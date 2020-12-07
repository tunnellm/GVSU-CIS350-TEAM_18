# Overview

> The purpose of this document is to present a detailed account of the features and test cases for the Android application, ColCalendar18. This document explains the purpose and features of the calendar, the interfaces thereof, what the calendar will do, and the constaints under which it must operate. Furthermore, this document details how the calendar will react to external stimuli such as End-User input. This document further details the test cases by which the application has been rigorously tested on. This document is intended for all stakeholders of the calendar. Stakeholders include, but are not limited to, the investors, the developers, and the quality assurance testing team. This document and application are to be proposed to mrdoktorprofessor and the 1-PM Morning class of CIS350 for their approval and a received grade of an A.

# Software Requirements

> The following section describes all of the requirements for ColCalendar18 as well as which Test Cases are linked to each requirement. There is a Functional Requirements sub-section that lists all of the functional requirements and relevant test cases for the application. Following is a Non-Functional Requirements sub-section that lists all of the non-functional requirements and the relevant test cases for the application. All of the requirements for both sub-sections are listed with a high-level description of their use-cases.

## Functional Requirements

### User-Created Categories

| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR1 | The application shall allow for the user to create course categories with credit hours that contain assignment objects as described below. |  |
| FR2 | The application shall allow for the user to create assignments with Point Value and Weighting for each course category. |  |
| FR3 | The application shall allow for the user to create events with Event Name, Description, and Date of Event. |  |
| FR4 | The application shall save new courses when added by the user and validated. | |
| FR5 | The application shall save new events when added by the user. |  |
| FR6 | The application shall save new assignments when added by the user and validated. |  |


### User Input: Created Categories
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR7 | The application shall have the capability to notify the user when an assignment is within 48 hours of completion. | |
| FR8 | The application shall load all assignments from persistent memory on application startup. |  |
| FR9 | The application shall correctly distribute each loaded assignment to the proper course. |  |
| FR10 | The application shall load all events from persistent memory on application startup. |  |
| FR11 | The application shall take into account leap year to correctly display dates. |  |


### ColCalendar18 Display
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR13 | The application shall display a calendar on the home screen of the application. |  |
| FR14 | The application shall display events happening on the selected day on the front page calendar. | TC9 |
| FR15 | The application shall display assignments happening on the selected day on the front page calendar. | TC2, TC3, TC4, TC5, TC6, TC7 |
| FR16 | The application shall display Assignment information for each Course when selected by the user. | TC2, TC3, TC4, TC5, TC6, TC7 |
| FR17 | The application shall display all of the user-created course categories. | TC1, TC2, TC3, TC4, TC5, TC6, TC7, TC13 |



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
| NFR6 | The application shall calculate the optimal order of completion for each assignment per course. | TC2, TC3, TC4, TC5, TC6, TC7 |
| NFR7 | The application shall display the assignments in order of optimal completion on the selected course page. | TC2, TC3, TC4, TC5, TC6, TC7 |
| NFR8 | The application shall display assignments in a manner that is easy to be understood by the user at a glance. | TC2, TC3, TC4, TC5, TC6, TC7 |
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
| TC3 | Assignment Name Validation | Open The Application, Ensure that a dummy Course has been created for testing, Navigate to MANAGE COLCALENDAR, Navigate to ASSIGNMENTS, Select the dummy Course, enter information for all fields except for name, Press +1  | 100, .1 | Error Message Stating: "You forgot to fill out one of the forms" | Error Message Stating: "You forgot to fill out one of the forms" | PASS | FR1, FR2 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC4 | Assignment Course Created Validation | On a fresh install, Open The Application, Navigate to MANAGE COLCALENDAR, Navigate to ASSIGNMENTS, Enter information for all fields and select a date, Press +1 | Ass Name, 100, .1, Date 1 Greater Than Today | Error message stating: "Add a course first!" | Error message stating: "Add a course first!" | PASS | FR1, FR2 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC5 | Assignment Weighting Greater Than 1 Required | Open The Application, Ensure that a dummy Course has been created for testing, Navigate to MANAGE COLCALENDAR, Navigate to ASSIGNMENTS, Select the dummy Course, enter information in all fields, Press +1 | Ass Name 2, 100, 10, Date 1 Greater Than Today | Error Message Stating: "Weighting Must Be Less Than 1" | Error Message Stating: "Weighting Must Be Less Than 1" | PASS | FR1,FR2 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC6 | Assignment Date Validation | Open The Application, Ensure that a dummy Course has been created for testing, Navigate to MANAGE COLCALENDAR, Navigate to ASSIGNMENTS, Select the dummy Course, enter information in all fields, Press +1 | Ass Name 3, 100, 10, Same Date as Current Date | Error Message Stating: "Selected Date Must Be Different From Today's Date" | Error Message Stating: "Selected Date Must Be Different From Today's Date" | PASS | FR1, FR2 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC7 | Assignment Points Validation | Open The Application, Ensure that a dummy Course has been created for testing, Navigate to MANAGE COLCALENDAR, Navigate to ASSIGNMENTS, Select the dummy Course, enter information for all fields except for name, Press +1  | QWERTY, .1 | Error Message Stating: "You forgot to fill out one of the forms" | Error Message Stating: "You forgot to fill out one of the forms" | PASS | FR1, FR2 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC8 | Event Name Validation | Open The Application, Navigate to MANAGE COLCALENDAR, Navigates to EVENTS, Input Information in the Description Field | This Is An Event Description | Error Message Stating: "You forgot to fill out one of the forms" | Error Message Stating: "You forgot to fill out one of the forms" | PASS | FR3 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC9 | Event Description Validation | Open The Application, Navigate to MANAGE COLCALENDAR, Navigates to EVENTS, Input Information in the Name Field | This Is An Event Name | Error Message Stating: "You forgot to fill out one of the forms | Error Message Stating: "You forgot to fill out one of the forms | PASS | FR3 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC10 | Courses No Input Validation | Open The Application, Navigate to MANAGE COLCALENDAR, Press +1 |  | Error Message Stating: "You forgot to fill out one of the forms | Error Message Stating: "You forgot to fill out one of the forms | PASS | FR1 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC11 | Assignments No Input Validation | On A Fresh Install, Open The Application, Navigate to MANAGE COLCALENDAR, Navigate to ASSIGNMENTS, Press +1 |  | Error Message Stating: "You forgot to fill out one of the forms | Error Message Stating: "You forgot to fill out one of the forms | PASS | FR1, FR2 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC12 | Events No Input Validation | Open The Application, Navigate to MANAGE COLCALENDAR, Navigate to EVENTS Press +1 |  | Error Message Stating: "You forgot to fill out one of the forms | Error Message Stating: "You forgot to fill out one of the forms | PASS | FR3 |

## Integration tests

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC13 | User-Creation of Courses | Open The Application, Navigate to MANAGE COLCALENDAR, Enter Information For All Fields, Press +1 | Beep Boop, 5 | Message Stating: "Successfully Added Beep Boop" | Message Stating: "Successfully Added Beep Boop" | PASS | FR1, FR4, FR17, NFR4, NFR5 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC14 | User-Creation of Assignment | Open The Application, Ensure that at least one dummy Course (Made for testing purposes) has been made, Navigate to MANAGE COLCALENDAR, Navigate to ASSIGNMENTS, Enter Information For All Fields, Press +1 | Dummy Course Name, Ass 3, 100, .2, Date 1 Greater than Today's date | Message Stating: "Successfully Added Assignment to {}" where {} is the name of the dummy course | Message Stating: "Successfully Added Bb" | PASS | FR1, FR2, FR6, NFR4, NFR5 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC15 | User-Creation of Event | Open The Application, Navigate to MANAGE COLCALENDAR, Navigate to EVENTS, Enter Information For All Fields, Press +1 | Event Name, Event Description | Message Stating: "Added Event Name\nEvent Description"  | Message Stating: "Added Event Name\nEvent Description" | PASS | FR3, FR5, FR11, NFR5 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC16 | Display Assignments in Order | Open The Application, Ensure that a dummy course and assignments have been made (course and assignments from previous tests count), Navigate to MANAGE COLCALENDAR, Select the course that was previously made | Press the name of the course | Message Stating: "Course Details\nName {1}\nCredits Hours:{2}\n\nAssignment Name{3}\nAssignment Weighting{4}, Points: {5}\nAssignment Due Date:{6} *n" Where {1} is the Course name, {2} is the Course Credit hours {3} is the Assignment name. {4} is the Assignment Weighting, {5} is the Assignment points, {6} is the Assignment Due Date and n is the last three fields repeated with information from the amount of Assignments instantiated in the Course   | Message Stating: "Course Details\nName:Bb\nCredit Hours:11\n\nAssignment Name: Ass 3\nAssignmentWeighting:0.1, Points:100.0\nAssignment Due Date: DECEMBER/8/2020\n\nAssignment Name:100\nAssignment Weighting: 0.1, Points: 100.0\nAssignment Due Date:DECEMBER/6/2021" | PASS | FR1, FR2, FR9, FR16, NFR6, NFR7, NFR9, NFR10 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC17 | Display User-Instantiated Classes | Open the application, ensure that dummy Courses, Assignments, and Events have been created on a date (Assignments, Courses, and Events from previous testing works), Click on a date that has an event or assignment, or both, created, and validate output. | Date Of Event And/or Assignment | There are multiple outputs that are valid, Valid Assignment Output: Assignment Name:{1}\nAssignment Weighting:{2}, Points:{3}\nAssignment Due Date:{4} Where {1} is the name of the Assignment Object, {2} is the Weighting of the Assignments, {3} is the TotalPoints of the Assignments and {4} is the Due Date of the Assignment -- Valid Events Output: Event:{1}\nDescription:{2} Where {1} is the name of the Event, {2} is the Description of the event. Valid No Output: No Events -- If there are no events, the last output will appear. On a date with an assignment and/or event, valid assignment and/or event will appear in-line. | Message Stating: "Assignment Name: Ass 3\nAssignment Weighting: 0.1, Points: 100.0\n Assignment Due Date: DECEMBER/8/2020\n\nEvent: Event Name\nDescription: Event Description" | PASS | FR10, FR11, FR13, FR14, FR15, NFR5, NFR9, NFR10 |

## System Tests

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC18 | Application Startup | Open The Application | Press Application ColCalendar18 from App Menu | The Application Opens Without Crashing | The Application Opened Without Crashing | PASS | NFR12, NFR14 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC19 | Automatic Saving of Courses | Open The Application, Navigate to MANAGE COLCALENDAR, Enter Information For All Fields, Press +1, Close Application Fully, Open The Application, Navigate to MANAGE COLCALENDAR | Beep Boop, 5 | Beep Boop is located in Courses Spinner | Beep Boop is located in Courses Spinner | PASS | FR4, FR9, FR17, NFR1, NFR2, NFR3, NFR4, NFR5, NFR9, NFR10, NFR14, NFR15  |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC20 | Automatic Saving of Assignment | Open The Application, Ensure that at least one dummy Course (Made for testing purposes) has been made, Navigate to MANAGE COLCALENDAR, Navigate to ASSIGNMENTS, Enter Information For All Fields, Press +1, Close the Application Fully, Open The Application, Navigate to MANAGE COLCALENDAR, Press The Dummy Course Name | Dummy Course Name, Ass 3, 100, .2, Date 1 Greater than Today's date | Message Containing: Assignment Name:Ass 3\nAssignment Weighting: 0.1, Points: 100, Assignment Due Date: {One Greater than Today’s Date}” | Message Containing: Assignment Name:Ass 3\nAssignment Weighting: 0.1, Points: 100, Assignment Due Date: DECEMBER/8/2020” | PASS | FR6, FR8, FR16, NFR1, NFR2, NFR3, NFR4, NFR5, NFR9, NFR10, NFR14, NFR15 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC21 | Automatic Saving of Event | Open The Application, Navigate to MANAGE COLCALENDAR, Navigate to EVENTS, Enter Information For All Fields, Press +1, Close The Application Fully, Open The Application, Press The Date of The Event Created | Event Name, Event Description | Message Containing: "Event: Event Name\nEvent Description: Event Description"  | Message Stating: "Event: Event Name\nEvent Description: Event Description" | PASS | FR3, FR5, FR10, FR11, FR13, FR14, FR15, NFR1, NFR2, NFR3, NFR4, NFR5, NFR9, NFR10, NFR14, NFR15 |

| ID  | Description | Steps | Input Values | Expected Output | Actual Output | Pass/Fail | Requirement Link |
| :-------------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: | :----------: |
| TC12 | Application Notification | Open The Application, Ensure that an Assignment has been created with a date within 48 of today, Press Turn On Notifications, Wait for Notification | Assignment (Created in Earlier Test or as described in TC13/TC14 if fresh install) | Notification With Text Stating: “ColCal\nYou have an assignment due soon”  | Notification With Text Stating: “ColCal\nYou have an assignment due soon” | PASS | FR10, FR11, FR13, FR14, NFR9, NFR10, NFR11, NFR14, NFR15 |

# Software Artifacts

> The following section contains all of the links for all of the software development artifacts that we have created throughout the semester. This shows the progress we have made as a team over the course of the semester.

* [software_requirements_specification_final.md](https://github.com/tunnellm/GVSU-CIS350-TEAM_18/blob/master/docs/software_requirements_specification_final.md)
* [software_requirements_specification.md (Midterm)](https://github.com/tunnellm/GVSU-CIS350-TEAM_18/blob/master/docs/software_requirements_specification.md)
* [Burn Down Chart 12-7-20.pdf](https://github.com/tunnellm/GVSU-CIS350-TEAM_18/blob/master/docs/Burn%20Down%20Chart%2012-7-20.pdf)
* [Extended UserAssingments Description.MD](https://github.com/tunnellm/GVSU-CIS350-TEAM_18/blob/master/artifacts/use_case_diagrams/Extend%20UserAssignments%20Description.MD)
* [UML_Use-Case_Create_Classifications.pdf](https://github.com/tunnellm/GVSU-CIS350-TEAM_18/blob/master/artifacts/use_case_diagrams/UML_Use-Case_Create_Classifications.pdf)
* [Use-Case 10-11.pdf](https://github.com/tunnellm/GVSU-CIS350-TEAM_18/blob/master/artifacts/use_case_diagrams/Use-Case%2010-11.pdf)
* [UserInputAssignments.pdf](https://github.com/tunnellm/GVSU-CIS350-TEAM_18/blob/master/artifacts/use_case_diagrams/UserInputAssignments.pdf)
* [Burn Down Chart 10-23-2020.pdf](https://github.com/tunnellm/GVSU-CIS350-TEAM_18/blob/master/docs/Burn%20Down%20Chart%2010-23-2020.pdf)
* [High-Level Tasks.md](https://github.com/tunnellm/GVSU-CIS350-TEAM_18/blob/master/docs/High-Level%20Tasks.md)
* [Midterm Slides.pdf](https://github.com/tunnellm/GVSU-CIS350-TEAM_18/blob/master/docs/Midterm%20Slides.pdf)
* [README.md](https://github.com/tunnellm/GVSU-CIS350-TEAM_18/blob/master/README.md)
* [proposal 10-04.md](https://github.com/tunnellm/GVSU-CIS350-TEAM_18/blob/master/docs/proposal%2010-04.md)
* [proposal 9-27.md](https://github.com/tunnellm/GVSU-CIS350-TEAM_18/blob/master/docs/proposal%209-27.md)
* []()
* []()
* []()