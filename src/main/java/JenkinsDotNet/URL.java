package JenkinsDotNet;

// ReSharper disable InconsistentNaming
	public final class URL
	{
// ReSharper restore InconsistentNaming
		public static final URL LoadStatistics = new URL("/overallLoad/api/xml");
		public static final URL BuildQueue = new URL("/queue/api/xml");
		public static final URL Api = new URL("/api/xml");
		public static final URL Job = new URL("/job/{0}/api/xml");
		public static final URL Computer = new URL("/computer/{0}/api/xml");
		public static final URL Build = new URL("/job/{0}/{1}/api/xml");
		private String _url;

		private URL(String url)
		{
			_url = url;
		}

		public String Url(Object... parameters)
		{
			return String.format(toString(), parameters);
		}

		@Override
		public String toString()
		{
			return _url;
		}
	}