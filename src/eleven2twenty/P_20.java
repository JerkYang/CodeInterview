package eleven2twenty;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author: JerkYang
 * @CreateTime: 2019-09-15 14:15
 * @Description: 顺时针打印矩阵 p161
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1    2     3       4
 * 5    6     7       8
 * 9    10    11     12
 * 13   14    15     16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 */
public class P_20 {
    public ArrayList<Integer> printMatrix(int[][] array) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (array.length == 0) {
            return result;
        }
        int rows = array.length, cols = array[0].length;
        int start = 0;
        //对于一个5x5的矩阵而言，最后一圈只有一个数字，对应的坐标为(2.2)。我们发现5>2X2。
        // 对于一个6x6的矩阵而言，最后圈有4个数字，其左上角的坐标仍然为(2, 2)。我们发现6> 2X2依然成立。
        // 于是可以得出，让循环继续的条件是columns > starUXx2并且rows > sartYx2。所以我们可以用如下的循环来打印矩阵:
        while (cols > start * 2 && rows > start * 2) {
            result = printMatrixCircle(array, cols, rows, start, result);
            ++start;
        }
        return result;
    }

    private ArrayList<Integer> printMatrixCircle(int[][] array, int cols, int rows, int start, ArrayList result) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        //从左到右打印一行
        for (int i = start; i <= endX; i++) {
            result.add(array[start][i]);
        }
        //从上到下打印一行
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                result.add(array[i][endX]);
            }
        }
        //从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                result.add(array[endY][i]);
            }
        }
        //从下到上打印一行
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                result.add(array[i][start]);
            }
        }
        return result;
    }

    @Test
    public void Test() {
        //int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] arr = {{1}, {5}, {9}, {13}};
        ArrayList<Integer> integers = printMatrix(arr);
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i));
            if (i != integers.size() - 1) {
                System.out.print(",");
            }
        }

    }
}
