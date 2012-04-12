package cn.jhc.management;

import java.util.*;
public class Pay {
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
	 * 计算客户的折扣数目
	 */
	public double getDiscount(int curCustNo, int[] custNo, int[] custScore){
    	double discount;
    	int index = -1;
    	for(int i = 0; i < custNo.length; i++){
    	    if(curCustNo == custNo[i]){
    	         index = i;
    	         break;
    	    }
    	}
        
    	//判断折扣
    	if(custScore[index]<1000){
             discount = 0.95;    		
    	}else if(1000<=custScore[index] && custScore[index]<2000){
    		 discount = 0.9;
    	}else if(2000<=custScore[index] && custScore[index]<3000){
    		 discount = 0.85;
    	}else if(3000<=custScore[index] && custScore[index]<4000){
    		 discount = 0.8;
    	}else if(4000<=custScore[index] && custScore[index]<6000){
    		 discount = 0.75;
    	}else if(6000<=custScore[index] && custScore[index]<8000){
    		 discount = 0.7;
    	}else{
    		 discount = 0.6;
    	}
    	return discount;
    }
    
	/*
	 * 　实现购物结算以及输出购物小票
	 */
	public void calcPrice(){
		int curCustNo;    //客户号
		int goodsNo = 0;   //商品编号
		double price; //商品价格
		String name;
		int count; //购入数量
		String choice;
		String goodsList = "";   //购物清单
		double total = 0;  //购物总金额
	    double finalPay = 0;  //打折后需付款
	    double payment; //实际交费金额
		
		System.out.println("我行我素购物管理系统 > 购物结算\n\n");

		//打印产品清单
		System.out.println("*************************************");
		 System.out.println("请选择购买的商品编号：" );
		for(int i = 0, p = 0; i < goodsName.length && goodsName[i] != null; i++){
			p++;
			System.out.println(p + ": " + goodsName[i] + "\t");
		}
		System.out.println("*************************************\n");
		
		/*进行购入结算系统*/
		Scanner input = new Scanner(System.in);
		System.out.print("\t请输入会员号：");
        curCustNo = input.nextInt();
        double discount = getDiscount(curCustNo, custNo, custScore);
        
        do{
            System.out.print("\t请输入商品编号：");  //数组下标+1即产品编号
            goodsNo = input.nextInt();
            System.out.print("\t请输入数目：");
            count = input.nextInt();
            
            //查询单价
            price = goodsPrice[goodsNo-1];
            name = goodsName[goodsNo-1];
            total = total + price * count;

            
            //连接购物清单
            goodsList = goodsList + "\n" + name + "\t" + "￥"+ price+ "\t\t"  + count + "\t\t" + "￥"+ (price * count) +"\t";

            System.out.print("\t是否继续（y/n）");
            choice = input.next();
        }while(choice.equals("y"));
        
        //计算消费总金额
		finalPay = total * discount;
        
		//打印消费清单
        System.out.println("\n");
        System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊消费清单＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
		System.out.println("物品\t\t" + "单价\t\t" + "个数\t\t"+ "金额\t");
		System.out.print(goodsList);
		System.out.println("\n折扣：\t" + discount);
		System.out.println("金额总计:\t" + "￥"+finalPay);
		System.out.print("实际交费:\t￥" );
		payment = input.nextDouble();
		System.out.println("找钱:\t" + "￥"+(payment-finalPay));
        
        //计算获得的积分：
		int score =  (int)finalPay / 100 * 3;

	    //更改会员积分
	    for(int i = 0; i < custNo.length; i++){
	         if(custNo[i] == curCustNo){
	        	 custScore[i] = custScore[i] + score;
	        	 System.out.println("本次购物所获的积分是： " + score);
	        	 break;
	         }
	    }
        
        //返回上一级菜单
	    System.out.print("\n请'n'返回上一级菜单:");
        if(input.next().equals("n")){
        	Menu menu = new Menu();
        	menu.setData(goodsName, goodsPrice, custNo, custBirth, custScore);
        	menu.showMainMenu();
        }

	}

}
