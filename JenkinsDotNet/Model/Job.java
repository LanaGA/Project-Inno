package JenkinsDotNet.Model;

import JenkinsDotNet.*;

import java.util.*;

import static org.simple.coollection.Coollection.*;

/**
 * Represents an individual job
 */
public class Job extends JenkinsModel<Job> {
    /**
     * Gets the name of the job.
     *
     * <value>
     * The name
     * </value>
     */
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String value) {
        Name = value;
    }

    /**
     * Gets the URL of the job.
     *
     * <value>
     * The URL
     * </value>
     */
    private String Url;

    public final String getUrl() {
        return Url;
    }

    private void setUrl(String value) {
        Url = value;
    }

    /**
     * Gets the color (status) of the job.
     *
     * <value>
     * The color - blue = success, red = failure
     * </value>
     */
    private String Color;

    public final String getColor() {
        return Color;
    }

    private void setColor(String value) {
        Color = value;
    }

    /**
     * Gets the display name of the job.
     *
     * <value>
     * The display name
     * </value>
     */
    private String DisplayName;

    public final String getDisplayName() {
        return DisplayName;
    }

    private void setDisplayName(String value) {
        DisplayName = value;
    }

    /**
     * Gets the description of the job.
     *
     * <value>
     * The description
     * </value>
     */
    private String Description;

    public final String getDescription() {
        return Description;
    }

    private void setDescription(String value) {
        Description = value;
    }

    /**
     * Gets the upstream projects from this job
     *
     * <value>
     * List of upstream projects
     * </value>
     */
    private List<Job> UpstreamProjects;

    public final List<Job> getUpstreamProjects() {
        return UpstreamProjects;
    }

    private void setUpstreamProjects(List<Job> value) {
        UpstreamProjects = value;
    }

    /**
     * Gets the downstream projects from this job.
     *
     * <value>
     * List of downstream projects
     * </value>
     */
    private List<Job> DownstreamProjects;

    public final List<Job> getDownstreamProjects() {
        return DownstreamProjects;
    }

    private void setDownstreamProjects(List<Job> value) {
        DownstreamProjects = value;
    }

    /**
     * Gets the past builds of this job.
     *
     * <value>
     * List of builds
     * </value>
     */
    private List<Build> Builds;

    public final List<Build> getBuilds() {
        return Builds;
    }

    private void setBuilds(List<Build> value) {
        Builds = value;
    }

    /**
     * Gets the last run build of this job.
     *
     * <value>
     * The last build
     * </value>
     */
    private Build LastBuild;

    public final Build getLastBuild() {
        return LastBuild;
    }

    private void setLastBuild(Build value) {
        LastBuild = value;
    }

    /**
     * Gets the last completed build of this job.
     *
     * <value>
     * The last completed build
     * </value>
     */
    private Build LastCompletedBuild;

    public final Build getLastCompletedBuild() {
        return LastCompletedBuild;
    }

    private void setLastCompletedBuild(Build value) {
        LastCompletedBuild = value;
    }

    /**
     * Gets the last failed build of this job.
     *
     * <value>
     * The last failed build
     * </value>
     */
    private Build LastFailedBuild;

    public final Build getLastFailedBuild() {
        return LastFailedBuild;
    }

    private void setLastFailedBuild(Build value) {
        LastFailedBuild = value;
    }

    /**
     * Gets the last stable build of this job.
     *
     * <value>
     * The last stable build
     * </value>
     */
    private Build LastStableBuild;

    public final Build getLastStableBuild() {
        return LastStableBuild;
    }

    private void setLastStableBuild(Build value) {
        LastStableBuild = value;
    }

    /**
     * Gets the last successful build of this job.
     *
     * <value>
     * The last successful build
     * </value>
     */
    private Build LastSuccessfulBuild;

    public final Build getLastSuccessfulBuild() {
        return LastSuccessfulBuild;
    }

    private void setLastSuccessfulBuild(Build value) {
        LastSuccessfulBuild = value;
    }

    /**
     * Gets the last unsuccessful build of this job.
     *
     * <value>
     * The last unsuccessful build
     * </value>
     */
    private Build LastUnsuccessfulBuild;

    public final Build getLastUnsuccessfulBuild() {
        return LastUnsuccessfulBuild;
    }

    private void setLastUnsuccessfulBuild(Build value) {
        LastUnsuccessfulBuild = value;
    }

    /**
     * Parses a job from Jenkins API XML.
     *
     * @param element XML fragment representing a job
     * @return <c>true</c> if XML was valid, <c>false</c> otherwise
     */
    @Override
    protected boolean ParseFromXml(XElement element) {
        return false;
    }

// TODO: find a way to connect the project-library collection
   /*
   protected boolean ParseFromXml(XElement element) {
        if (element == null) {
            return false;
        }
        ArrayList<Object> elements = element.Elements().ToList();
        // Name
        Name = elements.First(x => x.Name == "name").Value;
        // Url
        Url = elements.First(x => x.Name == "url").Value;
        // Color
        Color = elements.First(x => x.Name == "color").Value;
        // DisplayName
        DisplayName = elements.Where(x => x.Name == "displayName").Select(x=>x.Value).FirstOrDefault();
        // Description
        Description = elements.Where(x => x.Name == "description").Select(x => x.Value).FirstOrDefault();
        // UpstreamProjects
        UpstreamProjects = elements.Where(x => x.Name == "upstreamProject").Select(FromXml).ToList();
        // DownstreamProjects
        DownstreamProjects = elements.Where(x => x.Name == "downstreamProject").Select(FromXml).ToList();
        // Builds
        Builds = elements.Where(x => x.Name == "build").Select(JenkinsModel<Build>.FromXml).ToList();
        // LastBuild
        LastBuild = JenkinsModel<Build>.FromXml(elements.FirstOrDefault(x => x.Name == "lastBuild"));
        // LastCompletedBuild
        LastCompletedBuild = JenkinsModel<Build>.FromXml(elements.FirstOrDefault(x => x.Name == "lastCompletedBuild"));
        // LastFailedBuild
        LastFailedBuild = JenkinsModel<Build>.FromXml(elements.FirstOrDefault(x => x.Name == "lastFailedBuild"));
        // LastStableBuild
        LastStableBuild = JenkinsModel<Build>.FromXml(elements.FirstOrDefault(x => x.Name == "lastStableBuild"));
        // LastSuccessfulBuild
        LastSuccessfulBuild = JenkinsModel<Build>.FromXml(elements.FirstOrDefault(x => x.Name == "lastSuccessfulBuild"));
        // LastUnsuccessfulBuild
        LastUnsuccessfulBuild = JenkinsModel<Build>.FromXml(elements.FirstOrDefault(x => x.Name == "lastUnsuccessfulBuild"));
        return true;
    }*/
}