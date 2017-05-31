package hr.tvz.stuban.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.stuban.domain.Note;
import hr.tvz.stuban.repository.NoteRepository;

@RestController
@RequestMapping("/api/note")
public class NoteRestController {
	@Autowired
	NoteRepository noteRepository;

	@GetMapping
	public List<Note> findAll() {
		return noteRepository.findAll();
	}

	@GetMapping("/{id}")
	public Note findOne(@PathVariable Integer id) {
		return noteRepository.findOne(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Note save(@RequestBody Note note) {
		return noteRepository.save(note);
	}

	@PutMapping("/{id}")
	public Note update(@RequestBody Note note) {
		return noteRepository.save(note);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		noteRepository.delete(noteRepository.findOne(id));
	}
}