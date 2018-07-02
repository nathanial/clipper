(ns clipper.page
    (:require [reagent.core :as reagent :refer [atom]]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]
              [clipper.state :as state]
              [clipper.components :as components :refer [inline-text-editor]]))

(defn page-title [page]
    (inline-text-editor {:value (:name page) :class "page-title"}))

(defn blank-page [page]
    [:div {:class "blank-page"}
        (page-title page)])

(defn show-page [page]
    [:div {:class "page"}
        (cond
            (= (:type page) :blank) (blank-page page)
            :else [:h1 "Other " (:type page)])])

(defn selected-page []
    (let [page (first (filter #(= @state/selected-page (:id %1)) @state/pages))]
        (if page
            (show-page page))))

