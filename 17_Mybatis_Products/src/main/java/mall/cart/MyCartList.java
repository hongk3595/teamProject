package mall.cart;

import java.util.HashMap;
import java.util.Map;


public class MyCartList { //장바구니 역할
	//3번 상품 4개, 12번 상품 7개
	
	private Map<Integer, Integer> orderlists= null;
	
	public MyCartList() {
		orderlists = new HashMap<Integer, Integer>();
	}
	
	public void addOrder(int pnum, int oqty) {
		if(orderlists.containsKey(pnum)==false) {
			orderlists.put(pnum, oqty);
			
		}else {//장바구니에 해당 번호의 상품이 이미 있으면
			Integer value= orderlists.get(pnum);
			orderlists.put(pnum, oqty+value);
		}
	}
 
	public Map<Integer, Integer> getAllOrderLists() {
		return orderlists;
	}
	
}
