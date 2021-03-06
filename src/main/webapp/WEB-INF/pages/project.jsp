<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.padeoe.pojo.Risk" %>
<%@ page import="com.padeoe.pojo.User" %>
<%@ page import="com.padeoe.pojo.RiskOperation" %>
<%@ page import="com.padeoe.pojo.Project" %>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>风险管理系统-风险管理</title>

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

    <link href="/css/dataTables.bootstrap.min.css" rel="stylesheet">



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
                <a class="navbar-brand" href="index_page">项目风险管理项目页面</a>
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
                        用户：<%out.print(((User)session.getAttribute("user")).getUsername());%>
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
                            <a href="tables.html"><i class="fa fa-table fa-fw"></i> Tables</a>
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
                                    <a href="typography.html">Typography</a>
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
                    <h1 class="page-header">项目 管理</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">

                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->


                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <%String projectname = ((Project)request.getAttribute("project")).getName();
                            out.print(projectname);
                                session.setAttribute("projectname",projectname);
                            %>
                        </div>
                        <!-- /.panel-heading -->
                        <b>详细描述：</b><%= (((Project)request.getAttribute("project"))).getDescription() %>
                        <!-- /.panel-body -->
                    </div>
                    <br>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            风险条目表
                            <div class="pull-right">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                        操作
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu pull-right" role="menu">
                                        <li><a href="/addrisk_op?name=<%=projectname%>">导入具体风险条目</a>
                                        </li>
                                        <!--
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                        -->
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">

                                <div class="panel panel-default">
                                    <!-- /.panel-heading -->
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                                <thead>
                                                <tr>
                                                    <th>风险条目编号</th>
                                                    <th>风险简述</th>
                                                    <th>风险详述</th>
                                                    <th>可能性</th>
                                                    <th>影响程度</th>
                                                    <th>阈值</th>
                                                    <th>提交者</th>
                                                    <th>跟踪者</th>
                                                    <th>最新状态</th>
                                                    <th>最新更新时间</th>
                                                    <th>修改</th>
                                                </tr>
                                                </thead>
                                                <tbody>

                                                <%
                                                    int i = 0;
                                                    List<RiskOperation> Listop = (List<RiskOperation>)request.getAttribute("listop");
                                                    for (Risk risk : (List<Risk>)request.getAttribute("listr")) {
                                                         out.println("<tr>");
                                                        int id = Listop.get(i).getId().intValue();
                                                        out.println("<td>"+ id +"</td>");
                                                        out.println("<td>"+ risk.getRiskBrief() +"</td>");
                                                        out.println("<td>"+ Listop.get(i).getDescription() +"</td>");

                                                        int possibilitiyint =Listop.get(i).getPossibility();
                                                        String possibility = risk.getLevel_Possiblility(possibilitiyint);
                                                        out.println("<td>"+ possibility +"</td>");

                                                        int influenceint =Listop.get(i).getInfluence() ;
                                                        String influence = risk.getLevel_Influence(influenceint);
                                                        out.println("<td>"+ influence +"</td>");

                                                        out.println("<td>"+ risk.getThreshold() +"</td>");
                                                        out.println("<td>"+ Listop.get(i).getCreatorName() +"</td>");
                                                        out.println("<td>"+ Listop.get(i).getTracerName() +"</td>");

                                                        int stateint = Listop.get(i).getState().intValue();
                                                        String state = "";
                                                        switch (stateint){
                                                            case (1):
                                                                state = "被发现";
                                                                break;
                                                            case(2):
                                                                state = "演变为问题";
                                                                break;
                                                            case(3):
                                                                state = "解决中";
                                                                break;
                                                            case(4):
                                                                state = "已解决";
                                                                break;
                                                        }
                                                        out.println("<td>"+ state +"</td>");

                                                        out.println("<td>"+ Listop.get(i).getUpdateTime() +"</td>");
                                                        out.println("<td> <a href=\"/modifyrisk_op?id=" + id + "\">修改</a> </td>");
                                                        out.println("</tr>");
                                                        i++;
                                                    }
                                                %>

                                                </tbody>
                                            </table>
                                        </div>
                                        <!-- /.table-responsive -->
                                    </div>
                                    <!-- /.panel-body -->
                                </div>
                                <!-- /.panel -->
                            </div>
                            <!-- /.col-lg-12 -->
                        </div>
                        <!-- /.panel-heading -->

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

    <!-- Page-Level Plugin Scripts - Tables -->
    <script src="/js/dataTables.bootstrap.min.js"></script>
    <script src="/js/jquery.dataTables.js"></script>
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
        $(document).ready(function() {
            $('#dataTables-example').dataTable();
        });
    </script>
</body>

</html>
