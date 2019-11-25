import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MethodsTest {

    private static MethodsCode code;

    @BeforeEach
    public void init() {
        code = new MethodsCode();
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class getTotal {
        @Test
        @DisplayName("GIVEN number WHEN digit contains even and odd digits THEN return sum")
        public void getTotal1() {
            assertEquals(10, code.getTotal("5421312341"));
        }

        @Test
        @DisplayName("GIVEN number WHEN digit contains only odd number THEN return negative sum")
        public void getTotal2() {
            assertEquals(-6, code.getTotal("33"));
        }

        @Test
        @DisplayName("GIVEN number WHEN digits are all zeros THEN return -1")
        public void getTotal3() {
            assertEquals(-1, code.getTotal("00000000000"));
        }

    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class bankStatementCalculator {
        @Test
        @DisplayName("GIVEN statements WHEN they are less than $1,000.00 THEN compute total")
        public void bankStatementCalculator1() {
            //GIVEN
            List<String> myStatement = new ArrayList<>();
            myStatement.add("$23.21");
            myStatement.add("$18.10");
            myStatement.add("$22.18");
            myStatement.add("$100.90");
            myStatement.add("$23.10");

            //WHEN
            double actual = code.bankStatementCalculator(myStatement);

            //THEN
            assertEquals(187.49, actual);
        }


        @Test
        @DisplayName("GIVEN statements WHEN they are more than $1,000.00 THEN compute total")
        public void bankStatementCalculator2() {
            //GIVEN
            List<String> myStatement = new ArrayList<>();
            myStatement.add("$14.21");
            myStatement.add("$200.60");
            myStatement.add("$1,000.28");
            myStatement.add("$2,000.50");
            myStatement.add("$23.10");

            //WHEN
            double statementTotal = code.bankStatementCalculator(Arrays.asList("$14.21", "$200.60", "$1,000.28", "$2,000.50", "$23.10"));

            //THEN
            assertEquals(3238.69, statementTotal);
        }

        @Test
        @DisplayName("GIVEN statements WHEN they are equal to $0 THEN compute total")
        public void bankStatementCalculator3() {
            //GIVEN
            List<String> myStatement = new ArrayList<>();
            myStatement.add("$0");
            myStatement.add("$0");
            myStatement.add("$0");
            myStatement.add("$0");
            myStatement.add("$0");

            //WHEN
            double actual = code.bankStatementCalculator(Arrays.asList("$0", "$0", "$0", "$0", "$0"));

            //THEN
            assertEquals(-1.0, actual);
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class getPopulation {
        @Test
        @DisplayName("GIVEN countries, populations and selected country WHEN selected country is present THEN get population of selected country")
        public void getPopulation1() {
            //GIVEN
            List<String> countries = Arrays.asList("USA", "Mexico", "South Korea", "Brazil");
            List<String> populations = Arrays.asList("300000000", "60000000", "5200000", "12000000");
            int randomNum = 1;

            String randomCountry = countries.get(randomNum);

            //WHEN
            String actual = code.getPopulation(countries, populations, randomCountry);
            String expected = populations.get(randomNum);

            //THEN
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("GIVEN countries, populations and selected country WHEN selected country is present THEN get population of selected country")
        public void getPopulation2() {
            //GIVEN
            List<String> countries = new ArrayList<>();
            countries.add("Turkey");
            countries.add("Greece");
            countries.add("Romania");
            countries.add("Germany");
            countries.add("France");
            countries.add("Russia");
            countries.add("Argentina");
            countries.add("South Korea");
            countries.add("North Korea");
            countries.add("China");
            countries.add("India");
            countries.add("Kazakhstan");
            countries.add("Algeria");
            countries.add("Belgium");
            countries.add("Lithuania");
            countries.add("Somewhere");

            List<String> populations = new ArrayList<>();
            populations.add("80000000");
            populations.add("63200000");
            populations.add("965555520");
            populations.add("1000000");
            populations.add("14000000");
            populations.add("66200000");
            populations.add("999555520");
            populations.add("6700000");
            populations.add("123000000");
            populations.add("5432200000");
            populations.add("125555520");
            populations.add("6300000");
            populations.add("99000000");
            populations.add("69200000");
            populations.add("7655555520");
            populations.add("32100000");

            int randomNum = 2;
            String randomCountry = countries.get(randomNum);

            //WHEN
            String actual = code.getPopulation(countries, populations, randomCountry);
            String expected = populations.get(randomNum);

            //THEN
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("GIVEN countries, populations and selected country WHEN selected country is not present THEN return \"-1\"")
        public void getPopulation3() {
            //GIVEN
            List<String> countries = new ArrayList<>();
            countries.add("South Africa");
            countries.add("Mali");
            countries.add("Morocco");
            countries.add("Algeria");

            List<String> populations = new ArrayList<>();
            populations.add("20000000");
            populations.add("90000000");
            populations.add("2300000");
            populations.add("12000000");

            String nonExistingCountry = "Some non existing country";

            //WHEN
            String actual = code.getPopulation(countries, populations, nonExistingCountry);
            String expected = "-1";

            //THEN
            assertEquals(expected, actual);
        }

    }


    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class randomNumberGenerator {

        @Test
        @DisplayName("GIVEN bound WHEN its is less than 1 THEN return -1")
        public void randomNumberGenerator1() {
            assertEquals(-1, code.randomGenerator(0));
        }

        @Test
        @DisplayName("GIVEN bound WHEN its is greater than 1 THEN return random number between 1 and bound")
        public void randomNumberGenerator2() {
            for (int i = 0; i < 20; i++) {
                int rnd = code.randomGenerator(3);
                if (rnd == 0) {
                    assertFalse(true);
                } else {
                    assertTrue(true);
                }
            }

        }

        @Test
        @DisplayName("GIVEN bound WHEN its is equal to 1 THEN return 1")
        public void randomNumberGenerator3() {
            assertEquals(1, code.randomGenerator(1));
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class correctListOfNames {

        @Test
        @DisplayName("GIVEN names {Bob, Alise} WHEN wrong: Alise and correct: Alice THEN return {Bob, Alice}")
        public void correctListOfNames1() {
            List<String> actual = code.correctListOfNames(Arrays.asList("Bob", "Alise"), "Alise", "Alice");

            assertTrue(Arrays.asList("Bob", "Alice").equals(actual));
        }

    }
}