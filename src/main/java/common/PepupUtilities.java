package common;

public class PepupUtilities {

	public static boolean[] StringToBooleans(String str) {
	    String[] strs = str.replace("[", "").replace("]", "").split(", ");
	    boolean[] bools = new boolean[strs.length];
	    for (int i = 0; i < bools.length; i++) {
	      bools[i] = Boolean.parseBoolean(strs[i].trim());
	    }
		return bools;
	}

	public static int[] StringToIntegers(String str) {
	    String[] strs = str.replace("[", "").replace("]", "").split(", ");
	    int[] ints = new int[strs.length];
	    for (int i = 0; i < ints.length; i++) {
	      ints[i] = Integer.parseInt(strs[i].trim());
	    }
		return ints;
	}

	public static String BooleansToString(boolean[] bools) {
		String str = "";
		for(int i = 0; i < bools.length; i++) {
			str = str.concat(String.valueOf(bools[i]));
			str = str.concat(", ");
		}
		str = str.substring(0,str.length()-2);
		return str;
	}

	public static String IntegersToString(int[] ints) {
		String str = "";
		for(int i = 0; i < ints.length; i++) {
			str = str.concat(String.valueOf(ints[i]));
			str = str.concat(", ");
		}
		str = str.substring(0,str.length()-2);
		return str;
	}

}
