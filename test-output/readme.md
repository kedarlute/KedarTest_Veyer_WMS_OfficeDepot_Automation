<?xml version="1.0" encoding="UTF-8"?>
<project-readme>
    <project>
        <name>KedarTest OfficeDepot Automation Framework</name>
        <description>
            A TestNG-based Selenium automation framework using Maven for dependency management,
            WebDriverManager for browser driver configuration, ExtentReports for reporting,
            and ThreadLocal WebDriver for parallel execution support.
        </description>
        <version>1.0.0</version>
        <author>Kedar Lute</author>
        <created></created>
    </project>

    <features>
        <feature>TestNG support for structured test execution</feature>
        <feature>Thread-safe WebDriver using Singleton with ThreadLocal</feature>
        <feature>Parallel test execution via testng.xml</feature>
        <feature>Rich ExtentReports with screenshots and tags</feature>
        <feature>Retry mechanism for failed tests</feature>
    </features>

    <dependencies>
        <dependency>selenium-java</dependency>
        <dependency>testng</dependency>
        <dependency>webdrivermanager</dependency>
        <dependency>extentreports</dependency>
    </dependencies>

    <project-structure>
        <directory>src/main/java</directory>
        <directory>src/test/java</directory>
        <directory>test-output</directory>
        <file>pom.xml</file>
        <file>testng.xml</file>
    </project-structure>

    <execution>
        <instructions>
            <step>Clone the project repository</step>
            <step>Import the project into IntelliJ IDEA</step>
            <step>Run `mvn clean test` or right-click on testng.xml → Run</step>
            <step>View ExtentReport in /test-output directory</step>
        </instructions>
    </execution>

    <report>
        <type>ExtentReport</type>
        <location>test-output/ExtentReport_*.html</location>
    </report>

    <notes>
        <note>Make sure ChromeDriver or WebDriverManager is properly set up</note>
        <note>Java 8+ required</note>
        <note>Run in parallel by modifying testng.xml: parallel="methods"</note>
    </notes>
</project-readme>