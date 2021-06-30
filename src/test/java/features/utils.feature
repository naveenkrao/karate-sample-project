
  Feature: common utilities

    Scenario:
      * def randomAlphabetic = function (count) { return org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(count) }

      * def customRequest =
      """
       function() {
       var name = randomAlphabetic(2)
       return {
           name:name,
           city:'Bangalore'
       }
    }
      """



