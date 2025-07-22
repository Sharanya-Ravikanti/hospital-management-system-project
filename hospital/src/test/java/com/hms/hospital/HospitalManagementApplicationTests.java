package com.hms.hospital;
import com.hms.hospital.HospitalManagementApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = HospitalManagementApplication.class)  // Explicitly specify the main class
class HospitalManagementApplicationTests {

    @Test
    void contextLoads() {
        // Test that the application context loads successfully
    }
}
