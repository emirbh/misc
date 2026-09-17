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
import fpml.consolidated.com.meta.ElectricityTransmissionContingencyTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The type of transmission contingency, i.e. what portion of the transmission the delivery obligations are applicable.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The type of transmission contingency, i.e. what portion of the transmission the delivery obligations are applicable.
 *
 */
@RosettaDataType(value="ElectricityTransmissionContingencyType", builder=ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ElectricityTransmissionContingencyType", model="fpml", builder=ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilderImpl.class, version="2.1.1")
public interface ElectricityTransmissionContingencyType extends RosettaModelObject {

	ElectricityTransmissionContingencyTypeMeta metaData = new ElectricityTransmissionContingencyTypeMeta();

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
	String getElectricityTransmissionContingencyScheme();

	/*********************** Build Methods  ***********************/
	ElectricityTransmissionContingencyType build();
	
	ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder toBuilder();
	
	static ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder builder() {
		return new ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityTransmissionContingencyType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ElectricityTransmissionContingencyType> getType() {
		return ElectricityTransmissionContingencyType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("electricityTransmissionContingencyScheme"), String.class, getElectricityTransmissionContingencyScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityTransmissionContingencyTypeBuilder extends ElectricityTransmissionContingencyType, RosettaModelObjectBuilder {
		ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder setValue(String value);
		ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder setElectricityTransmissionContingencyScheme(String electricityTransmissionContingencyScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("electricityTransmissionContingencyScheme"), String.class, getElectricityTransmissionContingencyScheme(), this);
		}
		

		ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityTransmissionContingencyType  ***********************/
	class ElectricityTransmissionContingencyTypeImpl implements ElectricityTransmissionContingencyType {
		private final String value;
		private final String electricityTransmissionContingencyScheme;
		
		protected ElectricityTransmissionContingencyTypeImpl(ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder builder) {
			this.value = builder.getValue();
			this.electricityTransmissionContingencyScheme = builder.getElectricityTransmissionContingencyScheme();
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
		@RosettaAttribute("electricityTransmissionContingencyScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("electricityTransmissionContingencyScheme")
		public String getElectricityTransmissionContingencyScheme() {
			return electricityTransmissionContingencyScheme;
		}
		
		@Override
		public ElectricityTransmissionContingencyType build() {
			return this;
		}
		
		@Override
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder toBuilder() {
			ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getElectricityTransmissionContingencyScheme()).ifPresent(builder::setElectricityTransmissionContingencyScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityTransmissionContingencyType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(electricityTransmissionContingencyScheme, _that.getElectricityTransmissionContingencyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (electricityTransmissionContingencyScheme != null ? electricityTransmissionContingencyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityTransmissionContingencyType {" +
				"value=" + this.value + ", " +
				"electricityTransmissionContingencyScheme=" + this.electricityTransmissionContingencyScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityTransmissionContingencyType  ***********************/
	class ElectricityTransmissionContingencyTypeBuilderImpl implements ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder {
	
		protected String value;
		protected String electricityTransmissionContingencyScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("electricityTransmissionContingencyScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("electricityTransmissionContingencyScheme")
		public String getElectricityTransmissionContingencyScheme() {
			return electricityTransmissionContingencyScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("electricityTransmissionContingencyScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("electricityTransmissionContingencyScheme")
		@Override
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder setElectricityTransmissionContingencyScheme(String _electricityTransmissionContingencyScheme) {
			this.electricityTransmissionContingencyScheme = _electricityTransmissionContingencyScheme == null ? null : _electricityTransmissionContingencyScheme;
			return this;
		}
		
		@Override
		public ElectricityTransmissionContingencyType build() {
			return new ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeImpl(this);
		}
		
		@Override
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getElectricityTransmissionContingencyScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder o = (ElectricityTransmissionContingencyType.ElectricityTransmissionContingencyTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getElectricityTransmissionContingencyScheme(), o.getElectricityTransmissionContingencyScheme(), this::setElectricityTransmissionContingencyScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityTransmissionContingencyType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(electricityTransmissionContingencyScheme, _that.getElectricityTransmissionContingencyScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (electricityTransmissionContingencyScheme != null ? electricityTransmissionContingencyScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityTransmissionContingencyTypeBuilder {" +
				"value=" + this.value + ", " +
				"electricityTransmissionContingencyScheme=" + this.electricityTransmissionContingencyScheme +
			'}';
		}
	}
}
