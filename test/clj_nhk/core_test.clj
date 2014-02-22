(ns clj-nhk.core-test
  (:require [clojure.test :refer :all]
            [clj-nhk.core :refer :all]))

(deftest url-test
  (testing "FIXME, I fail."
    (is (=  (programlist-api "MYKEY" "130" "g1" "2014-02-22") "http://api.nhk.or.jp/v1/pg/list/130/g1/2014-02-22.json?key=MYKEY"))
    (is (=  (programgenre-api "MYKEY" "130" "g1" "0000" "2014-02-22") "http://api.nhk.or.jp/v1/pg/genre/130/g1/0000/2014-02-22.json?key=MYKEY"))
    (is (=  (programinfo-api "MYKEY" "130" "g1" "2014022211298") "http://api.nhk.or.jp/v1/pg/info/130/g1/2014022211298.json?key=MYKEY"))
    (is (=  (nowonair-api "MYKEY" "130" "g1") "http://api.nhk.or.jp/v1/pg/now/130/g1.json?key=MYKEY"))))
