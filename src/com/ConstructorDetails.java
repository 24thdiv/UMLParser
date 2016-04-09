package com;
import java.util.ArrayList;

public class ConstructorDetails {

	private String name;
	private ArrayList<String> paramType;
	private ArrayList<String> paramId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getParamType() {
		return paramType;
	}
	public void setParamType(ArrayList<String> paramType) {
		this.paramType = paramType;
	}
	public ArrayList<String> getParamId() {
		return paramId;
	}
	public void setParamId(ArrayList<String> paramId) {
		this.paramId = paramId;
	}
	@Override
	public String toString() {
		return "ConstructorDetails [name=" + name + ", paramType=" + paramType + ", paramId=" + paramId + "]";
	}
	
	
}
