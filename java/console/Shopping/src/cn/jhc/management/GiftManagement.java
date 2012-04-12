package cn.jhc.management;

import java.util.Scanner;

import cn.jhc.data.*;

/**
 *真情回馈
 */
public class GiftManagement {
	/*商品信息*/
	public String[] goodsName;
    public double[] goodsPrice;
    
    /*会员信息*/
    public int[] custNo;
    public String[] custBirth;
    public int[] custScore;
    
	
	/**
	 * 传递数据库
	 */
	public void setData(String[] goodsName1, double[] goodsPrice1, int[] custNo1, String[] custBirth1, int[] custScore1){
		   goodsName = goodsName1;
		   goodsPrice = goodsPrice1;
		   custNo = custNo1;
		   custBirth = custBirth1;
		   custScore = custScore1;
	} 
	
	/**
	 * 返回上一级菜单
	 */
	  public void returnLastMenu(){
		   System.out.print("\n\n请按'n'返回上一级菜单:");
		   Scanner input = new Scanner(System.in);
		   boolean con = true;
		   do{ 
		     if(input.next().equals("n")){
			    Menu menu = new Menu();
		        menu.setData(goodsName, goodsPrice, custNo, custBirth, custScore);
		        menu.showSendGMenu();
		     }else{
		    	System.out.print("输入错误, 请重新'n'返回上一级菜单：");
		    	con = false;
		     }
	       }while(!con);
	   }
	
	/**
	  * 实现生日问候功能
	  */
	  public void sendBirthCust(){
		  System.out.println("我行我素购物管理系统 > 生日问候\n\n");
		  System.out.print("请输入今天的日期(月/日<用两位表示>)：");
          Scanner input = new Scanner(System.in);
          String date = input.next();
          System.out.println(date);
          String no = "";
          boolean isAvailable = false;
          for(int i = 0; i < custBirth.length; i++){
       	    if(custBirth[i]!=null && custBirth[i].equals(date)){
       		  no = no + custNo[i] + "\n";
       		  isAvailable = true;
       	    }
          }
          if(isAvailable){
       	     System.out.println("过生日的会员是：");
       	     System.out.println(no);
             System.out.println("恭喜！获赠MP3一个！");
          }else{
       	     System.out.println("今天没有过生日的会员！");
          }     
          
          //返回上一级菜单
          returnLastMenu();
	  }
	  
	  /**
       *  产生幸运会员
       */
	  public void  sendLuckyCust(){
		  System.out.println("我行我素购物管理系统 > 幸运抽奖\n\n");
		  System.out.print("是否开始（y/n）：");
		  Scanner input = new Scanner(System.in);
		  if(input.next().equals("y")){
			  int random = (int)(Math.random()* 10);
			  int baiwei; //百位 
			  boolean isAvailable = false;
			  String list = "";
              for(int i = 0; i< custNo.length; i++){
                 if(custNo[i]==0){
                	 break;
                 } 
    			 baiwei = custNo[i] / 100 % 10;
            	 if(baiwei == random){
            		 list = list + custNo[i]+ "\t";
            		 isAvailable = true;
            	 }
              }
              if(isAvailable){
            	   System.out.println("幸运客户获赠MP3：" + list);
              }else{
            	   System.out.println("无幸运客户。");
              }
		  }
		  
		  //返回上一级菜单
          returnLastMenu();
	  }
	  
	  public void sendGoldenCust(){
		  System.out.println("我行我素购物管理系统 > 幸运大放送\n\n");
		  int index = 0;
		  int max = custScore[0];
		  //假定积分各不相同
		  for(int i = 0; i < custScore.length; i++){
			  if(custScore[i] == 0){
				  break;  //数组后面为空用户
			  }
			  //求最大积分的客户
			  if(custScore[i] > max){
				  max = custScore[i];
				  index = i;
			  }
		  }
		  System.out.println("具有最高积分的会员是： " + custNo[index] + "\t" + custBirth[index] + "\t" + custScore[index]);
          //创建笔记本电脑对象
		  Gift laptop = new Gift();
		  laptop.name = "苹果笔记本电脑";
		  laptop.price = 12000;
		  System.out.print("恭喜！获赠礼品： ");
		  System.out.println(laptop);
		  
          //返回上一级菜单
          returnLastMenu();
	  }
}
