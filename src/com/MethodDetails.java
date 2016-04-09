package com;
import java.util.ArrayList;

public class MethodDetails {

	public MethodDetails(String name, String modifier, String rtype, ArrayList<String> paramType,
			ArrayList<String> paramId) {
		super();
		this.name = name;
		this.modifier = modifier;
		this.rtype = rtype;
		this.paramType = paramType;
		this.paramId = paramId;
	}
	private String name;
	private String modifier;
	private String rtype;
	private ArrayList<String> paramType;
	private ArrayList<String> paramId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
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
		return "MethodDetails [name=" + name + ", modifier=" + modifier + ", rtype=" + rtype + ", paramType="
				+ paramType + ", paramId=" + paramId + "]";
	}
	
	
}
