package org.jeffgrubb.NJTrains;

/**
 * Created by jgrubb on 1/1/16.
 */
public class DatabaseProperties {

    private String name;
    private String url;
    private String user;
    private String password;

    public String getName() { return name; }
    public String getUrl() { return url; }
    public String getUser() { return user; }
    public String getPassword() { return password; }

    public void setName(String name) { this.name = name; }
    public void setUrl(String url) { this.url = url; }
    public void setUser(String user) { this.user = user; }
    public void setPassword(String password) { this.password = password; }
}
