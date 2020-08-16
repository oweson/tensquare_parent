package com.tensquare.demo.hystrix;

import com.tensquare.demo.feignService.RecruitClient;
import entity.Result;
import org.springframework.stereotype.Component;

@Component
public class FailCall implements RecruitClient {
    @Override
    public Result findAll() {
        return new Result(false, 500, "远程服务不可用", null);
    }

    @Override
    public Result findById(String id) {
        return new Result(false, 500, "根据id进行查找不可用！！！", null);
    }
}
