package ru.itis.inf304.progEnikeyAuditor.singletone;

import org.junit.Test;
import org.junit.Assert;

public class SingletoneExampleTest {
    @Test
    public void testSingletonInstance() {
        // Проверка наличия класса в одном экземпляре
        SingletoneExample instance1 = SingletoneExample.getInstance();
        SingletoneExample instance2 = SingletoneExample.getInstance();
        // Сравнение двух экземпляров
        Assert.assertEquals(instance1, instance2);
    }
}
