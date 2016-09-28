package ljt.bupt.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {

	public static void main(String[] args) {
		int numRows = 5;
		List<List<Integer>> re = generate(numRows);
		for(List li : re){
			System.out.println(li);
		}
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

	private static List<List<Integer>> generate2(int numRows) {
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<numRows;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
	}

	private static List<List<Integer>> generate1(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		if(numRows == 0){
			return res;
		}else if(numRows == 1 ){
			List<Integer> list = new ArrayList<>();
			list.add(1);
			res.add(list);
		}else if(numRows == 2){
			List<Integer> list1 = new ArrayList<>();
			list1.add(1);
			res.add(list1);
			
			List<Integer> list2 = new ArrayList<>();
			list2.add(1);
			list2.add(1);
			res.add(list2);
		}else{
			List<Integer> list1 = new ArrayList<>();
			list1.add(1);
			res.add(list1);
			
			List<Integer> list2 = new ArrayList<>();
			list2.add(1);
			list2.add(1);
			res.add(list2);
			
			
			for(int i = 2 ; i< numRows ; i++){
				List<Integer> tmp = res.get(i-1);
				List<Integer> re  = new ArrayList<>();
				re.add(1);
				for(int j = 0 ; j < tmp.size()-1 ; j++){
					Integer hh = tmp.get(j) + tmp.get(j+1);
					re.add(hh);
				}
				re.add(1);
				res.add(re);
			}
		}
		
		return res;
	}

}
