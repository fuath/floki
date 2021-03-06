(ns floki.global.events
  (:require [re-frame.core :as rf]
            [quark.navigation.core :as nav]
            [floki.preview.events]
            [floki.movement.events]
            [floki.global.logic :as l.global]))

(rf/reg-event-db
  :init
  (fn [_ _]
    {:tree/input {}
     :tree/paths []
     :pos/x      -1
     :pos/y      0
     :tree/path  []}))

(rf/reg-event-db
  :input/set
  (fn [db [_ {:keys [format data]}]]
    (assoc db
      :tree/input data
      :tree/format format
      :tree/paths (sort l.global/custom-compare (nav/paths data)))))
