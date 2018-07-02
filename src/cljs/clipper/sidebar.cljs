(ns clipper.sidebar
    (:require [reagent.core :as reagent :refer [atom]]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]
              [clipper.state :as state]))

(defn add-page-btn []
    [:div {:class "add-page-btn" :on-mouse-down #(state/add-page)}
        [:i {:class "fa fa-plus"}]])

(defn page-settings-btn [page]
    [:div {:class "page-settings-btn" :on-mouse-down #(state/open-page-settings page)}
        [:i {:class "fa fa-ellipsis-h"}]])

(defn page-item [page is-selected]
    (let [class (if is-selected "page-item selected" "page-item")]
        [:div {:class class :key (:id page) :on-mouse-down #(state/select-page page)}
        [:span {:class "page-title"} (:name page)]
        (page-settings-btn page)]))

(defn sidebar []
    (let [selected-page @state/selected-page]
        [:div {:class "side-bar"}
            [:div {:class "pages-header"}
                "Pages"
                (add-page-btn)]
            (for [page @state/pages]
                (page-item page (= (:id page) selected-page)))]))
