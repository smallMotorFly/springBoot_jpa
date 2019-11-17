package com.zhangbin.org.jpadetail.Entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : zhangbin
 * @version : 1.0.1
 * @date : Created in 2019/11/16 14:15
 * @description: 商品分类信息
 * @modified By:
 */
@Entity
@Table(name = "t_type_message")
public class GoodTypeEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_is_show")
    private int isSow;

    @Column(name = "t_order")
    private int order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsSow() {
        return isSow;
    }

    public void setIsSow(int isSow) {
        this.isSow = isSow;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
