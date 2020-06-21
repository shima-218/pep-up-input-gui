package inputData;

public class InputValues {

	//singleton
	private static InputValues ivs = new InputValues();
	private InputValues() {};
	public static InputValues getInstance() {
		return ivs;
	};

	private InputValuesForMonth thisMonth;

	private InputValuesForMonth lastMonth;

	public InputValuesForMonth getThisMonth() {
		return thisMonth;
	}

	public void setThisMonth(InputValuesForMonth thisMonth) {
		this.thisMonth = thisMonth;
	}

	public InputValuesForMonth getLastMonth() {
		return lastMonth;
	}

	public void setLastMonth(InputValuesForMonth lastMonth) {
		this.lastMonth = lastMonth;
	}

}
