public class Ex2 {
    public static int[][] matrix;

    public static void main(String[] args) {
        run();

    }

    public static void run(){
        fillInTheMatrix();
        printMatrix();
        printMax();
        printMin();
        printAverage();
    }
    private static void fillInTheMatrix(){
        matrix = new int[4][4];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = Randomizer.randomInRange(-10, 10);
            }
        }
    }
    private static void printMatrix(){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
                System.out.println();
        }
        System.out.println();
    }
    private static void printMax(){
        int result = matrix[0][0];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
               if(matrix[i][j] > result) result = matrix[i][j];
            }
        }
        System.out.println("Max value = " + result);
    }

    private static void printMin(){
        int result = matrix[0][0];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(result > matrix[i][j]) result = matrix[i][j];
            }
        }
        System.out.println("Min value = " + result);
    }
    private static void printAverage(){
        double result = 0;
        int amountOfNumbers = matrix.length * matrix[0].length;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                result += matrix[i][j];
            }
        }
        System.out.println("Average value = " + result/amountOfNumbers);
    }


    static class Randomizer{
        private static long seed;
        static {
            seed = System.currentTimeMillis();
        }
        public static int random(int to){                    // Generate a pseudo random num in range [0, to)
            seed = ((11035 * seed + 12345) / 675) % 1048576;

            return (int) (seed % to);
        }

        public static int random(){                           // Generate a pseudo random num
            seed = ((11035 * seed + 12345) / 675) % 1048576;

            return (int)seed;
        }

        public static int randomInRange(int from, int to){            // Generate a pseudo random num in range [from, to]
            return from + random() % (to - from + 1);
        }
    }
}
