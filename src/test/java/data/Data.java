package data;

import Objects.Account;
import Objects.Appointment;
import Utils.Utility;

public class Data {
    public static Account getAccount() {
        Account account = new Account();
        account.setUsername("John Doe");
        account.setPassword("ThisIsNotAPassword");
        return account;
    }

    public static Appointment getAppointment() {
        Appointment appointment = new Appointment();
        appointment.setFacility("Hongkong CURA Healthcare Center");
        appointment.setHospitalReadmission(true);
        appointment.setHealthcareProgram("Medicaid");
        appointment.setVisitDate(Utility.getDatetime());
        appointment.setComment("This is an example comment");
        return appointment;
    }
}
