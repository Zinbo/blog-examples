package mockitocheatsheet;

public class Configuration {

    private RepositoryConfiguration repositoryConfiguration;

    public RepositoryConfiguration getRepositoryConfiguration() {
        return repositoryConfiguration;
    }

    public void verifyConnectionToDatabaseIsAlive() {
        // check db here
    }

    public class RepositoryConfiguration {

        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();

        public DatabaseConfiguration getDatabaseConfiguration() {
            return databaseConfiguration;
        }

        public class DatabaseConfiguration {

            private DriverConfiguration driverConfiguration;

            public DriverConfiguration getDriverConfiguration() {
                return driverConfiguration;
            }

            public class DriverConfiguration {
                private String driverType;

                public String getDriverType() {
                    return driverType;
                }
            }

        }
    }




}
