package com.service.impl;

import com.mapper.ItemsMapper;
import com.pojo.Items;
import com.pojo.ItemsExample;
import com.service.ItemsService;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    ItemsMapper itemsMapper;
    @Override
    @Transactional
    public PageVo findAll(String query, Integer pageNow) {
        if (query==null){
            query="";
        }
        if (pageNow==null){
            pageNow=1;
        }

        ItemsExample example=new ItemsExample();
        ItemsExample.Criteria criteria=example.createCriteria();
        criteria.andNameLike("%"+query+"%");
        Integer begin=(pageNow-1)*3;
        example.setBegin(begin);
        List<Items> items= itemsMapper.selectByExampleWithBLOBs(example);
        Integer mycount= itemsMapper.countByExample(example);
        Integer myPages=(Integer)(mycount%3==0?mycount/3:mycount/3+1);

        PageVo pageVo=new PageVo();
        pageVo.setBegin(begin);
        pageVo.setItems(items);
        pageVo.setMyPage(myPages);
        pageVo.setQuery(query);
        pageVo.setPageNow(pageNow);
        return pageVo;
    }

    @Override
    public void add(Items items) {
        itemsMapper.insertSelective(items);
    }

    @Override
    public Items findOne(Integer id){
        Items items=itemsMapper.selectByPrimaryKey(id);
        return items;
    }
    @Override
    public void update(Items items) {
        itemsMapper.updateByPrimaryKeySelective(items);
    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id:ids){
            itemsMapper.deleteByPrimaryKey(id);
        }
    }


}
