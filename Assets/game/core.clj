(ns game.core
  (use arcadia.core))

(log "asdf")

(def ^:dynamic bingo-board (partition 15 (range 1 76)))

(defn rand-part [coll]
  (def ^:dynamic part coll)
  (let [r (rand-nth part)]
    (set! part (remove #(= % r)))
    r))

(rand-part (first bingo-board))

(doseq [part bingo-board]
  (dotimes [i 5]
    (let [r (rand-nth part)]
      (println r)
      (set! part (remove #(= % r) part))))
  (println part))

(remove #(= % 1) bingo-board)
