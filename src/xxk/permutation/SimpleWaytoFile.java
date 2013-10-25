package xxk.permutation;

import java.io.FileWriter;
import java.io.IOException;

public class SimpleWaytoFile{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SimpleWaytoFile().go();
	}

	public void go(){
		//init
		for(int i=0;i<n;i++){
			flag[i]=false;
		}
		//calculate time
		try{
			fout=new FileWriter("E://a.txt");
			long start=System.currentTimeMillis();
			dfs(0);
			long end=System.currentTimeMillis();
			System.out.println(end-start);
			fout.close();
		}catch(IOException e){
			
		}
	}
	
	private static final int n=10;
	private int array[]=new int[n];
	private boolean flag[]=new boolean[n];
	private FileWriter fout;
	
	private void dfs(int depth) throws IOException{
		if(depth>=n){
			for(int i=0;i<n;i++){
				fout.write(array[i]+" ");
			}
			fout.write("\n");
		}
		
		for(int i=0;i<n;i++){
			if(flag[i]){
				continue;
			}else{
				flag[i]=true;
				array[depth]=i+1;
				dfs(depth+1);
				flag[i]=false;
			}
		}
	}
	

}
