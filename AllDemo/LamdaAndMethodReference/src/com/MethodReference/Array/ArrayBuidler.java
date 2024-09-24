package com.MethodReference.Array;

/**
 * 定义一个创建数组的函数式接口
 */

public interface ArrayBuidler {
    // 定义一个创建int类型数组的方法，参数传递数组的长度，返回创建的int数组
    int[] builderArray(int length);
}
