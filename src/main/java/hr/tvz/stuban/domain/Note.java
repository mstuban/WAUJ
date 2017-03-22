package hr.tvz.stuban.domain;

import java.io.Serializable;

public class Note implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 595742045650639860L;
	private User user;
	private Notebook notebook;
	private String noteHeadline;
	private String noteText;
	
	public Note(User user, Notebook notebook, String noteHeadline, String noteText) {
		super();
		this.user = user;
		this.notebook = notebook;
		this.noteHeadline = noteHeadline;
		this.noteText = noteText;
	}

	public Note() {
		// TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Notebook getNotebook() {
		return notebook;
	}

	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}

	public String getNoteHeadline() {
		return noteHeadline;
	}

	public void setNoteHeadline(String noteHeadline) {
		this.noteHeadline = noteHeadline;
	}

	public String getNoteText() {
		return noteText;
	}

	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}
}
