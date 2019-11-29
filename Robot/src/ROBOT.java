import java.util.Scanner;

public class ROBOT {
	
	public static String dichuyenL(String a,int b) {
		switch (a) {
		case "E":
			if (b==0) a="E";
			else if (b==1) a="N";
			else if (b==2) a="W";
			else a = "S";
			break;
		case "N":
			if (b==0) a="N";
			else if (b==1) a="W";
			else if (b==2) a="S";
			else a = "E";
			break;
		case "W":
			if (b==0) a="W";
			else if (b==1) a="S";
			else if (b==2) a="E";
			else a = "N";
			break;

		default:
			if (b==0) a="S";
			else if (b==1) a="E";
			else if (b==2) a="N";
			else a = "W";
			break;
		}
		return a;
	}
	public static String dichuyenR(String a,int b) {
		switch (a) {
		case "E":
			if (b==0) a="E";
			else if (b==1) a="S";
			else if (b==2) a="W";
			else a = "N";
			break;
		case "N":
			if (b==0) a="N";
			else if (b==1) a="E";
			else if (b==2) a="S";
			else a = "W";
			break;
		case "W":
			if (b==0) a="W";
			else if (b==1) a="N";
			else if (b==2) a="E";
			else a = "S";
			break;

		default:
			if (b==0) a="S";
			else if (b==1) a="W";
			else if (b==2) a="N";
			else a = "E";
			break;
		}
		return a;
	}
	public static byte[] dichuyenF(byte x11,byte x12,String x13,byte x21,byte x22,int c,byte m,byte n) {
		byte[] f=new byte[10] ;
		byte rb1=-1; x12 =x12;x11=x11;
		switch (x13) {
		case "E":
			for (int i =1;i<=c;i++) {
				x11++;
				if (x11==x21&&x12==x22) {rb1=3;f[2]=2;f[1] = rb1;f[3] = x11;f[4] = x12;return f;}
				else if (x11>m) {rb1 = 1;f[1] = rb1;f[3] = x11;f[4] = x12;return f;}
				else rb1 =0;
			}
			break;
		case "N":
			for (int i =1;i<=c;i++) {
				x12++;
				if (x11==x21&&x12==x22) {rb1=3;f[2]=2;f[1] = rb1;f[3] = x11;f[4] = x12;return f;}
				else if (x12>n) {rb1 = 1;f[1] = rb1;f[3] = x11;f[4] = x12;return f;}
				else rb1 =0;
			}
			break;
		case "W":
			for (int i =1;i<=c;i++) {
				x11--;
				if (x11==x21&&x12==x22) {rb1=3;f[1] = rb1;f[2]=2;f[3] = x11;f[4] = x12;return f;}
				else if (x11<1) {rb1 = 1;f[1] = rb1;f[3] = x11;f[4] = x12;return f;}
				else rb1 =0;				
			}
			break;

		default:
			for (int i =1;i<=c;i++) {
				x12--;
				if (x11==x21&&x12==x22) {rb1=3;f[1] = rb1;f[2]=2;f[3] = x11;f[4] = x12;return f;}
				else if (x12<1) {rb1 = 1;f[1] = rb1;f[3] = x11;f[4] = x12;return f;}
				else rb1 =0;
			}
			break;
		}
		f[1] = rb1; f[3] = x11;f[4] = x12;
		return f;
	}
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		byte rb1 =0,rb2=0;  // 2 biến in ra màn hình
		
		byte m =sc.nextByte();
		byte n = sc.nextByte();   //kích thước mxn 
		
		byte x =sc.nextByte();//luôn bằng 2
		byte k= sc.nextByte(); //số lần di chuyển của cả robot
		
		byte x11 = sc.nextByte();  //tọa độ rb1
		byte x12 = sc.nextByte();
		String x13 = sc.next(); // hướng di chuyển ban đầu rb1
		
		byte x21 = sc.nextByte();  //tọa độ rb2
		byte x22 = sc.nextByte();
		String x23 = sc.next();  // hướng di chuyển ban đầu rb2
		
		for (byte i=1;i<=k;i++) {
			byte a =sc.nextByte();  // rb phải di chuyển
			String b = sc.next();  //cách thức di chuyển của rb
			int c =sc.nextByte();   //số bước di chuyển của rb
			 if (rb1==0&&rb2==0) {
			 if (a==1) {
				 switch (b) {
				case "L":
					 c%=4;
					 x13=dichuyenL(x13,c);
					break;
				case "R":
					 c%=4;
					 x13=dichuyenR(x13,c);
					break;
				default:
					rb1=dichuyenF(x11,x12,x13,x21,x22,c,m,n)[1];
					x11=dichuyenF(x11,x12,x13,x21,x22,c,m,n)[3];
					x12=dichuyenF(x11,x12,x13,x21,x22,c,m,n)[4];
					break;}}
			 else { 
					 switch (b) {
						case "L":
							 c%=4;
							 x23=dichuyenL(x23,c);
							break;
						case "R":
							 c%=4;
							 x23=dichuyenR(x23,c);
							break;
						default:
							rb2=dichuyenF(x21,x22,x23,x11,x12,c,m,n)[1];
							x21=dichuyenF(x21,x22,x23,x11,x12,c,m,n)[3];
							x22=dichuyenF(x21,x22,x23,x11,x12,c,m,n)[4];
							break;
						}
				 }
			 }else break;
		}
		if (rb1==3||rb2 ==3) {rb1 = 1;rb2 =2;}
		System.out.println(rb1+"  "+rb2);
		

	}

}
