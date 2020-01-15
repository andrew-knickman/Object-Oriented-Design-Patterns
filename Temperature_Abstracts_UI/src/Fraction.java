
public class Fraction 
{
	private int numer;
	private int denom;

	 public Fraction() 
	 { // no-arg constructor
		 numer = 0;
		 denom = 1;
	 }

	 public Fraction(int numer, int denom) 
	 {
		 this.numer = numer;
		 this.denom = denom;
	 }

	 public Fraction(Fraction frac) 
	 { // copy constructor
		 numer = frac.getNumer();
		 denom = frac.getDenom();
	 }
	 // getters and setters
	 public int getNumer() 
	 {
	 return numer;
	 }

	 public void setNumer(int x) 
	 {
		 numer = x;
	 }

	 public int getDenom() 
	 {
		 return denom;
	 }

	 public void setDenom(int x) throws ArithmeticException 
	 {
		 if (x != 0) 
		 {
			 denom = x;
		 }
		 else
			 throw new ArithmeticException("Divide by 0");
	 }

	// Special Methods
	 public String toString() 
	 {
		 return numer + "/" + denom;
	 }

	 //Equals() method
	 public boolean equals(Fraction r)
	 {
		 Fraction temp1 = this.reduce();
		 Fraction temp2 = r.reduce();
	
		 return (temp1.numer == temp2.numer) && (temp1.denom == temp2.denom);
	 }
	 // Addition Method
	 public Fraction add(Fraction r) 
	 {
		 int num1 = ((this.numer * r.denom) + (r.numer * this.denom));
		 int num2 = this.denom * r.denom;
		 Fraction x = new Fraction (num1, num2);
	
		 return x;
	 }
	 
	 // Subtraction Method
	 public Fraction subtract(Fraction r)
	 {
		 int num1 =((this.numer * r.denom) - (r.numer * this.denom));
		 int num2 = this.denom * r.denom;
		 Fraction x = new Fraction (num1, num2);
	
		 return x;
	 }

	 // Multiplication Method
	 public Fraction multiply (Fraction r) 
	 {
		 int num1 = this.numer * r.numer;
		 int num2 = this.denom * r.denom;
		 Fraction x = new Fraction (num1, num2);
	
		 return x;
	 }

	 // Other Methods
	 public Fraction reduce() 
	 {
		 Fraction temp = new Fraction();
	
		 int GCD = gcd(numer, denom);
	
		 temp.setNumer(numer / GCD);
		 temp.setDenom(denom / GCD);
	
		 return temp;
	 }
	// Private Methods
	 private int gcd(int n1, int n2)
	 {
		 int M, N, R;
	
		 if (n1 < n2)
		 {
			 N = n1;
			 M = n2;
		 }
		 else
		 {
			 N = n2;
			 M = n1;
		 }
	
		 R = M % N;
	
		 while (R != 0)
		 {
			 M = N;
			 N = R;
		
			 R = M % N;
		 }
	
		 return N;
	 }


}
