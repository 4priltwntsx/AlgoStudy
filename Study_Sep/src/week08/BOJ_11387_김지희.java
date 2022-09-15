package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//님 무기가 좀 나쁘시네여
public class BOJ_11387_김지희 {
	static class CombatPower{
		int attack, power, prob, damage, speed;

		public CombatPower(int attack, int power, int prob, int damage, int speed) {
			this.attack = attack;
			this.power = power;
			this.prob = prob;
			this.damage = damage;
			this.speed = speed;
		}
	}
	
	static CombatPower[] arr;
	static CombatPower[] plus;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new CombatPower[2];
		plus = new CombatPower[2];
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int pw = Integer.parseInt(st.nextToken());
			int pr = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			if(i<2) {
				arr[i] = new CombatPower(a, pw, pr, d, s);	
			}
			
			else {
				plus[i-2] = new CombatPower(a, pw, pr, d, s);
			}
		}
		float c = calc(arr[0]); //현재 전투력
		float p = calc(arr[1]);
		CombatPower pc = new CombatPower(arr[0].attack-plus[0].attack+plus[1].attack, arr[0].power-plus[0].power +plus[1].power , 
				arr[0].prob-plus[0].prob+plus[1].prob, arr[0].damage-plus[0].damage+plus[1].damage, 
				arr[0].speed-plus[0].speed+plus[1].speed);
		CombatPower pp = new CombatPower(arr[1].attack+plus[0].attack-plus[1].attack, arr[1].power+plus[0].power -plus[1].power , 
				arr[1].prob+plus[0].prob-plus[1].prob, arr[1].damage+plus[0].damage-plus[1].damage, 
				arr[1].speed+plus[0].speed-plus[1].speed);
		float nc = calc(pc);
		float np = calc(pp);
		
		if(c>nc) System.out.println("-");
		else if(c==nc) System.out.println("0");
		else System.out.println("+");
		
		
		if(p>np) System.out.println("-");
		else if(p==np) System.out.println("0");
		else System.out.println("+");
		
		
	}
	
	private static float calc(CombatPower cur) {
		//전투력 = attack(1+pw/100) X [{1-min(prob, 1)} + min(prob, 1) X damage] x {1+ speed)
		float tempProb = (float)cur.prob/100;
		float tempDmg = (float)cur.damage/100;
		float tempSpd = (float)cur.speed/100;
		
		float result = cur.attack * (1+(float)cur.power/100) * ((1-Math.min(tempProb, 1)) + Math.min(tempProb, 1) * tempDmg) * (1+tempSpd);
		
		return result;
	}
	
}
