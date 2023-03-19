(ns tadam-personas.urls
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]
            [tadam-personas.views.public :as view-public]))

(defroutes public
  ;; Urls public pages
  (GET "/" [] view-public/index)
  (GET "/holamundo" [] view-public/holamundo)
  (GET "/hola" [] view-public/hola)
  (POST "/hola" [] view-public/hola-action)
  (GET "/api" [] view-public/api)
  (GET "/api/hola" [] view-public/api-hola)
  (POST "/api/hola" [] view-public/api-hola))


(defroutes resources-routes
  ;; Resources (statics)
  (route/resources "/")
  (route/not-found view-public/page-404))

(def all-routes
  ;; Wrap routers. "resources-routes" should always be the last.
  (compojure.core/routes public resources-routes))
