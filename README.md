# railway_reservation
This system is designed for the online reservation of railway tickets for travel between any destinations This system enables the Advance booking in any class, against general and ladies quota, on payment of fare in full for adults and children, a maximum of six berths/seats at a time, for journey between any two stations served by a train.

It also provides details about
1. Time table
2. Train fares
3. Current status of reservation position
4.Train available between a pair of stations
5.Accommodation available for a train/date combination
		The user of this system should first register for any interaction with the system. Once registered, he/she will be provided with a username and password for the user to log in. After logging in the user should select the kind of activity he would like to perform like booking a ticket, canceling a ticket, look out for help and so on. A person can check the train timings, train fares and other trains information without login.
	
Requirements:

RESERVATION

		The customer can reserve ticket by filling the reservation form present in the website. The reservation form present contain passenger name, sex, age, address, credit no, bank name, class through which the passenger is to travel etc. The online manager will verify the detail and provide PNR number to the customers who reserve the ticket.


CANCELLATION
             
		The user can also perform cancellation of the ticket which he\she had reserved earlier by entering PNR no. This PNR no will be checked with the PNR no in the database. If it exists then it will be cancelled. After cancellation process the conformation message will be send by the server.

 
Functional Requirements Specification
   This section outlines the use cases for each of the actors separately.
Passenger
	      Use cases: reserve ticket, cancel ticket, view ticket fare, view train details.	

 
If passenger needed reserves his ticket before and after reserving if he want to cancel his ticket then he can move to cancel ticket option and amount of ticket is display along with the train details…. 
	1: passenger first checks for the train details.
	2: passenger by viewing ticket amount reserves his ticket
	3: if he wants to cancel his ticket he does it 
Administrator
	Usecase: update train details
 
Administrator simply updates all the information such as the train arrival and departure details, ticket fare amounted…
	1: first administrator updates all details.
	2: passenger goes through then and acts accordingly.

User Characteristics

A passenger can reserve ticket, view ticket fare and view train details by searching from the database. A user can also cancel ticket which is reserved by him. And the administrator simply updates all the information such as the train arrival and departure details, ticket fare amounted and the tickets which are bought and then blocks the seats which are reserved.
		The railway database is used to know the total details and information about the train and the tickets reserved by the passengers. So, if the user wants to reserve the train ticket then he should first fill the form and select the dates and timing of the train along with the place. So, if the seats are available then the administrator will issue ticket and the bill should be paid by using credit/debit card. So, the passenger can also cancel the reserved ticket whenever he wants.
Class diagram for Online Railway Ticket Reservation 
Sequence diagram for Online Railway Ticket Reservation
 


