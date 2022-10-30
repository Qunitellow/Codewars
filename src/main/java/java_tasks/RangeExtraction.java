package java_tasks;

/*
https://www.codewars.com/kata/51ba717bb08c1cd60f00002f
*/
class RangeExtraction {
    public static String rangeExtraction(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int cnt = 0; cnt < arr.length; cnt++) {
            int lenOrderNums = 0;
            if (cnt == arr.length - 1) {
                sb.append(arr[cnt]);
                return sb.toString();
            }
            while (Math.abs(arr[cnt] - arr[cnt + 1]) == 1) {
                cnt++;
                lenOrderNums++;
                if (cnt + 1 == arr.length)
                    break;
            }
            if (lenOrderNums == 0) {
                sb.append(arr[cnt]);
            } else {
                sb.append(arr[cnt - lenOrderNums]).append(lenOrderNums == 1 ? "," : "-").append(arr[cnt]);
            }
            if (cnt != arr.length - 1)
                sb.append(",");
        }
        return sb.toString();
    }
}