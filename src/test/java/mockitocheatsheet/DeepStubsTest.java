package mockitocheatsheet;

import mockitocheatsheet.Configuration.RepositoryConfiguration;
import mockitocheatsheet.Configuration.RepositoryConfiguration.DatabaseConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class DeepStubsTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkIfDriverIsPostgres_withPostgresDriver_returnsTrue() {
        // arrange
        Configuration configMock = Mockito.mock(Configuration.class);
        RepositoryConfiguration repositoryConfigMock = Mockito.mock(RepositoryConfiguration.class);
        Mockito.when(configMock.getRepositoryConfiguration()).thenReturn(repositoryConfigMock);
        DatabaseConfiguration databaseConfigMock = Mockito.mock(DatabaseConfiguration.class);
        Mockito.when(repositoryConfigMock.getDatabaseConfiguration()).thenReturn(databaseConfigMock);
        DatabaseConfiguration.DriverConfiguration driverConfigMock = Mockito.mock(DatabaseConfiguration.DriverConfiguration.class);
        Mockito.when(databaseConfigMock.getDriverConfiguration()).thenReturn(driverConfigMock);
        Mockito.when(driverConfigMock.getDriverType()).thenReturn("postgres");

        BlogRepository blogRepository = new BlogRepository(configMock);

        // act
        boolean actual = blogRepository.checkIfDriverIsPostgres();

        // assert
        Assert.assertTrue(actual);
    }

    @Test
    public void usingDeepStubs_checkIfDriverIsPostgres_withPostgresDriver_returnsTrue() {
        // arrange
        Configuration configMock = Mockito.mock(Configuration.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(configMock.getRepositoryConfiguration()
                .getDatabaseConfiguration().getDriverConfiguration().getDriverType()).thenReturn("postgres");

        BlogRepository blogRepository = new BlogRepository(configMock);

        // act
        boolean actual = blogRepository.checkIfDriverIsPostgres();

        // assert
        Assert.assertTrue(actual);
    }
}
