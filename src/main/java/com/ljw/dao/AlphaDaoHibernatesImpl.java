package com.ljw.dao;

import org.springframework.stereotype.Repository;

/**
 * @author lanjuwen
 * @create 2022-04-04  11:20
 */
@Repository("alphaHibernates") // 使用名字区分bean
public class AlphaDaoHibernatesImpl implements AlphaDao {
    @Override
    public String select() {
        return "hibernate";
    }
}
