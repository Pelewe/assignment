package assignment.cmdWrite;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CmdWrite {

	public void WriteTofile() {
		FileWriter out = null;
		
	/*	married=line;
		boolean isMarried;
		if(married=="Y") {
			isMarried=true;
		}
		else {
			isMarried=false;
		}
		
		out.write("insert into customers(id, first_name, last_name, gender, date_of_birth, marital_status) values("+id+", '"+fname+"','"+lname+"','"+gender+"','"+DOB+"','"+isMarried+"');"+"\n");
		*/
	}
	
	public void writeToFile(List<String> contents, FileWriter out) throws Exception{
		String id,fname,lname,gender,DOB;
		boolean isMarried=false;
		gender="";
		
		int length1=contents.get(1).length();
		int length2=contents.get(2).length();
		id=contents.get(0);
		lname=contents.get(1).substring(0,1).toUpperCase()+contents.get(1).substring(1,length1).toLowerCase();
		fname=contents.get(2).substring(0,1).toUpperCase()+contents.get(2).substring(1,length2).toLowerCase();
		
		
	
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-mm-dd");
		SimpleDateFormat simple2 = new SimpleDateFormat("dd/MM/YYYY");
		Date date= simple.parse(contents.get(3));
				
		DOB=simple2.format(date);
				
		if(contents.get(4)=="Married") {
			isMarried=true;
		}
		if(contents.get(5)=="Male") {
			gender="M";
		}
		else {
			gender="F";
		}
		out.write("insert into customers(id, first_name, last_name, gender, date_of_birth, marital_status) values("+id+", '"+fname+"','"+lname+"','"+gender+"','"+DOB+"','"+isMarried+"');"+"\n");
		
	}
}
