package com.tensquare.qa;

import com.tensquare.qa.dao.CardDao;
import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.pojo.Card;
import com.tensquare.qa.pojo.Problem;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = QaApplication.class)
public class TensquareDemoApplicationTests {
    @Autowired
    ProblemDao problemDao;
    @Autowired
    CardDao cardDao;

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

    @Test
    public  void save(){
        ArrayList<Card> cards = Lists.newArrayList();
        for (int i = 0; i < 20; i++) {
            Card card = new Card();
            card.setCoed("985");
            cards.add(card);



        }

        List<Card> list = cardDao.saveAll(cards);
        System.out.println(list);
    }

    @Test
    public void   query(){
        Specification<Card> specification = new Specification<Card>() {
            @Override
            public Predicate toPredicate(Root<Card> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
               return  criteriaBuilder.like(root.get("coed").as(String.class),"%985%");
            }
        };
        Sort sort = new Sort(Sort.Direction.ASC, "coed");
        Pageable pageable = new PageRequest(0,2,sort);
        Page<Card> cardPage = cardDao.findAll(specification, pageable);
        System.out.println(cardPage);
    }

}
