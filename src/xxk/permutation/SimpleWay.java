package xxk.permutation;

/**
 * generate permutation, using dfs algorithm, using System.out to print;
 * @author xxk
 *
 */
public class SimpleWay{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SimpleWay().go();
	}

	public void go(){
		//init
		for(int i=0;i<n;i++){
			flag[i]=false;
		}
		//calculate time
		long start=System.currentTimeMillis();
		dfs(0);
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	private static final int n=8;
	private int array[]=new int[n];
	private boolean flag[]=new boolean[n];
	
	private void dfs(int depth){
		if(depth>=n){//--------print
			for(int i=0;i<n;i++){
				System.out.print(array[i]+" ");
			}
			System.out.println();
		}
		
		for(int i=0;i<n;i++){
			if(flag[i]){
				continue;
			}else{
				flag[i]=true;
				array[depth]=i;
				dfs(depth+1);
				flag[i]=false;
			}
		}
	}

}
