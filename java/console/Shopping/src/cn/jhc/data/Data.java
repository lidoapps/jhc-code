package cn.jhc.data;

/**
 * 初始化数据
 */
public class Data {
      /*商品信息*/
	  public String[] goodsName = new String[50];
      public double[] goodsPrice = new double[50];
      
      /*会员信息*/
      public int[] custNo = new int[100];
      public String[] custBirth = new String[100];
      public int[] custScore = new int[100];
      
      /*管理员*/
	  public Manager manager = new Manager();
      
      public void ini(){
    	  //商品0
    	  goodsName[0] = "addidas运动鞋";    
    	  goodsPrice[0] = 880;
    	  
    	  //商品1
    	  goodsName[1] = "Kappa网球裙";      
    	  goodsPrice[1]= 200;  
    	  
    	  //商品2
    	  goodsName[2] = "网球拍";           
    	  goodsPrice[2]= 780;
    	  
    	  //商品3    
    	  goodsName[3]= "addidasT恤";       
    	  goodsPrice[3] = 420.78;
    	  
    	  //商品4
    	  goodsName[4] = "Nike运动鞋";       
    	  goodsPrice[4] = 900;
    	  
    	  //商品5
    	  goodsName[5] = "Kappa网球";
    	  goodsPrice[5] = 45;
    	  
    	  //商品6
    	  goodsName[6] = "KappaT恤";
    	  goodsPrice[6] = 245;
    	  
    	  custNo [0] = 1900;        //客户1
    	  custBirth[0] = "08/05";
    	  custScore[0] = 2000;
    	  
    	  custNo [1] = 1711;        //客户2
    	  custBirth[1] = "07/13";
    	  custScore[1] = 4000;
    	  
    	  custNo [2] = 1623;        //客户3    
    	  custBirth[2] = "06/26";
    	  custScore[2] = 5000;
    	  
    	  custNo [3] = 1545;        //客户4
    	  custBirth[3] = "04/08";
    	  custScore[3] = 2200;
    	  
    	  custNo [4] = 1464;        //客户5
    	  custBirth[4] = "08/16";
    	  custScore[4] = 1000;
    	  
    	  custNo [5] = 1372;        //客户6
    	  custBirth[5] = "12/23";
    	  custScore[5] = 3000;
    	  
    	  custNo[6] = 1286;         //客户7
    	  custBirth[6] = "12/21";
    	  custScore[6] = 10080;
    	  
      }

}
