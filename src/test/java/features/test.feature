@test1

Feature:Test feature
  Scenario: Get custom request
    * def testUtils = call read('classpath:features/utils.feature')
    * def getRequest = testUtils.customRequest()
    * print getRequest


