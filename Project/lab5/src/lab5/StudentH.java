
package lab5;
import java.util.*;
public class StudentH {

	public static void main(String[] args) {
		Set<Double> Height = new HashSet<>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the heights of 10Students");
		for(int i=0;i<10;i++) {
		Double stdH = scanner.nextDouble();
		Height.add(stdH);
		}
		
		System.out.println("Heights of the students:");
		for(Double stdH : Height) {
			System.out.println(stdH);
		}
	}

}
