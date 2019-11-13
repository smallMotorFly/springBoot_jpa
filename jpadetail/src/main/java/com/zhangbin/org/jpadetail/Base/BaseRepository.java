package com.zhangbin.org.jpadetail.Base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author: zhangbin
 * @description: 基类接口
 * @date: 2019/11/14 00:28
 * @param
 * @return
 */
@NoRepositoryBean
public interface BaseRepository <T,PK extends Serializable> extends JpaRepository<T,PK> {
}
