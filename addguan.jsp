
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
           <%-- <li ><a href="/ChatRobot/head/select.do"><i class="product"></i><em>用户头像</em></a></li>--%>
        </ul>
        <ul>
            <li ><a href="${basePath}/annunciate/selectone.do"><i class="articleCat"></i><em>通告管理</em></a></li>
            <li class="cur"><a href="${basePath}/annunciate/addguan.do"><i class="articleCat"></i><em>添加官方通告</em></a></li>
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

        <form  action="${basePath}/annunciate/save.do" method="post" enctype="multipart/form-data" >
            <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
                <tr>
                    <td width="80" align="right">工作主题</td>
                    <td>
                        <input type="text" name="theme" value="" size="40" class="inpMain" />
                    </td>
                </tr>
                <tr>
                    <td align="right">通告类型</td>
                    <td>
                        <select name="work_type">
                            <c:forEach items="${items}" var="it">
                                <option value="${it.antype}">${it.antype}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <%--<tr>
                    <td align="right">发布人</td>
                    <td>
                        <input type="text" name="wx_name" value="" size="20" class="inpMain" />
                    </td>
                </tr>--%>
              <%--  <tr>
                    <td align="right">联系方式</td>
                    <td>
                        <input type="text" name="phone" value="" size="20" class="inpMain" />
                    </td>
                </tr>--%>
                <tr>
                    <td align="right">工作时间</td>
                    <td>
                       <%-- <input type="text"  name="work_time" value="" size="10" class="Wdate" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm'})"/>--%>
                           <input type="text" id="d11" name="work_time" value="" size="10" class="Wdate" onClick="WdatePicker()" />至 <input type="text" id="d11" name="work_finish" value="" size="10" class="Wdate" onClick="WdatePicker()" />
                    </td>
                </tr>
                <tr>
                    <td align="right">工作地点</td>
                    <td>
                       <%-- <select id="cmbProvince" name="cmbProvince"></select>
                        <select id="cmbCity" name="cmbCity"></select>
                        <select id="cmbArea" name="cmbArea"></select>--%>
                        <select id="s_province" name="cmbProvince"></select>  
                        <select id="s_city" name="cmbCity" ></select>  
                        <select id="s_county" name="cmbArea"></select>
                       <%-- <input type="text" name="workplace" value="" size="40" class="inpMain" />--%>
                    </td>
                </tr>
                <tr>
                    <td align="right">详细地址</td>
                    <td>
                        <input type="text" name="information" value="" size="40" class="inpMain" />
                    </td>
                </tr>
                <tr>
                    <td align="right">报名截止时间</td>
                    <td>
                        <%--<input type="text" id="d11" name="deadline" value="" size="40" class="Wdate" onClick="WdatePicker()" />--%>
                        <input type="text"  name="deadline" value="" size="10" class="Wdate" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm'})"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">性别</td>
                    <td>
                        <label for="mobile_closed_0">
                            <input type="radio" name="asex" id="mobile_closed_0" value="男" checked="true">
                            男</label>
                        <label for="mobile_closed_1">
                            <input type="radio" name="asex" id="mobile_closed_1" value="女">
                            女</label>
                    </td>
                </tr>
                <tr>
                    <td align="right">人数</td>
                    <td>
                        <input  onkeyup="value=value.replace(/[^\d]/g,'') "
                                onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
                                type="text" name="number" value="" size="5" class="inpMain" />
                    </td>
                </tr>
                <tr>
                    <td align="right">是否面试</td>
                    <td>
                        <label for="mobile_closed_0">
                            <input type="radio" name="interview" id="mobile_closed_0" value="否" checked="true">
                            否</label>
                        <label for="mobile_closed_1">
                            <input type="radio" name="interview" id="mobile_closed_1" value="是">
                            是</label>
                    </td>
                </tr>
                <tr>
                    <td align="right">薪酬</td>
                    <td>
                        <label for="mobile_closed_0">
                            <input type="radio" name="price" id="mobile_closed_0" value="自报价" onclick="b()" >
                            自报价</label>
                        <label for="mobile_closed_1">
                            <input type="radio" name="price" id="mobile_closed_1" value="面议" onclick="b()">
                            面议</label>
                        <label for="mobile_closed_1">
                            <input type="radio" name="price"   id="i4"  onclick="a()">
                            价格</label>
                      <div id="i8"> 、
                          <input id="i3" onblur="c()"  type="text"  value="" size="5" class="inpMain" />
                          <select name="dan">
                              <option value="元/人">元/人</option>
                              <option value="元/人/天">元/人/天</option>
                              <option value="元/人/时">元/人/时</option>
                          </select>
                      </div>
                    </td>
                </tr>
                <tr>
                    <td align="right">添加图片</td>
                    <td>
                        <input type="file" name="file" size="18" />
                    </td>
                </tr>
                <tr>
                    <td align="right">详情说明</td>
                    <td>
                        <textarea name="details" cols="60" rows="4" class="textArea"></textarea>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="hidden" value="${a}" id="i1">
                        <input type="hidden" name="token" value="25bfda40" />
                        <input type="hidden" name="cat_id" value="" />
                        <input name="submit" class="btn" type="submit" value="提交" />
                    </td>
                </tr>

            </table>
        </form>
    </div>
    </div>
    <div class="clear"></div>
    <div id="dcFooter">
        <div id="footer">
            <div class="line"></div>
            <script class="resources library" src="${basePath}/js/area.js" type="text/javascript"></script>
            <script type="text/javascript">_init_area();</script>
            <script type="text/javascript">
                var Gid  = document.getElementById ;
                var showArea = function(){
                    Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" +
                        Gid('s_city').value + " - 县/区" +
                        Gid('s_county').value + "</h3>"							}
                Gid('s_county').setAttribute('onchange','showArea()');

              /*  addressInit('cmbProvince', 'cmbCity', 'cmbArea');*/
                $(document).ready(function(){
                    var a=document.getElementById("i1");
                    $("#i8").hide();
                    if(a.getAttribute("value")!=""){
                        alert("提交成功");
                    }
                    }
                );
                function b() {
                    $("#i8").hide();
                }
                function a() {
                   $("#i8").show();
                }
                function c() {
                    var a=$("#i3").val();
                    $("#i4").val(a);
                    alert(a);
                }
            </script>
        </div>
    </div><!-- dcFooter 结束 -->
    <div class="clear"></div> </div>

</body>
</html>
