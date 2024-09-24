package com.Red;

import java.util.ArrayList;

public interface OpenMode {
    /**
     * 请将totalMoney分成count 份， 保存到ArrayList<Integer>中返回
     *
     * @param totalMoney            总金额为计算方便，已经转换成整数，单位为分
     * @param totalCount            红包个数
     * @return  ArrayList<Interger> 元素为各个红包的金额值，所有元素的值累和等于总金额；
     */
    ArrayList<Integer> divide(int totalMoney, int totalCount);
}
