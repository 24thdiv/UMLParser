package com;
import java.util.ArrayList;
import java.util.List;

import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.visitor.VoidVisitorAdapter;

public class ConstructorVisitor extends VoidVisitorAdapter{

	@Override
	public void visit(ConstructorDeclaration con, Object o){
		
		ConstructorDetails tmpcosDept=new ConstructorDetails();
		String nam;
		ArrayList<String> tp = new ArrayList<String>();
		ArrayList<String> id = new ArrayList<String>();
		
		//get name of constructor
		nam=con.getName();	
		List<Parameter> typ = con.getParameters();
		if(typ!=null){
			for(Parameter tmp : typ)
			{
			//get parameter valued and type of constructor	
			tp.add(tmp.getType().toString());
			id.add(tmp.getId().toString());
							
			}	
		}
		// add to tmp
		tmpcosDept.setName(nam);
		tmpcosDept.setParamType(tp);
		tmpcosDept.setParamId(id);
		
		//add to cons arraylist.
	//	StatikClass.cons.add(tmpcosDept);
		 StatikClass.classes.get(umlparser.index).getConstruDetails().add(tmpcosDept);
		 	
		//System.out.println("coco");
		
	}
}
