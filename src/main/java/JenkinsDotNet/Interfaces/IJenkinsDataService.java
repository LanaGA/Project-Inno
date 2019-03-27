package JenkinsDotNet.Interfaces;

import JenkinsDotNet.Model.*;
import JenkinsDotNet.*;
import javafx.concurrent.Task;

import java.io.IOException;

/** 
 Data service for connecting to Jenkins.
 Provides only parameterised (generic) type access.
 Use <see cref="JenkinsServer"/> class for type-specific methods.
*/
public interface IJenkinsDataService
{
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
	<T extends JenkinsModel<T>> Task<T> RequestAsync(URL component, String baseUrl, String userName, String apiKey, Object... parameters) throws IOException;
}