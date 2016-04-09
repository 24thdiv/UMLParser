package com;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;



public class ClassVisitor extends VoidVisitorAdapter {	

	@Override
	public void visit(ClassOrInterfaceDeclaration cla, Object arg){

		ClassDetails tmpClsDet = new ClassDetails(null, null, null, false, false, null, null, null,null);
		String nam;
		boolean isInterfc; 
		boolean isabstrac = false;
		ArrayList<String> extend = new ArrayList<String>();
		ArrayList<String> imple = new ArrayList<String>();
		
		// get class name and check interface
		nam = cla.getName();
		isInterfc = cla.isInterface();
		
		//get all extends and implements
		List<ClassOrInterfaceType> extn = cla.getExtends();
		List<ClassOrInterfaceType> imp = cla.getImplements();
		
		//add extend and implements in arraylist
		if(extn!=null){
			for(ClassOrInterfaceType ex : extn){
				extend.add(ex.getName());
			}
		}
		
		if(imp!=null){
			for(ClassOrInterfaceType im : imp){
				imple.add(im.getName());
			}
		}
		
		//add all in temp class object
		tmpClsDet.setName(nam);
		tmpClsDet.setInterFace(isInterfc);
		tmpClsDet.setIsabstract(isabstrac);
		tmpClsDet.setImple(imple);
		tmpClsDet.setExtd(extend);
		tmpClsDet.setFieldDetails(new ArrayList<FieldDetails>());
		tmpClsDet.setConstruDetails(new ArrayList<ConstructorDetails>());
		tmpClsDet.setMethodDetails(new ArrayList<MethodDetails>());
		tmpClsDet.setMethodCall(new HashMap<>());
		StatikClass.classes.add(tmpClsDet);
		//StatikClass.classes.add(tmpClsDet);
		
		
	//	System.out.println("Class added");
		
	}

}
