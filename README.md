&nbsp;Workforce Management API



This project is a task assignment and tracking system for managing workforce activities, including dynamic task assignment, task reassignment, priority handling, and task activity tracking with in-memory or database support.



Features



Bug Fixes

\- \*\*Bug 1\*\*: Fixed task reassignment duplication – older tasks are now marked as `CANCELLED`.

\- \*\*Bug 2\*\*: Cancelled tasks are excluded from date-based task queries.



&nbsp;New Features

\- \*\*Smart Date Filtering\*\*: Fetches all tasks starting in the date range \*\*plus\*\* ongoing tasks started earlier.

\- \*\*Task Prioritization\*\*: Set priority (`LOW`, `MEDIUM`, `HIGH`) and filter tasks by it.

\- \*\*Task Comments \& Activity Logs\*\*:

&nbsp; - Add comments to tasks.

&nbsp; - View full history of activities (assignment, priority changes, etc.)



---

&nbsp;API Endpoints



&nbsp;Task Management



| Method | Endpoint                        | Description                         |

|--------|----------------------------------|-------------------------------------|

| GET    | `/api/tasks/{id}`               | Get task by ID                      |

| GET    | `/api/tasks/date?from\&to`       | Get tasks in date range             |

| POST   | `/api/tasks/assign-by-ref`      | Assign tasks by reference           |

| PUT    | `/api/tasks/{id}/priority`      | Change priority of task             |

| GET    | `/api/tasks/priority/{priority}`| Get tasks by priority               |



\### 💬 Comments \& History



| Method | Endpoint                        | Description                         |

|--------|----------------------------------|-------------------------------------|

| POST   | `/api/comments/add`             | Add a comment to a task             |

| GET    | `/api/comments/task/{taskId}`   | Get all comments of a task          |

| GET    | `/api/tasks/{id}`               | Includes comments \& activity logs   |



---



&nbsp;Technologies Used



\- Java 17

\- Spring Boot

\- Spring Web

\- H2 / MySQL

\- Lombok

\- Postman (for API testing)



---



&nbsp;Running the App



```bash

./mvnw spring-boot:run





---





\##  Bug Fixes

\###  Bug 1: Task Re-assignment Creates Duplicates



\*\*Issue\*\*: When reassigning tasks by reference, old tasks remained active, causing duplicates.



\*\*Fix\*\*: Updated `assignByReference()` to:

\- Cancel previous tasks (`status = CANCELLED`)

\- Only assign one active task to the new assignee.



\*\*Before\*\*:

\- Multiple tasks with same `referenceId`, `taskType`, and active status.



\*\*After\*\*:

\- Only one active task for the assignee, others cancelled.



---



\### Bug 2: Cancelled Tasks Clutter the View



\*\*Issue\*\*: Date-based task fetch returned cancelled tasks.



\*\*Fix\*\*: Modified date filtering logic to exclude tasks with `status = CANCELLED`.



---



\## ✨ New Features



\### 1️⃣ Smart Daily Task View



\- Endpoint: `GET /api/tasks/date?from=YYYY-MM-DD\&to=YYYY-MM-DD`

\- Returns:

&nbsp; - Tasks started within range

&nbsp; - \*\*+\*\* Open tasks that started earlier



---



\### 2️⃣ Task Prioritization



\- Enum `Priority`: `LOW`, `MEDIUM`, `HIGH`

\- Set priority:

&nbsp; - `PUT /api/tasks/{id}/priority`

\- Filter by priority:

&nbsp; - `GET /api/tasks/priority/HIGH`



---



\### 3️⃣ Task Comments \& History



\- Add comment: `POST /api/comments/add`

\- View task comments: `GET /api/comments/task/{taskId}`

\- View task activity:

&nbsp; - Automatically logs:

&nbsp;   - Creation

&nbsp;   - Assignment

&nbsp;   - Priority changes

\- Activity and comments included in `GET /api/tasks/{id}`



---



\##  Demonstration



Screenshots, postman test runs, and logs showing:



\- Fixes working as expected

\-  Features working end-to-end

\-  Test case results (if applicable)



---



&nbsp;Files Submitted



\- `src/` (source code)

\- `README.md` (project overview)

\- `submission.md` (this report)

\- `postman\_collection.json` (Postman test collection)



---



\##  Resources



\- GitHub: \[https://github.com/MohanDeredla](https://github.com/MohanDeredla)





