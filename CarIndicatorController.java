public class CarIndicatorController {

private boolean leftIndicator;
private boolean rightIndicator;

/**
 * Updates the indicator outputs based on the switch inputs.
 *
 * @param leftSwitch   left turn switch
 * @param rightSwitch  right turn switch
 * @param hazardSwitch hazard switch
 */
public void update(boolean leftSwitch,
                   boolean rightSwitch,
                   boolean hazardSwitch) {

    // Hazard mode has the highest priority.
    if (hazardSwitch) {
        leftIndicator = true;
        rightIndicator = true;
    }

    // Both turn switches at the same time are treated as invalid.
    else if (leftSwitch && rightSwitch) {
        leftIndicator = false;
        rightIndicator = false;
    }

    // Left turn.
    else if (leftSwitch) {
        leftIndicator = true;
        rightIndicator = false;
    }

    // Right turn.
    else if (rightSwitch) {
        leftIndicator = false;
        rightIndicator = true;
    }

    // No switch selected.
    else {
        leftIndicator = false;
        rightIndicator = false;
    }
}

public boolean isLeftIndicatorOn() {
    return leftIndicator;
}

public boolean isRightIndicatorOn() {
    return rightIndicator;
}

/**
 * Returns the current controller output as text.
 */
public String getOutput() {
    return "Left=" + (leftIndicator ? "ON" : "OFF")
            + ", Right=" + (rightIndicator ? "ON" : "OFF");
}

public static void main(String[] args) {

    CarIndicatorController controller =
            new CarIndicatorController();

    System.out.println("CAR INDICATOR CONTROLLER SIMULATION");
    System.out.println("-----------------------------------");

    controller.update(false, false, false);
    System.out.println("No switch       -> "
            + controller.getOutput());

    controller.update(true, false, false);
    System.out.println("Left switch     -> "
            + controller.getOutput());

    controller.update(false, true, false);
    System.out.println("Right switch    -> "
            + controller.getOutput());

    controller.update(false, false, true);
    System.out.println("Hazard switch   -> "
            + controller.getOutput());

    controller.update(true, true, false);
    System.out.println("Left + Right    -> "
            + controller.getOutput());

    controller.update(true, false, true);
    System.out.println("Left + Hazard   -> "
            + controller.getOutput());

    controller.update(false, true, true);
    System.out.println("Right + Hazard  -> "
            + controller.getOutput());
}


  }
  
