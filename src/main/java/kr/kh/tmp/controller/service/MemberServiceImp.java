package kr.kh.tmp.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.tmp.controller.dao.MemberDAO;

@Service
public class MemberServiceImp  implements MemberService{

	@Autowired
	MemberDAO memberDAO;
}
