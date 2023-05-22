# TimeFormatter
The goal of this project is to build a utility library that can be used in various projects. 
The library provides different functionalities to convert milliseconds to seconds, minutes, hours, and 
also provides options to hide zero units and display the output in two different formats. This library is implemented with the 
help of **Chain of Responsibility Principle**, **Strategy pattern** and **method chaining**. 
## Functionality:
This project provides a TimeFormatterUtil class which consists of an enum that offers a set of options for formatting time in milliseconds to a specific unit of time.

The enum includes three formatting options: TO_SECONDS, TO_MINUTES, and TO_HOURS. Each formatting option has a corresponding timeConverter object that implements the TimeFormatter interface. The timeConverter object is used to format the time in milliseconds into the desired unit of time.

The TimeFormatterUtil class provides two methods for formatting time. The first method, formatTime(), takes the time in milliseconds as an input and returns a formatted string in the desired unit of time. The second method, format(), takes the time in milliseconds as an input and returns a FormattedTime object that contains the formatted string in the desired unit of time.
format() function provides the base for **method chaining**
by returning the FormattedTime object. 


The FormattedTime class is a nested class inside the TimeFormatterUtil class. It provides two methods that can be used to modify the formatted string. The removeZeroUnits() method removes any zero units from the formatted string, and the toShortForm() method formats the string in a short form using 'h', 'm', and 's' for hours, minutes, and seconds, respectively.
This class also contains the toString() method to return the final formatted string. 

## Design Approach
During the design of this project, a significant focus was placed on maintaining a high degree of cohesion and loose coupling between the classes. Each class was designed to adhere to the Single Responsibility principle, ensuring that it has only one reason to change. In order to achieve this goal, two design patterns were implemented.
* **Chain of Responsibility:** The Chain of Responsibility is implemented with the help of builder classes (HoursBuilder, MinutesBuilder, SecondsBuilder) to format time in hours, minutes, and seconds. The formatter classes in org.utility.timeformatter package acts as the client and delegates the request to the first builder in the chain, which then passes the request to the next builder and so on until the request is handled.
* **Strategy:** The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable at runtime. In this class, the TimeFormatterUtil enum defines a set of formatting options (TO_SECONDS, TO_MINUTES, TO_HOURS) and uses the TimeFormatter interface as the abstraction for the algorithms. Each option in the enum encapsulates a specific implementation of the TimeFormatter interface, making them interchangeable at runtime.

## Open for Extension
By utilizing these patterns, the project is designed to be more modular, maintainable and extensible.
* The Strategy pattern is being used here to provide a flexible and extensible solution for formatting time in different units. If new formatting options need to be added in the future, a new implementation of the TimeFormatter interface can be created and added to the TimeFormatterUtil enum, without affecting the existing code.
* With chain of responsibility, if we need to add support for formatting time in days or weeks, we can simply create a new UnitBuilder class for days or weeks and add it to the chain of responsibility. Other formatter classes will not need to be modified, and the new functionality will seamlessly integrate with the existing code.
* The FormattedTime class in TimeFormatterUtil provides a way to extend the functionality of the TimeFormatterUtil without modifying the existing code. By encapsulating the formatted string in a separate class, we can add new methods to manipulate the formatted time without affecting the existing functionality of TimeFormatterUtil. For example, if we want to add a method to remove leading zeroes from the formatted string, we can simply add a method to the FormattedTime class, and the users of TimeFormatterUtil can use this method without modifying their code. This makes the TimeFormatterUtil more extensible and easier to maintain over time.

## Function Calls as per Assignment Tasks:
* Task 1:
`` TimeFormatterUtil.TO_SECONDS.format(milliseconds) ``
* Task 2:
  `` TimeFormatterUtil.TO_MINUTES.format(milliseconds) ``
* Task 3:
    `` TimeFormatterUtil.TO_HOURS.format(milliseconds) ``
* Task 4:
  `` TimeFormatterUtil.TO_HOURS.format(milliseconds).removeZeroUnits().toString() ``
* Task 5:
    `` TimeFormatterUtil.TO_HOURS.format(milliseconds).toShortForm().toString() ``

This code also provides functionalities to convert time string to short form after removing zero units. 
``                TimeFormatterUtil.TO_HOURS.format(milliseconds).removeZeroUnits().toShortForm().toString());``

Also, you can convert time string to short form with any time unit.Furthermore, TO_SECONDS and TO_MINUTES enums can be used to simply convert milliseconds to seconds or minutes, respectively. For instance, calling TO_MINUTES on 3650000ms will convert it to 60 minutes and 50 seconds.
## Junit Tests:
Test folder contains all the test cases written as junit tests. 
