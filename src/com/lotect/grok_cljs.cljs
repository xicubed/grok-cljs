(ns ^:figwheel-always ^:figwheel-hooks com.lotect.grok-cljs
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]
   [clojure.math.combinatorics :as combo]))


(println "This text is printed from src/com/lotect/grok_cljs.cljs. Go ahead and edit it and see reloading in action.")

(defn multiply [a b] (* a b))

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "“Hello” — HAL 9000"}))

(defn get-app-element []
  (gdom/getElement "app"))

(def available [\q \w \t \u \i \p \s \g \h \j \k \z \x \v \b \n \m])

(defn count-of-combos [a]
  (/ (combo/count-combinations available 2) 2))

(defn pairs []
  (first (take (count-of-combos [available]) (combo/combinations available 2))))

(defn pairs-n [n]
  (first (take-nth n ((count-of-combos [available]) (combo/combinations available 2)))))


(defn pairs-loop []
  (loop [i 0]
    (when (< i (count-of-combos [available]))
      (println i)
      (take-nth (combo/combinations available 2))

     (recur (inc i)))))


(defn hello-world []
  [:div
   [:h1 (:text @app-state)]
   [:h3 "Edit this in src/com/lotect/grock_cljs.cljs line 20  aaaand watch it change! testing change..."]
   [:p (str (count-of-combos [available]))]
   [:p (take (count-of-combos [available]) (combo/combinations available 2))]
   [:p (pairs)]])




(defn mount [el]
  (rdom/render [hello-world] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

;; conditionally start your application based on the presence of an "app" element
;; this is particularly helpful for testing this ns without launching the app
(mount-app-element)

;; specify reload hook with ^:after-load metadata
(defn ^:after-load on-reload []
  (mount-app-element))
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)

