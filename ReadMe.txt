--Run Tests--
Get this git repository to your local machine.

To run tests, please go following directory inside Eclipse or IntelliJ src/test/java/HWTests/Tests
Right Click and Run Tests


--Tool and Framework Versions--
Java Version: java 14 (Please check related SDK version before run the tests.)
Maven Version: 3.6.3 (Maven will download all necessary external libraries according to pom.xml)

junit Version 5.4.2

--Configuration--
Three browsers are supported. Drivers for these browsers located in driver folder.
Following details show minimum requirements and configuration.
To configure related web driver. You can change name parameter of driverConfig.json file under
src/config
folder.
Configuration details are below.

Min requirements for browsers(x64)

Chrome Release: 81.0.4044.92
Configuration in driverConfig.json
{
  "name": "chrome"
}


Firefox Release: 75.0
Configuration in driverConfig.json
{
  "name": "firefox"
}

Edge Release: 80.0.361.111
Configuration in driverConfig.json
{
  "name": "edge"
}

