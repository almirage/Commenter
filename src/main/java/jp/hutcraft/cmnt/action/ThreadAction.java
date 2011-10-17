package jp.hutcraft.cmnt.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import jp.hutcraft.cmnt.entity.Comment;
import jp.hutcraft.cmnt.service.CommentService;
import net.arnx.jsonic.JSON;

import org.seasar.framework.util.StringUtil;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

public class ThreadAction {
	
//	@ActionForm @Resource ThreadForm threadForm;
	@Resource CommentService commentService;
	@Resource HttpServletResponse httpServletResponse;

	public String url;
	
	@Execute(validator = false)
	public String index() {
		if (StringUtil.isEmpty(url)) return null;
		final List<Comment> comments = commentService.findByUrl(url);
	    final List<ResponseCommentEntity> entities = createEntities(comments);
	    ResponseUtil.write(JSON.encode(entities), "text/javascript");
	    return null;
	}
	private List<ResponseCommentEntity> createEntities(Iterable<Comment> comments) {
		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		final List<ResponseCommentEntity> r = new ArrayList<ResponseCommentEntity>();
		for (final Comment c : comments) {
			final ResponseCommentEntity entity = new ResponseCommentEntity();
			entity.id = c.id;
			entity.name = c.name;
			entity.comment = c.comment;
			entity.makeDate = df.format(c.makeDate);
			r.add(entity);
		}
		return r;
	}
	static class ResponseCommentEntity {
		public String id;
		public String name;
		public String comment;
		public String makeDate;
	}
}
