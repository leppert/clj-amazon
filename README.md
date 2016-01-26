clj-amazon
==========

Clojure wrapper library for Amazon Product Advertising API, originally forked from code on Clojars by eduardoejp, with subsequent edits by jakemcc.

It's gradually evolving to include more and more field types from the Amazon API, but not yet complete.
Add more cases to the form in ```parse-results``` to extend.

## Usage

    ...not in Clojars yet, bear with me...

### From the REPL
Leiningen 2 has been used with this project.

    lein deps
    lein repl

And at the REPL:

    (use 'clj-amazon.core)
    (use 'clj-amazon.product-advertising)

    (def ACCESS-KEY "YOUR-ACCESS-KEY-HERE" )
    (def SECRET-KEY "YOUR-SECRET-KEY-HERE" )
    (def ASSOCIATE-ID "YOUR-ASSOCIATE-ID-HERE")
    (def ENDPOINT "webservices.amazon.co.uk") ;; Amazon UK product API

    (def gibson-opus-search (with-signer (ACCESS-KEY SECRET-KEY ENDPOINT) (item-search :search-index "Books", :keywords "Neuromancer", :associate-tag ASSOCIATE-ID, :condition "New")))

    (def lookup-specific-item (with-signer (ACCESS-KEY SECRET-KEY ENDPOINT) (item-lookup :associate-tag ASSOCIATE-ID :item-id "B0069KPSPC" :response-group "ItemAttributes,OfferSummary")))


## Reference

You can find more information about the Amazon Product Advertising API on the following web-pages.

"Getting Started Guide"
http://docs.amazonwebservices.com/AWSECommerceService/2011-08-01/GSG/Welcome.html

"Developer Guide"
http://docs.amazonwebservices.com/AWSECommerceService/latest/DG/index.html?Welcome.html


## License

Distributed under the Eclipse Public License, the same as Clojure.
