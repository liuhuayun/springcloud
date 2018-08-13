package liuhy.springcloud.stream.message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

/*kafka发送对象消息
kafka 消息的key和value支持以下类型，但是不支持对象，为了让kafka发送的消息为对象类型，需要自定义对象的序列化和对象的反序列化。

org.apache.kafka.common.serialization.ByteArraySerializer
org.apache.kafka.common.serialization.ByteBufferSerializer
org.apache.kafka.common.serialization.BytesSerializer
org.apache.kafka.common.serialization.DoubleSerializer
org.apache.kafka.common.serialization.IntegerSerializer
org.apache.kafka.common.serialization.LongSerializer
org.apache.kafka.common.serialization.StringSerializer*/

/**
 * 对象序列化
 */
public class ObjectSerializer implements Serializer<Object> {
	public void configure(Map<String, ?> map, boolean b) {

	}

	public byte[] serialize(String topic, Object object) {
		byte[] bytes = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			byteArrayOutputStream = new ByteArrayOutputStream();
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(object);
			bytes = byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (byteArrayOutputStream != null) {
					byteArrayOutputStream.close();
				}
				if (objectOutputStream != null) {
					objectOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bytes;
	}

	public void close() {

	}
}