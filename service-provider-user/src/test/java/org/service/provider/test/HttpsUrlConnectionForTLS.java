package org.service.provider.test;

import javax.net.ssl.HttpsURLConnection;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;


public class HttpsUrlConnectionForTLS {

    public HttpURLConnection createConnection(URI uri) throws IOException {
        URL url = uri.toURL();
        URLConnection connection = url.openConnection();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) connection;
        httpsURLConnection.setSSLSocketFactory(new TLSSocketConnectionFactory());
        return httpsURLConnection;
    }

    public static void main(String[] args) {
        HttpsUrlConnectionForTLS httpsUrlConnectionMessageSender = new HttpsUrlConnectionForTLS();
        String loginUrl = "https://apigw.gongpingjia.com/api/vehicle-archive/";
        String data = "username=xiaomi&password=Ultrasafe_123";
        HttpURLConnection connection;
        try {
            connection = httpsUrlConnectionMessageSender.createConnection(new URI(loginUrl ));
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            connection.connect();
            //POST请求
            OutputStreamWriter os = null;
            String json="";
            os = new OutputStreamWriter(connection.getOutputStream());
            os.write(data);
            os.flush();
            json=getResponse(connection);
            System.out.println(json);


             if (connection != null) {
                    connection.disconnect();
                }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getResponse(HttpURLConnection Conn) throws IOException {


        InputStream is;
        if (Conn.getResponseCode() >= 400) {
            is = Conn.getErrorStream();
        } else {
            is = Conn.getInputStream();
        }


        String response = "";
        byte buff[] = new byte[512];
        int b = 0;
        while ((b = is.read(buff, 0, buff.length)) != -1) {
            response += new String(buff, 0, b);

        }
        is.close();

        System.out.println(response);
        return response;
    }
}