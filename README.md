# social-frd-mgnt-test
This repository created for for social network task

# Social Friend Management Api
application with a need to build its own social network, "Friends Management" is a common requirement which usually starts off simple but can grow in complexity depending on the application's use case.
Usually, applications would start with features like "Friend", "Unfriend", "Block", "Receive Updates" etc.

# Technology Used in Project
## Spring Boot
1.  Auto configuration
2.  Embedded server for development environment
3.  Easy data source configuration
4.  Less development time

## MySql 
1. Lightweight and easy database
2. Easy to install easy to work.
3. It provide the GUI database with the help workbench or third party GUI tool like SQLYog

# Rest Endpoint Descriptions
1.	Logon help to create the user user profile in form of uniquely in form of email id.


  * Path : `/logon`
   * Input :
   ```
   {
			"email": "vishwakarma@gmail.com"
   }
   ```
   * Sample Output :
   ```
   {
		"success": true,
	}

  ```

2.  As a user, I need an API to create a friend connection between two email addresses.So that they become friend
  * Path : `/makeFriendRequest`
    * Input :
    ```
    {
		"friends":[
		          	"vishwakarma@gmail.com",
		          	"sudhansu@gmail.com"
	           	]
    }
    ```
    * Output :
    ```
    {
		"success": true
	}
	```


3. As a user, I need an API to retrieve the friends list for an email address.
   * Path : `/myfriendlist`
   * Input :
   ```
   {
		"email":"any@example.com"
   }
   ```
   * Sample Output :
   ```
   {
		"success": true,
		"friends":[
	          		"rk@gmail.com",
		          	"vishwakarma@gmail.com",			
		          ],
		"count":2
	}
	```
    
4.  As a user, I need an API to retrieve the common friends list between two email addresses user.
    * Path : `/commonfriends`
    * Input :
    ```
    {
		"friends":[
		          	"andy@example.com",
                "john@example.com"
		          ]
    }
    ```
    * Output :
    ```
    {
      "success": true,
      "friends" :
      [
        'common@example.com'
      ],
      "count" : 1
      }
      ```
  
5.  As a user, I need an API to subscribe to updates from an email address.
    * Path : `/usersubscribe`
    * Input :
    ```
    {
	       	"requestor": "lisa@example.com",
           "target": "john@example.com"
    }
    ```
    * Output :
    ```
    {
		"success": true
	}
	```
  
6. As a user, I need an API to block updates from an email address.
    * Path : `/blockfriend`
    * Input :
    ```
    {
	    	"requestor": "andy@example.com",
        "target": "john@example.com"
    }
    ```
    * Output :
    ```
    {
		"success": true
	}
	```


7.  As a user, I need an API to retrieve all email addresses that can receive updates from an email address.
    * Path : `/notifyuser`
    * Input :
    ```
    {
      	"sender": "john@example.com",
        "text": "Hello World! kate@example.com"
    }
    ```
    * Output :
    ```
    {
		"success": true,
		"recipients":[
	    		"lisa@example.com",
          "kate@example.com"			
		]
	}
	```
	
### Possible Error code
When we make a request and there may be the possibility of invalid input wrong request etc .
In this case we will get some error info with error code.

	  * 30006 : Sending Invalid request
	  * 30005 : Request email is not valid
	  * 30003 : The given email does not exist
	  * 30003 : Same email for two peaple at a time
	  * 30004 : Request email is aleady exist in user friend list
	  * 30001 : Sending the request to block user



