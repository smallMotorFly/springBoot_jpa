package com.zhangbin.org.jpadetail.Jpa;

import com.zhangbin.org.jpadetail.Base.BaseRepository;
import com.zhangbin.org.jpadetail.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserJPA extends BaseRepository<UserEntity,Long> {

    /**
     * @author: zhangbin
     * @description: 自定义sql查询 nativeQuery = true 表明了使用原生的sql
     * @date: 2019/11/14 00:04
     * @param age:年龄
     * @return
     */
    @Query(value = "select *from t_user where t_age > ?1", nativeQuery = true)
    public List<UserEntity> nativeQuery(int age);

    /**
     * @author: zhangbin
     * @description: 自定义sql删除
     * @date: 2019/11/14 00:13
     * @param name:名字, pwd:密码
     * @return
     */

    @Modifying
    @Query(value = "delete from t_user where t_name = ?1 ", nativeQuery = true)
    public void deleteQuery(String name);
}
