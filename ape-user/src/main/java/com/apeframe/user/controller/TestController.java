package com.apeframe.user.controller;

import com.apeframe.common.web.bean.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/local-cache")
    public Result localCache() {

        return Result.ok();
    }
}
