package JenkinsDotNet.Model;

//import static org.simple.coollection.Coollection.*;

import org.w3c.dom.Document;

/**
 * Represents an individual computer in a Jenkins cluster
 */
public abstract class Computer extends JenkinsModel<Computer> {
    /**
     * Gets the build number.
     *
     * <value>The build number.</value>
     */
    private String DisplayName;

    public final String getDisplayName() {
        return DisplayName;
    }

    private void setDisplayName(String value) {
        DisplayName = value;
    }

    /**
     * Gets the build URL.
     *
     * <value>The build URL</value>
     */
    private String Icon;

    public final String getIcon() {
        return Icon;
    }

    private void setIcon(String value) {
        Icon = value;
    }

    /**
     * Gets a short description of the build.
     *
     * <value>Short description of the build</value>
     */
    private boolean Idle;

    public final boolean getIdle() {
        return Idle;
    }

    private void setIdle(boolean value) {
        Idle = value;
    }

    /**
     * Gets the full display name of the build.
     *
     * <value>The full name of the build</value>
     */
    private boolean Offline;

    public final boolean getOffline() {
        return Offline;
    }

    private void setOffline(boolean value) {
        Offline = value;
    }


    /**
     * Parses a computer from Jenkins API XML.
     *
     * @param element XML fragment representing a masterComputer or slaveComputer
     * @return <c>true</c> if XML was valid, <c>false</c> otherwise
     */
//TODO: find a way to connect the project-library collection
    protected boolean ParseFromXml(Document element) {
        if (element == null) {
            return false;
        }

        return true;
    }
}