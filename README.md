# MySeleniumDemo
- Selenium skeleton with Page object model with Page Factory
- TestNg is used as a test framework
- Dependency Java Maven
- Running on Mac

# Prerequisites
1. Java JDK 8+, set up environment varible
2. Maven, set up environment varible
3. Eclipse IDE
4. Eclipse plug-in: TestNG

# How to run
- git clone from https://github.com/hatien85212/TienDaoSeleniumDemo.git
- cd to project folder
- run command: mvn clean test

# Some errors might occur
1. java.lang.IllegalStateException: The driver is not executable: /Users/tien.dao/git/TienDaoSeleniumDemo/src/test/resources/drivers/chromedriver
--> Reason: missing permission to execute the file
--> Solve: try to giving full permission to the chromedriver and it will work fine by following cmd: chmod +x chromedriver