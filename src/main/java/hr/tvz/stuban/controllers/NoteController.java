package hr.tvz.stuban.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import hr.tvz.stuban.domain.NewNoteForm;
import hr.tvz.stuban.domain.Note;
import hr.tvz.stuban.domain.Notebook;
import hr.tvz.stuban.domain.User;
import hr.tvz.stuban.editors.NotebookEditor;
import hr.tvz.stuban.editors.UserEditor;
import hr.tvz.stuban.repository.NoteRepository;
import hr.tvz.stuban.repository.NotebookRepository;
import hr.tvz.stuban.repository.UserRepository;

@Controller
@SessionAttributes(names = { "noteCounter", "newNoteForm" })
public class NoteController {

	@Autowired
	private NotebookRepository notebookRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NoteRepository noteRepository;

	@GetMapping("/newNote")
	public String showForm(Model model, Principal principal, Authentication authentication) {
		model.addAttribute("notebooks", notebookRepository.findAll());
		model.addAttribute("users", userRepository.findAll());

		if (authentication != null) {

			boolean hasAdminRole = authentication.getAuthorities().stream()
					.anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));

			List<Note> userNotes = new ArrayList<>();

			List<Note> allNotes = noteRepository.findAll();

			if (!hasAdminRole) {
				for (Note note : allNotes) {
					if (note.getUser().getUsername().equals(principal.getName())) {
						userNotes.add(note);
					}
				}

			} else {
				userNotes = noteRepository.findAll();
			}

			model.addAttribute("notes", userNotes);
		}

		return "newNote";

	}

	@ModelAttribute("noteCounter")
	public Map<String, Integer> getNoteCounter() {
		return new HashMap<>();
	}

	@ModelAttribute("newNoteForm")
	public NewNoteForm getNewNoteForm() {
		return new NewNoteForm();
	}

	@PostMapping("/newNote")
	public String processForm(@ModelAttribute NewNoteForm newNoteForm, Model model, Principal principal,
			Authentication authentication) {
		User formUser = null;
		Notebook formNotebook = null;
		Note note = new Note();

		if (authentication != null) {

			boolean hasAdminRole = authentication.getAuthorities().stream()
					.anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));

			if (!hasAdminRole) {
				for (User user : userRepository.findAll()) {
					if (user.getUsername().equals(principal.getName())) {
						formUser = user;
						break;
					}
				}
			} else {
				formUser = newNoteForm.getUser();
			}

			for (Notebook notebook : notebookRepository.findAll()) {
				if (notebook.getName().equals(newNoteForm.getNotebook().getName())) {
					formNotebook = notebook;
					break;
				}
			}

			note = new Note(formUser, formNotebook, newNoteForm.getHeadline(), newNoteForm.getContent());
			model.addAttribute("note", note);
			model.addAttribute("notes", noteRepository.findAll());

			noteRepository.save(note);
		}

		return "showNewNote";

	}

	@GetMapping("/editNote")
	public String edit(@SessionAttribute NewNoteForm newNoteForm, Model model) {
		model.addAttribute("newNoteForm", newNoteForm);
		return "redirect:/newNote";
	}

	@GetMapping("/addNewNote")
	public String confirmSavingNewNote(@SessionAttribute NewNoteForm newNoteForm,
			@SessionAttribute Map<String, Integer> noteCounter, Model model, Principal principal,
			Authentication authentication) {

		User formUser = null;
		Notebook formNotebook = null;
		Note note = new Note();

		if (authentication != null) {

			boolean hasAdminRole = authentication.getAuthorities().stream()
					.anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));

			if (!hasAdminRole) {
				for (User user : userRepository.findAll()) {
					if (user.getUsername().equals(principal.getName())) {
						formUser = user;
						break;
					}
				}
			} else {
				formUser = newNoteForm.getUser();
			}

			for (Notebook notebook : notebookRepository.findAll()) {
				if (notebook.getName().equals(newNoteForm.getNotebook().getName())) {
					formNotebook = notebook;
					break;
				}
			}

			note = new Note(formUser, formNotebook, newNoteForm.getHeadline(), newNoteForm.getContent());

			if (noteCounter.containsKey(note.getNotebook().getName())) {
				int counter = noteCounter.get(note.getNotebook().getName());
				counter++;
				noteCounter.put(note.getNotebook().getName(), counter);
			} else {
				noteCounter.put(note.getNotebook().getName(), 1);
			}

			model.addAttribute("note", note);

			model.addAttribute("newNoteForm", new NewNoteForm());

			noteRepository.save(note);
		}

		return "note";
	}

	@GetMapping("/resetNoteStatistics")
	public String showFormFresh(SessionStatus status) {
		status.setComplete();
		return "redirect:/newNote";
	}

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.registerCustomEditor(User.class, new UserEditor());
		binder.registerCustomEditor(Notebook.class, new NotebookEditor());
		binder.registerCustomEditor(Notebook.class, new NotebookEditor(notebookRepository));
		binder.registerCustomEditor(User.class, new UserEditor(userRepository));

	}

	@GetMapping("/deleteNote/{id}")
	public String deleteNoteById(@PathVariable Integer id) {

		noteRepository.delete(noteRepository.findOne(id));

		return "redirect:/newNote";
	}

}
