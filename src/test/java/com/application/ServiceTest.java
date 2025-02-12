package com.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    private Service service;

    @BeforeEach
    void setUp() {
        service = new Service();
    }

    @Test
    void getPhotoReturnsString() {
        String result = service.getPhoto("photoId");
        assertEquals("Photo photoId", result);
    }
}
