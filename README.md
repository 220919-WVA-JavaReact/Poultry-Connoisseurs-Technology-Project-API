# Eggcellent Reviews

## Description
API for the official Eggcellent Reviews website.

## Executive Summary
- Movie App will provide a platform for users to read about and review movies.
- All users can read about and write reviews for movies.
- Admins can login and delete inappropriate reviews or ban users.

### All-Users User Stories
- A user can register
- A user can login/logout
- A user has a profile page
- A user can see other people's profile pages
- A user can add a movie to their 'watched' list
- A user can navigate to the page of a movie
- A user can see the previous reviews of a movie on the page
- A user can leave a review of a movie

### Admin User Stories
- An admin can delete a user's review
- An admin can ban a user

## Stretch Goals
- [FEATURE] - Dark Mode
- [FEATURE] - Movie Ratings
- [FEATURE] - Notifications
- [FEATURE] - Password Reset
- [FEATURE] - Movie Recommendations


## Endpoints
    - /auth
        - POST
            - HTTP Request
                - url: "http://localhost:8080/egg/auth"
                - header: Content-type: JSON
                - Body: { "username":user, "password":pass }
            - HTTP Response
                - status code
                    - 200: success
                    - 400: unable to login
                body:
                    - Principal - UserDTO
                Header:
                    - set-cookie: JSessionID


    - /users
        - GET
            - /users
                - HTTP Request
                    - url: "http://localhost:8080/egg/users"
                    - headers:
                     - cookie: JSessionID
                        - MUST be admin
                - HTTP Response
                    - status code
                        - 200: success
                        - 401: unauthorized
                - body
                    - UserDTO[]
                - Header:
                    - content-type: JSON
        - PUT
            - /ban
                - HTTP Request
                    - url: "http://localhost:8080/egg/users/userID
                    - headers:
                     - cookie: JSessionId
                        - MUST be admin
                - HTTP Response
                    - status code
                        - 200: success
                        - 401: unauthorized
                        - 403: access level higher req
                - body
                    - UserDTO
                - Header:
                    - content-type:JSON

    - /reviews
        - GET
            - /movieID
                - HTTP Request
                    - url: "http://localhost:8080/egg/reviews"
                    - headers:
                     - None unless storing JSessionID
                - HTTP Response
                    - status code
                        - 200: success
                        - 500: error retrieving info
                - body
                    - Review[]
                - Header:
                    - content-type: JSON
            - /users/userID
                - HTTP Request
                    - url: "http://localhost:8080/egg/reviews/users/userID"
                    - headers:
                     - None unless storing JSessionID
                - HTTP Response
                    - status code
                        - 200: success
                        - 500: error retrieving info
                - body
                    - Review[]
                - Header:
                    - content-type: JSON