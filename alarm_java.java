package com.company;
//Beginner level project- Alarm Clock

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class alarm_java {
    public static void main(String[] args) {
        try{
            Scanner sc= new Scanner(System.in);
            System.out.print("Enter your alarm time in 24 hour (military) time \"hh:mm:ss AM/PM\" format: ");
            String time_set= sc.nextLine();
            System.out.println("Your alarm is now set for: "+time_set+"...");
            Boolean flag=true;
            while(flag){	//Consider always a true condition.
                String currentTimeWithSeconds = new SimpleDateFormat("HH:mm:ss a").format(new Date());
                boolean timesMatch = currentTimeWithSeconds.equals(time_set);	//Equating the exact time to the time entered by the user**.
                Thread.sleep(1000);

                int currentHours = Integer.parseInt(currentTimeWithSeconds.substring(0, 2));
                int currentMinutes = Integer.parseInt(currentTimeWithSeconds.substring(3, 5));
                int currentSeconds = Integer.parseInt(currentTimeWithSeconds.substring(6, 8));

                int setHours = Integer.parseInt(time_set.substring(0,2));
                int setMinutes = Integer.parseInt(time_set.substring(3,5));
                int setSeconds = Integer.parseInt(time_set.substring(6,8));

                int countdownHours = setHours-currentHours;
                int countdownMinutes = setMinutes-currentMinutes;
                int countdownSeconds = setSeconds-currentSeconds;

                if(countdownHours<0)
                    countdownHours = countdownHours + 24;
                if(countdownHours<1 && setMinutes<currentMinutes)
                    countdownHours = countdownHours + 24;
                if(countdownMinutes<0)
                    countdownMinutes = countdownMinutes + 60;
                if(setMinutes<=currentMinutes && countdownMinutes != 60 && countdownSeconds != 0)
                    countdownHours--;
                if(countdownSeconds<=60 && countdownSeconds != 0 )
                    countdownMinutes--;
                if(countdownMinutes<0)
                    countdownMinutes = countdownMinutes + 60;
                if(countdownSeconds !=0)
                    countdownSeconds = countdownSeconds + 60;
                if(countdownHours<0)
                    countdownHours = countdownHours + 24;


                System.out.println("Time left: " + (countdownHours) + " hours, " + (countdownMinutes) + " minutes, and " + (countdownSeconds) + " seconds.");

                if(timesMatch==true || (countdownHours==0 && countdownMinutes==0 && countdownSeconds==0)){
                    System.out.println();
                    System.out.println("Wake up! It's: "+ time_set);
                    break;	//Using break to jump out of the loop as soon as the alarm starts ringing.
                }
                else
                    continue;

            }
            flag=false;
        }
        catch(Exception e){
            System.out.println("Check the details you entered again!");
        }
    }

}
