package article.service;

import java.util.Map;

import article.model.Writer;

public class WriteRequest {
	
	private Writer writer;
	private String title;
	private String content;
	private String local;
	private String fileName;
	
public WriteRequest(Writer writer, String title, String content, String local) {
		
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.local = local;
		
	} 
	
	public WriteRequest(Writer writer, String title, String content, String local, String fileName) {
		
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.local = local;
		this.fileName = fileName;
	}
	
	
	
	
	
	public Writer getWriter() {
		return writer;
	}





	public String getTitle() {
		return title;
	}





	public String getContent() {
		return content;
	}





	public String getLocal() {
		return local;
	}





	public String getFileName() {
		return fileName;
	}





	public void validate(Map<String, Boolean> errors) {
		if(title==null || title.trim().isEmpty()) {
			errors.put("title",Boolean.TRUE);
		}
	}
	
	
	
}