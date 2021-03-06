package com.springcurso.service.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HashUtilTests {

    @Test
    public void getSecureHashTest() {
        String hash = HashUtil.getSecureHash("123");
        System.out.println("CODIGO " + hash);
        assertThat(hash.length()).isEqualTo(64);
    }
}
