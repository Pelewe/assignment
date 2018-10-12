package assignment;

import assignment.cmdRead.CmdRead;


public class Assignment {
	
	public static void main(String[] arg) {
		//READ INPUTS
		
		String Filename=arg[0];
		int firstId=Integer.parseInt(arg[1]);
		
		/*System.out.println(Filename);
		System.out.println(firstId);
		
		String Filename="C:\\Users\\Reverside\\Documents\\assignment\\sample_2.txt";
		int firstId=200;*/
		
		CmdRead read=new CmdRead();
		read.readFile(Filename,firstId);
		
	}

}
