<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/jquery.fileupload.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/jquery.fileupload-ui.css">
	<!-- CSS adjustments for browsers with JavaScript disabled -->
	<noscript><link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/jquery.fileupload-noscript.css"></noscript>
	<noscript><link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/jquery.fileupload-ui-noscript.css"></noscript>
	<title>首頁</title>
</head>

<body ng-app="pcmsApp">

	<div ng-controller="pcmsController" class="container">
	
		<div class="form-group">
			<label>客戶統編:</label> 
			<input type="text" class="form-control" id="customer.id" ng-model="customer.customerId" />
		</div>
		
		<div class="form-group">
			<label>客戶姓名:</label> 
			<input type="text" class="form-control" id="customer.name" ng-model="customer.customerName" />
		</div>
		
		<div class="form-group">
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
				上傳參考附件
			</button>
		</div>
		 
		<button type="submit" class="btn btn-outline-primary" ng-click="submit()">進件</button>
		
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" ng-controller="DemoFileUploadController" data-file-upload="options" data-ng-class="{'fileupload-processing': processing() || loadingFiles}">
		<form id="fileupload" action="<%=request.getContextPath() %>/FileUpload" method="POST" enctype="multipart/form-data">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">上傳參考附件</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<label>參考附件:</label>
<!-- 						<input type="file" class="form-control-file" file-model="customer.customerFile" /> -->
<!-- 						<input type="file" class="form-control-file" multiple="multiple" id="customer.customerFiles" name="customer.customerFiles"/> -->
						<div class="row fileupload-buttonbar">
				            <div class="col-lg-7">
				                <!-- The fileinput-button span is used to style the file input field as button -->
				                <span class="btn btn-success fileinput-button" ng-class="{disabled: disabled}">
				                    <i class="glyphicon glyphicon-plus"></i>
				                    <span>Add files...</span>
				                    <input type="file" name="files[]" multiple ng-disabled="disabled">
				                </span>
				                
				                <button type="button" class="btn btn-primary start" data-ng-click="submit()">
<!-- 				                <button type="button" class="btn btn-primary start" ng-click="allFilesUpload()"> -->
				                    <i class="glyphicon glyphicon-upload"></i>
				                    <span>Start upload</span>
				                </button>
				                
				                <button type="button" class="btn btn-warning cancel" data-ng-click="cancel()">
				                    <i class="glyphicon glyphicon-ban-circle"></i>
				                    <span>Cancel upload</span>
				                </button>
				                <!-- The global file processing state -->
				                <span class="fileupload-process"></span>
				                
				            </div>
				            <!-- The global progress state -->
				            <div class="col-lg-5 fade" data-ng-class="{in: active()}">
				                <!-- The global progress bar -->
				                <div class="progress progress-striped active" data-file-upload-progress="progress()"><div class="progress-bar progress-bar-success" data-ng-style="{width: num + '%'}"></div></div>
				                <!-- The extended global progress state -->
				                <div class="progress-extended">&nbsp;</div>
				            </div>
				        </div>
				        
				        <!-- The table listing the files available for upload/download -->
				        <table class="table table-striped files ng-cloak">
				            <tr data-ng-repeat="file in queue" data-ng-class="{'processing': file.$processing()}">
				                <td data-ng-switch data-on="!!file.thumbnailUrl">
				                    <div class="preview" data-ng-switch-when="true">
				                        <a data-ng-href="{{file.url}}" title="{{file.name}}" download="{{file.name}}" data-gallery>
				                        	<img data-ng-src="{{file.thumbnailUrl}}" alt="">
				                        </a>
				                    </div>
				                    <div class="preview" data-ng-switch-default data-file-upload-preview="file"></div>
				                </td>
				                
				                <td>
				                    <p class="name" data-ng-switch data-on="!!file.url">
				                        <span data-ng-switch-when="true" data-ng-switch data-on="!!file.thumbnailUrl">
				                            <a data-ng-switch-when="true" data-ng-href="{{file.url}}" title="{{file.name}}" download="{{file.name}}" data-gallery>{{file.name}}</a>
				                            <a data-ng-switch-default data-ng-href="{{file.url}}" title="{{file.name}}" download="{{file.name}}">{{file.name}}</a>
				                        </span>
				                        <span data-ng-switch-default>{{file.name}}</span>
				                    </p>
				                    <strong data-ng-show="file.error" class="error text-danger">{{file.error}}</strong>
				                </td>
				                <td>
				                    <p class="size">{{file.size | formatFileSize}}</p>
				                    <div class="progress progress-striped active fade" data-ng-class="{pending: 'in'}[file.$state()]" data-file-upload-progress="file.$progress()"><div class="progress-bar progress-bar-success" data-ng-style="{width: num + '%'}"></div></div>
				                </td>
				                <td>
				                    <button type="button" class="btn btn-primary start" data-ng-click="file.$submit()" data-ng-hide="!file.$submit || options.autoUpload" data-ng-disabled="file.$state() == 'pending' || file.$state() == 'rejected'">
				                        <i class="glyphicon glyphicon-upload"></i>
				                        <span>Start</span>
				                    </button>
				                    <button type="button" class="btn btn-warning cancel" data-ng-click="file.$cancel()" data-ng-hide="!file.$cancel">
				                        <i class="glyphicon glyphicon-ban-circle"></i>
				                        <span>Cancel</span>
				                    </button>
				                    <button ng-controller="FileDestroyController" type="button" class="btn btn-danger destroy" data-ng-click="file.$destroy()" data-ng-hide="!file.$destroy">
				                        <i class="glyphicon glyphicon-trash"></i>
				                        <span>Delete</span>
				                    </button>
				                </td>
				            </tr>
				        </table>
					</div>
				</div>
			</div>
		</form>
		</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.min.js"></script>
<!-- 	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> -->
<!-- 	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script> -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<!-- 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	 -->
	
	<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
	<script src="<%=request.getContextPath() %>/resources/js/vendor/jquery.ui.widget.js"></script>
	<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
	<script src="<%=request.getContextPath() %>/resources/js/jquery.iframe-transport.js"></script>
	<!-- The basic File Upload plugin -->
	<script src="<%=request.getContextPath() %>/resources/js/jquery.fileupload.js"></script>
	<!-- The File Upload processing plugin -->
	<script src="<%=request.getContextPath() %>/resources/js/jquery.fileupload-process.js"></script>
	<!-- The File Upload image preview & resize plugin -->
	<script src="<%=request.getContextPath() %>/resources/js/jquery.fileupload-image.js"></script>
	<!-- The File Upload audio preview plugin -->
	<script src="<%=request.getContextPath() %>/resources/js/jquery.fileupload-audio.js"></script>
	<!-- The File Upload video preview plugin -->
	<script src="<%=request.getContextPath() %>/resources/js/jquery.fileupload-video.js"></script>
	<!-- The File Upload validation plugin -->
	<script src="<%=request.getContextPath() %>/resources/js/jquery.fileupload-validate.js"></script>
	<!-- The File Upload Angular JS module -->
	<script src="<%=request.getContextPath() %>/resources/js/jquery.fileupload-angular.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/index.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/directives/fileModel.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/service/multipartForm.js"></script>
</body>
</html>