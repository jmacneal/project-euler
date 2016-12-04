(ns project-euler.q9
  (:gen-class)
  (:require [clojure.string :as string]))

(defn is-triple-1000? [a b]
  "Predicate. Returns true if a^2 + b^2 = c^2, a < b < c, a + b + c = 1000."
  (let [c (- 1000 a b)]
    (and
     (> b a)
     (> c b)
     (= (+ (* a a) (* b b)) (* c c)))))

(defn -main
  "Problem: Find the product of the first (and only) Pythagorean Triple (a^2 + b^2 = c^2) for a+b+c=1000."
  [& args]
  (let [[a b] (first (filter #(apply is-triple-1000? %) (for [b (range 1 1000) a (range 1 1000) :while (< a b)] (vector a b))))]
    (println (str "Values:" [a b (- 1000 a b)] "\nProduct:" (* a b (- 1000 a b))))))
