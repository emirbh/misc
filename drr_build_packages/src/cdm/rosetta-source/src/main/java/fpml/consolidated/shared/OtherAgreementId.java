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
import fpml.consolidated.shared.meta.OtherAgreementIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A agreement identifier allocated by a party. FpML does not define the domain values associated with this element. Note that the domain values for this element are not strictly an enumerated list.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A agreement identifier allocated by a party. FpML does not define the domain values associated with this element. Note that the domain values for this element are not strictly an enumerated list.
 *
 */
@RosettaDataType(value="OtherAgreementId", builder=OtherAgreementId.OtherAgreementIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OtherAgreementId", model="fpml", builder=OtherAgreementId.OtherAgreementIdBuilderImpl.class, version="2.1.1")
public interface OtherAgreementId extends RosettaModelObject {

	OtherAgreementIdMeta metaData = new OtherAgreementIdMeta();

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
	String getAgreementIdScheme();

	/*********************** Build Methods  ***********************/
	OtherAgreementId build();
	
	OtherAgreementId.OtherAgreementIdBuilder toBuilder();
	
	static OtherAgreementId.OtherAgreementIdBuilder builder() {
		return new OtherAgreementId.OtherAgreementIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OtherAgreementId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OtherAgreementId> getType() {
		return OtherAgreementId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("agreementIdScheme"), String.class, getAgreementIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OtherAgreementIdBuilder extends OtherAgreementId, RosettaModelObjectBuilder {
		OtherAgreementId.OtherAgreementIdBuilder setValue(String value);
		OtherAgreementId.OtherAgreementIdBuilder setAgreementIdScheme(String agreementIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("agreementIdScheme"), String.class, getAgreementIdScheme(), this);
		}
		

		OtherAgreementId.OtherAgreementIdBuilder prune();
	}

	/*********************** Immutable Implementation of OtherAgreementId  ***********************/
	class OtherAgreementIdImpl implements OtherAgreementId {
		private final String value;
		private final String agreementIdScheme;
		
		protected OtherAgreementIdImpl(OtherAgreementId.OtherAgreementIdBuilder builder) {
			this.value = builder.getValue();
			this.agreementIdScheme = builder.getAgreementIdScheme();
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
		@RosettaAttribute("agreementIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agreementIdScheme")
		public String getAgreementIdScheme() {
			return agreementIdScheme;
		}
		
		@Override
		public OtherAgreementId build() {
			return this;
		}
		
		@Override
		public OtherAgreementId.OtherAgreementIdBuilder toBuilder() {
			OtherAgreementId.OtherAgreementIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherAgreementId.OtherAgreementIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAgreementIdScheme()).ifPresent(builder::setAgreementIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreementId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(agreementIdScheme, _that.getAgreementIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (agreementIdScheme != null ? agreementIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementId {" +
				"value=" + this.value + ", " +
				"agreementIdScheme=" + this.agreementIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of OtherAgreementId  ***********************/
	class OtherAgreementIdBuilderImpl implements OtherAgreementId.OtherAgreementIdBuilder {
	
		protected String value;
		protected String agreementIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("agreementIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agreementIdScheme")
		public String getAgreementIdScheme() {
			return agreementIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public OtherAgreementId.OtherAgreementIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("agreementIdScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agreementIdScheme")
		@Override
		public OtherAgreementId.OtherAgreementIdBuilder setAgreementIdScheme(String _agreementIdScheme) {
			this.agreementIdScheme = _agreementIdScheme == null ? null : _agreementIdScheme;
			return this;
		}
		
		@Override
		public OtherAgreementId build() {
			return new OtherAgreementId.OtherAgreementIdImpl(this);
		}
		
		@Override
		public OtherAgreementId.OtherAgreementIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreementId.OtherAgreementIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAgreementIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreementId.OtherAgreementIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtherAgreementId.OtherAgreementIdBuilder o = (OtherAgreementId.OtherAgreementIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAgreementIdScheme(), o.getAgreementIdScheme(), this::setAgreementIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreementId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(agreementIdScheme, _that.getAgreementIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (agreementIdScheme != null ? agreementIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementIdBuilder {" +
				"value=" + this.value + ", " +
				"agreementIdScheme=" + this.agreementIdScheme +
			'}';
		}
	}
}
