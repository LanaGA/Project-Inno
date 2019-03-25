package JenkinsDotNet.Model;

import JenkinsDotNet.*;

import java.util.*;

/**
 * Represents an individual view
 */
public class View extends JenkinsModel<View> {
    /**
     * Gets the name of this view
     */
    private String Name;

    public final String getName() {
        return Name;
    }

    private void setName(String value) {
        Name = value;
    }

    /**
     * Gets the URL of this view
     */
    private String Url;

    public final String getUrl() {
        return Url;
    }

    private void setUrl(String value) {
        Url = value;
    }

    /**
     * Gets the list of jobs in this view
     */
    private List<Job> Jobs;

    public final List<Job> getJobs() {
        return Jobs;
    }

    private void setJobs(List<Job> value) {
        Jobs = value;
    }

    /**
     * Parses a view from Jenkins API XML.
     *
     * @param element XML fragment representing a view
     * @return <c>true</c> if XML was valid, <c>false</c> otherwise
     */
    @Override
    protected boolean ParseFromXml(XElement element) {
        throw new UnsupportedOperationException();
    }
}