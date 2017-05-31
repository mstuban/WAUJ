package hr.tvz.stuban.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "notebook")
public class Notebook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4875590196822548399L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer notebook_id;
	private String name;

	@Column(name = "content_summary")
	private String contentSummary;

	@OneToMany(mappedBy = "notebook", fetch = FetchType.EAGER)
	private List<Note> notes;

	public Notebook(String name, String contentSummary) {
		super();
		this.name = name;
		this.contentSummary = contentSummary;
	}

	public Notebook() {
		super();
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

	public Integer getId() {
		return notebook_id;
	}

	public void setId(Integer id) {
		this.notebook_id = id;
	}

}
