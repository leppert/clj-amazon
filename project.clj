(defproject org.clojars.jakemcc/clj-amazon "0.3.0-SNAPSHOT"
  :description "Clojure bindings for the Amazon Product Advertising API."
  :url "http://github.com/rorygibson/clj-amazon/"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :plugins [[lein-autodoc "0.9.0"]]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "2.0.1"]]
  :deploy-repositories [["snapshots" {:url "https://clojars.org/repo"
                                      :username :gpg :password :gpg}]
                        ["releases" {:url "https://clojars.org/repo"
                                     :username :gpg :password :gpg}]])
