(ns
    com.dthume.incanter-utils
  (:require [incanter.core :as incant]
            [com.dthume.util.set :as xr]))

(defn xrel->dataset
  "Transform xrel to an incanter dataset"
  [xrel]
  (let [ks (into [] (xr/distinct-keys xrel))]
    (incant/dataset ks
                    (map (fn [row] (map row ks))
                         xrel))))

(defn dataset->xrel
  "Transform ds, an incanter dataset to an xrel; note that since xrels are
inherently sets, the resulting xrel may contain less rows than ds."
  [ds]
  (set (:rows ds)))
