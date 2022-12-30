package com.company;
//Beginner level project- Alarm Clock

import java.text.SimpleDateFormat;
import java.util.*;

public class alarm_java {
    public static void main(String[] args) {
            try{
                Scanner sc= new Scanner(System.in);
                System.out.println("Enter the time that in HH:mm a format where HH(hour):mm(minutes) a(pm or am):");
                String time_set= sc.nextLine();
                System.out.println("Your alarm is now set for: "+time_set+"...");
                Boolean flag=true;
                while(flag){	//Consider always a true condition.
                    String current_Time = new SimpleDateFormat("HH:mm a").format(new Date());	//current time in HH(hour):mm(minutes):a(pm or am)
                    boolean x = current_Time.equals(time_set);	//Equating the exact time to the time entered by the user**.
                    if(x==true){
                        System.out.println("Wake up it's: "+ time_set);
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
