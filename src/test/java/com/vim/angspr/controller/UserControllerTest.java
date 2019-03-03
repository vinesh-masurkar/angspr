package com.vim.angspr.controller;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.jayway.restassured.response.Header;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserControllerTest {

    private UserController controller;

    @Before
    public void setup(){
        controller = new UserController();
    }

    @Test
    public void ping() {
        ResponseEntity<String> expected = new ResponseEntity<>(
                "User Service says Hello",
                HttpStatus.OK);

        //when(controller.ping()).thenReturn(true);

        given()
                .standaloneSetup(controller)
                .header(new Header("Content-Type", "application/json"))
            .when()
                .get("angspr/ping")
            .then()
                .statusCode(HttpStatus.OK.value())
                .body(Matchers.equalTo(expected.getBody()));

        //ArgumentCaptor<String> latLongCaptor = ArgumentCaptor.forClass(String.class);

        //Mockito.verify(mockService).isWithinGeofence(latLongCaptor.capture());

        //Assert.assertThat(latLongCaptor.getValue(), Matchers.equalTo(latLong));
    }

}