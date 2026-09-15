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
import fpml.consolidated.com.meta.GasDeliveryPointMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A scheme identifying the types of the Delivery Point for a physically settled gas trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A scheme identifying the types of the Delivery Point for a physically settled gas trade.
 *
 */
@RosettaDataType(value="GasDeliveryPoint", builder=GasDeliveryPoint.GasDeliveryPointBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GasDeliveryPoint", model="fpml", builder=GasDeliveryPoint.GasDeliveryPointBuilderImpl.class, version="2.1.1")
public interface GasDeliveryPoint extends RosettaModelObject {

	GasDeliveryPointMeta metaData = new GasDeliveryPointMeta();

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
	GasDeliveryPoint build();
	
	GasDeliveryPoint.GasDeliveryPointBuilder toBuilder();
	
	static GasDeliveryPoint.GasDeliveryPointBuilder builder() {
		return new GasDeliveryPoint.GasDeliveryPointBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasDeliveryPoint> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GasDeliveryPoint> getType() {
		return GasDeliveryPoint.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("deliveryPointScheme"), String.class, getDeliveryPointScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasDeliveryPointBuilder extends GasDeliveryPoint, RosettaModelObjectBuilder {
		GasDeliveryPoint.GasDeliveryPointBuilder setValue(String value);
		GasDeliveryPoint.GasDeliveryPointBuilder setDeliveryPointScheme(String deliveryPointScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("deliveryPointScheme"), String.class, getDeliveryPointScheme(), this);
		}
		

		GasDeliveryPoint.GasDeliveryPointBuilder prune();
	}

	/*********************** Immutable Implementation of GasDeliveryPoint  ***********************/
	class GasDeliveryPointImpl implements GasDeliveryPoint {
		private final String value;
		private final String deliveryPointScheme;
		
		protected GasDeliveryPointImpl(GasDeliveryPoint.GasDeliveryPointBuilder builder) {
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
		public GasDeliveryPoint build() {
			return this;
		}
		
		@Override
		public GasDeliveryPoint.GasDeliveryPointBuilder toBuilder() {
			GasDeliveryPoint.GasDeliveryPointBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasDeliveryPoint.GasDeliveryPointBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDeliveryPointScheme()).ifPresent(builder::setDeliveryPointScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasDeliveryPoint _that = getType().cast(o);
		
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
			return "GasDeliveryPoint {" +
				"value=" + this.value + ", " +
				"deliveryPointScheme=" + this.deliveryPointScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of GasDeliveryPoint  ***********************/
	class GasDeliveryPointBuilderImpl implements GasDeliveryPoint.GasDeliveryPointBuilder {
	
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
		public GasDeliveryPoint.GasDeliveryPointBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("deliveryPointScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPointScheme")
		@Override
		public GasDeliveryPoint.GasDeliveryPointBuilder setDeliveryPointScheme(String _deliveryPointScheme) {
			this.deliveryPointScheme = _deliveryPointScheme == null ? null : _deliveryPointScheme;
			return this;
		}
		
		@Override
		public GasDeliveryPoint build() {
			return new GasDeliveryPoint.GasDeliveryPointImpl(this);
		}
		
		@Override
		public GasDeliveryPoint.GasDeliveryPointBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasDeliveryPoint.GasDeliveryPointBuilder prune() {
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
		public GasDeliveryPoint.GasDeliveryPointBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GasDeliveryPoint.GasDeliveryPointBuilder o = (GasDeliveryPoint.GasDeliveryPointBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDeliveryPointScheme(), o.getDeliveryPointScheme(), this::setDeliveryPointScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasDeliveryPoint _that = getType().cast(o);
		
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
			return "GasDeliveryPointBuilder {" +
				"value=" + this.value + ", " +
				"deliveryPointScheme=" + this.deliveryPointScheme +
			'}';
		}
	}
}
