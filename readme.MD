SwagLabsDemoAPP Bundle ID: com.saucelabs.SwagLabsMobileApp

WDIO Demo App Bundle ID: org.reactjs.native.example.wdioDemoApp

Allure Result Create Command : allure serve target/allure-results


Test cases for App Automation

1. Login Functionality

    Test Case 1: Valid Login
        Description: Verify that the user can log in with valid credentials.
        Steps:
            Open the app.
            Enter valid username (e.g., standard_user).
            Enter valid password (e.g., secret_sauce).
            Tap the login button.
        Expected Result: User is successfully logged in and redirected to the homepage.

    Test Case 2: Invalid Login (Wrong Password)
        Description: Verify that the user cannot log in with incorrect password.
        Steps:
            Open the app.
            Enter valid username (e.g., standard_user).
            Enter invalid password.
            Tap the login button.
        Expected Result: An error message appears indicating the password is incorrect.

    Test Case 3: Invalid Login (Wrong Username)
        Description: Verify that the user cannot log in with an incorrect username.
        Steps:
            Open the app.
            Enter an invalid username.
            Enter a valid password.
            Tap the login button.
        Expected Result: An error message appears indicating the username is incorrect.

    Test Case 4: Empty Username and Password
        Description: Verify that the app prompts for username and password if fields are left empty.
        Steps:
            Open the app.
            Leave both username and password fields empty.
            Tap the login button.
        Expected Result: An error message appears indicating that both fields are required.

2. Product List Functionality

    Test Case 5: Product List is Displayed
        Description: Verify that after successful login, the list of products is displayed.
        Steps:
            Log in with valid credentials.
            Wait for the homepage to load.
        Expected Result: A list of products is shown on the homepage.

    Test Case 6: Add Product to Cart
        Description: Verify that a product can be added to the cart.
        Steps:
            Log in with valid credentials.
            Select a product from the list.
            Tap the "Add to Cart" button.
        Expected Result: The product is successfully added to the cart, and the cart badge is updated.

    Test Case 7: Remove Product from Cart
        Description: Verify that a product can be removed from the cart.
        Steps:
            Log in with valid credentials.
            Add a product to the cart.
            Open the cart.
            Remove the product from the cart.
        Expected Result: The product is removed from the cart, and the cart badge is updated accordingly.

3. Checkout Process

    Test Case 8: Complete Purchase Flow
        Description: Verify that the user can successfully complete a purchase.
        Steps:
            Log in with valid credentials.
            Add products to the cart.
            Open the cart and tap "Checkout".
            Enter shipping details.
            Select a payment option.
            Confirm the order.
        Expected Result: The user successfully completes the purchase, and an order confirmation is displayed.

    Test Case 9: Cancel Checkout
        Description: Verify that the user can cancel the checkout process.
        Steps:
            Log in with valid credentials.
            Add products to the cart.
            Tap "Checkout".
            Tap the "Cancel" button at any point in the checkout process.
        Expected Result: The checkout process is canceled, and the user is redirected to the product list or home page.

4. UI and Performance Testing

    Test Case 10: Verify UI Elements on Login Page
        Description: Verify the presence of essential UI elements (e.g., username field, password field, login button).
        Steps:
            Open the app.
        Expected Result: All UI elements (username, password, login button) are visible and accessible.

    Test Case 11: Verify App Load Time
        Description: Measure the time it takes to load the app from launch to the product list screen.
        Steps:
            Launch the app.
        Expected Result: The app loads within an acceptable time frame (e.g., < 5 seconds).

5. Error Handling and Validation

    Test Case 12: Display Error for Network Failure
        Description: Verify that the app handles network failure gracefully and shows an error message.
        Steps:
            Simulate a network failure (turn off Wi-Fi/data).
            Try to add a product to the cart.
        Expected Result: An appropriate error message is shown, and the app prompts the user to check their internet connection.

    Test Case 13: Product Detail View
        Description: Verify that tapping a product in the list opens the product detail view.
        Steps:
            Log in with valid credentials.
            Tap on any product in the list.
        Expected Result: The product detail view opens and shows correct details (e.g., product description, price, images).

6. Logout Functionality

    Test Case 14: Logout
        Description: Verify that the user can log out of the app.
        Steps:
            Log in with valid credentials.
            Tap the logout button in the menu or settings.
        Expected Result: The user is logged out and returned to the login screen.
