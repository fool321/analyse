//package analyse;
//
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Vector;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//import jxl.write.Label;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//import jxl.write.biff.RowsExceededException;
//
//
//public class Analyse {
//	static team[] teams=new team[30];
//	static int gla=0;
//	public static void main(String[] args) {
//		try {
//			readExcel("fullevents.xls");
//		} catch (BiffException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
////		System.out.println(gla);
////		try {
////			writeExcel();
////		} catch (WriteException | IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
//		//System.out.println("gg");
//	
//
//	
//	private static void readExcel(String filename) throws BiffException, IOException   {
//		File xlsFile = new File(filename);
//		// 获得工作簿对象
//		Workbook workbook = Workbook.getWorkbook(xlsFile);
//		// 获得所有工作表
//		Sheet[] sheets = workbook.getSheets();
//		// 遍历工作表
//		if (sheets != null) {
//			for (Sheet sheet : sheets) {
//				// 获得行数
//				int rows = sheet.getRows();
//				// 获得列数
//				int cols = sheet.getColumns();
//				// 读取数据
//				System.out.println(rows+" "+cols);
//				for (int row = 1; row < rows; row++) {
//					for (int col = 0; col < cols; col++) {
//						Cell cell = sheet.getCell(col, row);   
//						String[] strings = cell.getContents().split(",");
//						for(int i=0;i<strings.length;i++) {
//							//System.out.println(strings[i]+" ");
//						}
////						System.out.println(strings[0]);
////	                    int id = Integer.valueOf(strings[0]);
////	                    done done = new done(strings[0],strings[1], strings[2], strings[3], strings[4], strings[5], strings[6], strings[7], strings[8], strings[9], strings[10]);                   
////	                    teams[id].setdone(done);
//	              
//					}
//					//System.out.println();
//					gla++;
//				}
//			}
//		}
//		workbook.close();
//	}
//	
//
//	 static void writeExcel() throws IOException, RowsExceededException,WriteException {
//		
//		File xlsFile = new File("jxl.xls");
//		// 创建一个工作簿
//		WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);
//		// 创建一个工作表
//		WritableSheet sheet = workbook.createSheet("sheet1", 0);
//		// 向行和列中写数据
//		for (int row = 0; row < 10; row++) {
//			for (int col = 0; col < 10; col++) {
//				// 向工作表中添加数据
//				sheet.addCell(new Label(col, row, "data" + row + col));
//			}
//		}
//		workbook.write();
//		workbook.close();
//	}
//}
//class team {
//	String TeamID;
//	Vector<done>dones = new Vector<done>();
//	void setdone(done d1) {
//		this.dones.add(d1);
//	}
//	Vector<match>matchs = new Vector<match>();
//	void setmatch(match m1) {
//		this.matchs.add(m1);
//	}
//}
//
//class match{
//	String matchID;
//	String OpponentID;
//	String Outcome;
//	String OwnScore;
//	String OpponentScore;
//	String Side;
//	String CoachID;
//	public match() {
//		this.matchID=matchID;
//		this.OpponentID=OpponentID;
//		this.Outcome=Outcome;
//		this.OwnScore=OwnScore;
//		this.OpponentScore=OpponentScore;
//		this.Side=Side;
//		this.CoachID=CoachID;
//		// TODO Auto-generated constructor stub
//	}
//
//}
//class done {
//	String MatchId;
//	String OriginPlayerID;
//	String DestinationplayID;
//	String matchPeriod;
//	String EventTime;
//	String EventType;
//	String EventSubtype;
//	String EventOrigin_X;
//	String EventOrigin_Y;
//	String EventDedestination_X;
//	String EventDedestination_Y;
//	
//	public done(String MatchId,String OriginPlayerID,String DestinationplayID,String matchPeriod,String EventTime,String EventType,String EventSubtype,String EventOrigin_X,String EventOrigin_Y,String EventDedestination_X,String EventDedestination_Y) {
//		this.MatchId=MatchId;
//		this.OriginPlayerID=OriginPlayerID;
//		this.DestinationplayID=DestinationplayID;
//		this.matchPeriod=matchPeriod;
//		this.EventTime=EventTime;
//		this.EventType=EventType;
//		this.EventSubtype=EventSubtype;
//		this.EventOrigin_X=EventOrigin_X;
//		this.EventOrigin_Y=EventOrigin_Y;
//		this.EventDedestination_X=EventDedestination_X;
//		this.EventDedestination_Y=EventDedestination_Y;
//		// TODO Auto-generated constructor stub
//	}
//	
//}
