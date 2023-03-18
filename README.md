# tadam-personas

Estudiando Clojure.

## Usage

```sh
lein run
```

## Testing

``` sh
lein check-idiomatic
lein check-format
```

## Hola MVC

- Saluda a alguien con una página dinámica MVC
- [src\tadam_personas\urls.clj](https://github.com/akobashikawa/tadam-personas/blob/master/src/tadam_personas/urls.clj)

```clj
(POST "/hola" [] view-public/hola-action)
```

- [src\tadam_personas\views\public.clj](https://github.com/akobashikawa/tadam-personas/blob/master/src/tadam_personas/views/public.clj)

```clj
(defn hola
  ;; View HTML
  [req]
    (render-HTML req "public/hola.html" {:nombre "Mundo"}))

(defn hola-action
  ;; View HTML
  [req]
    (render-HTML req "public/hola.html" {:nombre (-> req :params :nombre)}))
```

- [resources\templates\public\hola.html](https://github.com/akobashikawa/tadam-personas/blob/master/resources/templates/public/hola.html)

```clj
{% block content %}
<h1>Hola</h1>

<form action="/hola" method="POST">
    <input type="text" name="nombre" placeholder="Nombre" class="form-control">
    <button type="submit" class="btn btn-primary mt-2">Hola</button>
</form>

<h2 class="mt-4">Hola {{ nombre }}!</h2>
{% endblock %}
```
