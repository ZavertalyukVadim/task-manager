package interlink.configuration;


import java.net.URI;
import java.net.URISyntaxException;

class Parser {
    private String url;
    private String user;
    private String password;

    Parser(String fullUrl) throws URISyntaxException {
        URI uri = new URI(fullUrl);
        String afterJdbc = uri.getScheme() + "ql://";
        String host = uri.getHost();
        String nameDb = uri.getPath();
        String name = uri.getUserInfo();
        String needPart = "?sslmode=require";
        String jdbc = "jdbc:";
        int port = uri.getPort();
        this.url = jdbc + afterJdbc + host + ":" + port + nameDb + needPart;
        this.user = name.substring(0, name.indexOf(":"));
        this.password = name.substring(name.indexOf(":") + 1);
    }

    String getUrl() {
        return url;
    }

    String getUser() {
        return user;
    }

    String getPassword() {
        return password;
    }
    //for local server
    //postgres://postgres:school24@localhost:5432/postgres
    //for heroku server
    // postgres://ypypoocqqfxguc:dw0k-Vp_nbSrpZZA7oppd460gx@ec2-54-228-189-38.eu-west-1.compute.amazonaws.com:5432/dfbbsovsq0lhu7
}
