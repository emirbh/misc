package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanAllocationSettlementTaskTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to uniquely identify a settlement task type within a syndicated loan structure.
 *
 */
@RosettaDataType(value="LoanAllocationSettlementTaskType", builder=LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationSettlementTaskType", model="fpml", builder=LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilderImpl.class, version="2.1.1")
public interface LoanAllocationSettlementTaskType extends RosettaModelObject {

	LoanAllocationSettlementTaskTypeMeta metaData = new LoanAllocationSettlementTaskTypeMeta();

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
	String getAllocationSettlementTaskTypeScheme();

	/*********************** Build Methods  ***********************/
	LoanAllocationSettlementTaskType build();
	
	LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder toBuilder();
	
	static LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder builder() {
		return new LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationSettlementTaskType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationSettlementTaskType> getType() {
		return LoanAllocationSettlementTaskType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("allocationSettlementTaskTypeScheme"), String.class, getAllocationSettlementTaskTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationSettlementTaskTypeBuilder extends LoanAllocationSettlementTaskType, RosettaModelObjectBuilder {
		LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder setValue(String value);
		LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder setAllocationSettlementTaskTypeScheme(String allocationSettlementTaskTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("allocationSettlementTaskTypeScheme"), String.class, getAllocationSettlementTaskTypeScheme(), this);
		}
		

		LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationSettlementTaskType  ***********************/
	class LoanAllocationSettlementTaskTypeImpl implements LoanAllocationSettlementTaskType {
		private final String value;
		private final String allocationSettlementTaskTypeScheme;
		
		protected LoanAllocationSettlementTaskTypeImpl(LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder builder) {
			this.value = builder.getValue();
			this.allocationSettlementTaskTypeScheme = builder.getAllocationSettlementTaskTypeScheme();
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
		@RosettaAttribute("allocationSettlementTaskTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationSettlementTaskTypeScheme")
		public String getAllocationSettlementTaskTypeScheme() {
			return allocationSettlementTaskTypeScheme;
		}
		
		@Override
		public LoanAllocationSettlementTaskType build() {
			return this;
		}
		
		@Override
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder toBuilder() {
			LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAllocationSettlementTaskTypeScheme()).ifPresent(builder::setAllocationSettlementTaskTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationSettlementTaskType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(allocationSettlementTaskTypeScheme, _that.getAllocationSettlementTaskTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (allocationSettlementTaskTypeScheme != null ? allocationSettlementTaskTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementTaskType {" +
				"value=" + this.value + ", " +
				"allocationSettlementTaskTypeScheme=" + this.allocationSettlementTaskTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanAllocationSettlementTaskType  ***********************/
	class LoanAllocationSettlementTaskTypeBuilderImpl implements LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder {
	
		protected String value;
		protected String allocationSettlementTaskTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("allocationSettlementTaskTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationSettlementTaskTypeScheme")
		public String getAllocationSettlementTaskTypeScheme() {
			return allocationSettlementTaskTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("allocationSettlementTaskTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allocationSettlementTaskTypeScheme")
		@Override
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder setAllocationSettlementTaskTypeScheme(String _allocationSettlementTaskTypeScheme) {
			this.allocationSettlementTaskTypeScheme = _allocationSettlementTaskTypeScheme == null ? null : _allocationSettlementTaskTypeScheme;
			return this;
		}
		
		@Override
		public LoanAllocationSettlementTaskType build() {
			return new LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeImpl(this);
		}
		
		@Override
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAllocationSettlementTaskTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder o = (LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAllocationSettlementTaskTypeScheme(), o.getAllocationSettlementTaskTypeScheme(), this::setAllocationSettlementTaskTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationSettlementTaskType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(allocationSettlementTaskTypeScheme, _that.getAllocationSettlementTaskTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (allocationSettlementTaskTypeScheme != null ? allocationSettlementTaskTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementTaskTypeBuilder {" +
				"value=" + this.value + ", " +
				"allocationSettlementTaskTypeScheme=" + this.allocationSettlementTaskTypeScheme +
			'}';
		}
	}
}
