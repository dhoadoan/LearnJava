import java.util.*;
public class Recursion01 {
    /*

    schedule = []

                1  1  1      1        1
                2  2  2      2        2
                3  3  3      3
                4  4  4  4   4
                5  5  5      5
                .  .  .
                .  .  .
                8  8  8          8     8

                Mo Tu Wed Th Fri Sat Sun

    maximum = 40 hours

    For each day, you cannot work more than 8 hours

    Given an array of strings representing the schedule you will work for next week
    and an integer that represents the max number of hours you will work within a week


    Print all the possible schedules

    [3, 6, 4, 2, 8, 7] = 35
           ^     ^
    [3, 6, 2, 1, 8, 7] = 34

backtrack(day){
   if(day == 3){
     return;
   }

    print(start + "" + day);
    backtrack(day + 1);
    print(end + "" + day);

}
output:
  start0
  start1
  start2
  end2
  end1
  end0

   backtrack(0)
      
        
          
  
            
    *
    * */
    public static void main(String[] args) {
        //client
        printAllSchedules(new String[]{"1", "*", "1", "*", "*", "4", "2"}, 40);
    }
    // [4,*,5,.....]
    //API
    public static void printAllSchedules(String[] sheet, int maxHours){
        backtrack(0, sheet, maxHours);
    }



    private static void backtrack(int day, String[] sheet, int maxHours){
        if(day == sheet.length){ //solved all days
            //check if our sheet has total hours less than maxHours
            if(getTotalHours(sheet) <= maxHours){
                System.out.println(Arrays.toString(sheet)); //just print the schedule
            }
            return;
        }
        // [3, 5,....]
//          backtrack(0, sheet, maxHours) 
        //    backtrack(1, sheet, maxHours);

        if(sheet[day].equals("*")){ // its a fixed schedule on that day){ // if that day I have a choice to choose
            //for each day I want to try all the hoursbacktrack(day + 1, sheet, maxHours);
            for(int hour = 1; hour <= 8; hour++){
                //try
                sheet[day] = hour + ""; // try a new state
                backtrack(day + 1, sheet, maxHours); //use the state and solve the rest of the problem
                sheet[day] = "*"; //come back to the original state
            }
        }
        else{ //dont have any choice
            backtrack(day + 1, sheet, maxHours);
        }
    }



    //["3", "4", "1", "5", " 6"...]
    // 3 + 4 + 1 + 5 + 6 = 19
    private static int getTotalHours(String[] sheet){
        int hours = 0;
        for(String hourString: sheet){
            hours += Integer.parseInt(hourString);
        }
        return hours;
    }
}