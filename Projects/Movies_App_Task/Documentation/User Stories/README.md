# User Stories <br/>
### Functional Requirements: 

- ***Movie Details:*** As a user, I want to get the movie details on a new page whenever I click on a movie card.
  - Acceptance criteria:
    - Movie details are shown on a ***new page***
    - Movie details consist of (poster - name - revenue - etc.)
***
-  ***Popular Movies At Home Page:*** As a user, I want a page that displays the current popular movies and is able to display their details of them.
    - Acceptance criteria:
      - User can see movies displayed in a grid
      - User can get the information of any shown movie when he clicks on it
***
- ***Search By Name***: As a user, I want a search bar where I can search movies by their names, I also want suggestions to show after writing 3 letters or more of the name.
  - Acceptance criteria:
    - Well functional search bar
    - Suggestions are shown after writing 3 or more letters
    - If I clicked on a movie from a suggestion list, it must redirect me to the movie details
***
- ***Search By Category:*** As a user, I want a button to filter the movies based on category.
  - Acceptance criteria:
    - Well functional button
    - All movies displayed belong only to the category I selected
***
- ***Sort By Parameters:*** As a user, I want to sort movies based on some criteria
  - Acceptance criteria:
    - Well functional button
    - All movies displayed belong only to the category I selected
***
- ***Registration:*** As a user, I want a page where I can make an account for myself
  - Acceptance criteria:
    - Page for registration
    - Basic validation (each user has a single mail - valid phone number & e-mail - etc.)

***
- ***Login And Save Personal Things:*** As a user, I want a page where I can log in either by the account I created or by using Gmail or Facebook
  - Acceptance criteria:
    - Page for login
    - I can log in using other social media accounts (Gmail - Facebook)
***
***
### Non-Functional Requirements: 
- ***Caching Movie Details:*** we will create a simple cache to check if the required movie card is in the cache or not. (instead of hitting the main database directly)
  - Acceptance criteria:
    - Retrieve the movie card from the cache if exist
    - Add the movie card if it is not in the cache
***
- ***Caching Eviction strategy:*** We should have a strategy to evict items in the cache (LRU - LFU)
  - Acceptance criteria:
    - Cache doesn't exceed a specific number of rows
    - If the cache exceeded that number, then the first row must be deleted
