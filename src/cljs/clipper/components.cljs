(ns clipper.components
    (:require [reagent.core :as reagent :refer [atom]]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]
              [clipper.state :as state]))

(defn inline-text-editor [{value :value class :class on-change :on-change}]
    [:div {:class (str "inline-text-editor " class)}
        value])
