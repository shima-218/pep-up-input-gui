package common;

public class PepupUtilities {

	public static boolean[] StringToBooleans(String str) {
	    String[] strs = str.replace("[", "").replace("]", "").split(", ");
	    boolean[] bools = new boolean[strs.length];
	    for (int i = 0; i < bools.length; i++) {
	      bools[i] = Boolean.parseBoolean(strs[i]);
	    }
		return bools;
	}

}
