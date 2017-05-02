(ns game.core
  (use arcadia.core))

(log "asdf")

(def ^:dynamic bingo-board (partition 15 (range 1 76)))

(defn rand-part [coll]
  (def ^:dynamic part coll)
  (let [r (rand-nth part)]
    (set! part (remove #(= % r)))
    r))

;; (defn a [l part]
;;   (recur (conj 

(defn add [coll itm]
  (let [r (rand-nth (range 1 16))]
    (if (< (count coll) 5)
      (conj coll (rand-nth (range 1 16))) 
      coll)))

;; working
(reduce add #{} (range 1 16))

(defn add [part]
  (fn [coll itm]
    (let [r (rand-nth part)]
      (if (< (count coll) 5)
        (conj coll r)) 
        coll)))

(conj #{} 1)

(some #(= 1 %) [1 2 3])

(defn rand-5 [coll]
  (reduce (add coll) #{} coll))

((add (range 16 31)) #{} 1)

(rand-5 (range 16 31))

(rand-part (first bingo-board))

(doseq [part bingo-board]
  (dotimes [i 5]
    (let [r (rand-nth part)]
      (println r)
      (set! part (remove #(= % r) part))))
  (println part))

(remove #(= % 1) bingo-board)
