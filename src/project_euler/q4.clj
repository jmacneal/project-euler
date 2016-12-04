(ns project-euler.q4
  (:require [clojure.string :as str])
  (:gen-class))

(defn isPalindrome [num]
  "Returns true if num is palindromic, false otherwise. digits should be an array of numbers (single-digit)"
  (letfn [(palindrome-helper [digits]
    (loop [f (first digits) l (last digits) middle (drop 1 (drop-last digits))]
      (cond
        (<= (count digits) 1) true
        (= f l) (if (empty? middle) true
                    (recur (first middle) (last middle) (drop 1 (drop-last middle))))
        :else false)))]
    (palindrome-helper (as-> num $ (str $) (str/split $ #"") (drop 1 $) (map read-string $)))))

(def three-digits
  (take 900 (iterate inc 100)))

(def products
  (loop [nums three-digits acc []]
    (if (empty? nums) acc
        (recur (drop 1 nums) (concat acc (map #(* (first nums) %) three-digits))))))

(defn -main
  "Problem: find the largest palindromic product of 2 three-digit nums"
  [& args]
  (println (apply max (filter isPalindrome (vec products)))))











