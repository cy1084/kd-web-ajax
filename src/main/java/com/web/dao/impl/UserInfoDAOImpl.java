package com.web.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.common.MybatisConfig;
import com.web.dao.UserInfoDAO;
import com.web.vo.UserInfoVO;

public class UserInfoDAOImpl implements UserInfoDAO {

	@Override
	public List<UserInfoVO> selectUserInfoList(SqlSession session, UserInfoVO user) {

		return session.selectList("com.web.mapper.UserInfoMapper.selectUserInfo", user);
	}

	@Override
	public UserInfoVO selectUserInfo(SqlSession session, int uiNum) {
		return session.selectOne("com.web.mapper.UserInfoMapper.selectUserInfo", uiNum);
	}

	@Override
	public int insertUserInfo(SqlSession session, UserInfoVO user) {
		return session.insert("com.web.mapper.UserInfoMapper.inserttUserInfo", user);
	}

	@Override
	public int updateUserInfo(SqlSession session, UserInfoVO user) {
		return session.update("com.web.mapper.UserInfoMapper.updateUserInfo", user);
	}

	@Override
	public int deleteUserInfo(SqlSession session, UserInfoVO user) {
		return session.delete("com.web.mapper.UserInfoMapper.deleteUserInfo", user);
	}

	public static void main(String[] args) {
		try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession()) {
			UserInfoDAO uiDAO = new UserInfoDAOImpl();
			
			List<UserInfoVO> userList = uiDAO.selectUserInfoList(session, null);
			for (UserInfoVO user : userList) {
				System.out.println(user);
			}

			UserInfoVO user = uiDAO.selectUserInfo(session, 1);
			System.out.println(user);
			//user.setUiId("dao");
			//int result = uiDAO.insertUserInfo(session, user);
			//System.out.println(result);
			
			user.setUiName("변경");
			int result = uiDAO.updateUserInfo(session, user);
			System.out.println(result);
			session.commit();
		}
	}

}
