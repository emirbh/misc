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
import fpml.consolidated.meta.SignatureValueMeta;


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
@RosettaDataType(value="SignatureValue", builder=SignatureValue.SignatureValueBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SignatureValue", model="fpml", builder=SignatureValue.SignatureValueBuilderImpl.class, version="2.1.1")
public interface SignatureValue extends SignatureValueType {

	SignatureValueMeta metaData = new SignatureValueMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	SignatureValue build();
	
	SignatureValue.SignatureValueBuilder toBuilder();
	
	static SignatureValue.SignatureValueBuilder builder() {
		return new SignatureValue.SignatureValueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SignatureValue> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SignatureValue> getType() {
		return SignatureValue.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SignatureValueBuilder extends SignatureValue, SignatureValueType.SignatureValueTypeBuilder {
		@Override
		SignatureValue.SignatureValueBuilder setValue(String value);
		@Override
		SignatureValue.SignatureValueBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		SignatureValue.SignatureValueBuilder prune();
	}

	/*********************** Immutable Implementation of SignatureValue  ***********************/
	class SignatureValueImpl extends SignatureValueType.SignatureValueTypeImpl implements SignatureValue {
		
		protected SignatureValueImpl(SignatureValue.SignatureValueBuilder builder) {
			super(builder);
		}
		
		@Override
		public SignatureValue build() {
			return this;
		}
		
		@Override
		public SignatureValue.SignatureValueBuilder toBuilder() {
			SignatureValue.SignatureValueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SignatureValue.SignatureValueBuilder builder) {
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
			return "SignatureValue {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SignatureValue  ***********************/
	class SignatureValueBuilderImpl extends SignatureValueType.SignatureValueTypeBuilderImpl implements SignatureValue.SignatureValueBuilder {
	
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public SignatureValue.SignatureValueBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SignatureValue.SignatureValueBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public SignatureValue build() {
			return new SignatureValue.SignatureValueImpl(this);
		}
		
		@Override
		public SignatureValue.SignatureValueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SignatureValue.SignatureValueBuilder prune() {
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
		public SignatureValue.SignatureValueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SignatureValue.SignatureValueBuilder o = (SignatureValue.SignatureValueBuilder) other;
			
			
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
			return "SignatureValueBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
