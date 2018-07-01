<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<title>首頁</title>
	<base href="/">
</head>

<body ng-app="PCMS">

	<div ng-controller="pcmsController" class="container">
		<table>
			<tr>
				<td>
					<button type="button" class="btn btn-primary" ng-click="initDB()">一鍵新增假資料</button>
				</td>
				<td>
					<button type="button" class="btn btn-primary" ng-click="toFM001S02()">開戶審查進件($location)</button>
				</td>
				<td>
					<button type="button" class="btn btn-primary" ng-click="toFM003()">案件查詢</button>
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td>
					<a class="btn btn-default" ng-href="<%=request.getContextPath() %>/#/FM001S02">開戶審查進件(ng-href)</a>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="container">
        <div class="container" ng-view></div>
    </div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular-route.min.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/module.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/directives/fileDirective.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/index.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/pages/fm001/FM001S02.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/pages/fm003/FM003.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/pages/common/COMMON_SELF_BUILD.js"></script>
</body>
</html>