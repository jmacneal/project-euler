(ns project-euler.q6
  (:gen-class))

(defn -main
  "Problem: Find the difference between the square of sums and sum of squares for 1-100."
  [& args]
  (println (int (- (Math/pow (reduce + (take 100 (iterate inc 1))) 2) (reduce + (map #(Math/pow % 2) (take 100 (iterate inc 1))))))))












