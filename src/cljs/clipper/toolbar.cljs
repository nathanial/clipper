(ns clipper.toolbar
    (:require [reagent.core :as reagent :refer [atom]]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]
              [clipper.state :as state]))

(defn app-title []
    [:div {:class "app-title"}
        "Clipper"])

(defn app-toolbar []
    [:div {:class "app-toolbar"}
        (app-title)
    ])
