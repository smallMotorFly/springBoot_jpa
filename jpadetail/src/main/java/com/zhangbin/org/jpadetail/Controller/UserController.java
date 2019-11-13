package com.zhangbin.org.jpadetail.Controller;

import com.zhangbin.org.jpadetail.Base.BaseEntity;
import com.zhangbin.org.jpadetail.Entity.UserEntity;
import com.zhangbin.org.jpadetail.Jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : zhangbin
 * @version : 1.0.0
 * @date : Created in 2019/11/13 11:19 下午
 * @description: test
 * @modified By:
 */
@RestController
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/list")
    public List<UserEntity> list() {

        return userJPA.findAll();
    }

    /**
     * @author: zhangbin
     * @description: 添加数据
     * @date: 2019/11/13 23:56
     * @param
     * @return
     */
    @RequestMapping(value = "/add")
    public String add() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("name add");
        userEntity.setAddress("address add");
        userEntity.setAge(21);
        userJPA.save(userEntity);
        return "用户信息保存成功";
    }
    /**
     * @author: zhangbin
     * @description: 删除
     * @date: 2019/11/14 00:01
     * @param userId:用户id
     * @return
     */
    @RequestMapping(value = "/delete")
    public String delete(Long userId) {
        userJPA.deleteById(userId);
        return "用户信息删除成功";
    }

    /**
     * @author: zhangbin
     * @description: 使用自定义sql查询
     * @date: 2019/11/14 00:07
     * @param
     * @return
     */
    @RequestMapping(value = "/age")
    public  List<UserEntity> age() {
        return userJPA.nativeQuery(20);
    }

    /**
     * @author: zhangbin
     * @description:自定义sql删除
     * @date: 2019/11/14 00:15
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteWhere")
    public String deleteWhere() {
        userJPA.deleteQuery("admin");
        return "自定义sql删除数据成功";
    }
    /**
     * @author: zhangbin
     * @description: 分页查询
     * @date: 2019/11/14 00:39
     * @param
     * @return
     */
    @RequestMapping(value = "/listpage")
    public BaseEntity<UserEntity> cutPage(int page) {
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setSize(2);
        baseEntity.setPage(page);

        //获取排序对象
        Sort.Direction sort_d = Sort.Direction.ASC.toString().equalsIgnoreCase(baseEntity.getSidx()) ? Sort.Direction.ASC : Sort.Direction.DESC;
        // 注意：sidx 这里的排序字段不是数据库内的字段名而是实体内的属性名
        Sort sort = new Sort(sort_d, baseEntity.getSidx());

        // 创建分页
        PageRequest pageRequest = new PageRequest(baseEntity.getPage() - 1, baseEntity.getSize(),sort);
        //执行分页查询
        List<UserEntity> list = userJPA.findAll(pageRequest).getContent();
        baseEntity.setData(list);
        return baseEntity;
    }
}
