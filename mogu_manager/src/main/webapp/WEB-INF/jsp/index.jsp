<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="edge" />
<link rel="shortcut" href="images/mogu-icon.ico" sizes="32x32" />


<title>蘑菇商品后台管理系统</title>


<link href="js/insdep/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
<link href="js/insdep/themes/insdep/easyui_animation.css" rel="stylesheet" type="text/css">
<link href="js/insdep/themes/insdep/easyui_plus.css" rel="stylesheet" type="text/css">
<link href="js/insdep/themes/insdep/insdep_theme_default.css" rel="stylesheet" type="text/css">
<link href="js/insdep/themes/insdep/icon.css" rel="stylesheet" type="text/css">
<link href="js/insdep/plugin/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/insdep/jquery.min.js"></script>
<script type="text/javascript" src="js/insdep/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/insdep/themes/insdep/jquery.insdep-extend.min.js"></script>


</head>

<body>
	<div id="master-layout">
        <div data-options="region:'north',border:false,bodyCls:'theme-header-layout'">
        	<div class="theme-navigate">
                <div class="left">
                    <a href="#" class="easyui-linkbutton left-control-switch"><i class="fa fa-bars fa-lg"></i></a>
                    <a href="#" class="easyui-menubutton theme-navigate-user-button" data-options="menu:'.theme-navigate-user-panel'">个人信息</a>
                    <a href="#" class="easyui-linkbutton" align="right">新建</a>
                    <a href="#" class="easyui-linkbutton" align="right" onclick="doQuit()">退出</a>
                    
                    <div class="theme-navigate-user-panel">
                       <dl>
                       		<dd>
                            	<img src="${admin.img }" width="86" height="86">
                                <b class="badge-prompt">${admin.username }<i class="badge color-important">10</i></b>
                                <span>${admin.email }</span>
                                <p>安全等级：<i class="text-success">高</i></p>
                            </dd>
                            <dt>
                            	<a class="theme-navigate-user-modify">修改密码</a>
                                <a class="theme-navigate-user-logout" href="#" onclick="doQuit()">注销</a>
                            </dt>
                       </dl>
                    </div>
                </div>
                <div class="right">
                    <select id="cc2" class="easyui-combobox theme-navigate-combobox" name="dept" style="width:180px;">  
                    	<option>Choose a language</option>   
                        <option>Chinese</option>   
                        <option>English</option>   
                        <option>Korean</option>   
                        <option>Japanese</option>   
                        <option>Arabic</option>   
                    </select>  
                    <input class="easyui-searchbox theme-navigate-search" data-options="prompt:'输入搜索的关键词..',menu:'#mm',searcher:doSearch" style="width:300px"></input>
                    <a href="#" class="easyui-menubutton theme-navigate-more-button" data-options="menu:'#more',hasDownArrow:false"></a>
                    <div id="more" class="theme-navigate-more-panel">
                    	<div>联系我们</div>
                        <div>参与改进计划</div>
                        <div>检测更新</div>
                        <div>关于</div>
                    </div>
                    <!--自动列表-->
                    <div id="mm" class="theme-navigate-menu-panel">
                        <div data-options="name:'all'">特别感谢：</div>
                        <div data-options="name:'sports'">&nbsp;&nbsp;&nbsp;&nbsp;陈波、沈博剑、罗倩、唐诗涵、何欣洋、覃登康</div>
                    </div>
                </div>
            </div>
        
        </div>

        <!--开始左侧菜单-->
        <div data-options="region:'west',border:false,bodyCls:'theme-left-layout'" style="width:200px;">


            <!--正常菜单--> 
            <div class="theme-left-normal">
                <!--theme-left-switch 如果不需要缩进按钮，删除该对象即可-->    
                <div class="left-control-switch theme-left-switch"><i class="fa fa-chevron-left fa-lg"></i></div>

                <!--start class="easyui-layout"-->
                <div class="easyui-layout" data-options="border:false,fit:true"> 
                    <!--start region:'north'-->
                    <div data-options="region:'north',border:false" style="height:100px;">
                        <!--start theme-left-user-panel-->
                        <div class="theme-left-user-panel">
                            <dl>
                                <dt>
                                    <img src="${admin.img }" width="43" height="43">
                                </dt>
                                <dd>
                                    <b class="badge-prompt">${admin.username} <i class="badge color-important">10</i></b>
                                    <span>${admin.email}</span>
                                    <p>安全等级：<i class="text-success">高</i></p>
                                </dd>

                            </dl>
                        </div>
                        <!--end theme-left-user-panel-->
                    </div>   
                    <!--end region:'north'-->

                    <!--start region:'center'-->
                    <div data-options="region:'center',border:false">

                        <!--start easyui-accordion data-options="attributes:{'url':'item-add'}"--> 
                        <div class="easyui-accordion" data-options="border:false,fit:true">   
                            <div title="商品管理">
                                <ul name="menuTree" class="easyui-tree" data-options="border:false,fit:true">
                                	<li data-options="attributes:{'url':'item-add'}">新增商品</li>
                                    <li data-options="attributes:{'url':'item-list'}">商品列表</li>
                                    <li data-options="attributes:{'url':'item-param-list'}">规格参数</li>
                                </ul>  
                            </div>   
                            <div title="网站内容管理">   
                                <ul name="menuTree" class="easyui-tree" data-options="border:false,fit:true">
                                    <li data-options="attributes:{'url':'content-category'}">内容分类管理</li>
                                    <li data-options="attributes:{'url':'content'}">内容管理</li>
                                </ul>      
                            </div>   
                            <div title="订单信息管理">   
                                <ul name="menuTree" class="easyui-tree" data-options="border:false,fit:true">
                                    <li data-options="attributes:{'url':'order-list'}">订单列表</li>
                                </ul>      
                            </div>
                            <div  title="用户管理">   
                                <ul name="menuTree" class="easyui-tree" data-options="border:false,fit:true">
                                    <li data-options="attributes:{'url':'user-list'}">用户列表</li>
                                </ul>      
                            </div>
                            <div title="个人设置">   
                                <ul name="menuTree" class="easyui-tree" data-options="border:false,fit:true">
                                    <li data-options="attributes:{'url':'/admin/modify'}">修改个人资料</li>
                                </ul>      
                            </div>
                        </div>
                        <!--end easyui-accordion--> 

                    </div>
                    <!--end region:'center'-->
                </div>  
                <!--end class="easyui-layout"-->

            </div>
            <!--最小化菜单--> 
            <div class="theme-left-minimal">
                <ul class="easyui-datalist" data-options="border:false,fit:true">
                    <li><i class="fa fa-pencil fa-2x"></i><p>编辑</p></li>
                    <li><i class="fa fa-cog fa-2x"></i><p>设置</p></li>
                    <li><a class="left-control-switch"><i class="fa fa-chevron-right fa-2x"></i><p>打开</p></a></li>
                </ul>
            </div>

        </div>
        <!--结束左侧菜单--> 

        <div id="tabs" class="easyui-tabs" data-options="region:'center',border:false" style="padding:20px; background:#fff;height:100%">
			</div>
             
        </div>
    </div>



    <script>
    	$(function(){

			/*布局部分*/
			$('#master-layout').layout({
				fit:true/*布局框架全屏*/
			});   
			
            /*右侧菜单控制部分*/

            var left_control_status=true;
            var left_control_panel=$("#master-layout").layout("panel",'west');

            $(".left-control-switch").on("click",function(){
                if(left_control_status){
                    left_control_panel.panel('resize',{width:70});
                    left_control_status=false;
                    $(".theme-left-normal").hide();
                    $(".theme-left-minimal").show();
                }else{
                    left_control_panel.panel('resize',{width:200});
                    left_control_status=true;
                    $(".theme-left-normal").show();
                    $(".theme-left-minimal").hide();
                }
                $("#master-layout").layout('resize', {width:'100%'})
            });

            /*右侧菜单控制结束*/


			$(".theme-navigate-user-modify").on("click",function(){
                $('.theme-navigate-user-panel').menu('hide');
				$.insdep.window({width:"30%",height:"40%",id:"personal-set-window",href:"pwd-edit",title:"修改密码"});
               
            }); 

			var cc2=$('#cc2').combo('panel');
			cc2.panel({cls:"theme-navigate-combobox-panel"}); 
			
			$('ul[name="menuTree"]').tree({
				onClick: function(node){
					//console.log(1);
					var tabs = $("#tabs");
					var tab = tabs.tabs("getTab",node.text);
					if(tab){
						tabs.tabs("select",node.text);
					}else{
						tabs.tabs('add',{
						    title:node.text,
						    href: node.attributes.url,
						    closable:true,
						});
					}
				}
			});
			 
		});
		// 搜索框
		function doSearch(value,name){
			alert('该功能尚未实现');
		};
		
		function doQuit(){
			$.get(
					"/admin/quit",
					function(data){
						if(data.status == 200){
							alert("安全退出成功！");
							location.href=data.msg;
						}else{
							alert("安全退出失败！");
						}
					});
		};
			
    </script>

    <!--第三方插件加载-->
    <script src="js/insdep/plugin/justgage-1.2.2/raphael-2.1.4.min.js"></script>
    <script src="js/insdep/plugin/justgage-1.2.2/justgage.js"></script>
    <script src="js/insdep/plugin/Highcharts-5.0.0/js/highcharts.js"></script>
    <script type="text/javascript" src="js/insdep/plugin/ueditor-1.4.3.3/ueditor.config.js"></script>
    <script type="text/javascript" src="js/insdep/plugin/ueditor-1.4.3.3/ueditor.all.min.js"></script>


    <link href="js/insdep/plugin/cropper-2.3.4/dist/cropper.min.css" rel="stylesheet" type="text/css">
    <script src="js/insdep/plugin/cropper-2.3.4/dist/cropper.min.js"></script>


    <!--第三方插件加载结束-->

</body>
</html>
