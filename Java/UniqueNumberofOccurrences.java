class Solution {
  public boolean uniqueOccurrences(int[] arr) {

    Map<Integer, Integer> count = new HashMap<>();
    for(int element : arr) {
      count.put(element, count.getOrDefault(element, 0) + 1);
    }

    HashSet<Integer> seen = new HashSet<>();
    for(int value : count.values()) {
      if(!seen.add(value)) {
        return false;
      }
    }

    return true;
  }
}
/*
We have 2 things i.e. java application and database. Now, to convert java calls into database specific calls
and database specific calls into java calls, translator is required which is nothing but Driver
*/
/* A network socket is required to reach database from java application and for that we have to establish
 a connection between java application and the database.
*/
/*
To send sql query to the database and to bring the results from the database to java application,
some mode(vehicle) is required and that vehicle is nothing but statement object.
*/
/*
Using statement object we can send the sql query to the database. Now, the database engine will execute
that query and will place the results in a box which is nothing but ResultSet.
*/
