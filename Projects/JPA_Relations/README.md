# JPA - Hibernate in SpringBoot
#### Implemented a simple database for a group of organizations by using Jpa & Hibernate to define relations and constraints between classes.
## What I had done
- Implemented the repository and service layers
- Definded the relations between tables
  - One To One (Bidirectional)
  - One To Many (Unidirectional)
  - Many To Many (Bidirectional)
- Used Cascading (Persist - Remove)
- Used fetching strategy (Eager - Lazy)
- Tested all the repositories using Junit
  - Making sure that simple CRUD operations are working as expected
  - Making sure that cascading is working as expected
  - Took notes about
  - Flushing in database
  - Automated test cases wokrs in asynchronous way by default
## Database Schema
![Organizations_Ceg excalidraw](https://user-images.githubusercontent.com/77211992/183228378-cc9aef27-1e71-41dd-a347-0047aa9c348b.png)

## TODOs
- Finish the services implementation
- Test the service layer
- Start building the controller layer
- Test the controller layer
- Learn how to run a test cage package properly
- Read more about mapping in hibernate, and when would unidirectional is enough
- Read more use cases about Lazy & Eager fetching
- What other uncommon problems I may face (like flushing)
- Learn how to access the Many To Many join column, and how to acces it. (or if I should define it my self with two one to many relation)
- Fix the problems that occur when running the whole repository collection test package
- Use more testing assertion
