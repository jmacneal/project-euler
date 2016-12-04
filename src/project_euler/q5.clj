(ns project-euler.q5
  (:gen-class)
  (:require [project-euler.q3 :as p]))

(defn divisor-of? [x & divisors]
  "Returns true if x divides evenly by all divisors, false otherwise"
  (not (some #(not (= 0 (mod x %))) (vec divisors))))

(defn divisor-of-11-to-20? [x]
  (divisor-of? x 11 12 13 14 15 16 17 18 19 20))

(defn count-prime-factors [x]
  "Returns a map with prime factors of x as keys, and the power of those factors as the values"
  (loop [factors (p/prime-factorize x) m {}]
    (let [head (-> factors first str keyword)]
      (cond (empty? factors)   m
            (contains? m head) (recur (rest factors) (update-in m [head] inc))
            :else              (recur (rest factors) (assoc m head 1))))))

(defn lcm [d & divisors]
  "Returns the least common multiple of d and divisors, using prime factorization"
  (let [prime-factors (map count-prime-factors (cons d divisors))]
    (let [prime-map (apply (partial merge-with max) prime-factors)]
      (int (reduce * (map #(Math/pow %1 %2) (map (comp read-string name)  (keys prime-map)) (vals prime-map)))))))

(defn -main
  "Problem: Find the smallest positive integer divisible by 1-20"
  [& args]
  (println (lcm 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20)))












