<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="content-style-type" content="text/css" />
<meta http-equiv="content-script-type" content="text/javascript" />

<title><tiles:getAsString name="title" /></title>
<style type="text/css">
background-color: white;
color: black;
</style>
</head>
<body>

<tiles:insert page="/WEB-INF/view/common/header.jsp" />

<div id="contents">
	<tiles:insert attribute="content" />
</div>
<div id="side">
	<tiles:insert attribute="menu" />
</div>

<tiles:insert page="/WEB-INF/view/common/footer.jsp" />

</body>
</html>