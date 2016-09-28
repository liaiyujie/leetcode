package ljt.bupt.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII_119 {

	public static void main(String[] args) {
		int rowIndex = 1000;
		long start = System.currentTimeMillis();
		List<Integer> re = getRow(rowIndex);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println(re);
	}
//	Each row is built in place, on top of the previous row, e.g. for k=3:
//
//		1 0 0 0 // before the for loop
//		1 1 0 0 // first iteration of outer loop, start inner loop at index 1: 0 + 1 = 1; done
//		1 2 1 0 // 2nd iteration of outer loop, start inner loop at index 2: 0 + 1 = 1; 1 + 1 = 2; done
//		1 3 3 1 // 3rd iteration of outer loop ...
	private static List<Integer> getRow(int rowIndex) {//最快的算法
		int[] row = new int[rowIndex + 1];
        row[0] = 1;
        for(int i=1; i<row.length; i++) {
            for(int j=i; j>=1; j--) {
                row[j] += row[j-1];
            }
        }
        List<Integer> retval = new ArrayList<>();
        for(int i : row) {
            retval.add(i);
        }
        return retval;
	}

	private static List<Integer> getRow3(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		if (rowIndex < 0)
			return list;

		for (int i = 0; i < rowIndex + 1; i++) {
			list.add(0, 1);
			for (int j = 1; j < list.size() - 1; j++) {
				list.set(j, list.get(j) + list.get(j + 1));
			}
		}
		return list;
	}

	private static List<Integer> getRow2(int rowIndex) {
		List<Integer> tmp1 = new ArrayList<>();
		List<Integer> tmp2 = new ArrayList<>();
		tmp1.add(1);
		tmp2.add(1);
		tmp2.add(1);
		if(rowIndex==0)
			return tmp1;
		else if(rowIndex==1)
			return tmp2;
		else{
			for(int i = 2; i< rowIndex+1;i++){
				if(i%2==0){
					tmp1.clear();
					for(int j = 0 ; j < tmp2.size()+1 ; j++){
						if(j==0||j==tmp2.size()){
							tmp1.add(1);
						}else{
							tmp1.add(tmp2.get(j-1)+tmp2.get(j));
						}
					}
				}else{
					tmp2.clear();
					for(int j = 0 ; j < tmp1.size()+1 ; j++){
						if(j==0||j==tmp1.size()){
							tmp2.add(1);
						}else{
							tmp2.add(tmp1.get(j-1)+tmp1.get(j));
						}
					}
				}
			}
		}
		if(rowIndex%2==0)
			return tmp1;
		return tmp2;
	}

	private static List<Integer> getRow1(int rowIndex) {//最慢的算法
		List<List<Integer>> re = generate(rowIndex+1);
		
		return re.get(rowIndex);
	}

	private static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows <=0){
            return triangle;
        }
        for (int i=0; i<numRows; i++){
            List<Integer> row =  new ArrayList<Integer>();
            for (int j=0; j<i+1; j++){
                if (j==0 || j==i){
                    row.add(1);
                } else {
                    row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
	}

}
