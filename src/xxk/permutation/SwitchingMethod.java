package xxk.permutation;
import java.io.FileWriter;
import java.io.IOException;

public class SwitchingMethod {

	public static void main(String[] args) throws Exception{
		new SwitchingMethod().go();
	}
	
	private static final int n=10;
	private static final int maxA=n;
	private int a[]=new int[n];
	private boolean p[]=new boolean[n];
	
	public void go() throws Exception{
		//init
		for(int i=0;i<n;i++){
			a[i]=i+1;
			p[i]=false;
		}
		//
		FileWriter fout=new FileWriter("E://a.txt");
		long start=System.currentTimeMillis();
		do{
			//print
			for(int i=0;i<n;i++){
				//System.out.print(a[i]);
				fout.write(a[i]+" ");
			}
			//System.out.println();
			fout.write("\n");
			
		}while(move());
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		fout.close();
	}
	
	private boolean move(){
		int max=1;
		int pos=-1;
		for(int i=0;i<n;i++){
			if(a[i]<max)
				continue;
			if((p[i]&&i<n-1&&a[i]>a[i+1]) || (!p[i]&&i>0&&a[i]>a[i-1])){
				max=a[i];
				pos=i;
			}
		}
		if(pos==-1){//can not move, permutation shall end
			return false;
		}
		//swap
		int k=p[pos] ? 1 : -1;
		int temp=a[pos];a[pos]=a[pos+k];a[pos+k]=temp;
		boolean tempp=p[pos];p[pos]=p[pos+k];p[pos+k]=tempp;
		//change all direction which larger than max
		//if(max==n) return true;
		for(int i=0;i<n;i++){
			if(a[i]>max){
				p[i]=!p[i];
			}
		}
		return true;
	}
	
	
}//end Class
