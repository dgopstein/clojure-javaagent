# clojure-javaagent
An example project demonstrating how to build and attach a javaagent to a Clojure REPL at runtime

A long-form description of this example is available at <https://dgopstein.github.io/articles/clojure-javaagent>

There are two separate components of this project:
1. Generating the javaagent jar: `lein with-profile instrumentation uberjar`
2. Loading the javaagent from your project: `lein run`
