/**
 * @author : 孙留平
 * @since : 2018年11月15日 上午11:11:22
 * @see:
 */
package com.tianque.mock.server.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.tianque.mock.server.config.GlobalConfig;
import com.tianque.mock.server.domain.MockParamDTO;

/**
 * @author : Administrator
 * @since : 2018年11月15日 上午11:11:22
 * @see :
 */
public class HttpClientUtil {
    private static CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

    public static String doPost(MockParamDTO mockParamDTO) {
        String actionUrl = GlobalConfig.WHOLE_MOCK_SERVER_ADDRESS + mockParamDTO.getUrl();
        HttpPost httpPost = new HttpPost(actionUrl);
        httpPost.addHeader("Accept", "text/plain");
        try {
            httpPost.setEntity(new StringEntity(mockParamDTO.getRequestParams()));
            CloseableHttpResponse response = closeableHttpClient.execute(httpPost);
            // 验证输出是否是正确
            InputStream content = response.getEntity().getContent();
            InputStreamReader inputStreamReader = new InputStreamReader(content);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            return bufferedReader.readLine();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
