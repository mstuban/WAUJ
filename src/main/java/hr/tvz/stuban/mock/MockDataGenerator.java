package hr.tvz.stuban.mock;

import java.util.ArrayList;
import java.util.List;

import hr.tvz.stuban.domain.Notebook;
import hr.tvz.stuban.domain.User;

public class MockDataGenerator {

	public static List<User> mockUserList() {
		List<User> korisnikList = new ArrayList<>();
		korisnikList.add(new User(1, "pperic", "Pero", "Perić"));
		korisnikList.add(new User(2, "iivic", "Ivo", "Ivić"));
		korisnikList.add(new User(3, "mmarkic", "Marko", "Markić"));
		return korisnikList;
	}

	public static List<Notebook> mockNotebookList() {
		List<Notebook> notebookList = new ArrayList<>();
		notebookList.add(new Notebook("Pero's notebook", "Pero's stuff"));
		notebookList.add(new Notebook("Ivo's notebook", "Ivo's stuff"));
		notebookList.add(new Notebook("Marko's notebook", "Marko's stuff"));
		return notebookList;
	}

}
