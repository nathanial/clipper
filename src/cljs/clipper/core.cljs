(ns clipper.core
    (:require [reagent.core :as reagent :refer [atom]]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]
              [clipper.toolbar :as toolbar]
              [clipper.sidebar :as sidebar]
              [clipper.state :as state]))

;; -------------------------
;; Views


(defn home-page []
  [:div {:class "home-page"}
    (toolbar/app-toolbar)
    (sidebar/sidebar)])

;; -------------------------
;; Routes

(defonce page (atom #'home-page))

(defn current-page []
  @page)

(secretary/defroute "/" []
  (reset! page #'home-page))


;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (accountant/configure-navigation!
    {:nav-handler
     (fn [path]
       (secretary/dispatch! path))
     :path-exists?
     (fn [path]
       (secretary/locate-route path))})
  (accountant/dispatch-current!)
  (mount-root))
