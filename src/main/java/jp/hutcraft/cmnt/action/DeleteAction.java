package jp.hutcraft.cmnt.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import jp.hutcraft.cmnt.entity.Comment;
import jp.hutcraft.cmnt.form.CommentDeleteForm;
import jp.hutcraft.cmnt.service.CommentService;
import jp.hutcraft.common.util.DigestUtil;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.framework.util.StringUtil;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class DeleteAction {

	@ActionForm
	@Resource protected CommentDeleteForm commentDeleteForm;
	@Resource protected CommentService commentService;
	@Resource protected HttpServletRequest httpServletRequest;
	
	@Execute(validate = "validate", input = "input")
	public String index() {
		if (StringUtil.isEmpty(commentDeleteForm.id)) return "input.jsp";
		final Comment comment = commentService.findById(commentDeleteForm.id);
		commentService.delete(comment);
		return String.format("%s?redirect=true", comment.url);
	}
	public ActionMessages validate() {
		final ActionMessages r = new ActionMessages();
		if (StringUtil.isEmpty(commentDeleteForm.id)) {
			r.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.required", "id"));
			return r;
		}

		final Comment comment = commentService.findById(commentDeleteForm.id);
		if (!StringUtil.isEmpty(commentDeleteForm.password)) { // パスワード入力されてる
			if (!DigestUtil.toMD5(commentDeleteForm.password).equals(comment.password)) {
				r.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.invalid", "削除キー"));
			}
		} else {
			final String cookiePassword = getPasswordByCookie();
			if (!StringUtil.isEmpty(cookiePassword)) {
				if (!DigestUtil.toMD5(cookiePassword).equals(comment.password)) {
					r.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.invalid", "削除キー"));
				}
			}
		}
		return r;
	}
	
	private String getPasswordByCookie() {
		for (final Cookie c : httpServletRequest.getCookies()) {
			if (c.getName().equals("delkey"))
				try {
					return URLDecoder.decode(c.getValue(), "UTF-8");
				} catch (final UnsupportedEncodingException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
		}
		return "";
	}
	
	public Comment comment;
	@Execute(validator = false)
	public String input() {
		comment = commentService.findById(commentDeleteForm.id);
		return "input.jsp";
	}
}
