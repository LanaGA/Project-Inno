package JenkinsDotNet.Model;

/**
 * Base class for models, providing common functionality
 *
 * <typeparam name="T"></typeparam>
 */
public abstract class JenkinsModel<T extends JenkinsModel<T>> {
    /**
     * Read a model from an XML fragment.
     *
     * @param element XML fragment
     * @return Object of the current type
     */
    public static <T> T FromXml(Object element) {
       /* T newObj = new T();
        return newObj.ParseFromXml(element) ? newObj : null;*/
        return null;
    }

    /**
     * Parses a model from Jenkins API XML.
     *
     * @param element XML fragment representing a model
     * @return <c>true</c> if XML was valid, <c>false</c> otherwise
     */
    protected abstract boolean ParseFromXml(Object element);

    /**
     * Updates a model from another instance of the same model.
     *
     * @param source The source object
     */
    public void UpdateFrom(T source) {
        // Iterate the Properties of the destination instance and
        // populate them from their source counterparts
        var destinationProperties = this.getClass();
		/*for (var destinationPi : destinationProperties)
		{
			System.Reflection.PropertyInfo sourcePi = source.getClass().GetProperty(destinationPi.Name);
			destinationPi.SetValue(this, sourcePi.GetValue(source, null), null);
		}*/
    }
}