import java.util.*;


public class test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] str = new String[6];
		
		int i = 0;
		System.out.println("enter 6 strings: ");
		while(i<6) {
			str[i] = input.next();
			i++;
		}
		
		System.out.println(str);
	}

}
