package com.zhangbin.org.jpadetail.Base;

import java.io.Serializable;
import java.util.List;

/**
 * @author : zhangbin
 * @version : 1.0.0
 * @date : Created in 2019/11/14 00:29
 * @description: 基类entity
 * @modified By:
 */
public class BaseEntity<T> implements Serializable {
   /**
    * @author: zhangbin
    * @description: 分页页码默认1
    * @date: 2019/11/14 00:30
    * @param null
    * @return
    */
    protected int page = 1;
    /**
     * @author: zhangbin
     * @description: 分页每页数量默认20条
     * @date: 2019/11/14 00:31
     * @param null
     * @return
     */
    protected int size = 20;

    protected List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    /**
     * @author: zhangbin
     * @description: 排序列名默认为 id
     * @date: 2019/11/14 00:31
     * @param null
     * @return
     */
    protected String sidx = "id";
}
