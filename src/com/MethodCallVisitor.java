package com;

import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.visitor.VoidVisitorAdapter;

public class MethodCallVisitor extends VoidVisitorAdapter{

	

	 @Override
	    public void visit(MethodCallExpr exp, Object obj)
	    {
	       
	       if(exp.getScope()!=null)  
	        StatikClass.classes.get(umlparser.index).getMethodCall().put(exp.getScope().toString(), exp.getName());
	       
	       else
	    	   StatikClass.classes.get(umlparser.index).getMethodCall().put(StatikClass.classes.get(umlparser.index).getName(), exp.getName());
	        
	        
	        
	    }

	 

}
