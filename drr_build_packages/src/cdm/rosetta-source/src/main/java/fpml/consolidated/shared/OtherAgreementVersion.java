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
import fpml.consolidated.shared.meta.OtherAgreementVersionMeta;
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
@RosettaDataType(value="OtherAgreementVersion", builder=OtherAgreementVersion.OtherAgreementVersionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OtherAgreementVersion", model="fpml", builder=OtherAgreementVersion.OtherAgreementVersionBuilderImpl.class, version="2.1.1")
public interface OtherAgreementVersion extends RosettaModelObject {

	OtherAgreementVersionMeta metaData = new OtherAgreementVersionMeta();

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
	String getAgreementVersionScheme();

	/*********************** Build Methods  ***********************/
	OtherAgreementVersion build();
	
	OtherAgreementVersion.OtherAgreementVersionBuilder toBuilder();
	
	static OtherAgreementVersion.OtherAgreementVersionBuilder builder() {
		return new OtherAgreementVersion.OtherAgreementVersionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OtherAgreementVersion> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OtherAgreementVersion> getType() {
		return OtherAgreementVersion.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("agreementVersionScheme"), String.class, getAgreementVersionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OtherAgreementVersionBuilder extends OtherAgreementVersion, RosettaModelObjectBuilder {
		OtherAgreementVersion.OtherAgreementVersionBuilder setValue(String value);
		OtherAgreementVersion.OtherAgreementVersionBuilder setAgreementVersionScheme(String agreementVersionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("agreementVersionScheme"), String.class, getAgreementVersionScheme(), this);
		}
		

		OtherAgreementVersion.OtherAgreementVersionBuilder prune();
	}

	/*********************** Immutable Implementation of OtherAgreementVersion  ***********************/
	class OtherAgreementVersionImpl implements OtherAgreementVersion {
		private final String value;
		private final String agreementVersionScheme;
		
		protected OtherAgreementVersionImpl(OtherAgreementVersion.OtherAgreementVersionBuilder builder) {
			this.value = builder.getValue();
			this.agreementVersionScheme = builder.getAgreementVersionScheme();
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
		@RosettaAttribute("agreementVersionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agreementVersionScheme")
		public String getAgreementVersionScheme() {
			return agreementVersionScheme;
		}
		
		@Override
		public OtherAgreementVersion build() {
			return this;
		}
		
		@Override
		public OtherAgreementVersion.OtherAgreementVersionBuilder toBuilder() {
			OtherAgreementVersion.OtherAgreementVersionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherAgreementVersion.OtherAgreementVersionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAgreementVersionScheme()).ifPresent(builder::setAgreementVersionScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreementVersion _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(agreementVersionScheme, _that.getAgreementVersionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (agreementVersionScheme != null ? agreementVersionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementVersion {" +
				"value=" + this.value + ", " +
				"agreementVersionScheme=" + this.agreementVersionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of OtherAgreementVersion  ***********************/
	class OtherAgreementVersionBuilderImpl implements OtherAgreementVersion.OtherAgreementVersionBuilder {
	
		protected String value;
		protected String agreementVersionScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("agreementVersionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agreementVersionScheme")
		public String getAgreementVersionScheme() {
			return agreementVersionScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public OtherAgreementVersion.OtherAgreementVersionBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("agreementVersionScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agreementVersionScheme")
		@Override
		public OtherAgreementVersion.OtherAgreementVersionBuilder setAgreementVersionScheme(String _agreementVersionScheme) {
			this.agreementVersionScheme = _agreementVersionScheme == null ? null : _agreementVersionScheme;
			return this;
		}
		
		@Override
		public OtherAgreementVersion build() {
			return new OtherAgreementVersion.OtherAgreementVersionImpl(this);
		}
		
		@Override
		public OtherAgreementVersion.OtherAgreementVersionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreementVersion.OtherAgreementVersionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAgreementVersionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreementVersion.OtherAgreementVersionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtherAgreementVersion.OtherAgreementVersionBuilder o = (OtherAgreementVersion.OtherAgreementVersionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAgreementVersionScheme(), o.getAgreementVersionScheme(), this::setAgreementVersionScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreementVersion _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(agreementVersionScheme, _that.getAgreementVersionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (agreementVersionScheme != null ? agreementVersionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementVersionBuilder {" +
				"value=" + this.value + ", " +
				"agreementVersionScheme=" + this.agreementVersionScheme +
			'}';
		}
	}
}
