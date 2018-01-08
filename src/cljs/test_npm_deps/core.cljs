(ns test-npm-deps.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [test-npm-deps.events :as events]
            [test-npm-deps.views :as views]
            [test-npm-deps.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
