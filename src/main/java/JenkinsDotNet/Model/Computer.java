package JenkinsDotNet.Model;

import JenkinsDotNet.*;

import java.util.*;

/**
 * Represents an individual computer in a Jenkins cluster
 */
public class Computer extends JenkinsModel<Computer> {
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
    //TODO:Add other fields

    /**
     * Parses a computer from Jenkins API XML.
     *
     * @param element XML fragment representing a masterComputer or slaveComputer
     * @return <c>true</c> if XML was valid, <c>false</c> otherwise
     */
    @Override
    protected boolean ParseFromXml(Object element) {
        if (element == null) {
            return false;
        }
		/*ArrayList<Object> elements = element.Elements().ToList();
		// DisplayName
		setDisplayName(elements.First(x -> x.Name.equals("displayName")).Value);
		// Icon
		setIcon(elements.First(x -> x.Name.equals("icon")).Value);
		// Idle
		boolean idle;
		tangible.OutObject<Boolean> tempOut_idle = new tangible.OutObject<Boolean>();
		Boolean.TryParse(elements.Where(x -> x.Name.equals("idle")).Select(x -> x.Value).FirstOrDefault(), tempOut_idle);
	idle = tempOut_idle.argValue;
		setIdle(idle);
		// Offline
		boolean offline;
		tangible.OutObject<Boolean> tempOut_offline = new tangible.OutObject<Boolean>();
		Boolean.TryParse(elements.Where(x -> x.Name.equals("offline")).Select(x -> x.Value).FirstOrDefault(), tempOut_offline);
	offline = tempOut_offline.argValue;
		setOffline(offline);*/
        return true;
    }
}