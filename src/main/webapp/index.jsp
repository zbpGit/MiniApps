
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" value="${pageContext.request.contextPath}"></c:set>
<c:set var="basePath" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${base}"></c:set>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${basePath}/js/global.js"></script>
</head>
<body>
<div ><h1>hahahaha</h1></div>

<form method="post" action="/topic/submit" >
    <input onblur="checkTitle()" id="i1" type="text" name="li" style="width:200px" >
    <input type="submit">
</form>
</body>
<script>
    var json = [{'sid':1,'response_answer':2},{'sid':2,'response_answer':3},{'sid':4,'response_answer':5}];
    var jsonStr = JSON.stringify(json);
    function checkTitle(){
        $.ajax({
            url:'http://admin.qingmeng168.com:8081/RedPage/topic/submit',
            type:'POST',
            data:{"li":jsonStr,"id":9999},
            traditional:true,
            success:function(data){
                alert(data)
            }
        })
    }
</script>
</html>
