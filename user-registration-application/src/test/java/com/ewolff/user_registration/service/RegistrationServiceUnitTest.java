package com.ewolff.user_registration.service;

import com.ewolff.user_registration.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceUnitTest {

    @Mock
    private JdbcTemplate jdbcTemplateMock;

    @InjectMocks
    private RegistrationService service;

    @Test
    public void registerNewUser() {
        // arrange
        User user = new User("Eberhard","Wolff","eberhard.wolff@gmail.com");
        // act
        boolean registered = service.register(user);
        // assert
        assertThat(registered, is(true));
        verify(jdbcTemplateMock).update(
                anyString(),
                eq(user.getFirstname()),
                eq(user.getName()),
                eq(user.getEmail()));
    }

    @Test
    public void doNotRegisterExistingUser() {
        // arrange
        User user = new User("Eberhard","Wolff","eberhard.wolff@gmail.com");
        List<User> users = new ArrayList<>();
        users.add(user);
        // simulating that user already exists
        when(jdbcTemplateMock.query(anyString(), Matchers.any(RowMapper.class), eq(user.getEmail()))).thenReturn(users);
        // act
        boolean registered = service.register(user);
        // assert
        assertThat("should not register user with existing mail address", registered, is(false));
    }
}
