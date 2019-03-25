//====================================================================================================
//The Free Edition of C# to Java Converter limits conversion output to 100 lines per file.

//To subscribe to the Premium Edition, visit our website:
//https://www.tangiblesoftwaresolutions.com/order/order-csharp-to-java.html
//====================================================================================================

package JenkinsDotNet.Tests;

import JenkinsDotNet.Interfaces.IJenkinsDataService;
import JenkinsDotNet.JenkinsServer;
import JenkinsDotNet.Model.Build;
import JenkinsDotNet.Model.Job;
import JenkinsDotNet.Model.Node;
import JenkinsDotNet.URL;
import javafx.concurrent.Task;
import org.powermock.core.MockRepository;
// TODO: makes MockRepository works
import java.util.List;

import static sun.rmi.transport.TransportConstants.Return;


public class JenkinsServerUnitTest {

    private final String _url = "http://www.example.com";
    private final String _userName = "testUser";
    private final String _apiKey = "someNewApiKey";
    private final String _name = "Test Jenkins Server";
    private final String _jobName = "Test Jenkins Job";
    private final Object[] _jobNameList = new Object[1];
    private final String _buildNumber = "99";
    private final Object[] _buildNumberList = new Object[2];
    private IJenkinsDataService _mockDataService;
    private JenkinsServer _targetServer;

    public static class MockJob extends Job {
        private String Name;

        public final String getName() {
            return Name;
        }

        public final void setName(String value) {
            Name = value;
        }
    }

    public static class MockBuild extends Build {
        private String Number;

        public final String getNumber() {
            return Number;
        }

        public final void setNumber(String value) {
            Number = value;
        }
    }

    public final void InitTests() {
        // Stub DataService and setupexpected return
        _mockDataService = MockRepository.<IJenkinsDataService>GenerateStub();
        _targetServer = new JenkinsServer(_mockDataService, _url, _userName, _apiKey, _name);
        _jobNameList[0] = _jobName;
        _buildNumberList[0] = _buildNumber;
        _buildNumberList[1] = _jobName;

    }

    public final void CleanupTests() {
        _mockDataService.BackToRecord(BackToRecordOptions.All);
        _targetServer = null;
    }

    public final void GetNodeDetails_ServiceAvailable_NodeReturned() {
        // Arrange
        Node expected = new Node();
        Task<Node> expectedTask = new Task<Node>(() -> expected);
        expectedTask.Start();

        // VS reports a compiler error here but tests run fine...
        _mockDataService.Expect(ds -> ds.<Node>RequestAsync(Arg.Is(URL.Api), Arg.Is(_url), Arg.Is(_userName), Arg.Is(_apiKey), Arg < Object[]>.
        Is.Anything)).Return(expectedTask);
        //mockDataService.Expect(
        //    ds =>ds.RequestAsync<Node>(Arg.Is(URL.Api), Arg.Is(url), Arg.Is(userName), Arg.Is(apiKey),Arg<object[]>.Is.Anything));

        // Act
        var actual = _targetServer.GetNodeDetails();

        // Assert
        assert actual == expected;
        _mockDataService.VerifyAllExpectations();
    }

    public final void GetNodeDetailsAsync_ServiceAvailable_NodeReturned() {
        // Arrange
        Node expected = new Node();
        Task<Node> expectedTask = new Task<Node>(() -> expected);
        expectedTask.Start();

        // VS reports a compiler error here but tests run fine...
        _mockDataService.Expect(ds -> ds.<Node>RequestAsync(Arg.Is(URL.Api), Arg.Is(_url), Arg.Is(_userName), Arg.Is(_apiKey), Arg < Object[]>.
        Is.Anything)).Return(expectedTask);

        // Act
        var actualTask = _targetServer.GetNodeDetailsAsync();
        actualTask.Wait();
        var actual = actualTask.Result;

        // Assert
        assert actual == expected;
        _mockDataService.VerifyAllExpectations();
    }

    public final void GetJobDetails_ServiceAvailable_JobReturned() {
        // Arrange
        MockJob expected = new MockJob();
        expected.Name = _jobName;
        Task<Job> expectedTask = new Task<Job>(() -> expected);
        expectedTask.Start();

        // VS reports a compiler error here but tests run fine...
        _mockDataService.Expect(ds -> ds.<Job>RequestAsync(Arg.Is(URL.Job), Arg.Is(_url), Arg.Is(_userName), Arg.Is(_apiKey), Arg < Object[]>.
        List.ContainsAll(_jobNameList))).Return(expectedTask);

        // Act
        var actual = _targetServer.GetJobDetails(_jobName);

        // Assert
        assert actual == expected;
        _mockDataService.VerifyAllExpectations();
    }

    public final void GetJobDetailsAsync_ServiceAvailable_JobReturned() {
        // Arrange
        MockJob expected = new MockJob();
        expected.Name = _jobName;
        Task<Job> expectedTask = new Task<Job>(() -> expected);
        expectedTask.Start();

        // VS reports a compiler error here but tests run fine...
        _mockDataService.Expect(ds -> ds.<Job>RequestAsync(Arg.Is(URL.Job), Arg.Is(_url), Arg.Is(_userName), Arg.Is(_apiKey), Arg < Object[]>.
        List.ContainsAll(_jobNameList))).Return(expectedTask);
        //mockDataService.Expect(
        //    ds =>ds.RequestAsync<Node>(Arg.Is(URL.Api), Arg.Is(url), Arg.Is(userName), Arg.Is(apiKey),Arg<object[]>.Is.Anything));

        _targetServer = new JenkinsServer(_mockDataService, _url, _userName, _apiKey, _name);

        // Act
        var actualTask = _targetServer.GetJobDetailsAsync(_jobName);
        actualTask.Wait();
        var actual = actualTask.Result;

        // Assert
        assert actual == expected;
        _mockDataService.VerifyAllExpectations();
    }

    public final void GetBuildDetails_ServiceAvailable_BuildReturned() {
        // Arrange
        MockBuild expected = new MockBuild();
        expected.Number = _buildNumber;
        Task<Build> expectedTask = new Task<Build>(() -> expected);
        expectedTask.Start();

        // VS reports a compiler error here but tests run fine...
        _mockDataService.Expect(ds -> ds.<Build>RequestAsync(Arg.Is(URL.Build), Arg.Is(_url), Arg.Is(_userName), Arg.Is(_apiKey), Arg < Object[]>.
        List.ContainsAll(_buildNumberList))).Return(expectedTask);

        // Act
        var actual = _targetServer.GetBuildDetails(_jobName, _buildNumber);

        // Assert
        assert actual == expected;
        _mockDataService.VerifyAllExpectations();
    }

    public final void GetBuildDetailsAsync_ServiceAvailable_BuildReturned() {
        // Arrange
        MockBuild expected = new MockBuild();
        expected.Number = _buildNumber;
        Task<Build> expectedTask = new Task<Build>(() -> expected);
        expectedTask.Start();

        // VS reports a compiler error here but tests run fine...
        _mockDataService.Expect(ds -> ds.<Build>RequestAsync(Arg.Is(URL.Build), Arg.Is(_url), Arg.Is(_userName), Arg.Is(_apiKey), Arg < Object[]>.
        List.ContainsAll(_buildNumberList))).Return(expectedTask);
        //mockDataService.Expect(
        //    ds =>ds.RequestAsync<Node>(Arg.Is(URL.Api), Arg.Is(url), Arg.Is(userName), Arg.Is(apiKey),Arg<object[]>.Is.Anything));

        _targetServer = new JenkinsServer(_mockDataService, _url, _userName, _apiKey, _name);

        // Act
        var actualTask = _targetServer.GetBuildDetailsAsync(_jobName, _buildNumber);
        actualTask.Wait();
        var actual = actualTask.Result;

        // Assert
        assert actual == expected;
        _mockDataService.VerifyAllExpectations();
    }
}