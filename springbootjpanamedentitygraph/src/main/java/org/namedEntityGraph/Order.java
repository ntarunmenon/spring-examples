package org.namedEntityGraph;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "purchaseOrder")
@NamedEntityGraphs({ @NamedEntityGraph(name = "graph.Order.items", attributeNodes = @NamedAttributeNode(value = "items", subgraph = "items"), subgraphs = @NamedSubgraph(name = "items", attributeNodes = @NamedAttributeNode("product"))) })
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id = null;
	@Version
	@Column(name = "version")
	private int version = 0;

	@Column
	private String orderNumber;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private Set<OrderItem> items = new HashSet<OrderItem>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", version=" + version + ", orderNumber="
				+ orderNumber + "]";
	}

}