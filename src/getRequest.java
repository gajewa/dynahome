import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class getRequest {
    private URL connectionURL;
    private URLConnection connection;

    public getRequest(String path) throws IOException {
        this.connectionURL = new URL(path);
        this.connection = connectionURL.openConnection();
    }

    public void setAuthData(String username, String password){
        String encoded = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.UTF_8));
        this.connection.setRequestProperty("Authorization", "Basic "+encoded);


    }

    public InputStream getInputStream() throws IOException {
        return this.connection.getInputStream();
    }
}
