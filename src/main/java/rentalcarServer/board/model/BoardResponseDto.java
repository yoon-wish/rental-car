package rentalcarServer.board.model;

import java.sql.Timestamp;

public class BoardResponseDto {

	private String id;
	private int num;
	private String title;
	private String content;
	private String notice;
	private Timestamp reg_date;
    
	public BoardResponseDto(String id, int num, String title, String content, String notice, Timestamp reg_date) {
		super();
		this.id = id;
		this.num = num;
		this.title = title;
		this.content = content;
		this.notice = notice;
		this.reg_date = reg_date;
	}
	
	public BoardResponseDto(String id, String title, String content, String notice) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.notice = notice;
	}
	
	public BoardResponseDto(Board board) {
		this.id = board.getId();
		this.num = board.getNum();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.notice = board.getNotice();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public int getNum() {
		return num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	
	
	
	
}
