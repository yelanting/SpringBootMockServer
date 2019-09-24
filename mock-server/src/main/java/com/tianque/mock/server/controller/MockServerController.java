/**
 * @author : 孙留平
 * @since : 2018年11月14日 下午5:29:21
 * @see:
 */
package com.tianque.mock.server.controller;

import com.tianque.mock.server.domain.MockParamDTO;
import com.tianque.mock.server.vo.ResponseData;

/**
 * @author : Administrator
 * @since : 2018年11月14日 下午5:29:21
 * @see :
 */
public interface MockServerController {
    ResponseData mockPost(MockParamDTO mockParamDTO);

    // ResponseData mockGet(MockParamDTO mockParamDTO);
    //
    // ResponseData mockDelete(MockParamDTO mockParamDTO);
    //
    // ResponseData mockPatch(MockParamDTO mockParamDTO);
    //
    // ResponseData mockTrace(MockParamDTO mockParamDTO);
    //
    // ResponseData mockHead(MockParamDTO mockParamDTO);
    //
    // ResponseData mockOptions(MockParamDTO mockParamDTO);
    //
    // ResponseData mock(MockParamDTO mockParamDTO);
}