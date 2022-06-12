#Author: Arun_Mathai

Feature: To verify API automation with Rest Assured


#GET request
Scenario: To GET user details of a particular user

Given To get user details for user with userId "1"
Then user details response should include the following
| userId  | id | title               | completed |
| 1       | 1  | delectus aut autem  | false     |


#POST request
Scenario: To make a post on Social Media

Given To initiate Rest service to make a post in Socail Media
Then status code response should be "201"
And post response should include the following
| userId  | id | title            | body 						|
| 122     | 101| amatjango        | amatComments    |


#GET request
Scenario: To get the comment details of a particular users Social media post

Given To initiate Rest service to get the comment details of user with userId "5"
Then status code response should be "200"
And comments response should include the following
| name  																	|  email 							|  body 						|
| vero eaque aliquid doloribus et culpa   | Hayden@althea.biz   | harum non quasi et ratione\ntempore iure ex voluptates in ratione\nharum architecto fugit inventore cupiditate\nvoluptates magni quo et          |



#PUT request
Scenario: To update a comment for a post in social media

Given Rest service to update a comment for a post in social media
Then status code response should be "200"
And post response should include the following
| userId  | id | title            | body 						|
| 222     | 1  | amatjango new    | amatComments new   |


#PATCH request
Scenario: To update the title for a post in social media using Patch request


Given Rest service to update a title for a post in social media using patch request
| userId    | title                    | 
| 222     | amatjango patch request  |
Then status code response should be "200"
And post response should include the following
| userId  | id | title                     | body 						|
| 222     | 1  | amatjango patch request   | quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto 	|



#DELETE request
Scenario: To delete a user with a particular id

Given Rest service to delete a user with id "1"
Then status code response should be "200"

