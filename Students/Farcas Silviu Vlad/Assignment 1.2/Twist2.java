public class Twist2{
	public static void main(String[] args){
		int f = getNthfibo(2);
		long sum=0;
		int i;
		for(i=2;f<=4_000_000;i++){
			if(f%2==0)sum += f;
			f = getNthfibo (i+1);
		}
		System.out.println("The sum is " + sum);
	}
	public static int getNthfibo(int n) {
  
        if (n <= 1) return n;

        int[][] result = {{1, 0}, {0, 1}}; // identity matrix.
        int[][] fiboM = {{1, 1}, {1, 0}};

        while (n > 0) {
            if (n%2 == 1) {
                multMatrix(result, fiboM);
            }
            n = n / 2;
            multMatrix(fiboM, fiboM);
        }

        return result[1][0];
    }

    private static void multMatrix(int[][] m, int [][] n) {
        int a = m[0][0] * n[0][0] +  m[0][1] * n[1][0];
        int b = m[0][0] * n[0][1] +  m[0][1] * n[1][1];
        int c = m[1][0] * n[0][0] +  m[1][1] * n[0][1];
        int d = m[1][0] * n[0][1] +  m[1][1] * n[1][1];

        m[0][0] = a;
        m[0][1] = b;
        m[1][0] = c;
        m[1][1] = d;
    }
}