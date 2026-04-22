public class QuantityMeasurementApp {

    public enum LengthUnit {
        FEET(12.0), INCH(1.0);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    public static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            QuantityLength that = (QuantityLength) obj;
            
            // Convert both to a common base unit (INCH)
            double thisValueInInches = this.value * this.unit.getFactor();
            double thatValueInInches = that.value * that.unit.getFactor();
            
            return Double.compare(thisValueInInches, thatValueInInches) == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("Running UC3: Generic Quantity Class for DRY Principle tests...\n");

        // Test Cases
        
        // testEquality_FeetToFeet_SameValue
        QuantityLength feet1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(1.0, LengthUnit.FEET);
        System.out.println("testEquality_FeetToFeet_SameValue (1.0 ft, 1.0 ft): " + feet1.equals(feet2) + " (Expected: true)");

        // testEquality_InchToInch_SameValue
        QuantityLength inch1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength inch2 = new QuantityLength(1.0, LengthUnit.INCH);
        System.out.println("testEquality_InchToInch_SameValue (1.0 in, 1.0 in): " + inch1.equals(inch2) + " (Expected: true)");

        // testEquality_FeetToInch_EquivalentValue
        QuantityLength feetOne = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inchTwelve = new QuantityLength(12.0, LengthUnit.INCH);
        System.out.println("testEquality_FeetToInch_EquivalentValue (1.0 ft, 12.0 in): " + feetOne.equals(inchTwelve) + " (Expected: true)");

        // testEquality_InchToFeet_EquivalentValue
        System.out.println("testEquality_InchToFeet_EquivalentValue (12.0 in, 1.0 ft): " + inchTwelve.equals(feetOne) + " (Expected: true)");

        // testEquality_FeetToFeet_DifferentValue
        QuantityLength feetTwo = new QuantityLength(2.0, LengthUnit.FEET);
        System.out.println("testEquality_FeetToFeet_DifferentValue (1.0 ft, 2.0 ft): " + feet1.equals(feetTwo) + " (Expected: false)");

        // testEquality_InchToInch_DifferentValue
        QuantityLength inchTwo = new QuantityLength(2.0, LengthUnit.INCH);
        System.out.println("testEquality_InchToInch_DifferentValue (1.0 in, 2.0 in): " + inch1.equals(inchTwo) + " (Expected: false)");

        // testEquality_NullComparison
        System.out.println("testEquality_NullComparison (1.0 ft, null): " + feet1.equals(null) + " (Expected: false)");

        // testEquality_SameReference
        System.out.println("testEquality_SameReference (feet1, feet1): " + feet1.equals(feet1) + " (Expected: true)");
    }
}
