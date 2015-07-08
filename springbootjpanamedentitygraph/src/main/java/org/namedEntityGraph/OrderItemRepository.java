package org.namedEntityGraph;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

}
