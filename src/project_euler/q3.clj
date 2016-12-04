(ns project-euler.q3
  (:gen-class))

(def big-num 600851475143)

(defn prime? [x]
  "return true if x is prime, false otherwise"
  (let [less-than (take (int (Math/sqrt x)) (iterate inc 2))]
    (or
     (= x 2)
     (not (some #(= 0 (mod x %)) less-than)))))

(def primes
  (filter prime? (iterate inc 2)))

(defn next-divisor [number collection]
  "returns the next divisor of number in the collection"
  (first (filter #(= 0 (mod number %)) collection)))

(defn next-prime-divisor [number]
  "returns the next prime divisor of number"
  (next-divisor number primes))

(defn prime-factorize [x]
  "return a list of the prime factors of x"
  (loop [n x factors []]
    (let [divisor (next-prime-divisor n)]
      (if divisor (recur (/ n divisor) (conj factors divisor))
          factors))))

(defn -main
  "Problem: find the largest prime factor of big-num"
  [& args]
  (println (apply max (prime-factorize big-num))))

