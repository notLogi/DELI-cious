## Deli Around the Corner


The Deli Around the Corner application allows customer to order sandwiches, chips, and drinks. Sandwiches are fully customizable with cold cuts, veggies, and sauces of their choosing. After checking out, the receipt is stored in a text file named the time the order was processed.   


## User stories
- As a user, I want to filter out transactions by date, vendor, description, and the amount deposited/paid.
- As a user, I want to be able to add deposits, so I can keep track of spending.
- As a user, I want to be able to add payments, so I can keep track of my debt repayment.
- As a user, I want to see a list of options, so I can choose what to do on the application.
- As a user, I want to open all transactions, so I can see calculate the amount of money I have spent.
### Some features include:

**Add sandwiches, chips, drinks**
- Customers are allowed to add as much items as they want to order.

**Add toppings to sandwiches**
- Customers are allowed to add toppings to their sandwiches
- Option to request extra toppings
- Meat and cheeses cost extra, veggies, sauces, and sides are free of charge.

**Clear cart**
- If the user does not want to buy anything because of their change of mind, then they can exit the application.
- Can clear cart if they want to start over.

**Persistent storage**
- All products bought are stored in a text file.
- Total cost is calculated
- The text file is named after the time the order was processed.
  


## Setup


### Prerequisites

- IntelliJ IDEA: Ensure you have IntelliJ IDEA installed, which you can download from [here](https://www.jetbrains.com/idea/download/).
- Java SDK: Make sure Java SDK is installed and configured in IntelliJ.

### Running the Application in IntelliJ

Follow these steps to get your application running within IntelliJ IDEA:

1. Open IntelliJ IDEA.
2. Select "Open" and navigate to the directory where you cloned or downloaded the project.
3. After the project opens, wait for IntelliJ to index the files and set up the project.
4. Find the main class with the `public static void main(String[] args)` method.
5. Right-click on the file and select 'Run 'FinancialTracker.main()'' to start the application.

## Technologies Used

- Java SDK 17
- IntelliJ IDEA

## Demo(Left to right, top to bottom)
<img width="327" height="125" alt="image" src="https://github.com/user-attachments/assets/016e2e8b-dbaf-4c31-b32d-0241e68c3fa6" />




## Class Diagram
<img width="1243" height="668" alt="image" src="https://github.com/user-attachments/assets/6c14f69b-4937-4f23-b641-d1d08bb2cd34" />
<img width="475" height="242" alt="image" src="https://github.com/user-attachments/assets/46d80aed-f737-4153-8898-8424b3526fe5" />
<img width="545" height="352" alt="image" src="https://github.com/user-attachments/assets/5521e04e-8eea-432b-b93f-8f177ae7d5a6" />
<img width="1023" height="396" alt="image" src="https://github.com/user-attachments/assets/4e0b8ee2-0ef2-4b64-a4c3-5c5b763deb9a" />
<img width="807" height="248" alt="image" src="https://github.com/user-attachments/assets/41513f7a-fc44-4d90-b2ae-055e5307b5e7" />
<img width="807" height="248" alt="image" src="https://github.com/user-attachments/assets/30f2b7c7-f068-4dab-9873-50f6cb1089c1" />








## An Interesting Part of My Code

- Had a couple of switch cases in my cheese and meat class. Intellij suggested using yield in my switch cases to set a variable equal to the value returned.
- Used a couple of stream methods instead of for-loops.

## Resources
- https://www.geeksforgeeks.org/java/enhancements-for-switch-statement-in-java-13/

## Big thanks to:
- Raymond
- Potato Sensei
## Contributors:
- Roger Su


