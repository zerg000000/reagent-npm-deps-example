(defproject test-npm-deps "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.946"]
                 [reagent "0.8.0-alpha2" :exclusions [cljsjs/react
                                                      cljsjs/react-dom
                                                      cljsjs/create-react-class]]
                 [re-frame "0.10.2"]]

  :plugins [[lein-cljsbuild "1.1.5"]]

  :min-lein-version "2.5.3"

  :jvm-opts ["--add-modules=java.xml.bind"]

  :source-paths ["src/clj"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :figwheel {:css-dirs ["resources/public/css"]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.8"]]

    :plugins      [[lein-figwheel "0.5.13"]]}}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "test-npm-deps.core/mount-root"}
     :compiler     {:main                 test-npm-deps.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :install-deps true
                    :npm-deps {:react "16.2.0"
                               :react-dom "16.2.0"
                               :create-react-class "15.6.2"}
                    :source-map-timestamp true
                    :preloads             [devtools.preload]
                    :external-config      {:devtools/config {:features-to-install :all}}
                    }}

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            test-npm-deps.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :process-shim true
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}


    ]}

  )
