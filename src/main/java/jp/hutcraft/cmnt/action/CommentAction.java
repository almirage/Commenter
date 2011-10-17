package jp.hutcraft.cmnt.action;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.hutcraft.cmnt.entity.Comment;
import jp.hutcraft.cmnt.form.CommentPostForm;
import jp.hutcraft.cmnt.service.CommentService;
import jp.hutcraft.common.util.DigestUtil;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.framework.util.StringUtil;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.URLEncoderUtil;

public class CommentAction {

	@ActionForm
	@Resource public CommentPostForm commentPostForm;
	@Resource protected CommentService commentService;
	@Resource protected HttpServletRequest httpServletRequest;
	@Resource protected HttpServletResponse httpServletResponse;
	
	@Execute(validator = false)
	public String index() {
		return "input.jsp";
	}
	
	@Execute(validate = "bisinessValidate", input = "index")
	public String post() {
		setCookies();
		final Comment comment = new Comment();
		comment.name = commentPostForm.name;
		comment.remoteHost = httpServletRequest.getRemoteAddr();
		comment.password = commentPostForm.password != null ? DigestUtil.toMD5(commentPostForm.password) : null;
		comment.tag = commentPostForm.tag;
		comment.url = commentPostForm.url;
		comment.comment = commentPostForm.comment;
		if (!StringUtil.isEmpty(comment.comment)) commentService.insert(comment);
		return String.format("%s?redirect=true", commentPostForm.url);
	}

	private void setCookies() {
		setCookie(new Cookie("name", URLEncoderUtil.encode(commentPostForm.name)));
		setCookie(new Cookie("delkey", URLEncoderUtil.encode(commentPostForm.password)));
	}
	private void setCookie(final Cookie cookie) {
		cookie.setPath("/");
		cookie.setMaxAge(60 * 60 * 24 * 90);	// Cookie有効期限は90日間
		httpServletResponse.addCookie(cookie);
	}

	@Execute(validator = false)
	public String test() {
		return "test.jsp";
	}

	public ActionMessages bisinessValidate() {
		final ActionMessages messages = new ActionMessages();
//		if (!StringUtil.isEmpty(commentPostForm.password) && commentPostForm.password.length() < 4) {
//			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.minlength", "password", "4"));
//		}
		if (StringUtil.isEmpty(commentPostForm.tag)) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.required", "tag"));
		}
		return messages;
	}
}
