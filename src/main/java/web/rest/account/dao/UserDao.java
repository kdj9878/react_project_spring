package web.rest.account.dao;

import java.util.List;
import java.util.Map;

public interface UserDao {
	

	//로그인 시 실행되는 메소드
	public Map<String, Object> searchUserById(Map<String, Object> param);

	//유저 리스트를 가져오는 메소드
	public List<Map<String, Object>> getUserList();

	//회원 정보 수정 메소드
	public int modUserInfo(Map<String, Object> params);


}
