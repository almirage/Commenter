package jp.hutcraft.cmnt.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link Comment}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.43", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2011/06/15 0:45:44")
public class CommentNames {

    /**
     * idのプロパティ名を返します。
     * 
     * @return idのプロパティ名
     */
    public static PropertyName<String> id() {
        return new PropertyName<String>("id");
    }

    /**
     * targetのプロパティ名を返します。
     * 
     * @return targetのプロパティ名
     */
    public static PropertyName<String> target() {
        return new PropertyName<String>("target");
    }

    /**
     * nameのプロパティ名を返します。
     * 
     * @return nameのプロパティ名
     */
    public static PropertyName<String> name() {
        return new PropertyName<String>("name");
    }

    /**
     * commentのプロパティ名を返します。
     * 
     * @return commentのプロパティ名
     */
    public static PropertyName<String> comment() {
        return new PropertyName<String>("comment");
    }

    /**
     * passwordのプロパティ名を返します。
     * 
     * @return passwordのプロパティ名
     */
    public static PropertyName<String> password() {
        return new PropertyName<String>("password");
    }

    /**
     * remoteHostのプロパティ名を返します。
     * 
     * @return remoteHostのプロパティ名
     */
    public static PropertyName<String> remoteHost() {
        return new PropertyName<String>("remoteHost");
    }

    /**
     * tagのプロパティ名を返します。
     * 
     * @return tagのプロパティ名
     */
    public static PropertyName<String> tag() {
        return new PropertyName<String>("tag");
    }

    /**
     * urlのプロパティ名を返します。
     * 
     * @return urlのプロパティ名
     */
    public static PropertyName<String> url() {
        return new PropertyName<String>("url");
    }

    /**
     * makeDateのプロパティ名を返します。
     * 
     * @return makeDateのプロパティ名
     */
    public static PropertyName<Timestamp> makeDate() {
        return new PropertyName<Timestamp>("makeDate");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _CommentNames extends PropertyName<Comment> {

        /**
         * インスタンスを構築します。
         */
        public _CommentNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _CommentNames(final String name) {
            super(name);
        }

        /**
         * インスタンスを構築します。
         * 
         * @param parent
         *            親
         * @param name
         *            名前
         */
        public _CommentNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * idのプロパティ名を返します。
         *
         * @return idのプロパティ名
         */
        public PropertyName<String> id() {
            return new PropertyName<String>(this, "id");
        }

        /**
         * targetのプロパティ名を返します。
         *
         * @return targetのプロパティ名
         */
        public PropertyName<String> target() {
            return new PropertyName<String>(this, "target");
        }

        /**
         * nameのプロパティ名を返します。
         *
         * @return nameのプロパティ名
         */
        public PropertyName<String> name() {
            return new PropertyName<String>(this, "name");
        }

        /**
         * commentのプロパティ名を返します。
         *
         * @return commentのプロパティ名
         */
        public PropertyName<String> comment() {
            return new PropertyName<String>(this, "comment");
        }

        /**
         * passwordのプロパティ名を返します。
         *
         * @return passwordのプロパティ名
         */
        public PropertyName<String> password() {
            return new PropertyName<String>(this, "password");
        }

        /**
         * remoteHostのプロパティ名を返します。
         *
         * @return remoteHostのプロパティ名
         */
        public PropertyName<String> remoteHost() {
            return new PropertyName<String>(this, "remoteHost");
        }

        /**
         * tagのプロパティ名を返します。
         *
         * @return tagのプロパティ名
         */
        public PropertyName<String> tag() {
            return new PropertyName<String>(this, "tag");
        }

        /**
         * urlのプロパティ名を返します。
         *
         * @return urlのプロパティ名
         */
        public PropertyName<String> url() {
            return new PropertyName<String>(this, "url");
        }

        /**
         * makeDateのプロパティ名を返します。
         *
         * @return makeDateのプロパティ名
         */
        public PropertyName<Timestamp> makeDate() {
            return new PropertyName<Timestamp>(this, "makeDate");
        }
    }
}