package org.namedentitygraph;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.namedEntityGraph.Order;
import org.namedEntityGraph.OrderItem;
import org.namedEntityGraph.OrderRepository;
import org.namedEntityGraph.SpringbootjpaNamedEntityGraphApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootjpaNamedEntityGraphApplication.class)
@WebAppConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("/META-INF/dbtest/sampleData.xml")
public class SpringbootjpaNamedEntityGraphApplicationTests {

	@Autowired
	private OrderRepository orderRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testNamedEntityGraphOrderItems() {
		Iterable<Order> orders = orderRepository.findAll();
		assertThat(orders, is(notNullValue()));
		for (Order order : orders) {
			assertThat(order.getItems(), is(notNullValue()));
			for (OrderItem orderItem : order.getItems()) {
				assertThat(orderItem.getProduct(), is(notNullValue()));
			}
		}
		System.out.println(orders);
	}

}
