    Build and Run Instructions:
    1.Make sure you have Docker installed and running on your system. You can check this by running the command 'docker --version' in your command prompt or terminal.

    2.Download the MongoDB image for Docker. Use the official MongoDB image, which typically has the name 'mongo'. You can do this by running the command 'docker pull mongo'.

    3.Ensure that your project has the necessary Docker configuration files, such as 'Dockerfile' and 'compose.yaml'. These files define the Docker container settings for your application and MongoDB.

    4.Open a command prompt or terminal in the root directory of your project.

    5.Run the command 'docker-compose -f compose.yaml build' to build the Docker images for your application and MongoDB. This command reads the Docker configuration files and builds the corresponding images.

    6.After a successful build, run the command 'docker-compose -f compose.yaml up' to start the containers. This command creates and starts the Docker containers for your application and MongoDB.

    7.Once the containers are running, your application will be accessible at 'http://localhost:8080'. You can open this URL in a web browser to check if your application is working.

    8.MongoDB will also be accessible at 'mongodb://localhost:27017'. You can use this URL to connect to MongoDB from your application or external database management tools.


    During the implementation of the project, I made several important decisions and incorporated additional components to improve the overall design and functionality. Here are the details:

    1.Data Transfer Objects (DTOs): I decided to use DTOs to transfer data between the controllers and services. DTOs provide a structured way to exchange data without exposing the internal domain objects. This approach helps decouple the API from the internal data model and provides flexibility in defining the data to be transferred.

    2.Mapper: To facilitate the conversion between DTOs and domain objects, I introduced a mapper component. The mapper is responsible for mapping data between different representations, such as converting DTOs to domain objects and vice versa. This separation of concerns helps maintain a clean architecture and simplifies the transformation process.

    3.Logger: I added a logging feature to the project to facilitate tracking and debugging. By incorporating a logger, it becomes easier to monitor the application's behavior, trace important actions, and identify potential issues. Logging plays a crucial role in troubleshooting and provides valuable insights into the application's execution flow.

    4.Custom Exception: To handle specific exceptional situations, I created a custom exception. This allows for more granular and meaningful error handling by providing detailed error messages, specific error codes, and additional contextual information. Custom exceptions help improve the clarity of error reporting and make it easier to address exceptional cases within the application.

    By implementing these components and making these decisions, the project's structure and maintainability have been significantly enhanced. The use of DTOs and a mapper promotes loose coupling and separates concerns, while the logging feature facilitates effective debugging and monitoring. Additionally, the custom exception provides a more tailored approach to handling errors and enhances error reporting within the application. These practices align with clean code principles and contribute to a more robust and maintainable codebase.

    
    Here's a detailed explanation of how clean code principles were applied in my project:

    1.Meaningful Naming: Throughout the project, I prioritized using descriptive and meaningful names for variables, methods, classes, and other components. This improves code readability and makes it easier for other developers to understand the purpose and functionality of different parts of the codebase.

    2.Modularity and Single Responsibility: I followed the principle of single responsibility, ensuring that each class and method has a clear and specific purpose. By keeping modules small and focused, the code becomes more maintainable, easier to understand, and less prone to bugs.

    3.Code Reusability: I strived to write reusable code by encapsulating common functionalities into separate methods or utility classes. This reduces code duplication and improves maintainability by promoting the use of modular and reusable components.

    4.Consistent Formatting: I maintained consistent code formatting throughout the project. This includes indentation, spacing, and the placement of braces. Consistent formatting enhances readability and makes the codebase more visually appealing and approachable for developers.

    5.Testing and Testability: I followed good testing practices to ensure code reliability and maintainability. I wrote unit tests for critical components, such as service methods or complex business logic, to validate their functionality. By testing code early and regularly, I increased the project's test coverage and reduced the likelihood of introducing bugs during development.

    6.SOLID Principles: I applied the SOLID principles (Single Responsibility, Open-Closed, Liskov Substitution, Interface Segregation, and Dependency Inversion) to design and structure the codebase. These principles promote loose coupling, abstraction, and maintainability, allowing for easier extensibility and flexibility in the face of changing requirements.

    7.Code Refactoring: I continually reviewed and refactored the codebase to improve its quality and readability. Refactoring helps eliminate code smells, reduces technical debt, and ensures adherence to clean code principles. By refactoring code regularly, the project remains maintainable and easier to work with over time.

    By adhering to these clean code principles, the project exhibits qualities such as readability, maintainability, reusability, and testability. This promotes collaboration among developers, reduces the likelihood of bugs, and lays a solid foundation for future enhancements and scalability.