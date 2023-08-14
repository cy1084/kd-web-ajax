package com.web.service.impl;

import java.util.List;

import com.web.dao.BoardInfoDAO;
import com.web.dao.impl.BoardInfoDAOImpl;
import com.web.service.BoardInfoService;
import com.web.vo.BoardInfoVO;


public class BoardInfoServiceImpl implements BoardInfoService {

	private BoardInfoDAO biDAO = new BoardInfoDAOImpl();
	

	@Override
	public List<BoardInfoVO> selectBoardInfoList(BoardInfoVO board) {
		return biDAO.selectBoardInfoList(board);
	}

	@Override
	public BoardInfoVO selectBoardInfo(int biNum) {

		return biDAO.selectBoardInfo(biNum);
	}

	@Override
	public int insertBoardInfo(BoardInfoVO board) {

		return biDAO.insertBoardInfo(board);
	}

	@Override
	public int updateBoardInfo(BoardInfoVO board) {

		return biDAO.updateBoardInfo(board);
	}

	@Override
	public int deleteBoardInfo(int biNum) {

		return biDAO.deleteBoardInfo(biNum);
	}

}
