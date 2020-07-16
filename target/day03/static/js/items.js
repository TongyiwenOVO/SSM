
//通过商品名称进行模糊查询
function queryByName(url){
    //获得搜索框的值
    var query = $("#searchName").val();
    //跳转到action，进行查询
    window.location.href="findAll?query="+query;
}

//分页查询
//首页
function firstPage(url) {
    //获得搜索框的值
    var query = $("#searchName").val();
    //获得当前页码
    var pageNow = $("#pageNow").val();
    //设置当前页
    pageNow = 1;
    //跳转
    window.location.href="findAll?query="+query+"&pageNow="+pageNow;
}

//末页
function lastPage(url,myPage){
    //获得搜索框的值
    var query = $("#searchName").val();
    //获得当前页码
    var pageNow = $("#pageNow").val();
    //设置当前页
    pageNow = myPage;
    //跳转
    window.location.href="findAll?query="+query+"&pageNow="+pageNow;
}


//上一页
function prePage(url,myPage) {
    //获得搜索框的值
    var query = $("#searchName").val();
    //获得当前页码
    var pageNow = $("#pageNow").val();
    //设置当前页
    if(pageNow>1 && pageNow<=myPage){
        if(pageNow>1){
            pageNow = pageNow - 1;
        }else{
            alert("已至首页！");
            pageNow = 1;
        }
    }else{
        alert("超出当前页数范围！");
        pageNow = 1;
    }
    //跳转
    window.location.href="findAll?query="+query+"&pageNow="+pageNow;
}


//下一页
function nextPage(url,myPage) {
    //获得搜索框的值
    var query = $("#searchName").val();
    //获得当前页码
    var pageNow = $("#pageNow").val();
    //设置当前页
    if(pageNow>=1 && pageNow<=myPage){
        if(pageNow<myPage){
            pageNow = pageNow - (-1);
        }else if(pageNow==myPage){
            alert("已至末页！");
            pageNow = myPage;
        }
    }else{
        alert("超出当前页数范围！");
        pageNow = 1;
    }
    //跳转
    window.location.href="findAll?query="+query+"&pageNow="+pageNow;
}


//跳转
function skipPage(url,myPage) {
    //获得搜索框的值
    var query = $("#searchName").val();
    //获得当前页码
    var pageNow = $("#pageNow").val();
    //设置当前页}
    if(pageNow<1 || pageNow>myPage){
        alert("超出当前页数范围！");
        pageNow=1;
    }
    //跳转
    window.location.href="findAll?query="+query+"&pageNow="+pageNow;
}

function deleteAll() {
    var str="";
    $(".single").each(function () {
        if ($(this).prop("checked")){
            var text=$(this).parents(".data").find(".id").text();
            str=str+text+"-";
        }
    });
    str=str.substr(0,str.length-1);
    window.location.href="delete/"+str;
}