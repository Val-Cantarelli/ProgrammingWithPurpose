See the Assessment Guide for information on how to interpret this report.

ASSESSMENT SUMMARY

Compilation:  PASSED
API:          PASSED

SpotBugs:     FAILED (1 warning)
PMD:          FAILED (1 warning)
Checkstyle:   FAILED (0 errors, 5 warnings)

Correctness:  27/34 tests passed
Memory:       2/2 tests passed
Timing:       51/51 tests passed

Aggregate score: 87.65%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 60% , Timing: 10% , Memory: 20% ]

ASSESSMENT DETAILS

The following files were submitted:
----------------------------------
2.2K Jul 15 15:46 Clock.java
1.9K Jul 15 15:46 ColorHSB.java


********************************************************************************
*  COMPILING
********************************************************************************


% javac ColorHSB.java
*-----------------------------------------------------------

% javac Clock.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
ColorHSB:

Clock:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS
********************************************************************************


% spotbugs *.class
*-----------------------------------------------------------
M C LEST_LOST_EXCEPTION_STACK_TRACE LEST: Method new Clock(String) throws alternative exception from catch block without history  At Clock.java:[line 17]
SpotBugs ends with 1 warning.


================================================================


% pmd .
*-----------------------------------------------------------
Clock.java:17: New exception is thrown in catch block, original stack trace may be lost [PreserveStackTrace]
PMD ends with 1 warning.


================================================================


% checkstyle *.java
*-----------------------------------------------------------

% custom checkstyle checks for ColorHSB.java
*-----------------------------------------------------------
[WARN] ColorHSB.java:11:18: '359' looks like an unnecessary constant. [MagicNumber]
[WARN] ColorHSB.java:22:27: '1000' looks like an unnecessary constant. [MagicNumber]
Checkstyle ends with 0 errors and 2 warnings.

% custom checkstyle checks for Clock.java
*-----------------------------------------------------------
[WARN] Clock.java:1:1: '23' is an unnecessary numeric literal because it is derived from the number of hours per day (24) or the number of minutes per hour (60). [NumericLiteralCount]
[WARN] Clock.java:1:1: '59' is an unnecessary numeric literal because it is derived from the number of hours per day (24) or the number of minutes per hour (60). [NumericLiteralCount]
[WARN] Clock.java:1:1: The numeric literal '60' appears 3 times. Define a constant variable (such as 'MINUTES_PER_HOUR'). [NumericLiteralCount]
Checkstyle ends with 0 errors and 3 warnings.


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of ColorHSB
*-----------------------------------------------------------
Running 17 total tests.

Test 1a: construct a ColorHSB object and call toString()
* (25, 84, 97)
* (0, 0, 0)
* (359, 100, 100)
  ==> passed

Test 1b: construct random ColorHSB objects and call toString()
* h <= 359, s <= 100, b <= 100
* h <=  60, s <=  10, b <=  10
  ==> passed

Test 2a: construct a ColorHSB object and call isGrayscale()
* (25, 84, 97)
* (0, 0, 0)
* (0, 50, 0)
* (0, 0, 50)
* (359, 100, 100)
  ==> passed

Test 2b: construct random ColorHSB objects and call isGrayscale()
* h <= 359, s <= 100, b <= 100
* h  =   0, s <= 100, b <= 100
* h <= 359, s  =   0, b <= 100
* h <= 359, s <= 100, b  =   0
* h <= 359, s  =   0, b  =   0
* h <=  10, s <=  10, b <=  10
  ==> passed

Test 3a: construct two ColorHSB objects and call distanceSquaredTo()
* (350, 100, 45) to (0, 100, 50)
* (25, 84, 97) to (0, 100, 100)
* (25, 84, 97) to (26, 85, 96)
* (180, 100, 100) to (0, 0, 0)
  ==> passed

Test 3b: construct random pairs of ColorHSB objects and call distanceSquaredTo()
* h <= 359, s <= 100, b <= 100
* h <=  60, s <=  10, b <=  10
* h <= 359, s <= 100, b  =   0
* h <= 359, s  =   0, b <= 100
* h  =   0, s <= 100, b <= 100
  ==> passed

Test 3c: construct random pairs of ColorHSB objects and check that
distanceSquaredTo() is symmetric
* h <= 359, s <= 100, b <= 100
* h <=  60, s <=  10, b <=  10
* h <= 359, s <= 100, b  =   0
* h <= 359, s  =   0, b <= 100
* h  =   0, s <= 100, b <= 100
  ==> passed

Test 4: create two ColorHSB objects and call the methods isGrayscale(),
toString(), and distanceSquaredTo() with probabilities (p1, p2, p3)
and check that they return the same values in each call
* 100 random calls (0.8, 0.1, 0.1)
* 100 random calls (0.8, 0.1, 0.1)
* 100 random calls (0.1, 0.8, 0.1)
* 100 random calls (0.1, 0.8, 0.1)
* 100 random calls (0.1, 0.1, 0.8)
* 100 random calls (0.1, 0.1, 0.8)
  ==> passed

Test 5a: check formatting of main() for inputs from exam specification
% java-introcs ColorHSB 25 84 97 < web.txt
Red (0, 100, 100)

% java-introcs ColorHSB 350 100 45 < web.txt
Maroon (0, 100, 50)

% java-introcs ColorHSB 25 84 97 < wiki.txt
Princeton_Orange (26, 85, 96)

==> passed

Test 5b: check that main() reads all data from standard input
* java-introcs ColorHSB 25 84 97 < web.txt
* java-introcs ColorHSB 350 100 45 < web.txt
* java-introcs ColorHSB 25 84 97 < wiki.txt
  ==> passed

Test 5c: check correctness of main() for inputs from exam specification
* java-introcs ColorHSB 25 84 97 < web.txt
* java-introcs ColorHSB 350 100 45 < web.txt
* java-introcs ColorHSB 25 84 97 < wiki.txt
  ==> passed

Test 6: check main() computes closest color
* web.txt
    - student prints a name that is not a pre-defined color
    - student   color name = ""
    - reference color name = "Black"

    - student prints invalid HSB values
    - student   hue        = [unable to parse]
    - student   saturation = [unable to parse]
    - student   brightness = [unable to parse]
    - command-line arguments: 50 25 7

    - standard input:
      White     0   0 100
      Silver    0   0  75
      Gray      0   0  50
      Black     0   0   0
      Red       0 100 100
      Maroon    0 100  50
      .
      .
      .
      Teal    180 100  50
      Blue    240 100 100
      Navy    240 100  50
      Fuchsia 300 100 100
      Purple  300 100  50

    - failed on trial 2 of 1000

* crayola.txt
    - student prints a name that is not a pre-defined color
    - student   color name = ""
    - reference color name = "Green"

    - student prints invalid HSB values
    - student   hue        = [unable to parse]
    - student   saturation = [unable to parse]
    - student   brightness = [unable to parse]
    - command-line arguments: 113 99 61

    - standard input:
      Red                       346  96  93
      Maroon                    346  83  76
      Scarlet                   350  94  99
      Brick_Red                 352  77  78
      English_Vermilion         358  65  80
      Madder_Lake               359  75  80
      .
      .
      .
      Mahogany                    0  74  79
      Peach                      26  36 100
      Sepia                      17  59  62
      Tan                        25  50  85
      White                       0   0 100

    - failed on trial 7 of 1000

* wiki.txt
  ==> FAILED


Tests 7a to 10 test that main() computes the closest color with respect
to the student's distanceSquaredTo() method, even if that method returns
incorrect values.

Test 7a: check main() with random command-line arguments
* web.txt
    - student prints a name that is not a pre-defined color
    - student   color name = ""
    - reference color name = "Black"

    - student prints invalid HSB values
    - student   hue        = [unable to parse]
    - student   saturation = [unable to parse]
    - student   brightness = [unable to parse]
    - command-line arguments: 54 17 21

    - standard input:
      White     0   0 100
      Silver    0   0  75
      Gray      0   0  50
      Black     0   0   0
      Red       0 100 100
      Maroon    0 100  50
      .
      .
      .
      Teal    180 100  50
      Blue    240 100 100
      Navy    240 100  50
      Fuchsia 300 100 100
      Purple  300 100  50

    - failed on trial 2 of 1000

* crayola.txt
    - student prints a name that is not a pre-defined color
    - student   color name = ""
    - reference color name = "Maximum_Green"

    - student prints invalid HSB values
    - student   hue        = [unable to parse]
    - student   saturation = [unable to parse]
    - student   brightness = [unable to parse]
    - command-line arguments: 105 64 24

    - standard input:
      Red                       346  96  93
      Maroon                    346  83  76
      Scarlet                   350  94  99
      Brick_Red                 352  77  78
      English_Vermilion         358  65  80
      Madder_Lake               359  75  80
      .
      .
      .
      Mahogany                    0  74  79
      Peach                      26  36 100
      Sepia                      17  59  62
      Tan                        25  50  85
      White                       0   0 100

    - failed on trial 1 of 1000

* wiki.txt
    - student prints a name that is not a pre-defined color
    - student   color name = ""
    - reference color name = "Yankees_Blue"

    - student prints invalid HSB values
    - student   hue        = [unable to parse]
    - student   saturation = [unable to parse]
    - student   brightness = [unable to parse]
    - command-line arguments: 244 67 5

    - standard input:
      Absolute_Zero                           217 100  73
      Acid_Green                               65  86  75
      Aero                                    206  47  91
      Aero_Blue                               151  21 100
      African_Violet                          288  31  75
      Air_Force_Blue_RAF                      204  45  66
      .
      .
      .
      Yellow_Rose                              56 100 100
      Yellow_Sunshine                          58 100 100
      Zaffre                                  233 100  66
      Zinnwaldite_Brown                        23  82  17
      Zomp                                    166  66  65

    - failed on trial 38 of 100

==> FAILED

Test 7b: check main() with random input files
* random input files with 10 pre-defined colors
    - student prints a name that is not a pre-defined color
    - student   color name = ""
    - reference color name = "Color_09"

    - student prints invalid HSB values
    - student   hue        = [unable to parse]
    - student   saturation = [unable to parse]
    - student   brightness = [unable to parse]
    - command-line arguments: 142 52 37

    - standard input:
      Color_01   224  25  15
      Color_02    67  76  59
      Color_03   226  55  60
      Color_04   336  97  84
      Color_05    94  15  56
      Color_06   291  94  15
      Color_07    85  63  14
      Color_08   227   1  29
      Color_09   157  26   5
      Color_10    87  88  87

    - failed on trial 1 of 1000

* random input files with 20 pre-defined colors
    - student prints a name that is not a pre-defined color
    - student   color name = ""
    - reference color name = "Color_16"

    - student prints invalid HSB values
    - student   hue        = [unable to parse]
    - student   saturation = [unable to parse]
    - student   brightness = [unable to parse]
    - command-line arguments: 126 48 14

    - standard input:
      Color_01   162  57  70
      Color_02   159  71  68
      Color_03    31  34  26
      Color_04   180  69  74
      Color_05   276  64  89
      Color_06   123  51  91
      .
      .
      .
      Color_16   150  89  23
      Color_17   161  80  94
      Color_18   277  71  94
      Color_19    94  25  94
      Color_20   293  63   5

    - failed on trial 5 of 1000

* random input files with 2 pre-defined colors
    - student prints a name that is not a pre-defined color
    - student   color name = ""
    - reference color name = "Color_01"

    - student prints invalid HSB values
    - student   hue        = [unable to parse]
    - student   saturation = [unable to parse]
    - student   brightness = [unable to parse]
    - command-line arguments: 236 69 67

    - standard input:
      Color_01   273  50  87
      Color_02    33  27  71

    - failed on trial 1 of 1000

* random input files with 1 pre-defined color
    - student prints a name that is not a pre-defined color
    - student   color name = ""
    - reference color name = "Color_01"

    - student prints invalid HSB values
    - student   hue        = [unable to parse]
    - student   saturation = [unable to parse]
    - student   brightness = [unable to parse]
    - command-line arguments: 23 12 86

    - standard input:
      Color_01    15  66  49

    - failed on trial 1 of 1000

==> FAILED

Test 8: check main() with ties possible for closest color
* wiki.txt
    - student prints a name that is not a pre-defined color
    - student   color name = ""
    - reference color name = "Black_Olive"

    - student prints invalid HSB values
    - student   hue        = [unable to parse]
    - student   saturation = [unable to parse]
    - student   brightness = [unable to parse]
    - command-line arguments: 39 5 4

    - standard input:
      Absolute_Zero                           217 100  73
      Acid_Green                               65  86  75
      Aero                                    206  47  91
      Aero_Blue                               151  21 100
      African_Violet                          288  31  75
      Air_Force_Blue_RAF                      204  45  66
      .
      .
      .
      Yellow_Rose                              56 100 100
      Yellow_Sunshine                          58 100 100
      Zaffre                                  233 100  66
      Zinnwaldite_Brown                        23  82  17
      Zomp                                    166  66  65

    - failed on trial 2 of 100

* grayscale.txt
    - student prints a name that is not a pre-defined color
    - student   color name = ""
    - reference color name = "Gray_4"

    - student prints invalid HSB values
    - student   hue        = [unable to parse]
    - student   saturation = [unable to parse]
    - student   brightness = [unable to parse]
    - command-line arguments: 50 4 4

    - standard input:
      Gray_0  0  0   0
      Gray_1  0  0   1
      Gray_2  0  0   2
      Gray_3  0  0   3
      Gray_4  0  0   4
      Gray_5  0  0   5
      .
      .
      .
      Gray_96  0  0  96
      Gray_97  0  0  97
      Gray_98  0  0  98
      Gray_99  0  0  99
      Gray_100  0  0 100

    - failed on trial 1 of 1000

* random input files with 10 pre-defined colors
* random input files with 20 pre-defined colors
  ==> FAILED

Test 9: check main() with large input files
* random input files with 2000 pre-defined colors
* random input files with 5000 pre-defined colors
* random input files with 10000 pre-defined colors
  ==> passed

Test 10: check main() when distance is very large
* colors1.txt
    - student prints a name that is not a pre-defined color
    - student   color name = ""
    - reference color name = "Aqua"

    - student prints invalid HSB values
    - student   hue        = [unable to parse]
    - student   saturation = [unable to parse]
    - student   brightness = [unable to parse]
    - command-line arguments: 2 1 6

    - standard input:
      Aqua  180 100 100

    - failed on trial 1 of 50

* colors8.txt
    - student prints a name that is not a pre-defined color
    - student   color name = ""
    - reference color name = "Aqua_5"

    - student prints invalid HSB values
    - student   hue        = [unable to parse]
    - student   saturation = [unable to parse]
    - student   brightness = [unable to parse]
    - command-line arguments: 4 1 4

    - standard input:
      Aqua_0  180 100 100
      Aqua_1  180 100  99
      Aqua_2  180  99 100
      Aqua_3  180  99  99
      Aqua_4  179 100 100
      Aqua_5  179  99 100
      Aqua_6  179 100  99
      Aqua_7  181 100 100

    - failed on trial 1 of 50

* colors10.txt
    - student prints a name that is not a pre-defined color
    - student   color name = ""
    - reference color name = "Aqua_8"

    - student prints invalid HSB values
    - student   hue        = [unable to parse]
    - student   saturation = [unable to parse]
    - student   brightness = [unable to parse]
    - command-line arguments: 315 67 91

    - standard input:
      Aqua_0  180 100 100
      Aqua_1  180 100  99
      Aqua_2  180  99 100
      Aqua_3  180  99  99
      Aqua_4  179 100 100
      Aqua_5  179  99 100
      Aqua_6  179 100  99
      Aqua_7  181 100 100
      Aqua_8  181  99 100
      Aqua_9  181 100  99

    - failed on trial 1 of 50

==> FAILED

Total: 12/17 tests passed!


================================================================
Testing correctness of Clock
*-----------------------------------------------------------
Running 17 total tests.

Test 1a: construct a Clock object; check formatting of toString()
* hours = 11, minutes = 59
* hours =  3, minutes = 30
* hours = 16, minutes =  5
* hours =  0, minutes =  0
* hours = 23, minutes = 59
  ==> passed

Test 1b: construct random Clock objects; check formatting of toString()
* 10000 trials with 10 <= hours < 24, 10 <= minutes < 60
* 10000 trials with  0 <= hours < 24, 10 <= minutes < 60
* 10000 trials with 10 <= hours < 24,  0 <= minutes < 60
* 10000 trials with  0 <= hours < 24,  0 <= minutes < 60
  ==> passed

Test 2a: construct a Clock object; check toString()
* hours = 11, minutes = 59
* hours =  3, minutes = 30
* hours =  0, minutes =  0
* hours = 23, minutes = 59
  ==> passed

Test 2b: construct random Clock objects; check toString()
* 10000 trials with 10 <= hours < 24, 10 <= minutes < 60
* 10000 trials with  0 <= hours < 24, 10 <= minutes < 60
* 10000 trials with 10 <= hours < 24,  0 <= minutes < 60
* 10000 trials with  0 <= hours < 24,  0 <= minutes < 60
  ==> passed

Test 3: construct two random Clock objects; check isEarlierThan()
* 10000 trials (earlier)
* 10000 trials (later)
* 10000 trials (equal)
* 10000 trials (reference equal)
  ==> passed

Test 4a: construct a Clock object; call tic(); check toString()
* hours = 12, minutes = 34
* hours =  3, minutes = 30
* hours =  0, minutes =  0
* hours = 23, minutes =  0
  ==> passed

Test 4b: construct a Clock object; call tic(); check toString()
* hours =  0, minutes = 59
* hours =  1, minutes = 59
* hours =  2, minutes = 59
* hours = 11, minutes = 59
* hours = 12, minutes = 59
* hours = 22, minutes = 59
* hours = 23, minutes = 59
  ==> passed

Test 4c: construct random Clock objects; call tic(); check toString()
* 10000 trials with 10 <= hours < 23, 10 <= minutes < 59
* 10000 trials with  0 <= hours < 23, 10 <= minutes < 59
* 10000 trials with 10 <= hours < 23,  0 <= minutes < 59
* 10000 trials with  0 <= hours < 24,  0 <= minutes < 60
  ==> passed

Test 5a: construct a Clock object; call toc(); check toString()
* hours = 12, minutes = 34, delta = 5
* hours =  3, minutes = 30, delta = 10
* hours =  0, minutes =  0, delta = 45
* hours = 23, minutes =  0, delta = 1
* hours = 23, minutes =  0, delta = 0
  ==> passed

Test 5b: construct a Clock object; call toc(); check toString()
* hours =  0, minutes = 59, delta = 10
* hours =  1, minutes = 59, delta = 60
* hours =  2, minutes = 59, delta = 1
* hours = 11, minutes = 59, delta = 45
* hours = 12, minutes = 59, delta = 120
* hours = 22, minutes = 59, delta = 1440
* hours = 23, minutes = 59, delta = 100
* hours =  0, minutes =  0, delta = 30000
  ==> passed

Test 5c: construct random Clock objects; call toc(); check toString()
* 10000 trials with 10 <= hours < 23, 10 <= minutes < 59,  0 <= delta < 60
* 10000 trials with  0 <= hours < 23, 10 <= minutes < 59,  0 <= delta < 60
* 10000 trials with 10 <= hours < 23,  0 <= minutes < 59,  0 <= delta < 60
* 10000 trials with  0 <= hours < 24,  0 <= minutes < 60,  0 <= delta < 60
* 10000 trials with  0 <= hours < 24,  0 <= minutes < 60,  0 <= delta < 1440
* 10000 trials with  0 <= hours < 24,  0 <= minutes < 60,  0 <= delta < 14400
  ==> passed

Test 6a: construct random Clock objects with 1-argument constructor; check toString()
* time = 11:59
* time = 03:30
* time = 16:05
* time = 00:00
* time = 23:59
  ==> passed

Test 6b: construct random Clock objects with 1-argument constructor; check toString()
* 10000 trials with 10 <= hours < 24, 10 <= minutes < 60
* 10000 trials with  0 <= hours < 24, 10 <= minutes < 60
* 10000 trials with 10 <= hours < 24,  0 <= minutes < 60
* 10000 trials with  0 <= hours < 24,  0 <= minutes < 60
  ==> passed

Test 7: check two-argument constructor with invalid arguments
* hours = 24, minutes =  0
* hours = 24, minutes = 60
* hours =  0, minutes = 60
* hours = -1, minutes = 30
* hours = 12, minutes = -1
* hours =  0, minutes = -1
* hours = -1, minutes = -1
* hours = 59, minutes = 23
* hours = -2147483648, minutes = -2147483648
* hours = -2147483648, minutes = 2147483647
* hours = 2147483647, minutes = -2147483648
* hours = 2147483647, minutes = 2147483647
  ==> passed

Test 8: check 1-argument constructor with invalid arguments
* time = "24:00"
* time = "25:10"
* time = "12:60"
* time = "12:060"
* time = "12:100"
* time = "2:56"
* time = "2:5"
* time = "02:5"
* time = "0:0"
* time = "00007:23"
* time = "07:000023"
* time = "12,34"
* time = "1234"
* time = "HH:MM"
* time = "0"

  java.lang.StringIndexOutOfBoundsException: String index out of range: 2

  java.base/java.lang.StringLatin1.charAt(StringLatin1.java:47)
  java.base/java.lang.String.charAt(String.java:728)
  Clock.<init>(Clock.java:9)
  TestClock.checkOneArgumentConstructorInvalidArguments(TestClock.java:152)
  TestClock.test8(TestClock.java:1040)
  TestClock.main(TestClock.java:1195)

    - throws an exception, but not an IllegalArgumentException

* time = ""

  java.lang.StringIndexOutOfBoundsException: String index out of range: 2

  java.base/java.lang.StringLatin1.charAt(StringLatin1.java:47)
  java.base/java.lang.String.charAt(String.java:728)
  Clock.<init>(Clock.java:9)
  TestClock.checkOneArgumentConstructorInvalidArguments(TestClock.java:152)
  TestClock.test8(TestClock.java:1041)
  TestClock.main(TestClock.java:1195)

    - throws an exception, but not an IllegalArgumentException

* time = "-12:34"
* time = "0x06:34"
* time = " 12:34"
* time = "12:34 "
* time = ":1234"
* time = "1:234"
* time = "123:4"
* time = "1234:"
* time = "12345"
  ==> FAILED

Test 9: construct Clock with 2-argument constructor; call toc() with negative delta
* hours = 11, minutes = 59, delta = -1
* hours = 23, minutes = 59, delta = -5
* hours =  1, minutes = 23, delta = -10
* hours = 16, minutes = 45, delta = -100
* hours = 12, minutes =  0, delta = -1440
* hours = 21, minutes = 30, delta = -14400
* hours = 17, minutes = 18, delta = -2147483648
  ==> passed

Test 10: create two Clock objects from 2-argument constructor; check random
intermixed sequence of calls to toString(), isEarlierThan(), tic(),
and toc(), with probabilities (p1, p2, p3, p4), respectively
* p = (0.5, 0.5, 0.0, 0.0)
* p = (0.5, 0.0, 0.5, 0.0)
* p = (0.5, 0.0, 0.0, 0.5)
* p = (0.0, 0.5, 0.5, 0.0)
    - failed on operation 7 of 1000
    - student   isEarlierThan() = false
    - reference isEarlierThan() = true
    - student   clock1          = "00:00"
    - student   clock2          = "23:55"
    - reference clock1          = "00:00"
    - reference clock2          = "23:55"
    - sequence of Clock operations was:
      Clock clock1 = new Clock(23, 55)
      clock1.tic()
      clock1.isEarlierThan(clock2)  ==> false
      clock1.tic()
      clock1.tic()
      clock1.tic()
      clock1.tic()
      clock1.isEarlierThan(clock2)  ==> false

    - failed on trial 1 of 100

* p = (0.0, 0.5, 0.0, 0.5)
    - failed on operation 12 of 1000
    - student   isEarlierThan() = false
    - reference isEarlierThan() = true
    - student   clock1          = "02:04"
    - student   clock2          = "23:58"
    - reference clock1          = "02:04"
    - reference clock2          = "23:58"
    - sequence of Clock operations was:
      Clock clock1 = new Clock(23, 58)
      Clock clock2 = new Clock(23, 58)
      clock1.isEarlierThan(clock2)  ==> false
      clock1.isEarlierThan(clock2)  ==> false
      clock1.isEarlierThan(clock2)  ==> false
      clock1.isEarlierThan(clock2)  ==> false
      clock1.isEarlierThan(clock2)  ==> false
      clock1.isEarlierThan(clock2)  ==> false
      clock1.isEarlierThan(clock2)  ==> false
      clock1.isEarlierThan(clock2)  ==> false
      clock1.isEarlierThan(clock2)  ==> false
      clock1.isEarlierThan(clock2)  ==> false
      clock1.toc(126)
      clock1.isEarlierThan(clock2)  ==> false

    - failed on trial 1 of 100

* p = (0.2, 0.2, 0.3, 0.3)
    - failed on operation 33 of 1000
    - student   isEarlierThan() = false
    - reference isEarlierThan() = true
    - student   clock1          = "01:23"
    - student   clock2          = "07:38"
    - reference clock1          = "01:23"
    - reference clock2          = "07:38"

    - failed on trial 1 of 100

* p = (0.2, 0.2, 0.3, 0.3)
    - failed on operation 26 of 1000
    - student   isEarlierThan() = true
    - reference isEarlierThan() = false
    - student   clock1          = "18:49"
    - student   clock2          = "07:12"
    - reference clock1          = "18:49"
    - reference clock2          = "07:12"

    - failed on trial 1 of 100

==> FAILED

Total: 15/17 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of ColorHSB
*-----------------------------------------------------------
Running 1 total tests.

Test 1: Memory usage per ColorHSB object
* number bytes used by student   ColorHSB object = 32
* number bytes used by reference ColorHSB object = 32
  ==> passed

Total: 1/1 tests passed!


================================================================



Analyzing memory of Clock
*-----------------------------------------------------------
Running 1 total tests.

Test 1: Memory usage per Clock object
* number bytes used by student   Clock object = 24
* number bytes used by reference Clock object = 24
  ==> passed

Total: 1/1 tests passed!


================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing Clock
*-----------------------------------------------------------
Running 51 total tests.

Test 1: create n Clock object; call toString() n times

                    n  seconds
----------------------------------
=> passed        1000     0.01
=> passed        2000     0.01
=> passed        4000     0.02
=> passed        8000     0.03
=> passed       10000     0.04
=> passed       20000     0.07
=> passed       40000     0.12
=> passed       80000     0.11
=> passed      100000     0.09
=> passed      200000     0.15

==> 10/10 tests passed


Test 2: create n Clock object; call isEarlierThan() n^2 times

                    n  seconds
----------------------------------
=> passed         100     0.00
=> passed         200     0.00
=> passed         400     0.00
=> passed         800     0.00
=> passed        1000     0.00
=> passed        2000     0.00
=> passed        4000     0.01
=> passed        8000     0.05
=> passed       10000     0.08

==> 9/9 tests passed


Test 3: create a Clock object; call tic() n times

                    n  seconds
----------------------------------
=> passed        1000     0.00
=> passed        2000     0.00
=> passed        4000     0.00
=> passed        8000     0.00
=> passed       10000     0.00
=> passed       20000     0.00
=> passed       40000     0.00
=> passed       80000     0.00
=> passed      100000     0.00
=> passed      200000     0.00
=> passed      400000     0.00
=> passed      800000     0.00
=> passed     1000000     0.00
=> passed     2000000     0.00
=> passed     4000000     0.00
=> passed     8000000     0.00

==> 16/16 tests passed


Test 4: create a Clock object; call toc(n) n times

                    n  seconds
----------------------------------
=> passed        1000     0.00
=> passed        2000     0.00
=> passed        4000     0.00
=> passed        8000     0.00
=> passed       10000     0.00
=> passed       20000     0.00
=> passed       40000     0.00
=> passed       80000     0.00
=> passed      100000     0.00
=> passed      200000     0.00
=> passed      400000     0.00
=> passed      800000     0.00
=> passed     1000000     0.00
=> passed     2000000     0.00
=> passed     4000000     0.00
=> passed     8000000     0.00
==> 16/16 tests passed


Total: 51/51 tests passed!


================================================================



