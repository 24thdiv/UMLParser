package com;
import java.util.ArrayList;

public class StatikClass {

	
	public static ArrayList<MethodDetails> methods = new ArrayList<MethodDetails>();
	public static ArrayList<FieldDetails> fields = new ArrayList<FieldDetails>();
	public static ArrayList<ConstructorDetails> cons = new ArrayList<ConstructorDetails>();
	
	
	public static ArrayList<ClassDetails> classes =  new ArrayList<ClassDetails>();
	
	
	public static ArrayList<ClassDetails> getClasses() {
		return classes;
	}
	public static void setClasses(ArrayList<ClassDetails> classes) {
		StatikClass.classes = classes;
	}
	public static ArrayList<MethodDetails> getMethods() {
		return methods;
	}
	public static void setMethods(ArrayList<MethodDetails> methods) {
		StatikClass.methods = methods;
	}
	public static ArrayList<FieldDetails> getFields() {
		return fields;
	}
	public static void setFields(ArrayList<FieldDetails> fields) {
		StatikClass.fields = fields;
	}
	public static ArrayList<ConstructorDetails> getCons() {
		return cons;
	}
	public static void setCons(ArrayList<ConstructorDetails> cons) {
		StatikClass.cons = cons;
	}
	

}
