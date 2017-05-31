package hr.tvz.stuban.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.stuban.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findAll();

}
