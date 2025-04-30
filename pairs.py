from churchnumerals import *

# Tuples

# (M,N) := lambda f: (f (M) (N) )

pair = lambda a: lambda b: lambda f: (f (a) (b))

fst = lambda p: (p (lambda x: lambda y: x))

snd = lambda p: (p (lambda x: lambda y: y))

p0 = (pair (czero) (cone))
