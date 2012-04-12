package cn.jhc.management;

import cn.jhc.data.*;

import java.util.*;

public class Main {
      /**
       * 我行我素购物管理系统的入口
       *
       */
	  public static void main(String[] args){
    	   /*出始化商场的商品和客户信息*/
           Data initial = new Data();
           initial.ini();
           
           
           /*进入系统*/
           Menu menu = new Menu();
     	   menu.setData(initial.goodsName, initial.goodsPrice, 
          		   initial.custNo, initial.custBirth,initial.custScore);
           menu.showLoginMenu();
           
           /*菜单选择*/
           boolean con = true;
           while(con){
             Scanner input = new Scanner(System.in);
             int choice = input.nextInt();
             VerifyEqual pv = new VerifyEqual();
             switch(choice){
               case 1: 
            	  /*密码验证*/
            	  for(int i = 3; i>=1; i--){
            		  if(pv.verify(initial.manager.username, initial.manager.password)){
                    	  menu.showMainMenu();
                    	  break;
            		  }else if(i!=1){
            			  System.out.println("\n用户名和密码不匹配，请重新输入："); //超过3次输入，退出
            		  }else{
            			  System.out.println("\n您没有权限进入系统！谢谢！");
            			  con = false;
            		  }
            	  }
            	  break;
               case 2: 
            	  if(pv.verify(initial.manager.username, initial.manager.password)){
            		  System.out.print("请输入新的用户名：");
            		  initial.manager.username = input.next();
            		  System.out.print("请输入新的密码：");
            		  initial.manager.password = input.next();
            		  System.out.println("用户名和密码已更改！");
            		  System.out.println("\n请选择，输入数字：");
            	  }else{
            		  System.out.println("抱歉，你没有权限修改！");
            		  con = false;
            	  }
            	  break;
               case  3: 
            	  System.out.println("谢谢您的使用！");
            	  con = false;
            	  break;
               default: 
            	  System.out.print("\n输入有误！请重新选择，输入数字: ");
             }
             if(!con){
            	 break;
             }
           }
          
      }
}
