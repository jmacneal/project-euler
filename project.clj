(defproject project-euler "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.nrepl "0.2.12"]
                 [org.clojure/tools.trace "0.7.9"]]


  :profiles {:uberjar {:aot :all}
             :prime_sieve {:main project-euler.prime_sieve}
             :q1  {:main project-euler.q1}
             :q2  {:main project-euler.q2}
             :q3  {:main project-euler.q3}
             :q4  {:main project-euler.q4}
             :q5  {:main project-euler.q5}
             :q6  {:main project-euler.q6}
             :q7  {:main project-euler.q7}
             :q8  {:main project-euler.q8}
             :q9  {:main project-euler.q9}
             :q10 {:main project-euler.q10}  
             :q61 {:main project-euler.q61}}
  
  
  :aliases {"prime_sieve" ["with-profile" "prime_sieve" "run"]
            "q1"  ["with-profile" "q1" "run"]
            "q2"  ["with-profile" "q2" "run"]
            "q3"  ["with-profile" "q3" "run"]
            "q4"  ["with-profile" "q4" "run"]
            "q5"  ["with-profile" "q5" "run"]
            "q6"  ["with-profile" "q6" "run"]
            "q7"  ["with-profile" "q7" "run"]
            "q8"  ["with-profile" "q8" "run"]
            "q9"  ["with-profile" "q9" "run"]
            "q10" ["with-profile" "q10" "run"]            
            "q61" ["with-profile" "q61" "run"]}
  
  ;; :main ^:skip-aot project-euler.prime_sieve
  :target-path "target/%s"
  :plugins [[cider/cider-nrepl "0.13.0"]])

  
