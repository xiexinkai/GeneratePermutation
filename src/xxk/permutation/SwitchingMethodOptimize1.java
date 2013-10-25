package xxk.permutation;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SwitchingMethodOptimize1 {

	public static void main(String[] args) throws Exception{
		new SwitchingMethodOptimize1().go();
	}
	
	private static final int n=10;
	private static final int maxA=n;
	private char a[]=new char[n+1];
	private boolean p[]=new boolean[n];
	
	public void go() throws Exception{
		//init
		for(int i=0;i<n;i++){
			a[i]=(char)(i+97);
			p[i]=false;
		}
		a[n]='\n';
		//
		BufferedWriter fout=new BufferedWriter(new FileWriter("E:\\a.txt"));
		long start=System.currentTimeMillis();
		do{
			fout.write(a);
			
			//put N to left
			if(!p[n-1]&&a[n-1]==maxA){
				for(int i=n-1;i>=1;i--){
					char temp=a[i];a[i]=a[i-1];a[i-1]=temp;
					boolean tempp=p[i];p[i]=p[i-1];p[i-1]=tempp;
					fout.write(a);
				}
			}else if(p[0]&&a[0]==maxA){
				for(int i=0;i<n-1;i++){
					char temp=a[i];a[i]=a[i+1];a[i+1]=temp;
					boolean tempp=p[i];p[i]=p[i+1];p[i+1]=tempp;
					fout.write(a);
				}
			}
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
		char temp=a[pos];a[pos]=a[pos+k];a[pos+k]=temp;
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
