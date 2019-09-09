# pom-selenium-alure-testng

I have followed POM staructure for this automation project. Project has been made as a TestNG project and for a better report viewing purpose, I have added Allure reporting tool to this project.

# Prerequisites
* JDK `8` or higher
* Gradle use `4.0.1` (Download Gradle from https://gradle.org/releases/ and keep Gradle files in C:\Program Files)
* Chrome version `64.0`

### How to run test and check the test report
1. After cloning the project, go to the directory `".\pom-selenium-allure-testng`
2. Build the automation project with gradle.
3. After step 2, run allure report with allure.
4. Check the report in generated allure report in its server

##### NB. 
If you want to share the allure report link to others, make sure that your PC is turned on and you and the shared user must be in same network

### Building with Gradle
```sh
$ gradle clean test
```
Downloaded files (including the Gradle distribution itself) will be stored in the Gradle user home directory (typically `user_home/.gradle`).

### Building report with Allure

```sh
$ gradle allureserve
```
For first time report generation with allure, Need to run in the following command:
```sh
$ gradle allurereport allureserve
```











