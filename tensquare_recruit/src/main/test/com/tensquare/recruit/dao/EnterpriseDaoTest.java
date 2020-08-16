package com.tensquare.recruit.dao;

import com.tensquare.recruit.RecruitApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RecruitApplication.class)
public class EnterpriseDaoTest {
    @Autowired
    private RecruitDao recruitDao;
    @Test
    public  void selectDemo(){
        recruitDao.findTop2ByStateOrderByCreatetimeDesc("1").forEach(System.out::println);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}