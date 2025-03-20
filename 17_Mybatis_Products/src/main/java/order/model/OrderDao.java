package order.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("myOrderDao")
public class OrderDao {
	
	private String namespace = "order.model.Order";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate ;
	
	public int insertOrder(String memberId) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace + ".insertOrder",memberId);
		return cnt;
	}

	public int getMaxOid() {
		int maxOid = sqlSessionTemplate.selectOne(namespace + ".getMaxOid");
		
		return maxOid;
	}

	public List<OrderBean> orderMall(String id) {
		List<OrderBean> obean = sqlSessionTemplate.selectList(namespace+".orderMall",id);
		return obean;
	}
}
