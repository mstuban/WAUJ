package hr.tvz.stuban.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.stuban.domain.User;
import hr.tvz.stuban.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
	@Autowired
	UserRepository userRepository;

	@GetMapping
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User findOne(@PathVariable Integer id) {
		return userRepository.findOne(id);
	}

}

