(ns ^:figwheel-no-load clipper.dev
  (:require
    [clipper.core :as core]
    [devtools.core :as devtools]))

(devtools/install!)

(enable-console-print!)

(core/init!)
