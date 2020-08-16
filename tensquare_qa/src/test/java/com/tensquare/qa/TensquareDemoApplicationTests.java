package com.tensquare.qa;

import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.pojo.Problem;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = QaApplication.class)
public class TensquareDemoApplicationTests {
    @Autowired
    ProblemDao problemDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void  list(){
        List<Problem> all = problemDao.findAll();
        System.out.println(all);
    }

    @Test
    public void exampleTest(){
        Problem problem = new Problem();
        problem.setContent("jdk无效？");
        Example<Problem> problemExample = Example.of(problem);
        List<Problem> all = problemDao.findAll(problemExample);
        Assert.assertNotNull(all);
    }

    @Test
    public  void  find(){

        Problem problem = new Problem();
        problem.setContent("cmd");
        ExampleMatcher content = ExampleMatcher.matching().withMatcher("content", ExampleMatcher.GenericPropertyMatchers.contains());
        //创建匹配器，即如何使用查询条件
        Example<Problem> problemExample = Example.of(problem, content);
        List<Problem> all = problemDao.findAll(problemExample);
        System.out.println(all);
    }

}
