![RadixStringSorter](radixstringsorter.png)
# Radix String Sorter
###### During my Spring 2018 semester at college, I was taking a 2000-level Software Design & Data Structures course. While discussing the selection and insertion sorting algorithms to use for the class' final project, the professor told us that more advanced sorting methods like quicksort and radix sort would be saved for the 3000-level Data Structures course. He seemed particularly amused at the idea of teaching a freshman/sophomore class these algorithms, especially radix sort - so, I decided to learn and use it in a project of my own.

## Introduction
The purpose of this program is to provide the user a tool for sorting strings (words) based on the length of their components. Components are defined by the user's desired delimiter, which is what separates each word sequence. 

For example: `This,is,a,comma,separated,value,example` yields `This is a comma separated value example` when using a comma as a delimiter. 

Additionally, the user is given the choice of displaying text either separated by the newline character `\n` or by the generic space character. This provides visual aid to more easily discern the difference between shorter and longer character sequences.

## Application
While the development of this program was mostly for my personal learning of the algorithm, there are still potential applications such as:

- Pattern recognition
- Indexing
- Evaluation of reading level complexity

And more, considering the delimiter choices supplied to the client.

## System requirements
- Java SE 8 or greater
- Not a potato

## Installation & accessing code files
Installation is as simple as downloading the .zip file of this repository, extracting its contents, and running the included `Radix String Sorter.jar` file. 
To access the code files for editing, import them into your favorite Java-supported IDE from the `RadixStringSorter` folder.
If you wish to simply run the program, then downloading the `Runnable JAR` folder will include everything that is required.

## Delimiters
In layman's terms, a delimiter can be defined as the starting and stopping point for a series of data. It is what allows you to gather chunks of a string between certain characters, essentially. For example, each word in `I.like.cheeseburgers.` is delimited by a period.

Included delimiters besides Java's standard whitespace are as following: `.` `,` `|` and `\`. Also included are each of these delimiters formatted such that they include the whitespace after them: `. *` `, *` `| *` and `\ *`.

## Fixes and updates
_**06.13.2018:**_
> Patched bug where Scanner object was not escaping period, quotation, and vertical line delimiters. Result of bug was empty spaces where characters should have existed. Patched by using character sets to escape the delimiters, i.e. `[.] instead of .`

_**06.25.2018:**_
> Replaced recursive sorting method with an iterative version to reduce chances of stack overflow / program hangups. Also added runnable JAR file to same directory as the application's logo so that it will show the logo as an icon of the window.

_**07.24.2018:**_
> Added test cases to repository, gave user the ability to use delimiters with x amount of space after the delimiting character, made the appearance of delimiters in the dropdown menu more user-friendly
