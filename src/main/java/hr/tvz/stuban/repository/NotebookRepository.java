package hr.tvz.stuban.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.stuban.domain.Notebook;

public interface NotebookRepository extends JpaRepository<Notebook, Integer>{

	List<Notebook> findAll();

	Notebook findByName(String name);

}
