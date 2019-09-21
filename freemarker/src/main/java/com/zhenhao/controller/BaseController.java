package com.zhenhao.controller;

import com.github.pagehelper.Page;
import org.apache.commons.lang3.math.NumberUtils;

import javax.servlet.http.HttpServletRequest;

public class BaseController  {

    public Page newPage(HttpServletRequest request){
        return newPage(request,"id","desc");
    }

    public Page newPage(HttpServletRequest request,String defaultOrder,String defaultSort){
        String str_pageIndex = request.getParameter("pageIndex");
        int pageIndex = NumberUtils.toInt(str_pageIndex,1);
        String str_pageSize = request.getParameter("pageSize");
        int pageSize = NumberUtils.toInt(str_pageSize,10);
        Page page = new Page(pageIndex,pageSize);
        return page;

    }

}
