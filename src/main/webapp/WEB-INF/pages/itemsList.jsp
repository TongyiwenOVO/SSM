<%--
  Created by IntelliJ IDEA.
  User: 10101
  Date: 2020/7/15
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>商品列表</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/index.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/items.js"></script>
</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 100px">
        <div class="col-md-6 col-lg-6">
            <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button" onclick="queryByName('${pageContext.request.contextPath}')">查找</button>
                    </span>
                <input type="text" class="form-control" placeholder="Search by name" id="searchName" value="${vo.query}">
            </div>
        </div>
        <div class="col-md-4 col-lg-4">
            <a href="addItem.jsp" class="btn btn-success">添加商品</a>
            <input class="btn btn-danger" type="button" value="删除所有" onclick="deleteAll()">
        </div>
    </div>
    <div class="row" style="margin-top: 50px">
        <table class="table table-bordered">
            <tr align="center">
                <th style="text-align:center"><input type="checkbox" class="choose_all"></th>
                <th style="text-align:center">商品编号</th>
                <th style="text-align:center">商品名称</th>
                <th style="text-align:center">商品描述</th>
                <th style="text-align:center">商品价格</th>
                <th style="text-align:center">生产日期</th>
                <th style="text-align:center">商品图片</th>
                <th style="text-align:center">操作</th>
            </tr>
            <c:forEach items="${vo.items}" var="item">
                <tr class="data" align="center">
                    <td class="datachoose"><input type="checkbox" class="single"></td>
                    <td class="id">${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.detail}</td>
                    <td>${item.price}</td>
                    <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd"/></td>
                    <td>
                        <c:if test="${item.pic!=null && item.pic!=''}">
                            <img src="${item.pic}" width="64px" height="auto"/>
                        </c:if>
                    </td>
                    <td>
                        <a href="findOne?id=${item.id}" class="btn btn-info" >修改</a>|
                        <a href="delete?id=${item.id}" class="btn btn-danger">删除</a>
                    </td>
                </tr>
            </c:forEach>
            <tr align="center">
                <td colspan="8">
                    <input class="btn btn-success" type="button" value="首页"
                           onclick="firstPage('${pageContext.request.contextPath}')"/>&nbsp;&nbsp;
                    <input class="btn btn-success" type="button" id="pre" value="上一页"
                           onclick="prePage('${pageContext.request.contextPath}',${vo.myPage})"/>&nbsp;&nbsp;
                    <!--当前页-->
                    <input type="text" id="pageNow" value="${vo.pageNow}" style="text-align:center"/>&nbsp;&nbsp;
                    <input class="btn btn-success" type="button" value="跳转"
                           onclick="skipPage('${pageContext.request.contextPath}',${vo.myPage})"/>&nbsp;&nbsp;
                    <input class="btn btn-success" type="button" id="next" value="下一页"
                           onclick="nextPage('${pageContext.request.contextPath}',${vo.myPage})"/>&nbsp;&nbsp;
                    <input class="btn btn-success" type="button" value="末页"
                           onclick="lastPage('${pageContext.request.contextPath}',${vo.myPage})"/>&nbsp;&nbsp;
                </td>
            </tr>
        </table>
    </div>
</div>

</body>
<script>
    function deleteAll() {
        var str="";
        $(".single").each(function () {
            if ($(this).prop("checked")){
                var text=$(this).parents(".data").find(".id").text();
                str=str+"id="+text+"&";
            }
        });
        str=str.substr(0,str.length-1);
        window.location.href="delete?"+str;
    }
</script>

</html>
