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

import hr.tvz.stuban.domain.Notebook;
import hr.tvz.stuban.repository.NotebookRepository;

@RestController
@RequestMapping("/api/notebook")
public class NotebookRestController {
	@Autowired
	NotebookRepository notebookRepository;

	@GetMapping
	public List<Notebook> findAll() {
		return notebookRepository.findAll();
	}

	@GetMapping("/{id}")
	public Notebook findOne(@PathVariable Integer id) {
		return notebookRepository.findOne(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Notebook save(@RequestBody Notebook notebook) {
		return notebookRepository.save(notebook);
	}

	@PutMapping("/{id}")
	public Notebook update(@RequestBody Notebook notebook) {
		return notebookRepository.save(notebook);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		notebookRepository.delete(notebookRepository.findOne(id));
	}
}
