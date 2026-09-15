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
import fpml.consolidated.meta.KeyValueTypeMeta;
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
@RosettaDataType(value="KeyValueType", builder=KeyValueType.KeyValueTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="KeyValueType", model="fpml", builder=KeyValueType.KeyValueTypeBuilderImpl.class, version="2.1.1")
public interface KeyValueType extends RosettaModelObject {

	KeyValueTypeMeta metaData = new KeyValueTypeMeta();

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
	DSAKeyValueType getDsaKeyValue();
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
	RSAKeyValueType getRsaKeyValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 1; Max Occurs: 1; Namespace: ##other; Process Contents: lax.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 1; Max Occurs: 1; Namespace: ##other; Process Contents: lax.
	 *
	 */
	String getAnyContents();

	/*********************** Build Methods  ***********************/
	KeyValueType build();
	
	KeyValueType.KeyValueTypeBuilder toBuilder();
	
	static KeyValueType.KeyValueTypeBuilder builder() {
		return new KeyValueType.KeyValueTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends KeyValueType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends KeyValueType> getType() {
		return KeyValueType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dsaKeyValue"), processor, DSAKeyValueType.class, getDsaKeyValue());
		processRosetta(path.newSubPath("rsaKeyValue"), processor, RSAKeyValueType.class, getRsaKeyValue());
		processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface KeyValueTypeBuilder extends KeyValueType, RosettaModelObjectBuilder {
		DSAKeyValueType.DSAKeyValueTypeBuilder getOrCreateDsaKeyValue();
		@Override
		DSAKeyValueType.DSAKeyValueTypeBuilder getDsaKeyValue();
		RSAKeyValueType.RSAKeyValueTypeBuilder getOrCreateRsaKeyValue();
		@Override
		RSAKeyValueType.RSAKeyValueTypeBuilder getRsaKeyValue();
		KeyValueType.KeyValueTypeBuilder setDsaKeyValue(DSAKeyValueType dsaKeyValue);
		KeyValueType.KeyValueTypeBuilder setRsaKeyValue(RSAKeyValueType rsaKeyValue);
		KeyValueType.KeyValueTypeBuilder setAnyContents(String anyContents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dsaKeyValue"), processor, DSAKeyValueType.DSAKeyValueTypeBuilder.class, getDsaKeyValue());
			processRosetta(path.newSubPath("rsaKeyValue"), processor, RSAKeyValueType.RSAKeyValueTypeBuilder.class, getRsaKeyValue());
			processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
		}
		

		KeyValueType.KeyValueTypeBuilder prune();
	}

	/*********************** Immutable Implementation of KeyValueType  ***********************/
	class KeyValueTypeImpl implements KeyValueType {
		private final DSAKeyValueType dsaKeyValue;
		private final RSAKeyValueType rsaKeyValue;
		private final String anyContents;
		
		protected KeyValueTypeImpl(KeyValueType.KeyValueTypeBuilder builder) {
			this.dsaKeyValue = ofNullable(builder.getDsaKeyValue()).map(f->f.build()).orElse(null);
			this.rsaKeyValue = ofNullable(builder.getRsaKeyValue()).map(f->f.build()).orElse(null);
			this.anyContents = builder.getAnyContents();
		}
		
		@Override
		@RosettaAttribute("dsaKeyValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dsaKeyValue")
		public DSAKeyValueType getDsaKeyValue() {
			return dsaKeyValue;
		}
		
		@Override
		@RosettaAttribute("rsaKeyValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rsaKeyValue")
		public RSAKeyValueType getRsaKeyValue() {
			return rsaKeyValue;
		}
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("anyContents")
		public String getAnyContents() {
			return anyContents;
		}
		
		@Override
		public KeyValueType build() {
			return this;
		}
		
		@Override
		public KeyValueType.KeyValueTypeBuilder toBuilder() {
			KeyValueType.KeyValueTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(KeyValueType.KeyValueTypeBuilder builder) {
			ofNullable(getDsaKeyValue()).ifPresent(builder::setDsaKeyValue);
			ofNullable(getRsaKeyValue()).ifPresent(builder::setRsaKeyValue);
			ofNullable(getAnyContents()).ifPresent(builder::setAnyContents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			KeyValueType _that = getType().cast(o);
		
			if (!Objects.equals(dsaKeyValue, _that.getDsaKeyValue())) return false;
			if (!Objects.equals(rsaKeyValue, _that.getRsaKeyValue())) return false;
			if (!Objects.equals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dsaKeyValue != null ? dsaKeyValue.hashCode() : 0);
			_result = 31 * _result + (rsaKeyValue != null ? rsaKeyValue.hashCode() : 0);
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KeyValueType {" +
				"dsaKeyValue=" + this.dsaKeyValue + ", " +
				"rsaKeyValue=" + this.rsaKeyValue + ", " +
				"anyContents=" + this.anyContents +
			'}';
		}
	}

	/*********************** Builder Implementation of KeyValueType  ***********************/
	class KeyValueTypeBuilderImpl implements KeyValueType.KeyValueTypeBuilder {
	
		protected DSAKeyValueType.DSAKeyValueTypeBuilder dsaKeyValue;
		protected RSAKeyValueType.RSAKeyValueTypeBuilder rsaKeyValue;
		protected String anyContents;
		
		@Override
		@RosettaAttribute("dsaKeyValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dsaKeyValue")
		public DSAKeyValueType.DSAKeyValueTypeBuilder getDsaKeyValue() {
			return dsaKeyValue;
		}
		
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder getOrCreateDsaKeyValue() {
			DSAKeyValueType.DSAKeyValueTypeBuilder result;
			if (dsaKeyValue!=null) {
				result = dsaKeyValue;
			}
			else {
				result = dsaKeyValue = DSAKeyValueType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rsaKeyValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rsaKeyValue")
		public RSAKeyValueType.RSAKeyValueTypeBuilder getRsaKeyValue() {
			return rsaKeyValue;
		}
		
		@Override
		public RSAKeyValueType.RSAKeyValueTypeBuilder getOrCreateRsaKeyValue() {
			RSAKeyValueType.RSAKeyValueTypeBuilder result;
			if (rsaKeyValue!=null) {
				result = rsaKeyValue;
			}
			else {
				result = rsaKeyValue = RSAKeyValueType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("anyContents")
		public String getAnyContents() {
			return anyContents;
		}
		
		@RosettaAttribute("dsaKeyValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dsaKeyValue")
		@Override
		public KeyValueType.KeyValueTypeBuilder setDsaKeyValue(DSAKeyValueType _dsaKeyValue) {
			this.dsaKeyValue = _dsaKeyValue == null ? null : _dsaKeyValue.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rsaKeyValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rsaKeyValue")
		@Override
		public KeyValueType.KeyValueTypeBuilder setRsaKeyValue(RSAKeyValueType _rsaKeyValue) {
			this.rsaKeyValue = _rsaKeyValue == null ? null : _rsaKeyValue.toBuilder();
			return this;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("anyContents")
		@Override
		public KeyValueType.KeyValueTypeBuilder setAnyContents(String _anyContents) {
			this.anyContents = _anyContents == null ? null : _anyContents;
			return this;
		}
		
		@Override
		public KeyValueType build() {
			return new KeyValueType.KeyValueTypeImpl(this);
		}
		
		@Override
		public KeyValueType.KeyValueTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyValueType.KeyValueTypeBuilder prune() {
			if (dsaKeyValue!=null && !dsaKeyValue.prune().hasData()) dsaKeyValue = null;
			if (rsaKeyValue!=null && !rsaKeyValue.prune().hasData()) rsaKeyValue = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDsaKeyValue()!=null && getDsaKeyValue().hasData()) return true;
			if (getRsaKeyValue()!=null && getRsaKeyValue().hasData()) return true;
			if (getAnyContents()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public KeyValueType.KeyValueTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			KeyValueType.KeyValueTypeBuilder o = (KeyValueType.KeyValueTypeBuilder) other;
			
			merger.mergeRosetta(getDsaKeyValue(), o.getDsaKeyValue(), this::setDsaKeyValue);
			merger.mergeRosetta(getRsaKeyValue(), o.getRsaKeyValue(), this::setRsaKeyValue);
			
			merger.mergeBasic(getAnyContents(), o.getAnyContents(), this::setAnyContents);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			KeyValueType _that = getType().cast(o);
		
			if (!Objects.equals(dsaKeyValue, _that.getDsaKeyValue())) return false;
			if (!Objects.equals(rsaKeyValue, _that.getRsaKeyValue())) return false;
			if (!Objects.equals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dsaKeyValue != null ? dsaKeyValue.hashCode() : 0);
			_result = 31 * _result + (rsaKeyValue != null ? rsaKeyValue.hashCode() : 0);
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "KeyValueTypeBuilder {" +
				"dsaKeyValue=" + this.dsaKeyValue + ", " +
				"rsaKeyValue=" + this.rsaKeyValue + ", " +
				"anyContents=" + this.anyContents +
			'}';
		}
	}
}
