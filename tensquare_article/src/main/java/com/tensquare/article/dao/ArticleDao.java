package com.tensquare.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface ArticleDao extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {
    /**
     * 1 文章审核
     *
     * @param id
     */
    @Modifying
    @Query(value = "UPDATE tb_article SET state=1 WHERE id=?1", nativeQuery = true)
    public int updateState(String id);


    /**
     * 2 文章点赞
     * 坑：当时从pdf中将sql复制出来导致无法执行成功，但是控制台不提示错误，所以最好自己写
     * @Query有nativeQuery=true，表示可执行的原生sql，原生sql指可以直接复制sql语句给参数赋值就能运行
     * @Query无nativeQuery=true， 表示不是原生sql，查询语句中的表名则是对应的项目中实体类的类名
     *
     * @param id
     */
    @Modifying
    @Query(value = "UPDATE tb_article SET thumbup=thumbup+1 WHERE id=?1", nativeQuery = true)
    public int addThumbup(String id);
}
