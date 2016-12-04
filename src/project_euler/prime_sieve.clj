(ns project-euler.prime_sieve
  (:gen-class))

(defn sieve [n]
  "Returns a BitSet with bits set for each prime up to n"
  (let [bs (new java.util.BitSet n)]
    (.flip bs 2 n)
    (doseq [i (range 4 n 2)] (.clear bs i))
    (doseq [p (range 3 (Math/sqrt n))]
      (if (.get bs p)
        (doseq [q (range (* p p) n (* 2 p))] (.clear bs q))))
    bs))

(defn bits-to-primes [bit-set]
  (loop [count 0 primes []]
    (let [next-set-bit (.nextSetBit bit-set count)]
      (cond (= -1 next-set-bit) primes
            :else               (recur (inc next-set-bit) (conj primes next-set-bit))))))



(defn -main
  "Returns all primes up to and including n."
  [& args]
  (println (apply + (bits-to-primes (sieve (read-string (first args)))))))
