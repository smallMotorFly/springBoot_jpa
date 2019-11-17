package com.zhangbin.org.jpadetail.Controller;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.zhangbin.org.jpadetail.Base.Inquirer;
import com.zhangbin.org.jpadetail.Entity.GoodEntity;
import com.zhangbin.org.jpadetail.Entity.QGoodEntity;
import com.zhangbin.org.jpadetail.Jpa.GoodJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : zhangbin
 * @version : 1.0.1
 * @date : Created in 2019/11/16 14:30
 * @description: DSL测试
 * @modified By:
 */
@RestController
public class QueryController {

    @Autowired
    private GoodJPA goodJPA;

    //注入
    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/query")
    public List<GoodEntity> list() {

        QGoodEntity qGoodEntity = QGoodEntity.goodEntity;
        JPAQuery<GoodEntity> jpaQuery = new JPAQuery<>(entityManager);
        return jpaQuery.select(qGoodEntity).from(qGoodEntity).where(qGoodEntity.id.eq(Long.valueOf("1"))).fetch();
    }

    @RequestMapping(value = "/join")
    public List<GoodEntity> join() {
        // 查询实体
        QGoodEntity goodEntity = QGoodEntity.goodEntity;
         // 查询条件
        BooleanExpression expression = goodEntity.type.id.eq(Long.valueOf("1"));
        //  执行查询
        Iterator<GoodEntity> iterator = goodJPA.findAll(expression).iterator();

        List<GoodEntity> goodEntities = new ArrayList<>();

        while (iterator.hasNext()) {
            goodEntities.add(iterator.next());
        }

        return  goodEntities;
    }

    /**
     * @description: jpa 整合 querySql完成查询
     * @author: zhangbin
     * @date: 2019/11/16 16:10
     * @param
     * @return
     */
    @RequestMapping(value = "/check")
    public List<GoodEntity> check() {
        // querydsl 查询实体
        QGoodEntity goodEntity = QGoodEntity.goodEntity;
        // 自定义查询
        Inquirer inquirer = new Inquirer();
        // 添加查询条件
        inquirer.putExpression(goodEntity.type.id.eq(Long.valueOf("1")));
        // 返回查询结果
        return inquirer.iteratorToList(goodJPA.findAll(inquirer.buildQuery()));
    }

}

