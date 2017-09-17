package com.hzit.hzitshop.service;



public interface BaseService<T> {
    int insert(T t);
    int delete(Integer id);
    int update(T t);
    T selectOne(int id);
}
