package com.tensquare.demo.controller;

import com.tensquare.demo.feignService.RecruitClient;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class RecruitController {
    @Autowired
    private RecruitClient recruitClient;

    @RequestMapping("getAllRecruit")
    public Result list() {
        return recruitClient.findAll();
    }

    @RequestMapping("getById/{id}")
    public Result getById(@PathVariable String id) {
        return recruitClient.findById(id);
    }
}
