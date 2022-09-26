# Double Linked List

Create a class DoubleLinkdList that implements ILinkedList interface.

## Input Format
First line contains a comma-separated list of the linkedlist elements.<br />
The following line contains a keyword of the operation required to perform on the list.<br />
The number and the contents of the following lines depend on the keyword:<br />

#### add:<br> Followed by 1 line containing the element to insert to the end of the list.
#### addToIndex:<br>Followed by 2 lines, the first contains the insertion index and the second contains the insertion value.
#### get:<br> Followed by 1 line containing the index of the requried element.
#### set:<br> Followed by 2 lines, the first contains the index and the second contains the value of the new value.
#### clear:<br> Not followed by additional lines.
#### isEmpty:<br> Not followed by additional lines.
#### remove:<br> Followed by 1 line containig the index of the element.
#### sublist:<br> Followed by 2 lines, the first has the starting index and the second has the ending index of the sublist.
#### contains:<br> Followed by 1 line, containing the the element we test for exisitence.


## Constraints
Assume the list contains only integer values for this problem.

## Output Format
For keywords add, addToIndex, set, clear, and remove it is required to print the list elements after the operations.<br />
For get: print the retrieved element.<br />
For isEmpty, contains: print "True" or "False".<br />
For sublist: print the elements of the sublist.<br />
If any error occurs, print "Error".<br />

## Input and Output Samples

|N| Input | Output |
|--|-------|--------|
|1|[]<br>add<br>10<br> |[10]|
|2|[40, 98, 36, 83, 25, 64, 36, 10, 31, 70]<br>addToIndex<br>3<br>67<br>|[40, 98, 36, 67, 83, 25, 64, 36, 10, 31, 70]|
|3|[1, 2]<br>isEmpty|False|
|4|[6, 89, 85, 33, 18]<br>set<br>0<br>69|[69, 89, 85, 33, 18]|
|5|[26, 30, 16, 84, 24, 29, 80, 27, 17, 30, 20, 65, 41, 70, 25, 65, 67, 45, 82, 80]<br>get<br>16|67|
|6|[51, 60, 86, 13, 34, 90, 34, 94]<br>size|8|
|7|[58, 1, 26, 62, 27, 86, 71, 61, 99, 39, 10, 75, 93, 70, 77, 61, 82, 31]<br>contains<br>31|True|
|8|[13]<br>contains<br>69|False|
|9|[31, 87, 81, 100, 70, 26, 36, 28, 88, 66, 65, 8, 41]<br>sublist<br>6<br>8|[36, 28, 88]|
|10|[74, 59, 23, 89, 38, 73, 62, 22, 29]<br>clear|[]|
|11|[1, 5, 4, 2, 1, 4]<br>get<br>6|Error|