package JenkinsDotNet.Model;
import static org.simple.coollection.Coollection.*;
import JenkinsDotNet.*;
import java.util.*;

/**
 * Represents a single Jenkins node
 */
public class Node extends JenkinsModel<Node> {
    /**
     * Gets the description of this node
     */
    private String Description;

    public final String getDescription() {
        return Description;
    }

    private void setDescription(String value) {
        Description = value;
    }

    /**
     * Gets the name of this node
     */
    private String Name;

    public final String getName() {
        return Name;
    }

    private void setName(String value) {
        Name = value;
    }

    /**
     * Gets the number of available executors on this node
     */
    private int NumExecutors;

    public final int getNumExecutors() {
        return NumExecutors;
    }

    private void setNumExecutors(int value) {
        NumExecutors = value;
    }

    /**
     * Gets the jobs configured on this node
     */
    private List<Job> Jobs;

    public final List<Job> getJobs() {
        return Jobs;
    }

    private void setJobs(List<Job> value) {
        Jobs = value;
    }

    /**
     * Gets the overall load of this node
     */
    private LoadStatistics LoadStatistics;

    public final LoadStatistics getLoadStatistics() {
        return LoadStatistics;
    }

    private void setLoadStatistics(LoadStatistics value) {
        LoadStatistics = value;
    }

    /**
     * Gets the views associated with this node
     */
    private List<View> Views;

    public final List<View> getViews() {
        return Views;
    }

    private void setViews(List<View> value) {
        Views = value;
    }

    /**
     * Parses a node from Jenkins API XML.
     *
     * @param element XML fragment representing a node
     * @return <c>true</c> if XML was valid, <c>false</c> otherwise
     */
    @Override
    //TODO: find a way to connect the project-library collection
    protected boolean ParseFromXml(XElement element) {
        if (element == null) {
            return false;
        }
        ArrayList<Object> elements = element.Elements().ToList();

        // Name and description
        setName(elements.First(rom(elements).where("nodeName", eq(x -> x.Name)).Value);
        setDescription(from(elements).where("nodeDescription", eq(x -> x.Name)).Value);

        // Num executors
        int numExecutors;
        tangible.OutObject<Integer> tempOut_numExecutors = new tangible.OutObject<Integer>();
        tangible.TryParseHelper.tryParseInt(from(elements).where("numExecutord", eq(x -> x.Name)).first).Value, tempOut_numExecutors);
        numExecutors = tempOut_numExecutors.argValue;
        setNumExecutors(numExecutors);

        // Jobs

        setJobs(from(elements).where("job", eq(x -> x.Name)).Select(JenkinsModel < Job >.FromXml).ToList());

        return true;
    }
}