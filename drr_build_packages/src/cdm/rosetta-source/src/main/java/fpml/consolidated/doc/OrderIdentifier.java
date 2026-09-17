package fpml.consolidated.doc;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.doc.meta.OrderIdentifierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that an order's identifier(s).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that an order's identifier(s).
 *
 */
@RosettaDataType(value="OrderIdentifier", builder=OrderIdentifier.OrderIdentifierBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OrderIdentifier", model="fpml", builder=OrderIdentifier.OrderIdentifierBuilderImpl.class, version="2.1.1")
public interface OrderIdentifier extends RosettaModelObject {

	OrderIdentifierMeta metaData = new OrderIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	OrderId getOrderId();

	/*********************** Build Methods  ***********************/
	OrderIdentifier build();
	
	OrderIdentifier.OrderIdentifierBuilder toBuilder();
	
	static OrderIdentifier.OrderIdentifierBuilder builder() {
		return new OrderIdentifier.OrderIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OrderIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OrderIdentifier> getType() {
		return OrderIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("orderId"), processor, OrderId.class, getOrderId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OrderIdentifierBuilder extends OrderIdentifier, RosettaModelObjectBuilder {
		OrderId.OrderIdBuilder getOrCreateOrderId();
		@Override
		OrderId.OrderIdBuilder getOrderId();
		OrderIdentifier.OrderIdentifierBuilder setOrderId(OrderId orderId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("orderId"), processor, OrderId.OrderIdBuilder.class, getOrderId());
		}
		

		OrderIdentifier.OrderIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of OrderIdentifier  ***********************/
	class OrderIdentifierImpl implements OrderIdentifier {
		private final OrderId orderId;
		
		protected OrderIdentifierImpl(OrderIdentifier.OrderIdentifierBuilder builder) {
			this.orderId = ofNullable(builder.getOrderId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("orderId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("orderId")
		public OrderId getOrderId() {
			return orderId;
		}
		
		@Override
		public OrderIdentifier build() {
			return this;
		}
		
		@Override
		public OrderIdentifier.OrderIdentifierBuilder toBuilder() {
			OrderIdentifier.OrderIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OrderIdentifier.OrderIdentifierBuilder builder) {
			ofNullable(getOrderId()).ifPresent(builder::setOrderId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrderIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(orderId, _that.getOrderId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (orderId != null ? orderId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrderIdentifier {" +
				"orderId=" + this.orderId +
			'}';
		}
	}

	/*********************** Builder Implementation of OrderIdentifier  ***********************/
	class OrderIdentifierBuilderImpl implements OrderIdentifier.OrderIdentifierBuilder {
	
		protected OrderId.OrderIdBuilder orderId;
		
		@Override
		@RosettaAttribute("orderId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("orderId")
		public OrderId.OrderIdBuilder getOrderId() {
			return orderId;
		}
		
		@Override
		public OrderId.OrderIdBuilder getOrCreateOrderId() {
			OrderId.OrderIdBuilder result;
			if (orderId!=null) {
				result = orderId;
			}
			else {
				result = orderId = OrderId.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("orderId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("orderId")
		@Override
		public OrderIdentifier.OrderIdentifierBuilder setOrderId(OrderId _orderId) {
			this.orderId = _orderId == null ? null : _orderId.toBuilder();
			return this;
		}
		
		@Override
		public OrderIdentifier build() {
			return new OrderIdentifier.OrderIdentifierImpl(this);
		}
		
		@Override
		public OrderIdentifier.OrderIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrderIdentifier.OrderIdentifierBuilder prune() {
			if (orderId!=null && !orderId.prune().hasData()) orderId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOrderId()!=null && getOrderId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrderIdentifier.OrderIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OrderIdentifier.OrderIdentifierBuilder o = (OrderIdentifier.OrderIdentifierBuilder) other;
			
			merger.mergeRosetta(getOrderId(), o.getOrderId(), this::setOrderId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrderIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(orderId, _that.getOrderId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (orderId != null ? orderId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrderIdentifierBuilder {" +
				"orderId=" + this.orderId +
			'}';
		}
	}
}
