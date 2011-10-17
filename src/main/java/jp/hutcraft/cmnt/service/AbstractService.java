package jp.hutcraft.cmnt.service;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.UUID;

import javax.annotation.Generated;

import org.seasar.extension.jdbc.service.S2AbstractService;

/**
 * サービスの抽象クラスです。
 * 
 * @param <ENTITY>
 *            エンティティの型 
 */
@Generated(value = {"S2JDBC-Gen 2.4.43", "org.seasar.extension.jdbc.gen.internal.model.AbstServiceModelFactoryImpl"}, date = "2011/06/13 3:09:41")
public abstract class AbstractService<ENTITY> extends S2AbstractService<ENTITY> {
//	protected LoginMemberDto loginMemberDto;
	public void insertBatch(final Iterable<ENTITY> entities) {
		for (final ENTITY e : entities) insert(e);
	}
	@Override
	public int insert(final ENTITY entity) {
		try {
			for (final Field f : entity.getClass().getFields()) {
				if ("id".equals(f.getName())) {
					f.set(entity, UUID.randomUUID().toString());
				}
				if ("makeDate".equals(f.getName())) {
					f.set(entity, new Timestamp(System.currentTimeMillis()));
				}
//				if ("makeUser".equals(f.getName())) {
//					if (loginMemberDto == null) {
//						f.set(entity, "");
//					} else {
//						f.set(entity, loginMemberDto.getMember().id);
//					}
//				}
			}
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
		return jdbcManager.insert(entity).excludesNull().execute();
	}
	@Override
	public int update(final ENTITY entity) {
		try {
			for (final Field f : entity.getClass().getFields()) {
				if ("editDate".equals(f.getName())) {
					f.set(entity, new Timestamp(System.currentTimeMillis()));
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return jdbcManager.update(entity).execute();
	}
	public void deleteBatch(final Iterable<ENTITY> items) {
		for (final ENTITY i : items) delete(i);
	}
}