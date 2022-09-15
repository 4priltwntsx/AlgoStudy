package 일타싸피;

public class test01 {

	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { {0,0}, {127,0}, {254,0}, {0,127}, {127,127},{254,254}};
	
	
	public static void main(String[] args) {
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		

		float angle = 0.0f;
		float power = 0.0f;
		
	    balls[0][0] = 64.0f; // 흰 공
	    balls[0][1] = 64.0f;
	    balls[1][0] = 30.0f; //타겟
	    balls[1][1] = 100.0f;
		
	    for (int i = 0; i < NUMBER_OF_BALLS; i++) {
	         System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
		}		
	    
		float whiteBall_x = balls[0][0];
		float whiteBall_y = balls[0][1];
		
		int x = -1;
		
		for(int i=1; i<NUMBER_OF_BALLS; i++) {
			if(!(balls[i][0] == -1 && balls[i][1] == -1)) {
				x = i;
				break;
			}
		}

		float targetBall_x = balls[x][0];
		float targetBall_y = balls[x][1]; //타겟
		

		// ---------------타겟 홀 찾기 ---------------------------
		int MIN = Integer.MAX_VALUE;
		int hole_x = 0;
		int hole_y = 0;
		
		for(int i=0; i<6; i++) {
			float hx = HOLES[i][0];
			float hy = HOLES[i][1];
			
			//홀-흰공
			double c = Math.sqrt((Math.abs(hx-whiteBall_x))*((Math.abs(hx-whiteBall_x)) + (Math.abs(hy-whiteBall_y))*(Math.abs(hy-whiteBall_y))));
			//흰공-타겟볼
			double  a = Math.sqrt((Math.abs(targetBall_x-whiteBall_x))*(Math.abs(targetBall_x-whiteBall_x)) + (Math.abs(targetBall_y-whiteBall_y))*(Math.abs(targetBall_y-whiteBall_y)));
			//타겟볼 - 홀
			double b = Math.sqrt((Math.abs(targetBall_x-hx))*(Math.abs(targetBall_x-hx)) + (Math.abs(targetBall_y-hy))*(Math.abs(targetBall_y-hy)));
			
			if((c*c)>(a*a)+(b*b)) {  //삼각형
				if(MIN > b) { 
					hole_x = HOLES[i][0];
					hole_y = HOLES[i][1];
					MIN = (int) b;
				}
			}			
		}
		//------------- -----------------------------------
		
		
		float width=  Math.abs(targetBall_x - hole_x);
		float height = Math.abs(targetBall_y - hole_y);
		
		double distance = Math.sqrt((width*width) + (height*height));
		float r = (float) Math.atan(height/width);
		float a = (float) Math.toDegrees(r);
		
		float temp_x = (float) (Math.cos(r) * (distance+5.73)); // 작은 삼각형의 가로
		float temp_y = (float) (Math.sin(r) * (distance+5.73)); // 작은 삼각형의 세로
		
		//////////////////////////////////////////////////////////////
		
		if(whiteBall_x < targetBall_x && whiteBall_y<targetBall_y) {
			// 흰 공 기준 제 1사분면
			System.out.println("1사분면");
			temp_x = hole_x - temp_x;
			temp_y = hole_y - temp_y;
			
			//임시 구들과 계산
			float w = Math.abs(temp_x - whiteBall_x);
			float h = Math.abs(temp_y - whiteBall_y);
			double radian = Math.atan(w/h);
			angle = (float) Math.toDegrees(radian);
		}
		else if(whiteBall_x < targetBall_x && whiteBall_y > targetBall_y) {
			// 흰 공 기준 제 2사분면
			System.out.println("제 2사분면");
			temp_x = hole_x - temp_x;
			temp_y = hole_y + temp_y;
			
			float w = Math.abs(temp_x - whiteBall_x);
			float h = Math.abs(temp_y - whiteBall_y);
			double radian = Math.atan(h/w);
			angle = (float) (Math.toDegrees(radian) + 90);
			
		}
		else if(whiteBall_x > targetBall_x && whiteBall_y > targetBall_y) {
			// 흰 공 기준 제 3사분면
			System.out.println("제 3사분면");
			temp_x = hole_x + temp_x;
			temp_y = hole_y + temp_y;
			
			float w = Math.abs(temp_x - whiteBall_x);
			float h = Math.abs(temp_y - whiteBall_y);
			double radian = Math.atan(w/h);
			angle = (float) (Math.toDegrees(radian) + 180);
		}
		else if(whiteBall_x > targetBall_x && whiteBall_y < targetBall_y) {
			// 흰 공 기준 제 4사분면
			System.out.println("제 4사분면");
			temp_x = hole_x + temp_x;
			temp_y = hole_y - temp_y;
			
			// 임시구들과 계산한 값
			float w = Math.abs(temp_x - whiteBall_x);
			float h = Math.abs(temp_y - whiteBall_y);
			double radian = Math.atan(w/h);
			angle = (float) (360-Math.toDegrees(radian));
		}
		
		if((hole_x == targetBall_x) && (whiteBall_x == targetBall_x)) {
			if(hole_y < targetBall_y) {
				angle = 180;
			}else angle = 0;
		}
		
	      System.out.println("최종 각도-------------------------------------");
	      // power = (float) distance;
	      power = (float) 100; // 그냥 풀파워
	      System.out.println(angle);

		
	}
	
	
}
