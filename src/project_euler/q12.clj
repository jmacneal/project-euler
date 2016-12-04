(ns project-euler.q12
  (:gen-class))


(def triangles
  (map #(/ (* % (inc %)) 2) (iterate inc 1)))

(defn divisors [number]
  (concat (take-while #(not= number %) (filter #(= 0 (mod number %)) (iterate inc 1))) [number]))

(defn num-divisors [number]
  (* 2 (count (take-while #(<= % (Math/sqrt number)) (filter #(= 0 (mod number %)) (iterate inc 1))))))

(defn binary-search [val col init]
  "Searches col for val, starting at position init."
  (loop [index init previous-index 0]
    (let [current-val (nth col index)]
      (cond (= current-val val) index
            (< current-val val) (if (> previous-index index)
                                  (recur (/ (+ previous-index index) 2) index)
                                  (recur (* 2 index) index))
            (> current-val val) (if (< previous-index index)
                                  (recur (/ (+ previous-index index) 2) index)
                                  (recur (/ index 2) index))))))

(binary-search 500 (map num-divisors triangles) )
(num-divisors 99)
(num-divisors 28)
(take 100 triangles)
(nth triangles 21893)
(num-divisors (nth triangles 1234543))
(first (filter #(> (num-divisors %) 500) triangles))

(first (drop-while #(< % 500) (map num-divisors triangles)))

(defn -main
  "Problem: Find the first triangular number with more than 500 divisors."
  [& args]
  (println (first (filter #(> (num-divisors %) 500) triangles))))










