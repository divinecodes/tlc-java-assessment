package com.vmorg.auth;

public interface AuthorisingService {
    /**
     *  validate if user is authorized to make the request
     *
     * @param user
     * @return
     */
    boolean isAuthorised(String user);
}
