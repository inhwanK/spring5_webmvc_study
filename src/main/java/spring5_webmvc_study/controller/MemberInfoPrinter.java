package spring5_webmvc_study.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter printer;

	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			throw new MemberNotFoundException("데이터 없음\n");
		}
		printer.print(member);
		System.out.println();
	}

//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
//
//	public void setPrinter(MemberPrinter printer) {
//		this.printer = printer;
//	}

}
