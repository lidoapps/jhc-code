package cn.jhc.management;

import java.util.Scanner;

import cn.jhc.data.*;

/**
 *Menu.java
 *菜单类 
 */
public class Menu {
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
	 * 显示我行我素购物管理系统的登录菜单
	 */
	public void showLoginMenu() {
		System.out.println("\n\n\t\t\t    欢迎使用我行我素购物管理系统1.0版\n\n");
		System.out.println ("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. 登 录 系 统\n\n");
		System.out.println("\t\t\t\t 2. 更 改 管 理 员 密 码\n\n");
		System.out.println("\t\t\t\t 3. 退 出\n\n");
		System.out.println ("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("请选择,输入数字:");    
	}	
	
	/**
	 * 显示我行我素购物管理系统的主菜单
	 */
	public void showMainMenu() {
		System.out.println("\n\n\t\t\t\t欢迎使用我行我素购物管理系统\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. 客 户 信 息 管 理\n");
		System.out.println("\t\t\t\t 2. 购 物 结 算\n");
		System.out.println("\t\t\t\t 3. 真 情 回 馈\n");		
		System.out.println("\t\t\t\t 4. 注 销\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("请选择,输入数字:");
		
		Scanner input = new Scanner(System.in);
		boolean con = false;
		do{
			String num = input.next();
			  if(num.equals("1")){
                   //显示客户信息管理菜单
				   showCustMMenu();
				   break;
			  }else if(num.equals("2")){
				   //显示购物结算菜单
				   Pay pay = new Pay();
				   pay.setData(goodsName, goodsPrice, custNo, custBirth, custScore);
				   pay.calcPrice();
				   break;
			  }else if(num.equals("3")){
                   //显示真情回馈菜单
				   showSendGMenu();
				   break;
			  }else if(num.equals("4")){
				   showLoginMenu(); 
				   break;
			  }else{
				   System.out.print("输入错误，请重新输入数字：");
				   con = false;
			  }
		}while(!con);
	}
	
	/**
	 * 客户信息管理菜单
	 */
	
	public void showCustMMenu() {
		System.out.println("我行我素购物管理系统 > 客户信息管理\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. 显 示 所 有 客 户 信 息\n");
		System.out.println("\t\t\t\t 2. 添 加 客 户 信 息\n");
		System.out.println("\t\t\t\t 3. 修 改 客 户 信 息\n");
		System.out.println("\t\t\t\t 4. 查 询 客 户 信 息\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("请选择,输入数字或按'n'返回上一级菜单:");
		Scanner input = new Scanner(System.in);
	    
		boolean con = true;  //处理如果输入菜单号错误
	    do{
	      CustManagement cm = new CustManagement();
		  cm.setData(goodsName, goodsPrice, custNo, custBirth, custScore);
		  String num = input.next();
		  if(num.equals("1")){
			  cm.show();
			  break;
		  }else if(num.equals("2")){
			  cm.add();
			  break;
		  }else if(num.equals("3")){
			  cm.modify();
			  break;
		  }else if(num.equals("4")){
			  cm.search();
			  break;
			 
		  }else if(num.equals("n")){
              showMainMenu();
        	  break;
		  }else{
			System.out.println("输入错误, 请重新输入数字：");
			con = false;
		  }
	    }while(!con);
	}
	
	/**
	 * 显示我行我素购物管理系统的真情回馈菜单
	 */
	public void showSendGMenu(){
		 System.out.println("我行我素购物管理系统 > 真情回馈\n");
		 System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		 System.out.println("\t\t\t\t 1. 幸 运 大 放 送\n");
		 System.out.println("\t\t\t\t 2. 幸 运 抽 奖\n");
		 System.out.println("\t\t\t\t 3. 生 日 问 候\n");
		 System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		 System.out.print("请选择,输入数字或按'n'返回上一级菜单:");
		 Scanner input = new Scanner(System.in);
		 
		 boolean con = true;  //处理如果输入菜单号错误
		 GiftManagement gm = new GiftManagement();
		 gm.setData(goodsName, goodsPrice, custNo, custBirth, custScore);
		    do{
			  String num = input.next();
			  if(num.equals("1")){
                   //幸运大放送
				   gm.sendGoldenCust();
				   break;
			  }else if(num.equals("2")){
                  //幸运抽奖
				   gm.sendLuckyCust();
				   break;
			  }else if(num.equals("3")){
                  //生日问候
				  gm.sendBirthCust();
				  break;
			  }else if(num.equals("n")){
                  showMainMenu();
                  break;
			  }else{
				System.out.println("输入错误, 请重新输入数字：");
				con = false;
			  }
		    }while(!con);
	}
}
