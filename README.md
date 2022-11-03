# Algorithmns-Class_HW1

## Q1: Find Missing Number

Convert the following pseudocode algorithm into Java.

```algorithm findMissing
  Input: integer array A of length N where each element is distinct
    and in the range [0, N]
  Output: integer x where x is in the range [0, N], but not in A

  s = the sum of all numbers in A
  return (N(N+1))/2 - s
```
## Q2: TwoSum (Fast)

Convert the following code into Pseudocode and put it in twosum.txt. Hint: for some loops, you should describe what it does in English. 

**There are no tests for this problem, so be sure to double check and test your translation manually, similar to how we did in lecture.**
```
public static int[] twoSumFast(int[] arr, int target) {
    HashSet<Integer> seen = new HashSet<>();
    for (int j = 0; j < arr.length; j++) {
      int otherAddend = target - arr[j];
      if (seen.contains(otherAddend)) {
        for (int i = 0; i < arr.length; i++) {
          if (arr[i] == otherAddend)  {
            return new int[] {i, j};
          }
        }
      } else {
        seen.add(arr[j]);
      }
    }
    return new int[] {-1, -1};
  }
```


## Q3: countFives

Write countFives, which takes in an integer and returns the number of times 5 appears as a digit
within the number. Examples:
```  
  countFives(123467890) // should output 0
  countFives(555555)    // should output 6
  countFives(15354)     // should output 2
```

**In order to receive full credit for this problem, you must use recursion. I.e. using =, for,
while, etc. is prohibited.**


## Q4: pickTrees

You build homes out of wood and you need material from a nearby forest. However, you want to
avoid deforestation, so you decide for each tree you cut down, you'll leave its neighbors alone,
giving the forest time to recover. However, you still need as much wood as possible, so you
have to be careful about which trees you pick to cut down.
Write pickTrees, which takes in an array of N trees arr where arr[i] represents how much wood
you can harvest by cutting down tree i. It should return the max amount of wood you can
harvest while following the rule of skipping neighbors
```
    // Pick tree 0, tree 2, and tree 4 => 1 + 3 + 5 = 9 wood total
    int testResult5 = pickTrees(new int[] {1, 2, 3, 4, 5});
    System.out.println(testResult5); // should output 9

    // Pick tree 1 and tree 3 => 3 + 3 = 6 wood total
    int testResult6 = pickTrees(new int[] {1, 3, 4, 3});
    System.out.println(testResult6); // should output 6

    // Pick tree 0 and tree 3 => 5 + 9 = 14 wood total
    int testResult7 = pickTrees(new int[] {5, 1, 4, 9});
    System.out.println(testResult7); // should output 14 
```

**In order to receive full credit for this problem, you must use recursion. I.e. using =, for,
while, etc. is prohibited**
