package com.vmorg.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class AuthorisingServiceTest {

    @Mock
    AuthorisingService authorisingService = Mockito.mock(AuthorisingService.class);

    private final String adminUser = "admin@vmorg.com";
    private final String invalidUser = "fake@vmorg.com";

    @BeforeEach
    void setUp() {
        when(authorisingService.isAuthorised(adminUser)).thenReturn(true);
        when(authorisingService.isAuthorised(invalidUser)).thenReturn(false);
    }


    @Test
    void testUserIsAuthorised() {
        boolean authorized = authorisingService.isAuthorised(adminUser);

        assertTrue(authorized);
    }

    @Test
    void testUserIsNotAuthorise() {
        boolean authorized = authorisingService.isAuthorised(anyString());

        assertFalse(authorized);
    }
}