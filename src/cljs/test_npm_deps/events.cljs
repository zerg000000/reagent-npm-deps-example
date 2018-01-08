(ns test-npm-deps.events
  (:require [re-frame.core :as re-frame]
            [test-npm-deps.db :as db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/default-db))
