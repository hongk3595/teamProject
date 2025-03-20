package orderdetail.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("myOrderDetail")
public class OrderDetailDao {
	private final String namespace = "orderdetail.model.OrderDetail"; // orderdetail.xml
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate ;

	public int insertOrderDetail(OrderDetailBean odBean) {
		int cnt = sqlSessionTemplate.insert(namespace + ".insertOrderDetail", odBean);
		return cnt;
	}
}