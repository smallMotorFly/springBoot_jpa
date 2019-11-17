package com.zhangbin.org.jpadetail.Entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : zhangbin
 * @version : 1.0.1
 * @date : Created in 2019/11/16 14:15
 * @description: 商品信息
 * @modified By:
 */
@Entity
@Table(name = "t_message")
public class GoodEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_title")
    private  String title;

    @Column(name = "t_price")
    private  double price;

    @Column(name = "t_unit")
    private  String unit;

    @Column(name = "t_order")
    private int order;

    @OneToOne
    @JoinColumn(name = "t_type_id")
    private  GoodTypeEntity type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public GoodTypeEntity getType() {
        return type;
    }

    public void setType(GoodTypeEntity type) {
        this.type = type;
    }
}
