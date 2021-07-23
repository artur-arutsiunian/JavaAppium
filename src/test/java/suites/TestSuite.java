package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.ChangeAppConditionTests;
import tests.MyListsTests;
import tests.SearchTests;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ChangeAppConditionTests.class,
        MyListsTests.class,
        SearchTests.class
})

public class TestSuite {
}
