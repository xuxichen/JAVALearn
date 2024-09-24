package com.jedis.service;

import com.jedis.domain.Province;

import java.util.List;

public interface ProvinceService {

    abstract public List<Province> finAll();

    /**
     * 使用redis缓存
     * @return
     */
    abstract public String finAllJson();

}
