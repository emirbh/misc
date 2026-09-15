package fpml.consolidated;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.meta.KeyValueMeta;


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
@RosettaDataType(value="KeyValue", builder=KeyValue.KeyValueBuilderImpl.class, version="2.1.1")
@RuneDataType(value="KeyValue", model="fpml", builder=KeyValue.KeyValueBuilderImpl.class, version="2.1.1")
public interface KeyValue extends KeyValueType {

	KeyValueMeta metaData = new KeyValueMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	KeyValue build();
	
	KeyValue.KeyValueBuilder toBuilder();
	
	static KeyValue.KeyValueBuilder builder() {
		return new KeyValue.KeyValueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends KeyValue> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends KeyValue> getType() {
		return KeyValue.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dsaKeyValue"), processor, DSAKeyValueType.class, getDsaKeyValue());
		processRosetta(path.newSubPath("rsaKeyValue"), processor, RSAKeyValueType.class, getRsaKeyValue());
		processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface KeyValueBuilder extends KeyValue, KeyValueType.KeyValueTypeBuilder {
		@Override
		KeyValue.KeyValueBuilder setDsaKeyValue(DSAKeyValueType dsaKeyValue);
		@Override
		KeyValue.KeyValueBuilder setRsaKeyValue(RSAKeyValueType rsaKeyValue);
		@Override
		KeyValue.KeyValueBuilder setAnyContents(String anyContents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dsaKeyValue"), processor, DSAKeyValueType.DSAKeyValueTypeBuilder.class, getDsaKeyValue());
			processRosetta(path.newSubPath("rsaKeyValue"), processor, RSAKeyValueType.RSAKeyValueTypeBuilder.class, getRsaKeyValue());
			processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
		}
		

		KeyValue.KeyValueBuilder prune();
	}

	/*********************** Immutable Implementation of KeyValue  ***********************/
	class KeyValueImpl extends KeyValueType.KeyValueTypeImpl implements KeyValue {
		
		protected KeyValueImpl(KeyValue.KeyValueBuilder builder) {
			super(builder);
		}
		
		@Override
		public KeyValue build() {
			return this;
		}
		
		@Override
		public KeyValue.KeyValueBuilder toBuilder() {
			KeyValue.KeyValueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(KeyValue.KeyValueBuilder builder) {
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
			return "KeyValue {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of KeyValue  ***********************/
	class KeyValueBuilderImpl extends KeyValueType.KeyValueTypeBuilderImpl implements KeyValue.KeyValueBuilder {
	
		
		@RosettaAttribute("dsaKeyValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dsaKeyValue")
		@Override
		public KeyValue.KeyValueBuilder setDsaKeyValue(DSAKeyValueType _dsaKeyValue) {
			this.dsaKeyValue = _dsaKeyValue == null ? null : _dsaKeyValue.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rsaKeyValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rsaKeyValue")
		@Override
		public KeyValue.KeyValueBuilder setRsaKeyValue(RSAKeyValueType _rsaKeyValue) {
			this.rsaKeyValue = _rsaKeyValue == null ? null : _rsaKeyValue.toBuilder();
			return this;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("anyContents")
		@Override
		public KeyValue.KeyValueBuilder setAnyContents(String _anyContents) {
			this.anyContents = _anyContents == null ? null : _anyContents;
			return this;
		}
		
		@Override
		public KeyValue build() {
			return new KeyValue.KeyValueImpl(this);
		}
		
		@Override
		public KeyValue.KeyValueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyValue.KeyValueBuilder prune() {
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
		public KeyValue.KeyValueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			KeyValue.KeyValueBuilder o = (KeyValue.KeyValueBuilder) other;
			
			
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
			return "KeyValueBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
