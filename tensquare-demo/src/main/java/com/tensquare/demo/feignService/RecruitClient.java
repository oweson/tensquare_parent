package com.tensquare.demo.feignService;

import com.tensquare.demo.hystrix.FailCall;
import entity.Result;
import entity.StatusCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "tensquare-recruit", fallback = FailCall.class)
public interface RecruitClient {
    @RequestMapping(value = "/recruit/", method = RequestMethod.GET)
    public Result findAll();

    @RequestMapping("/recruit/{id}")
    public Result findById(@PathVariable String id);

}
