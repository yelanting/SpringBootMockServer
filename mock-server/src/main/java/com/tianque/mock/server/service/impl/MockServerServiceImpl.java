/**
 * @author : 孙留平
 * @since : 2018年11月14日 下午5:31:18
 * @see:
 */
package com.tianque.mock.server.service.impl;

import org.junit.Rule;
import org.mockserver.junit.MockServerRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tianque.mock.server.domain.MockParamDTO;
import com.tianque.mock.server.service.MockServerService;

/**
 * @author : Administrator
 * @since : 2018年11月14日 下午5:31:18
 * @see :
 */
@Service
public class MockServerServiceImpl implements MockServerService {
    private static Logger logger = LoggerFactory.getLogger(MockServerServiceImpl.class);

    @Rule
    public static MockServerRule serverRule = new MockServerRule(MockServerServiceImpl.class, 5000);

    /*
     * (non-Javadoc)
     * 
     * @see com.adminstrator.platform.service.MockServerService#mock()
     */
    @Override
    public String mockPost(MockParamDTO mockParamDTO) {
        logger.info("正在模拟post请求,请求参数:{}", mockParamDTO);
        // mockParamDTO.setRequestMethod(RequestMethod.POST);
        // MockServerClient mockServerClient = MockServerUtil.getDefaultMockServerClient();
        // mockServerClient.when(request().withPath(GlobalConfig.MOCK_TESTURL).withMethod(RequestMethod.POST.toString()))
        // .respond(HttpResponse.response().withStatusCode(200).withBody(mockParamDTO.getExpectedResponse()));
        //
        // String result = HttpClientUtil.doPost(mockParamDTO);
        // logger.debug("正在模拟post请求返回结果:{}", result);
        // return result;
        return mockParamDTO.getExpectedResponse();

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.adminstrator.platform.service.MockServerService#mock()
     */
    @Override
    public String mock() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.adminstrator.platform.service.MockServerService#mockGet(com.adminstrator.platform.domain.MockParamDTO)
     */
    @Override
    public String mockGet(MockParamDTO mockParamDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.adminstrator.platform.service.MockServerService#mockPut(com.adminstrator.platform.domain.MockParamDTO)
     */
    @Override
    public String mockPut(MockParamDTO mockParamDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.adminstrator.platform.service.MockServerService#mockDelete(com.adminstrator.platform.domain.MockParamDTO)
     */
    @Override
    public String mockDelete(MockParamDTO mockParamDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.adminstrator.platform.service.MockServerService#mockPatch(com.adminstrator.platform.domain.MockParamDTO)
     */
    @Override
    public String mockPatch(MockParamDTO mockParamDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.adminstrator.platform.service.MockServerService#mockHead(com.adminstrator.platform.domain.MockParamDTO)
     */
    @Override
    public String mockHead(MockParamDTO mockParamDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.adminstrator.platform.service.MockServerService#mockOptions(com.adminstrator.platform.domain.MockParamDTO)
     */
    @Override
    public String mockOptions(MockParamDTO mockParamDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.adminstrator.platform.service.MockServerService#mockTrace(com.adminstrator.platform.domain.MockParamDTO)
     */
    @Override
    public String mockTrace(MockParamDTO mockParamDTO) {
        // TODO Auto-generated method stub
        return null;
    }

}
