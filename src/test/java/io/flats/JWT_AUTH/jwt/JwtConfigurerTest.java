package io.flats.JWT_AUTH.jwt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtConfigurer.class, JwtTokenProvider.class})
@ExtendWith(SpringExtension.class)
public class JwtConfigurerTest {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

//    @Test
//    public void testConstructor() {
//        // TODO: This test is incomplete.
//        //   Reason: No meaningful assertions found.
//        //   To help Diffblue Cover to find assertions, please add getters to the
//        //   class under test that return fields written by the method under test.
//        //   See https://diff.blue/R004
//
//        new JwtConfigurer(this.jwtTokenProvider);
//    }
}

