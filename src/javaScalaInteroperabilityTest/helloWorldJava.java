/**
 * 
 */
package javaScalaInteroperabilityTest;

/**
 * @author ChristianPemberton
 *
 */
public class helloWorldJava {

	public int i;
	public int j; 
	
	public helloWorldJava() {
		i = 1;
		j = 1; 
		printHWJ();
	}
	
	public void printHWJ() {
		System.out.println("Hello, Java World!");
	}	
	
	public void printHWJS() {
		System.out.print("Hello, Java+Scala World!");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello, Java World!");
	}
}
