true = lambda t: lambda f: t

false = lambda t: lambda f: f

ifbs = lambda b: lambda t: lambda f: ((b (t) (f)))

b2str = lambda b: ((ifbs (b) ("TRUE") ("FALSE")))

ifb = lambda b: lambda t: lambda f: ((b (t) (f)) (()))

b2str = lambda b: ((ifb (b) (lambda _: "TRUE") (lambda _: "FALSE")))
