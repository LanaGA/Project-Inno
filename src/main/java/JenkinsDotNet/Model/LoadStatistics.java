package JenkinsDotNet.Model;

import org.w3c.dom.Document;

/**
 * Represents the overall load of a Jenkins node.
 */
public abstract class LoadStatistics extends JenkinsModel<LoadStatistics> {
    /**
     * Gets the queue length of this node
     */
    private float QueueLength;

    public final float getQueueLength() {
        return QueueLength;
    }

    private void setQueueLength(float value) {
        QueueLength = value;
    }

    /**
     * Gets the current number of busy executors
     */
    private float BusyExecutors;

    public final float getBusyExecutors() {
        return BusyExecutors;
    }

    private void setBusyExecutors(float value) {
        BusyExecutors = value;
    }

    /**
     * Gets the total available executors
     */
    private float TotalExecutors;

    public final float getTotalExecutors() {
        return TotalExecutors;
    }

    private void setTotalExecutors(float value) {
        TotalExecutors = value;
    }

    /**
     * Parses a LoadStatistics object from Jenkins API XML.
     *
     * @param element XML fragment representing a node's LoadStatistics
     * @return <c>true</c> if XML was valid, <c>false</c> otherwise
     */
    @Override
    protected boolean ParseFromXml(Document element) {
        throw new UnsupportedOperationException();
    }
}