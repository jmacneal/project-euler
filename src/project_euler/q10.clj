(ns project-euler.q10
  (:gen-class)
  (:use [project-euler.prime_sieve :only [bits-to-primes sieve] :as prime_sieve]))

(defn -main
  "Returns all primes up to (not including) 2,000,000."
  [& args]
  (println (apply + (prime_sieve/bits-to-primes (prime_sieve/sieve (dec 2000000))))))
