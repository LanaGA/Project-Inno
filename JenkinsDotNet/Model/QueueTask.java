package JenkinsDotNet.Model;

import JenkinsDotNet.*;

public class QueueTask extends JenkinsModel<QueueTask> {
    /**
     * Gets the name of this task
     */
    private String Name;

    public final String getName() {
        return Name;
    }

    private void setName(String value) {
        Name = value;
    }

    /**
     * Gets the URL of this task
     */
    private String Url;

    public final String getUrl() {
        return Url;
    }

    private void setUrl(String value) {
        Url = value;
    }

    /**
     * Gets whether thistask is currently blocked
     */
    private boolean Blocked;

    public final boolean getBlocked() {
        return Blocked;
    }

    private void setBlocked(boolean value) {
        Blocked = value;
    }

    /**
     * Parses a queue task from Jenkins API XML.
     *
     * @param element XML fragment representing a queue task
     * @return <c>true</c> if XML was valid, <c>false</c> otherwise
     */
    @Override
    protected boolean ParseFromXml(XElement element) {
        throw new UnsupportedOperationException();
    }
}