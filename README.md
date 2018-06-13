![RadixStringSorter](radixstringsorter.png)
# Radix String Sorter
###### During my Spring 2018 semester at college, I was taking a 2000-level Software Design & Data Structures course. While discussing the selection and insertion sorting algorithms to use for the class' final project, the professor told us that more advanced sorting methods like quicksort and radix sort would be saved for the 3000-level Data Structures course. He seemed particularly amused at the idea of teaching a freshman/sophomore class these algorithms, especially radix sort - so, I decided to learn and use it in a project of my own.

## Introduction
The purpose of this program is to provide the user a tool for sorting strings (words) based on the length of their components. Components are defined by the user's desired delimiter, which is what separates each word sequence. 

For example: `This,is,a,comma,separated,value,example` yields `This is a comma separated value example` when using a comma as a delimiter. 

Additionally, the user is given the choice of displaying text either separated by the newline character `\n` or by the generic space character. This provides visual aid to more easily discern the difference between shorter and longer character sequences.

## Application
While the development of this program was mostly for personal learning and development, there are still potential applications such as:

- Pattern recognition
- Indexing
- Evaluation of reading level complexity

And more, considering the delimiter choices supplied to the client.

## System requirements
- Java SE 8 or greater
- Not a potato

## Installation & accessing code files
Installation is as simple as downloading the .zip file, extracting its contents, and running the included `Radix String Sorter.jar` file. 
To access the code files for editing, import them into your favorite Java-supported IDE from the `/src/` folder.

## Potential future revisions
1. Give user choice of what sorting algorithm to use and a corresponding performance report based on array accesses
2. Compare feature using graphs to show the difference in performance between sorting algorithms
3. Desort feature, replacing sorted input with the original input
