(ns test-npm-deps.views
  (:require [re-frame.core :as re-frame]
            [test-npm-deps.subs :as subs]
            ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div "Hello from " @name]))