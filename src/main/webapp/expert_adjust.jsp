<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0">
<title>专家订正</title>
<%-- <spring:message code="main.title"></spring:message> --%>
<link rel="icon" type="image/ico" href="favicon.ico">

<!-[if lt IE9]> 
	<script src="js/html5.js"></script>
<![endif]>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>

<style type="text/css">

	*{ margin: 0;padding: 0; border: 0;}
	.main-wrapper{ width:100%;}
	#query_condition{ width:100%; height:20%; margin-bottom:20px;}
	#pieChart{border:2px dashed #000;width:100%;height:200px;margin-bottom:20px; }
	#svgs svg{ width:100px; height:100px;margin:0;padding:0;float:left;}
	#model1{float:left;}
	#expert_adjust{ border:2px dashed #000; width:100%; height:200px; }

</style>

<script type="text/javascript">
	function sendRequestToServer(){
		$.ajax({
			  type: 'POST',
			  url: 'rest/test.do',
			  success: function(result){
					  console.log("sssss");
/* 				  if(result.code=="SUCCESS"){
					  //window.location.href='homePage.jsp';
				  }else{
					  //$("#loginMsg").css("color",redGreen).html(tips[3]+ result.msg);
				  } */
			  },
			  dataType: "json",
			  contentType:"application/json"
		});
	}
</script>

</head>

<body class="bg_b">
	<div class="main-wrapper">
		<div id="query_condition">
			<span>启动时间</span>
			<input id="query_date" type="date" class="form_control"/>
			<select id="pollution_type">
				<option value="1">PM2.5</option>
			</select>
			<select id="statistic_type">
				<option value="2" id="industry">行业贡献率</option>
				<option value="1" id="area">地区贡献率</option>
			</select>
			&nbsp;&nbsp;
			<button id="query" onclick="javascript:void(0);">查询</button>
		</div>
		<div id="pieChart">
			<div id="modes">
				<span id="model1">MODE1</span>
				<div id="svgs">
					<svg version="1.1"xmlns="http://www.w3.org/2000/svg">
						<circle cx=40 ,cy =40 r="40" stroke="black" stroke-width="2" fill="red"/>
					</svg>
					<svg version="1.1"xmlns="http://www.w3.org/2000/svg">
						<circle  r="40" stroke="black"stroke-width="2" fill="green"/>
					</svg>
					<svg version="1.1"xmlns="http://www.w3.org/2000/svg">
						<circle  r="40" stroke="black"stroke-width="2" fill="blue"/>
					</svg>
					<svg version="1.1"xmlns="http://www.w3.org/2000/svg">
						<circle  r="40" stroke="black"stroke-width="2" fill="yellow"/>
					</svg>
				</div>
			</div>
		</div>
		
		<div id="expert_adjust">
			<div id="left">
				<div id="up">
					<span>专家订正</span>
					<select id="choose_day">
						<option value="first">第一天</option>
						<option value="second">第二天</option>
						<option value="third">第三天</option>
					</select>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button id="export_table">导出</button>
				</div>
				<div id="down">
					<table border="1">
						<thead class="theader">
							<tr>
								<td>总和</td>
								<td>电力</td>
								<td>工业</td>
								<td>居民</td>
								<td>交通</td>
								<td>农业</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>100</td>
								<td>11.4</td>
								<td>37.4</td>
								<td>25.1</td>
								<td>13.9</td>
								<td>12.3</td>
							</tr>
							<tr>
								<td>100</td>
								<td>11.4</td>
								<td>37.4</td>
								<td>25.1</td>
								<td>13.9</td>
								<td>12.3</td>
							</tr>
							<tr>
								<td>100</td>
								<td>11.4</td>
								<td>37.4</td>
								<td>25.1</td>
								<td>13.9</td>
								<td>12.3</td>
							</tr>
						</tbody>
					</table>
					<button id="submit">提交</button>
				</div>
			</div>
			<div id="right" style="border: 1">
				<svg version="1.1"xmlns="http://www.w3.org/2000/svg">
					<circle cx="100" cy="50" r="40" stroke="black"stroke-width="2" fill="red"/>
				</svg>
				<button id="export_pie">
					导出
				</button>
			</div>
		</div>
	</div>
	<a href="javascript:void(0);" onclick="sendRequestToServer()">+++++++++</a>
</body>
</html>