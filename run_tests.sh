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

# Construct the classpath string
CLASSPATH="lib/junit-platform-console-standalone-1.9.3.jar${CLASSPATH_SEPARATOR}target/test-classes${CLASSPATH_SEPARATOR}target/classes"

java -cp "${CLASSPATH}" org.junit.platform.console.ConsoleLauncher --scan-classpath


