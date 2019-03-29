package JenkinsDotNet.Model;

import org.w3c.dom.Document;

/**
 * Base class for models, providing common functionality
 *
 * <typeparam name="T"></typeparam>
 */
// TODO: find analog XElement
public abstract class JenkinsModel<T extends JenkinsModel<T>> {
    /**
     * Read a model from an XML fragment.
     *
     * @param element XML fragment
     * @return Object of the current type
     */
    public static <T> T FromXml(Document element) {
        return null;

    }

    /**
     * Parses a model from Jenkins API XML.
     *
     * @param element XML fragment representing a model
     * @return <c>true</c> if XML was valid, <c>false</c> otherwise
     */
    protected abstract boolean ParseFromXml(Document element);

}