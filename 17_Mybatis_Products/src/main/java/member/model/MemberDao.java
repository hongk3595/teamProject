package member.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utility.Paging;

@Service("myMemberDao")
public class MemberDao {
	
	private final String namespace = "member.model.Member";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate ;

	public MemberBean getMember(String id) {
		MemberBean login = null;
		login = sqlSessionTemplate.selectOne(namespace + ".getMember",id);
		System.out.println("MDAO login : " + login);
		return login;
	}

	public int registerMember(MemberBean mb) {
		int cnt = sqlSessionTemplate.insert(namespace+".registerMember",mb);
		return cnt;
	}

	public List<MemberBean> getMemberList(Map<String, String> map, Paging pageInfo) {
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());

		List<MemberBean> lists = sqlSessionTemplate.selectList(namespace + ".getMemberList", map, rowBounds);
		System.out.println("productsDao lists.size(): " + lists.size());
		return lists;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace + ".getTotalCount", map);
		return cnt;
	}

	public int updateMpoint(String memberId, int mpoint) {
		MemberBean mbean = new MemberBean();
		mbean.setId(memberId);
		mbean.setMpoint(mpoint);
		int cnt = sqlSessionTemplate.update(namespace + ".updateMpoint", mbean);
		return cnt;
		
	}
} 
