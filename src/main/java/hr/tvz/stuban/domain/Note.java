package hr.tvz.stuban.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "note")
public class Note implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 595742045650639860L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "notebook_id")
	private Notebook notebook;

	@Column(name = "note_headline")
	private String noteHeadline;

	@Column(name = "note_text")
	private String noteText;

	public Note(User user, Notebook formNotebook, String noteHeadline, String noteText) {
		super();
		this.user = user;
		this.notebook = formNotebook;
		this.noteHeadline = noteHeadline;
		this.noteText = noteText;
	}

	public Note(Integer id, User user, Notebook notebook, String noteHeadline, String noteText) {
		super();
		this.id = id;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
