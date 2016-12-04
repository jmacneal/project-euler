(ns project-euler.q61
  (:gen-class))

(def triangles
  (vec (drop-while #(< % 1000) (take-while #(< % 10000) (map #(/ (* % (inc %)) 2) (iterate inc 1))))))

(def squares
  (vec (drop-while #(< % 1000) (take-while #(< % 10000) (map #(* % %)  (iterate inc 1))))))

(def pentagons
  (vec  (drop-while #(< % 1000) (take-while #(< % 10000) (map #(/ (* % (dec (* 3 %))) 2) (iterate inc 1))))))

(def hexagons
  (vec  (drop-while #(< % 1000) (take-while #(< % 10000) (map #(* % (dec (* 2 %))) (iterate inc 1))))))

(def heptagons
  (vec  (drop-while #(< % 1000) (take-while #(< % 10000) (map #(/ (* % (- (* 5 %) 3)) 2) (iterate inc 1))))))

(def octagons
  (vec  (drop-while #(< % 1000) (take-while #(< % 10000) (map #(* % (- (* 3 %) 2)) (iterate inc 1))))))


(defn is-cyclic [n1 n2]
  "Predicate: returns true if the last 2 digits of n1 = the first 2 digits of n2, false otherwise."
  (let [n1-digits (map #(Character/digit % 10) (str n1))
        n2-digits (map #(Character/digit % 10) (str n2))]
    (= (take-last 2 n1-digits) (take 2 n2-digits))))

(defn next-cycles [figurates cycles]
  "Returns each possible cycle with a member of cycles as a prefix and a figurate as the last element."
  (filter #(is-cyclic (first (take-last 2 %)) (last %))
          (for [f figurates c cycles]
            (conj c f))))

(defn complete-cycles [cycles]
  "Returns each cycle in cycles for which the head and tail elements form a cycle."
  (filter #(is-cyclic (last %) (first %)) cycles))


(defn generate-cycle [figurates cycles]
  "Supplied with a sequences of figurate vectors and a sequence of initial cycles, returns all possible complete cycles."
  (cond (empty? cycles)    []
        (empty? figurates) (complete-cycles cycles)
        :else              (map #(generate-cycle (remove #{%} figurates) (next-cycles % cycles)) figurates)))

(defn -main
  "Problem: Find the (only) cyclic set of 6 4-digit triangular->octagonal numbers, and take their sum."
  [& args]
  (flatten (generate-cycle [squares pentagons hexagons heptagons octagons] (map vector triangles))))




