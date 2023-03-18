# tadam-personas

Estudiando Clojure.

## Hola Mundo MVC

- Saluda al mundo con una página dinámica MVC
- [src\tadam_personas\urls.clj](https://github.com/akobashikawa/tadam-personas/blob/holamundo-mvc/src/tadam_personas/urls.clj)

```clj
(GET "/holamundo" [] view-public/holamundo)
```

- [src\tadam_personas\views\public.clj](https://github.com/akobashikawa/tadam-personas/blob/holamundo-mvc/src/tadam_personas/views/public.clj)

```clj
(defn holamundo
  ;; View HTML
  [req]
    (render-HTML req "public/holamundo.html" {}))
```

- [resources\templates\public\holamundo.html](https://github.com/akobashikawa/tadam-personas/blob/holamundo-mvc/resources/templates/public/holamundo.html)

```clj
{% extends "layouts/base.html" %}

{% block title %}
Hola Mundo
{% endblock %}

{% block content %}
<h1>Hola Mundo</h1>
{% endblock %}
```
