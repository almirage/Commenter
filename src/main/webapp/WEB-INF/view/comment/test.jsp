<%@page pageEncoding="UTF-8"%>
<html>
<head>
	<script type="text/javascript" src="${f:url("/js/jquery.js")}"></script>
	<script type="text/javascript" src="${f:url("/js/commenter.js")}"></script>
</head>
<body>

<h1>test</h1>

<div id="hoge">&nbsp;</div>
<script type="text/javascript">
commenter.display("hoge", "http://www.hutcraft.jp/", "hutcraft");
</script>

<div id="hoge2"></div>
<script type="text/javascript">
commenter.tag("hoge2", "hutcraft", 10, "■過去のコメント一覧");
</script>

</body>
</html>