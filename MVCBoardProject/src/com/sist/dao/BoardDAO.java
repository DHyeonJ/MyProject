package com.sist.dao;
import java.io.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class BoardDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   // 초기화 블럭 => XML을 파싱 
	   try
	   {
		   // XML읽기
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   ssf=new SqlSessionFactoryBuilder().build(reader);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   // 목록 출력 
   public static List<BoardVO> boardListData(Map map)
   {
	   List<BoardVO> list=new ArrayList<BoardVO>();
	   // DBCP => 반환  ==> maxActive=8,maxIdle=8
	   SqlSession session=ssf.openSession();//getConnection();
	   list=session.selectList("boardListData",map);
	   session.close();// 반환 (disConnection())
	   return list;
	   //null
   }
   public static void boardInsert(BoardVO vo){
	   SqlSession session=ssf.openSession(true);
	   session.insert("boardInsert",vo);
	   //session.commit();
	   session.close();
   }
   static public BoardVO boardDetailData(int no){
	   BoardVO vo = new BoardVO();
	   SqlSession session = ssf.openSession();
	   session.update("hitIncrement",no);
	   session.commit();
	   vo=session.selectOne("boardDetailData",no);
	   session.close();
	   return vo;
   }
   // 총 페이지
   public static int boardTotalPage(){
	   int total=0;
	   //오라클 연결
	   SqlSession session= ssf.openSession();
	   total=session.selectOne("boardTotalPage");
	   //							id명
	   // session.selectOne("boardDetailData", no);
	   //							id명	   === parmeterType
	   //반환
	   session.close();
	   return total;
   }
   // 수정 데이터 읽기
// <select id="boardDetailData" resultType="BoardVO" parameterType="int">
   public static BoardVO boardUpdateData(int no){
	   BoardVO list = new BoardVO();
	   SqlSession session=ssf.openSession(); //getConnection()
	   list=session.selectOne("boardDetailData",no); //재사용
	   session.close(); //disConnection();
	   return list;
   }
   // 수정하기
   // <update id="boardUpdate" parameterType="BoardVO">
   public static boolean boardUpdate(BoardVO vo){
	   boolean bCheck  = false;
	   SqlSession session=ssf.openSession();
	   //DB에 있는 비밀번호 읽기
	   String db_pwd=session.selectOne("boardGetPwd",vo.getNo());
	   if(db_pwd.equals(vo.getPwd())){
		   bCheck=true;
		   session.update("boardUpdate",vo);
		   session.commit();
	   }
	   session.close();
	   return bCheck;
   }
   // 삭제하기
   //<delete id="boardDelete" parameterType="int">
   public static boolean boardDelete(int no,String pwd){
	   boolean bCheck  = false;
	   try{
	   SqlSession session=ssf.openSession();
	   //DB에 있는 비밀번호 읽기
	   String db_pwd=session.selectOne("boardGetPwd",no);
	   if(db_pwd.equals(pwd)){
		   bCheck=true;
		   session.delete("boardDelete",no);
		   session.commit();
	   }
	   session.close();
	   }catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   return bCheck;
   }
   // 검색하기(찾기)
   // <select id="boardFindData" resultType="BoardVO" parameterType="java.util.Map">
   public static List<BoardVO> boardFindData(Map map){
	   List<BoardVO> list= new ArrayList<BoardVO>();
	   SqlSession session = ssf.openSession();
	   list=session.selectList("boardFindData",map);
	   session.close();
	   return list;
   }

}








