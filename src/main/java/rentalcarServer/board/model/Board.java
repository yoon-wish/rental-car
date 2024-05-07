package rentalcarServer.board.model;

import java.sql.Timestamp;

public class Board {

	private String id;
	private int num;
	private String title;
	private String content;
	private String notice;
	private Timestamp reg_date;
	private Timestamp mod_date;
	
	public Board(String id, int num, String title, String content, String notice,
			Timestamp reg_date, Timestamp mod_date) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.notice = notice;
		this.reg_date = reg_date;
		this.mod_date = mod_date;
	}

	public Board(String id, int num, String title, String content, String notice,
			Timestamp reg_date) {
		super();
		this.id = id;
		this.num = num;
		this.title = title;
		this.content = content;
		this.notice = notice;
		this.reg_date = reg_date;
	}
	
	public String getId() {
		return id;
	}
	
	public int getNum() {
		return num;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getNotice() {
		return notice;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public Timestamp getMod_date() {
		return mod_date;
	}
	
	
}
