(ns datomic-schema-grapher.datomic-test-helpers
  (:require [datomic.api :as d]))

(defn- transact-edn
  [connection file]
  (let [project-dir (System/getProperty "user.dir")
        read-edn #(read-string (slurp (str project-dir %)))]
    (do
      (println "Transacting edn: " file)
      @(d/transact connection (read-edn file)))))

(defn prepare-database!
  ([uri schema]
   (when (d/create-database uri)
     (transact-edn (d/connect uri) schema)))
  ([uri schema fixtures]
   (prepare-database! uri schema)
   (transact-edn (d/connect uri) fixtures)))

(defn delete-database!
  [uri]
  (d/delete-database uri))

(defn database [uri] (d/db (d/connect uri)))

(defn setup
  [before after]
  (fn [test-case]
    (do
      (before)
      (test-case)
      (after))))
