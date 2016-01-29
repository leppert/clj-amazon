(ns clj-amazon.core-test
  (:use clojure.test
        clj-amazon.core))


(def first-jan-2016 (java.util.GregorianCalendar. 2016 (java.util.Calendar/JANUARY) 1))


(deftest time-format-test
  (testing "Test that timestamp format is correct"
    (is (= "2016-01-01T00:00:00.000Z" (timestamp (.getTime first-jan-2016))))))


(deftest percent-encoding
  (testing "Encodes spaces to %20 instead of +"
    (is (= "foo%20bar" (percent-encode-rfc-3986 "foo bar" UTF-8))))
  (testing "Additionally replaces * signs with %2A"
    (is (= "foo%2Abar" (percent-encode-rfc-3986 "foo*bar" UTF-8))))
  (testing "Does not encode ~ to %7E, leaves it as ~"
    (is (= "foo~bar" (percent-encode-rfc-3986 "foo~bar" UTF-8)))))
