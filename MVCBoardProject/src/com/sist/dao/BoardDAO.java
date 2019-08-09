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
	   // �ʱ�ȭ �� => XML�� �Ľ� 
	   try
	   {
		   // XML�б�
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   ssf=new SqlSessionFactoryBuilder().build(reader);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   // ��� ��� 
   public static List<BoardVO> boardListData(Map map)
   {
	   List<BoardVO> list=new ArrayList<BoardVO>();
	   // DBCP => ��ȯ  ==> maxActive=8,maxIdle=8
	   SqlSession session=ssf.openSession();//getConnection();
	   list=session.selectList("boardListData",map);
	   session.close();// ��ȯ (disConnection())
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
   // �� ������
   public static int boardTotalPage(){
	   int total=0;
	   //����Ŭ ����
	   SqlSession session= ssf.openSession();
	   total=session.selectOne("boardTotalPage");
	   //							id��
	   // session.selectOne("boardDetailData", no);
	   //							id��	   === parmeterType
	   //��ȯ
	   session.close();
	   return total;
   }
   // ���� ������ �б�
// <select id="boardDetailData" resultType="BoardVO" parameterType="int">
   public static BoardVO boardUpdateData(int no){
	   BoardVO list = new BoardVO();
	   SqlSession session=ssf.openSession(); //getConnection()
	   list=session.selectOne("boardDetailData",no); //����
	   session.close(); //disConnection();
	   return list;
   }
   // �����ϱ�
   // <update id="boardUpdate" parameterType="BoardVO">
   public static boolean boardUpdate(BoardVO vo){
	   boolean bCheck  = false;
	   SqlSession session=ssf.openSession();
	   //DB�� �ִ� ��й�ȣ �б�
	   String db_pwd=session.selectOne("boardGetPwd",vo.getNo());
	   if(db_pwd.equals(vo.getPwd())){
		   bCheck=true;
		   session.update("boardUpdate",vo);
		   session.commit();
	   }
	   session.close();
	   return bCheck;
   }
   // �����ϱ�
   //<delete id="boardDelete" parameterType="int">
   public static boolean boardDelete(int no,String pwd){
	   boolean bCheck  = false;
	   try{
	   SqlSession session=ssf.openSession();
	   //DB�� �ִ� ��й�ȣ �б�
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
   // �˻��ϱ�(ã��)
   // <select id="boardFindData" resultType="BoardVO" parameterType="java.util.Map">
   public static List<BoardVO> boardFindData(Map map){
	   List<BoardVO> list= new ArrayList<BoardVO>();
	   SqlSession session = ssf.openSession();
	   list=session.selectList("boardFindData",map);
	   session.close();
	   return list;
   }

}








