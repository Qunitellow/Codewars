package java_tasks.codeSpeed;

import java_tasks.Greed;

/*
Измерения скорости срабатывания кода
*/
public class CodeSpeed {
    public static double getTime() {
        for (int i = 0; i < 20; i ++) { //прогрев JVM
            Greed.greedy(new int[]{6,6,6,6,1});
        }
        int count = 1000; //первоначальное кол-во повтора выполнения testMethod

        while(true) {
            long begin =  System.nanoTime();

            for (int i = 0; i < count; i ++)
                Greed.greedy(new int[]{6,6,6,6,1});

            long end = System.nanoTime();

            if ((end - begin) < 1000000000) { //Прогон тестов пока суммарное выполнения count раз
                count *= 100000;              //testMethod`a не будет равно несколько секунд
                continue;
            }

            return (double)(end - begin) / count;
        }
    }
}
