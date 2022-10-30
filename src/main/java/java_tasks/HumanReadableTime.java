package java_tasks;

/*
https://www.codewars.com/kata/52685f7382004e774f0001f7
*/
public class HumanReadableTime {
    public static String makeReadable(int input) {
    if (input > 359999) return null;
    int hours = input / 3600;
    int minutes = (input - (hours * 3600)) / 60;
    int seconds = input - hours * 3600 - minutes * 60;
    return (hours < 10 ? "0" + hours : hours) + ":" +
            (minutes < 10 ? "0" + minutes : minutes) + ":" +
            (seconds < 10 ? "0" + seconds : seconds);
    }
}
