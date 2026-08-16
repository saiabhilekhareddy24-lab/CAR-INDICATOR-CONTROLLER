public class CarIndicatorControllerTest {

private static int passed = 0;
private static int failed = 0;

private static void test(String testName,
                         boolean leftInput,
                         boolean rightInput,
                         boolean hazardInput,
                         boolean expectedLeft,
                         boolean expectedRight) {

    CarIndicatorController controller =
            new CarIndicatorController();

    controller.update(leftInput, rightInput, hazardInput);

    boolean actualLeft = controller.isLeftIndicatorOn();
    boolean actualRight = controller.isRightIndicatorOn();

    if (actualLeft == expectedLeft &&
        actualRight == expectedRight) {

        System.out.println("[PASS] " + testName);
        passed++;

    } else {

        System.out.println("[FAIL] " + testName);
        System.out.println("       Expected: Left="
                + expectedLeft + ", Right=" + expectedRight);
        System.out.println("       Actual:   Left="
                + actualLeft + ", Right=" + actualRight);

        failed++;
    }
}

public static void main(String[] args) {

    System.out.println("======================================");
    System.out.println(" CAR INDICATOR CONTROLLER TESTBENCH");
    System.out.println("======================================");

    test(
        "No switch",
        false, false, false,
        false, false
    );

    test(
        "Left indicator",
        true, false, false,
        true, false
    );

    test(
        "Right indicator",
        false, true, false,
        false, true
    );

    test(
        "Hazard indicator",
        false, false, true,
        true, true
    );

    test(
        "Left + Right invalid input",
        true, true, false,
        false, false
    );

    test(
        "Left + Hazard",
        true, false, true,
        true, true
    );

    test(
        "Right + Hazard",
        false, true, true,
        true, true
    );

    test(
        "Left + Right + Hazard",
        true, true, true,
        true, true
    );

    System.out.println();
    System.out.println("======================================");
    System.out.println("TEST SUMMARY");
    System.out.println("======================================");
    System.out.println("Tests Passed : " + passed);
    System.out.println("Tests Failed : " + failed);

    if (failed == 0) {
        System.out.println("RESULT       : ALL TESTS PASSED");
    } else {
        System.out.println("RESULT       : SOME TESTS FAILED");
    }
}


}
