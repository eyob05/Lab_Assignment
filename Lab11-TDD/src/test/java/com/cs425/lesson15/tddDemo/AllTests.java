package com.cs425.lesson15.tddDemo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArrayFlattenerAppTest.class, FlattenerAppNullTest.class })
public class AllTests {

}
