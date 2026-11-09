package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScholarshipCalculatorTest {

    ScholarshipCalculator calc = new ScholarshipCalculator();

    @Test
    void letterGrade_score95_returnsA() {
        assertEquals("A", calc.letterGrade(95));
    }

    @Test
    void letterGrade_score75_returnsC() {
        assertEquals("C", calc.letterGrade(75));
    }

    @Test
    void gpa_scores95And85_returns3point5() {
        assertEquals(3.5, calc.gpa(new double[]{95, 85}), 0.001);
    }

    @Test
    void scholarship_highGpaEnoughCredits_returns100() {
        assertEquals(100, calc.scholarship(3.9, 16, false));
    }

    @Test
    void scholarship_gpa3point5Credits12_returns70() {
        assertEquals(70, calc.scholarship(3.5, 12, false));
    }
}
