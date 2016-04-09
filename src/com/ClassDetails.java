package com;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import javax.print.attribute.HashAttributeSet;

import japa.parser.ast.body.FieldDeclaration;

public class ClassDetails {

	public ClassDetails(String name, ArrayList<String> extd, ArrayList<String> imple, boolean isInterFace,
			boolean isabstract, ArrayList<MethodDetails> methodDetails, ArrayList<FieldDetails> fieldDetails,
			ArrayList<ConstructorDetails> construDetails, HashMap<String, String> methodCall) {
		super();
		this.name = name;
		this.extd = extd;
		this.imple = imple;
		this.isInterFace = isInterFace;
		this.isabstract = isabstract;
		this.methodDetails = methodDetails;
		this.fieldDetails = fieldDetails;
		this.construDetails = construDetails;
		this.methodCall=methodCall;
	}

	private String name;
	private ArrayList<String> extd;
	private ArrayList<String> imple;
	private boolean isInterFace;
	private boolean isabstract;
	private ArrayList<MethodDetails> methodDetails = new ArrayList<MethodDetails>();
	private ArrayList<FieldDetails> fieldDetails;
	private ArrayList<ConstructorDetails> construDetails;
	private HashMap<String, String> methodCall;
	
	
	public HashMap<String, String> getMethodCall() {
		return methodCall;
	}
	public void setMethodCall(HashMap<String, String> methodCall) {
		this.methodCall = methodCall;
	}
	public ArrayList<MethodDetails> getMethodDetails() {
		return methodDetails;
	}
	public void setMethodDetails(ArrayList<MethodDetails> methodDetails) {
		this.methodDetails = methodDetails;
	}
	public ArrayList<FieldDetails> getFieldDetails() {
		return fieldDetails;
	}
	public void setFieldDetails(ArrayList<FieldDetails> fieldDetails) {
		this.fieldDetails = fieldDetails;
	}
	public ArrayList<ConstructorDetails> getConstruDetails() {
		return construDetails;
	}
	public void setConstruDetails(ArrayList<ConstructorDetails> construDetails) {
		this.construDetails = construDetails;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getExtd() {
		return extd;
	}
	public void setExtd(ArrayList<String> extd) {
		this.extd = extd;
	}
	public ArrayList<String> getImple() {
		return imple;
	}
	public void setImple(ArrayList<String> imple) {
		this.imple = imple;
	}
	public boolean isInterFace() {
		return isInterFace;
	}
	public void setInterFace(boolean isInterFace) {
		this.isInterFace = isInterFace;
	}
	public boolean isIsabstract() {
		return isabstract;
	}
	public void setIsabstract(boolean isabstract) {
		this.isabstract = isabstract;
	}
	
	@Override
	public String toString() {
		return "ClassDetails [name=" + name + ", extd=" + extd + ", imple=" + imple + ", isInterFace=" + isInterFace
				+ ", isabstract=" + isabstract + ", \n methodDetails=" + methodDetails + ", \n fieldDetails=" + fieldDetails
				+ ", construDetails=" + construDetails + "]\n methodCall="+ methodCall+"]\n";
	}
	
	
	
	
	
}
