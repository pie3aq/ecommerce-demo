# ecommerce-demo Project Documentation

## Introduction

This document describes the steps taken to enable running tests and the main application in the `ecommerce-demo` project without using Maven. It also includes a list of identified issues and suggestions for further improvements.

## Running Tests Without Maven

To run the unit tests in the project, follow these steps:

1.  **Ensure you have Java Development Kit (JDK) version 17 or newer installed.**
    You can check your Java version by running:
    ```bash
    java -version
    ```
2.  **Navigate to the main project directory `ecommerce-demo`** in your terminal or command prompt.
3.  **Compile the source code and tests** using the provided script:
    ```bash
    ./compile_main.sh
    ```
    This script compiles `.java` files from `src/main/java` and `src/test/java` directories and places the compiled `.class` files in the respective `target/classes` and `target/test-classes` subdirectories.
4.  **Run the tests** using the provided script:
    ```bash
    ./run_tests.sh
    ```
    This script uses the JUnit Platform Console Standalone library to run tests from the `target/test-classes` directory. Test results will be displayed in the console.

## Running the Main Application

To run the main application, follow these steps:

1.  **Ensure you have compiled the source code** by running `./compile_main.sh` as described above.
2.  **Navigate to the main project directory `ecommerce-demo`**.
3.  **Run the main application** using the following command:
    ```bash
    java -cp target/classes main.Main
    ```
    This command executes the `Main` class, which is the entry point of the application. The output will be displayed in the console.

## Project Structure and Files

-   `src/main/java/`: Contains the application's source code.
-   `src/test/java/`: Contains the unit test code.
-   `lib/`: Contains necessary `.jar` libraries. In this case, it's `junit-platform-console-standalone-1.9.3.jar`.
-   `target/`: The directory where compiled `.class` files are placed.
    -   `target/classes/`: Compiled application source code.
    -   `target/test-classes/`: Compiled test code.
-   `compile_main.sh`: Script for compiling source code and tests. It has been improved to correctly handle source paths and classpath for both main and test compilation, including OS-specific path separators and using response files for `javac`.
-   `run_tests.sh`: Script for running JUnit tests. It has been improved to work on various operating systems by using separate `--class-path` arguments and an improved `ConsoleLauncher` invocation method.

## Identified Issues and Implemented Fixes

During the analysis and modification of the project, the following issues were identified and fixed:

1.  **Mismatch between package declarations and actual directory structure:**
    -   **Problem:** In `src/main/java/Main.java`, the package declaration (`package src.main;`) and some imports (`import src.main.cart.Cart;` etc.) did not correspond to the actual directory structure (`src/main/java/main/...`).
    -   **Fix:** The package declaration was changed to `package main;` and import paths were corrected to match the structure `main.cart.Cart`, `main.catalog.Catalog`, etc.
2.  **Incorrect assertion in `CatalogTest.testGetAllProductsSortedByName()`:**
    -   **Problem:** The test checked if the last product in the sorted list started with "Waterproof Jacket", whereas it should have been "Windshield for Stove" after alphabetical sorting.
    -   **Fix:** The assertion was updated to expect "Windshield for Stove".
3.  **Invalid promotion code in `CartTest.testSetPromotionByCode()`:**
    -   **Problem:** The test used the promotion code "3FOR2", while `PromotionFactory.java` defined "3ZA2" for the same promotion logic.
    -   **Fix:** The promotion code in the test was changed to "3ZA2".
4.  **Logical error in `ThreeForTwoPromotion.java`:**
    -   **Problem:** The "3 for 2" promotion logic incorrectly calculated the price, setting the price of every third (cheapest) product to 1.00 instead of 0.00.
    -   **Fix:** The logic was changed to set the price of every third cheapest product to 0.00.
5.  **Classpath separator issue in `run_tests.sh`:**
    -   **Problem:** The script used a colon (`:`) as a path separator in the `--class-path` argument, which caused an error on operating systems that use a semicolon (e.g., Windows).
    -   **Fix:** The script was modified to use separate `--class-path` arguments for each path, eliminating the separator issue.
6.  **Test execution issue (no arguments supplied to `ConsoleLauncher`):**
    -   **Problem:** The `run_tests.sh` script used `java -jar`, which caused the `--class-path` and `--scan-classpath` arguments to be interpreted by `ConsoleLauncher` *after* it was launched, rather than by the Java Virtual Machine itself. This resulted in the `No arguments were supplied to the ConsoleLauncher` error.
    -   **Fix:** The JUnit invocation method was changed to use `java -cp` and directly specify the `org.junit.platform.console.ConsoleLauncher` class. Logic was also added to automatically detect the path separator (`:` for Linux/macOS, `;` for Windows) based on the operating system.
7.  **Compilation issues (`cannot find symbol`, `package does not exist`):**
    -   **Problem:** The `compile_main.sh` script was not correctly specifying the source path for `javac`, leading to compilation errors for classes that depended on other classes within the project or JUnit libraries. Additionally, `find ... | xargs` can cause issues with too many arguments on some systems.
    -   **Fix:** The `compile_main.sh` script was updated to use the `-sourcepath` argument for `javac` to correctly specify the source directories. To handle a large number of source files and OS-specific path issues, it now generates temporary response files (`sources_main.txt`, `sources_test.txt`) containing the list of `.java` files, which are then passed to `javac` using the `@` syntax. This approach is more robust across different environments.

## Additional Notes and Suggestions

-   **Import Organization:** It is good practice to maintain consistency and order in Java import sections.
-   **Error Handling:** In the `Cart` class, messages about product unavailability are printed to `System.out`. For more complex applications, consider using a dedicated logging mechanism or throwing exceptions.
-   **Testing `printContents()`:** The `printContents()` method in the `Cart` class prints the cart contents to the console. Directly testing this method is challenging. One could consider redirecting `System.out` in the test or refactoring the method to return a formatted string that can be easily asserted.
-   **README.md:** The `README.md` file contained compilation and execution instructions specific to manual single-file compilation. These have been replaced by the use of `compile_main.sh` and `run_tests.sh` scripts.

I hope this information is helpful!


