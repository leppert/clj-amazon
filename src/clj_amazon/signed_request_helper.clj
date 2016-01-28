(ns clj-amazon.signed-request-helper
  (:require [clj-amazon.core :refer :all]))


(def HMAC-NAME "HmacSHA256")


(defprotocol ISignedRequestsHelper
  (sign [self params])
  (hmac [self string]))


(defrecord SignedRequestsHelper [endpoint access-key secret-key secret-key-spec mac]
  ISignedRequestsHelper
  (sign [self params]
    (let [query-str (-> params
                      (assoc "AWSAccessKeyId" access-key, "Timestamp" (timestamp))
                      (canonicalize UTF-8))
          query     (str "GET\n" endpoint "\n" "/onca/xml" "\n" query-str)
          hmac      (.hmac self query)
          encoded   (percent-encode-rfc-3986 hmac UTF-8)]
        (str "http://" endpoint "/onca/xml" "?" query-str "&Signature=" encoded)))

  (hmac [self string]
    (-> string (.getBytes UTF-8)
      (->> (.doFinal mac)
        (.encode (org.apache.commons.codec.binary.Base64. 76 (byte-array 0))))
      String.)))


(defn signed-request-helper
  [access-key secret-key endpoint]
  (let [secret-key-spec (-> secret-key (.getBytes UTF-8) (javax.crypto.spec.SecretKeySpec. HMAC-NAME))
        mac             (javax.crypto.Mac/getInstance HMAC-NAME)]
    (.init mac secret-key-spec)
    (SignedRequestsHelper. endpoint access-key secret-key secret-key-spec mac)))
