package com.sparta.gwoc.dto;


import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ValidatorTest {

    @BeforeEach
    void setup(){

    }


    @Nested
    class ValidIDTests{
        @ParameterizedTest
        @ValueSource(strings = {"00005", "0004", "003", "02", "1"})
        @DisplayName("when an id shorter than 6 gets given returns false")
        void whenAnIdShorterThan6GetsGivenReturnsFalse(String empID) {
            assertThat(false, equalTo(Validator.isValidEmployeeID(empID)));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1234567", "12345678", "123456789", "1234567890"})
        @DisplayName("when an id is longer than 6 gets given returns false")
        void whenAnIdIsLongerThan6GetsGivenReturnsFalse(String empID) {
            assertThat(false, equalTo(Validator.isValidEmployeeID(empID)));
        }

        @Test
        @DisplayName("when an id contains not only numbers, isValidEmployeeID returns false")
        void whenAnIdContainsNotOnlyNumbersIsValidEmployeeIdReturnsFalse() {
            assertThat(false, equalTo(Validator.isValidEmployeeID("A23456")));
        }

        @Test
        @DisplayName("when an id is exactly 6 characters long and only contains numbers, isValidEmployeeID returns true")
        void whenAnIdIsExactly6CharactersLongAndOnlyContainsNumbersIsValidEmployeeIdReturnsTrue() {
            assertThat(true, equalTo(Validator.isValidEmployeeID("123456")));
        }
    }

    @Nested
    class ValidGenderTests{
        @ParameterizedTest
        @ValueSource(strings={"X", "A","Q","D", "g", "5", "f", "m", "Fm", "Mm", "Ds"})
        @DisplayName("when gender other than F or M return false")
        void whenGenderIsAnyOtherThanFemaleOrMaleReturnFalse(String gender){
            assertThat(false, equalTo(Validator.isValidGender(gender)));
        }

        @Test
        @DisplayName("when gender if F should return true")
        void whenGenderIsFemaleShouldReturnTrue(){
            assertThat(true, equalTo(Validator.isValidGender("F")));
        }
         }



    @Nested
    class ValidCharacterTests{
        @ParameterizedTest
        @ValueSource(strings = {"ABABABA", "AB"})
        @DisplayName("given a string greater than 1 character is given, isValidCharacter returns false")
        void givenAStringGreaterThan1CharacterIsGivenIsValidCharacterReturnsFalse(String character) {
            assertThat(false, equalTo(Validator.isValidCharacter(character)));
        }

        @Test
        @DisplayName("given a string is 1 char long and lowercase, isValidCharacter returns false")
        void givenAStringIs1CharLongAndLowercaseIsValidCharacterReturnsFalse() {
            assertThat(false, equalTo(Validator.isValidCharacter("a")));
        }

        @Test
        @DisplayName("given a string is 1 char long and not a letter, isValidCharacter returns false")
        void givenAStringIs1CharLongAndNotALetterIsValidCharacterReturnsFalse() {
            assertThat(false, equalTo(Validator.isValidCharacter("1")));

        }

        @Test
        @DisplayName("given a string is 1 char long and an uppercase letter, isValidCharacter returns true")
        void givenAStringIs1CharLongAndAnUppercaseLetterIsValidCharacterReturnsTrue() {
            assertThat(true, equalTo(Validator.isValidCharacter("J")));
        }
    }

    @Nested
    class ValidEmailTests{
        @Test
        @DisplayName("given an email has all components, isValidEmail returns true")
        void givenAnEmailHasAllComponentsIsValidEmailReturnsTrue() {
            //assertThat(true, is(equalTo(Validator.isValidEmail("example15@example.co.uk"))));
            assertThat(Validator.isValidEmail("ex.Am-pl!e15@example.co.uk"), equalTo(true));
        }

        @ParameterizedTest
        @ValueSource(strings = {"usernamegoogle.com", ".example12@example.co.uk", "Example.example12@example.", ".com@exampe13"})
        @DisplayName("given an email don't have all component, isValidEmail returns false")
        void givenAnEmailDontHaveAllComponentIsValidEmailReturnsFalse(String email) {
            assertThat(false, equalTo(Validator.isValidEmail(email)));
        }

        
    }
    
    @Nested
    class ValidStringTests{
        @Test
        @DisplayName("given a string has characters other than letters in it, isValidString returns false")
        void givenAStringHasCharactersOtherThanLettersInItIsValidStringReturnsFalse() {
            assertThat(false, equalTo(Validator.isValidString("H3ll0")));
        }

        @Test
        @DisplayName("given a string is null, isValidString returns false")
        void givenAStringIsNullIsValidStringReturnsFalse() {
            assertThat(false, equalTo(Validator.isValidString(null)));
        }

    }

}
