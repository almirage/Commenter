package jp.hutcraft.cmnt.form;

import org.seasar.struts.annotation.Required;

public class CommentPostForm {

	public String name;
	public String password;
	@Required
	public String url;
	public String comment;
	@Required
	public String tag;
	
}
