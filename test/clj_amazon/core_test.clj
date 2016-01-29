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


(deftest assoc+-does-what-its-meant-to
  (testing "Assoc value with empty map"
    (is (= {:a :b} (assoc+ {} :a :b))))

  (testing "Assoc value with populated map"
    (is (= {:a :b :c :d} (assoc+ {:a :b} :c :d))))

  (testing "Assoc value with populated map with duplicate key"
    (is (= {:a [:b :c]} (assoc+ {:a :b} :a :c))))

  (testing "Nil map acts like empty map"
    (is (= {:a :b} (assoc+ nil :a :b)))))


(deftest bool-str
  (testing "Map truthy values to 'True' or 'False'"
    (is (= "True" (_bool->str true)))
    (is (= "False" (_bool->str false)))
    (is (= "True" (_bool->str :foobar)))
    (is (= "False" (_bool->str nil)))))


(deftest str-sym
  (testing "Symbolises strings"
    (is (= 'foo (_str->sym "Foo")))
    (is (= 'foo-bar (_str->sym "FooBar")))
    (is (= nil (_str->sym nil)))
    (is (= nil (_str->sym "")))))


(deftest extracts-strs
  (testing "Pulls second values out of nested lists"
    (is (= '("abc" "ghi") (_extract-strs (list "abc" (list "def" "ghi")))))))


(deftest extracts-vars
  (testing "Symbolises values pulled by _extract-strs"
    (is (= '(abc ghi) (_extract-vars (list "Abc" (list "Def" "Ghi")))))))
