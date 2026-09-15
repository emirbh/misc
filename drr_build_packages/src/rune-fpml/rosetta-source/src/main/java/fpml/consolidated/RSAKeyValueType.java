package fpml.consolidated;

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
import fpml.consolidated.meta.RSAKeyValueTypeMeta;
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
@RosettaDataType(value="RSAKeyValueType", builder=RSAKeyValueType.RSAKeyValueTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RSAKeyValueType", model="fpml", builder=RSAKeyValueType.RSAKeyValueTypeBuilderImpl.class, version="2.1.1")
public interface RSAKeyValueType extends RosettaModelObject {

	RSAKeyValueTypeMeta metaData = new RSAKeyValueTypeMeta();

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
	String getModulus();
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
	String getExponent();

	/*********************** Build Methods  ***********************/
	RSAKeyValueType build();
	
	RSAKeyValueType.RSAKeyValueTypeBuilder toBuilder();
	
	static RSAKeyValueType.RSAKeyValueTypeBuilder builder() {
		return new RSAKeyValueType.RSAKeyValueTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RSAKeyValueType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RSAKeyValueType> getType() {
		return RSAKeyValueType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("modulus"), String.class, getModulus(), this);
		processor.processBasic(path.newSubPath("exponent"), String.class, getExponent(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RSAKeyValueTypeBuilder extends RSAKeyValueType, RosettaModelObjectBuilder {
		RSAKeyValueType.RSAKeyValueTypeBuilder setModulus(String modulus);
		RSAKeyValueType.RSAKeyValueTypeBuilder setExponent(String exponent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("modulus"), String.class, getModulus(), this);
			processor.processBasic(path.newSubPath("exponent"), String.class, getExponent(), this);
		}
		

		RSAKeyValueType.RSAKeyValueTypeBuilder prune();
	}

	/*********************** Immutable Implementation of RSAKeyValueType  ***********************/
	class RSAKeyValueTypeImpl implements RSAKeyValueType {
		private final String modulus;
		private final String exponent;
		
		protected RSAKeyValueTypeImpl(RSAKeyValueType.RSAKeyValueTypeBuilder builder) {
			this.modulus = builder.getModulus();
			this.exponent = builder.getExponent();
		}
		
		@Override
		@RosettaAttribute("modulus")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("modulus")
		public String getModulus() {
			return modulus;
		}
		
		@Override
		@RosettaAttribute("exponent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exponent")
		public String getExponent() {
			return exponent;
		}
		
		@Override
		public RSAKeyValueType build() {
			return this;
		}
		
		@Override
		public RSAKeyValueType.RSAKeyValueTypeBuilder toBuilder() {
			RSAKeyValueType.RSAKeyValueTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RSAKeyValueType.RSAKeyValueTypeBuilder builder) {
			ofNullable(getModulus()).ifPresent(builder::setModulus);
			ofNullable(getExponent()).ifPresent(builder::setExponent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RSAKeyValueType _that = getType().cast(o);
		
			if (!Objects.equals(modulus, _that.getModulus())) return false;
			if (!Objects.equals(exponent, _that.getExponent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (modulus != null ? modulus.hashCode() : 0);
			_result = 31 * _result + (exponent != null ? exponent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RSAKeyValueType {" +
				"modulus=" + this.modulus + ", " +
				"exponent=" + this.exponent +
			'}';
		}
	}

	/*********************** Builder Implementation of RSAKeyValueType  ***********************/
	class RSAKeyValueTypeBuilderImpl implements RSAKeyValueType.RSAKeyValueTypeBuilder {
	
		protected String modulus;
		protected String exponent;
		
		@Override
		@RosettaAttribute("modulus")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("modulus")
		public String getModulus() {
			return modulus;
		}
		
		@Override
		@RosettaAttribute("exponent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exponent")
		public String getExponent() {
			return exponent;
		}
		
		@RosettaAttribute("modulus")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("modulus")
		@Override
		public RSAKeyValueType.RSAKeyValueTypeBuilder setModulus(String _modulus) {
			this.modulus = _modulus == null ? null : _modulus;
			return this;
		}
		
		@RosettaAttribute("exponent")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exponent")
		@Override
		public RSAKeyValueType.RSAKeyValueTypeBuilder setExponent(String _exponent) {
			this.exponent = _exponent == null ? null : _exponent;
			return this;
		}
		
		@Override
		public RSAKeyValueType build() {
			return new RSAKeyValueType.RSAKeyValueTypeImpl(this);
		}
		
		@Override
		public RSAKeyValueType.RSAKeyValueTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RSAKeyValueType.RSAKeyValueTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getModulus()!=null) return true;
			if (getExponent()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RSAKeyValueType.RSAKeyValueTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RSAKeyValueType.RSAKeyValueTypeBuilder o = (RSAKeyValueType.RSAKeyValueTypeBuilder) other;
			
			
			merger.mergeBasic(getModulus(), o.getModulus(), this::setModulus);
			merger.mergeBasic(getExponent(), o.getExponent(), this::setExponent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RSAKeyValueType _that = getType().cast(o);
		
			if (!Objects.equals(modulus, _that.getModulus())) return false;
			if (!Objects.equals(exponent, _that.getExponent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (modulus != null ? modulus.hashCode() : 0);
			_result = 31 * _result + (exponent != null ? exponent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RSAKeyValueTypeBuilder {" +
				"modulus=" + this.modulus + ", " +
				"exponent=" + this.exponent +
			'}';
		}
	}
}
