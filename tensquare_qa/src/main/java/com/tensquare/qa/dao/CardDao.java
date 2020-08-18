package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CardDao extends JpaRepository<Card,Integer>, JpaSpecificationExecutor<Card> {
}
