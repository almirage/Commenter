package jp.hutcraft.cmnt.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import jp.hutcraft.cmnt.entity.Comment;
import jp.hutcraft.cmnt.form.TagForm;
import jp.hutcraft.cmnt.service.CommentService;
import net.arnx.jsonic.JSON;

import org.seasar.framework.util.StringUtil;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

public class TagAction {

	@ActionForm
	@Resource TagForm tagForm;
	@Resource CommentService commentService;
	
	@Execute(validator = false)
	public String index() {
		if (StringUtil.isEmpty(tagForm.tag)) return null;
		final Integer limit = tagForm.limit;
		final List<Comment> comments = commentService.findByTag(tagForm.tag, limit == null ? 10 : limit);
		final List<ResponseCommentEntity> entities = createEntities(comments);
	    ResponseUtil.write(JSON.encode(entities), "text/javascript");
		return null;
	}
	private List<ResponseCommentEntity> createEntities(Iterable<Comment> comments) {
		final DateFormat df = new SimpleDateFormat("MM-dd HH:mm");
		final List<ResponseCommentEntity> r = new ArrayList<ResponseCommentEntity>();
		for (final Comment c : comments) {
			final ResponseCommentEntity entity = new ResponseCommentEntity();
			entity.id = c.id;
			entity.name = c.name;
			entity.comment = c.comment;
			entity.makeDate = df.format(c.makeDate);
			entity.url = c.url;
			r.add(entity);
		}
		return r;
	}
	
	public List<Comment> comments;
	@Execute(validator=false)
	public String list() {
		comments = commentService.findByTag(tagForm.tag, 100);
		return "list.jsp";
	}
	static class ResponseCommentEntity {
		public String id;
		public String name;
		public String comment;
		public String url;
		public String makeDate;
	}

}
