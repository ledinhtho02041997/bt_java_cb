import java.util.Scanner;

public class main {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Nhập số thứ nhất: ");
	String a = sc.nextLine();
	
	System.out.print("Nhập số thứ hai: ");
	String b = sc.nextLine();
	sc.close();
	String kq="";
	int tong=0,du=0;
	
	while (a.length()>0||b.length()>0) {
		if (a.length()==0) a="0";
		if (b.length()==0) b="0";
		String cuoi1 = Character.toString(a.charAt(a.length()-1));
		int c= Integer.parseInt(cuoi1);
		
		String cuoi2 = Character.toString(b.charAt(b.length()-1));
		int d= Integer.parseInt(cuoi2);
		
		tong=(c+d+du)%10;
		du=(c+d+du)/10;
		
		kq=tong+kq;
		a=a.substring(0,a.length()-1);
		b=b.substring(0,b.length()-1);
	}
	System.out.println("Kết quả: "+kq);
}
}
