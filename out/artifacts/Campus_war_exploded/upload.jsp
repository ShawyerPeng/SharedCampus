<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    描述：<input type="text" name="description">
    <button type="submit"> 提交 </button>
</form><br>
<form action="/uploadMultipart" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="file" name="file">
    描述：<input type="text" name="description">
    <button type="submit"> 提交 </button>
</form>
</body>
</html>