package com.vo;

import com.pojo.Items;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public class PageVo {
    private Integer pageNow;//当前页
    private Integer myPage;//总页数
    private String query; //查询条件
    private Integer begin;//每一页起始值
    private List<Items> items;//每页记录

    @Override
    public String toString() {
        return "PageVo{" +
                "pageNow=" + pageNow +
                ", myPage=" + myPage +
                ", query='" + query + '\'' +
                ", begin=" + begin +
                ", items=" + items +
                '}';
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getMyPage() {
        return myPage;
    }

    public void setMyPage(Integer myPage) {
        this.myPage = myPage;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
