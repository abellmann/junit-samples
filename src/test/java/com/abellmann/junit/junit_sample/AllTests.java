package com.abellmann.junit.junit_sample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CustomerTest.class, MovieTest.class, RentalTest.class })
public class AllTests {

}
