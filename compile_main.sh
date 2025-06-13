#!/bin/bash

# Determine the operating system to set the correct classpath separator
case "$(uname -s)" in
    Linux*|Darwin*)
        # Linux or macOS
        CLASSPATH_SEPARATOR=":"
        ;;
    CYGWIN*|MINGW32*|MSYS*|MINGW*)
        # Windows (Cygwin, MinGW, MSYS)
        CLASSPATH_SEPARATOR=";"
        ;;
    *)
        # Default to Linux/macOS separator for other systems
        CLASSPATH_SEPARATOR=":"
        ;;
esac

# Create target directories if they don't exist
mkdir -p target/classes
mkdir -p target/test-classes

# Compile main source code
# Find all .java files in src/main/java and compile them
find src/main/java -name "*.java" > sources_main.txt
javac -d target/classes -sourcepath src/main/java @sources_main.txt

# Compile test source code
# Find all .java files in src/test/java and compile them
find src/test/java -name "*.java" > sources_test.txt
javac -d target/test-classes -sourcepath src/test/java -cp "target/classes${CLASSPATH_SEPARATOR}lib/junit-platform-console-standalone-1.9.3.jar" @sources_test.txt

rm sources_main.txt sources_test.txt


