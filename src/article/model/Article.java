package article.model;

import java.util.Date;

public class Article {
	
	private Integer number;
	private Writer writer;
	private String localName;
	private String title;
	private Date regDate;
	private Date modifiedDate;
	private int readCount;
	
	public Article(Integer number, Writer writer, String localName, String title, Date regDate, Date modifiedDate,
			int readCount) {
		super();
		this.number = number;
		this.writer = writer;
		this.localName = localName;
		this.title = title;
		this.regDate = regDate;
		this.modifiedDate = modifiedDate;
		this.readCount = readCount;
	}

	public Integer getNumber() {
		return number;
	}

	public Writer getWriter() {
		return writer;
	}

	public String getLocalName() {
		return localName;
	}

	public String getTitle() {
		return title;
	}

	public Date getRegDate() {
		return regDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public int getReadCount() {
		return readCount;
	}
	
	
	

}
