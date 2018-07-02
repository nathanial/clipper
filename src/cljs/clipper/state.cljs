(ns clipper.state
    (:require [reagent.core :as reagent]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]))

(defonce pages (reagent/atom []))
(defonce selected-page (reagent/atom nil))

(defn add-page []
    (swap! pages conj {:id (random-uuid) :name "New Page"}))

(defn open-page-settings [page]
    (println "Open Page Settings" page))

(defn select-page [page]
    (swap! selected-page (fn [_] (:id page))))
