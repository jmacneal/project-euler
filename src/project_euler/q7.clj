(ns project-euler.q7
  (:gen-class)
  (:require [project-euler.q3 :as p]))

(defn -main
  "Problem: find the 10,001st prime"
  [& args]
  (println (nth p/primes 10000)))












