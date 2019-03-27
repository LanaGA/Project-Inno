package JenkinsDotNet;

import JenkinsDotNet.Interfaces.*;
import JenkinsDotNet.Model.*;
import JenkinsDotNet.Services.*;
import javafx.concurrent.Task;

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
     */

    public JenkinsServer(String url, String username, String apikey) {
        this(url, username, apikey, "Jenkins Server");
    }

    public JenkinsServer(String url, String username, String apikey, String name) {
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
     */

    public JenkinsServer(IJenkinsDataService dataService, String url, String username, String apikey) {
        this(dataService, url, username, apikey, "Jenkins Server");
    }

    public JenkinsServer(IJenkinsDataService dataService, String url, String username, String apikey, String name) {
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
        async returnVal = GetNodeDetailsAsync();
        returnVal.Wait();
        return returnVal.Result;
    }

    /**
     * Asynchronously gets the details of a node.
     *
     * @return Task to retrieve the node
     */
    public final Task<Node> GetNodeDetailsAsync() {
        return await _jenkinsDataService.<Node>RequestAsync(URL.Api, getUrl(), getUserName(), getApiKey());
    }

    /**
     * Gets details of a job.
     *
     * @param jobName Name of the job requested
     * @return The requested job
     */
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
    public final JenkinsDataService GetJobDetailsAsync(String jobName) {
        return new JenkinsDataService(URL.Job, getUrl(), getUserName(), getApiKey(), jobName);
    }

    /**
     * Gets details of a build
     *
     * @param jobName     Name of the job to get a build from
     * @param buildNumber The build number requested
     * @return The requested build
     */
    public final Build GetBuildDetails(String jobName, String buildNumber) {
        var returnVal = GetBuildDetailsAsync(jobName, buildNumber);
        return returnVal.Result;
    }

    /**
     * Asynchronously gets details of a build
     *
     * @param jobName     Name of the job to get a build from
     * @param buildNumber The build number requested
     * @return Task to retrieve the requested build
     */
    public final JenkinsDataService GetBuildDetailsAsync(String jobName, String buildNumber) {
        return new JenkinsDataService(URL.Build, getUrl(), getUserName(), getApiKey(), jobName, buildNumber);

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
    public final Task<Build> GetBuildDetailsAsync(Job job, String buildNumber) {
        return GetBuildDetailsAsync(job.getName(), buildNumber);
    }


    /**
     * Gets details of a computer.
     *
     * @param computerName Name of the computer requested
     * @return The requested computer
     */
    public final Computer GetComputerDetails(String computerName) {
        var returnVal = GetComputerDetailsAsync(computerName);
        returnVal.Wait();
        return returnVal.Result;
    }

    /**
     * Asynchronously gets details of a computer
     *
     * @param computerName Name of the computer requested
     * @return Task to retrieve the computer
     */
    public final JenkinsDataService GetComputerDetailsAsync(String computerName) {
        return new JenkinsDataService(URL.Computer, getUrl(), getUrl(), getUserName(), getApiKey(), computerName);
    }
}