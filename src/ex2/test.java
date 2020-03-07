package ex2;

public class test {
	public static void main(String[] args) {
		String str = "Everything okay but.....!!	I found everything goes well except the plug. Why the left and right is opposite and I have to put the plug upside down for charging!!! Another flaw is the big noise.";
		String[] strings = SpilitSentence.spStrings(str);
		for(String s:strings) {
			System.out.print(s);
		}
	}
}
