(ns project-euler.q2
  (:gen-class))

(defn next-fib [[f1 f2]]
  "Returns the next fibonacci number following f2"
  [f2 (+ f1 f2)])

(def fibonacci
  (map first (iterate next-fib [1 1])))

(defn -main
  "Problem: get the sum of all even fibonacci numbers less than 4,000,000"
  [& args]
  println (reduce + (filter even? (take-while #(< % 4000000) fibonacci))))
