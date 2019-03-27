package JenkinsDotNet.Services;

import JenkinsDotNet.Interfaces.*;
import JenkinsDotNet.Model.*;
import JenkinsDotNet.*;
import com.sun.tools.javac.util.Convert;
import javafx.concurrent.Task;
import jdk.incubator.http.HttpResponse;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.HttpURLConnection;

/** 
 Data service for connecting to Jenkins.
 Provides only parameterised (generic) type access.
 Use <see cref="JenkinsServer"/> class for type-specific methods.
*/
public final class JenkinsDataService implements IJenkinsDataService
{
	private static final JenkinsDataService instance = new JenkinsDataService(URL.Computer, getUrl(), getUrl(), getUserName(), getApiKey(), computerName);;
	private static JenkinsModel JenkinsModel = new JenkinsModel() {
		@Override
		protected boolean ParseFromXml(Object element) {
			return false;
		}
	};

	// Explicit static constructor to tell C# compiler
	// not to mark type as beforefieldinit
	/** 
	 Initializes the <see cref="JenkinsDataService"/> class.
	*/
	static
	{
	}

	public JenkinsDataService(URL computer, String s, String url, String userName, String apiKey, String computerName)
	{
	}

	public static JenkinsDataService getInstance()
	{
		return instance;
	}

	/** 
	 Requests data for a given model type from the Jenkins server
	 
	 <typeparam name="T">JenkinsModel object required</typeparam>
	 @param component The URL of the object required
	 @param baseUrl The base URL of the server
	 @param userName Name of the user
	 @param apiKey The user's API key
	 @param parameters Any parameters required for the specified URL
	 @return Task representing the retrieval of requested data
	*/
	public <T extends JenkinsModel<T>> Task<T> RequestAsync(URL component, String baseUrl, String userName, String apiKey, Object... parameters) throws IOException {
		HttpURLConnection request = ComposeMessage(baseUrl + component.Url(parameters), userName, apiKey);
		Task<String> readTask = new Task<String>() {
			@Override
			protected String call() throws Exception {
				return null;
			}
		};
		return  readTask.<T>get(Object.Parse(task[1].Result));
	}


	private static HttpURLConnection ComposeMessage(String url, String userName, String apiKey)
	{
		return ComposeMessage(url, userName, apiKey, true);
	}

	private static HttpURLConnection ComposeMessage(String url, String userName, String apiKey, boolean authenticated)
	{
		HttpURLConnection request = new HttpURLConnection(url) {
			@Override
			public void connect() throws IOException {

			}

			@Override
			public void disconnect() {

			}

			@Override
			public boolean usingProxy() {
				return false;
			}
		};
		if (authenticated)
		{
			AddAuthenticationHeader(request, userName, apiKey);
		}
		return request;
	}

	private static Task<HttpResponse> SendMessage(HttpURLConnection request) throws IOException {
		HttpMessageHandler handler = new HttpClientHandler();
		HttpClient httpClient = new HttpClient(handler);
		return httpClient.Send(request);
	}

	private static void AddAuthenticationHeader(HttpURLConnection request, String userName, String apiKey)
	{
		String encodedKey = new String((userName + ":" + apiKey).getBytes(java.nio.charset.StandardCharsets.UTF_8));
		request.Headers.Authorization = new AuthenticationHeaderValue("Basic", encodedKey);
	}

	/*private static <T extends JenkinsModel<T>> T GetObject(Object xml)
	{
		return JenkinsModel<T>.FromXml(xml);
	}*/
}