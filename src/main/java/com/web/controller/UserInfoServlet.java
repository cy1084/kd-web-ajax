package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/userInfo/*")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson=new Gson();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out= response.getWriter();
		List<String> list=new ArrayList<>();
		
		
		//1번째 경우
		list.add("번호1");
		//list.add("\"번호1\"");
		list.add("번호2");
		list.add("번호3");
		String json1="";
		for(String str:list) {
			json1+="\""+str+"\",";
		}
		json1+=json1.substring(0,json1.length()-1);
		out.print(list);
		
		//2번째 경우
		String json2="[";
		for(int i=1;i<=3;i++) {
			json2 +="\"번호"+i+"\","; //json 형태
		}
		json2=json2.substring(0,json2.length()-1);
		json2+="]";
		out.print(json2);
		
		
		//3번째 경우
		String json3=gson.toJson(list);
		out.print(json3);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
