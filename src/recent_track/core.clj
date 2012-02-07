(ns recent-track.core
  (:require [clojure.data.json :as json])
  (:gen-class))

(def recentTrackURL "http://ws.audioscrobbler.com/2.0/?method=user.recenttracks.json&user=ahjones&api_key=b25b959554ed76058ac220b7b2e0a026&format=json")

(defn firstArtist [tracks]
  (get-in tracks [:recenttracks :track 0 :artist :#text]))

(defn firstName [tracks]
  (get-in tracks [:recenttracks :track 0 :name]))

(defn -main [& args]
     (let [trackText (slurp (.openStream (java.net.URL. recentTrackURL)))
	   tracks (json/read-json trackText)]
       (println (str (firstArtist tracks) " by " (firstName tracks)))))


