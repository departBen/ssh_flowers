package com.bs.flower.utils;

import com.bs.flower.entity.OrdersDetails;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 购物车类
 * Created by ben on 2017/4/8.
 */
public class ShoppingCart {

    private Map<Integer,OrdersDetails> detailsMap;


    public ShoppingCart() {
        if (detailsMap == null){
            detailsMap = new HashMap<>();
        }
    }

    //添加鲜花
    public void addFlower(int flowerId,OrdersDetails ordersDetails){
        if (detailsMap.containsKey(flowerId)){
            OrdersDetails details = detailsMap.get(flowerId);
            ordersDetails.setNum(details.getNum() + ordersDetails.getNum());
            detailsMap.put(flowerId,ordersDetails);
        } else {
            detailsMap.put(flowerId,ordersDetails);
        }
    }

    //更新购物车
    public void updateCart(int flowerId,int num){
        OrdersDetails ordersDetails = detailsMap.get(flowerId);
        ordersDetails.setNum(num);
        detailsMap.put(flowerId,ordersDetails);
    }

    //计算总价
    public double getGross(){
        double gross = 0;
        for (Iterator iterator = detailsMap.values().iterator();iterator.hasNext();){
            OrdersDetails ordersDetails = (OrdersDetails) iterator.next();
            gross += ordersDetails.getNum() * ordersDetails.getPrice();
        }
        return gross;
    }



    public Map<Integer, OrdersDetails> getDetailsMap() {
        return detailsMap;
    }

    public void setDetailsMap(Map<Integer, OrdersDetails> detailsMap) {
        this.detailsMap = detailsMap;
    }
}
