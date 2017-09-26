
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" value="${pageContext.request.contextPath}"></c:set>
<c:set var="basePath" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${base}"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台管理中心 - 用户管理 </title>
    <meta name="Copyright" content="Douco Design." />
    <link href="${basePath}/css/public.css" rel="stylesheet" type="text/css">
    <script lang="javascript" type="text/javascript" src="${basePath}/js/day/WdatePicker.js"></script>
    <script type="text/javascript" src="${basePath}/js/jquery.min.js"></script>
    <%--<script type="text/javascript" src="${basePath}/js/jsAddresss.js"></script>--%>
    <script class="resources library" src="${basePath}/js/area.js" type="text/javascript"></script>
    <script type="text/javascript" src="${basePath}/js/global.js"></script>
</head>
<body>
<div id="dcWrap">
    <div id="dcHead">
        <div id="head">
            <div class="logo"><img width="115" height="25" src="${basePath}/IMG/top.jpg" alt="logo"></div>
            <div class="nav">

            </div>
        </div>
    </div>
    <!-- dcHead 结束 -->
    <div id="dcLeft"><div id="menu">
        <ul class="top">
            <li><a href="${basePath}/user/home.do"><i class="home"></i><em>管理首页</em></a></li>
        </ul>
        <ul>
            <li><a href="${basePath}/user/selectAll.do"><i class="productCat"></i><em>查找用户</em></a></li>
            <%--<li><a href="/ChatRobot/head/select.do"><i class="product"></i><em>用户头像</em></a></li>--%>
        </ul>
        <ul>
            <li class="cur"><a href="${basePath}/annunciate/selectone.do"><i class="articleCat"></i><em>通告管理</em></a></li>
            <li><a href="${basePath}/annunciate/addguan.do"><i class="articleCat"></i><em>添加官方通告</em></a></li>
            <li ><a href="${basePath}/addguanform/select.do"><i class="articleCat"></i><em>通告类型编辑</em></a></li>
            <li><a href="${basePath}/indent/select.do"><i class="article"></i><em>订单管理</em></a></li>
        </ul>
        <ul class="bot">
            <li ><a href="${basePath}/serve/select.do"><i class="backup"></i><em>服务编辑</em></a></li>
            <li ><a href="${basePath}/banner/select.do"><i class="backup"></i><em>Banner编辑</em></a></li>
            <li ><a href="${basePath}/reports/select.do"><i class="mobile"></i><em>举报管理</em></a></li>
        </ul>
    </div></div>
    <div id="dcMain">
        <!-- 当前位置 -->
        <div id="urHere">后台管理中心<b>></b><strong>通告管理</strong> </div>   <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <form action="${basePath}/annunciate/selectone.do" method="post">
            用户ID<input type="text" size="10" name="id" value="${id}" class="inpMain">
            通告主题<input type="text" name="theme" value="${theme}"  class="inpMain" />
            通告类型<select name="work_type">
                    <option value="${antype}">全部</option>
                    <c:forEach items="${itan}" var="it">
                    <option value="${it.antype}">${it.antype}</option>
                    </c:forEach>
                    </select>
            工作地区  <%--<select id="cmbProvince" name="cmbProvince"></select>
                       <select id="cmbCity" name="site"></select>
                        <select  id="cmbArea" name="cmbArea"></select>--%>
            <select id="s_province" name="province"></select>  
            <select id="s_city" name="site" ></select>  
            <%--<select id="s_county" name="cmbArea"></select>--%>
            开工日期 <input type="text" name="work_time" value="${work_time}" size="10" class="Wdate" onClick="WdatePicker()" />
            状态<select name="audit">
                <option value="">全部</option>
                <option value="0">待处理</option>
                <option value="1">已通过</option>
                <option value="2">已拒绝</option>
                </select>
            <input name="submit" class="btn" type="submit" value="查询" /><br>
        </form>
        <br>
        <br>
        <c:if test="${its.total!=count}">已为您筛选到&nbsp;&nbsp;<span style='font-weight: bold; color: #5858E6'>${its.total}</span>&nbsp;&nbsp;条记录</c:if>
        <c:if test="${its.total==count}"> 共有&nbsp;&nbsp;<span style='font-weight: bold; color: #5858E6'>${count}</span>&nbsp;&nbsp;条记录</c:if>

                   <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
                   <tr>

                       <th width="50" align="center">通告类型</th>
                       <th width="40" align="center">发布人id</th>
                       <th  width="80" align="center">发布人</th>
                       <th width="90" align="center">联系方式</th>
                       <th width="90" align="center">微信号</th>
                       <th width="100" align="center">工作地点</th>
                       <th width="80" align="center">开工时间</th>
                       <%--<th width="60" align="center">工作人数</th>--%>
                       <th width="40" align="center">性别</th>
                       <th width="80" align="center">详情</th>
                       <th width="70" align="center">报名截止时间</th>
                       <th width="70" align="center">申请时间</th>
                       <th width="70" align="center">处理时间</th>
                       <th width="50" align="center">状态</th>
                       <th width="70" align="center">操作</th>
                   </tr>
                   <c:forEach items="${items}" var="it">
                   <tr>

                       <th align="center">${it.work_type}</th>
                       <th align="center">${it.user.id}</th>
                       <th align="center">${it.user.wx_name}</th>
                       <th align="center">${it.user.phone}</th>
                       <th align="center">${it.user.wx_id}</th>
                       <th align="center">${it.workplace}</th>
                       <th align="center">${it.work_time}</th>
                       <%--<th  align="center">${it.number}</th>--%>
                       <th align="center">${it.asex}</th>
                       <th align="center">${it.theme}<br/><a  target="_blank" style="color: #0065B0" href="${basePath}/annunciate/selectAll.do?vid=${it.vid}">点击展开详情</a></th>
                       <th  align="center">${it.deadline}</th>
                       <th align="center">${it.an_time}</th>
                       <th align="center">${it.update_time}</th>
                       <th  align="center">
                           <c:if test="${it.audit==0}">待处理</c:if>
                           <c:if test="${it.audit==1}">已通过</c:if>
                           <c:if test="${it.audit==2}">已拒绝</c:if>
                       </th>
                       <th align="center"><a style=" color: #0065B0" href="${basePath}/annunciate/YES.do?vid=${it.vid}&p=${its.pageNum}&id=${id}&theme=${theme}&work_type=${antype}&work_time=${work_time}&site=${site}">通过</a> | <a style="color: #0065B0" href="${basePath}/annunciate/NO.do?vid=${it.vid}&p=${its.pageNum}&id=${id}&theme=${theme}&work_type=${antype}&work_time=${work_time}&site=${site}">拒绝</a> | <a style="color: #0065B0" href="${basePath}/annunciate/delete.do?vid=${it.vid}&p=${its.pageNum}&id=${id}&theme=${theme}&work_type=${antype}&work_time=${work_time}&site=${site}">删除</a></th>
                   </tr>
                   </c:forEach>
           </table>
        <div>
            共&nbsp;${its.pages}&nbsp;页&nbsp; &nbsp;
            <a href="${basePath}/annunciate/selectone.do?p=${its.firstPage}&id=${id}&theme=${theme}&work_type=${antype}&work_time=${work_time}&site=${site}&province=${province}">最前页</a>&nbsp;&nbsp; <a href="${basePath}/annunciate/selectone.do?p=${its.prePage}&id=${id}&theme=${theme}&work_type=${antype}&work_time=${work_time}&site=${site}&province=${province}">上一页</a>
            <span style='font-weight: bold; color: #5858E6'>${its.pageNum}</span>&nbsp;&nbsp; <a href="${basePath}/annunciate/selectone.do?p=${its.nextPage}&id=${id}&theme=${theme}&work_type=${antype}&work_time=${work_time}&site=${site}&province=${province}">下一页</a>
            <a href="${basePath}/annunciate/selectone.do?p=${its.lastPage}&id=${id}&theme=${theme}&work_type=${antype}&work_time=${work_time}&site=${site}&province=${province}">最后页</a>&nbsp;
        </div>
    </div>
    </div>
    <div class="clear"></div>
    <div id="dcFooter">
        <div id="footer">
            <div class="line"></div>

        </div>
    </div><!-- dcFooter 结束 -->
    <div class="clear"></div> </div>
<script type="text/javascript">_init_area();</script>
<script type="text/javascript">
    var Gid  = document.getElementById ;
    var showArea = function(){
        Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" +
            Gid('s_city').value + " - 县/区" +
            Gid('s_county').value + "</h3>"							}
    Gid('s_county').setAttribute('onchange','showArea()');

    addressInit('cmbProvince', 'cmbCity', 'cmbArea');
    $(document).ready(function(){
        $("#cmbArea").hide();})
</script>
</body>
</html>
