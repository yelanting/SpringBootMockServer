/**
 * @author : 孙留平
 * @since : 2018年11月14日 下午5:30:58
 * @see:
 */
package com.tianque.mock.server.service;

import com.tianque.mock.server.domain.MockParamDTO;

/**
 * @author : Administrator
 * @since : 2018年11月14日 下午5:30:58
 * @see :
 */
public interface MockServerService {
    String mock();

    String mockPost(MockParamDTO mockParamDTO);

    String mockGet(MockParamDTO mockParamDTO);

    String mockPut(MockParamDTO mockParamDTO);

    String mockDelete(MockParamDTO mockParamDTO);

    String mockPatch(MockParamDTO mockParamDTO);

    String mockHead(MockParamDTO mockParamDTO);

    String mockOptions(MockParamDTO mockParamDTO);

    String mockTrace(MockParamDTO mockParamDTO);
}
