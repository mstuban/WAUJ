package hr.tvz.stuban.editors;

import java.beans.PropertyEditorSupport;

import hr.tvz.stuban.domain.User;
import hr.tvz.stuban.mock.MockDataGenerator;
import hr.tvz.stuban.repository.UserRepository;

public class UserEditor extends PropertyEditorSupport {

	UserRepository userRepository;
	
	public UserEditor(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserEditor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setAsText(String text) {
		User user = null;

		for (User u : MockDataGenerator.mockUserList()) {
			if (u.getId().equals(Integer.parseInt(text))) {
				user = u;
				break;
			}
		}

		this.setValue(user);
	}

	@Override
	public String getAsText() {
		User u = (User) this.getValue();
		return (u != null ? u.getId().toString() : "");
	}
}