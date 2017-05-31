package hr.tvz.stuban.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.stuban.domain.Note;

public interface NoteRepository extends JpaRepository<Note, Integer>{
	List<Note> findAll();

	void delete(Note note);

	Note save(Note note);
	

}
