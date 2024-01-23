package lesson9;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

public class StreamAPITest {
    @BeforeTest
    public int[] arr() {
        return new int[]{-79, 99, -83, -75, -78, -22, -57, 84, 11, 15};
    }

    @Test(priority = 1)
    public Object[] testStreamAPI() {
        return Arrays.stream(arr())
                .mapToObj(Math::abs)
                .sorted()
                .toArray();
    }

    @AfterTest
    public void positiveArr() {
        System.out.println(Arrays.toString(testStreamAPI()));
    }
}
