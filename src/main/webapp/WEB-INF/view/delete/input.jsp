<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles" %>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"  value="コメント削除" />
<tiles:put name="content" type="string">
<tiles:put name="menu" value="/WEB-INF/view/common/menu.jsp" />

<h1>コメント削除</h1>

<html:errors />

<p>${f:h(comment.comment)} -- ${f:h(comment.name)} (<fmt:formatDate value="${comment.makeDate}" type="date" pattern="yyyy-MM-dd HH:mm:ss" />)</p>

<dl>
	<dt>コメント対象URL</dt>
	<dd>${f:h(comment.url)}</dd>
	<dt>コメント対象TAG</dt>
	<dd>${f:h(comment.tag)}</dd>
</dl>

<s:form>
<p>削除キー: <input type="password" name="password" value="${f:h(password)}" />
<input type="hidden" name="id" value="${f:h(comment.id)}" />
<input type="submit" name="index" value="削除する" />
</p>
</s:form>

</tiles:put>
</tiles:insert>
