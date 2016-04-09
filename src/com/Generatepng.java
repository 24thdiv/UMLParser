package com;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import javafx.geometry.Side;

public class Generatepng {
		
public String generateoutputfile1(){
		
		String dataA="";
		String data = "@startuml\n";
		data+="skinparam classAttributeIconSize 0\n";
		ArrayList<String> classes = getAllClass();
		int in=0;
		String test="";
		
		for(ClassDetails cd : StatikClass.classes)
		{
			//System.out.println("classname:-"+cd.getName());
			if(cd.isInterFace())
				data+=cd.getName()+"<<interface>>\n";
			else if(cd.isIsabstract())
				data+=cd.getName()+"<<abstract>>\n";
			else data+="class "+cd.getName()+"\n";
			
			
			if(cd.getExtd().size()>0)
			{
				ArrayList<String> e = cd.getExtd();
				for(String ex : e)
					data+=cd.getName()+" --|> "+ex+"\n";	
			}
			
			if(cd.getImple().size()>0)
			{
				ArrayList<String> i = cd.getImple();
				for(String im : i)
					data+=cd.getName()+" ..|> "+im+"\n";	
			}
			
			
			
			
			if(cd.getMethodDetails().size()>0)
			{
				data+="class "+cd.getName()+"{\n";
		
				for(MethodDetails me : cd.getMethodDetails())
				{				
					if(me.getModifier().equals("static"))
					{
						data+="{static} ";
					}
					/*if(cd.isInterFace())
						data+="{abstract} ";*/
					if(me.getModifier().equals("publicabt"))
						data+="{abstract} ";
					
					data+="+"+me.getName()+"(";
					
					if(me.getParamId().size()>0 && me.getParamType().size()>0)
					{
						int index =0;	
						while(index < me.getParamId().size())
						{	
							if(index>0)
								data+=",";
							data+=me.getParamId().get(index)+" : "+me.getParamType().get(index);
							
							if(classes.indexOf(me.getParamType().get(index))!=-1 && cd.isInterFace()!=true)
							{
								//System.out.println("asssssssss"+cd.getName()+"----------->"+classes.get(classes.indexOf(me.getParamType().get(index))));
								umlparser.asso[in][classes.indexOf(me.getParamType().get(index))]=1;	
							}
							
							index++;
						}
							
					}
					
					data+=") : "+me.getRtype()+"\n";
						
				}
				
				data+="}\n";
				
			}
			
			
			
			if(cd.getConstruDetails().size()>0)
			{
				
				data+="class "+cd.getName()+"{\n";
				
				for(ConstructorDetails cos : cd.getConstruDetails())
				{
					
					data+="+"+cos.getName()+"(";
					
					if(cos.getParamId().size()>0 && cos.getParamType().size()>0)
					{
						int index =0;
						while(index < cos.getParamId().size())
						{
							if(index>0)
							{
								data+=",";
							}
							data+=cos.getParamId().get(index)+" : "+cos.getParamType().get(index);
							index++;
						}			
					}
					
					data+=")\n";
					
				}
				data+="}\n";
				
			}
			
			
			if(cd.getFieldDetails().size()>0)
			{
				data+="class "+cd.getName()+"{\n";
				
				for(FieldDetails fld : cd.getFieldDetails())
				{
					
					String gotclass="";
					int many=0;
					String collect="";
					if(fld.getType().contains(">"))
					{
						String variabl = fld.getType().substring(0,fld.getType().lastIndexOf(">"));
						String col[] = variabl.split("<");
						collect=col[1];			
					}
					
								int ar=0;
								for(ClassDetails cld : StatikClass.classes)
								{	
									if(fld.getType().equals(cld.getName()))
									{  
										gotclass = cld.getName(); 
										many=1;
										break;
									}
									else if(collect.contains(cld.getName())){
										gotclass = cld.getName();
										many=2;
										break;
									}
								ar++;
								}
								

								if(!gotclass.equals(""))
								   {
										if(many==1)
										{	if(!fld.getModifier().equals("default"))
											umlparser.arrow[in][ar]=1;
												   
										}else if(many==2){
											if(!fld.getModifier().equals("default"))
											umlparser.arrow[in][ar]=2;
											
										}
								   }
								   else{
									   	if(fld.getModifier().equals("public"))
									   		data+="+"+fld.getVar()+" : "+fld.getType()+"\n";
									   	else if(fld.getModifier().equals("private"))
									   		data+="-"+fld.getVar()+" : "+fld.getType()+"\n";
								   }
								
				}
				
				data+="}\n";
				
			}
			
			
			
			if(cd.getMethodCall().size()>0)
			{
				
				for(String mc : cd.getMethodCall().keySet())
				{
					for(FieldDetails f : cd.getFieldDetails())	
					{
						if(f.getVar().equals(mc))
							umlparser.asso[in][classes.indexOf(f.getType())]=1;	
							System.out.println("MEthodcall*******"+cd.getName()+"----->"+f.getType());
						
					}
					
				}
				
				
			}
			
			
		in++;	
		}
			
		for(int i=0;i<umlparser.arrow.length;i++)
		{
			for(int j=0; j<umlparser.arrow.length;j++)
			{
				System.out.print(umlparser.arrow[i][j]);
			}
		//	System.out.println("\n");
		}
		
		
		for(int i=0;i<umlparser.asso.length;i++)
		{
			for(int j=0; j<umlparser.asso.length;j++)
			{
				
				if(umlparser.asso[i][j]==1)
					test+=classes.get(i)+" ..> "+classes.get(j)+"\n";

			}
			
		}
		
		
		for(int i=0;i<umlparser.arrow.length;i++)
		{
			for(int j=i+1; j<umlparser.arrow.length;j++)
			{
				
				if(umlparser.arrow[i][j]==1)
				{
					if(umlparser.arrow[j][i]==1)
						test+=classes.get(i)+" \"1\" -- \"1\" "+classes.get(j)+"\n";
					else if(umlparser.arrow[j][i]==2)
						test+=classes.get(i)+" \"*\" -- \"1\" "+classes.get(j)+"\n";
					else
						test+=classes.get(i)+" -- \"1\" "+classes.get(j)+"\n";
				}
				else if(umlparser.arrow[i][j]==2){
					test+=classes.get(i)+" -- \"*\" "+classes.get(j)+"\n";
					
				}
				else{
					if(umlparser.arrow[j][i]==1)
						test+=classes.get(i)+" \"1\" -- "+classes.get(j)+"\n";
					else if(umlparser.arrow[j][i]==2)
						test+=classes.get(i)+" \"*\" -- "+classes.get(j)+"\n";
				}
				
			}
		}
		
		
		data+=dataA;
		data+=test;
		data+="@enduml";
		
		System.out.println(data);
		System.out.println("test::-- " + test);
	
		return data;
	}
	
	
	public ArrayList<String> getAllClass()
	{
		ArrayList<String> classes = new ArrayList<String>(); 
		
		for(ClassDetails c : StatikClass.classes)
		{
			classes.add(c.getName());
			
			
		}
		return classes;
		
	}
	
	
	
	
	
	

}
