/**
 * @author : 孙留平
 * @since : 2018年11月14日 下午5:29:58
 * @see:
 */
package com.tianque.mock.server.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianque.mock.server.controller.MockServerController;
import com.tianque.mock.server.domain.MockParamDTO;
import com.tianque.mock.server.service.MockServerService;
import com.tianque.mock.server.vo.ResponseData;

import net.sf.json.JSONObject;

/**
 * @author : Administrator
 * @since : 2018年11月14日 下午5:29:58
 * @see :
 */
@Controller
@RequestMapping("/mockServer")
public class MockServerControllerImpl implements MockServerController {
    @Autowired
    private MockServerService mockServerService;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.adminstrator.platform.controller.MockServerController#mock(com.adminstrator.platform.domain.MockParamDTO)
     */
    @Override
    @PostMapping("/mock")
    @ResponseBody
    public ResponseData mockPost(MockParamDTO mockParamDTO) {

        ResponseData responseData = new ResponseData();

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("details", JSONObject.fromObject(mockParamDTO));
        jsonObject.put("response", mockServerService.mockPost(mockParamDTO));
        responseData.setData(jsonObject);
        return responseData;
    }

    // @Override
    // @GetMapping("/mock")
    // public ResponseData mockGet(MockParamDTO mockParamDTO) {
    // // mockServerService.mockGet(mockParamDTO);
    // // return null;
    // ResponseData responseData = new ResponseData();
    // responseData.setData(mockServerService.mockPost(mockParamDTO));
    // return responseData;
    // }
    //
    // /*
    // * (non-Javadoc)
    // *
    // * @see com.adminstrator.platform.controller.MockServerController#mockDelete(com.adminstrator.platform.domain.
    // * MockParamDTO)
    // */
    // @Override
    // public ResponseData mockDelete(MockParamDTO mockParamDTO) {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // /*
    // * (non-Javadoc)
    // *
    // * @see com.adminstrator.platform.controller.MockServerController#mockPatch(com.adminstrator.platform.domain.
    // * MockParamDTO)
    // */
    // @Override
    // public ResponseData mockPatch(MockParamDTO mockParamDTO) {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // /*
    // * (non-Javadoc)
    // *
    // * @see com.adminstrator.platform.controller.MockServerController#mockTrace(com.adminstrator.platform.domain.
    // * MockParamDTO)
    // */
    // @Override
    // public ResponseData mockTrace(MockParamDTO mockParamDTO) {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // /*
    // * (non-Javadoc)
    // *
    // * @see
    // *
    // com.adminstrator.platform.controller.MockServerController#mockHead(com.adminstrator.platform.domain.MockParamDTO)
    // */
    // @Override
    // public ResponseData mockHead(MockParamDTO mockParamDTO) {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // /*
    // * (non-Javadoc)
    // *
    // * @see com.adminstrator.platform.controller.MockServerController#mockOptions(com.adminstrator.platform.domain.
    // * MockParamDTO)
    // */
    // @Override
    // public ResponseData mockOptions(MockParamDTO mockParamDTO) {
    // // TODO Auto-generated method stub
    // return null;
    // }
    //
    // /*
    // * (non-Javadoc)
    // *
    // * @see
    // * com.adminstrator.platform.controller.MockServerController#mock(com.adminstrator.platform.domain.MockParamDTO)
    // */
    // @Override
    // public ResponseData mock(MockParamDTO mockParamDTO) {
    // // TODO Auto-generated method stub
    // return null;
    // }

}
