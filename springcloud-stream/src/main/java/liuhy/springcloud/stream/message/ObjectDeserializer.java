package liuhy.springcloud.stream.message;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

/**
 * 对象反序列化
 */
public class ObjectDeserializer implements Deserializer<Object> {
	public void configure(Map<String, ?> map, boolean b) {

	}

	public Object deserialize(String topic, byte[] bytes) {
		Object object = null;
		ByteArrayInputStream byteArrayInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			byteArrayInputStream = new ByteArrayInputStream(bytes);
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
			object = objectInputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (byteArrayInputStream != null) {
					byteArrayInputStream.close();
				}
				if (objectInputStream != null) {
					objectInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return object;
	}

	public void close() {

	}
}