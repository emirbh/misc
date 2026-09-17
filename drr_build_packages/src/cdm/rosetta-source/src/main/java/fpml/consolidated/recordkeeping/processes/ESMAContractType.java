package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.recordkeeping.processes.meta.ESMAContractTypeMeta;
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
 */
@RosettaDataType(value="ESMAContractType", builder=ESMAContractType.ESMAContractTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ESMAContractType", model="fpml", builder=ESMAContractType.ESMAContractTypeBuilderImpl.class, version="2.1.1")
public interface ESMAContractType extends RosettaModelObject {

	ESMAContractTypeMeta metaData = new ESMAContractTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
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
	 */
	String getContractTypeScheme();

	/*********************** Build Methods  ***********************/
	ESMAContractType build();
	
	ESMAContractType.ESMAContractTypeBuilder toBuilder();
	
	static ESMAContractType.ESMAContractTypeBuilder builder() {
		return new ESMAContractType.ESMAContractTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ESMAContractType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ESMAContractType> getType() {
		return ESMAContractType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("contractTypeScheme"), String.class, getContractTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ESMAContractTypeBuilder extends ESMAContractType, RosettaModelObjectBuilder {
		ESMAContractType.ESMAContractTypeBuilder setValue(String value);
		ESMAContractType.ESMAContractTypeBuilder setContractTypeScheme(String contractTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("contractTypeScheme"), String.class, getContractTypeScheme(), this);
		}
		

		ESMAContractType.ESMAContractTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ESMAContractType  ***********************/
	class ESMAContractTypeImpl implements ESMAContractType {
		private final String value;
		private final String contractTypeScheme;
		
		protected ESMAContractTypeImpl(ESMAContractType.ESMAContractTypeBuilder builder) {
			this.value = builder.getValue();
			this.contractTypeScheme = builder.getContractTypeScheme();
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
		@RosettaAttribute("contractTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractTypeScheme")
		public String getContractTypeScheme() {
			return contractTypeScheme;
		}
		
		@Override
		public ESMAContractType build() {
			return this;
		}
		
		@Override
		public ESMAContractType.ESMAContractTypeBuilder toBuilder() {
			ESMAContractType.ESMAContractTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ESMAContractType.ESMAContractTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getContractTypeScheme()).ifPresent(builder::setContractTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMAContractType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(contractTypeScheme, _that.getContractTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (contractTypeScheme != null ? contractTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMAContractType {" +
				"value=" + this.value + ", " +
				"contractTypeScheme=" + this.contractTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ESMAContractType  ***********************/
	class ESMAContractTypeBuilderImpl implements ESMAContractType.ESMAContractTypeBuilder {
	
		protected String value;
		protected String contractTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("contractTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractTypeScheme")
		public String getContractTypeScheme() {
			return contractTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ESMAContractType.ESMAContractTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("contractTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractTypeScheme")
		@Override
		public ESMAContractType.ESMAContractTypeBuilder setContractTypeScheme(String _contractTypeScheme) {
			this.contractTypeScheme = _contractTypeScheme == null ? null : _contractTypeScheme;
			return this;
		}
		
		@Override
		public ESMAContractType build() {
			return new ESMAContractType.ESMAContractTypeImpl(this);
		}
		
		@Override
		public ESMAContractType.ESMAContractTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMAContractType.ESMAContractTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getContractTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMAContractType.ESMAContractTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ESMAContractType.ESMAContractTypeBuilder o = (ESMAContractType.ESMAContractTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getContractTypeScheme(), o.getContractTypeScheme(), this::setContractTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMAContractType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(contractTypeScheme, _that.getContractTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (contractTypeScheme != null ? contractTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMAContractTypeBuilder {" +
				"value=" + this.value + ", " +
				"contractTypeScheme=" + this.contractTypeScheme +
			'}';
		}
	}
}
