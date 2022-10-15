# SubArraySum0
It will give all the sub-arrays of the main array whose sum is 0.

Step1: 
Take the same number of 1's as of number of elements present in the array.
eg.:Our main set/array S={2,3,-5,7}==>1111


Step2: 
Convert that number of 1's(Binary Value) to the decimal value.
eg.:1111==>15

Step3:
Generate the Binary numbers from 1 to that converted decimal value.
eg.:1 - 15 ==> 0001 - 1111

Step4:
Now for each generated binary number:  
i^th index = index/position of '1' in the binary number 
create a SubArray in which insert the i^th index element of main array 
So after this step we will get all the possible subsets of main set except
Empty Set.
eg.: 
0001 ==> {7} = 7
0010 ==> {-5} = -5
0011 ==> {-5,7} = 2
0100 ==> {3} = 3
0101 ==> {3,7} = 10
0110 ==> {3,-5} = -2
0111 ==> {3,-5,7} = 5
1000 ==> {2} = 2
1001 ==> {2,7} = 9
1010 ==> {2,-5} = -3
1011 ==> {2,-5,7} = 4
1100 ==> {2,3} = 5
1101 ==> {2,3,7} = 12
1110 ==> {2,3,-5} = 0 <----
1111 ==> {2,3,-5,7} = 7

Step5:
Do the sum of all elements of each SubArrays and check whose Sum is 0.
And then simply print that SubArray.
eg.: {2,3,-5}

Done............!!!
