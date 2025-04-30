# Church Numerals

czero = lambda x: lambda f: x

csucc = lambda n: \
            lambda x: lambda f: f (n (x) (f))

# conversions 

c2int = lambda n: (n (0) (lambda n: 1+n))

def int2c(n):
    if n==0:
        return lambda x: lambda f: x
    else:
        fp = int2c(n-1)
        return lambda x: lambda f: f(fp (x) (f))

# some constants

czero = int2c(0)
cone = csucc (czero)
ctwo = csucc (cone)
cfour= int2c(4)

# some operations

cadd  = lambda m: lambda n: \
            lambda x: lambda f: n (m (x) (f)) (f)

cmul = lambda m: lambda n: \
            n (czero) (lambda x: (cadd (m) (x)))

cpow = lambda m: lambda n: \
            n (cone) (lambda x: (cmul (m) (x)))

# convert to unary notation

pcnat = lambda n: print (n ("Z") (lambda n: "1"+n))
