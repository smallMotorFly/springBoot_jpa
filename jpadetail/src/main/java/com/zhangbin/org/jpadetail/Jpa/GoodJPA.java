package com.zhangbin.org.jpadetail.Jpa;

import com.zhangbin.org.jpadetail.Entity.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GoodJPA extends JpaRepository<GoodEntity,Long>, QuerydslPredicateExecutor<GoodEntity> {
}
