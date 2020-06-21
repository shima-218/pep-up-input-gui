package pepUpInput;

public class Option {

	private String userId;
	private String password;
	private String inputYearMonth;
	private boolean[] inputOrNotArray;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInputYearMonth() {
		return inputYearMonth;
	}
	public void setInputYearMonth(String inputYearMonth) {
		this.inputYearMonth = inputYearMonth;
	}
	public boolean[] getInputOrNotArray() {
		return inputOrNotArray;
	}
	public void setInputOrNotArray(boolean[] inputOrNotArray) {
		this.inputOrNotArray = inputOrNotArray;
	}

}
