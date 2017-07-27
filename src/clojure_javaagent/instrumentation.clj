(ns clojure-javaagent.instrumentation
  (:import [java.lang.instrument Instrumentation])
  (:gen-class
   :methods [^:static [agentmain [String java.lang.instrument.Instrumentation] void]]))

(defn -agentmain [^String args ^Instrumentation instrumentation]
  (println "Loading agentmain")

  ; Give the Instrumentation object a binding for access from other namespaces
  (def instrumentation instrumentation))
