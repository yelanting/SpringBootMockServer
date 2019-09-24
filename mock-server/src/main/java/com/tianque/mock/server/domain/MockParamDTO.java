/**
 * @author : 孙留平
 * @since : 2018年11月14日 下午8:41:12
 * @see:
 */
package com.tianque.mock.server.domain;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : Administrator
 * @since : 2018年11月14日 下午8:41:12
 * @see :
 */
public class MockParamDTO {
    private RequestMethod requestMethod = RequestMethod.POST;
    private String url;
    private String requestParams;
    private String expectedResponse;

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExpectedResponse() {
        return expectedResponse;
    }

    public void setExpectedResponse(String expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MockParamDTO [requestMethod=" + requestMethod + ", url=" + url + ", requestParams=" + requestParams
                + ", expectedResponse=" + expectedResponse + "]";
    }
}
