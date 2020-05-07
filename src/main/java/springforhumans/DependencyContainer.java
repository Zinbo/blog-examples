package springforhumans;

public class DependencyContainer {

    public static BlogPostService getBlogPostService() {

        return new BlogPostService(getDatabaseRepository());
    }

    public static DatabaseRepository getDatabaseRepository() {
        return new PostgresDatabaseRepository();
    }
}
