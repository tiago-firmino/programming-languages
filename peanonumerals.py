from recursor import *

# Zero := lambda x: lambda f: x
# Succ n := lambda x: lambda f: (f (n) )

zero = lambda x: lambda f: x
succ = lambda n: lambda x: lambda f: (f (n) )

# matchz n { Z -> t | Succ x -> e[x] }

matchz = lambda n: lambda z: lambda s: \
            (n (z) (lambda prd: ( s (prd) )))

pred = lambda n: (matchz (n) (zero) (lambda x: x))

def int2p(n):
    if n==0:
        return zero
    else:
        return succ (int2p(n-1))    

p2int = lambda n: \
            (matchz (n)\
                (0) \
                (lambda x: (1 + (p2int (x)))))

pp2intd = lambda f:\
            lambda x: \
                    (matchz (x)\
                        (0) \
                        (lambda s: (1+(f (s)))))

pnat = rec (pp2intd)

one = int2p(1)
two = int2p(2)

adddef = lambda add: \
        lambda a: lambda b: \
            (matchz (a) \
                (b) \
                (lambda s: (succ(add (s) (b)))))

add = rec (adddef)

muldef = lambda f: \
            lambda a: lambda b: \
                (matchz (a) \
                    (zero) \
                    (lambda s: (add (f (s) (b)) (b))))

mul = rec (lambda mul_r: \
            lambda a: lambda b: \
                (matchz (a) \
                    (zero) \
                    (lambda p: (add (mul_r (p) (b)) (b))))) 
