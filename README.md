# 4JPM
Tech test - Daily Trade Reporting Engine

This reporting engine has 3 dependencies to external jars. 2 dependencies are for tests and 1 for compile time,
this means that there is NO RUN TIME DEPENDENCY to any library.

I choose to minimise the exposure of the classes so only the tests are public,
while the 2 classes used in the implementation are package protected

Needless to say that the actual code is exercised from the test and only for the tests because
there is no such real usage for a system that prints some processing done over a fix set of values hardcoded in memory all the time.
In other words I see the Engine and Instruction classes as part of a bigger picture.