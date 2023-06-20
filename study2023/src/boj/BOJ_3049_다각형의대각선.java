package boj;
import java.util.Scanner;

public class BOJ_3049_다각형의대각선 {

	public static void main(String[] args) {
		// n개 중에 4개 꼭지점 고르기만 하면 되는데
		// 음 nC4 .. n! / 4! * (n-4)!
		// -> n * n-1 * n-2 * n-3 / 4!
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println((N*(N-1)*(N-2)*(N-3))/24);
	}
}
