//package gg1;
//
//import java.io.File;
//import java.io.InputStreamReader;
//import java.text.DecimalFormat;
//import java.util.FormatFlagsConversionMismatchException;
//import java.util.Vector;
//import java.util.jar.Attributes.Name;
//
//import org.apache.poi.ss.formula.ptg.AddPtg;
//
//import jxl.Workbook;
//import jxl.write.WritableSheet;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class Gg {
//	static team team1 = new team();
//	static int[][] chat = new int[30][30];
//	static int[][] chatshortpass = new int[30][30];
//	static int[][] chatlongpass = new int[30][30];
//	static int[][] chatatack =  new int[30][30];
//	 static void ggnum(String Name1,String Name2,int x1,int y1,int x2,int y2) {
//			int x=0;int y=0;
//			String nameF = "Huskies_F";
//			String nameM = "Huskies_M";
//			String nameD = "Huskies_D";
//			String nameG = "Huskies_G";
//			if(Name1.substring(0, 9).equals(nameF)) {
//				x=Integer.valueOf(Name1.substring(9))-1;
//			}
//			else if(Name1.substring(0, 9).equals(nameM)) {
//				x=Integer.valueOf(Name1.substring(9))+5;
//			}
//			else if(Name1.substring(0, 9).equals(nameD)) {
//				x=Integer.valueOf(Name1.substring(9))+18;
//			}
//			else if(Name1.substring(0, 9).equals(nameG)) {
//				x=Integer.valueOf(Name1.substring(9))+28;
//			}
//			
//			if(Name2.substring(0, 9).equals(nameF)) {
//				y=Integer.valueOf(Name2.substring(9))-1;
//			}
//			else if(Name2.substring(0, 9).equals(nameM)) {
//				y=Integer.valueOf(Name2.substring(9))+5;
//			}
//			else if(Name2.substring(0, 9).equals(nameD)) {
//				y=Integer.valueOf(Name2.substring(9))+18;
//			}
//			else if(Name2.substring(0, 9).equals(nameG)) {
//				y=Integer.valueOf(Name2.substring(9))+28;
//			}
//			if(judge(x1, y1, x2, y2)) {
//				chatlongpass[x][y]++;
//				chatlongpass[y][x]++;
//			}
//			else {
//				chatshortpass[x][y]++;
//				chatshortpass[y][x]++;
//			}
//			if(judge1(x1, y1, x2, y2)) {
//				chatatack[x][y]++;
//				chatatack[y][x]++;
//			}
//		}
//	 
//	 static boolean judge(int x1,int y1,int x2,int y2) {
//		 int judgenum=600;
//		 int nownum = (int) Math.pow(x2-x1, 2)+(int) Math.pow(y2-y1, 2);
//		 if(nownum>judgenum)
//			 return true;//����
//		 return false;
//	 }
//	 
//	 static boolean judge1(int x1,int y1,int x2,int y2) {
//		 int judgenum=400;
//		 int nownum = (int) Math.pow(x2-x1, 2)+(int) Math.pow(y2-y1, 2);
//		 if(nownum>judgenum&&x2<50&&y2<50)
//			 return true;//����
//		 return false;
//	 }
//	 
//	 static int getX(String Name1) {
//		 	int x=0;
//			String nameF = "Huskies_F";
//			String nameM = "Huskies_M";
//			String nameD = "Huskies_D";
//			String nameG = "Huskies_G";
//			if(Name1.substring(0, 9).equals(nameF)) {
//				x=Integer.valueOf(Name1.substring(9))-1;
//			}
//			else if(Name1.substring(0, 9).equals(nameM)) {
//				x=Integer.valueOf(Name1.substring(9))+5;
//			}
//			else if(Name1.substring(0, 9).equals(nameD)) {//D10
//				x=Integer.valueOf(Name1.substring(9))+18;
//			}
//			else if(Name1.substring(0, 9).equals(nameG)) {
//				x=Integer.valueOf(Name1.substring(9))+28;
//			}
//			return x;
//	 }
//	 static int getTime(String half,String timString) {
//		 int time=0;
//		 if(half.equals("2H"))
//			 time+=45;
//		 time+=Double.valueOf(timString).intValue()/60;		
////		 if(time>=90)
////			 System.out.println(half+" "+timString);
//				 //time+=Integer.parseInt(timString);
//	//	 System.out.println(time);
//		 return time;
//	 }
//	 
//	 static void printrus(int type) {
//		 
//		 if(type==5) {
//			 //chat
//				for(int i=0;i<chat.length;i++) {
//				for(int j=0;j<chat.length;j++) {
//					int num = 0;
//					if(chat[i][j]!=0) {
//						//num = chatatack[i][j]*200+chatshortpass[i][j]*550+chatlongpass[i][j]*250;
//						num = chatatack[i][j]*200+chatshortpass[i][j]*550+chatlongpass[i][j]*250;
//						num /= chat[i][j];
//					}
//					System.out.print(num+" ");
//				}
//				System.out.println();
//			}
//		 }
//		 if(type==4) {
//			 //chat
//				for(int i=0;i<chat.length;i++) {
//				for(int j=0;j<chat.length;j++) {
//					int num = 0;
//					if(chat[i][j]!=0) {
//						num = chatatack[i][j]*1000;
//						num /= chat[i][j];
//					}
//					System.out.print(num+" ");
//				}
//				System.out.println();
//			}
//		 }
//		 
//		 if(type==2) {//longpass
//			 //chat
//			 for(int i=0;i<chat.length;i++) {
//				for(int j=0;j<chat.length;j++) {
//					int num=0;
//					//DecimalFormat df =new DecimalFormat("0.000");
//					if(chat[i][j]!=0) {
//						num = chatshortpass[i][j]*1000;
//						num /=chat[i][j];
//						//System.out.print(df.format((float)chatlongpass[i][j]/chat[i][j]));
//					}
//					System.out.print(num+" ");
//				}
//				System.out.println();
//			}
//		 }
//		 if(type==1) {
//			 //chat
//				for(int i=0;i<chat.length;i++) {
//				for(int j=0;j<chat.length;j++) {
//					System.out.print(chat[i][j]+" ");
//				}
//				System.out.println();
//			}
//		 }
//		 if(type==3) {//longpass
//			 //chat
//			 for(int i=0;i<chat.length;i++) {
//				for(int j=0;j<chat.length;j++) {
//					int num=0;
//					//DecimalFormat df =new DecimalFormat("0.000");
//					if(chat[i][j]!=0) {
//						num = chatlongpass[i][j]*1000;
//						num /=chat[i][j];
//						//System.out.print(df.format((float)chatlongpass[i][j]/chat[i][j]));
//					}
//					System.out.print(num+" ");
//				}
//				System.out.println();
//			}
//		 }
//	 }
//	 
//	 static void print(int type) {
//		 if(type==1) {
//			 //chat
//				for(int i=0;i<chat.length;i++) {
//				for(int j=0;j<chat.length;j++) {
//					System.out.print(chat[i][j]+" ");
//				}
//				System.out.println();
//			}
//		 }
//		 if(type==2) {//shortpass
//			 //chat
//				for(int i=0;i<chat.length;i++) {
//				for(int j=0;j<chat.length;j++) {
//					System.out.print(chatshortpass[i][j]+" ");
//				}
//				System.out.println();
//			}
//		 }
//		 if(type==3) {//longpass
//			 //chat
//				for(int i=0;i<chat.length;i++) {
//				for(int j=0;j<chat.length;j++) {
//					System.out.print(chatlongpass[i][j]+" ");
//				}
//				System.out.println();
//			}
//		 }
//	 }
//	 
//	public static void main(String[] args) throws IOException {
//		
//		for(int i=0;i<chat.length;i++) {
//			for(int j=0;j<chat.length;j++) {
//				chat[i][j]=0;
//				chatshortpass[i][j]=0;
//				chatlongpass[i][j]=0;
//				chatatack[i][j]=0;
//			}
//		}
//			
//		
//		File writename = new File("TeamNumber.txt"); //���
//		String pathname = "fullevent.txt";//����
//		
//		writename.createNewFile(); BufferedWriter out = new BufferedWriter(new FileWriter(writename)); 
//		File filename = new File(pathname); InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));BufferedReader br = new BufferedReader(reader); 
//		
//		String line = "";
//		line = br.readLine();line = br.readLine();
//		
//		String playidString = "Huskies_G";//�����ַ���
//		Vector<String>ssStrings = new Vector<String>();
//		int time=0;
//		int match = 1;
//		
//		while (line != null) {
//			String nameString=null;//,x1 = null,x2= null,y1= null,y2= null;
//			String[] arr = line.split(",");
//			
//			if(!arr[1].equals("Huskies")) {
//				line = br.readLine(); // һ�ζ���һ������
//				continue;
//			}
//			String currmatchString = ""+match;
//			if(!arr[0].equals(currmatchString)) {
//				for(int i=0;i<ssStrings.size();i++) {//������������
//					if(time>=90)
//						break;
//					if(!(ssStrings.get(i).length()==0)) {
//						for(int j=i+1;j<ssStrings.size();j++) {
//							if(!(ssStrings.get(j).length()==0)) {
//								int x = getX(ssStrings.get(i));//����
//								int y = getX(ssStrings.get(j));
//								//System.out.println((getTime(arr[4],arr[5])+" "+time));
//								chat[x][y]+=(90-time);
//								chat[y][x]+=(90-time);	
//							}
//						}
//					}
//				}
//				time=0;
//				match++;
//				ssStrings.clear();
//				line = br.readLine();
//				continue;
//			}
//	
//			// ��Ϊ���˵���Ϊʱ���  �ó������ϴλ��˻򿪳���ʱ��
//			if(arr[6].equals("Substitution")) {
//				//������ӡvector
//				for(int i=0;i<ssStrings.size();i++) {
//					if(!(ssStrings.get(i).length()==0)) {
//						for(int j=i+1;j<ssStrings.size();j++) {
//							if(!(ssStrings.get(j).length()==0)) {
//								int x = getX(ssStrings.get(i));//����
//								int y = getX(ssStrings.get(j));
//								//System.out.println((getTime(arr[4],arr[5])+" "+time));
//								chat[x][y]+=(getTime(arr[4],arr[5])-time);
//								chat[y][x]+=(getTime(arr[4],arr[5])-time);	
//							}
//						}
//					}
//				}
//				time=getTime(arr[4],arr[5]);
//				//����
//				ssStrings.clear();
//				//System.out.println("-------"+arr[4]+" "+arr[5]+" "+arr[3]+"  ����  "+arr[2]);
//				line = br.readLine();
//				continue;
//			}
//			
//			int flag1=0,flag2=0;
//			for(int i=0;i<ssStrings.size();i++) {
//				if(arr[2].equals(ssStrings.get(i)))
//					flag1=1;
//				if(arr[3].equals(ssStrings.get(i)))
//					flag2=1;
//				if(flag1==1&&flag2==1)
//					break;
//			}			
//			if(flag1==0)
//				ssStrings.add(arr[2]);
//			if(flag2==0)
//				ssStrings.add(arr[3]);
//		
//			line = br.readLine(); // һ�ζ���һ������				
//		}
//		
//		//��ȡpass��
////		System.out.println("gg");
//		String pathname1 = "passevent.txt";//����
//		
//		File filename1 = new File(pathname1); InputStreamReader reader1 = new InputStreamReader(new FileInputStream(filename1));BufferedReader br1 = new BufferedReader(reader1); 
//		
//		String line1 = "";
//		line1 = br1.readLine();line1 = br1.readLine();
//		
//		while (line1 != null) {
//			String nameString=null;int x1=0,x2=0,y1=0,y2=0;// = null,x2= null,y1= null,y2= null;
//			String[] arr = line1.split(",");
//			x1=Double.valueOf(arr[7]).intValue();
//			y1=Double.valueOf(arr[8]).intValue();
//			x2=Double.valueOf(arr[9]).intValue();
//			y2=Double.valueOf(arr[10]).intValue();
//			
//			if(arr[1].equals("Huskies")) {
//					ggnum(arr[2],arr[3],x1,y1,x2,y2);
//					//System.out.println(line1);
//			}
//				
//			line1 = br1.readLine(); // һ�ζ���һ������
//		}
////		print(3);
////		System.out.println();
////		print(1);
////		System.out.println();
//		printrus(5);
////		for(int i=0;i<chat.length;i++) {
////			for(int j=0;j<chat.length;j++) {
////				System.out.print(chat[i][j]+" ");
////			}
////			System.out.println();
////		}
//
//		out.close(); // ���ǵùر��ļ�
//	}
//}
//
//
////int flag=1;
////for(int j=0;j<ssStrings.size();j++) {
////	if(j>i)
////		break;
////	if(!(ssStrings.get(j).length()==0))
////		flag++;
////}
////System.out.println(flag);
//
////for(int i=0;i<ssStrings.size();i++) {
////	if(!(ssStrings.get(i).length()==0))
////		System.out.println(ssStrings.get(i)+" ");
////}
////	out.write(team1.matchs.get(i).y+" ");
////	out.flush();
//
////	System.out.println("hhh"+arr[2]+"ggg"+arr[3]+"rrr");
////	if(arr[3].length()==0)
////		continue;
//	//System.out.println(arr[3].length());
//	//��ͣ�¼�
//
//
////if(arr[3].equals(ssStrings.get(i))) {//�����Ա�ڳ���
////	if(arr[4].equals(ssStrings.get(i))) {//�����Ա�ڳ���
////		break;
////	}
////}
////ssStrings.add(arr[3]);int flag = 0;
////for(int j=0;j<ssStrings.size();j++) {
////	if(arr[4].equals(ssStrings.get(i))) {//�����Ա�ڳ���
////		flag = 1;break;
////	}
////}
////if(flag==0) {//û���ҵ������Ա
////	ssStrings.add(arr[4]);
////}
////for(int i=0;i<arr.length;i++) {
////if(arr[i].equals("Substitution")) {
////	System.out.println(line);
////}
////continue;
////}
////if(arr[1].equals("Huskies")) {
////
////ggnum(arr[2],arr[3]);
////
////}
//
////for(int i=0;i<chat.length;i++) {
////	for(int j=0;j<chat.length;j++) {
////		System.out.print(chat[i][j]+" ");
////	}
////	System.out.println();
////}
//
////if(!arr[0].equals("1")) {
////for(int i=0;i<ssStrings.size();i++) {
////	if(!(ssStrings.get(i).length()==0))
////		System.out.println(ssStrings.get(i)+" ");
////}
////break;
////}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////package analyse;
////
////import java.io.BufferedReader;
////import java.io.BufferedWriter;
////import java.io.File;
////import java.io.FileInputStream;
////import java.io.FileWriter;
////import java.io.IOException;
////import java.io.InputStreamReader;
////import java.util.Vector;
////
////// ע�⣬û�ж�������Ϊ����������������
////public class Backup {
////	public static void main(String[] args) {
////		String string = ",,,123,,";
////		String[] arr = string.split(",");
////		for(int i=0;i<arr.length;i++) {
////			System.out.println(arr[i]+" ");
////		}
////	}
////}
////
////public class Gg {
////	static team team1 = new team();
////
////	static int[][] chat = new int[30][30];
////	 static void ggnum(String Name1,String Name2) {
////			int x=0;int y=0;
////			String nameF = "Huskies_F";
////			String nameM = "Huskies_M";
////			String nameD = "Huskies_D";
////			String nameG = "Huskies_G";
////			if(Name1.substring(0, 9).equals(nameF)) {
////				x=Integer.valueOf(Name1.substring(9))-1;
////			}
////			else if(Name1.substring(0, 9).equals(nameM)) {
////				x=Integer.valueOf(Name1.substring(9))+5;
////			}
////			else if(Name1.substring(0, 9).equals(nameD)) {
////				x=Integer.valueOf(Name1.substring(9))+18;
////			}
////			else if(Name1.substring(0, 9).equals(nameG)) {
////				x=Integer.valueOf(Name1.substring(9))+28;
////			}
////			
////			if(Name2.substring(0, 9).equals(nameF)) {
////				y=Integer.valueOf(Name2.substring(9))-1;
////			}
////			else if(Name2.substring(0, 9).equals(nameM)) {
////				y=Integer.valueOf(Name2.substring(9))+5;
////			}
////			else if(Name2.substring(0, 9).equals(nameD)) {
////				y=Integer.valueOf(Name2.substring(9))+18;
////			}
////			else if(Name2.substring(0, 9).equals(nameG)) {
////				y=Integer.valueOf(Name2.substring(9))+28;
////			}
////			chat[x][y]++;
////			chat[y][x]++;
////		}
////
////	public static void main(String[] args) throws IOException {
////		System.out.println(chat.length);
////		
////		for(int i=0;i<chat.length;i++) {
////			for(int j=0;j<chat.length;j++) {
////				chat[i][j]=0;
////			}
////		}
////		
////		File writename = new File("PassMatch1_Huskies_G.txt"); // ���·�������û����Ҫ����һ���µ�output��txt�ļ�
////		writename.createNewFile(); // �������ļ�
////		BufferedWriter out = new BufferedWriter(new FileWriter(writename));
////		String pathname = "gg.txt"; // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��
////		File filename = new File(pathname); // Ҫ��ȡ����·����input��txt�ļ�
////		InputStreamReader reader = new InputStreamReader(
////				new FileInputStream(filename)); // ����һ������������reader
////		BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������
////		String line = "";
////		line = br.readLine();
////		line = br.readLine();
////		//out.write("hold on;\n");
////		String playidString = "Huskies_G";
////		
////		while (line != null) {
////			String nameString=null,x1 = null,x2= null,y1= null,y2= null;
////			String[] arr = line.split(",");
////			//if(arr[0].equals("1")) {
////				if(arr[1].equals("Huskies")) {
//////					System.out.println(arr[2]);
//////					System.out.println(arr[3].substring(9));
////					ggnum(arr[2],arr[3]);
////
//////					System.out.println(arr[2].substring(0, 9));
//////					if(arr[2].substring(0, 9).equals(playidString)) {
//////						match match1 = new match(arr[7], arr[8]);
//////						team1.setmatch(match1);
//////					}
//////					if(arr[3].substring(0, 9).equals(playidString)) {
//////						match match1 = new match(arr[9], arr[10]);
//////						team1.setmatch(match1);
//////					}
////				}
////			//}
//////			else {
//////				break;
//////			}					
////			line = br.readLine(); // һ�ζ���һ������
////		}
////		for(int i=0;i<chat.length;i++) {
////			for(int j=0;j<chat.length;j++) {
////				System.out.print(chat[i][j]+" ");
////			}
////			System.out.println();
////		}
////		
//////		out.write("x=[");
//////		for (int i = 0; i < team1.matchs.size(); i++) {
//////			out.write(team1.matchs.get(i).x+" ");
//////			out.flush();
//////		}
//////		out.write("];\n");
//////		
//////		out.write("y=[");
//////		for (int i = 0; i < team1.matchs.size(); i++) {
//////			out.write(team1.matchs.get(i).y+" ");
//////			out.flush();
//////		}
//////		out.write("];\n");
////		
////		out.close(); // ���ǵùر��ļ�
////	}
////}
////
////class checknum{
////	public static void main(String[] args) {
////
////	}
////}
////
////class player{
////	String playernameString;
////	String numberString;
////	int num;
////	public player(String playname) {
////		this.playernameString = playname;
////		// TODO Auto-generated constructor stub
////	}
////	Vector<player>players = new Vector<player>();
////	void searchname(String nameString) {
////		for(int i=0;i<this.players.size();i++) {//�ҵ�
////			if(this.players.get(i).playernameString.equals(nameString)) {//�ҵ���
////				this.players.get(i).num++;
////				break;
////			}
////		}
////		player newpPlayer = new player(nameString);
////		newpPlayer.num = 1;
////	}
////}
////
////
////class team {
////	String TeamID;
//////	Vector<done>dones = new Vector<done>();
//////	void setdone(done d1) {
//////		this.dones.add(d1);
//////	}
////	Vector<match>matchs = new Vector<match>();
////	void setmatch(match m1) {
////		this.matchs.add(m1);
////	}
////}
////class match{
////	String x;
////	String y;
////	//String playid;
////	public match(String x,String y) {
////		this.x = x;
////		this.y = y;
////	//	this.playid=idString;
////		// TODO Auto-generated constructor stub
////	}
////}
//////String name1 = "Huskies_F1";	String name2 = "Huskies_F1";	String name3 = "Huskies_F1";	String name4 = "Huskies_F1";	String name5 = "Huskies_F1";	String name6 = "Huskies_F1";
//////String nameD1="Huskies_D1";String nameD2="Huskies_D2";
//////String nameD3="Huskies_D3";String nameD4="Huskies_D4";
//////String nameD5="Huskies_D5";String nameD6="Huskies_D6";
//////String nameD7="Huskies_D7";String nameD8="Huskies_D7";
//////String nameD9="Huskies_D9";String nameD10="Huskies_D10";
//////String nameM1="Huskies_M1";String nameM2="Huskies_M2";
//////String nameM3="Huskies_M3";String nameM4="Huskies_M4";
//////String nameM5="Huskies_M5";String nameM6="Huskies_M6";
//////String nameM7="Huskies_M7";String nameM8="Huskies_M8";
//////String nameM9="Huskies_M9";String nameM10="Huskies_M10";
//////String nameM11="Huskies_M11";String nameM12="Huskies_M12";
//////String nameM13="Huskies_M13";
//////String nameG1 ="Huskies_G1";
//////public void writeExcel(){
////////��ʼд��excel,����ģ���ļ�ͷ
//////String[] titleA = {"id","Cgonghao","Cname"};        
////////����Excel�ļ���B��CD���ļ�
//////File fileA = new File("e:/TestFile.xls");
//////if(fileA.exists()){
//////  //����ļ����ھ�ɾ��
//////  fileA.delete();
//////}
//////try {
//////  fileA.createNewFile();
//////  //����������
//////  WritableWorkbook workbookA = Workbook.createWorkbook(fileA);            
//////  //����sheet
//////  WritableSheet sheetA = workbookA.createSheet("sheet1", 0);
//////  Label labelA = null;            
//////  //��������
//////  for (int i = 0; i < titleA.length; i++) {
//////      labelA = new Label(i,0,titleA[i]);
//////      sheetA.addCell(labelA);    
//////  }            
//////  //��ȡ����Դ
//////  for (int i = 1; i < 10; i++) {
//////      labelA = new Label(0,i,i+" ");
//////      sheetA.addCell(labelA);
//////      labelA = new Label(1,i,"20180101" + i);
//////      sheetA.addCell(labelA);
//////      labelA = new Label(2,i,"����00"+i);
//////      sheetA.addCell(labelA);
//////  }
//////  workbookA.write();    //д������        
//////  workbookA.close();  //�ر�����
//////  logger.info("�ɹ�д���ļ�����ǰ��E�̲鿴�ļ���");
//////
//////} catch (Exception e) {
//////  logger.info("�ļ�д��ʧ�ܣ����쳣...");
//////}
//////}	
//////
//////static player player1 = new player(playname)
////// 
//////class cin_txt {
//////	static void main(String args[]) {
//////		try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw
////// 
//////			/* ����TXT�ļ� */
//////			String pathname = "gg.txt"; // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��
//////			File filename = new File(pathname); // Ҫ��ȡ����·����input��txt�ļ�
//////			InputStreamReader reader = new InputStreamReader(
//////					new FileInputStream(filename)); // ����һ������������reader
//////			BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������
//////			String line = "";
//////			line = br.readLine();
//////			while (line != null) {
//////				
//////				line = br.readLine(); // һ�ζ���һ������
//////			}
////// 
//////			/* д��Txt�ļ� */
//////			File writename = new File(".\\result\\en\\output.txt"); // ���·�������û����Ҫ����һ���µ�output��txt�ļ�
//////			writename.createNewFile(); // �������ļ�
//////			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
//////			out.write("�һ�д���ļ���\r\n"); // \r\n��Ϊ����
//////			out.flush(); // �ѻ���������ѹ���ļ�
//////			out.close(); // ���ǵùر��ļ�
////// 
//////		} catch (Exception e) {
//////			e.printStackTrace();
//////		}
//////	}
//////}
////
////
////
//////match match1 = new match(arr[7], arr[8]);
//////match match2 = new match(arr[9], arr[10]);
//////team1.setmatch(match1);
//////team1.setmatch(match2);
//////x1 = arr[7];
//////y1 = arr[8];
//////x2 = arr[9];
//////y2 = arr[10];
//////
//////out.write("A=["+x1+","+x2+"];\n");
//////out.write("B=["+y1+","+y2+"];\n");
//////out.write("plot(A,B,'b*-');\n");//plot(A,B,'b*-');
//////out.flush(); // �ѻ���������ѹ���ļ�
////
////
//////if(arr[0].equals("1")) {
////		//do sth
//////}
//////else {
//////	break;
//////}	