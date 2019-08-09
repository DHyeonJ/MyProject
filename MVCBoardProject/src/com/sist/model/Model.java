package com.sist.model;

import javax.servlet.http.HttpServletRequest;

/*
 *    1. interface , 추상클래스 
 *       ===================
 *        관련된 클래스를 모아서 관리할 목적 
 *       interface , 추상클래스 
 *       ===================
 *        1) 미완성 클래스 => 프로그래머가 완성해서 사용 
 *        2) interface : 모든메서드를 구현(1.7)
 *           =========
 *           interface A
 *           {
 *               int a=10; // 상수형 변수
 *               => public static final int a
 *                  ===================
 *               void display();
 *               => public abstract void display()
 *                  ===============
 *           } 
 *           
 *           오버라이딩 
 *            1) 상속 (extends , implements)
 *            2) 메소드명이 동일 
 *            3) 리턴형,매개변수가 동일 
 *            4) 축소는 불가능 , 확장은 가능 (접근지정어)
 *              =====================
 *               private < default < protected < public 
 *               =======================================   
 *               
 *            예외처리 : 목적) 비정상종료를 방지하고 정상 상태를 유지 
 *                    => 기능 : 사전에 에러 방지하는 프로그램 
 *                    => 방식 : 복구(try~catch) , 회피 (throws)
 *                    => 상속도 
 *                       =========
 *                        Object
 *                       ==========
 *                           |
 *                        Throwable
 *                      ==============
 *                      |            |
 *                    Error       Exception
 *                             ================
 *                             |              |
 *                          CheckExcetion   UnCheckException
 *                          =============   ================= RuntimeException
 *                          IOException                         = NumberFormatException
 *                          SQLException                        = NullPointerException
 *                          ClassNotFoundException              = ArrayIndexOutOfBoundsException
 *                          MalformURLException                 = ClassCastException
 *                          
 *                          extends
 *                    class =======> class
 *                              extends 
 *                    interface =========> interface
 *                              implements
 *                    interface =========> class
 *                            extends , implements 
 *                    class ============> interface(X)
 */
public interface Model {
   public String handlerRequest(HttpServletRequest request) throws Throwable;
}







