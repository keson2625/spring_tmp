package kr.kh.tmp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.tmp.dao.PostDAO;
import kr.kh.tmp.model.vo.BoardVO;
import kr.kh.tmp.model.vo.MemberVO;
import kr.kh.tmp.model.vo.PostVO;

@Service
public class PostServiceImp implements PostService {

	@Autowired
	private PostDAO postDao;

	@Override
	public boolean insertBoard(String name) {
		try {
			return postDao.insertBoard(name);
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<BoardVO> getBoardList() {
		return postDao.selectBoardList();
	}

	@Override
	public boolean updateBoard(BoardVO board) {
		if(board == null) {
			return false;
		}
		
		try {
			return postDao.updateBoard(board);
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteBoard(int num) {
		return postDao.deleteBoard(num);
	}

	@Override
	public List<PostVO> getPostList(Integer bo_num) {
		return postDao.selectPostList(bo_num);
	}

	@Override
	public boolean insertPost(PostVO post, MemberVO user) {

		if(user == null || post == null) {
			return false;
		}
		
		post.setPo_me_id(user.getMe_id());
		
		boolean res = postDao.insertPost(post);
		//추후 첨부파일 등록
		
		return res;
	}

	@Override
	public void updateView(int po_num) {
		postDao.updateView(po_num);
		
	}

	@Override
	public PostVO getPost(int po_num) {
		return postDao.selectPost(po_num);
	}
}
