package com.Project;

import com.Project.controller.Second;
import com.Project.model.SecondModel;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import static java.lang.String.valueOf;
import static junit.framework.TestCase.assertTrue;

import static junit.framework.TestCase.assertFalse;

public class FirstTest {
    Second second;
    SecondModel model;
    final static Logger logger = Logger.getLogger(valueOf(Second.class));

    @Before
    public void setUp()
    {
        logger.info("Odpalam setUp");
        second = new Second();
    }

    @Test
    public void InNotCorrectData()
    {
        List numbers = null;
        assertFalse(second.isCorrectNumbers(numbers));
    }

    @Test
    public void InCorrectData()
    {
        List numbers = new ArrayList();
        numbers.add(5);
        numbers.add(2);
        numbers.add(7);
        numbers.add(1);
        assertTrue(second.isCorrectNumbers(numbers));
    }



}
