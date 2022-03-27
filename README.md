# Testing

**Selenium Basics - WebTesting**

-----------------------------------------------------------------------------------
**Example - 1 -> Playing Music from Spotify**
  
  The concept includes logging-in to the spotify webpage and playing 'yellow' song by coldplay.
  It comprises of:
          
          initiating login 
          enabling web-player
          enabling search bar
          adding input of 'yellow' in the search bar
          enabling play


**_Libraries used - Setup_**

    chromedriver.exe
    selenium-server-standalone-2.53.0.jar

**_Run_**

  Need to run file webPageTest.java inside src folder
  
**Considerations** 

> Random value of the song is used 
> Spotify loads the webpage enablement option after every successful login




--------------------------------------------------------------------------------------------




**Example - 2 -> Fetching loan value from emicalculator page**
  
  The concept includes opening bank emi calculator page and fetching the amount of loan.It comprises of:
          
          initiating webpage
          setting certain value of amount
          setting certain value of interest
          setting certain value of tenure
          fetching the loan value


**_Libraries used - Setup_**

    chromedriver.exe
    selenium-server-standalone-2.53.0.jar

**_Run_**

  Need to run file webPageElementInteractionTest.java inside src folder
  
**Considerations** 

> Random values of the three parameters are used


--------------------------------------------------------------------------------------------




**Example - 3 -> Fetching loan value from emicalculator page through manual input**
  
  The concept includes opening bank emi calculator page and fetching the amount of loan.It comprises of:
          
          initiating webpage
          setting certain value of amount through input
          setting certain value of interest through input
          setting certain value of tenure through input
          fetching the loan value


**_Libraries used - Setup_**

    chromedriver.exe
    selenium-server-standalone-2.53.0.jar

**_Run_**

  Need to run file webPageElementInteractionTestTwo.java inside src folder
  
**Considerations** 

> Input values of the three parameters are used
