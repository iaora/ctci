/*
 * Living People: Given a list of people with their birth and death, implement a method to compute
 * the year with the most number of people alive. You can assume that all people were born between
 * 1900 and 2000 (inclusive). If a person was alive during any portion of that year, they should
 * be included in that year's count.
 *
 * Assumption: The input given into this method is an array of People objects.
 *
 * Runtime: 
 *      Time : O(n), where n = number of people. # of years = 200 = constant, so not counted
 *      Space : O(years), where years = range of years [1900,2000]
 */

public class Pr10{
    public static void main(String[] args){
        Pr10 pr = new Pr10();
        Pr10.Person[] people = new Pr10.Person[5];
        people[0] = pr.new Person(1903, 1903);
        people[1] = pr.new Person(1901, 1905);
        people[2] = pr.new Person(1904, 1905);
        people[3] = pr.new Person(1903, 1905);
        people[4] = pr.new Person(1902, 1904);

        int[] numDiff = new int[7];
        populateTotals(numDiff, people);

        print(numDiff);
        getMax(numDiff);
    }

    private static void getMax(int[] numDiff){
        int index = -1;
        int maxCount = -1;
        int count = 0;
        for(int i = 0; i < numDiff.length; i++){
            count += numDiff[i];
            if(maxCount < count){
                maxCount = count;
                index = i;
            }
        }
        System.out.println("Max at year " + (1900+index));
    }

    private static void populateTotals(int[] numDiff, Pr10.Person[] people){
        for(Pr10.Person person : people){
            // add birth
            numDiff[person.getBirthYear() - 1900] += 1;
            // remove death -- add 1 to index to account for them
            // being alive in the year they died
            numDiff[person.getDeathYear() - 1900 + 1] -= 1;
        }
    }

    private static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    class Person{
        private int birthYear;
        private int deathYear;

        private Person(int birthYear, int deathYear){
            this.birthYear = birthYear;
            this.deathYear = deathYear;
        }

        public int getBirthYear(){return birthYear;}
        public int getDeathYear(){return deathYear;}
    }
}
