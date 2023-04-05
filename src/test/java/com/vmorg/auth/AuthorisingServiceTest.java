package com.vmorg.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AuthorisingServiceTest {

    @Mock
    AuthorisingService authorisingService = Mockito.mock(AuthorisingService.class);

    private final String adminUser = "admin@vmorg.com";
    private final String invalidUser = "fake@vmorg.com";
    @BeforeEach
    void setUp(){
        when(authorisingService.isAuthorised(eq(adminUser))).thenReturn(true);
        when(authorisingService.isAuthorised(eq(invalidUser))).thenReturn(false);
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