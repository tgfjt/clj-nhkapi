;; for NHK Program API
;
(ns clj-nhk.core
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]
            [clj-time.core :as t]
            [clj-time.format :as tf])
  (:use [clojure.string :only (join)]))

;; Program List API
; http://api.nhk.or.jp/v1/pg/list/{area}/{service}/{date}.json?key={apikey}
(def list-url "http://api.nhk.or.jp/v1/pg/list/")
;; Program Genre API
; http://api.nhk.or.jp/v1/pg/genre/{area}/{service}/{genre}/{date}.json?key={apikey}
(def genre-url "http://api.nhk.or.jp/v1/pg/genre/")
;; Program Info API
; http://api.nhk.or.jp/v1/pg/info/{area}/{service}/{id}.json?key={apikey}
(def info-url "http://api.nhk.or.jp/v1/pg/info/")
;; Now On Air API
; http://api.nhk.or.jp/v1/pg/now/{area}/{service}.json?key={apikey}
(def now-url "http://api.nhk.or.jp/v1/pg/now/")

;; Custom Date Format for json from NHK API
(def hmm-format (tf/formatter "H:mm"))

;; Create URL for Program List API
(defn programlist-api
  [apikey area service & date]
  (if (nil? date)
    (str list-url
      (join "/"
        [area service
          (str (tf/unparse (:date tf/formatters) (t/now)) ".json?key=" apikey)]))
    (str list-url (join "/" [area service (str (apply str date) ".json?key=" apikey)]))))

;; Create URL for Program Genre API
(defn programgenre-api
  [apikey area service genre & date]
  (if (nil? date)
    (str genre-url
      (join "/"
        [area service genre
          (str (tf/unparse (:date tf/formatters) (t/now)) ".json?key=" apikey)]))
    (str genre-url (join "/" [area service genre (str (apply str date) ".json?key=" apikey)]))))

;; Create URL for Program Info API
(defn programinfo-api
  [apikey area service id]
    (str info-url
      (join "/" [area service (str id ".json?key=" apikey)])))

;; Create URL for Now On Air API
(defn nowonair-api
  [apikey area service]
    (str now-url (str area "/" service ".json?key=" apikey)))

(defn get-list
  [url]
  (let [programs-data (client/get url)]
    (json/read-str (:body programs-data) :key-fn keyword)))

(defn show-programs
  [service json-list]
  ((keyword service) (:list json-list)))

(defn current-programs
  [service json-list]
  ((keyword service) (:nowonair_list json-list)))

(defn programlist
  [apikey area service & date]
  (show-programs service
    (if (nil? date)
      (get-list (programlist-api apikey area service))
      (get-list (programlist-api apikey area service date)))))

(defn programgenre
  [apikey area service genre & date]
  (show-programs service
    (if (nil? date)
      (get-list (programgenre-api apikey area service genre))
      (get-list (programgenre-api apikey area service genre date)))))

(defn programinfo
  [apikey area service id]
  (show-programs service
    (get-list (programinfo-api apikey area service id))))

(defn nowonair
  [apikey area service]
  (current-programs service (get-list (nowonair-api apikey area service))))

(defn -main
  [apikey area service id]
  (programinfo apikey area service id))
