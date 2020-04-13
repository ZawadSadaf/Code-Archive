package src;

public class Econ {
	Econ() {}
	
	//*********************************************************************//
	//*****Chapter 3*******************************************************//
	//*********************************************************************//
	
	// Must Transfer Over From Chapter3 Class
	
	//*********************************************************************//
	//*****Chapter 4*******************************************************//
	//*********************************************************************//
	
	/** The uniform series compound amount factor.
	 * Finds the future value of a uniform series using the interest, period, 
	 * and uniform payments. Formula is F = A  * [ ( 1 + i ) ^ n - 1 / i ] or 
	 * A(F/A, i%, n)
	 */
	public double uniformSCAF(double a, double n, double i) {
		return a * ((Math.pow((1 + i), n) - 1) / i);
	}
	
	/** The uniform series sinking fund factor. 
	 * Finds the payment amount of a uniform series using the interest, period, 
	 * and future value. Formula is A = F * [ i / ( 1 + i ) ^ n - 1] or 
	 * F(A/F, i%, n)
	 */
	public double uniformSSFF(double f, double i, double n) {
		return f * (i / (Math.pow((1 + i), n) - 1));
	}
	
	/** The uniform series capital recovery factor. 
	 * Finds the payment amount of a uniform series using the interest, period, 
	 * and the present value. Formula is P * [ i ( 1 + i ) ^ n / ( 1 + i ) ^ n - 1 ] or 
	 * P(A/P, i%, n)
	 */
	public double uniformSCRF(double p, double i, double n) {
		return p * ((i * Math.pow(1 + i, n)) / (Math.pow(1 + i, n) - 1));
	}
	
	/** The uniform series present worth factor. 
	 * Finds the present worth of a uniform series using the interest, period, 
	 * and the payment amount. Formula is A * [ ( 1 + i ) ^ n - 1 / i ( 1 + i ) ^ n ] or 
	 * A(P/A, i%, n)
	 */
	public double uniformSPWF(double a, double i, double n) {
		return a * ( (Math.pow(1 + i, n) - 1) / (i * Math.pow(1 + i, n)));
	}
	
	/** The arithmetic gradient uniform series present worth factor. 
	 * For series of uniformly increasing payments, G represents the change from period to period.  
	 * Formula is P = G * [ ( 1 + i ) ^ i * n - 1 / i^2 ( 1 + i ) ^ n ] or 
	 * G(P/G, i%, n)
	 */
	public double arithmeticGUSPWF(double g, double i, double n) {
		return g * ( (Math.pow(1 + i, n) - (i * n) - 1) / (Math.pow(i, 2) * Math.pow(1 + i, n)) );
	}
	
	/** The arithmetic gradient uniform series change factor. 
	 * For series of uniformly increasing payments, G represents the change from period to period.  
	 * Formula is A = G * [ ( 1 / n ) - ( n / ( 1 + i) ^ n - 1 ) ] or 
	 * G(A/G, i%, n)
	 */
	public double arithmeticGUSCF(double g, double i, double n) {
		return g * ( ( ( 1 / i ) - ( n / ( Math.pow(1 + i, n) - 1 ) ) ) );
	}
	
	/** The geometric series present worth factor, where i != g. 
	 * Formula is P = A1 * [ ( 1 - ( 1 + g ) ^ n * ( 1 + i ) ^ -n ) / ( i - g ) ] or 
	 * A1(P/A, g, i, n)
	 */
	public double geometricSPWFI(double a1, double g, double i, double n) {
		return a1 * ( ( 1 - Math.pow(1 + g, n) * Math.pow(1 + i, -n) ) / ( i - g ) );
	}
	
	/** The geometric series present worth factor, where i == g. 
	 * Formula is P = A1 [ n * ( 1 + i) ^ -1 ] or A1(P/A, g, i, n)
	 */
	public double geometricSPWF(double a1, double i, double n) {
		return a1 * ( n * Math.pow(1 + i, -1));
	}
	
	//*********************************************************************//
	//*****Chapter 5*******************************************************//
	//*********************************************************************//
	
	
}
