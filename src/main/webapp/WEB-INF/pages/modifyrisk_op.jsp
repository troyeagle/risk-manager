<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.padeoe.pojo.User" %>
<%@ page import="com.padeoe.pojo.Risk" %>
<%@ page import="com.padeoe.pojo.RiskOperation" %>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>风险管理系统-修改风险条目</title>

    <!-- Bootstrap Core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        th{ white-space: nowrap; }
    </style>

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index_page">项目风险管理</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!--
                 <li class="dropdown">
                     <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                         <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                     </a>
                     <ul class="dropdown-menu dropdown-messages">
                         <li>
                             <a href="#">
                                 <div>
                                     <strong>John Smith</strong>
                                     <span class="pull-right text-muted">
                                         <em>Yesterday</em>
                                     </span>
                                 </div>
                                 <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                             </a>
                         </li>
                         <li class="divider"></li>
                         <li>
                             <a href="#">
                                 <div>
                                     <strong>John Smith</strong>
                                     <span class="pull-right text-muted">
                                         <em>Yesterday</em>
                                     </span>
                                 </div>
                                 <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                             </a>
                         </li>
                         <li class="divider"></li>
                         <li>
                             <a href="#">
                                 <div>
                                     <strong>John Smith</strong>
                                     <span class="pull-right text-muted">
                                         <em>Yesterday</em>
                                     </span>
                                 </div>
                                 <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                             </a>
                         </li>
                         <li class="divider"></li>
                         <li>
                             <a class="text-center" href="#">
                                 <strong>Read All Messages</strong>
                                 <i class="fa fa-angle-right"></i>
                             </a>
                         </li>
                     </ul>
                     <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 1</strong>
                                        <span class="pull-right text-muted">40% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 2</strong>
                                        <span class="pull-right text-muted">20% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 3</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 4</strong>
                                        <span class="pull-right text-muted">80% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete (danger)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Tasks</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="index_page">
                        用户：<% out.print(((User)session.getAttribute("user")).getUsername());%>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <!--
                       <li><a href="#"><i class="fa fa-user fa-fw"></i> 用户资料 </a>
                       </li>
                       <li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置 </a>
                       </li>
                       -->
                       <li class="divider"></li>
                       <li><a href="/logout"> 登出</a>
                       </li>
                   </ul>
                   <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">

                        <li>
                            <a href="index_page">主页</a>
                        </li>
                        <%
                            if(((User)session.getAttribute("user")).getAuthority()==0) {
                                out.print("<li>");
                                out.print("<a href=\"riskmanage_page\">风险管理</a>");
                                out.print("</li>");
                            }
                        %>
                        <li>
                            <a href="projectmanage_page">项目管理</a>
                        </li>
                        <li>
                            <a href="piechart_page">统计图表</a>
                        </li>
                        <!--
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Flot Charts</a>
                                </li>
                                <li>
                                    <a href="morris.html">Morris.js Charts</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level
                        </li>
                        <li>
                            <a href=""><i class="fa fa-table fa-fw"></i> Tables</a>
                        </li>
                        <li>
                            <a href="forms.html"><i class="fa fa-edit fa-fw"></i> Forms</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> UI Elements<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="panels-wells.html">Panels and Wells</a>
                                </li>
                                <li>
                                    <a href="buttons.html">Buttons</a>
                                </li>
                                <li>
                                    <a href="notifications.html">Notifications</a>
                                </li>
                                <li>
                                    <a href="">Typography</a>
                                </li>
                                <li>
                                    <a href="icons.html"> Icons</a>
                                </li>
                                <li>
                                    <a href="grid.html">Grid</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level
                        </li>

                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Second Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Second Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                            </ul>
                            <!-- /.nav-second-level
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="blank.html">Blank Page</a>
                                </li>
                                <li>
                                    <a href="login.jsp">Login Page</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level
                        </li>
                    -->
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">修改风险条目</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

            <%
                Risk risk = (Risk)request.getAttribute("risk");
                RiskOperation riskop = (RiskOperation)request.getAttribute("riskop");
            %>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="col-lg-2">
                        </div>
                        <div class="col-lg-8">
                            <br>
                            <form role="form" action="modifyRiskOpBL">
                                <p style="color: red; text-align: center">${requestScope.error}</p>

                                <div class="form-group">
                                    <label>风险条目ID</label>
                                    <input class="form-control-static" readonly="readonly" name="id" type="text" value="<%out.println( riskop.getId().intValue());%>">
                                </div>

                                <div class="form-group">
                                    <label>风险简述</label>
                                    <input class="form-control" name="riskBrief"  readonly="readonly" type="text" value="<%out.println( risk.getRiskBrief());%>">
                                </div>

                                <div class="form-group">
                                    <label>风险详细描述</label>
                                    <textarea class="form-control" rows="3" name="riskDetail"><%=riskop.getDescription()%></textarea>
                                </div>


                                <div class="form-group">
                                    <label>阈值</label>
                                    <input class="form-control" name="threshold"  readonly="readonly"  type="text" value="<%=risk.getThreshold()%>">
                                </div>

                                <%
                                    int state = riskop.getPossibility().intValue();
                                %>

                                <div class="form-group">
                                    <label>状态</label>
                                    <select class="form-control" name="state">
                                        <option <%if(state==1){out.print("selected=\"selected\"");} %> >被发现</option>
                                        <option <%if(state==2){out.print("selected=\"selected\"");} %> >演变为问题</option>
                                        <option <%if(state==3){out.print("selected=\"selected\"");} %> >解决中</option>
                                        <option <%if(state==4){out.print("selected=\"selected\"");} %> >已解决</option>
                                    </select>
                                </div>

                                <%
                                      int possibility = riskop.getPossibility().intValue();
                                %>

                                <div class="form-group">
                                    <label>可能性</label>
                                    <select class="form-control" name="possibility">
                                        <option <%if(possibility==1){out.print("selected=\"selected\"");} %> >低</option>
                                        <option <%if(possibility==2){out.print("selected=\"selected\"");} %> >普通</option>
                                        <option <%if(possibility==3){out.print("selected=\"selected\"");} %> >高</option>
                                    </select>
                                </div>

                                <%

                                    int influence = riskop.getInfluence().intValue();

                                %>

                                <div class="form-group">
                                    <label>影响程度</label>
                                    <select class="form-control" name="influence">
                                        <option <%if(influence==1){out.print("selected=\"selected\"");} %> >一般</option>
                                        <option <%if(influence==2){out.print("selected=\"selected\"");} %> >较大</option>
                                        <option <%if(influence==3){out.print("selected=\"selected\"");} %> >致命</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label>是否提示追踪者</label>
                                    <input type="checkbox" name="Notification" value="true" />是
                                </div>

                                <div class="form-group">
                                    <label>追踪者</label>
                                    <textarea class="form-control" rows="1" name="tracer"><%=riskop.getTracerName()%></textarea>
                                </div>

                                <div class="form-group">
                                    <label>提示标题</label>
                                    <textarea class="form-control" rows="1" name="Notificationtitle"></textarea>
                                </div>

                                <div class="form-group">
                                    <label>提供给追踪者的信息</label>
                                    <textarea class="form-control" rows="3" name="Notificationmessage"></textarea>
                                    <p class="help-block" >不填写则默认为系统自动生成信息</p>
                                </div>


                                <button type="submit" class="btn btn-default"><h5>提交表单</h5></button>
                            </form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->

                </div>
                <!-- /.col-lg-8 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="/vendor/raphael/raphael.min.js"></script>
    <script src="/vendor/morrisjs/morris.min.js"></script>
    <script src="/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/dist/js/sb-admin-2.js"></script>

</body>

</html>