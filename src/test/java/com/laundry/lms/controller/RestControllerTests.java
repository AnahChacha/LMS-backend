package com.laundry.lms.controller;

import com.laundry.lms.config.LmsApplicationTests;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;

public class RestControllerTests extends LmsApplicationTests {

    @Test
    public void filterCustomerByDateRange() {
        LocalDate startDate = LocalDate.of(2023, 03, 11);
        LocalDate endDate = LocalDate.of(2023, 03, 29);

        given()
                .contentType(ContentType.JSON)
                .queryParam("startDate", startDate.toString())
                .queryParam("endDate", endDate.toString()).log().all()
                .get("reports/findCustomersByDateRange")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void filterStaffByDateRange() {
        LocalDate startDate = LocalDate.of(2023, 03, 11);
        LocalDate endDate = LocalDate.of(2023, 03, 29);

        given()
                .contentType(ContentType.JSON)
                .queryParam("startDate", startDate.toString())
                .queryParam("endDate", endDate.toString())
                .get("reports/findStaffsByDateRange")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void filterServicesByDateRange(){
        LocalDate startDate=LocalDate.of(2023,03,11);
        LocalDate endDate =LocalDate.of(2023,03,29);

        given()
                .contentType(ContentType.JSON)
                .queryParam("startDate",startDate.toString())
                .queryParam("endDate",endDate.toString())
                .get("reports/findServicesByDateRange")
                .then().log().all()
                .statusCode(200);
    }
}
