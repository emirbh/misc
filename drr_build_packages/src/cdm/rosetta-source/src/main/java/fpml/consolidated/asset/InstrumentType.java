package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.InstrumentTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A taxonomic classification, or typology, for a security (e.g. ISO 10962 CFI code).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A taxonomic classification, or typology, for a security (e.g. ISO 10962 CFI code).
 *
 */
@RosettaDataType(value="InstrumentType", builder=InstrumentType.InstrumentTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InstrumentType", model="fpml", builder=InstrumentType.InstrumentTypeBuilderImpl.class, version="2.1.1")
public interface InstrumentType extends RosettaModelObject {

	InstrumentTypeMeta metaData = new InstrumentTypeMeta();

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
	String getInstrumentTypeScheme();

	/*********************** Build Methods  ***********************/
	InstrumentType build();
	
	InstrumentType.InstrumentTypeBuilder toBuilder();
	
	static InstrumentType.InstrumentTypeBuilder builder() {
		return new InstrumentType.InstrumentTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InstrumentType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InstrumentType> getType() {
		return InstrumentType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("instrumentTypeScheme"), String.class, getInstrumentTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InstrumentTypeBuilder extends InstrumentType, RosettaModelObjectBuilder {
		InstrumentType.InstrumentTypeBuilder setValue(String value);
		InstrumentType.InstrumentTypeBuilder setInstrumentTypeScheme(String instrumentTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("instrumentTypeScheme"), String.class, getInstrumentTypeScheme(), this);
		}
		

		InstrumentType.InstrumentTypeBuilder prune();
	}

	/*********************** Immutable Implementation of InstrumentType  ***********************/
	class InstrumentTypeImpl implements InstrumentType {
		private final String value;
		private final String instrumentTypeScheme;
		
		protected InstrumentTypeImpl(InstrumentType.InstrumentTypeBuilder builder) {
			this.value = builder.getValue();
			this.instrumentTypeScheme = builder.getInstrumentTypeScheme();
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
		@RosettaAttribute("instrumentTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("instrumentTypeScheme")
		public String getInstrumentTypeScheme() {
			return instrumentTypeScheme;
		}
		
		@Override
		public InstrumentType build() {
			return this;
		}
		
		@Override
		public InstrumentType.InstrumentTypeBuilder toBuilder() {
			InstrumentType.InstrumentTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InstrumentType.InstrumentTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getInstrumentTypeScheme()).ifPresent(builder::setInstrumentTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(instrumentTypeScheme, _that.getInstrumentTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (instrumentTypeScheme != null ? instrumentTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentType {" +
				"value=" + this.value + ", " +
				"instrumentTypeScheme=" + this.instrumentTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of InstrumentType  ***********************/
	class InstrumentTypeBuilderImpl implements InstrumentType.InstrumentTypeBuilder {
	
		protected String value;
		protected String instrumentTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("instrumentTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("instrumentTypeScheme")
		public String getInstrumentTypeScheme() {
			return instrumentTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public InstrumentType.InstrumentTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("instrumentTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("instrumentTypeScheme")
		@Override
		public InstrumentType.InstrumentTypeBuilder setInstrumentTypeScheme(String _instrumentTypeScheme) {
			this.instrumentTypeScheme = _instrumentTypeScheme == null ? null : _instrumentTypeScheme;
			return this;
		}
		
		@Override
		public InstrumentType build() {
			return new InstrumentType.InstrumentTypeImpl(this);
		}
		
		@Override
		public InstrumentType.InstrumentTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentType.InstrumentTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getInstrumentTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentType.InstrumentTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InstrumentType.InstrumentTypeBuilder o = (InstrumentType.InstrumentTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getInstrumentTypeScheme(), o.getInstrumentTypeScheme(), this::setInstrumentTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(instrumentTypeScheme, _that.getInstrumentTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (instrumentTypeScheme != null ? instrumentTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentTypeBuilder {" +
				"value=" + this.value + ", " +
				"instrumentTypeScheme=" + this.instrumentTypeScheme +
			'}';
		}
	}
}
