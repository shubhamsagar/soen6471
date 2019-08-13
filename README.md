# soen6471
Team-9-MVC

Customer relationship management (CRM) is an approach for managing all our company’s relationships and interactions with customers. The goal is, communicating well with the customers and meet their requires in order to gain their satisfaction. This system helps boost our connection to the customers and improve profitability

Software Requirements  
Requirements for software implementation:
1-	The system shall communicate with database MySQL to store models and data structures.
2-	The system backend will implement by Java 8 language, Maven for build tools and using ORM Hibernate for creating classes.
3-	The system interface will be designed by HTML CSS jsp and datatable.js 
4-	We will use technology of JAVA, Junit, to automate Testing process.
5-	User interfaces shall be consistent through whole system.
6-	User interfaces shall be compatible with any windows system and different resolution.
7-	There are no memory requirements.
Architecture Design Style
The MVC pattern divides the system into three interconnected parts each having a specific role in the application namely Models, Controllers and Views. This provides a clear separation in the development process and helps in the parallelization of the development process.
Also, this gives the agility for the project to be started small and keep on building upon it. Making it very suitable for agile and scrum development methodologies. 
The models act as a dynamic database of the system, representing an object and is independent of the user interface. It can also have the logic that is used to notify the controller of any update in the objects. 
The view is responsible for rendering the data which is obtained from the model or capturing the input from the user and rendering models in the required format. 
The controller communicates with both the model and the view, it controls the flow of data into the models and also updates the views with the change in data.
MVC states that there should be a clear separation between the model, view and the controller. The proposed system is divided into three different layers that follow the MVC architecture:
1-	Model: The project consists of various identified objects like the customer representative, the client, tickets, telephone plans. Each object work as an independent model. These are the models that hold the details which would be required to update the views.

2-	View: The project uses different screens to interact with the customer representative.

2-1-	Login View: a login panel for the customer representatives.
2-2-	Navigation View: a navigation view for customer representative to navigate between managing user and tickets.
2-3-	Tickets list view: a view listing all the tickets
2-4-	User search view: a view to search a user.
2-5-	User management view: a view for managing user details and plans.

3-	Controller: The controllers will help the models and views communicate with each other. For that reason, the project contains controllers to be able to fulfill the required functionality, for example:

3-1-	Ticket Controller
3-2-	Customer Representative controller
3-3-	Client/User Controller

Following the current trend of MVC pattern we have divided the project into further layer including:

4-	Service Layer: Providing the major separation between the data and the controllers implementing all the business logic that will be required by the project.

5-	DAO layer: DAO layer works as the buffer between the database and the project handling all the database operations.
In terms of technologies, we have used the Spring MVC framework to develop this project. Spring MVC is a framework which follows the MVC pattern strictly and enforces the theory of MVC in the development process.
With the help of Dependency Injection which is inherent in spring, we have also created a loosely coupled system which gives us some freedom and parallelization that is one of the prime merits of MVC.
