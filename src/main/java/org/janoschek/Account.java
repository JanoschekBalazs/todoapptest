package org.janoschek;

public class Account {

    private String username;
    private String password;

    private static final Account TESTACCOUNT = new Account("testadmin", "testadmin");

    public Account (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Account getTestAccount() {
        return TESTACCOUNT;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
