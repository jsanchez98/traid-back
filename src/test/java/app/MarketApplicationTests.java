package app;

import app.controller.TraderController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MarketApplicationTests {

    @Autowired
    private TraderController traderController;

	@Test
	void contextLoads() {
	    assertThat(traderController).isNotNull();
	}

}
