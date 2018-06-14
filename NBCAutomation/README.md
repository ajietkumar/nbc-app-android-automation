# nbc-qa-automation
This Repo is for QA automation scripts for various platforms

# To create JENKINs jobs,

1) Launch Jenkins.
2) Click on ‘New Item’.
3) Enter an item Name ‘NBCDWebAutomation’ and select ‘Maven project’.
4)’Maven project name’ field should be auto populated else enter the name of the project as ‘NBCDWebAutomation’.
5) Select ‘Git’ under ‘Source Code Management’
6) Enter Repository URL as ‘’ https://github.com/nbcdotcom/nbc-qa-automation.git”.
7) Set Credentials as ‘-none-‘ and ‘Branch Specifier’ As ‘*/master’.
8) Select ‘Build whenever a SNAPSHOT dependency is built’ under ‘Build Triggers’.
9)Set Root POM as ‘pom.xml’ under ‘Build’.
10)Set ‘Goals and options’ as ‘clean test’.
11) Set Post Steps as ‘Run only if build succeeds’.
12)Set ‘TextNG XML report pattern as ‘**/testing-results.xml’.
13)Click Apply and Save.

src.zip: This zip file is with csv code.
