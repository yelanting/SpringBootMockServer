/**
 * @author : 孙留平
 * @since : 2018年11月15日 上午10:40:27
 * @see:
 */
package com.tianque.mock.server.util;

import org.mockserver.client.MockServerClient;

import com.tianque.mock.server.config.GlobalConfig;

/**
 * @author : Administrator
 * @since : 2018年11月15日 上午10:40:27
 * @see :
 */
public class MockServerUtil {
    public static MockServerClient getDefaultMockServerClient() {
        return new MockServerClient(GlobalConfig.MOCK_SERVER_LOCALHOST, GlobalConfig.MOCK_SERVER_GLOBAL_PORT);
    }

}
