package mainpage.Service;


import java.util.Map;
import mainpage.Member;

public interface MembershipService {
	public boolean comparePW(String pw, String pwOk);

	
	public boolean MembershipProc(Member member);
	public Map<String,String> getMember();
}
