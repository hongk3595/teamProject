package mall.cart;

import java.util.HashMap;
import java.util.Map;


public class MyCartList { //��ٱ��� ����
	//3�� ��ǰ 4��, 12�� ��ǰ 7��
	
	private Map<Integer, Integer> orderlists= null;
	
	public MyCartList() {
		orderlists = new HashMap<Integer, Integer>();
	}
	
	public void addOrder(int pnum, int oqty) {
		if(orderlists.containsKey(pnum)==false) {
			orderlists.put(pnum, oqty);
			
		}else {//��ٱ��Ͽ� �ش� ��ȣ�� ��ǰ�� �̹� ������
			Integer value= orderlists.get(pnum);
			orderlists.put(pnum, oqty+value);
		}
	}
 
	public Map<Integer, Integer> getAllOrderLists() {
		return orderlists;
	}
	
}
