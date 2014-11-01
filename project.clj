(defproject org.clojars.jakemcc/clj-amazon "0.2.4"
  :description "Clojure bindings for the Amazon Product Advertising API."
  :url "http://github.com/FreeAgent/clj-amazon/"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :plugins [[lein-autodoc "0.9.0"]]
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [clj-http "0.5.8"]]
  :deploy-repositories [["snapshots" {:url "https://clojars.org/repo"
                                      :username :gpg :password :gpg}]
                        ["releases" {:url "https://clojars.org/repo"
                                     :username :gpg :password :gpg}]])
