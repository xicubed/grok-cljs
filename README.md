# grok-cljs

FIXME: Write a one-line description of your library/project.

## Overview

FIXME: Write a paragraph about the library/project and highlight its goals.

## Development

To get an interactive development environment run:

    clojure -A:fig:build

This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    rm -rf target/public

To create a production build run:

	rm -rf target/public
	clojure -A:fig:min


## some commonly used stuff

```
com.lotect.grok-cljs=> (require '[clojure.math.combinatorics :as combo])

cljs.user=> (ns com.lotect.grok-cljs)
nil
com.lotect.grok-cljs=>

(js/console.log '(pairs))
```

## License

Copyright © 2022 lotect.com

MIT License see LICENSE file