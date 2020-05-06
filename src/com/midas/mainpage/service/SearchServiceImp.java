package mainpage.Service;

import mainpage.Member;
import mainpage.data.IMembershipManage;
import mainpage.data.IMembershipManageImpl;

public class SearchServiceImp implements SearchService{
	private IMembershipManage imemManage = new IMembershipManageImpl();
	
	@Override
	public boolean MembershipProc(Member member) {
		// TODO Auto-generated method stub
		return imemManage.MembershipProc(member);
	}

	

}








