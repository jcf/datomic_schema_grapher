(defproject jcf/datomic-schema-grapher "0.0.2-SNAPSHOT"
  :description "A library and lein plugin for graphing the datomic schema."
  :url "https://github.com/felixflores/datomic_schema_grapher"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[hiccup "1.0.5"]
                 [jcf/dorothy "0.0.7-SNAPSHOT"]]
  :profiles {:dev {:dependencies [[com.datomic/datomic-free "0.9.4572"]
                                  [org.clojure/clojure "1.8.0"]]}}
  :jvm-opts ["-Xmx1g"])
