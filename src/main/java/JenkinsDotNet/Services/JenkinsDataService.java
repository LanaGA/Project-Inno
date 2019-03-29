package JenkinsDotNet.Services;

import JenkinsDotNet.Interfaces.IJenkinsDataService;
import JenkinsDotNet.Model.JenkinsModel;
import JenkinsDotNet.Model.XElement;
import JenkinsDotNet.URL;
import javafx.concurrent.Task;
import jdk.incubator.http.HttpClient;
import net.oauth.http.HttpMessage;
import net.oauth.http.HttpResponseMessage;

import javax.swing.text.AbstractDocument;

import static JenkinsDotNet.Model.JenkinsModel.FromXml;

/**
 * Data service for connecting to Jenkins.
 * Provides only parameterised (generic) type access.
 * Use <see cref="JenkinsServer"/> class for type-specific methods.
 */
public final class JenkinsDataService implements IJenkinsDataService {
    private static final JenkinsDataService instance = new JenkinsDataService();

    public static JenkinsDataService getInstance() {
        return instance;
    }

    /**
     * Requests data for a given model type from the Jenkins server
     *
     * <typeparam name="T">JenkinsModel object required</typeparam>
     *
     * @param component  The URL of the object required
     * @param baseUrl    The base URL of the server
     * @param userName   Name of the user
     * @param apiKey     The user's API key
     * @param parameters Any parameters required for the specified URL
     * @return Task representing the retrieval of requested data
     */
// TODO: handle with AsyncHandler
    public <T extends JenkinsModel<T>> Task<T> RequestAsync(URL component, String baseUrl, String userName, String apiKey, Object... parameters) {

        HttpRequestMessage request = ComposeMessage(baseUrl + component.Url(parameters), userName, apiKey);
        Task<HttpResponseMessage> task = SendMessage(request);
        Task<String> readTask = (await task).AbstractDocument.Content.ReadAsStringAsync();
        return await
        readTask.ContinueWith(task1 -> JenkinsDotNet.Services.JenkinsDataService.<T>GetObject(XElement.Parse(task1.Result)));
    }


    private static HttpRequestMessage ComposeMessage(String url, String userName, String apiKey) {
        return ComposeMessage(url, userName, apiKey, true);
    }

    private static HttpRequestMessage ComposeMessage(String url, String userName, String apiKey, boolean authenticated) {
        HttpRequestMessage request = new HttpRequestMessage(HttpMethod.Get, url);
        if (authenticated) {
            AddAuthenticationHeader(request, userName, apiKey);
        }
        return request;
    }

    private static Task<HttpResponseMessage> SendMessage(HttpRequestMessage request) {
        HttpMessageHandler handler = new HttpClientHandler();
        HttpClient httpClient = new HttpClient(handler);
        return await httpClient.SendAsync(request);
    }

    private static void AddAuthenticationHeader(HttpRequestMessage request, String userName, String apiKey) {
        String encodedKey = Convert.ToBase64String((userName + ":" + apiKey).getBytes(java.nio.charset.StandardCharsets.UTF_8));
        request.Headers.Authorization = new AuthenticationHeaderValue("Basic", encodedKey);
    }

    private static <T extends JenkinsModel<T>> T GetObject(XElement xml) {
        return JenkinsModel < T >.FromXml(xml);
    }
}