# Overview

> The purpose of this document is to present a detailed account of the features and test cases for the Android application, ColCalendar18. This document explains the purpose and features of the calendar, the interfaces thereof, what the calendar will do, and the constaints under which it must operate. Furthermore, this document details how the calendar will react to external stimuli such as End-User input. This document further details the test cases by which the application has been rigorously tested on. This document is intended for all stakeholders of the calendar. Stakeholders include, but are not limited to, the investors, the developers, and the quality assurance testing team. This document and application are to be proposed to mrdoktorprofessor and the 1-PM Morning class of CIS350 for their approval and a received grade of an A.

# Software Requirements

> The following section describes all of the requirements for ColCalendar18 as well as which Test Cases are linked to each requirement. There is a Functional Requirements sub-section that lists all of the functional requirements and relevant test cases for the application. Following is a Non-Functional Requirements sub-section that lists all of the non-functional requirements and the relevant test cases for the application. All of the requirements for both sub-sections are listed with a high-level description of their use-cases.

## Functional Requirements

### <User-Created Categories>
</br>
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR1 | The application shall allow for the user to create course categories that are static per semester. | TC1 |
| FR2 | The application shall allow for the user to create assignments for each course category. | TC2 |
| FR3 | The application shall allow for the user to create events with Event Name, Description, and Date of Event. | TC1,TC2 |
| … | … | … |

### <User Input: Assignments>
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR4 | The application shall have the capability to notify the user when an assignment is within 48 hours of completion. | TC1 |
| FR5 | The application shall load all assignments from persistent memory on application startup. | TC2 |
| FR6 | The application shall correctly distribute each loaded assignment to the proper course. | TC1,TC2 |


### <Persistent Memory>
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR7 | The application shall save new courses when added by the user and validated. | TC1 |
| FR8 | The application shall save new events when added by the user. | TC2 |
| FR9 | The application shall save new assignments when added by the user and validated. | TC1,TC2 |


### <User Input: Events>
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR10 | The application shall load all events from persistent memory on application startup. | TC1 |
| FR11 | The application shall take into account leap year to correctly display dates. | TC2 |
| FR12 | The application shall include all major U.S. Federal holidays automatically. | TC1,TC2 |
| … | … | … |

### <Calendar Display>
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| FR13 | The application shall display events happening on the selected day on the front page calendar. | TC1 |
| FR14 | The application shall display assignments happening on the selected day on the front page calendar. | TC2 |
| FR15 | The application shall display Assignment information for each Course when selected by the user. | TC1,TC2 |
| … | … | … |

## Non-Functional Requirements

### <Loading>
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR1 | The application shall load from persistent memory without impacting startup performance. | TC4 |
| NFR2 | The application shall load from persistent memory without data loss between multiple application instances. | TBD |
| NFR3 | The application shall load from persistent memory without requiring extra permissions by the user. | TC6 |
| … | … | … |

### <Generate To-Do List>
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR4 | The application shall calculate the optimal order of completion for each assignment per course. | TC4 |
| NFR5 | The application shall display the assignments in order of optimal completion on the selected course page. | TBD |
| NFR6 | The application shall display assignments in a manner that is easy to be understood by the user at a glance. | TC6 |
| … | … | … |

### <Graphical User Interface>
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR7 | The application shall have a graphical user interface that is easily navigated by the user. | TC4 |
| NFR8 | The application shall take user input on a range of different device models. | TBD |
| NFR9 | The application shall have a graphical user interface that is navigatable without application crashing. | TC6 |
| … | … | … |

### <Saving>
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR10 | The application shall not require extra permissions to save to persistent memory. | TC4 |
| NFR11 | The application shall save to persistent memory without affecting the performance of the application or the user experience thereof. | TBD |
| NFR12 | The application shall never require input from the user to save or load data. | TC6 |
| … | … | … |

### <Application Stability>
| ID | Requirement | Test Cases |
| :-------------: | :----------: | :----------: |
| NFR13 | The application shall be lightweight, with minimal usage of device computing resources. | TC4 |
| NFR14 | The application shall reload from a dormant state providing a seamless user experience. | TBD |
| NFR15 | The application shall run alongside other applications without any interruption in performance | TC6 |
| … | … | … |

# Test Specification

> The following section has all of the test cases for the application. Each test case has a description as well as all of the required steps, inputs, and outputs to complete each test case. Each test is linked to the relevant requirement mentioned above.