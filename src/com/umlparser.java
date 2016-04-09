
package com;


import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.Node;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.TypeDeclaration;
import jdk.nashorn.internal.codegen.MethodEmitter;
import net.sourceforge.plantuml.SourceStringReader;


@SuppressWarnings("unused")
public class umlparser {
	
	
	 static int index=0;
	 static int[][] arrow;
	 static int[][] asso;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ParseException, IOException {

		//.java files
		
	if(args.length==2)
	{	
		
		 File curDir=null;
		
		try{
		 curDir= new File(args[0]);
		}
		catch(Exception e){
			System.out.println("Please enter correct directory");
		}
		
		File[] fils = curDir.listFiles((File pathname) -> pathname.getName().endsWith(".java"));
		
		if(fils.length>0)
		{	
			CompilationUnit coU[] = new CompilationUnit[fils.length];
			arrow = new int[fils.length][fils.length];	
			asso = new int[fils.length][fils.length];
		
			try
			{
				for (int i=0;i<fils.length;i++)
				{
				coU[i] = JavaParser.parse(fils[i]);
				new ClassVisitor().visit(coU[i], null);
				new MethodVisitor().visit(coU[i], null);
				new FieldVisitor().visit(coU[i],null);    
				new MethodCallVisitor().visit(coU[i], null);
		        new ConstructorVisitor().visit(coU[i],null);  
		        index++;	
				}
			}catch(Exception e){
			System.out.println("Exception : " + e.getMessage());
			e.printStackTrace();
			}finally{
			}
		
			//System.out.println(StatikClass.classes.toString());
			Generatepng gen = new Generatepng();
			String data = gen.generateoutputfile1();
			
			
			OutputStream pg = null;
			
			try{
				
				pg = new FileOutputStream(args[1]);
				
			}catch(FileNotFoundException e){
				System.out.println("PLease enter png file name");
			}
			
			SourceStringReader sr = new SourceStringReader(data);
			
			try{		
				String dest = sr.generateImage(pg);
			}catch(IOException e){
				e.printStackTrace();
			}
				
		}else{
			System.out.println("No Java files found");
		}	
		
	}
	else{
		
		System.out.println("PLease enter two argument");
		
	}
	   
	    
	    
	}
	
	
	
	
	
}       
	        
	        
	