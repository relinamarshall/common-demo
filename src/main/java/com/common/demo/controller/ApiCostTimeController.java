package com.common.demo.controller;

import com.common.core.util.R;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiCostTimeController
 *
 * @author Wenzhou
 * @since 2023/7/14 15:54
 */
@RestController
@RequestMapping("/test")
public class ApiCostTimeController {
    @PostMapping("/cost-time")
    public R<String> testCostTime() {
        return R.ok("ok");
    }
}
