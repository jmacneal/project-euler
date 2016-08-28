(defproject project-euler "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.nrepl "0.2.12"]
                 [lein-reload "1.0.0"]]
  :main ^:skip-aot project-euler.q3
  :target-path "target/%s"
  :plugins [[cider/cider-nrepl "0.11.0"]]
  :profiles {:uberjar {:aot :all}})
  ;;            :main-1 {:main project-euler.q1}
  ;;            :main-2 {:main project-euler.core}}
  
