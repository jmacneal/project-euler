(ns project-euler.q1
  (:gen-class))

(defn mult-of-3-or-5 [x]
  (or
   (= 0 (mod x 3))
   (= 0 (mod x 5))))

(defn -main
  "Problem: get the sum of all multiples of 3 and/or 5 below 1000"
  [& args]
  (let [x (reduce + (filter mult-of-3-or-5 (range 1 1000)))]
   (println x)))












