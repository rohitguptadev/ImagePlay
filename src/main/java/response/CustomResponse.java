package response;

public class CustomResponse<T> {

	private T data;
	private String errorMessage;
	private int errorCode;
	private boolean success;

	public CustomResponse(T data, String errorMessage, int errorCode,
			boolean success) {
		super();
		this.data = data;
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
