package assignment.cmdRead;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import assignment.cmdWrite.CmdWrite;


public class CmdRead {
	
	public void readFile(String filename, int startid) {
		
		
		if(filename.contains("1")) {
			readSample1Style(filename, startid);
		}
		else if(filename.contains("2")){
			readSample2Style(filename, startid);
		}
		else {
			readSample3Style(filename, startid);
		}
	
	}
	
	public void readSample1Style(String filename,int startid) {
		String file=filename;
		String line="";
		int id=startid;
		String find="";
		int end=0;
		String fname,lname,gender,DOB,married;

		FileWriter out = null;
		
		try {
			
			FileReader fileReader=new FileReader(file);
			BufferedReader bufferReader=new BufferedReader(fileReader);
			
			filename=filename.substring(0,filename.length()-4);
			out = new FileWriter(filename+".sql");
		
			while((line=bufferReader.readLine()) != null) {
				
				
				//find space and set lname
				find=" ";
				end=line.indexOf(find);
				lname=line.substring(0,end);
				line=line.substring(end+1,line.length());
			
				//set fname
				find=",";
				end=line.indexOf(find);
				fname=line.substring(0,end);
				line=line.substring(end+2,line.length());
					
				
				//set gender
				end=line.indexOf(find);
				gender=line.substring(0,end);
				line=line.substring(end+2,line.length());
				
				//set date
				end=line.indexOf(find);
				DOB=line.substring(0,end);
				line=line.substring(end+2,line.length());
				
				//set marrige status
				married=line;
				boolean isMarried;
				if(married=="Y") {
					isMarried=true;
				}
				else {
					isMarried=false;
				}
				
				out.write("insert into customers(id, first_name, last_name, gender, date_of_birth, marital_status) values("+id+", '"+fname+"','"+lname+"','"+gender+"','"+DOB+"','"+isMarried+"');"+"\n");
				
				System.out.println(id+" "+lname+" "+fname+" "+gender+' '+DOB+' '+married);
				
				id++;
			}
			out.close();
			bufferReader.close();
			
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file, File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readSample2Style(String filename,int startid){
		String line=null, temp="";
		int index=0;
		List<String> contents=new ArrayList<>();
	    int counter=startid;
	    CmdWrite write=new CmdWrite();
	    
	     try {
	    	 BufferedReader bufferReader=new BufferedReader(new FileReader(filename));
	    	 filename=filename.substring(0,filename.length()-4);
	    	 FileWriter out = new FileWriter(filename+".sql");
	    	 
	    	 while((line=bufferReader.readLine())!=null) {
	    		 contents.clear();
	    		 
	    		 
	    		 contents.add(String.valueOf(counter));
	    		 for(int i=1;i<5 ;i++) {
	    			 index=line.indexOf("|");
	    			 temp=line.substring(1,index-1);
	    			 contents.add(temp);
	    			
	    			 line=line.substring(index+1,line.length()-1);
	    			
	    		 }
	    		
	    		 
	    		 contents.add(line.substring(1,line.length()));
	    		 try {	
	    			 write.writeToFile(contents, out);
	    			 }
	    		 catch ( Exception e) {
	    			 System.out.println("Unable to parse and format dates");
	    			 }
	    		 
	    		 counter++;
	    	 }
	    	 bufferReader.close();
    		 out.close();
	     }
	     catch( IOException ex) {
	 		System.out.println("File does not exist");
	 	} 
	}
	


	      
		

	public void readSample3Style(String filename,int startid) {
		String line=null, temp="";
		int index=0;
		List<String> contents=new ArrayList<>();
	    int counter=startid;
	    CmdWrite write=new CmdWrite();
	    
	     try {
	    	 BufferedReader bufferReader=new BufferedReader(new FileReader(filename));
	    	 filename=filename.substring(0,filename.length()-4);
	    	 FileWriter out = new FileWriter(filename+".sql");
	    	 
	    	 while((line=bufferReader.readLine())!=null) {
	    		 contents.clear();
	    		 
	    		 
	    		 contents.add(String.valueOf(counter));
	    		 for(int i=1;i<5 ;i++) {
	    			 index=line.indexOf("|");
	    			 temp=line.substring(1,index-1);
	    			 contents.add(temp);
	    			
	    			 line=line.substring(index+1,line.length()-1);
	    			
	    		 }
	    		
	    		 
	    		 contents.add(line.substring(1,line.length()));
	    		 try {	
	    			 write.writeToFile(contents, out);
	    			 }
	    		 catch ( Exception e) {
	    			 System.out.println("Unable to parse and format dates");
	    			 }
	    		 
	    		 counter++;
	    	 }
	    	 bufferReader.close();
    		 out.close();
	     }
	     catch( IOException ex) {
	 		System.out.println("File does not exist");
	 	} 
	}
}

