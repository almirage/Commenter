package jp.hutcraft.cmnt.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Commentエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.43", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2011/06/15 0:45:40")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /** idプロパティ */
    @Id
    @Column(length = 2147483647, nullable = false, unique = true)
    public String id;

    /** targetプロパティ */
    @Column(length = 2147483647, nullable = false, unique = false)
    public String target;

    /** nameプロパティ */
    @Column(length = 2147483647, nullable = false, unique = false)
    public String name;

    /** commentプロパティ */
    @Column(length = 2147483647, nullable = false, unique = false)
    public String comment;

    /** passwordプロパティ */
    @Column(length = 2147483647, nullable = false, unique = false)
    public String password;

    /** remoteHostプロパティ */
    @Column(length = 2147483647, nullable = false, unique = false)
    public String remoteHost;

    /** tagプロパティ */
    @Column(length = 2147483647, nullable = false, unique = false)
    public String tag;

    /** urlプロパティ */
    @Column(length = 2147483647, nullable = false, unique = false)
    public String url;

    /** makeDateプロパティ */
    @Column(nullable = false, unique = false)
    public Timestamp makeDate;
}