package com;
import java.util.List;

public class FieldDetails {

	private String type;
	private String modifier;
	private String var;
	
	public FieldDetails(String type, String modifier, String var) {
		super();
		this.type = type;
		this.modifier = modifier;
		this.var = var;
	}
	public String getType() {
		return type;
	}
	public void setTye(String type) {
		this.type = type;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	@Override
	public String toString() {
		return "FieldDetails [type=" + type + ", modifier=" + modifier + ", var=" + var + "]";
	}
	
	
}
