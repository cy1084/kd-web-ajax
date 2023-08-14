package com.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.vo.BoardInfoVO;


public interface BoardInfoDAO {
	List<BoardInfoVO> selectBoardInfoList(BoardInfoVO board);

	BoardInfoVO selectBoardInfo(int biNum);

	int insertBoardInfo(BoardInfoVO board);

	int updateBoardInfo(BoardInfoVO board);

	int deleteBoardInfo(int biNum);

	
}