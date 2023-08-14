package com.web.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.web.vo.UserInfoVO;

public class MybatisConfig {
	private static SqlSessionFactory SSF;
	private final static String CONFIG_PATH = "config/mybatis-config.xml";

	// 메인 메소드 실행 전에 실행- static
	static {
		try {
			InputStream is= Resources.getResourceAsStream(CONFIG_PATH);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SSF = ssfb.build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return SSF;
	}

	public static void main(String[] args) {
		try (SqlSession session = getSqlSessionFactory().openSession(true)) {
			List<UserInfoVO> list = session.selectList("com.web.mapper.UserInfoMapper.selectUserInfoList");
			// com.web.mapper.namespace.id
			for (UserInfoVO userInfo : list) {
				System.out.println(userInfo);
			}
			UserInfoVO user=session.selectOne("com.web.mapper.UserInfoMapper.selectUserInfo",uiNum);

		} catch (Exception e) {
			throw e;
		}

	}

}
