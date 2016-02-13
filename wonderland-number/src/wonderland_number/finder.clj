(ns wonderland-number.finder)

(def all-numbers-in-wonderland
  (range 100000 (inc 999999)))

(defn digits [x]
  (set (str x)))

(defn same-digits?
  [x y]
  (= (digits x)
     (digits y)))

 (defn wonder-num?
   [x]
   (and (= 6 (count (str x) ))
        (every? (same-digits? x)
                (map #(* x %) [2 3 4 5 6]))))

(defn find-first [pred coll]
  (some #(when (pred %) %) coll))

(defn wonderland-number []
  (let [x (find-first wonder-num? all-numbers-in-wonderland)]
    (println x)
    x))
