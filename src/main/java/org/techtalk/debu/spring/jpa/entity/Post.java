package org.techtalk.debu.spring.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 *
@Table maps the entity with the table. If no @Table is defined, 
       the default value is used: the class name of the entity.
@Id declares the identifier property of the entity.
@Column maps the entity's field with the table's column. 
    If @Column is omitted, the default value is used: 
    the field name of the entity.
@OneToMany defines a one-to-many relationship between 2 entities.
@JoinColumn indicates the entity is the owner of the relationship: 
             the corresponding table has a column with a foreign key
              to the referenced table.
 */
@Entity
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pc_fid", referencedColumnName = "id")
	List<Comment> comments = new ArrayList<>();

	public Post() {

	}

	public Post(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}