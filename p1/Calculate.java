package p1;
import java.util.Random;
//����ͷ����������ӡͷ������
public class Calculate {
	public static void printHead(){					
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("------------------�������50��100���ڵļӼ�����ʽ��ϰ��-----------------------");
		System.out.println("------------------ÿ�����г�����Եõ�һ��50��ϰ�⼰��----------------------");
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
	
	//��ӡ��ʽ��������ӡ����ʽ��������ʽ�Ľ�����������з��س���	
	public static int[] gengrateEquation1(){					
		int x,y,z,sum = 0;
		int i=0,j=0;
		int [] store=new int[50];
		char ov = 0;
		//ʵ����random����
		Random random=new Random();	
			//��������50����ʽ
		while(i<50){
			String equationString="";
			//�������100����һ����x
			x=random.nextInt(101);
			//�������100����һ����y
			y=random.nextInt(101);
			//�������0��1���ֱ��ʾ�����ͼӷ�
			z=random.nextInt(2);
			//���ɵ���Ϊһ��ʾ�ӷ�
			if(z==1){
				ov='+';
				sum=x+y;
//				equationString=x+ov+y+"=";
				equationString=sum+"";
			}
			//���ɵ���Ϊ0��ʾ����
			if(z==0){
				ov='-';
				sum=(x-y);
//				equationString=x+ov+y+"=";
				equationString=sum+"";
			}
				//�����ʽ���С�ڵ���100����ڵ���0�����
			if((sum<=100&&sum>=0)&&cheakRepeat(equationString)){
				noRepeat[j++]=equationString;
				System.out.print("��"+(i+1)+"��:"+x+ov+y+"="+"\t");	
				//�����ɵ���ʽ�Ľ������������
				store[i++]=sum;
				//����ʽÿ5��һ�����
				if((i)%5==0){
					System.out.println();
				}
			}
			}   
		//���غ��н��������
		return store;
	}
	
	//ϰ�����������
	public static void printExercise(){			
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("---------------------------������50��ϰ��Ĵ�------------------------------");
		System.out.println("----------------------------------------------------------------------------");
		
	}
/*	���ϰ��Ĵ�
	����storeΪ��Ž��������*/
	public static void printCaluculation(int store[]){			
		for(int i=0;i<store.length; i++){
			//��ӡ��ʽ�Ĵ�
			System.out.print("��"+(i+1)+"��𰸣�"+store[i]+"\t");
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