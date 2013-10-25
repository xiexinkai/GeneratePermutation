package xxk.permutation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CopyFiles().go();
	}
	
	public void go(){
		try{
			BufferedReader fin=new BufferedReader(new FileReader("E://a.txt"));
			FileWriter fout=new FileWriter("E://b.txt");
			String str;
			long start=System.currentTimeMillis();
			while((str=fin.readLine())!=null){
				fout.write(str+"\n");
			}
			long end=System.currentTimeMillis();
			System.out.println(end-start);
			fin.close();
			fout.close();
		}catch(IOException e){
			
		}
	}

}
