package com;
import java.util.ArrayList;
import java.util.List;

import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.visitor.GenericVisitorAdapter;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import net.sourceforge.plantuml.sequencediagram.teoz.MainTile;
import japa.parser.ast.body.VariableDeclarator;

public class FieldVisitor extends VoidVisitorAdapter {

	String get = "get";
	String set = "set";
	
	@Override
	public void visit(FieldDeclaration fld, Object o){
		
	
		
		String var,typ,variabl;
		int modi;
		FieldDetails tmpFidDet = new FieldDetails(null, null, null);	
		
		 var = fld.getVariables().get(0).toString();
		
		 if(var.contains(" =")){
			 variabl = var.substring(0,var.lastIndexOf("="));
		// System.out.println("result "+variabl);
		 }
		 else{
			 
			 variabl = var;
		 }
		
		 
		 
		// System.out.println("hello divya "+fld.getVariables());
		 typ = fld.getType().toString();
		 modi = fld.getModifiers();
		
		 
		 switch(modi)
		 {
		 case 1: 
		 		tmpFidDet.setModifier("public");
		 		tmpFidDet.setTye(typ);
		 		tmpFidDet.setVar(variabl);;
				//StatikClass.fields.add(tmpFidDet);
				StatikClass.classes.get(umlparser.index).getFieldDetails().add(tmpFidDet);
		 		break;
		 case 2:
			 	tmpFidDet.setModifier(checkgetset(variabl, typ, "private"));
				tmpFidDet.setTye(typ);
				tmpFidDet.setVar(variabl);;
				StatikClass.classes.get(umlparser.index).getFieldDetails().add(tmpFidDet);
				break;
			 
		 case 4: 
			 	tmpFidDet.setModifier("protected");
		 		tmpFidDet.setTye(typ);
		 		tmpFidDet.setVar(variabl);;
				//StatikClass.fields.add(tmpFidDet);
				StatikClass.classes.get(umlparser.index).getFieldDetails().add(tmpFidDet);
		 		break;
		 		
		 case 0:
			 	tmpFidDet.setModifier("default");
		 		tmpFidDet.setTye(typ);
		 		tmpFidDet.setVar(variabl);;
				//StatikClass.fields.add(tmpFidDet);
				StatikClass.classes.get(umlparser.index).getFieldDetails().add(tmpFidDet);
		 		break;
		 		
		default :
				//do nothing
		 		
		 }		 
	
		// System.out.println("Field");
		 
	}
	
	
	public String checkgetset(String var, String type, String modif){
		
		ArrayList<MethodDetails> me = StatikClass.classes.get(umlparser.index).getMethodDetails();
		
		MethodDetails getMet = null;
		MethodDetails setMet = null;
		
		boolean checkMethodname1 = false;
		boolean checkMethodname2 = false;
		String modi = modif;
		
	if(me!=null){	
		
	
		for(MethodDetails m : me){
			
			
			if(m.getModifier().equals("public")){
				
				
				
				
				if(checkMethodname1==false){
					checkMethodname1 = m.getName().equalsIgnoreCase(get.concat(var));
					if(checkMethodname1==true ){
						 getMet = m;
					}
				}
				
				if(checkMethodname2==false){	
					if(m.getParamType().size()==1){
						if(m.getParamType().get(0).equals(type)){
							checkMethodname2 = m.getName().equalsIgnoreCase(set.concat(var));
							if(checkMethodname2==true){
								 setMet = m;
							}
							
						}			
					}
				}
				
			
				if(checkMethodname1==true && checkMethodname2==true){
					modi = "public";
					
				}
				else{
					modi = "private";
				}
				
			}
			
		}
		
		
	}
	
	StatikClass.classes.get(umlparser.index).getMethodDetails().remove(getMet);
	StatikClass.classes.get(umlparser.index).getMethodDetails().remove(setMet);
	return modi;	
}
	
	
	
}
