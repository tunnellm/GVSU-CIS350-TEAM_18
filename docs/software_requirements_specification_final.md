# Overview

> The purpose of this document is to present a detailed account of the features and test cases for the Android application, ColCalendar18. This document explains the purpose and features of the calendar, the interfaces thereof, what the calendar will do, and the constaints under which it must operate. Furthermore, this document details how the calendar will react to external stimuli such as End-User input. This document further details the test cases by which the application has been rigorously tested on. This document is intended for all stakeholders of the calendar. Stakeholders include, but are not limited to, the investors, the developers, and the quality assurance testing team. This document and application are to be proposed to mrdoktorprofessor and the 1-PM Morning class of CIS350 for their approval and a received grade of an A.

# Software Requirements

> The following section describes all of the requirements for ColCalendar18 as well as which Test Cases are linked to each requirement. There is a Functional Requirements sub-section that lists all of the functional requirements and relevant test cases for the application. Following is a Non-Functional Requirements sub-section that lists all of the non-functional requirements and the relevant test cases for the application. All of the requirements for both sub-sections are listed with a high-level description of their use-cases.

## Functional Requirements

### User-Created Categories

| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR1 | The application shall allow for the user to create course categories with credit hours that contain assignment objects as described below. | TC1, TC2, TC3, TC4, TC5, TC6, TC7 |
| FR2 | The application shall allow for the user to create assignments with Point Value and Weighting for each course category. | TC2, TC3, TC4, TC5, TC6, TC7 |
| FR3 | The application shall allow for the user to create events with Event Name, Description, and Date of Event. |  |
| FR4 | The application shall save new courses when added by the user and validated. |  |
| FR5 | The application shall save new events when added by the user. |  |
| FR6 | The application shall save new assignments when added by the user and validated. |  |


### User Input: Created Categories
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR7 | The application shall have the capability to notify the user when an assignment is within 48 hours of completion. | TC6 |
| FR8 | The application shall load all assignments from persistent memory on application startup. |  |
| FR9 | The application shall correctly distribute each loaded assignment to the proper course. |  |
| FR10 | The application shall load all events from persistent memory on application startup. |  |
| FR11 | The application shall take into account leap year to correctly display dates. |  |


### ColCalendar18 Display
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR13 | The application shall display a calendar on the home screen of the application. |  |
| FR14 | The application shall display events happening on the selected day on the front page calendar. |  |
| FR15 | The application shall display assignments happening on the selected day on the front page calendar. |  |
| FR16 | The application shall display Assignment information for each Course when selected by the user. |  |
| FR17 | The application shall display all of the user-created course categories.



## Non-Functional Requirements

### Persistent Memory
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR1 | The application shall load from persistent memory without impacting startup performance. |  |
| NFR2 | The application shall load from persistent memory without data loss between multiple application instances. |  |
| NFR3 | The application shall load from persistent memory without requiring extra permissions by the user. |  |
| NFR4 | The application shall not require extra permissions to save to persistent memory. |  |
| NFR5 | The application shall never require input from the user to save or load data. |  |


### Display Requirements
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR6 | The application shall calculate the optimal order of completion for each assignment per course. |  |
| NFR7 | The application shall display the assignments in order of optimal completion on the selected course page. |  |
| NFR8 | The application shall display assignments in a manner that is easy to be understood by the user at a glance. |  |
| NFR9 | The application shall have a graphical user interface that is easily navigated by the user. |  |
| NFR10 | The application shall have a graphical user interface that is navigatable without application crashing. |  |


### Application Stability
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR11 | The application shall be lightweight, with minimal usage of device computing resources. |  |
| NFR12 | The application shall reload from a dormant state providing a seamless user experience. |  |
| NFR13 | The application shall run alongside other applications without any interruption in performance. |  |
| NFR14 | The application shall run without major bugs or crashing issues |  |
| NFR15 | The application shall save to persistent memory without affecting the performance of the application or the user experience thereof. |  |


# Test Specification

> The following section has all of the test cases for the application. Each test case has a description as well as all of the required steps, inputs, and outputs to complete each test case. Each test is linked to the relevant requirement mentioned above.


## Unit Tests

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC1 | Course Name Validation | Open The Application, Navigate to MANAGE COLCALENDAR, Input in Course Name field, Press +1  | QWERTY | Error Message Stating: "You forgot to fill out one of the forms" | Error Message Stating: "You forgot to fill out one of the forms" | PASS | FR1 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC2 | Course Credit Hours Validation | Open The Application, Navigate to MANAGE COLCALENDAR, Input in Course Credit Hours field, Press +1  | 100 | Error Message Stating: "You forgot to fill out one of the forms" | Error Message Stating: "You forgot to fill out one of the forms" | PASS | FR1 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC3 | Assignment Name Validation | Open The Application, Ensure that a dummy Course has been created for testing, Navigate to MANAGE COLCALENDAR, Navigate to Assignments, Select the dummy Course, enter information for all fields except for name, Press +1  | 100, .1 | Error Message Stating: "You forgot to fill out one of the forms" | Error Message Stating: "You forgot to fill out one of the forms" | PASS | FR1, FR2 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC4 | Assignment Course Created Validation | On a fresh install, Open The Application, Navigate to MANAGE COLCALENDAR, Navigate to Assignments, Enter information for all fields and select a date, Press +1 | Ass Name, 100, .1, Date 1 Greater Than Today | Error message stating: "Add a course first!" | Error message stating: "Add a course first!" | PASS | FR1, FR2 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC5 | Assignment Weighting Greater Than 1 Required | Open The Application, Ensure that a dummy Course has been created for testing, Navigate to MANAGE COLCALENDAR, Navigate to Assignments, Select the dummy Course, enter information in all fields, Press +1 | Ass Name 2, 100, 10, Date 1 Greater Than Today | Error Message Stating: "Weighting Must Be Less Than 1" | Error Message Stating: "Weighting Must Be Less Than 1" | PASS | FR1,FR2 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC6 | Assignment Date Validation | Open The Application, Ensure that a dummy Course has been created for testing, Navigate to MANAGE COLCALENDAR, Navigate to Assignments, Select the dummy Course, enter information in all fields, Press +1 | Ass Name 3, 100, 10, Same Date as Current Date | Error Message Stating: "Selected Date Must Be Different From Today's Date" | Error Message Stating: "Selected Date Must Be Different From Today's Date" | PASS | FR1, FR2 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC7 | Assignment Points Validation | Open The Application, Ensure that a dummy Course has been created for testing, Navigate to MANAGE COLCALENDAR, Navigate to Assignments, Select the dummy Course, enter information for all fields except for name, Press +1  | QWERTY, .1 | Error Message Stating: "You forgot to fill out one of the forms" | Error Message Stating: "You forgot to fill out one of the forms" | PASS | FR1, FR2 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC8 | Event Name Validation | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC9 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC10 | <TC1 description> | <steps to execute TC1> | <input values to this test case> | <expected output as a result of test case> | <actual output of test case> | <did it pass or fail?> | <requirement IDs this test case is linked to> |
