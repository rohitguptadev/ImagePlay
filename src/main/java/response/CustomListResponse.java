package response;

public class CustomListResponse<T> extends CustomResponse<T> {

	private int offset;
	private int total;
	private int pageSize;

	public CustomListResponse(T data, String errorMessage, int errorCode,
			boolean success) {
		super(data, errorMessage, errorCode, success);
		// TODO Auto-generated constructor stub
	}

	public CustomListResponse(T data, String errorMessage, int errorCode,
			boolean success, int offset, int total, int pageSize) {
		super(data, errorMessage, errorCode, success);
		this.offset = offset;
		this.total = total;
		this.pageSize = pageSize;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	

}
