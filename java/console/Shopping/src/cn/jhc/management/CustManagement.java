package cn.jhc.management;

import java.util.Scanner;

public class CustManagement {
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
		        menu.showCustMMenu();
		     }else{
		    	System.out.print("输入错误, 请重新'n'返回上一级菜单：");
		    	con = false;
		     }
	       }while(!con);
	   }
	   
	   /**
        * 增加会员
        */
	    public void add(){
	    	System.out.println("我行我素购物管理系统 > 客户信息管理 > 添加客户信息\n\n");
	    	Scanner input = new Scanner(System.in); 
	    	System.out.print("请输入会员号(<4位整数>)：");
			int no = input.nextInt();
			System.out.print("请输入会员生日（月/日<用两位数表示>）：");
			String birth = input.next();
			System.out.print("请输入积分：");
			int score = input.nextInt();
			int index = -1;
			for(int i = 0; i< custNo.length; i++){
				if(custNo[i] == 0){
					index = i;
					break;
				}
			}
			custNo[index] = no;
			custBirth[index] = birth;
			custScore[index] = score;
			System.out.println("新会员添加成功！");
			
			//返回上一级菜单
			returnLastMenu();
	    }
	    
	    /**
	      * 更改客户信息
	      */
		public void modify(){
			 System.out.println("我行我素购物管理系统 > 客户信息管理 > 修改客户信息\n\n");
			 System.out.print("请输入会员号：");
			 Scanner input = new Scanner(System.in);
			 int no = input.nextInt();
			 System.out.println("  会员号            生日             积分      ");	     
		     System.out.println("------------|------------|---------------");
		     int index = -1;
			 for(int i = 0; i < custNo.length; i++){
			      if(custNo[i] == no){
			    	  System.out.println(custNo[i] + "\t\t" + custBirth[i]+"\t\t" + custScore[i]);
			    	  index = i;
			    	  break;
			       }
		     }
			 if(index !=-1){
				 System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
				 System.out.println("\t\t\t\t1.修 改 会 员 生 日.\n");
				 System.out.println("\t\t\t\t2.修 改 会 员 积 分.\n");
				 System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
				 System.out.print("请选择，输入数字：");
				 switch(input.nextInt()){
				    case 1:
				    	System.out.print("请输入修改后的生日：");
				    	custBirth[index] = input.next();
				    	System.out.println("生日信息已更改！");
				    	break;
				    case 2:
				    	System.out.print("请输入修改后的会员积分：");
				    	custScore[index] = input.nextInt();
				    	System.out.println("会员积分已更改！");
				    	break;
				 }
			 }else{
				 System.out.println("抱歉，没有你查询的会员。");
				 
			 }
			 //返回上一级菜单
			 returnLastMenu();
			 
		}
		
		 /**
	       * 查询客户的信息
	       */  
		  public void search(){
			 System.out.println("我行我素购物管理系统 > 客户信息管理 > 查询客户信息\n");
			 String con = "y";
			 Scanner input = new Scanner(System.in);
			 while(con.equals("y")){
			   System.out.print("请输入会员号：");
			   int no = input.nextInt();
			   System.out.println("  会员号            生日             积分      ");	     
		       System.out.println("------------|------------|---------------");
			   boolean isAvailable = false;
		       for(int i = 0; i < custNo.length; i++){
			      if(custNo[i] == no){
			    	  System.out.println(custNo[i] + "\t\t" + custBirth[i]+"\t\t" + custScore[i]);
			    	  isAvailable = true;
			    	  break;
			       }
		       }
			   if(!isAvailable){
				  System.out.println("抱歉，没有你查询的会员信息。");
			   }
			   System.out.print("\n要继续查询吗（y/n）:");
			   con = input.next();
		     }
			 
			 //返回上一级菜单
			 returnLastMenu();
		  }	  
		  
		    /**
		      * 显示所有的会员信息
		      */
			public void show(){
				System.out.println("我行我素购物管理系统 > 客户信息管理 > 显示客户信息\n\n");
				System.out.println("  会员号            生日             积分      ");	     
				System.out.println("------------|------------|---------------");
				int length = custNo.length;
				for(int i= 0; i<length;i++){
					if(custNo[i] == 0){
						break;  //客户信息已经显示完毕
					}
					System.out.println(custNo[i] + "\t\t" + custBirth[i]+ "\t\t" + custScore[i]);
				}
				
				//返回上一级菜单
				returnLastMenu();
			}
}
