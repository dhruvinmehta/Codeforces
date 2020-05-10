import java.util.*;

public class SuperheroTransformation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String t = in.next();

		if (s.length() != t.length()) {
			System.out.println("No");
		} else {
			SuperheroTransformation st = new SuperheroTransformation();
			System.out.println(st.canTransform(s, t));
		}

		in.close();
	}

	public String canTransform(String s, String t) {
		boolean result = false;

		List<Character> vowelList = new ArrayList<>();
		vowelList.add('a');
		vowelList.add('e');
		vowelList.add('i');
		vowelList.add('o');
		vowelList.add('u');

		for (int i = 0; i < s.length(); i++) {
			if (vowelList.contains(s.charAt(i)) && vowelList.contains(t.charAt(i))) {
				result = true;
			} else if (!vowelList.contains(s.charAt(i)) && !vowelList.contains(t.charAt(i))) {
				result = true;
			} else {
				result = false;
				break;
			}
		}

		if (result) {
			return "Yes";
		} else {
			return "No";
		}
	}
}