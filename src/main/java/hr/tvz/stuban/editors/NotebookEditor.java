package hr.tvz.stuban.editors;

import java.beans.PropertyEditorSupport;

import hr.tvz.stuban.domain.Notebook;
import hr.tvz.stuban.repository.NotebookRepository;

public class NotebookEditor extends PropertyEditorSupport {

	NotebookRepository notebookRepository;

	public NotebookEditor(NotebookRepository repo) {
		this.notebookRepository = repo;
	}

	public NotebookEditor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setAsText(String text) {
		Notebook notebook = null;

		for (Notebook nb : notebookRepository.findAll()) {
			if (nb.getName().equals(text)) {
				notebook = nb;
				break;
			}
		}

		this.setValue(notebook);
	}

	@Override
	public String getAsText() {
		Notebook nb = (Notebook) this.getValue();
		return (nb != null ? nb.getName().toString() : "");
	}
}