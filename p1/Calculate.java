package p1;
import java.util.Random;
//程序头部函数，打印头部内容
public class Calculate {
	public static void printHead(){					
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("------------------程序输出50道100以内的加减法算式的习题-----------------------");
		System.out.println("------------------每次运行程序可以得到一套50到习题及答案----------------------");
		System.out.println("----------------------------------------------------------------------------");
	}
	static String[] noRepeat=new String[50];
	public static boolean cheakRepeat(String Str){
		for(int i=0;i<noRepeat.length;i++){
			if(Str.equals(noRepeat[i])){
				return false;
			}
		}
		return true;
	}
	
	//打印算式函数，打印出算式，并将算式的结果存入数组中返回出来	
	public static int[] gengrateEquation1(){					
		int x,y,z,sum = 0;
		int i=0,j=0;
		int [] store=new int[50];
		char ov = 0;
		//实例化random对象
		Random random=new Random();	
			//控制生成50个算式
		while(i<50){
			String equationString="";
			//随机生成100以内一个数x
			x=random.nextInt(101);
			//随机生成100以内一个数y
			y=random.nextInt(101);
			//随机生成0或1，分别表示减法和加法
			z=random.nextInt(2);
			//生成的数为一表示加法
			if(z==1){
				ov='+';
				sum=x+y;
//				equationString=x+ov+y+"=";
				equationString=sum+"";
			}
			//生成的数为0表示减法
			if(z==0){
				ov='-';
				sum=(x-y);
//				equationString=x+ov+y+"=";
				equationString=sum+"";
			}
				//满足等式结果小于等于100或大于等于0的输出
			if((sum<=100&&sum>=0)&&cheakRepeat(equationString)){
				noRepeat[j++]=equationString;
				System.out.print("第"+(i+1)+"题:"+x+ov+y+"="+"\t");	
				//将生成的算式的结果放入数组中
				store[i++]=sum;
				//将算式每5个一行输出
				if((i)%5==0){
					System.out.println();
				}
			}
			}   
		//返回含有结果的数组
		return store;
	}
	
	//习题结果输出函数
	public static void printExercise(){			
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("---------------------------下面是50道习题的答案------------------------------");
		System.out.println("----------------------------------------------------------------------------");
		
	}
/*	输出习题的答案
	其中store为存放结果的数组*/
	public static void printCaluculation(int store[]){			
		for(int i=0;i<store.length; i++){
			//打印算式的答案
			System.out.print("第"+(i+1)+"题答案："+store[i]+"\t");
			if(i>0&&(i+1)%5==0){
				System.out.println();
			}
		}
		
	}


	public static void main(String[] args) {
		printHead();
		int result[]=gengrateEquation1();
		printExercise();
		printCaluculation(result);
	}
}