/**
 * @author : 孙留平
 * @since : 2018年11月15日 下午7:26:47
 * @see:
 */
package com.tianque.mock.server.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : Administrator
 * @since : 2018年11月15日 下午7:26:47
 * @see :
 */
@Controller
@RequestMapping("/mockTest")
public class MockTestController {
    @ResponseBody
    @PostMapping("/mockTest")
    public String mockTest() {
        return null;
    }
}
