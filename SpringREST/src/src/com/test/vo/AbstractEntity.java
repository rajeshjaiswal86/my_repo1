package com.test.vo;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Entity.findAll";
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
 
}