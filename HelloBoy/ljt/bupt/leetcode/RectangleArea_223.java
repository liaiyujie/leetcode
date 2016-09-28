package ljt.bupt.leetcode;

public class RectangleArea_223 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = computeArea(-3,0,3,4,0,-1,9,2);
		System.out.println(res);
	}
//	public int ComputeArea(int A, int B, int C, int D, int E, int F, int G, int H) {//很巧妙的解法
//        var a = Math.Max(A, E);
//            var b = Math.Max(B, F);
//            var c = Math.Min(C, G);
//            var d = Math.Min(D, H);
//            var total = (C - A) * (D - B) + (G - E) * (H - F);
//            if (c > a && d > b)
//                total -= (c - a) * (d - b);
//            return total;
//    }
	private static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {//很巧妙的解法
		 int rectOne = (C - A) * (D - B);
	        int rectTwo = (G - E) * (H - F);
	        
	        if(A >= G || B >= H || C <= E || D <= F){//左下和右上的点比较
	            return rectOne + rectTwo;
	        }
	        //得出重合面积的值
	        int length = Math.min(C, G) - Math.max(A, E);
	        int height = Math.min(D, H) - Math.max(B, F);
	        
	        return rectOne + rectTwo - length * height;
	}
	private static int computeArea1(int A, int B, int C, int D, int E, int F, int G, int H) {//很笨的解法，解到最后自己会绕进去
		//兩個矩陣是重合的
		if(A>=E&&B>=F&&C<=G&&D<=H){
			return (G-E)*(H-F);
		}
		if(A<=E&&B<=F&&C>=G&&D>=H){
			return (C-A)*(D-B);
		}
		int s1 = (C-A)*(D-B);
		int s2 = (G-E)*(H-F);
		//監測兩個矩陣是否是分開的
		
		if((G-A)>=(C-A)+(G-E)||(D-F)>=(D-B)+(H-F)){
			return s1+s2;
		}
		if((C-E)>=(C-A)+(G-E)||(H-B)>=(D-B)+(H-F)){
			return s1+s2;
		}
		//兩個矩陣重合
		if((G-A)<(C-A)+(G-E)){
			int s3 = (C-E)*(H-B);
			return s1+s2-s3;
		}
		if((C-E)<(C-A)+(G-E)){
			int s3 = (G-E)*(D-F);
			return s1+s2-s3;
		}
		return 0;
	}

}
