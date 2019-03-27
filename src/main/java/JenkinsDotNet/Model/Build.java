package JenkinsDotNet.Model;

import JenkinsDotNet.*;

import java.util.*;

/**
 * Represents an individual job
 */
public class Build extends JenkinsModel<Build> {
    /**
     * Gets the build number.
     *
     * <value>The build number.</value>
     */
    private String Number;

    public final String getNumber() {
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
    //TODO:Add other fields

    /**
     * Parses a build from Jenkins API XML.
     *
     * @param element XML fragment representing a build
     * @return <c>true</c> if XML was valid, <c>false</c> otherwise
     */
    @Override
    protected boolean ParseFromXml(Object element) {
        if (element == null) {
            return false;
        }
		/*ArrayList<Object> elements = element.Elements().ToList();
		// Number
		setNumber(elements.First(x -> x.Name.equals("number")).Value);
		// Url
		setUrl(elements.First(x -> x.Name.equals("url")).Value);
		// ShortDescription
		setShortDescription(elements.Where(x -> x.Name.equals("shortDescription")).Select(x -> x.Value).FirstOrDefault());
		// FullName
		setFullDisplayName(elements.Where(x -> x.Name.equals("fullDisplayName")).Select(x -> x.Value).FirstOrDefault());
		*/
        return true;
    }
}