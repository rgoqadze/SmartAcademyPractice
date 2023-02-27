package DataObject;

import com.github.javafaker.Faker;




public interface RegistrationData {

    String
            companyNameValue = "Company Name",
            personalIDStringValue = "Company",
            addressValue = "Chavchavadze St. #24",
            phoneStringValue = "phone",
            dateShortValue = "day",
            dateValue = "wednesday",
            emailValue = "test@gmail.com",
            emailWrongValue1 = "test@gmail",
            emailWrongValue2 = "test.gmail@",
            getEmailWrongValue3 = "test.gmail@";

    int
            personalIDShortValue =111111,
            personalIDLongValue = 1010300010,
            personalIDValue = 100000001,
            phoneShortValue = 12345678,
            phoneLongValue = 100020303,
            phoneValue = 123456789;
}
