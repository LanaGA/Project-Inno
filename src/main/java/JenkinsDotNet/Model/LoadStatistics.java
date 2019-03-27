package JenkinsDotNet.Model;

import JenkinsDotNet.*;

/** 
 Represents the overall load of a Jenkins node.
*/
public class LoadStatistics extends JenkinsModel<LoadStatistics>
{
	/** 
	 Gets the queue length of this node
	*/
	private float QueueLength;
	public final float getQueueLength()
	{
		return QueueLength;
	}
	private void setQueueLength(float value)
	{
		QueueLength = value;
	}
	/** 
	 Gets the current number of busy executors
	*/
	private float BusyExecutors;
	public final float getBusyExecutors()
	{
		return BusyExecutors;
	}
	private void setBusyExecutors(float value)
	{
		BusyExecutors = value;
	}
	/** 
	 Gets the total available executors 
	*/
	private float TotalExecutors;
	public final float getTotalExecutors()
	{
		return TotalExecutors;
	}
	private void setTotalExecutors(float value)
	{
		TotalExecutors = value;
	}

	/** 
	 Parses a LoadStatistics object from Jenkins API XML.
	 
	 @param element XML fragment representing a node's LoadStatistics
	 @return <c>true</c> if XML was valid, <c>false</c> otherwise
	*/
	@Override
	protected boolean ParseFromXml(Object element)
	{
		throw new UnsupportedOperationException();
	}
}