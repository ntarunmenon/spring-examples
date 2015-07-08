package org.namedEntityGraph;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

	@EntityGraph("graph.Order.items")
	public Iterable<Order> findAll();

}
