package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.ContractIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A contact id identifier allocated by a party. FpML does not define the domain values associated with this element.
 *
 */
@RosettaDataType(value="ContractId", builder=ContractId.ContractIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ContractId", model="fpml", builder=ContractId.ContractIdBuilderImpl.class, version="2.1.1")
public interface ContractId extends RosettaModelObject {

	ContractIdMeta metaData = new ContractIdMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getContractIdScheme();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();

	/*********************** Build Methods  ***********************/
	ContractId build();
	
	ContractId.ContractIdBuilder toBuilder();
	
	static ContractId.ContractIdBuilder builder() {
		return new ContractId.ContractIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ContractId> getType() {
		return ContractId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("contractIdScheme"), String.class, getContractIdScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractIdBuilder extends ContractId, RosettaModelObjectBuilder {
		ContractId.ContractIdBuilder setValue(String value);
		ContractId.ContractIdBuilder setContractIdScheme(String contractIdScheme);
		ContractId.ContractIdBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("contractIdScheme"), String.class, getContractIdScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		ContractId.ContractIdBuilder prune();
	}

	/*********************** Immutable Implementation of ContractId  ***********************/
	class ContractIdImpl implements ContractId {
		private final String value;
		private final String contractIdScheme;
		private final String id;
		
		protected ContractIdImpl(ContractId.ContractIdBuilder builder) {
			this.value = builder.getValue();
			this.contractIdScheme = builder.getContractIdScheme();
			this.id = builder.getId();
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
		@RosettaAttribute("contractIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("contractIdScheme")
		public String getContractIdScheme() {
			return contractIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public ContractId build() {
			return this;
		}
		
		@Override
		public ContractId.ContractIdBuilder toBuilder() {
			ContractId.ContractIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractId.ContractIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getContractIdScheme()).ifPresent(builder::setContractIdScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(contractIdScheme, _that.getContractIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (contractIdScheme != null ? contractIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractId {" +
				"value=" + this.value + ", " +
				"contractIdScheme=" + this.contractIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractId  ***********************/
	class ContractIdBuilderImpl implements ContractId.ContractIdBuilder {
	
		protected String value;
		protected String contractIdScheme;
		protected String id;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("contractIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("contractIdScheme")
		public String getContractIdScheme() {
			return contractIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ContractId.ContractIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("contractIdScheme")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("contractIdScheme")
		@Override
		public ContractId.ContractIdBuilder setContractIdScheme(String _contractIdScheme) {
			this.contractIdScheme = _contractIdScheme == null ? null : _contractIdScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ContractId.ContractIdBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public ContractId build() {
			return new ContractId.ContractIdImpl(this);
		}
		
		@Override
		public ContractId.ContractIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractId.ContractIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getContractIdScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractId.ContractIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractId.ContractIdBuilder o = (ContractId.ContractIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getContractIdScheme(), o.getContractIdScheme(), this::setContractIdScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(contractIdScheme, _that.getContractIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (contractIdScheme != null ? contractIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractIdBuilder {" +
				"value=" + this.value + ", " +
				"contractIdScheme=" + this.contractIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
