package hr.tvz.stuban.controllers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NoteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testShowFormAsAdmin() throws Exception {
		this.mockMvc.perform(get("/newNote").with(user("admin").password("password").roles("USER", "ADMIN")))
				.andExpect(status().isOk()).andExpect(model().attributeExists("notebooks"))
				.andExpect(model().attribute("notebooks", Matchers.hasSize(3)))
				.andExpect(model().attributeExists("users")).andExpect(model().attribute("users", Matchers.hasSize(5)))
				.andExpect(model().attributeExists("notes")).andExpect(model().attribute("notes", Matchers.hasSize(1)))
				.andExpect(view().name("newNote"));
	}

	@Test
	public void testShowFormAsUser() throws Exception {
		this.mockMvc.perform(get("/newNote").with(user("admin").password("password").roles("USER", "ADMIN")))
				.andExpect(status().isOk()).andExpect(model().attributeExists("notebooks"))
				.andExpect(model().attribute("notebooks", Matchers.hasSize(3)))
				.andExpect(model().attributeExists("users")).andExpect(model().attribute("users", Matchers.hasSize(5)))
				.andExpect(model().attributeExists("notes")).andExpect(model().attribute("notes", Matchers.hasSize(0)))
				.andExpect(view().name("newNote"));
	}

	@Test
	public void testResetNoteStatistics() throws Exception {
		this.mockMvc
				.perform(get("/resetNoteStatistics").with(user("admin").password("password").roles("USER", "ADMIN")))
				.andExpect(status().is3xxRedirection());
	}
	
	@Test
	public void testProcessForm_whenAuthenticated() throws Exception {
		this.mockMvc
				.perform(post("/newNote").param("notebook", "Web aplikacije u Javi")
						.param("naslov", "Neki naslov").param("tekst", "Neki tekst")
						.with(user("mstuban").password("password").roles("USER")))
				.andExpect(status().isOk()).andExpect(view().name("showNewNote"));
	}

	@Test
	public void testShowForm_whenNotAuthenticated() throws Exception {
		this.mockMvc.perform(get("/newNote")).andExpect(status().is3xxRedirection());
	}

	@Test
	public void testGetLoginWhenNotAuthenticated() throws Exception {
		this.mockMvc.perform(get("/login")).andExpect(status().isOk());
	}


}
