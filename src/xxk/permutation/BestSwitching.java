package xxk.permutation;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BestSwitching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BestSwitching().go();
	}
	
	public static int MAX_LEN=10;

	public void go()
	{
		int i,n,count=0;;
		int dir[]=new int[MAX_LEN+1];
		int left[]=new int[MAX_LEN+1];
		int loc[]=new int[MAX_LEN+1];
		char result[]=new char[MAX_LEN+1];
		double dfm,dff,dft;
		
		try{
			BufferedWriter fout=new BufferedWriter(new FileWriter("E://a.txt"));
			n=MAX_LEN;
			for(i=0;i<=n;i++)
			{
				dir[i]=-1;
				left[i]=i-1;
				loc[i]=i-1;
				result[i]=(char)(97+i);
			}
			result[n]='\n';
			long start=System.currentTimeMillis();//---------------BEGIN!
			fout.write(result);
			count++;
			i=n;
			while(true)
			{
				if(left[i]==0)
				{
					while(left[i]==0)
						i--;
					if(left[i]==-1)
						break;
					else
					{
						char t=result[loc[i]+dir[i]];				
						result[loc[i]+dir[i]]=result[loc[i]];
						result[loc[i]]=t;
	
						loc[i]+=dir[i];
						loc[t-'a'+1]-=dir[i];
						count++;
	
						fout.write(result);
						for(left[i]--,i++;i<=n;i++)
						{
							left[i]=i-1;
							dir[i]=-dir[i];
						}
						i=n;
					}
				}
				else
				{
					char t=result[loc[i]+dir[i]];
					
					result[loc[i]+dir[i]]=result[loc[i]];
					result[loc[i]]=t;
					loc[i]+=dir[i];
					loc[t-'a'+1]-=dir[i];
					count++;
	
					fout.write(result);
					left[i]--;
				}
			}
	
			long end=System.currentTimeMillis();//---------END!
			System.out.println(end-start);
			fout.close();
		}catch(Exception e){
			
		}
	}

}
