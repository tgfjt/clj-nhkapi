# clj-nhk

Clojure wrapper for NHK Program API.

[![wercker status](https://app.wercker.com/status/43674cee9b346f993a0d6a38eed86def/s/ "wercker status")](https://app.wercker.com/project/bykey/43674cee9b346f993a0d6a38eed86def)

## Usage

With Leiningen:

``` clj
[clj-nhk "0.1.0"]
```

Example:
* the title of present program of "Tokyo(130) NHKBS1(s1)"


``` clj
(use 'clj-nhk.core)

(println (:title (:present (nowonair "APIKEY" "130" "s1"))))
```

## License

Copyright © 2014 Takashi Fujita(@tgfjt)

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
