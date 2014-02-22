(defproject clj-nhk "0.1.0-SNAPSHOT"
  :description "Clojure wrapper for NHK Program API"
  :url "http://github.com/tgfjt/clj-nhkapi"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/data.json "0.2.4"]
                 [clj-http "0.7.9"]
                 [clj-time "0.6.0"]]
  :main clj-nhk.core)
