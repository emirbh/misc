package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CoalDeliveryPointMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A scheme identifying the types of the Delivery Point for a physically settled coal trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A scheme identifying the types of the Delivery Point for a physically settled coal trade.
 *
 */
@RosettaDataType(value="CoalDeliveryPoint", builder=CoalDeliveryPoint.CoalDeliveryPointBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CoalDeliveryPoint", model="fpml", builder=CoalDeliveryPoint.CoalDeliveryPointBuilderImpl.class, version="2.1.1")
public interface CoalDeliveryPoint extends RosettaModelObject {

	CoalDeliveryPointMeta metaData = new CoalDeliveryPointMeta();

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
	String getDeliveryPointScheme();

	/*********************** Build Methods  ***********************/
	CoalDeliveryPoint build();
	
	CoalDeliveryPoint.CoalDeliveryPointBuilder toBuilder();
	
	static CoalDeliveryPoint.CoalDeliveryPointBuilder builder() {
		return new CoalDeliveryPoint.CoalDeliveryPointBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CoalDeliveryPoint> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CoalDeliveryPoint> getType() {
		return CoalDeliveryPoint.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("deliveryPointScheme"), String.class, getDeliveryPointScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CoalDeliveryPointBuilder extends CoalDeliveryPoint, RosettaModelObjectBuilder {
		CoalDeliveryPoint.CoalDeliveryPointBuilder setValue(String value);
		CoalDeliveryPoint.CoalDeliveryPointBuilder setDeliveryPointScheme(String deliveryPointScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("deliveryPointScheme"), String.class, getDeliveryPointScheme(), this);
		}
		

		CoalDeliveryPoint.CoalDeliveryPointBuilder prune();
	}

	/*********************** Immutable Implementation of CoalDeliveryPoint  ***********************/
	class CoalDeliveryPointImpl implements CoalDeliveryPoint {
		private final String value;
		private final String deliveryPointScheme;
		
		protected CoalDeliveryPointImpl(CoalDeliveryPoint.CoalDeliveryPointBuilder builder) {
			this.value = builder.getValue();
			this.deliveryPointScheme = builder.getDeliveryPointScheme();
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
		@RosettaAttribute("deliveryPointScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPointScheme")
		public String getDeliveryPointScheme() {
			return deliveryPointScheme;
		}
		
		@Override
		public CoalDeliveryPoint build() {
			return this;
		}
		
		@Override
		public CoalDeliveryPoint.CoalDeliveryPointBuilder toBuilder() {
			CoalDeliveryPoint.CoalDeliveryPointBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CoalDeliveryPoint.CoalDeliveryPointBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDeliveryPointScheme()).ifPresent(builder::setDeliveryPointScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalDeliveryPoint _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(deliveryPointScheme, _that.getDeliveryPointScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (deliveryPointScheme != null ? deliveryPointScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalDeliveryPoint {" +
				"value=" + this.value + ", " +
				"deliveryPointScheme=" + this.deliveryPointScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CoalDeliveryPoint  ***********************/
	class CoalDeliveryPointBuilderImpl implements CoalDeliveryPoint.CoalDeliveryPointBuilder {
	
		protected String value;
		protected String deliveryPointScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("deliveryPointScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPointScheme")
		public String getDeliveryPointScheme() {
			return deliveryPointScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CoalDeliveryPoint.CoalDeliveryPointBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("deliveryPointScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPointScheme")
		@Override
		public CoalDeliveryPoint.CoalDeliveryPointBuilder setDeliveryPointScheme(String _deliveryPointScheme) {
			this.deliveryPointScheme = _deliveryPointScheme == null ? null : _deliveryPointScheme;
			return this;
		}
		
		@Override
		public CoalDeliveryPoint build() {
			return new CoalDeliveryPoint.CoalDeliveryPointImpl(this);
		}
		
		@Override
		public CoalDeliveryPoint.CoalDeliveryPointBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalDeliveryPoint.CoalDeliveryPointBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getDeliveryPointScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CoalDeliveryPoint.CoalDeliveryPointBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CoalDeliveryPoint.CoalDeliveryPointBuilder o = (CoalDeliveryPoint.CoalDeliveryPointBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDeliveryPointScheme(), o.getDeliveryPointScheme(), this::setDeliveryPointScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CoalDeliveryPoint _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(deliveryPointScheme, _that.getDeliveryPointScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (deliveryPointScheme != null ? deliveryPointScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CoalDeliveryPointBuilder {" +
				"value=" + this.value + ", " +
				"deliveryPointScheme=" + this.deliveryPointScheme +
			'}';
		}
	}
}
