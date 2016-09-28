package ljt.bupt.leetcode.bfs_dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HuaWeiJiShi {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		int[] score = new int[];
		
		while(true){
			ArrayList<Integer> score = new ArrayList<>();
			ArrayList<Integer> tmp = new ArrayList<>();
			int n = in.nextInt();
			int m = in.nextInt();
			
//			int[] score = new int[n+2];
			for(int i = 1 ; i<= n ; i++){
				score.add(in.nextInt());
			}
			in.nextLine();
			for(int i = 0 ; i< m ; i++){
				String opp = in.nextLine();
				String[] s = opp.split(" ");
				String C = s[0];
				int A = Integer.parseInt(s[1]);
				int B = Integer.parseInt(s[2]);
				if(C.equals("Q")&&(A<=0||B>n))
					continue;
				if(C.equals("U")&&(A<=0||A>n))
					continue;
				switch(C){
				case "Q":
					for(int j = A; j <=B ; j++ ){
						tmp.add(score.get(j-1));
					}
					int res = Collections.max(tmp);
					System.out.println(res);
					tmp.clear();
					break;
				case "U":
					score.set(A-1, B);
					break;
				default:
					break;
				}
				
			}
		}

	}

}
/*import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int M=0 ,N=0;
        int i;
        int A = 0,B = 0;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
                N = in.nextInt();
                M = in.nextInt();  
     
    //          System.out.println (N + " " + M);
                 
            int[] score = new int[N];
            for(i=0; in.hasNext() && i<N; i++){
                score[i] = in.nextInt();
    //          System.out.println (score[i] + " ");
            }
             
            String c = null;
             
            for(i=0; in.hasNext() && i< M; i++){
                c  = in.next();
                A = in.nextInt();
                B = in.nextInt();  
                process(c,A,B,score);
            }
        }
             
    }
 
    private static void process(String c, int a, int b, int[] score) {
        int begin,end;     
         
        if(c.equals("Q")){
            end = Math.max(a, b);
            begin = Math.min(a, b)-1;
            int max = score[begin];
            for(int i=begin;i<end;i++){
                if(max<score[i]){
                    max = score[i];
                }
            }
            System.out.println(max);
        }else if(c.equals("U")){
            score[a-1] = b;
        }
    }
}*/