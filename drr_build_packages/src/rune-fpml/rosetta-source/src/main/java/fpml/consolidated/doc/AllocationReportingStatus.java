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
import fpml.consolidated.doc.meta.AllocationReportingStatusMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Code that describes what type of allocation applies to the trade. Options include Unallocated, PreAllocation, PostAllocation.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Code that describes what type of allocation applies to the trade. Options include Unallocated, PreAllocation, PostAllocation.
 *
 */
@RosettaDataType(value="AllocationReportingStatus", builder=AllocationReportingStatus.AllocationReportingStatusBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AllocationReportingStatus", model="fpml", builder=AllocationReportingStatus.AllocationReportingStatusBuilderImpl.class, version="2.1.1")
public interface AllocationReportingStatus extends RosettaModelObject {

	AllocationReportingStatusMeta metaData = new AllocationReportingStatusMeta();

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
	String getAllocationReportingStatusScheme();

	/*********************** Build Methods  ***********************/
	AllocationReportingStatus build();
	
	AllocationReportingStatus.AllocationReportingStatusBuilder toBuilder();
	
	static AllocationReportingStatus.AllocationReportingStatusBuilder builder() {
		return new AllocationReportingStatus.AllocationReportingStatusBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AllocationReportingStatus> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AllocationReportingStatus> getType() {
		return AllocationReportingStatus.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("allocationReportingStatusScheme"), String.class, getAllocationReportingStatusScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AllocationReportingStatusBuilder extends AllocationReportingStatus, RosettaModelObjectBuilder {
		AllocationReportingStatus.AllocationReportingStatusBuilder setValue(String value);
		AllocationReportingStatus.AllocationReportingStatusBuilder setAllocationReportingStatusScheme(String allocationReportingStatusScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("allocationReportingStatusScheme"), String.class, getAllocationReportingStatusScheme(), this);
		}
		

		AllocationReportingStatus.AllocationReportingStatusBuilder prune();
	}

	/*********************** Immutable Implementation of AllocationReportingStatus  ***********************/
	class AllocationReportingStatusImpl implements AllocationReportingStatus {
		private final String value;
		private final String allocationReportingStatusScheme;
		
		protected AllocationReportingStatusImpl(AllocationReportingStatus.AllocationReportingStatusBuilder builder) {
			this.value = builder.getValue();
			this.allocationReportingStatusScheme = builder.getAllocationReportingStatusScheme();
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
		@RosettaAttribute("allocationReportingStatusScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationReportingStatusScheme")
		public String getAllocationReportingStatusScheme() {
			return allocationReportingStatusScheme;
		}
		
		@Override
		public AllocationReportingStatus build() {
			return this;
		}
		
		@Override
		public AllocationReportingStatus.AllocationReportingStatusBuilder toBuilder() {
			AllocationReportingStatus.AllocationReportingStatusBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AllocationReportingStatus.AllocationReportingStatusBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAllocationReportingStatusScheme()).ifPresent(builder::setAllocationReportingStatusScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AllocationReportingStatus _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(allocationReportingStatusScheme, _that.getAllocationReportingStatusScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (allocationReportingStatusScheme != null ? allocationReportingStatusScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationReportingStatus {" +
				"value=" + this.value + ", " +
				"allocationReportingStatusScheme=" + this.allocationReportingStatusScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of AllocationReportingStatus  ***********************/
	class AllocationReportingStatusBuilderImpl implements AllocationReportingStatus.AllocationReportingStatusBuilder {
	
		protected String value;
		protected String allocationReportingStatusScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("allocationReportingStatusScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationReportingStatusScheme")
		public String getAllocationReportingStatusScheme() {
			return allocationReportingStatusScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public AllocationReportingStatus.AllocationReportingStatusBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("allocationReportingStatusScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allocationReportingStatusScheme")
		@Override
		public AllocationReportingStatus.AllocationReportingStatusBuilder setAllocationReportingStatusScheme(String _allocationReportingStatusScheme) {
			this.allocationReportingStatusScheme = _allocationReportingStatusScheme == null ? null : _allocationReportingStatusScheme;
			return this;
		}
		
		@Override
		public AllocationReportingStatus build() {
			return new AllocationReportingStatus.AllocationReportingStatusImpl(this);
		}
		
		@Override
		public AllocationReportingStatus.AllocationReportingStatusBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationReportingStatus.AllocationReportingStatusBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAllocationReportingStatusScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationReportingStatus.AllocationReportingStatusBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AllocationReportingStatus.AllocationReportingStatusBuilder o = (AllocationReportingStatus.AllocationReportingStatusBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAllocationReportingStatusScheme(), o.getAllocationReportingStatusScheme(), this::setAllocationReportingStatusScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AllocationReportingStatus _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(allocationReportingStatusScheme, _that.getAllocationReportingStatusScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (allocationReportingStatusScheme != null ? allocationReportingStatusScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationReportingStatusBuilder {" +
				"value=" + this.value + ", " +
				"allocationReportingStatusScheme=" + this.allocationReportingStatusScheme +
			'}';
		}
	}
}
