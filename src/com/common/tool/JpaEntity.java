package com.common.tool;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

//@Entity
// 这里申明这个类为实例类
/*@IdClass(JpaEntity.MagazineId.class)
@EntityListeners( { Ajax.class, BarChart.class })
@SecondaryTable(name = "ART_DATA", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ART_ID", referencedColumnName = "ID"))
// 有时候一个逻辑上的记录被分散在多个数据库表中。通过SecondaryTable annotation可以指定entity class的secondary
// tables。通过column annotation的table属性来引用这些secondary tables。例如：
// 这里可以设置实例前的方法
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// InheritanceType.SINGLE_TABLE 策略为类的继承体系采用同一个表。表名是基类的名称
@DiscriminatorColumn(name = "Class", discriminatorType = DiscriminatorType.STRING)
@SqlResultSetMapping(name = "srsm1", entities = {
		@EntityResult(entityClass = Users.class),
		@EntityResult(entityClass = Users.class) })*/
public class JpaEntity {

	public static class MagazineId {
		// each identity field in the Magazine class must have a
		// corresponding field in the identity class
		private String isbn;
		private String title;

		public MagazineId() {
		}

		public MagazineId(String isbn, String title) {
			this.isbn = isbn;
			this.title = title;
		}

		/**
		 * Equality must be implemented in terms of identity field equality, and
		 * must use instanceof rather than comparing classes directly (some JPA
		 * implementations may subclass the identity class).
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof MagazineId)) {
				return false;
			}

			MagazineId rhs = (MagazineId) obj;
			boolean b1 = (isbn == rhs.isbn || (isbn != null && isbn
					.equals(rhs.isbn)));
			boolean b2 = (title == rhs.title || (title != null && title
					.equals(rhs.title)));
			return b1 && b2;
		}

		/**
		 * Hashcode must also depend on identity values.
		 */
		@Override
		public int hashCode() {
			int h1 = (isbn == null ? 0 : isbn.hashCode());
			int h2 = (title == null ? 0 : title.hashCode());
			return h1 ^ h2;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("isbn: " + isbn);
			sb.append(", title: " + title);
			return sb.toString();
		}
	}

	@PostLoad
	public static void PostLoad() {
		// photos=null;
		System.out
				.println("用这个annotation 标记的方法会在对象中所有eagerly fetched 字段被加载后调用。这个方法通常用来根据加载后的持久化字段的值更初始化非持久字段的值");
	}

	@PostPersist
	public static void PostPersist() {
		System.out
				.println("用这个annotation 标记的方法会在对象被持久化之后调用。这个方法可以用来在model被保存后更新view。");
	}

	@PostRemove
	public static void PostRemove() {
		System.out.println("用这个annotation 标记的方法会在对象被标记成已删除状态后调用。");
	}

	@PostUpdate
	public static void PostUpdate() {
		System.out
				.println("用这个annotation 标记的方法会在对象中持久字段值的改变被保存到datastore后调用。这个方法可以用来清空应用层的过期数据。");
	}

	@PrePersist
	public static void PrePersist() {
		System.out
				.println("用这个annotation 标记的方法会在对象被持久化之前调用。这个方法可以用来为持久化对象设置主键。");
	}

	@PreRemove
	public static void PreRemove() {
		System.out
				.println("用这个annotation 标记的方法会在对象经事务标记成已删除状态前调用。在这个方法中访问持久字段是合法的。在这个方法中，可以基于复杂的条件级联删除其它对象，或者做其它的清理工作。");
	}

	@PreUpdate
	public static void preUpdate() {
		System.out
				.println("用这个annotation 标记的方法会在对象中持久字段的值被flush到datastore前被调用。 这个方法通常用来根据非持久字段的值来设置持久字段。");
	}

	public static URL stringToURL(String s) {
		try {
			return new URL(s);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public static String urlToString(URL url) {
		return url.toExternalForm();
	}

	@Id
	@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String isbn;

	@Id
	// annotation用来指定identity字段
	private String title;

	@Transient
	// Transient annotation指定一个字段为non-persistent
	private byte[][] data;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.REFRESH, CascadeType.MERGE })
	private List<String> photos;

	//
	@JoinColumn(name = "fid", referencedColumnName = "fid")
/*	private Users userBean2;

	@OneToMany
	@JoinTable(name = "user", joinColumns = @JoinColumn(name = "isbn", referencedColumnName = "isbn"), inverseJoinColumns = @JoinColumn(name = "fid", referencedColumnName = "fid"))
	@OrderBy("fid")
	private Users userBean3;

	@Persistent
	//@org.apache.openjpa.persistence.Factory
	//@Factory("Externalization.stringToURL")
	// 指定根据external value初始化某个属性的方法名。
	// 如果指定static方法，那么这个方法必须返回这个属性类型的一个实例。这个方法可以接受StoreContext 类型的一个参数。
	@Externalizer("Externalization.urlToString")*/
	// annotation指定将某个属性转换为external
	// value的方法名。如果指定一个non-static方法，那么OpenJPA会假定目标对象是被Externalizer标记的属性对象
	private URL url;

	@Basic
	// basic annotation指定一个字段为persistent
	// @GeneratedValue(strategy = GenerationType.AUTO, generator="uuid-hex")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid-string")
	// •uuid-hex: 跟uuid-string一样，OpenJPA会生成128位的UUID，但是用32-character hexadecimal
	// string 表示。
	private String name;

	@TableGenerator(name = "tg1", table = "GenerationStrategyTable", pkColumnName = "id", valueColumnName = "sequence", allocationSize = 1)
	private long tableGeneratorValue;

	// 可嵌入实体bean
	@Embedded
//	private Users userBean;

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("isbn: " + isbn);
		sb.append(", title: " + title);
		return sb.toString();
	}

}
