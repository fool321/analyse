package gg1;

import java.io.File;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.FormatFlagsConversionMismatchException;
import java.util.Vector;
import java.util.jar.Attributes.Name;

import org.apache.poi.ss.formula.ptg.AddPtg;

import jxl.Workbook;
import jxl.write.WritableSheet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Gg {
	static team team1 = new team();
	static int[][] chat = new int[30][30];
	static int[][] chatshortpass = new int[30][30];
	static int[][] chatlongpass = new int[30][30];
	static int[][] chatatack =  new int[30][30];
	 static void ggnum(String Name1,String Name2,int x1,int y1,int x2,int y2) {
			int x=0;int y=0;
			String nameF = "Huskies_F";
			String nameM = "Huskies_M";
			String nameD = "Huskies_D";
			String nameG = "Huskies_G";
			if(Name1.substring(0, 9).equals(nameF)) {
				x=Integer.valueOf(Name1.substring(9))-1;
			}
			else if(Name1.substring(0, 9).equals(nameM)) {
				x=Integer.valueOf(Name1.substring(9))+5;
			}
			else if(Name1.substring(0, 9).equals(nameD)) {
				x=Integer.valueOf(Name1.substring(9))+18;
			}
			else if(Name1.substring(0, 9).equals(nameG)) {
				x=Integer.valueOf(Name1.substring(9))+28;
			}		
			if(Name2.substring(0, 9).equals(nameF)) {
				y=Integer.valueOf(Name2.substring(9))-1;
			}
			else if(Name2.substring(0, 9).equals(nameM)) {
				y=Integer.valueOf(Name2.substring(9))+5;
			}
			else if(Name2.substring(0, 9).equals(nameD)) {
				y=Integer.valueOf(Name2.substring(9))+18;
			}
			else if(Name2.substring(0, 9).equals(nameG)) {
				y=Integer.valueOf(Name2.substring(9))+28;
			}
			if(judge(x1, y1, x2, y2)) {
				chatlongpass[x][y]++;
				chatlongpass[y][x]++;
			}
			else {
				chatshortpass[x][y]++;
				chatshortpass[y][x]++;
			}
			if(judge1(x1, y1, x2, y2)) {
				chatatack[x][y]++;
				chatatack[y][x]++;
			}
		}
	 
	 static boolean judge(int x1,int y1,int x2,int y2) {
		 int judgenum=600;
		 int nownum = (int) Math.pow(x2-x1, 2)+(int) Math.pow(y2-y1, 2);
		 if(nownum>judgenum)
			 return true;//长传
		 return false;
	 }
	 
	 static boolean judge1(int x1,int y1,int x2,int y2) {
		 int judgenum=400;
		 int nownum = (int) Math.pow(x2-x1, 2)+(int) Math.pow(y2-y1, 2);
		 if(nownum>judgenum&&x2<50&&y2<50)
			 return true;//长传
		 return false;
	 }
	 
	 static int getX(String Name1) {
		 	int x=0;
			String nameF = "Huskies_F";
			String nameM = "Huskies_M";
			String nameD = "Huskies_D";
			String nameG = "Huskies_G";
			if(Name1.substring(0, 9).equals(nameF)) {
				x=Integer.valueOf(Name1.substring(9))-1;
			}
			else if(Name1.substring(0, 9).equals(nameM)) {
				x=Integer.valueOf(Name1.substring(9))+5;
			}
			else if(Name1.substring(0, 9).equals(nameD)) {//D10
				x=Integer.valueOf(Name1.substring(9))+18;
			}
			else if(Name1.substring(0, 9).equals(nameG)) {
				x=Integer.valueOf(Name1.substring(9))+28;
			}
			return x;
	 }
	 static int getTime(String half,String timString) {
		 int time=0;
		 if(half.equals("2H"))
			 time+=45;
		 time+=Double.valueOf(timString).intValue()/60;		
//		 if(time>=90)
//			 System.out.println(half+" "+timString);
				 //time+=Integer.parseInt(timString);
	//	 System.out.println(time);
		 return time;
	 }
	 
	 static void printrus(int type) {
		 
		 if(type==5) {
			 //chat
				for(int i=0;i<chat.length;i++) {
				for(int j=0;j<chat.length;j++) {
					int num = 0;
					if(chat[i][j]!=0) {
						//num = chatatack[i][j]*200+chatshortpass[i][j]*550+chatlongpass[i][j]*250;
						num = chatatack[i][j]*200+chatshortpass[i][j]*550+chatlongpass[i][j]*250;
						num /= chat[i][j];
					}
					System.out.print(num+" ");
				}
				System.out.println();
			}
		 }
		 if(type==4) {
			 //chat
				for(int i=0;i<chat.length;i++) {
				for(int j=0;j<chat.length;j++) {
					int num = 0;
					if(chat[i][j]!=0) {
						num = chatatack[i][j]*1000;
						num /= chat[i][j];
					}
					System.out.print(num+" ");
				}
				System.out.println();
			}
		 }
		 
		 if(type==2) {//longpass
			 //chat
			 for(int i=0;i<chat.length;i++) {
				for(int j=0;j<chat.length;j++) {
					int num=0;
					//DecimalFormat df =new DecimalFormat("0.000");
					if(chat[i][j]!=0) {
						num = chatshortpass[i][j]*1000;
						num /=chat[i][j];
						//System.out.print(df.format((float)chatlongpass[i][j]/chat[i][j]));
					}
					System.out.print(num+" ");
				}
				System.out.println();
			}
		 }
		 if(type==1) {
			 //chat
				for(int i=0;i<chat.length;i++) {
				for(int j=0;j<chat.length;j++) {
					System.out.print(chat[i][j]+" ");
				}
				System.out.println();
			}
		 }
		 if(type==3) {//longpass
			 //chat
			 for(int i=0;i<chat.length;i++) {
				for(int j=0;j<chat.length;j++) {
					int num=0;
					//DecimalFormat df =new DecimalFormat("0.000");
					if(chat[i][j]!=0) {
						num = chatlongpass[i][j]*1000;
						num /=chat[i][j];
						//System.out.print(df.format((float)chatlongpass[i][j]/chat[i][j]));
					}
					System.out.print(num+" ");
				}
				System.out.println();
			}
		 }
	 }
	 
	 static void print(int type) {
		 if(type==1) {
			 //chat
				for(int i=0;i<chat.length;i++) {
				for(int j=0;j<chat.length;j++) {
					System.out.print(chat[i][j]+" ");
				}
				System.out.println();
			}
		 }
		 if(type==2) {//shortpass
			 //chat
				for(int i=0;i<chat.length;i++) {
				for(int j=0;j<chat.length;j++) {
					System.out.print(chatshortpass[i][j]+" ");
				}
				System.out.println();
			}
		 }
		 if(type==3) {//longpass
			 //chat
				for(int i=0;i<chat.length;i++) {
				for(int j=0;j<chat.length;j++) {
					System.out.print(chatlongpass[i][j]+" ");
				}
				System.out.println();
			}
		 }
	 }
	 
	 static boolean judgeForward45(int x1,int y1,int x2,int y2) {
		 int judgenum=800;
		 int nownum = (int) Math.pow(x2-x1, 2)+(int) Math.pow(y2-y1, 2);
		 if(nownum>judgenum) {//长传
			 if(x2>x1) {
				 if(y2<=70&&y2>=30) {
					 double xx = Math.abs(x1-x2);
					 double yy = Math.abs(y1-y2);
					 double tan = xx/yy;
					 if(tan>0.7&&tan<1.42) {
						 return true;
					 }
				 }
			 }
		 }
		 return false;
	 }
	 
	public static void main(String[] args) throws IOException {
		
		for(int i=0;i<chat.length;i++) {
			for(int j=0;j<chat.length;j++) {
				chat[i][j]=0;
				chatshortpass[i][j]=0;
				chatlongpass[i][j]=0;
				chatatack[i][j]=0;
			}
		}
			
		
		File writename = new File("TeamNumber.txt"); //输出
		String pathname = "fullevent.txt";//输入
		
		writename.createNewFile(); BufferedWriter out = new BufferedWriter(new FileWriter(writename)); 
		File filename = new File(pathname); InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));BufferedReader br = new BufferedReader(reader); 
		
		String line = "";
		line = br.readLine();line = br.readLine();
		
		String playidString = "Huskies_G";//检索字符串
		Vector<String>ssStrings = new Vector<String>();
		int time=0;
		int match = 1;
		
		while (line != null) {
			String nameString=null;//,x1 = null,x2= null,y1= null,y2= null;
			String[] arr = line.split(",");
			
			if(!arr[1].equals("Huskies")) {
				line = br.readLine(); // 一次读入一行数据
				continue;
			}
			String currmatchString = ""+match;
			if(!arr[0].equals(currmatchString)) {
				for(int i=0;i<ssStrings.size();i++) {//本场比赛结束
					if(time>=90)
						break;
					if(!(ssStrings.get(i).length()==0)) {
						for(int j=i+1;j<ssStrings.size();j++) {
							if(!(ssStrings.get(j).length()==0)) {
								int x = getX(ssStrings.get(i));//坐标
								int y = getX(ssStrings.get(j));
								//System.out.println((getTime(arr[4],arr[5])+" "+time));
								chat[x][y]+=(90-time);
								chat[y][x]+=(90-time);	
							}
						}
					}
				}
				time=0;
				match++;
				ssStrings.clear();
				line = br.readLine();
				continue;
			}
	
			// 若为换人的行为时间点  得出距离上次换人或开场的时间
			if(arr[6].equals("Substitution")) {
				//立即打印vector
				for(int i=0;i<ssStrings.size();i++) {
					if(!(ssStrings.get(i).length()==0)) {
						for(int j=i+1;j<ssStrings.size();j++) {
							if(!(ssStrings.get(j).length()==0)) {
								int x = getX(ssStrings.get(i));//坐标
								int y = getX(ssStrings.get(j));
								//System.out.println((getTime(arr[4],arr[5])+" "+time));
								chat[x][y]+=(getTime(arr[4],arr[5])-time);
								chat[y][x]+=(getTime(arr[4],arr[5])-time);	
							}
						}
					}
				}
				time=getTime(arr[4],arr[5]);
				//销毁
				ssStrings.clear();
				//System.out.println("-------"+arr[4]+" "+arr[5]+" "+arr[3]+"  代替  "+arr[2]);
				line = br.readLine();
				continue;
			}
			
			int flag1=0,flag2=0;
			for(int i=0;i<ssStrings.size();i++) {
				if(arr[2].equals(ssStrings.get(i)))
					flag1=1;
				if(arr[3].equals(ssStrings.get(i)))
					flag2=1;
				if(flag1==1&&flag2==1)
					break;
			}			
			if(flag1==0)
				ssStrings.add(arr[2]);
			if(flag2==0)
				ssStrings.add(arr[3]);
		
			line = br.readLine(); // 一次读入一行数据				
		}
		
		//读取pass表
//		System.out.println("gg");
		String pathname1 = "passevent.txt";//输入
		
		File filename1 = new File(pathname1); InputStreamReader reader1 = new InputStreamReader(new FileInputStream(filename1));BufferedReader br1 = new BufferedReader(reader1); 
		
		String line1 = "";
		line1 = br1.readLine();line1 = br1.readLine();
		int shortpassSum=0;
		int shortpasschurrent=0;
		String maString = "1";
		int matchnum=1;
		int foward45 = 0;
		//System.out.println((6/5.1));
		
		while (line1 != null) {
			String nameString=null;int x1=0,x2=0,y1=0,y2=0;// = null,x2= null,y1= null,y2= null;
			String[] arr = line1.split(",");
			
			if(arr[1].equals("Huskies")) {
				x1=Double.valueOf(arr[7]).intValue();
				y1=Double.valueOf(arr[8]).intValue();
				x2=Double.valueOf(arr[9]).intValue();
				y2=Double.valueOf(arr[10]).intValue();
				if(judgeForward45(x1, y1, x2, y2)) {
					System.out.println(line1);
					foward45++;
				}
			}
			
//			if(arr[1].equals("Huskies")) {
//				//shortpassSum++;
//				while(true) {
//					line1 = br1.readLine();
//					arr = line1.split(",");
//					
//					x1=Double.valueOf(arr[7]).intValue();
//					y1=Double.valueOf(arr[8]).intValue();
//					x2=Double.valueOf(arr[9]).intValue();
//					y2=Double.valueOf(arr[10]).intValue();
//					
//					if(arr[1].equals("Huskies")) {
//						if(!judge(x1, y1, x2, y2)) {
//							shortpasschurrent++;
//							shortpassSum++;
//						}				
//					}
//					else {
//						if(!judge(x1, y1, x2, y2)) {
//							shortpassSum++;
//						}
//						break;
//					}
//					
//				}
//			}
			

			line1 = br1.readLine(); // 一次读入一行数据
		}
		//System.out.println(shortpasschurrent+" "+shortpassSum);
		
		
//		print(3);
//		System.out.println();
//		print(1);
//		System.out.println();
	//	printrus(5);
//		for(int i=0;i<chat.length;i++) {
//			for(int j=0;j<chat.length;j++) {
//				System.out.print(chat[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(foward45);
		out.close(); // 最后记得关闭文件
	}
}


//if(!arr[0].equals(maString)) {
//matchnum++;
//maString=""+matchnum;
////System.out.println(shortpasschurrent+" "+shortpassSum);
//shortpasschurrent=0;
//shortpassSum=0;
//}
//if(arr[0].equals("2"))
//break;
//if(arr[0].equals("1")) {
//line1 = br1.readLine();
//continue;
//}
//if(arr[0].equals("3"))
//break;

//int flag=1;
//for(int j=0;j<ssStrings.size();j++) {
//	if(j>i)
//		break;
//	if(!(ssStrings.get(j).length()==0))
//		flag++;
//}
//System.out.println(flag);

//for(int i=0;i<ssStrings.size();i++) {
//	if(!(ssStrings.get(i).length()==0))
//		System.out.println(ssStrings.get(i)+" ");
//}
//	out.write(team1.matchs.get(i).y+" ");
//	out.flush();

//	System.out.println("hhh"+arr[2]+"ggg"+arr[3]+"rrr");
//	if(arr[3].length()==0)
//		continue;
	//System.out.println(arr[3].length());
	//暂停事件


//if(arr[3].equals(ssStrings.get(i))) {//发球队员在场上
//	if(arr[4].equals(ssStrings.get(i))) {//接球队员在场上
//		break;
//	}
//}
//ssStrings.add(arr[3]);int flag = 0;
//for(int j=0;j<ssStrings.size();j++) {
//	if(arr[4].equals(ssStrings.get(i))) {//接球队员在场上
//		flag = 1;break;
//	}
//}
//if(flag==0) {//没有找到接球队员
//	ssStrings.add(arr[4]);
//}
//for(int i=0;i<arr.length;i++) {
//if(arr[i].equals("Substitution")) {
//	System.out.println(line);
//}
//continue;
//}
//if(arr[1].equals("Huskies")) {
//
//ggnum(arr[2],arr[3]);
//
//}

//for(int i=0;i<chat.length;i++) {
//	for(int j=0;j<chat.length;j++) {
//		System.out.print(chat[i][j]+" ");
//	}
//	System.out.println();
//}

//if(!arr[0].equals("1")) {
//for(int i=0;i<ssStrings.size();i++) {
//	if(!(ssStrings.get(i).length()==0))
//		System.out.println(ssStrings.get(i)+" ");
//}
//break;
//}