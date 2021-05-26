package spring5_webmvc_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthService {
	@Autowired
    private MemberDao memberDao;

    public AuthInfo authenicate(String email, String password) { //이메일과 비밀번호 인자로 받음.
        Member member = memberDao.selectByEmail(email); // memberDao를 통해 이메일을 검색.
        if (member == null) {	// 이메일 존재하는지 확인. 존재하지 않으면 익셉션 발생.
            throw new WrongIdPasswordException();
        }

        if (!member.matchPassword(password)) { // 패스워드 맞는지 확인 아니면 익셉션 발생
            throw new WrongIdPasswordException();
        }

        return new AuthInfo(member.getId(), member.getEmail(), member.getName()); //익셉션 발생하지 않았다면 회원정보?를 생성.
    }

}
