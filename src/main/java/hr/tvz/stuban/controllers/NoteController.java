package hr.tvz.stuban.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hr.tvz.stuban.domain.NewNoteForm;
import hr.tvz.stuban.domain.Note;
import hr.tvz.stuban.domain.Notebook;
import hr.tvz.stuban.domain.User;
import hr.tvz.stuban.mock.MockDataGenerator;

@Controller
public class NoteController {

	@GetMapping("/newNote")
	public String showForm(Model model) {
		model.addAttribute("users", MockDataGenerator.mockUserList());
		model.addAttribute("notebooks", MockDataGenerator.mockNotebookList());
		model.addAttribute("newNoteForm", new NewNoteForm());
		return "newNote";
	}

	@PostMapping("/newNote")
	public String processForm(@ModelAttribute NewNoteForm newNoteForm, Model model) {
		User formUser = null;
		Notebook formNotebook = null;
		Note note = new Note();
		
		System.out.println(newNoteForm.getUserID());
		
			
		if (!newNoteForm.getUserID().equals("")) {
			for (User user : MockDataGenerator.mockUserList()) {
				if (user.getId().equals(Long.parseLong(newNoteForm.getUserID()))) {
					formUser = user;
					break;
				}
			}
		} else {
			formUser = new User(null, "Anonymous", "Anonimi", "Anonimius");
		}

		for (Notebook notebook : MockDataGenerator.mockNotebookList()) {
			if (notebook.getName().equals(newNoteForm.getNotebookName())) {
				formNotebook = notebook;
				break;
			} else {
				formNotebook = new Notebook("Default notebook", "");
			}
		}

		note = new Note(formUser, formNotebook, newNoteForm.getHeadline(), newNoteForm.getContent());
		model.addAttribute("note", note);

		return "showNewNote";
	}
}
