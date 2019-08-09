package com.sist.model;

import javax.servlet.http.HttpServletRequest;

/*
 *    1. interface , �߻�Ŭ���� 
 *       ===================
 *        ���õ� Ŭ������ ��Ƽ� ������ ���� 
 *       interface , �߻�Ŭ���� 
 *       ===================
 *        1) �̿ϼ� Ŭ���� => ���α׷��Ӱ� �ϼ��ؼ� ��� 
 *        2) interface : ���޼��带 ����(1.7)
 *           =========
 *           interface A
 *           {
 *               int a=10; // ����� ����
 *               => public static final int a
 *                  ===================
 *               void display();
 *               => public abstract void display()
 *                  ===============
 *           } 
 *           
 *           �������̵� 
 *            1) ��� (extends , implements)
 *            2) �޼ҵ���� ���� 
 *            3) ������,�Ű������� ���� 
 *            4) ��Ҵ� �Ұ��� , Ȯ���� ���� (����������)
 *              =====================
 *               private < default < protected < public 
 *               =======================================   
 *               
 *            ����ó�� : ����) ���������Ḧ �����ϰ� ���� ���¸� ���� 
 *                    => ��� : ������ ���� �����ϴ� ���α׷� 
 *                    => ��� : ����(try~catch) , ȸ�� (throws)
 *                    => ��ӵ� 
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







