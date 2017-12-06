package com.cmcc.onenet.service;

import com.cmcc.onenet.Launch;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wannengjia@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringBootTest(classes = Launch.class)
public abstract class BaseServiceTest {  
 protected Logger logger = LoggerFactory.getLogger(getClass());
}
