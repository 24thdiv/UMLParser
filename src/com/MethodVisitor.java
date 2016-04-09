package com;
import java.util.ArrayList;
import java.util.List;

import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.visitor.VoidVisitorAdapter;

public class MethodVisitor extends VoidVisitorAdapter {

	
	
	
	
	@Override
	public void visit(MethodDeclaration meth, Object o){
		
		MethodDetails tmpmetDet = new MethodDetails(null, null, null, null, null);
		String nam,rtype;
		int modi;
		ArrayList<String> tp = new ArrayList<String>();
		ArrayList<String> id = new ArrayList<String>();
		
		//get method name, modifier, return type
		nam = meth.getName().toString();
		modi = meth.getModifiers();
		rtype = meth.getType().toString();
		System.out.println(meth.getBody());
		//get method's all parameter and value
		List<Parameter> typ = meth.getParameters();
		
		if(typ!=null){
			for(Parameter tmp : typ)
			{
			//get parameter valued and type of method
			tp.add(tmp.getType().toString());
			id.add(tmp.getId().toString());
							
			}	
		}
		
		 switch(modi)
		 {
		 	case 1: 
			 	// public methods only
		 		 tmpmetDet.setModifier("public");
		 		 tmpmetDet.setName(nam);
				 tmpmetDet.setRtype(rtype);
				 tmpmetDet.setParamType(tp);
				 tmpmetDet.setParamId(id);
				// StatikClass.methods.add(tmpmetDet);

				 ArrayList<MethodDetails> met = new ArrayList<MethodDetails>();
				
				 ClassDetails cd =  StatikClass.classes.get(umlparser.index);
					met = 	 cd.getMethodDetails();
							met.add(tmpmetDet);
			 		
				 System.out.println("Done");
				 break;
			  	 
		 	case 9: //main method	 
		 		 tmpmetDet.setModifier("static");
		 		 tmpmetDet.setName(nam);
				 tmpmetDet.setRtype(rtype);
				 tmpmetDet.setParamType(tp);
				 tmpmetDet.setParamId(id);
				 
				 String[] stm = meth.getBody().getStmts().get(0).toString().split(" ");
				 FieldDetails f = new FieldDetails(stm[0], "default", stm[1]);
				 StatikClass.classes.get(umlparser.index).getFieldDetails().add(f);
				 
				// StatikClass.methods.add(tmpmetDet);
				 StatikClass.classes.get(umlparser.index).getMethodDetails().add(tmpmetDet);
				// System.out.println("Done");
			  	 break;
		 	
		 	case 1025:
		 		
		 	// public abstract methods only
		 		 tmpmetDet.setModifier("publicabt");
		 		 tmpmetDet.setName(nam);
				 tmpmetDet.setRtype(rtype);
				 tmpmetDet.setParamType(tp);
				 tmpmetDet.setParamId(id);
				// StatikClass.methods.add(tmpmetDet);

				  StatikClass.classes.get(umlparser.index).getMethodDetails().add(tmpmetDet);
					
			//	 System.out.println("Done");
				 
				 break;
			 	
		default :
				//do nothing
		 		
		 }	
	//	System.out.println("method");
				
	}
	
	
}
