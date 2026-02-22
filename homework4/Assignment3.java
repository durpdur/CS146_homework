public class Assignment3 {

    public static void main(String[] args) {
        int[] elevationMap = {1, 2, 1, 4, 1, 2, 1, 5, 0, 0, 2, 1, 5};

        int l = 0;
        int r = elevationMap.length - 1;
        int res = 0;
        int maxIndex = 0;

        for (int i = 0; i < elevationMap.length; i++) {
            if (elevationMap[i] > elevationMap[maxIndex]) maxIndex = i;
        }

        int lMax = elevationMap[0];
        while (l < maxIndex) {
            if (elevationMap[l] > lMax) lMax = elevationMap[l];
            res += lMax - elevationMap[l];
            l++;
        }

        int rMax = elevationMap[r];
        while (r > maxIndex) {
            if (elevationMap[r] > rMax) rMax = elevationMap[r];
            res += rMax - elevationMap[r];
            r--;
        }
        
        System.out.println("Answer: " + res + " units");
    }
}
