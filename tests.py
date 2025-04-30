from churchnumerals import *
from booleans import *
from peanonumerals import *
from recursor import *
from pairs import *
from lists import *

### TESTS FOR CHURCH NUMERALS

print (cfour (1) (lambda x: x*5) )

# 625

print (c2int (cadd (int2c (20)) (int2c (5))))

#25

print (c2int (cmul (int2c (4)) (int2c (5))))

#20

print (c2int (cpow (int2c (2)) (int2c (10))))

#1024


print (cfour (1) (lambda x: x*5) )

# 1

print (c2int(int2c(19)))

#19

pcnat (cadd (cfour) (cfour) )

pcnat (cmul (cfour) (cfour) )

pcnat (cpow (cfour) (cfour) )

pcnat = lambda n: print (n ("Z") (lambda n: "1"+n))

pcnat (cadd (cfour) (cfour) )

pcnat (cmul (cfour) (cfour) )

pcnat (cpow (cfour) (cfour) )

### TESTS FOR BOOLEANS

print (b2str (true))

# TRUE

print (b2str (false))

# FALSE

### TESTS FOR PEANO NUMERALS


print ( p2int (int2p(16)) )

#16

print( pnat (succ(succ(zero))) )
# 2

print( pnat (int2p(40)) )

print( pnat (pred (int2p(22))) )

print( p2int (add (int2p(45)) (int2p(32))) )

# 77

print( p2int (add (int2p(15)) (int2p(10))) )

# 25

print( p2int (mul (int2p(8)) (int2p(3))) )

# 24

### TESTS FOR PAIRS

p0 = (pair (czero) (cone))

print (c2int (fst (p0)))
# 0

print (c2int (snd (p0)))

# 1

### TESTS FOR LISTS

l0 = CONS (two) (CONS (one) (CONS (two) (NIL)))

# l0 = [2,1,2]

print (p2int(suml (l0)))

# 5
