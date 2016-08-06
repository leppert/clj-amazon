clj-amazon
==========

[![CircleCI Status for leppert/clj-amazon](https://circleci.com/gh/leppert/clj-amazon.svg?style=shield&circle-token=:circle-token)]([![Circle CI](https://circleci.com/gh/jobdone/jobdone.io.svg?style=svg)](https://circleci.com/gh/leppert/clj-amazon))


Clojure wrapper library for Amazon Product Advertising API, originally forked from code on Clojars by eduardoejp, with subsequent edits by jakemcc.

It's gradually evolving to include more and more field types from the Amazon API, but not yet complete.
Add more cases to the form in ```parse-results``` to extend.

## Usage
Add this to the `:dependencies` section of your `project.clj`

    [org.clojars.leppert/clj-amazon "0.3.0-SNAPSHOT"]

### From the REPL
Leiningen 2 has been used with this project.

    lein deps
    lein repl

And at the REPL:

    (:require [clj-amazon.core :as aws]
              [clj-amazon.signed-request-helper :as signer]
              [clj-amazon.product-advertising :as pa])

    (def ACCESS-KEY "YOUR-ACCESS-KEY-HERE" )
    (def SECRET-KEY "YOUR-SECRET-KEY-HERE" )
    (def ASSOCIATE-ID "YOUR-ASSOCIATE-ID-HERE")
    (def ENDPOINT "webservices.amazon.com")
    (def signer (signer/signed-request-helper ACCESS-KEY SECRET-KEY ENDPOINT)

    (pa/item-search
      :timestamp (aws/timestamp)
      :signer signer
      :search-index "Books"
      :keywords "Neuromancer"
      :associate-tag ASSOCIATE-ID
      :condition "New"
      :response-group "ItemAttributes,Images,OfferSummary,EditorialReview")

    (pa/item-lookup
      :timestamp (aws/timestamp)
      :signer signer
      :associate-tag ASSOCIATE-ID
      :item-id "0441569595"
      :response-group "ItemAttributes,Images,OfferSummary,EditorialReview")





## Reference

You can find more information about the Amazon Product Advertising API on the following web-pages.

"Getting Started Guide"
http://docs.amazonwebservices.com/AWSECommerceService/2011-08-01/GSG/Welcome.html

"Developer Guide"
http://docs.amazonwebservices.com/AWSECommerceService/latest/DG/index.html?Welcome.html


## License

Distributed under the Eclipse Public License, the same as Clojure.
