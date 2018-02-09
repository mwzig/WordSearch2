# Word Search

## Contents
1.  [About](#1-about)
2.  [Installation](#2-installation)
3.  [Usage](#3-usage)
4.  [Options](#4-options)
5.  [Sample Output](#5-sample-output)
6.  [Sample Output with print input option](#6-sample-output-with-print-input-option)
7.  [Design Overview](#7-design-overview)

## 1. About
Welcome to my word search application.  This application takes as input a file that contains a list of words to find and a letter grid in which to find the words. The program then prints out a list of the words found and their coordinates in the grid.  (If the grid does not contain all of the words to find, the application also prints out the words not found.  Additionally, the application will optionally print out the input).

This application was created to conform to the following Kata: 
https://github.com/PillarTechnology/kata-word-search
(Note - those instructions have sample output that contains coordinates that appear to have
x and y coordinates reversed.  For purposes of my application, the x-coordinate (the row number), appears first, and the y-coordinate (the column number), appears second). 

## 2. Installation
Clone the repository:
```
    git clone https://github.com/mwzig/WordSearch2.git
```
Build with gradle:
```bash
    cd WordSearch2 && gradle build
```

## 3.  Usage
The input file must be formatted as per the example input files supplied with this application.
(These are found in Resources:  HealthyFoodWordSearch.txt, JunkFoodWordSearch.txt, PillarExampleWordSearch.txt and WordSearchWithWordsNotFound.txt).
These files specify the words to find on the first line, and then supply a letter grid that has letters separated by spaces or commas (with an equal number of rows and columns in the grid).

To run this application from the command line (on Windows) go to the WordSearch2 directory.  Enter the following:

`
java -cp ./bin/main wordsearch.WordSearch HealthyFoodWordSearch.txt 
`

The first parameter is the filename.  It must exist in the Resources directory, or you may specify a fully qualified file name as follows:

`
java -cp ./bin/main wordsearch.WordSearch c:/users/mary/Projects2018/WordSearch2/Resources/HealthyFoodWordSearch.txt
`

## 4.  Options
The second parameter is optional. If "true" is specified, the application will print out the input data.

`
java -cp ./bin/main wordsearch.WordSearch HealthyFoodWordSearch.txt true
`

`
java -cp ./bin/main wordsearch.WordSearch c:/users/mary/Projects2018/WordSearch2/Resources/HealthyFoodWordSearch.txt true
`

## 5. Sample Output

```
    APPLES: (5,14),(5,15),(5,16),(5,17),(5,18),(5,19)
    BLUEBERRIES: (0,12),(1,12),(2,12),(3,12),(4,12),(5,12),(6,12),(7,12),(8,12),(9,12),(10,12)
    BROCCOLI: (19,16),(18,15),(17,14),(16,13),(15,12),(14,11),(13,10),(12,9)
    CARROTS: (7,3),(6,4),(5,5),(4,6),(3,7),(2,8),(1,9)
    KALE: (6,13),(7,14),(8,15),(9,16)
    PINEAPPLE: (6,8),(6,7),(6,6),(6,5),(6,4),(6,3),(6,2),(6,1),(6,0)
    SPINACH: (6,16),(5,16),(4,16),(3,16),(2,16),(1,16),(0,16)
    WATERMELON: (0,15),(1,14),(2,13),(3,12),(4,11),(5,10),(6,9),(7,8),(8,7),(9,6)
```


## 6. Sample Output with print input option

```
    [APPLES, BLUEBERRIES, BROCCOLI, CARROTS, KALE, PINEAPPLE, SPINACH, WATERMELON]
    PHEOQYBUNXSEBLDWHBJN
    LDLKIXXZCSGMLVAXCYYY
    OMJXZJIHTMLVUTAVAUTM
    XKPJLSFOBYSBEHBANNZA
    KQCNLWRGQQJRBEAGIGMQ
    FHUILRYDXBMDELAPPLES
    ELPPAENIPELMRKCISTVQ
    IDSCFDKDLBBGRVAPDPMX
    XMNVYAGOBJRUIKRLTQQV
    GMDNWYNGWBYOECXCEQUM
    JSCIDBHFIGRBSUXRNGKC
    ZYDRZAZAMAURWKHGURLI
    PNLZSETCJIJUNWZBSNLP
    PLCQQDZLCOLSLQLTSGSS
    MFKHCLMAHCGOPFMUGNXU
    OXGOFKKELWDDCGHEDJDM
    XYBAQXPHOLQPLCNLKWBP
    TJZRHATODBBQJCORSPHV
    NRTNIWOHVENDHWORVXJI
    DNGTSKTECMARRUJLBJWX
    APPLES: (5,14),(5,15),(5,16),(5,17),(5,18),(5,19)
    BLUEBERRIES: (0,12),(1,12),(2,12),(3,12),(4,12),(5,12),(6,12),(7,12),(8,12),(9,12),(10,12)
    BROCCOLI: (19,16),(18,15),(17,14),(16,13),(15,12),(14,11),(13,10),(12,9)
    CARROTS: (7,3),(6,4),(5,5),(4,6),(3,7),(2,8),(1,9)
    KALE: (6,13),(7,14),(8,15),(9,16)
    PINEAPPLE: (6,8),(6,7),(6,6),(6,5),(6,4),(6,3),(6,2),(6,1),(6,0)
    SPINACH: (6,16),(5,16),(4,16),(3,16),(2,16),(1,16),(0,16)
    WATERMELON: (0,15),(1,14),(2,13),(3,12),(4,11),(5,10),(6,9),(7,8),(8,7),(9,6)
```

## 7. Design Overview

This application uses six classes:
`WordSearch`, `Grid`, `GridLetter`, `LocCoordinate`, `GridLine`, and `FoundWord`.

The `WordSearch` class is the main driving class of the application.  It reads the input file and creates a `Grid` object.  The `Grid` object represents the letter grid where the application looks for the words to find.
  
The `Grid` object contains a two dimensional array of `GridLetter` objects (to represent multiple rows of letters in the word search grid).  A `GridLetter` object represents one letter in the grid - it has a character for the letter, and a `LocCoordinate` object to represent the x,y coordinates of the letter in the `Grid`.

The `Grid` object uses that array to create  an ArrayList of `GridLine` objects.  A `GridLine` represents the string of letters found moving horizontally, vertically, or diagonally across the lines in the `Grid`.  Thus, the `GridLine` object contains the string of letters for that line, and it also contains an ArrayList of the `LocCoordinate` objects for the letters in that string.  Since we can search from right to left, the `GridLine`s also contain the reverse string for each line.

The `WordSearch` object then uses the list of words to find, and for each word it searches each `GridLine` in the `Grid` object's ArrayList of `GridLine`s.  If it finds the word, it creates a `FoundWord` object that contains a String representing the word found, and an ArrayList of `LocCoordinate` objects for each of the letters in the word found.

When the `WordSearch` object finishes searching the grid, it iterates through its ArrayList of `FoundWord` objects, and it then prints out the word found and its coordinates in the grid.  (It also prints any words not found).  

