package java_tasks.snail;

public class Snail {
    public static int[] snail(int[][] array) {
        if (array[0].length == 0)
            return new int[]{};

        int lengthArr = array.length;
        int[] result = new int[lengthArr * lengthArr];
        int currentIndex = 0;

        int currentSideSize = lengthArr;
        int shift = 0;
        while (shift < (lengthArr / 2.0)) {
            //верхняя сторона
            for (int i = 0; i < currentSideSize; i++) {
                result[currentIndex++] = array[shift][shift + i];
            }

            //правая сторона
            for (int i = 0; i < currentSideSize - 2; i++) {
                result[currentIndex++] = array[1 + shift + i][lengthArr - 1 - shift];
            }

            //нижняя сторона
            if (lengthArr / 2 - shift > 0) {
                for (int i = 0; i < currentSideSize; i++) {
                    result[currentIndex++] = array[lengthArr - 1 - shift][lengthArr - 1 - i - shift];
                }
            }

            //левая сторона
            for (int i = 0; i < currentSideSize - 2; i++) {
                result[currentIndex++] = array[lengthArr - 2 - shift - i][shift];
            }

            //уменьшение области захвата
            currentSideSize -= 2;
            shift++;
        }
        return result;
    }
}