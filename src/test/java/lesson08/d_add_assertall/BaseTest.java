package lesson08.d_add_assertall;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.junit.AfterClass;
import org.junit.AssumptionViolatedException;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest extends SimpleAPI {

    protected static WebDriver driver;

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.printf("Test '%s' - PASSED" + System.lineSeparator(), description.getMethodName());
            super.succeeded(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.printf("Test '%s' - FAILED due to: %s" + System.lineSeparator(),
                    description.getMethodName(),
                    e.getMessage());
            super.failed(e, description);
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            System.out.printf("Test '%s' - SKIPPED" + System.lineSeparator(), description.getMethodName());
            super.skipped(e, description);
        }

        @Override
        protected void starting(Description description) {
            System.out.printf("Test '%s' - is starting ..." + System.lineSeparator(), description.getMethodName());
            super.starting(description);
        }
    };

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Override
    WebDriver getDriver() {
        return driver;
    }

    void assertAll(Assertion... assertions) {
        List<Throwable> errors = new ArrayList<>();
        for (Assertion assertion : assertions) {
            try {
                assertion.assertSmth();
            } catch (Throwable throwable) {
                errors.add(throwable);
            }
        }
        if (!errors.isEmpty()) {
            throw new AssertionError(errors
                    .stream()
                    .map(assertionError -> "\n Failed" + assertionError.getMessage())
                    .collect(Collectors.toList()).toString());
        }
    }

    @FunctionalInterface
    public interface Assertion {
        void assertSmth();
    }
}
