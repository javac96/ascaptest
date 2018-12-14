$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MembershipApplicationWriter.feature");
formatter.feature({
  "line": 2,
  "name": "Membership Application flow",
  "description": "",
  "id": "membership-application-flow",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@MembershipApplicationWriters"
    }
  ]
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 22,
      "value": "#And User selects \"No\" for a member of different PRO"
    },
    {
      "line": 23,
      "value": "#When User completes General section with required information"
    },
    {
      "line": 24,
      "value": "#And User clicks on \"Continue\" button in \"Membership Application\" page"
    },
    {
      "line": 25,
      "value": "#Then System should display the Royalties Section"
    }
  ],
  "line": 28,
  "name": "Validate the Writer enrollment for US resident without direct deposit",
  "description": "",
  "id": "membership-application-flow;validate-the-writer-enrollment-for-us-resident-without-direct-deposit",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 27,
      "name": "@writer_US_resident_with_DD"
    },
    {
      "line": 27,
      "name": "@regression"
    }
  ]
});
formatter.step({
  "line": 29,
  "name": "User selects \"Music Creators\" tab",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "User clicks on \"Join\" link",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "User navigates to the \"Membership Application\" page",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "User selects membership type as \"\u003cmembershipType\u003e\" in page \"\u003cpageName\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "User clicks on \"Continue\" button in \"Membership Application\" page",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "System should display the General Section",
  "keyword": "Then "
});
formatter.examples({
  "line": 36,
  "name": "",
  "description": "",
  "id": "membership-application-flow;validate-the-writer-enrollment-for-us-resident-without-direct-deposit;",
  "rows": [
    {
      "cells": [
        "pageName",
        "membershipType"
      ],
      "line": 37,
      "id": "membership-application-flow;validate-the-writer-enrollment-for-us-resident-without-direct-deposit;;1"
    },
    {
      "cells": [
        "MembershipApplication",
        "writer"
      ],
      "line": 38,
      "id": "membership-application-flow;validate-the-writer-enrollment-for-us-resident-without-direct-deposit;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 9096544913,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User is in \"ASCAP Dashboard\" using \"Chrome\" browser",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "ASCAP Dashboard",
      "offset": 12
    },
    {
      "val": "Chrome",
      "offset": 36
    }
  ],
  "location": "WebStepDefs.navigationToDashboard(String,String)"
});
formatter.result({
  "duration": 343877111,
  "status": "passed"
});
formatter.scenario({
  "line": 38,
  "name": "Validate the Writer enrollment for US resident without direct deposit",
  "description": "",
  "id": "membership-application-flow;validate-the-writer-enrollment-for-us-resident-without-direct-deposit;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@MembershipApplicationWriters"
    },
    {
      "line": 27,
      "name": "@writer_US_resident_with_DD"
    },
    {
      "line": 27,
      "name": "@regression"
    }
  ]
});
formatter.step({
  "line": 29,
  "name": "User selects \"Music Creators\" tab",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "User clicks on \"Join\" link",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "User navigates to the \"Membership Application\" page",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "User selects membership type as \"writer\" in page \"MembershipApplication\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "User clicks on \"Continue\" button in \"Membership Application\" page",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "System should display the General Section",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Music Creators",
      "offset": 14
    }
  ],
  "location": "WebStepDefs.selectTab(String)"
});
formatter.result({
  "duration": 5571327228,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Join",
      "offset": 16
    }
  ],
  "location": "WebStepDefs.clickOnLink(String)"
});
formatter.result({
  "duration": 4677921555,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Membership Application",
      "offset": 23
    }
  ],
  "location": "WebStepDefs.navigateToPage(String)"
});
formatter.result({
  "duration": 96701926,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "writer",
      "offset": 33
    },
    {
      "val": "MembershipApplication",
      "offset": 50
    }
  ],
  "location": "WebStepDefs.selectMembershipType(String,String)"
});
formatter.result({
  "duration": 498342828,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Continue",
      "offset": 16
    },
    {
      "val": "Membership Application",
      "offset": 37
    }
  ],
  "location": "WebStepDefs.clickOnButton(String,String)"
});
formatter.result({
  "duration": 114081467,
  "status": "passed"
});
formatter.match({
  "location": "WebStepDefs.validateGeneralSection()"
});
formatter.result({
  "duration": 64166061,
  "status": "passed"
});
formatter.after({
  "duration": 2526820813,
  "status": "passed"
});
});