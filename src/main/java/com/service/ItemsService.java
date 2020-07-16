package com.service;

import com.pojo.Items;
import com.vo.PageVo;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

public interface ItemsService {
    PageVo findAll(String query, Integer pageNow);

    void add(Items items);

    void update(Items items);

   void delete(Integer[] ids);
    Items findOne(Integer id);
}
