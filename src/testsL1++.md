
# Strict Lists

let l = 1::2::nil; match l { nil -> println(nil) | x::y -> println(x); println(y) };;
#1
#Cons(head=2, tail=nil)
#Cons(head=2, tail=nil)

let len = fn l => { match l { nil -> 0 | x::y -> 1 + len (y) } }; let l0 = 1::2::3::nil; len (l0);;
#3

let mkl = fn n => { if (n==0) { nil } else { n::( mkl(n-1)) } }; let len = fn l => { println (l); match l { nil -> 0 | x::y -> 1 + len (y) } }; let l100 = mkl (100); println l100; len(l100);;
#nil
#100

let mkl = fn n => { if (n==0) { nil } else { n::( mkl(n-1)) } }; let suml = fn l => { match l { nil -> 0 | x::y -> x + suml (y) } }; let l100 = mkl (100); println l100; suml(l100);;
#5050

# Lazy Lists

let l = 1:?2:?nil; match l { nil -> println(nil) | x::y -> println(x); println(y) };;
#1
VLCons(headVal=undefined, tailVal=undefined)
VLCons(headVal=undefined, tailVal=undefined)

let l = 1:?2::nil; match l { nil -> println(nil) | x::y -> println(x); println(y) };;
#1
Cons(head=2, tail=nil)
Cons(head=2, tail=nil)

let add1 = fn l => { match l { nil -> 0 | h::t -> (h+1)::(add1 (t)) } }; let mkl = fn n => { if (n==0) { nil } else { n::( mkl(n-1)) } }; add1 ( mkl (10) );;
#Cons(head=11, tail=Cons(head=10, tail=Cons(head=9, tail=Cons(head=8, tail=Cons(head=7, tail=Cons(head=6, tail=Cons(head=5, tail=Cons(head=4, tail=Cons(head=3, tail=Cons(head=2, tail=0))))))))))

let add1 = fn l => { match l { nil -> 0 | h::t -> (h+1)::(add1 (t)) } }; let mkll = fn n => { if (n==0) { nil } else { n:?( mkll(n-1)) } }; let ll100 = mkll (100); add1 ( ll100 );;
#Cons(head=101, tail=Cons(head=100, tail=Cons(head=99, tail=Cons(head=98, tail=Cons(head=97, tail=Cons(head=96, tail=Cons(head=95, tail=Cons(head=94, tail=Cons(head=93, tail=Cons(head=92, tail=Cons(head=91, tail=Cons(head=90, tail=Cons(head=89, tail=Cons(head=88, tail=Cons(head=87, tail=Cons(head=86, tail=Cons(head=85, tail=Cons(head=84, tail=Cons(head=83, tail=Cons(head=82, tail=Cons(head=81, tail=Cons(head=80, tail=Cons(head=79, tail=Cons(head=78, tail=Cons(head=77, tail=Cons(head=76, tail=Cons(head=75, tail=Cons(head=74, tail=Cons(head=73, tail=Cons(head=72, tail=Cons(head=71, tail=Cons(head=70, tail=Cons(head=69, tail=Cons(head=68, tail=Cons(head=67, tail=Cons(head=66, tail=Cons(head=65, tail=Cons(head=64, tail=Cons(head=63, tail=Cons(head=62, tail=Cons(head=61, tail=Cons(head=60, tail=Cons(head=59, tail=Cons(head=58, tail=Cons(head=57, tail=Cons(head=56, tail=Cons(head=55, tail=Cons(head=54, tail=Cons(head=53, tail=Cons(head=52, tail=Cons(head=51, tail=Cons(head=50, tail=Cons(head=49, tail=Cons(head=48, tail=Cons(head=47, tail=Cons(head=46, tail=Cons(head=45, tail=Cons(head=44, tail=Cons(head=43, tail=Cons(head=42, tail=Cons(head=41, tail=Cons(head=40, tail=Cons(head=39, tail=Cons(head=38, tail=Cons(head=37, tail=Cons(head=36, tail=Cons(head=35, tail=Cons(head=34, tail=Cons(head=33, tail=Cons(head=32, tail=Cons(head=31, tail=Cons(head=30, tail=Cons(head=29, tail=Cons(head=28, tail=Cons(head=27, tail=Cons(head=26, tail=Cons(head=25, tail=Cons(head=24, tail=Cons(head=23, tail=Cons(head=22, tail=Cons(head=21, tail=Cons(head=20, tail=Cons(head=19, tail=Cons(head=18, tail=Cons(head=17, tail=Cons(head=16, tail=Cons(head=15, tail=Cons(head=14, tail=Cons(head=13, tail=Cons(head=12, tail=Cons(head=11, tail=Cons(head=10, tail=Cons(head=9, tail=Cons(head=8, tail=Cons(head=7, tail=Cons(head=6, tail=Cons(head=5, tail=Cons(head=4, tail=Cons(head=3, tail=Cons(head=2, tail=0))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))

let intsfm = fn n => { n:? (intsfm (n+1)) }; let pfst = fn l,n => { if (n==0) { println(n) } else { match l { nil -> 0 | h::t -> println(h); pfst (t) (n-1) } } }; let l = intsfm (0); pfst (l) (20);;
#0
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
0
0

let fibo = fn a, b => { a :? (fibo (b) (a+b)) }; let fibogen = fibo (0) (1); let count = box ( 30 ) ; let lv = box( fibogen ); while (!count ~= 0) { match (!lv) { nil -> println (0) | v :: tail -> println (v); lv := tail }; count := !count - 1 };;
#0
1
1
2
3
5
8
13
21
34
55
89
144
233
377
610
987
1597
2584
4181
6765
10946
17711
28657
46368
75025
121393
196418
317811
514229
false

let intsfm = fn n => { n:? (intsfm (n+1)) }; let filter = fn l, g => { match l { nil -> nil | h::t -> if (g(h)) { h :? (filter (t) (g)) } else { filter (t) (g)} } }; let pfst = fn l,n => { if (n==0) { println(n) } else { match l { nil -> 0 | h::t -> println(h); pfst (t) (n-1) } } }; let l = intsfm (0); let even = fn n => { (n/2)*2 == n }; let m = filter (l) (even); pfst (m) (100);;
#0
2
4
6
8
10
12
14
16
18
20
22
24
26
28
30
32
34
36
38
40
42
44
46
48
50
52
54
56
58
60
62
64
66
68
70
72
74
76
78
80
82
84
86
88
90
92
94
96
98
100
102
104
106
108
110
112
114
116
118
120
122
124
126
128
130
132
134
136
138
140
142
144
146
148
150
152
154
156
158
160
162
164
166
168
170
172
174
176
178
180
182
184
186
188
190
192
194
196
198
0
0
