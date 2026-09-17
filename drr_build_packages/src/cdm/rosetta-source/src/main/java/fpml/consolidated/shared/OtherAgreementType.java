package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.OtherAgreementTypeMeta;
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
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="OtherAgreementType", builder=OtherAgreementType.OtherAgreementTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OtherAgreementType", model="fpml", builder=OtherAgreementType.OtherAgreementTypeBuilderImpl.class, version="2.1.1")
public interface OtherAgreementType extends RosettaModelObject {

	OtherAgreementTypeMeta metaData = new OtherAgreementTypeMeta();

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
	String getAgreementTypeScheme();

	/*********************** Build Methods  ***********************/
	OtherAgreementType build();
	
	OtherAgreementType.OtherAgreementTypeBuilder toBuilder();
	
	static OtherAgreementType.OtherAgreementTypeBuilder builder() {
		return new OtherAgreementType.OtherAgreementTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OtherAgreementType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OtherAgreementType> getType() {
		return OtherAgreementType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("agreementTypeScheme"), String.class, getAgreementTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OtherAgreementTypeBuilder extends OtherAgreementType, RosettaModelObjectBuilder {
		OtherAgreementType.OtherAgreementTypeBuilder setValue(String value);
		OtherAgreementType.OtherAgreementTypeBuilder setAgreementTypeScheme(String agreementTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("agreementTypeScheme"), String.class, getAgreementTypeScheme(), this);
		}
		

		OtherAgreementType.OtherAgreementTypeBuilder prune();
	}

	/*********************** Immutable Implementation of OtherAgreementType  ***********************/
	class OtherAgreementTypeImpl implements OtherAgreementType {
		private final String value;
		private final String agreementTypeScheme;
		
		protected OtherAgreementTypeImpl(OtherAgreementType.OtherAgreementTypeBuilder builder) {
			this.value = builder.getValue();
			this.agreementTypeScheme = builder.getAgreementTypeScheme();
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
		@RosettaAttribute("agreementTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agreementTypeScheme")
		public String getAgreementTypeScheme() {
			return agreementTypeScheme;
		}
		
		@Override
		public OtherAgreementType build() {
			return this;
		}
		
		@Override
		public OtherAgreementType.OtherAgreementTypeBuilder toBuilder() {
			OtherAgreementType.OtherAgreementTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherAgreementType.OtherAgreementTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAgreementTypeScheme()).ifPresent(builder::setAgreementTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreementType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(agreementTypeScheme, _that.getAgreementTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (agreementTypeScheme != null ? agreementTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementType {" +
				"value=" + this.value + ", " +
				"agreementTypeScheme=" + this.agreementTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of OtherAgreementType  ***********************/
	class OtherAgreementTypeBuilderImpl implements OtherAgreementType.OtherAgreementTypeBuilder {
	
		protected String value;
		protected String agreementTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("agreementTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agreementTypeScheme")
		public String getAgreementTypeScheme() {
			return agreementTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public OtherAgreementType.OtherAgreementTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("agreementTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agreementTypeScheme")
		@Override
		public OtherAgreementType.OtherAgreementTypeBuilder setAgreementTypeScheme(String _agreementTypeScheme) {
			this.agreementTypeScheme = _agreementTypeScheme == null ? null : _agreementTypeScheme;
			return this;
		}
		
		@Override
		public OtherAgreementType build() {
			return new OtherAgreementType.OtherAgreementTypeImpl(this);
		}
		
		@Override
		public OtherAgreementType.OtherAgreementTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreementType.OtherAgreementTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAgreementTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreementType.OtherAgreementTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtherAgreementType.OtherAgreementTypeBuilder o = (OtherAgreementType.OtherAgreementTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAgreementTypeScheme(), o.getAgreementTypeScheme(), this::setAgreementTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreementType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(agreementTypeScheme, _that.getAgreementTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (agreementTypeScheme != null ? agreementTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementTypeBuilder {" +
				"value=" + this.value + ", " +
				"agreementTypeScheme=" + this.agreementTypeScheme +
			'}';
		}
	}
}
