package cn.tjuscs.st;

public class pocket {
	public static  boolean take(int x) {
		int sum = 0;
		boolean log = false;
		int []pocket = new int[] {50, 20, 10, 5, 1};
		for (int i = 0; i <= x/pocket[0] && i <= 1; i++) {
			for (int j = 0; j <= x/pocket[1] && j <= 1; j++) {
				for (int k = 0; k <= x/pocket[2] && k <= 1; k++) {
					for (int l = 0; l <= x/pocket[3] && l <=2; l++) {
						int m = x - (i * pocket[0] + j * pocket[1] + k * pocket[2] + l * pocket[3]);
						sum = i * pocket[0] + j * pocket[1] + k * pocket[2] + l * pocket[3] + m;
						if (sum == x && m >=0 && m <= 3) {
							log = true;
							System.out.println("You can take out the money " + x + " yuan");
							System.out.println("50yuan * " + i );
							System.out.println("20yuan * " + j );
							System.out.println("10yuan * " + k );
							System.out.println(" 5yuan * " + l );
							System.out.println(" 1yuan * " + m );
						}
					}
				}
			}
		}
		if (!log) {
			System.out.println("You can not take out the money " + x + " yuan");
		}
		return log;
	}
//	public static void main(String[] args) {
//		take(0);
//	}
}
