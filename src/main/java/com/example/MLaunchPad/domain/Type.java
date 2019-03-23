package com.example.MLaunchPad.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Type {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long typeID;
	private String typeName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
	private List<toDo> toDos;
	
	public Type () {}
	
	public Type(String typeName) {
		super();
		this.typeName = typeName;
	}

	public long getTypeID() {
		return typeID;
	}

	public void setTypeID(long typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public List<toDo> gettoDos() {
		return toDos;
	}
	
	public void settoDos(List<toDo> toDos) {
		this.toDos = toDos;
	}

	@Override
	public String toString() {
		return "Type [typeID=" + typeID + ", typeName=" + typeName + "]";
	}
	
}
