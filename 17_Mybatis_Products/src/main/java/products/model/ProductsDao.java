package products.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myProductsDao")
public class ProductsDao {

	private final String namespace = "product.model.Product";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate ;

	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace + ".getTotalCount", map);

		return cnt;
	}

	public List<ProductsBean> getProductsList(Map<String, String> map,Paging pageInfo) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());

		List<ProductsBean> lists = sqlSessionTemplate.selectList(namespace + ".getProductsList", map, rowBounds);
		System.out.println("productsDao lists.size(): " + lists.size());
		return lists;
	}

	public int insertProducts(ProductsBean pb) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace + ".insertProducts", pb);
		System.out.println("insert cnt : " + cnt);
		return cnt;
	}//insertProducts

	public ProductsBean getOneProduct(int num) {
		ProductsBean pb = sqlSessionTemplate.selectOne(namespace + ".getOneProduct", num); 
		return pb;
	}//getOneProduct

	public int updateProducts(ProductsBean products) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace + ".updateProducts",products);
		return cnt;
	}//updateProducts

	public int deleteProducts(int num) {
		System.out.println("deleteProducts");
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace + ".deleteProducts",num);
		return cnt;
	}//deleteProducts
	
	// 재고 수량 감소
	public int updateStock(int num, int qty) { 
		// update(String, Object)
		ProductsBean pb = new ProductsBean();
		pb.setNum(num);
		pb.setStock(qty);
		int cnt = sqlSessionTemplate.update(namespace+".updateStock",pb);
		return cnt;
	}
}


