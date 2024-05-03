package com.sparta.gwoc.dto;


import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.print.attribute.HashPrintServiceAttributeSet;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ValidatorTest {


    @Nested
    class ValidIDTests {
        @ParameterizedTest
        @ValueSource(strings = {"00005", "0004", "003", "02", "1"})
        @DisplayName("when an id shorter than 6 gets given returns false")
        void whenAnIdShorterThan6GetsGivenReturnsFalse(String empID) {
            assertThat(Validator.isValidEmployeeID(empID), equalTo(false));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1234567", "12345678", "123456789", "1234567890"})
        @DisplayName("when an id is longer than 6 gets given returns false")
        void whenAnIdIsLongerThan6GetsGivenReturnsFalse(String empID) {
            assertThat(Validator.isValidEmployeeID(empID), equalTo(false));
        }

        @Test
        @DisplayName("when an id contains not only numbers, isValidEmployeeID returns false")
        void whenAnIdContainsNotOnlyNumbersIsValidEmployeeIdReturnsFalse() {
            assertThat(Validator.isValidEmployeeID("A23456"), equalTo(false));
        }

        @Test
        @DisplayName("when an id is exactly 6 characters long and only contains numbers, isValidEmployeeID returns true")
        void whenAnIdIsExactly6CharactersLongAndOnlyContainsNumbersIsValidEmployeeIdReturnsTrue() {
            assertThat(Validator.isValidEmployeeID("123456"), equalTo(true));
        }
    }

    @Nested
    class ValidGenderTests {
        @ParameterizedTest
        @ValueSource(strings = {"X", "A", "Q", "D", "g", "5", "f", "m", "Fm", "Mm", "Ds"})
        @DisplayName("when gender other than F or M return false")
        void whenGenderIsAnyOtherThanFemaleOrMaleReturnFalse(String gender) {
            assertThat(Validator.isValidGender(gender), equalTo(false));

        }

        @Test
        @DisplayName("when gender if F should return true")
        void whenGenderIsFemaleShouldReturnTrue() {
            assertThat(Validator.isValidGender("F"), equalTo(true));
        }

        @Test
        @DisplayName("when gender if M should return true")
        void whenGenderIsMaleShouldReturnTrue() {
            assertThat(Validator.isValidGender("M"), equalTo(true));
        }
    }


    @Nested
    class ValidCharacterTests {
        @ParameterizedTest
        @ValueSource(strings = {"ABABABA", "AB"})
        @DisplayName("given a string greater than 1 character is given, isValidCharacter returns false")
        void givenAStringGreaterThan1CharacterIsGivenIsValidCharacterReturnsFalse(String character) {
            assertThat(Validator.isValidCharacter(character), equalTo(false));
        }

        @Test
        @DisplayName("given a string is 1 char long and lowercase, isValidCharacter returns false")
        void givenAStringIs1CharLongAndLowercaseIsValidCharacterReturnsFalse() {
            assertThat(Validator.isValidCharacter("a"), equalTo(false));
        }

        @Test
        @DisplayName("given a string is 1 char long and not a letter, isValidCharacter returns false")
        void givenAStringIs1CharLongAndNotALetterIsValidCharacterReturnsFalse() {
            assertThat(Validator.isValidCharacter("1"), equalTo(false));

        }

        @Test
        @DisplayName("given a string is 1 char long and an uppercase letter, isValidCharacter returns true")
        void givenAStringIs1CharLongAndAnUppercaseLetterIsValidCharacterReturnsTrue() {
            assertThat(Validator.isValidCharacter("J"), equalTo(true));
        }
    }

    @Nested
    class ValidEmailTests {
        @Test
        @DisplayName("given an email has all components, isValidEmail returns true")
        void givenAnEmailHasAllComponentsIsValidEmailReturnsTrue() {

            assertThat(Validator.isValidEmail("ex.Am-pl!e15@example.co.uk"), equalTo(true));
        }

        @ParameterizedTest
        @ValueSource(strings = {"usernamegoogle.com", ".example12@example.co.uk", "Example.example12@example.", ".com@exampe13"})
        @DisplayName("given an email don't have all component, isValidEmail returns false")
        void givenAnEmailDontHaveAllComponentIsValidEmailReturnsFalse(String email) {
            assertThat(Validator.isValidEmail(email), equalTo(false));
        }
    }

    @Nested
    class ValidStringTests {
        @Test
        @DisplayName("given a string has characters other than letters in it, isValidString returns false")
        void givenAStringHasCharactersOtherThanLettersInItIsValidStringReturnsFalse() {
            assertThat(Validator.isValidString("H3ll0"), equalTo(false));
        }

        @Test
        @DisplayName("given a string is null, isValidString returns false")
        void givenAStringIsNullIsValidStringReturnsFalse() {
            assertThat(Validator.isValidString(null), equalTo(false));
        }

        @Test
        @DisplayName("given a string has only letters in it, isValidString returns true")
        void givenAStringOnlyHasLettersInItIsValidStringReturnsFalse() {
            assertThat(Validator.isValidString("ValidName"), equalTo(false));
        }

        @Test
        @DisplayName("given a string contains whitespace, isValidString returns false")
        void givenAStringContainsWhitespaceIsValidStringReturnsFalse() {
            assertThat(Validator.isValidString("Invalid Name"), equalTo(false));
        }
    }

    @Nested
    class ValidPrefixTests {
        @Test
        @DisplayName("given a prefix contains anything other than letters, isValidPrefix returns false")
        void givenAPrefixContainsAnythingOtherThanLettersIsValidPrefixReturnsFalse() {
            assertThat(Validator.isValidPrefix("M!55."), equalTo(false));
        }

        @Test
        @DisplayName("given a prefix contains anything other than letters, isValidPrefix returns false")
        void givenAPrefixContainsOnlyLettersAndIsValid_IsValidPrefixReturnsFalse() {
            assertThat(Validator.isValidPrefix("M!55."), equalTo(false));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Dr.", "Mrs.", "Hon.", "Mr.", "Ms", "Drs", "Prof."})
        @DisplayName("given a prefix contains no numbers and is Valid, isValidPrefix returns false")
        void givenAPrefixContainsNoNumbersAndIsValid_isValidPrefixReturnsTrue(String validPrefixes){
            assertThat(Validator.isValidPrefix(validPrefixes), equalTo(true));
        }
    }


    @Nested
    class ValidDateTests{
        @ParameterizedTest
        @MethodSource("getInvalidFormatDates")
        @DisplayName("given a date is not in the dd/mm/yyyy format, isValidDate returns false")
        void givenADateIsNotInTheDdMmYyyyFormatIsValidDateReturnsFalse(String dateOfBirth, String dateOfJoin) {
            assertThat(Validator.isValidDate(dateOfBirth, dateOfJoin), equalTo(false));
        }

        public static Stream<Arguments> getInvalidFormatDates(){
            return Stream.of(
                    Arguments.of("2001/01/01", "01/2001/01"),
                    Arguments.of("01-01-2001", "01-2001-01"),
                    Arguments.of("01-01-2001", "01-01-2002")
            );
        }

        @ParameterizedTest
        @MethodSource("getBirthDaysAfterJoiningDates")
        @DisplayName("given dates are valid but birthdate is after joining date, isValidDate returns false")
        void givenDatesAreValidButBirthdateIsAfterJoiningDateIsValidDateReturnsFalse(String birthDate, String joiningDate) {
            assertThat(Validator.isValidDate(birthDate, joiningDate), equalTo(false));
        }

        public static Stream<Arguments> getBirthDaysAfterJoiningDates(){
            return Stream.of(
                    Arguments.of("2003/01/01", "2001/01/01"),
                    Arguments.of("2003/01/01", "1800/01/01"),
                    Arguments.of("2020/01/01", "2019/01/01")
            );
        }

        @ParameterizedTest
        @MethodSource("getBirthDaysAndJoiningDatesInTheFuture")
        @DisplayName("given dates are valid but are in the future, isValidDate returns false")
        void givenDatesAreValidButAreInTheFutureIsValidDateReturnsFalse(String birthDate, String joiningDate) {
            assertThat(Validator.isValidDate(birthDate, joiningDate), equalTo(false));
        }

        public static Stream<Arguments> getBirthDaysAndJoiningDatesInTheFuture(){
            return Stream.of(
                    Arguments.of("3004/01/01", "3005/01/01"),
                    Arguments.of("3004/01/01", "3008/01/01")
            );
        }

        @ParameterizedTest
        @MethodSource("getValidDates")
        @DisplayName("given dates are valid format and birthday is before joiningDate, isValidDate returns true")
        void givenDatesAreValidFormatAndBirthdayIsBeforeJoiningDateIsValidDateReturnsTrue(String birthDate, String joiningDate) {
            assertThat(Validator.isValidDate(birthDate, joiningDate), equalTo(true));
        }

        public static Stream<Arguments> getValidDates(){
            return Stream.of(
                    Arguments.of("01/01/2001", "01/02/2001"),
                    Arguments.of("01/01/2001", "01/01/2018"),
                    Arguments.of("01/01/2001", "02/01/2019")

            );
        }
    }

    @Nested
    class ValidSalaryTests {
        @Test
        @DisplayName("given a negative integer should return false")
        void givenANegativeIntegerShouldReturnFalse() {
            assertThat(Validator.isValidSalary("-666666"), equalTo(false));

        }

        @Test
        @DisplayName("given a positive integer should return true")
        void givenAPositiveIntegerShouldReturnTrue() {
            assertThat(Validator.isValidSalary("6666666"), equalTo(true));

        }
    }
}