package fpml.consolidated.doc;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.doc.meta.OrderIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that an identifier for an order.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that an identifier for an order.
 *
 */
@RosettaDataType(value="OrderId", builder=OrderId.OrderIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OrderId", model="fpml", builder=OrderId.OrderIdBuilderImpl.class, version="2.1.1")
public interface OrderId extends RosettaModelObject {

	OrderIdMeta metaData = new OrderIdMeta();

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
	String getValue();
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
	String getOrderIdScheme();

	/*********************** Build Methods  ***********************/
	OrderId build();
	
	OrderId.OrderIdBuilder toBuilder();
	
	static OrderId.OrderIdBuilder builder() {
		return new OrderId.OrderIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OrderId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OrderId> getType() {
		return OrderId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("orderIdScheme"), String.class, getOrderIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OrderIdBuilder extends OrderId, RosettaModelObjectBuilder {
		OrderId.OrderIdBuilder setValue(String value);
		OrderId.OrderIdBuilder setOrderIdScheme(String orderIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("orderIdScheme"), String.class, getOrderIdScheme(), this);
		}
		

		OrderId.OrderIdBuilder prune();
	}

	/*********************** Immutable Implementation of OrderId  ***********************/
	class OrderIdImpl implements OrderId {
		private final String value;
		private final String orderIdScheme;
		
		protected OrderIdImpl(OrderId.OrderIdBuilder builder) {
			this.value = builder.getValue();
			this.orderIdScheme = builder.getOrderIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("orderIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("orderIdScheme")
		public String getOrderIdScheme() {
			return orderIdScheme;
		}
		
		@Override
		public OrderId build() {
			return this;
		}
		
		@Override
		public OrderId.OrderIdBuilder toBuilder() {
			OrderId.OrderIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OrderId.OrderIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getOrderIdScheme()).ifPresent(builder::setOrderIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrderId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(orderIdScheme, _that.getOrderIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (orderIdScheme != null ? orderIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrderId {" +
				"value=" + this.value + ", " +
				"orderIdScheme=" + this.orderIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of OrderId  ***********************/
	class OrderIdBuilderImpl implements OrderId.OrderIdBuilder {
	
		protected String value;
		protected String orderIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("orderIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("orderIdScheme")
		public String getOrderIdScheme() {
			return orderIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public OrderId.OrderIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("orderIdScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("orderIdScheme")
		@Override
		public OrderId.OrderIdBuilder setOrderIdScheme(String _orderIdScheme) {
			this.orderIdScheme = _orderIdScheme == null ? null : _orderIdScheme;
			return this;
		}
		
		@Override
		public OrderId build() {
			return new OrderId.OrderIdImpl(this);
		}
		
		@Override
		public OrderId.OrderIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrderId.OrderIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getOrderIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OrderId.OrderIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OrderId.OrderIdBuilder o = (OrderId.OrderIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getOrderIdScheme(), o.getOrderIdScheme(), this::setOrderIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OrderId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(orderIdScheme, _that.getOrderIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (orderIdScheme != null ? orderIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OrderIdBuilder {" +
				"value=" + this.value + ", " +
				"orderIdScheme=" + this.orderIdScheme +
			'}';
		}
	}
}
