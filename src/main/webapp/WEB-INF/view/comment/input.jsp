<%@page pageEncoding="UTF-8"%>
<html>
<body>

<h1>Comment input</h1>


<ul>
	<li>名前は任意。入力しなくてもコメントは入れられる</li>
	<li>名前を入れた場合はパスワードは必須</li>
	<li>comment, url, tagは必須</li>
	<li>urlはPOST後の戻り先に使います</li>
	<li>tagは「最新の発言一覧」の絞り込みに使います</li>
</ul>

<html:errors />

<s:form>
<dl>
	<dt>name</dt>
	<dd><html:text property="name" /></dd>
	<dt>pass</dt>
	<dd><html:password property="password" /></dd>
	<dt>comment</dt>
	<dd><html:text property="comment" /></dd>
	<dt>url</dt>
	<dd><html:hidden property="url" />${f:h(url)}</dd>
	<dt>tag</dt>
	<dd><html:hidden property="tag" />${f:h(tag)}</dd>
</dl>
<p><input type="submit" name="post" value="post"/></p>
</s:form>

</body>
</html>