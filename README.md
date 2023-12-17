# Test task:

## User Story 1: Test Task: Remove Duplicates.

As a recluter, I want to verify the technical knowledge of this candidate, so it's necessary that the candidate complete this test task.

**Input:** Given a simple String: "AABBCCD112233".

**Output:** Return a new String, that will not contain any duplicates. Example "ABCD123"

**Acceptance criteria:**

The code should be clean, readable, and optimized.
Also, we expect to see test coverage with different test cases.

## **Proposed technical solution**

**Language**: Java, version: 11.

**Build automation tool:** Maven

Dependencies:

* Lombok: It helps reduce boilerplate and keeps the code clean and consistent.
* Slf4j: It helps to log in a simple way.
* jUnit and Mockito: are good knowledge testing frameworks.

**Architecture**

This is a simple testing task; however, it uses a Ports and Adapters approach to architecture, defining the Domain, the Service (Business Logic), the application (Handler), and the infrastructure.

It is easy to create new implementations to obtain data from other sources (repositories, APIs, etc.).

Changes are encapsulated in the specific implementations, avoiding possible coupling in the code.
