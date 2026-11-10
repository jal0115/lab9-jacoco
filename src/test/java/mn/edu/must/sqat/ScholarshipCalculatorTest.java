package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    // ---- letterGrade ----

    @Test
    void letterGrade_score85_returnsB() {
        assertEquals("B", calc.letterGrade(85));
    }

    @Test
    void letterGrade_score65_returnsD() {
        assertEquals("D", calc.letterGrade(65));
    }

    @Test
    void letterGrade_score50_returnsF() {
        assertEquals("F", calc.letterGrade(50));
    }

    @Test
    void letterGrade_negativeScore_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-1));
    }

    @Test
    void letterGrade_scoreAbove100_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(101));
    }

    // ---- gpa ----

    @Test
    void gpa_nullArray_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(null));
    }

    @Test
    void gpa_emptyArray_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[]{}));
    }

    @Test
    void gpa_allGradeTypes_returnsTwo() {
        assertEquals(2.0, calc.gpa(new double[]{95, 85, 75, 65, 50}), 0.001);
    }

    // ---- scholarship ----

    @Test
    void scholarship_gpaBelowZero_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(-0.1, 10, false));
    }

    @Test
    void scholarship_gpaAboveFour_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(4.1, 10, false));
    }

    @Test
    void scholarship_negativeCredits_throwsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(3.5, -1, false));
    }

    @Test
    void scholarship_hasViolation_returnsZero() {
        assertEquals(0, calc.scholarship(3.9, 16, true));
    }

    @Test
    void scholarship_highGpaButLowCredits_returns70() {
        assertEquals(70, calc.scholarship(3.9, 14, false));
    }

    @Test
    void scholarship_gpa3point5Credits11_returns50() {
        assertEquals(50, calc.scholarship(3.5, 11, false));
    }

    @Test
    void scholarship_gpa3point2_returns50() {
        assertEquals(50, calc.scholarship(3.2, 10, false));
    }

    @Test
    void scholarship_gpa2point5_returnsZero() {
        assertEquals(0, calc.scholarship(2.5, 20, false));
    }

    // ---- loop boundary: 0 / 1 / 2+ iterations ----
    // 0 iterations: gpa_emptyArray_throwsIllegalArgument, gpa_nullArray_throwsIllegalArgument

    @Test
    void gpa_singleScore_returnsFour() {
        assertEquals(4.0, calc.gpa(new double[]{95}), 0.001);
    }

    @Test
    void gpa_multipleScores_returnsTwoPointFive() {
        assertEquals(2.5, calc.gpa(new double[]{95, 85, 75, 65}), 0.001);
    }
}
