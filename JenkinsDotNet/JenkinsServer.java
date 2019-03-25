package JenkinsDotNet;

import JenkinsDotNet.Interfaces.*;
import JenkinsDotNet.Model.*;
import JenkinsDotNet.Services.*;
import org.asynchttpclient.*;

/**
 * Jenkins Server representation, includes login information
 */
public class JenkinsServer {
    /**
     * The _jenkins data service
     */
    private IJenkinsDataService _jenkinsDataService;

    /**
     * Initializes a new instance of the <see cref="JenkinsServer" /> class.
     *
     * @param url      The URL of the server
     * @param username A valid username
     * @param apikey   The user's API key
     * @param name     Friendly name of this server
     */

    public void JenkinsServer(String url, String username, String apikey) {
        this(url, username, apikey, "Jenkins Server");
    }

    public void JenkinsServerName(String url, String username, String apikey, String name) {
        setUrl(url);
        setUserName(username);
        setApiKey(apikey);
        setName(name);
        _jenkinsDataService = JenkinsDataService.getInstance();
    }

    /**
     * Initializes a new instance of the <see cref="JenkinsServer" /> class.
     *
     * @param dataService <see cref="IJenkinsDataService"/> available to this server
     * @param url         The URL of the server
     * @param username    A valid username
     * @param apikey      The user's API key
     * @param name        Friendly name of this server
     */

    public void JenkinsServer(IJenkinsDataService dataService, String url, String username, String apikey) {
        this(dataService, url, username, apikey, "Jenkins Server");
    }


    public void JenkinsServer(IJenkinsDataService dataService, String url, String username, String apikey, String name) {
        setUrl(url);
        setUserName(username);
        setApiKey(apikey);
        setName(name);
        _jenkinsDataService = dataService;
    }

    /**
     * Gets or sets the URL of the server.
     *
     * <value>The URL</value>
     */
    private String Url;

    public final String getUrl() {
        return Url;
    }

    public final void setUrl(String value) {
        Url = value;
    }

    /**
     * Gets or sets the friendly name of this server
     *
     * <value>The name</value>
     */
    private String Name;

    public final String getName() {
        return Name;
    }

    public final void setName(String value) {
        Name = value;
    }

    /**
     * Gets or sets the username used to connect to this server
     *
     * <value>The username</value>
     */
    private String UserName;

    public final String getUserName() {
        return UserName;
    }

    public final void setUserName(String value) {
        UserName = value;
    }

    /**
     * Gets or sets the API key of the configured user.
     *
     * <value>The API key</value>
     */
    private String ApiKey;

    public final String getApiKey() {
        return ApiKey;
    }

    public final void setApiKey(String value) {
        ApiKey = value;
    }

    /**
     * Gets details of a node.
     *
     * @return Node model
     */
    public final Node GetNodeDetails() {
        var returnVal = GetNodeDetailsAsync();
        returnVal.Wait();
        return returnVal.Result;
    }

    /**
     * Asynchronously gets the details of a node.
     *
     * @return Task to retrieve the node
     */
// TODO: fix it after JenkinsDataService
    public static Task<Node> GetNodeDetailsAsync() {
        try {
            String intermediate = await(doAThing());
            String result = await(doAnotherThing(intermediate));
            reportSuccess(result);
        }

    {
        return await _jenkinsDataService.<Node>RequestAsync(URL.Api, getUrl(), getUserName(), getApiKey());
    }








        async Task<int> AccessTheWebAsync()
        {
            HttpClient client = new HttpClient();
            var urlContents = await client.GetStringAsync("http://msdn.microsoft.com");
            return urlContents.Length;
        }




    /**
     * Gets details of a job.
     *
     * @param jobName Name of the job requested
     * @return The requested job
     */
//C#
    public final Job GetJobDetails(String jobName) {
        async returnVal = GetJobDetailsAsync(jobName);
        returnVal.Wait();
        return returnVal.Result;
    }

    /**
     * Asynchronously gets details of a job
     *
     * @param jobName Name of the job requested
     * @return Task to retrieve the job
     */
//C# TO JAVA CONVERTER TODO TASK: There is no equivalent in Java to the 'async' keyword:
//ORIGINAL LINE: public async Task<Job> GetJobDetailsAsync(string jobName)
    public final Task<Job> GetJobDetailsAsync(String jobName) {
//C# TO JAVA CONVERTER TODO TASK: There is no equivalent to 'await' in Java:
        return await _jenkinsDataService.<Job>RequestAsync(URL.Job, getUrl(), getUserName(), getApiKey(), jobName);
    }

    /**
     * Gets details of a build
     *
     * @param jobName     Name of the job to get a build from
     * @param buildNumber The build number requested
     * @return The requested build
     */
//C#
    public final Build GetBuildDetails(String jobName, String buildNumber) {
        async returnVal = GetBuildDetailsAsync(jobName, buildNumber);
        returnVal.Wait();
        return returnVal.Result;
    }

    /**
     * Asynchronously gets details of a build
     *
     * @param jobName     Name of the job to get a build from
     * @param buildNumber The build number requested
     * @return Task to retrieve the requested build
     */
//C# TO JAVA CONVERTER TODO TASK: There is no equivalent in Java to the 'async' keyword:
//ORIGINAL LINE: public async Task<Build> GetBuildDetailsAsync(string jobName, string buildNumber)
    public final Task<Build> GetBuildDetailsAsync(String jobName, String buildNumber) {
//C# TO JAVA CONVERTER TODO TASK: There is no equivalent to 'await' in Java:
        return await
        _jenkinsDataService.<Build>RequestAsync(URL.Build, getUrl(), getUserName(), getApiKey(), jobName, buildNumber).ContinueWith(t ->
        {
            t.Result.Job = new Job();
            t.Result.Job.setName(jobName);
            return t.Result;
        });

    }

    /**
     * Gets details of a build for a <see cref="Job"/> object
     *
     * @param job         Job to get a build from
     * @param buildNumber The build number requested
     * @return The requested build
     */
    public final Build GetBuildDetails(Job job, String buildNumber) {
        return GetBuildDetails(job.getName(), buildNumber);
    }

    /**
     * Asynchronously gets details of a build for a <see cref="Job"/> object
     *
     * @param job         Job to get a build from
     * @param buildNumber The build number requested
     * @return Task to retrieve the requested build
     */
//C# TO JAVA CONVERTER TODO TASK: There is no equivalent in Java to the 'async' keyword:
//ORIGINAL LINE: public async Task<Build> GetBuildDetailsAsync(Job job, string buildNumber)
    public final Task<Build> GetBuildDetailsAsync(Job job, String buildNumber) {
//C# TO JAVA CONVERTER TODO TASK: There is no equivalent to 'await' in Java:
        return await GetBuildDetailsAsync(job.getName(), buildNumber);
    }


    /**
     * Gets details of a computer.
     *
     * @param computerName Name of the computer requested
     * @return The requested computer
     */
    public final Computer GetComputerDetails(String computerName) {
        async returnVal = GetComputerDetailsAsync(computerName);
        returnVal.Wait();
        return returnVal.Result;
    }

    /**
     * Asynchronously gets details of a computer
     *
     * @param computerName Name of the computer requested
     * @return Task to retrieve the computer
     */
//C# TO JAVA CONVERTER TODO TASK: There is no equivalent in Java to the 'async' keyword:
//ORIGINAL LINE: public async Task<Computer> GetComputerDetailsAsync(string computerName)
    public final Task<Computer> GetComputerDetailsAsync(String computerName) {
//C# TO JAVA CONVERTER TODO TASK: There is no equivalent to 'await' in Java:
        return await
        _jenkinsDataService.<Computer>RequestAsync(URL.Computer, getUrl(), getUserName(), getApiKey(), computerName);
    }
}