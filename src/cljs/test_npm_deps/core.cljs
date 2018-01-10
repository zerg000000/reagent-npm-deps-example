(ns test-npm-deps.core
  (:require [reagent.core :as reagent]
            [test-npm-deps.events :as events]
            [test-npm-deps.views :as views]
            [test-npm-deps.config :as config]
            [re-frame.core :as rf]))

(set! *warn-on-infer* true)

(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (rf/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (rf/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
