# NFS_JAVA_C2_2026 | Full-Stack Development with Java, React & MongoDB



## Programme Description



This 20-day programme is designed to help participants build a complete full-stack web application using Java, Spring Boot, React, and MongoDB.



The programme takes learners from programming and web fundamentals to backend API development, frontend interface design, database modelling, authentication, testing, performance improvement, and final capstone presentation.



Throughout the programme, participants will work on practical exercises and gradually build a small but production-like web application. The final outcome is a working capstone project that demonstrates the use of a React frontend, Spring Boot backend, MongoDB database, secure authentication, API documentation, testing practices, and deployment-readiness basics.



AI tools such as Gemini are used as learning accelerators to help scaffold examples, suggest refactoring ideas, draft tests, generate sample data, and support MongoDB query or aggregation design. However, participants are expected to review, verify, understand, and take ownership of all generated code.



---



## Programme Duration



* Duration: 20 training days

* Daily Duration: 7 hours per day

* Total Training Hours: 140 hours

* Mode: Instructor-led training with guided labs, team build activities, review sessions, quizzes, and capstone development



---



## Programme Objectives



By the end of this programme, participants will be able to:



* Understand web fundamentals, HTTP, REST, and JSON.

* Write basic to intermediate Java and JavaScript code.

* Build REST APIs using Spring Boot.

* Apply validation, authentication, authorisation, and error-handling practices.

* Model data effectively using MongoDB.

* Use MongoDB indexes, queries, pagination, and aggregation pipelines.

* Build accessible React user interfaces with routing, forms, state, and data fetching.

* Apply testing practices for backend and frontend development.

* Use AI coding assistants responsibly for learning, refactoring, testing, and documentation.

* Design, build, document, and present a full-stack capstone project.



---





---



## AI-Assisted Learning Guidelines



Participants may use AI tools to:



* Generate README drafts and documentation sections.

* Create API call examples and JSON payload samples.

* Suggest method signatures and edge cases.

* Propose refactoring options.

* Draft test scenarios for backend and frontend features.

* Suggest MongoDB document structures, queries, indexes, and aggregation pipelines.

* Improve demo scripts and presentation notes.



Participants must always review, verify, test, and understand any AI-generated output. No passwords, API keys, tokens, private keys, or confidential data should be placed into AI prompts.

---

## Day 3 Exercise 02 - Interface and Repository Storage Practice

### Reflection

**Q: Why is InMemoryCourseRepository temporary storage?**

A: InMemoryCourseRepository uses a LinkedHashMap to store courses in memory (RAM). This means:
- Data is only stored while the application is running
- When the application stops, all data is lost
- It doesn't persist to a database or file system
- It's intended as a placeholder for demonstration and testing purposes

**Q: What would probably replace it later when we use MongoDB?**

A: We would create a `MongoDBCourseRepository` class that implements the same `CourseRepository` interface. This class would:
- Connect to a MongoDB database instead of using in-memory storage
- Store documents in MongoDB collections permanently
- Provide data persistence across application restarts
- Use the same interface methods (save, findById, findAll, deleteById, existsById) so that the rest of the application code doesn't need to change

This demonstrates the power of interfaces: by using the `CourseRepository` interface type, we can swap implementations without changing the client code that uses them.

---

## Day 3 Exercise 01 - Build and Trace the Code Flow

### Reflection

**Q: When getCourseById("C004") is called, which file does the request go to first, second, and third?**

A: The request flow follows this order:
1. **First:** `CodeFlowPractice.java` - The demo class calls the method
2. **Second:** `CourseService.java` - The service receives the request and calls the repository
3. **Third:** `InMemoryCourseRepository.java` - The repository retrieves the course from the LinkedHashMap

This demonstrates the layered architecture pattern where each layer has a specific responsibility, and the demo class doesn't directly access the repository.

---

## Day 3 Exercise 03 - Exception Practice with CourseService

### Reflection

**Q: Why is throwing CourseNotFoundException better than printing inside CourseService?**

A: Throwing an exception is better because:
- **Flexibility:** Console app, web API, and frontend app may all display the same error differently
- **Separation of concerns:** The service should report the error, not decide how to display it
- **Composability:** Different calling code can handle the same exception in different ways
- **Testing:** It's easier to test error scenarios when exceptions are thrown
- **Logging and monitoring:** Exceptions can be logged and monitored more effectively
- **Code reusability:** If the service printed directly to console, it couldn't be used in a web application or mobile app

---

## Day 3 Exercise 04 - Object Relationships and Composition

### Reflection

**Q: Why is CourseOffering a better design than putting start date, end date, and capacity directly inside Course?**

A: Separating CourseOffering from Course is better because:
- **Reusability:** A single course can have multiple offerings with different dates, times, and capacities
- **Flexibility:** Different offerings can be scheduled for different audiences (Beginner/Weekend/Online sessions)
- **Maintenance:** Changes to offering logic don't affect the core course definition
- **Real-world mapping:** In the real world, courses and offerings are distinct entities
- **Single Responsibility:** Course defines what is taught; CourseOffering defines when and how it's delivered
- **Scalability:** As the business grows, offerings might have additional properties (instructors, venues, etc.) that don't apply to courses

---

## Day 3 Exercise 05 - Loop Search Then Stream Search

### Reflection

**Q: Which version is easier to understand: loop or stream? Why?**

A: The loop version is generally easier to understand for beginners because:
- It's explicit and imperative: "Do this, then do that"
- Each step is clearly visible in the code
- It's similar to how people think about algorithms
- Debugging is straightforward with breakpoints

The stream version is more powerful for complex scenarios and becomes easier with practice because:
- It's more concise and expressive
- It separates "what to do" (filter) from "how to do it" (implementation)
- It's more functional and declarative in style

**Q: What does filter() do in a stream?**

A: `filter()` takes a predicate (condition) and returns only the elements from the stream that satisfy the condition. For example:
- `.filter(course -> course.getLevel().equalsIgnoreCase("Beginner"))` - keeps only Beginner courses
- Elements that don't match the condition are excluded from the result

---

## Day 3 Exercise 06 - Build StudentService Using the Same Pattern as CourseService

### Reflection

**Q: How is StudentService similar to CourseService?**

A: StudentService and CourseService are similar because:
- Both implement the service layer pattern with repository dependency injection
- Both have `create/register`, `getById`, `getAll`, and `search` methods
- Both handle validation and throw appropriate exceptions
- Both use the same repository-service architecture
- Both support both loop and stream versions of search methods
- This demonstrates that the service/repository pattern is a general architectural pattern applicable to many entities

**Q: Which file stores students temporarily while the program is running?**

A: `InMemoryStudentRepository.java` stores students temporarily using a LinkedHashMap:
- Data exists only in RAM while the application runs
- All data is lost when the application shuts down
- This is a placeholder for when we switch to MongoDB later
- The same pattern applies to courses with InMemoryCourseRepository

