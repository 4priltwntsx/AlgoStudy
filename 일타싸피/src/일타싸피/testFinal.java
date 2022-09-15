package 일타싸피;

public class testFinal {

   static final int TABLE_WIDTH = 254;
   static final int TABLE_HEIGHT = 127;
   static final int NUMBER_OF_BALLS = 6;
   static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

   public static void main(String[] args) {
      float[][] balls = new float[NUMBER_OF_BALLS][2];
      float angle = 0.0f;
      float power = 0.0f;

      balls[0][0] = 64.0f; // 흰 공
      balls[0][1] = 64.0f;
      balls[1][0] = 134.0f; // 타켓 공
      balls[1][1] = 121.0f;

      for (int i = 0; i < NUMBER_OF_BALLS; i++) {
         System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
      }
      float whiteBall_x = balls[0][0];
      float whiteBall_y = balls[0][1];

      int x = -1;
      for (int i = 1; i < NUMBER_OF_BALLS; i++) {
         if (!(balls[i][0] == -1 && balls[i][1] == -1)) {
            x = i;
            break;
         }
      }

      float targetBall_x = balls[x][0];
      float targetBall_y = balls[x][1];

      // 타켓 공 잡기
      int MIN = Integer.MAX_VALUE;
      int holes_x = 0;
      int holes_y = 0;
      for (int i = 0; i < 6; i++) {
         double c = Math.sqrt((Math.abs(HOLES[i][0] - whiteBall_x) * Math.abs(HOLES[i][0] - whiteBall_x))
               + (Math.abs(HOLES[i][1] - whiteBall_y) * Math.abs(HOLES[i][1] - whiteBall_y)));
         double a = Math.sqrt((Math.abs(targetBall_x - whiteBall_x) * Math.abs(targetBall_x - whiteBall_x))
               + (Math.abs(targetBall_y - whiteBall_y) * Math.abs(targetBall_y - whiteBall_y)));
         double b = Math.sqrt((Math.abs(targetBall_x - HOLES[i][0]) * Math.abs(targetBall_x - HOLES[i][0]))
               + (Math.abs(targetBall_y - HOLES[i][1]) * Math.abs(targetBall_y - HOLES[i][1])));
         if (c * c > (a * a) + (b * b)) {
            if (MIN > b) {
               holes_x = HOLES[i][0];
               holes_y = HOLES[i][1];
               MIN = (int) b;
            }
         }
      }

      System.out.println("넣어야할 홀-------------------------");
      System.out.println(holes_x + " " + holes_y);

      float w = Math.abs(targetBall_x - holes_x);
      float h = Math.abs(targetBall_y - holes_y);
      double d = Math.sqrt((w * w) + (h * h));
      System.out.println(d);
      float r = (float) Math.atan(h / w);
      float a = (float) Math.toDegrees(r);
      System.out.println("a의 각도-------------------------");
      System.out.println(a);
      // target과 홀의 각도 구하기

      float temp_x = (float) (Math.cos(r) * (d + 5.73)); // 작은 삼각형의 가로
      float temp_y = (float) (Math.sin(r) * (d + 5.73)); // 작은 삼각형의 세로

      if (whiteBall_x < targetBall_x && whiteBall_y < targetBall_y) {
         System.out.println("1사분면");
         temp_x = holes_x - temp_x;
         temp_y = holes_y - temp_y;
         System.out.println("임시공의 좌표값-------------------------");
         System.out.println(temp_x + " " + temp_y);

         // 임시구들과 계산한 값
         float width = Math.abs(temp_x - whiteBall_x);
         float height = Math.abs(temp_y - whiteBall_y);
         double radian = Math.atan(width / height);
         angle = (float) Math.toDegrees(radian);

      } else if (whiteBall_x < targetBall_x && whiteBall_y > targetBall_y) {
         System.out.println("2사분면");
         temp_x = holes_x - temp_x;
         temp_y = holes_y + temp_y;
         System.out.println("임시공의 좌표값-------------------------");
         System.out.println(temp_x + " " + temp_y);
         temp_x = 208;
         temp_y = 13;
         // 임시구들과 계산한 값
         float width = Math.abs(temp_x - whiteBall_x);
         float height = Math.abs(temp_y - whiteBall_y);
         double radian = Math.atan(height / width);
         angle = (float) (Math.toDegrees(radian) + 90);

      } else if (whiteBall_x > targetBall_x && whiteBall_y > targetBall_y) {
         System.out.println("3사분면");
         temp_x = holes_x + temp_x;
         temp_y = holes_y + temp_y;
         System.out.println(temp_x + " " + temp_y);

         // 임시구들과 계산한 값
         float width = Math.abs(temp_x - whiteBall_x);
         float height = Math.abs(temp_y - whiteBall_y);
         double radian = Math.atan(width / height);
         angle = (float) (Math.toDegrees(radian) + 180);

      } else if (whiteBall_x > targetBall_x && whiteBall_y < targetBall_y) {
         System.out.println("4사분면");
         temp_x = holes_x + temp_x;
         temp_y = holes_y - temp_y;
         System.out.println(temp_x + " " + temp_y);

         // 임시구들과 계산한 값
         float width = Math.abs(temp_x - whiteBall_x);
         float height = Math.abs(temp_y - whiteBall_y);
         double radian = Math.atan(width / height);
         angle = (float) (Math.toDegrees(radian) * -1 + 360);
      }

      if ((holes_x == targetBall_x) && (whiteBall_x == targetBall_x)) {
         if (holes_y < targetBall_y) {
            angle = 180;
         } else {
            angle = 0;
         }
      }
      System.out.println("최종 각도-------------------------------------");
      // power = (float) distance;
      power = (float) 100; // 그냥 풀파워
      System.out.println(angle);

   }

}