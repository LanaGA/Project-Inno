package JenkinsDotNet.Model;

import org.w3c.dom.Document;

/**
 * Represents an individual job
 */
public abstract class Build extends JenkinsModel<Build> {
    /**
     * Gets the build number.
     *
     * <value>The build number.</value>
     */
    private String Number;

    public String getNumber() {
        return Number;
    }

    private void setNumber(String value) {
        Number = value;
    }

    /**
     * Gets the build URL.
     *
     * <value>The build URL</value>
     */
    private String Url;

    public final String getUrl() {
        return Url;
    }

    private void setUrl(String value) {
        Url = value;
    }

    /**
     * Gets a short description of the build.
     *
     * <value>Short description of the build</value>
     */
    private String ShortDescription;

    public final String getShortDescription() {
        return ShortDescription;
    }

    private void setShortDescription(String value) {
        ShortDescription = value;
    }

    /**
     * Gets the full display name of the build.
     *
     * <value>The full name of the build</value>
     */
    private String FullDisplayName;

    public final String getFullDisplayName() {
        return FullDisplayName;
    }

    private void setFullDisplayName(String value) {
        FullDisplayName = value;
    }

    /**
     * Gets or sets the job this build belongs to.
     *
     * <value>The job</value>
     */
    private Job Job;

    public final Job getJob() {
        return Job;
    }

    public final void setJob(Job value) {
        Job = value;
    }

    /**
     * Parses a build from Jenkins API XML.
     *
     * @param element XML fragment representing a build
     * @return <c>true</c> if XML was valid, <c>false</c> otherwise
     */
    protected boolean ParseFromXml(Document element) {
        if (element == null) {
            return false;
        }

        return true;
    }
}