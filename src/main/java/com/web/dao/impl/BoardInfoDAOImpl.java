package com.web.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.common.MybatisConfig;
import com.web.dao.BoardInfoDAO;
import com.web.vo.BoardInfoVO;

public class BoardInfoDAOImpl implements BoardInfoDAO {

	@Override
	public List<BoardInfoVO> selectBoardInfoList(BoardInfoVO board) {
		try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession()) {
			return session.selectList("com.web.mapper.BoardInfoMapper.selectBoardInfo", board);
		}
	}

	@Override
	public BoardInfoVO selectBoardInfo(int biNum) {
		try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
			return session.selectOne("com.web.mapper.BoardInfoMapper.selectBoardInfo",biNum);
		}
	}

	@Override
	public int insertBoardInfo(BoardInfoVO board) {
		try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
			return session.selectOne("com.web.mapper.BoardInfoMapper.insertBoardInfo", board);
		}
	}

	@Override
	public int updateBoardInfo(BoardInfoVO board) {
		try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
			return session.selectOne("com.web.mapper.BoardInfoMapper.updateBoardInfo", board);
		}
	}

	@Override
	public int deleteBoardInfo(int biNum) {
		try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
			return session.selectOne("com.web.mapper.BoardInfoMapper.deleteBoardInfo", biNum);
		}
	}
}
