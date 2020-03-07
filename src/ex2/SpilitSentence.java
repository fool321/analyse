package ex2;

public class SpilitSentence {
	
	public static String[] spStrings(String str) {
		str = str.toLowerCase();
		str = str.replaceAll("\\s{1,}", " ");
		String str1 = str; 
		//str1 = str1.replaceAll("\\s{1,}", " ");
		str1 = str1.replace(" ","");
		str = str.replaceAll("[\\pP¡®¡¯¡°¡±]", "");
		String[] ggStrings = str.split(" ");
		
		for(int i=0;i<str1.length();i++) {
			if(str1.charAt(i)>='a'&&str1.charAt(i)<='z') {
				continue;
			}
			else {
				ggStrings = insert(ggStrings, str1.charAt(i)+"");
			}
		}
		return ggStrings;
//		for(String s:ggStrings) {
//			System.out.print(s+" ");
//		}
	//		System.out.println("\n"+str1);
	//	System.out.println(ggStrings);
	}
	
	private static String[] insert(String[] arr, String... str) {
		int size = arr.length; 
		int newSize = size + str.length; 
		String[] tmp = new String[newSize]; 
		for (int i = 0; i < size; i++) { 
			tmp[i] = arr[i];
		}
		for (int i = size; i < newSize; i++) {
			tmp[i] = str[i - size];
		} 
		return tmp; 
	}
	public static void main(String[] args) {
		String str = "Everything okay but.....!!	I found everything goes well except the plug. Why the left and right is opposite and I have to put the plug upside down for charging!!! Another flaw is the big noise.";
		spStrings(str);
	}
	
}
