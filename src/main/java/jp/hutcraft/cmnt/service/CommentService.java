package jp.hutcraft.cmnt.service;

import java.util.List;
import javax.annotation.Generated;
import jp.hutcraft.cmnt.entity.Comment;

import static jp.hutcraft.cmnt.entity.CommentNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link Comment}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.43", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2011/06/13 3:09:41")
public class CommentService extends AbstractService<Comment> {

	public List<Comment> findByUrl(String url) {
		return select().where(eq(url(), url)).orderBy(asc(makeDate())).getResultList();
	}

	public List<Comment> findByTag(final String tag, final int limit) {
		return select().where(eq(tag(), tag)).orderBy(desc(makeDate())).limit(limit).getResultList();
	}

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param id
     *            識別子
     * @return エンティティ
     */
    public Comment findById(String id) {
        return select().id(id).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<Comment> findAllOrderById() {
        return select().orderBy(asc(id())).getResultList();
    }
}