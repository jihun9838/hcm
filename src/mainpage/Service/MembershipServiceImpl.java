package mainpage.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mainpage.Member;
import mainpage.data.IMembershipManage;
import mainpage.data.IMembershipManageImpl;

public class MembershipServiceImpl implements MembershipService {
	private IMembershipManage membershipManager = new IMembershipManageImpl();
	
	@Override
	public boolean comparePW(String pw, String pwOk) {

		return pw.contentEquals(pwOk);
	}

	
	@Override
	public boolean MembershipProc(Member member) {
		return membershipManager.MembershipProc(member);
	}

	@Override
	public Map<String, String> getMember() {
		List<Member> lstmember = membershipManager.getMember();
		Map<String, String> mapmember = new HashMap<String, String>();
		
		for(Member member : lstmember)
			mapmember.put(member.getId(), member.getName());
		
		return mapmember;
	}

}











