package com.web.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.common.MybatisConfig;
import com.web.dao.UserInfoDAO;
import com.web.dao.impl.UserInfoDAOImpl;
import com.web.service.UserInfoService;
import com.web.vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoDAO uiDAO = new UserInfoDAOImpl();
	// UserInfoDAO는 UserInfoDAOImpl에 대해 의존성을 가지고 있다.(삭제되면 오류)

	@Override
	public List<UserInfoVO> selectUserInfoList(UserInfoVO user) {
		try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession()) {
			return uiDAO.selectUserInfoList(session, null);
		}
	}

	@Override
	public UserInfoVO selectUserInfo(int uiNum) {

		return null;
	}

	@Override
	public int insertUserInfo(UserInfoVO user) {

		return 0;
	}

	@Override
	public int updateUserInfo(UserInfoVO user) {

		return 0;
	}

	@Override
	public int deleteUserInfo(UserInfoVO user) {

		return 0;
	}

}
