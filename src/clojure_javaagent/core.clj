(ns clojure-javaagent.core
  (:import
   [com.sun.tools.attach VirtualMachine]
   [java.lang.management ManagementFactory])
  (:require [clojure-javaagent.instrumentation :as inst]))

(defn pid []
  "PID of the running JVM"
  (re-find #"\d+" (.getName (ManagementFactory/getRuntimeMXBean))))

(defn load-instrumentation
  "Load a javaagent from a jar file and attach it to this process"
  [jar-path]
  (.loadAgent (VirtualMachine/attach (pid)) jar-path))

(defn -main
  [& args]
  (let [project-path   (.getCanonicalPath (clojure.java.io/file "."))
        javaagent-path (str project-path "/target/instrumentation.jar")]

    ; Attach the instrumentation javaagent to this projecess
    (load-instrumentation javaagent-path)

    ; Find the size of an object
    (println "The size of a String is"
             (.getObjectSize inst/instrumentation "Hello World")
             "bytes")))


