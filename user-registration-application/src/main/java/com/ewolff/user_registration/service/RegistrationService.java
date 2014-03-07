package com.ewolff.user_registration.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.ewolff.user_registration.domain.User;

@Service
public class RegistrationService {

	private Pattern emailPattern = Pattern.compile(
			"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Registers a new user
	 * 
	 * @param user
	 *            the user to be registered
	 * @return true if the user could be registered, false if there was a
	 *         duplicate
	 * @throws IllegalArgumentException
	 *             if the user had invalid data
	 */
	public boolean register(User user) throws IllegalArgumentException {
		String email = user.getEmail();
		if (getByEMail(email) != null)
			return false;
		if (!validEMailAdress(email)) {
			throw new IllegalArgumentException("Invalid EMail Adress!");
		}
		jdbcTemplate.update(
				"INSERT INTO T_USER(firstname, name, email) VALUES (?, ?, ?)",
				user.getFirstname(), user.getName(), email);

		return true;
	}

	public boolean validEMailAdress(String email) {
		if (email==null) {
			return false;
		}
		return emailPattern.matcher(email).find();
	}

	public User getByEMail(String email) {
		List<User> result = jdbcTemplate.query(
				"SELECT firstname, name, email FROM T_USER WHERE email=?",
				new RowMapper<User>() {

					@Override
					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						return new User(rs.getString("firstname"), rs
								.getString("name"), rs.getString("email"));
					}
				}, email);
		if (result.size() > 1) {
			throw new IllegalStateException(
					"More than one user with the same email!");
		}
		if (result.size() == 0) {
			return null;
		}
		return result.get(0);
	}

	public void reset() {
		jdbcTemplate.update("DELETE FROM T_USER");
	}

	public void unregister(String email) {
		int numberOfRows = jdbcTemplate.update(
				"DELETE FROM T_USER WHERE email=?", email);
		if (numberOfRows == 0) {
			throw new IllegalArgumentException("User with email"+email+" not registered!");
		}
	}

	public void clean() {
		jdbcTemplate.update("DELETE FROM T_USER");
	}

}
