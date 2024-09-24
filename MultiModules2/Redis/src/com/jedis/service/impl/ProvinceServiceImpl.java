package com.jedis.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jedis.dao.ProvinceDao;
import com.jedis.dao.impl.ProvinceDaoImpl;
import com.jedis.domain.Province;
import com.jedis.service.ProvinceService;
import com.jedis.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao provinceDao = new ProvinceDaoImpl();
    @Override
    public List<Province> finAll() {
        return provinceDao.finAll();
    }

    @Override
    public String finAllJson() {
        // 1、先从redis中查询数据
        // 1.1、获取redis客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province = jedis.get("province");
        if (province == null || province.length()==0) {
            List<Province> provinces = this.finAll();

            // 2、序列化list为json
            ObjectMapper mapper = new ObjectMapper();
            String json = null;
            try {
                json = mapper.writeValueAsString(provinces);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            jedis.set("province", json);
            jedis.close();
            return json;
        }
        return province;
    }
}
