package com.vmorg.auth;

import com.vmorg.report.LogReport;

public class Authorisation implements  AuthorisingService{
    private static final String validUser = "admin@vmorg.com";
    @Override
    public boolean isAuthorised(String user) {
        if(user.equals(validUser)){
            return true;
        }

        LogReport.log(user + "Attempted to initiate a build");

        return true;
    }
}
