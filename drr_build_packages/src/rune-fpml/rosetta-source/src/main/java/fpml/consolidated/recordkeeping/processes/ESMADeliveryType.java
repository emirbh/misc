package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.recordkeeping.processes.meta.ESMADeliveryTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="ESMADeliveryType", builder=ESMADeliveryType.ESMADeliveryTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ESMADeliveryType", model="fpml", builder=ESMADeliveryType.ESMADeliveryTypeBuilderImpl.class, version="2.1.1")
public interface ESMADeliveryType extends RosettaModelObject {

	ESMADeliveryTypeMeta metaData = new ESMADeliveryTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
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
	 */
	String getDeliveryTypeScheme();

	/*********************** Build Methods  ***********************/
	ESMADeliveryType build();
	
	ESMADeliveryType.ESMADeliveryTypeBuilder toBuilder();
	
	static ESMADeliveryType.ESMADeliveryTypeBuilder builder() {
		return new ESMADeliveryType.ESMADeliveryTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ESMADeliveryType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ESMADeliveryType> getType() {
		return ESMADeliveryType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("deliveryTypeScheme"), String.class, getDeliveryTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ESMADeliveryTypeBuilder extends ESMADeliveryType, RosettaModelObjectBuilder {
		ESMADeliveryType.ESMADeliveryTypeBuilder setValue(String value);
		ESMADeliveryType.ESMADeliveryTypeBuilder setDeliveryTypeScheme(String deliveryTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("deliveryTypeScheme"), String.class, getDeliveryTypeScheme(), this);
		}
		

		ESMADeliveryType.ESMADeliveryTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ESMADeliveryType  ***********************/
	class ESMADeliveryTypeImpl implements ESMADeliveryType {
		private final String value;
		private final String deliveryTypeScheme;
		
		protected ESMADeliveryTypeImpl(ESMADeliveryType.ESMADeliveryTypeBuilder builder) {
			this.value = builder.getValue();
			this.deliveryTypeScheme = builder.getDeliveryTypeScheme();
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
		@RosettaAttribute("deliveryTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryTypeScheme")
		public String getDeliveryTypeScheme() {
			return deliveryTypeScheme;
		}
		
		@Override
		public ESMADeliveryType build() {
			return this;
		}
		
		@Override
		public ESMADeliveryType.ESMADeliveryTypeBuilder toBuilder() {
			ESMADeliveryType.ESMADeliveryTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ESMADeliveryType.ESMADeliveryTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getDeliveryTypeScheme()).ifPresent(builder::setDeliveryTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMADeliveryType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(deliveryTypeScheme, _that.getDeliveryTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (deliveryTypeScheme != null ? deliveryTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMADeliveryType {" +
				"value=" + this.value + ", " +
				"deliveryTypeScheme=" + this.deliveryTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ESMADeliveryType  ***********************/
	class ESMADeliveryTypeBuilderImpl implements ESMADeliveryType.ESMADeliveryTypeBuilder {
	
		protected String value;
		protected String deliveryTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("deliveryTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryTypeScheme")
		public String getDeliveryTypeScheme() {
			return deliveryTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ESMADeliveryType.ESMADeliveryTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("deliveryTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryTypeScheme")
		@Override
		public ESMADeliveryType.ESMADeliveryTypeBuilder setDeliveryTypeScheme(String _deliveryTypeScheme) {
			this.deliveryTypeScheme = _deliveryTypeScheme == null ? null : _deliveryTypeScheme;
			return this;
		}
		
		@Override
		public ESMADeliveryType build() {
			return new ESMADeliveryType.ESMADeliveryTypeImpl(this);
		}
		
		@Override
		public ESMADeliveryType.ESMADeliveryTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMADeliveryType.ESMADeliveryTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getDeliveryTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMADeliveryType.ESMADeliveryTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ESMADeliveryType.ESMADeliveryTypeBuilder o = (ESMADeliveryType.ESMADeliveryTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getDeliveryTypeScheme(), o.getDeliveryTypeScheme(), this::setDeliveryTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMADeliveryType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(deliveryTypeScheme, _that.getDeliveryTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (deliveryTypeScheme != null ? deliveryTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMADeliveryTypeBuilder {" +
				"value=" + this.value + ", " +
				"deliveryTypeScheme=" + this.deliveryTypeScheme +
			'}';
		}
	}
}
