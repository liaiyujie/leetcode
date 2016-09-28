package ljt.bupt.leetcode;

public class SumofTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 4;
		int b = -5;
		int result = getSum(a, b);
		System.out.println(result);
	}
	/*˼·��
	λ����
	����a=010010, b=100111, ��a^b = 110101, ���Եõ���ӦλΪ0,1��0,0��ӵĽ����������1,1��ӵ������
	��ô��Ҫ����ľ��1,1��ӵĶ�Ӧλ�����������ÿ������������
	a&b = 000010 ,˵�������ڶ�λ��Ӻ�������λ�����ǽ�λ�������������λ�ϣ���(a&b)<<1 ���Եõ�����λ�н�λ��
	���(a&b)<<1 Ϊ0�ˣ�˵���Ѿ�û�н�λ����a^b��Ϊa+b�Ľ����
	���(a&b)<<1��Ϊ0��˵���н�λ���������a^b��(a&b)<<1�Ľ�����������룬���������ϡ�
*/
	private static int getSum(int a, int b) {
		while (b > 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}

	private static int Add(int x, int y) {
		if (y == 0)
			return x;
		else
			return Add(x ^ y, (x & y) << 1);
	}
}
