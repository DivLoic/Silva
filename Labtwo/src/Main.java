import java.util.Arrays;


public class Main {
	
	private static final String[] allPseudo = {"lmd","steveJ","Turning","MaxW","abc","root", "NicoTesla"};

	public static boolean test(String id){
		boolean res = Arrays.asList(allPseudo).contains(id);
		System.out.print(res);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		test("lmd");
	}

}
