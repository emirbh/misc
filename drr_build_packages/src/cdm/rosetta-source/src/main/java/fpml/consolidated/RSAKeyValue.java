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
import fpml.consolidated.meta.RSAKeyValueMeta;


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
@RosettaDataType(value="RSAKeyValue", builder=RSAKeyValue.RSAKeyValueBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RSAKeyValue", model="fpml", builder=RSAKeyValue.RSAKeyValueBuilderImpl.class, version="2.1.1")
public interface RSAKeyValue extends RSAKeyValueType {

	RSAKeyValueMeta metaData = new RSAKeyValueMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	RSAKeyValue build();
	
	RSAKeyValue.RSAKeyValueBuilder toBuilder();
	
	static RSAKeyValue.RSAKeyValueBuilder builder() {
		return new RSAKeyValue.RSAKeyValueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RSAKeyValue> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RSAKeyValue> getType() {
		return RSAKeyValue.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("modulus"), String.class, getModulus(), this);
		processor.processBasic(path.newSubPath("exponent"), String.class, getExponent(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RSAKeyValueBuilder extends RSAKeyValue, RSAKeyValueType.RSAKeyValueTypeBuilder {
		@Override
		RSAKeyValue.RSAKeyValueBuilder setModulus(String modulus);
		@Override
		RSAKeyValue.RSAKeyValueBuilder setExponent(String exponent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("modulus"), String.class, getModulus(), this);
			processor.processBasic(path.newSubPath("exponent"), String.class, getExponent(), this);
		}
		

		RSAKeyValue.RSAKeyValueBuilder prune();
	}

	/*********************** Immutable Implementation of RSAKeyValue  ***********************/
	class RSAKeyValueImpl extends RSAKeyValueType.RSAKeyValueTypeImpl implements RSAKeyValue {
		
		protected RSAKeyValueImpl(RSAKeyValue.RSAKeyValueBuilder builder) {
			super(builder);
		}
		
		@Override
		public RSAKeyValue build() {
			return this;
		}
		
		@Override
		public RSAKeyValue.RSAKeyValueBuilder toBuilder() {
			RSAKeyValue.RSAKeyValueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RSAKeyValue.RSAKeyValueBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "RSAKeyValue {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RSAKeyValue  ***********************/
	class RSAKeyValueBuilderImpl extends RSAKeyValueType.RSAKeyValueTypeBuilderImpl implements RSAKeyValue.RSAKeyValueBuilder {
	
		
		@RosettaAttribute("modulus")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("modulus")
		@Override
		public RSAKeyValue.RSAKeyValueBuilder setModulus(String _modulus) {
			this.modulus = _modulus == null ? null : _modulus;
			return this;
		}
		
		@RosettaAttribute("exponent")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exponent")
		@Override
		public RSAKeyValue.RSAKeyValueBuilder setExponent(String _exponent) {
			this.exponent = _exponent == null ? null : _exponent;
			return this;
		}
		
		@Override
		public RSAKeyValue build() {
			return new RSAKeyValue.RSAKeyValueImpl(this);
		}
		
		@Override
		public RSAKeyValue.RSAKeyValueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RSAKeyValue.RSAKeyValueBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RSAKeyValue.RSAKeyValueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RSAKeyValue.RSAKeyValueBuilder o = (RSAKeyValue.RSAKeyValueBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "RSAKeyValueBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
