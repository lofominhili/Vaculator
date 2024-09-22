package com.lofominhili.vaculator;

import com.lofominhili.vaculator.services.VaculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class VaculatorApplicationTests {

    @Autowired
    private VaculatorService vaculatorService;

    @Test
    void contextLoads() {
        assertThat(vaculatorService).isNotNull();
    }

}
