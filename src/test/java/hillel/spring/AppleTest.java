package hillel.spring;

import org.junit.Test;
import lombok.val;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppleTest {
        @Test
        public void lombokWorks() throws Exception {
                val apple = new Apple(100, "Green");

               Assertions. assertThat(apple.getColor()).isEqualTo("Green");

               Assertions. assertThat(apple).isEqualTo(new Apple(100, "Green"));

        }

}