# Overview

> The purpose of this document is to present a detailed description of the ColCalendar18. It esplains the purpose and features of the calendar, the interfaces thereof, what the calendar will do, the constraints under which it must operate and how the calendar will react to external stimuli, such as user input. This document is intended for both the the developers of the calendar and will be proposed to mrdoktorprofessor and the class of CIS 350 for their approval and an A.

# Functional Requirements

1. Create Initial Classifications
	1. The application shall allow for the user to input class categories that are static per semester.
	1. The application shall allow for the user to input grading scale sub-categories per class category as described above.
	1. The application shall create color coding for each class when input by the user.
1. User Input: Assignments
	1. The application shall allow for the user to input assignments with due date and add to the relevant class category and grading scale sub-category.
	1. The application shall create assignments that can be modified or deleted.
	1. The application shall allow for the user to input an estimated number of hours the assignement will take.
	1. The application shall allow for the user to seemlessly edit existing assignements in the case a date is changed.
	1. The application shall allow for the user to input descriptions for assignments.
1. User Input: Events
	1. The application shall allow for the event of leap year and day within the calendar.
	1. The application shall allow users to input major institutional events such as breaks, career fairs, etc.
	1. The application shall allow users to edit major institutional events such as breaks, career fairs, etc.
	1. The application shall allow users to delete major institutional events such as breaks, career fairs, etc.
1. Calendar Background Process
	1. The application shall allow the user to set push notifications for assignments coming up..
	1. The application shall run in the background when closed.
1. Generate To-DO List
	1. The application shall designate certain priorities per assignment.
1. Grade Calculations
	1. The application's assignment grades shall be calculated from completed assignments over time.
	1. The application shall estimate impact of certain assignments on grades per class.
	
# Non-Functional Requirements

1. Generate To-DO List
	1. The application shall show the importance of each assignment through a system of darker shading and coloring on an assignment basis.
	1. The application shall display the assignments on the calendar in a concise and easy-to-read manner.
	1. 
1. Graphical User Interface
	1. The application shall have a modern user-interface design that is scalable for a large range of device sizes.
	1. The application shall be easy to navigate for a simple user experience.
1. Application Stability
	1. The application shall be reliable and without data loss or major crash causing errors.
	1. The application shall be lightweight with minimal usage of device computing resources.
	1. The application shall have a save state so that if the app does crash the user does not lose data.
	1. The application shall be able to run alongside other applications without causing any interruption in performance.
	1. The application shall be able to run on Android development software.
	1. The application shall be kept free of bugs.
	1. The application's files shall not be editable by the user.
1. Calendar Background Process
	1. The application shall include major  US holidays on the calendar GUI.
1. Background Process
	1. The application shall automatically append bug reports to a file in the cloud.
	