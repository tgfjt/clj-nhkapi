# clj-nhk

for NHK Program API with Clojure.

## Usage

With Leiningen:

```
[clj-nhk "0.1.0"]
```

'''
(use 'clj-nhk.core)

;; Following program Now On Air 
(:following (nowonair "APIKEY" "130" "g1"))
```

## License

Copyright © 2014 tgfjt

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
