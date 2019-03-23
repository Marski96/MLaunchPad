package com.example.MLaunchPad.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class toDo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String info;
	private String time;
	private String location;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "typeID")
	private Type type;

	public toDo() {}
	
	public toDo(long id, String info, String time, String location, Type type) {
		
		this.id = id;
		this.info = info;
		this.time = time;
		this.location = location;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		if(this.type != null)
			
		return "toDo [type=" + this.getType() + ", info=" + info + ", time=" + time + ", location=" + location
				+ "]";	
		
		else
		
		return "toDo [info=" + info + ", time=" + time + ", location=" + location
				+ "]";
	}
}
