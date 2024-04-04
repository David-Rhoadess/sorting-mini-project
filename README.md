Author: David Rhoades

Purpose: src contains implementations of multiple sorting alrogithms and a test suite

Aknowledgements:
https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Sp/labs/quicksort.html used for a quicksort outline and referenced during implementation

https://www.geeksforgeeks.org/timsort/  Source for the timSort Implementation (called RhoadesDavidSort becuase of assingment requirements). I used ChatGPT to modify the GeeksForGeeks implementation of TimSort to implement Sorter.

Short Essay on online sources:
Initially I asked ChatGPT to write a TimSort implementation. It wrote it seemingly with ease. Impressed, I asked it to adapt its implementation to implement Sorter and pasted in our Sorter defintion. Again, It completed this with ease. Still impressed I pasted the code into VScode which is when I became much less impressed and much less scared about finding a job in the CS field. The code ChatGTP wrote did not even compile, at one point it referenced a variable that it simply never defined. I went back to ChatGTP and informed it that its code did not compile and gave it the line number of the error. It proceeded to not correct the error and make a largely unrelated change. I told it again, this time specifying what I thought the problem was. Again it tried and failed to fix it. After spending some more time fruitlessly troubleshooting, I decided to abandon my ChatGPT code and instead looked elsewhere for a TimSOrt implementation. I found one at https://www.geeksforgeeks.org/timsort/ and spent some time reading through it. I decided to give ChatGPT a chance at redemption and asked it to modify this implementation so implement Sorter and this it was able to do. TimSort is the most advanced and difficult to implement sorting algorithm we have looked at largely becasue it contains InsertionSort and MergeSort within it. However, having already implemented both of these I am confident that, given some more time, I could implement TimSort on my own.