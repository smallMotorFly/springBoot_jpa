package com.zhangbin.org.jpadetail.Base;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : zhangbin
 * @version : 1.0.0
 * @date : Created in 2019/11/16 15:42
 * @description: 封装查询
 * @modified By:
 */
public class Inquirer {
    private List<BooleanExpression> expressions;

    public  Inquirer() {
        this.expressions = new ArrayList<>();
    }

    /**
     * @description: 添加查询条件到Query查询集合内
     * @author: zhangbin
     * @date: 2019/11/16 15:46
     * @param
     * @return
     */
    public Inquirer putExpression(BooleanExpression expression) {
        expressions.add(expression);
        return this;
    }

    public Predicate buildQuery() {
        BooleanExpression booleanExpression = null;

        for (int i = 0; i < expressions.size(); i++) {
            if (i == 0) {
                booleanExpression = expressions.get(i);
            } else {
                booleanExpression = booleanExpression.and(expressions.get(i));
            }
        }
        return booleanExpression;
    }

    /**
     * @description: 将Iterable集合转换成ArrayList集合
     * @author: zhangbin
     * @date: 2019/11/16 16:04
     * @param
     * @return
     */
    public <T> List<T> iteratorToList(Iterable<T> iterable) {
        List<T> returnList = new ArrayList<T>();
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            returnList.add(iterator.next());
        }
        return returnList;
    }



}
