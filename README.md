## DELI-BROS ORDERING APP


The Deli Around the Corner application allows customer to order sandwiches, chips, and drinks. Sandwiches are fully customizable with cold cuts, veggies, and sauces of their choosing. After checking out, the receipt is stored in a text file named the time the order was processed.   


## User stories
- As a customer, I want to have an option to add a sandwich to my order, so I can buy a sandwich.
- As a customer, I want to have an option to add chips and drinks, so I can buy chips and drinks.
- As a customer, I want to add multiple sandwiches, chips, and drinks, so I can place a full meal order.
- As a customer, I want to receive my receipt of my order, so I can see the list of food I bought and the total price.
- As a customer, I want to be able to clear my order, so I can restart my order due to a change of mind.
### Some features include:

**Add sandwiches, chips, drinks**
- Customers are allowed to add items as much as they want to order.

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
<img width="418" height="399" alt="image" src="https://github.com/user-attachments/assets/a682b307-cae1-4975-849b-d859fbdae1e8" />
<img width="662" height="343" alt="image" src="https://github.com/user-attachments/assets/75068ae0-1c98-4818-a8c4-6ccc8d26a593" />
<img width="789" height="409" alt="image" src="https://github.com/user-attachments/assets/4694b657-db6c-429c-957e-9a5a58eebce6" />
<img width="788" height="477" alt="image" src="https://github.com/user-attachments/assets/313bfe97-144a-4342-ad20-2d217574c0be" />
<img width="595" height="313" alt="image" src="https://github.com/user-attachments/assets/fb7def3c-e900-42be-8283-a7be3c4e1cf9" />

## Class Diagram
<img width="1801" height="835" alt="image" src="https://github.com/user-attachments/assets/26eee9c0-57be-4dbc-b66e-3b814ab0f8ce" />




## An Interesting Part of My Code

- Had a couple of switch cases in my cheese and meat class. Intellij suggested using yield in my switch cases to set a variable equal to the value returned.
- Used a couple of stream methods instead of for-loops.
- Used an integer parser to avoid having to use try-catches

## Resources
- https://www.geeksforgeeks.org/java/enhancements-for-switch-statement-in-java-13/

## Big thanks to:
- Raymond
- Potato Sensei
## Contributors:
- Roger Su


