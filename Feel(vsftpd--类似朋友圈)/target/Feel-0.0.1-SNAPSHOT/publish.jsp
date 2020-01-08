<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="js/kindeditor/themes/default/default.css" />
<script src="js/kindeditor/kindeditor.js"></script>
<script src="js/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script charset="utf-8" src="js/kindeditor/kindeditor-all.js"></script>
<script type="text/javascript">
   //(所有属性值必须为'',是个坑，千万要注意)
	KindEditor.ready(function(K) {
		var editor = K.editor({
			allowFileManager : true,
			//通过ajax发送请求
			uploadJson : 'upload'
		});
		editor = K.create('textarea[name="feel"]', {
		});
		//批量上传的点击事件
		K('#J_selectImage').click(function() {
		    editor.loadPlugin('multiimage', function() {
			     editor.plugin.multiImageDialog({
			     //立即插入的点击事件
				 clickFn : function(urlList) {
					  var div = K('#J_imageView');
					  //清空html内容
					  div.html('');
					  //data:发送ajax后获取到的服务器返回的json数据
				      K.each(urlList, function(i, data) {
						  div.append('<img src="' + data.url + '" width="100px" height="100px">');
						  div.append('<input type="hidden" value="'+ data.url + '" name="img">');
					  });
					  editor.hideDialog();
				  }
				  });
			  });
		 });
	  });
</script>
</head>
<body>
<form action="publish" method="post">
	标题：<input type="text" name="title" value=""><br>
	图片：<input type="button" id="J_selectImage" value="批量上传" />
		 <div id="J_imageView"></div><br>
	感受：<textarea name="feel" style="width:700px;height:200px;visibility:hidden;"></textarea>
	<input type="submit" value="发表">
</form>
</body>
</html>