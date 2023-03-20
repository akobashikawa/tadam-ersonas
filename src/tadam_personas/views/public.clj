;;;; Views public web
(ns tadam-personas.views.public
  (:require
  ;;  [ring.util.response :refer :all]
  ;;  [ring.util.request :refer [get-body-string]]
   [cheshire.core :refer [parse-string]]
   [tadam.templates :refer [render-HTML render-JSON render-404]]))

;;debugging parts of expressions
(defmacro dbg [x] `(let [x# ~x] (println "dbg:" '~x "=" x#) x#))

(defn index
  ;; View HTML
  [req]
    (render-HTML req "public/welcome.html" {}))

(defn holamundo
  ;; View HTML
  [req]
    (render-HTML req "public/holamundo.html" {}))

(defn hola
  ;; View HTML
  [req]
    (render-HTML req "public/hola.html" {:nombre "Mundo"}))

(defn hola-action
  ;; View HTML
  [req]
  (let [nombre (-> req :params :nombre)]
    (render-HTML req "public/hola.html" {:nombre nombre})))

(defn api-hola
  ;; View HTML
  [req]
    (let [body (slurp (:body req))
          params (parse-string body true)
          nombre (get params :nombre)
          saludo (str "Hola " nombre "!")]
      (render-JSON req {:saludo saludo})))

(defn api
  ;; View JSON
  [req]
    (render-JSON req {:result true}))

(defn page-404
  ;; View page 404
  [req]
  (render-404 req "public/404.html" {}))
