# Email-Project

### Note

Accidental merge of "feature-Custom-Query" into "Main" due to click error.

This is the final project of my QA Academy Software Development course. The project
puts together Agile methodologies, Java fundamentals and back-end, server side
requests.

The application takes the details of a user snd stores them in an external database. Users can then use CRUD to interact with the database via HTTP requests.

The end goal is build a seperate, interactive command line in which the user interacts with the CLI and the data is posted to the database through the HTTP requests.


### Why Are We Doing This?
This is an accumulation of all the knowledge we have learnt on the course so far and how we apply this knowledge in practical situations.


### How I Expected It To Go 
I knew the challenge was going to be tough. The topics covered regarding HTTP requests are complex and need to be done correct to work.


### What Went Well
the task as a whole went better than I thought. I managed to get a working CRUD application done within the first 48 hours which was a relief. The Rest of my time was focused on test coverage and Additional features.


### What Didn't Go To Plan
Connecting to a database was a tough start to the project as I have been having issues all week. This is a case of merely debugging and testing different fixes in order to get the connection. In the end, it worked by creating the database first, then connecting through the Spring API.

### Possible Improvements
Overall I am very happy with my end results. The project went how I expected and felt like I followed and applied the specification well. If I were to do the project again, I would have possibly looked into adding multiple entities within one database and linking them through their keys. I have a application table with the "Email" entity, as the goal of this table was to provider users with email address and passwords. I would like to have another table for say "Tickets" where this would link a user to a submitted ticket through the id's. 

### Postman

<!-- Create --> 
#### Create
<img width="1440" alt="Screenshot 2021-10-01 at 16 03 42 (2)" src="https://user-images.githubusercontent.com/79116038/135645893-1e8f7ea1-df51-4e6a-834f-89a5b5469ee1.png">

<!-- Read --> 
#### Read
<img width="1440" alt="Screenshot 2021-10-01 at 16 05 05 (2)" src="https://user-images.githubusercontent.com/79116038/135646030-74177dba-fdf1-45f3-a79d-6ce1fce739e9.png">

<!-- Update -->
#### Update
<img width="1101" alt="Screenshot 2021-10-02 at 12 18 14" src="https://user-images.githubusercontent.com/79116038/135713936-5adc5889-acb0-4731-a6ab-9acb8ca97b91.png">
<img width="1097" alt="Screenshot 2021-10-02 at 12 18 28" src="https://user-images.githubusercontent.com/79116038/135713939-43fc3576-8af7-4a94-96d0-4481146615cf.png">



<!-- Delete --> 
#### Delete
<img width="1095" alt="Screenshot 2021-10-02 at 12 38 58" src="https://user-images.githubusercontent.com/79116038/135714467-64faeaa6-4102-41de-a7e4-fac3f264f891.png">
<img width="1100" alt="Screenshot 2021-10-02 at 12 39 25" src="https://user-images.githubusercontent.com/79116038/135714474-dc034cbb-748a-4492-a963-4aabf454934d.png">
<img width="1100" alt="Screenshot 2021-10-02 at 12 39 37" src="https://user-images.githubusercontent.com/79116038/135714481-cb9b77de-8b94-4814-a9a0-77b2d9bcdb74.png">
 





### Database 

##### Create In Postman
<img width="1440" alt="Screenshot 2021-10-01 at 16 29 13 (2)" src="https://user-images.githubusercontent.com/79116038/135647602-969d9758-4018-4a28-8efe-27a9bd1d30ee.png">

##### Persisted In WorkBench 
<img width="1440" alt="Screenshot 2021-10-01 at 16 30 21 (2)" src="https://user-images.githubusercontent.com/79116038/135647640-f7cb4cc5-77e3-4417-a124-d2d6ae0103ed.png">

#### Test Results 
<img width="1397" alt="Screenshot 2021-10-04 at 22 27 36" src="https://user-images.githubusercontent.com/79116038/135927288-b77b6b64-075b-4a67-a869-e40e7feb55b0.png">


### Jira Board - https://laytreynolds.atlassian.net/jira/software/projects/QJPECA/boards/2

### Risk Assessment - [Risk Assessment.pdf](https://github.com/laytreynolds/Email-Project/files/7269789/Risk.Assessment.pdf)


