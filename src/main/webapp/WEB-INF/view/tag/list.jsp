<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles" %>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"  value="コメント一覧" />
<tiles:put name="content" type="string">
<tiles:put name="menu" value="/WEB-INF/view/common/menu.jsp" />

<style type="text/css">
.paragraph {
	margin: 1em;
	padding: 0.5em;
	padding-left: 1em;
	background-color: #f0f0ff;
}
.comment {
	background-color: #fffff0;
	margin: 0.5em;
	padding: 0.5em;
	font-size: 120%;
}
.author {
	margin: 0.5em;
}
</style>

<h3>コメント一覧 [${f:h(tag)}]</h3>

<c:forEach var="c" items="${comments}">
<div class="paragraph">
	<p class="comment">${f:h(c.comment)}</p>
	<p class="author"><strong>${f:h(c.name)}</strong> (<fmt:formatDate value="${c.makeDate}" type="date" pattern="yyyy-MM-dd HH:mm" />) <a href="${f:h(c.url)}">${f:h(c.url)}</a></p>
</div>
</c:forEach>

</tiles:put>
</tiles:insert>
