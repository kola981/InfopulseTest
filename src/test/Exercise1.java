package test;

public class Exercise1 {
	private static final double C = -1.49;
	private static final double D = 23.4;
	
	private static double[][] array = new double[100][100];
	
	public static void main(String[] args) {		
		
		for (int i=0; i<array.length; i++) {
			for (int j=0; j<array[i].length; j++) {
				array[i][j]=maxElement(i,j);
			}
		}		
		
		double maxEl = 0;
		int ind1 = 0;
		int ind2 = 0;
		
		loop:
		for (int i=0; i<array.length; i++) {
			for (int j=0; j<array[i].length; j++) {
				
				if (maxEl < array[i][j]) maxEl = array[i][j];
				
				if (maxEl == Double.POSITIVE_INFINITY) {
					ind1 = i;
					ind2 = j;
					break loop;
				}
					
			}
		}
		
		//Согласно формуле масимально возможное значение - бесконечное число
		System.out.printf(" Максимальное значение для элемента [%d][%d], %f", ind1, ind2, maxEl);
		
	}

	
	private static double maxElement(int i, int j) {
		double firstPart = computeSinPart();
		double secondPart = computeLnPart(i, j);
		double res = firstPart - secondPart;
		System.out.printf("%f - %f = %f%n", firstPart, secondPart, res);
		
		return Math.sqrt(Math.abs(res));
	}
	
	private static double computeSinPart() {
		return Math.sin(Math.sin(Exercise1.C));
	}
	
	private static double computeLnPart(int i, int j) {
		return 4*Math.log(Math.log(Exercise1.D))/(Math.pow(i, j));
	}
	
}
