from peanonumerals import *

# NIL := lambda n: lambda c: n
# CONS (v, l):= lambda n: lambda c: (c (v) (l))

NIL = lambda n: lambda c: n

CONS = lambda v: lambda l: lambda n: lambda c: (c (v) (l))

# matchl l { NIL -> nc | CONS(v,lr) -> M[v,lr] }

matchl = lambda l: lambda nc: lambda M: \
            (l (nc) (lambda v: lambda lr: (M (v) (lr))))

sumldef = lambda suml:\
            lambda l: \
                matchl (l) \
                    (zero) \
                    (lambda v: lambda r: add (v) (suml (r)))

suml = rec (sumldef)

