<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.padeoe.pojo.User" %>
<%@ page import="com.padeoe.pojo.Risk" %>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>风险管理系统-导入风险</title>

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
                        用户：<%//out.print(((User)session.getAttribute("user")).getUsername());%>
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
                        <li>
                            <a href="riskmanage_page">风险管理</a>
                        </li>
                        <li>
                            <a href="projectmanage_page">项目管理</a>
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
                    <h1 class="page-header">添加风险</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">

                        <div class="col-lg-12">
                            <br>
                            <form action="addrisk_op">
	                            <input type="hidden" name="name" value="<%= request.getAttribute("name") %>"/>
                                <div class="col-lg-1 form-group" >
                                    <button type="submit" class="btn btn-default">查询</button>
                                </div>

                                <div class="col-lg-3 form-group">
                                    <select class="form-control" name="type">
                                        <option>全部</option>
                                        <option>被识别的风险</option>
                                        <option>转化为问题的风险</option>
                                    </select>
                                </div>

                                <div class="col-lg-3 form-group">
                                    起始时间：<input type="datetime-local" name="startdate">
                                </div>

                                <div class="col-lg-3 form-group">
                                    结束时间：<input type="datetime-local" name="enddate">
                                </div>
                            </form>

                            <br>
                            <form action="/insertRiskOpBL" method="POST">
                            <div align="center">
                            	<% String error = (String)request.getAttribute("error"); %>
                            	<%if(error != null) { %> <a color="red"><%= error %></a> <% } %>
                                <button type="submit" id="lead">导入</button>
                            </div>
                                <br>
                            <table align="center">
                                <thead>
                                <tr>
                                    <th width="20">导入</th>
                                    <th width="70">风险编号</th>
                                    <th width="200">风险简述</th>
                                    <th width="300">风险详述</th>
                                    <th width="50">可能性 </th>
                                    <th width="50">影响程度</th>
                                    <th width="100">阈值</th>
                                    <th width="100">跟踪者</th>
                                </tr>
                                </thead>
                                <tbody>

                                <!--<tr>
                                    <td><input name="lead" type="checkbox"></td>
                                    <td>风险编号</td>
                                    <td>风险简述</td>
                                    <td>风险详述</td>
                                    <td>可能性</td>
                                    <td>影响程度</td>
                                    <td>阈值</td>
                                    <td>跟踪者</td>

                                </tr>-->
                                <% List<Risk> list = (List<Risk>)request.getAttribute("list"); %>
                                <input type="hidden" name="totalRisk" value="<%= list.size() %>"/>
                                <input type="hidden" name="project" value="<%= request.getAttribute("name") %>"/>
                                <%	
                                    for (int i = 0; i < list.size(); i ++) {
                                    	Risk risk = list.get(i);
                                        out.println("<tr>");
                                        
                                        // Risk Checkbox
                                        out.println("<td><input name=\"check_" + i + "\" type=\"checkbox\"></td>");
                                        int id = risk.getId().intValue();
                                        out.println(String.format("<td><input name=\"id_%d\" type=\"hidden\" value=\"%d\"/>%d", i, id, id));
                                        
                                        // Risk Brief & Detail
                                        out.println(String.format("<td>%s</td>", risk.getRiskBrief()));
                                        out.println(String.format("<td><input name=\"detail_%d\"value=\"%s\"></td>", i, risk.getRiskDetail()));

										// Possibility
                                        int possibilitiyint = risk.getPossibility().intValue();
                                        out.println("<td><select class=\"form-control\" name=\"possibility_" + i + "\">\n");
                                        out.println(possibilitiyint == 1? "<option selected=\"true\">低</option>" : "<option>低</option>");
                                    	out.println(possibilitiyint == 2? "<option selected=\"true\">普通</option>" : "<option>普通</option>");
                                        out.println(possibilitiyint == 3? "<option selected=\"true\">高</option>" : "<option>高</option>");
                                        out.println("</select></td>");

										// Influence
                                        int influenceint = risk.getInfluence().intValue();
                                        out.println("<td><select class=\"form-control\" name=\"influence_" + i + "\">\n");
                                        out.println(influenceint == 1? "<option selected=\"true\">一般</option>" : "<option>一般</option>");
                                    	out.println(influenceint == 2? "<option selected=\"true\">较大</option>" : "<option>较大</option>");
                                        out.println(influenceint == 3? "<option selected=\"true\">致命</option>" : "<option>致命</option>");
                                        out.println("</select></td>");

										// Threshold
                                        out.println("<td>"+ risk.getThreshold() +"</td>");
                                        
										// Tracer
                                        out.println("<td><input name=\"tracer_" + i + "\"value=\"\"></td>");

                                        out.println("</tr>");
                                    }
                                %>

                                </tbody>
                            </table>
							</form>
                            <br>
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

    <script>
        $(document).ready(function() {
            $('table').dataTable();
        });

        $('#lead').click(function () {


            var layer1 = $('tr :checkbox:checked').parent().parent();
            var totalRisk = layer1.length;
            for(var i = 0;i<layer1.length;i++){
                var layer2=$(layer1[i]).find('td');
                for(var j=0;j<layer2.length-1;j++){
                    console.log($(layer2[j]).text());
                    check[i] = true;
                    id[i] = layer2[0];
                    detail[i] = layer2[2];
                    tracer[i] = layer2[6];
                    possibility[i] = layer2[3];
                    influence[i]= layer2[4];
                }
            }

            var obj={
                'check[]': check,
                'id[]': id,
                'detail[]':detail,
                'tracer[]':tracer,
                'possibility[]':possibility,
                'influence[]':influence,
                'totalRisk':totalRisk,
                'project':'<%=request.getAttribute("name")%>'
            }
            $(obj).serialize();
        });
    </script>

<script src="/js/jquery.dataTables.min.js"></script>

</body>

</html>
