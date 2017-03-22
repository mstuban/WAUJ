package hr.tvz.stuban.domain;

import java.io.Serializable;

public class Notebook implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4875590196822548399L;
	private String name;
	private String contentSummary;
	
	public Notebook(String name, String contentSummary) {
		super();
		this.name = name;
		this.contentSummary = contentSummary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentSummary() {
		return contentSummary;
	}

	public void setContentSummary(String contentSummary) {
		this.contentSummary = contentSummary;
	}

}
