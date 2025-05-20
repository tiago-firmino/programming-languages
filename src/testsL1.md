let m = box(9);
let v = !m;
v+1;;

let m = box(0);
m := !m + 1;
m := !m + 1;
m := !m + 1;
m := !m + 1;
m := !m + 1;
!m
;;

let m = box(9);
let v = !m;
m := v + 1;
v
;;

let m = box(9);
let v = !m;
m := v + 1;
!m
;;

let c = 0;
let L = 1000;
let m = box(c);
while (!m>0) {
    m := !m - 1
};
!m
;;

let c = 0;
let L = 1000;
let m = box(L);
let S = box(c);
while (!m>0) {
    m := !m - 1;
    S := !S + !m
};
!S
;;

let L = 1000;
let m = box(L);
let fnxt = box(1);
while (!m>0) {
    m := !m - 1;
    let t = !fnxt;
    fnxt := !fnxt + !fp;
    fp := t
};
!fp
;;


let sigfpe = box ( fn x=>{x} );
let setfpe = fn h => { sigfpe := h };
let div = fn n,m => {
      if (m==0) { (!sigfpe) (n) }
        else { n / m}
};
setfpe (fn v => { -1 });
div (2) (0)
;;

/* some functions to encode mutable pairs */
let knot = box (fn x => {x});
let fact = fn n => {
      if (n==0) { 1}
        else { n * ((!knot)( n - 1 ))}};
knot := fact;
fact (6)
;;

/* some functions to encode mutable pairs */
let mkpair =
    fn a,b => { 
        let l = box(a);
        let r = box(b);
        fn f => { f (l) (r) }
};
let getfst = fn p => { p (fn a,b => {!a }) };
let setfst = fn p,v => { p (fn a,b => {a := v })};
let getsnd = fn p => {p (fn a,b => {!b })};
let setsnd = fn p,v => { p (fn a,b => {b := v})};
let x = mkpair (1) (2);
setfst (x) (10);
setsnd (x) (20);
(getfst (x)) + (getsnd (x))
;;

let mkpair =
    fn a,b => { 
        let l = box(a);
        let r = box(b);
        fn f => { f (l) (r) }
};
let getfst = fn p => { p (fn a,b => {!a }) };
let setfst = fn p,v => { p (fn a,b => {a := v })};
let getsnd = fn p => {p (fn a,b => {!b })};
let setsnd = fn p,v => { p (fn a,b => {b := v})};
let mp = mkpair(2)(3);
setfst(mp) (getfst(mp)+getsnd(mp));
getsnd(mp)* (getfst(mp));;

