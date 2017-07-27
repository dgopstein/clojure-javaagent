(defproject clojure-javaagent "1.0.0"
  :description "An example project demonstrating how to build and attach a javaagent to a Clojure REPL at runtime"
  :url "https://dgopstein.github.io/articles/clojure-javaagent"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"
            :key "mit"
            :year 2017}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :plugins [[lein-jdk-tools "0.1.1"]] ; put tools.jar on the classpath
  :profiles {:instrumentation
             {:main clojure-javaagent.instrumentation
              :aot [clojure-javaagent.instrumentation]
              :uberjar-name "instrumentation.jar"
              ; Note the '_' instead of '-' since we're describing java packages
              :manifest {"Agent-Class" "clojure_javaagent.instrumentation"}}}
  :main clojure-javaagent.core)
