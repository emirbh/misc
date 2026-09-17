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
import fpml.consolidated.shared.meta.IssuerIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used for issuer identifiers.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type used for issuer identifiers.
 *
 */
@RosettaDataType(value="IssuerId", builder=IssuerId.IssuerIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="IssuerId", model="fpml", builder=IssuerId.IssuerIdBuilderImpl.class, version="2.1.1")
public interface IssuerId extends RosettaModelObject {

	IssuerIdMeta metaData = new IssuerIdMeta();

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
	String getIssuerIdScheme();

	/*********************** Build Methods  ***********************/
	IssuerId build();
	
	IssuerId.IssuerIdBuilder toBuilder();
	
	static IssuerId.IssuerIdBuilder builder() {
		return new IssuerId.IssuerIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IssuerId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IssuerId> getType() {
		return IssuerId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("issuerIdScheme"), String.class, getIssuerIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IssuerIdBuilder extends IssuerId, RosettaModelObjectBuilder {
		IssuerId.IssuerIdBuilder setValue(String value);
		IssuerId.IssuerIdBuilder setIssuerIdScheme(String issuerIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("issuerIdScheme"), String.class, getIssuerIdScheme(), this);
		}
		

		IssuerId.IssuerIdBuilder prune();
	}

	/*********************** Immutable Implementation of IssuerId  ***********************/
	class IssuerIdImpl implements IssuerId {
		private final String value;
		private final String issuerIdScheme;
		
		protected IssuerIdImpl(IssuerId.IssuerIdBuilder builder) {
			this.value = builder.getValue();
			this.issuerIdScheme = builder.getIssuerIdScheme();
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
		@RosettaAttribute("issuerIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("issuerIdScheme")
		public String getIssuerIdScheme() {
			return issuerIdScheme;
		}
		
		@Override
		public IssuerId build() {
			return this;
		}
		
		@Override
		public IssuerId.IssuerIdBuilder toBuilder() {
			IssuerId.IssuerIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IssuerId.IssuerIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getIssuerIdScheme()).ifPresent(builder::setIssuerIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(issuerIdScheme, _that.getIssuerIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (issuerIdScheme != null ? issuerIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerId {" +
				"value=" + this.value + ", " +
				"issuerIdScheme=" + this.issuerIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of IssuerId  ***********************/
	class IssuerIdBuilderImpl implements IssuerId.IssuerIdBuilder {
	
		protected String value;
		protected String issuerIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("issuerIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("issuerIdScheme")
		public String getIssuerIdScheme() {
			return issuerIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public IssuerId.IssuerIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("issuerIdScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuerIdScheme")
		@Override
		public IssuerId.IssuerIdBuilder setIssuerIdScheme(String _issuerIdScheme) {
			this.issuerIdScheme = _issuerIdScheme == null ? null : _issuerIdScheme;
			return this;
		}
		
		@Override
		public IssuerId build() {
			return new IssuerId.IssuerIdImpl(this);
		}
		
		@Override
		public IssuerId.IssuerIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerId.IssuerIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getIssuerIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IssuerId.IssuerIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IssuerId.IssuerIdBuilder o = (IssuerId.IssuerIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getIssuerIdScheme(), o.getIssuerIdScheme(), this::setIssuerIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IssuerId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(issuerIdScheme, _that.getIssuerIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (issuerIdScheme != null ? issuerIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IssuerIdBuilder {" +
				"value=" + this.value + ", " +
				"issuerIdScheme=" + this.issuerIdScheme +
			'}';
		}
	}
}
