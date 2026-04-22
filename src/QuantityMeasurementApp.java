public class QuantityMeasurementApp {

    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Feet feet = (Feet) obj;
            return Double.compare(feet.value, value) == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("Running UC1: Feet measurement equality tests...\n");

        // Test Cases
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        Feet feet3 = new Feet(2.0);
        Object nonNumeric = new Object();

        // testEquality_SameValue()
        System.out.println("testEquality_SameValue (1.0 ft and 1.0 ft): " + feet1.equals(feet2) + " (Expected: true)");

        // testEquality_DifferentValue()
        System.out.println("testEquality_DifferentValue (1.0 ft and 2.0 ft): " + feet1.equals(feet3) + " (Expected: false)");

        // testEquality_NullComparison()
        System.out.println("testEquality_NullComparison (1.0 ft and null): " + feet1.equals(null) + " (Expected: false)");

        // testEquality_NonNumericInput()
        System.out.println("testEquality_NonNumericInput (1.0 ft and Object): " + feet1.equals(nonNumeric) + " (Expected: false)");

        // testEquality_SameReference()
        System.out.println("testEquality_SameReference (feet1 and feet1): " + feet1.equals(feet1) + " (Expected: true)");
    }
}
