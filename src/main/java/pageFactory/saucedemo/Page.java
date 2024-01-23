package pageFactory.saucedemo;

public interface Page<T> {
    T waitUntilPageLoaded();
}
