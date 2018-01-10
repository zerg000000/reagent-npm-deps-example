(ns test-npm-deps.core
  (:require [reagent.core :as reagent]
            [test-npm-deps.config :as config]
            [re-frame.core :as rf]))

(set! *warn-on-infer* true)

(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn main []
  [:div "Hello World"])

(defn mount-root []
  (rf/clear-subscription-cache!)
  (reagent/render [main]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (dev-setup)
  (mount-root))
