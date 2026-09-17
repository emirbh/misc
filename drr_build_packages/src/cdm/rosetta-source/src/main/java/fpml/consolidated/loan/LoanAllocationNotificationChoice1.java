package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanAllocationNotificationChoice1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="LoanAllocationNotificationChoice1", builder=LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1BuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationNotificationChoice1", model="fpml", builder=LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1BuilderImpl.class, version="2.1.1")
public interface LoanAllocationNotificationChoice1 extends RosettaModelObject {

	LoanAllocationNotificationChoice1Meta metaData = new LoanAllocationNotificationChoice1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A party-specific allocation identifier.
	 *
	 */
	LoanAllocationIdentifier getAllocationId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A summary structure representing the loan trade allocation.
	 *
	 */
	LoanAllocationSummary getAllocationSummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure defining information related to a loan trade allocation.
	 *
	 */
	LoanAllocationType getAllocation();

	/*********************** Build Methods  ***********************/
	LoanAllocationNotificationChoice1 build();
	
	LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder toBuilder();
	
	static LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder builder() {
		return new LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationNotificationChoice1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationNotificationChoice1> getType() {
		return LoanAllocationNotificationChoice1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("allocationId"), processor, LoanAllocationIdentifier.class, getAllocationId());
		processRosetta(path.newSubPath("allocationSummary"), processor, LoanAllocationSummary.class, getAllocationSummary());
		processRosetta(path.newSubPath("allocation"), processor, LoanAllocationType.class, getAllocation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationNotificationChoice1Builder extends LoanAllocationNotificationChoice1, RosettaModelObjectBuilder {
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getOrCreateAllocationId();
		@Override
		LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getAllocationId();
		LoanAllocationSummary.LoanAllocationSummaryBuilder getOrCreateAllocationSummary();
		@Override
		LoanAllocationSummary.LoanAllocationSummaryBuilder getAllocationSummary();
		LoanAllocationType.LoanAllocationTypeBuilder getOrCreateAllocation();
		@Override
		LoanAllocationType.LoanAllocationTypeBuilder getAllocation();
		LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder setAllocationId(LoanAllocationIdentifier allocationId);
		LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder setAllocationSummary(LoanAllocationSummary allocationSummary);
		LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder setAllocation(LoanAllocationType allocation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("allocationId"), processor, LoanAllocationIdentifier.LoanAllocationIdentifierBuilder.class, getAllocationId());
			processRosetta(path.newSubPath("allocationSummary"), processor, LoanAllocationSummary.LoanAllocationSummaryBuilder.class, getAllocationSummary());
			processRosetta(path.newSubPath("allocation"), processor, LoanAllocationType.LoanAllocationTypeBuilder.class, getAllocation());
		}
		

		LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationNotificationChoice1  ***********************/
	class LoanAllocationNotificationChoice1Impl implements LoanAllocationNotificationChoice1 {
		private final LoanAllocationIdentifier allocationId;
		private final LoanAllocationSummary allocationSummary;
		private final LoanAllocationType allocation;
		
		protected LoanAllocationNotificationChoice1Impl(LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder builder) {
			this.allocationId = ofNullable(builder.getAllocationId()).map(f->f.build()).orElse(null);
			this.allocationSummary = ofNullable(builder.getAllocationSummary()).map(f->f.build()).orElse(null);
			this.allocation = ofNullable(builder.getAllocation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("allocationId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationId")
		public LoanAllocationIdentifier getAllocationId() {
			return allocationId;
		}
		
		@Override
		@RosettaAttribute("allocationSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationSummary")
		public LoanAllocationSummary getAllocationSummary() {
			return allocationSummary;
		}
		
		@Override
		@RosettaAttribute("allocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocation")
		public LoanAllocationType getAllocation() {
			return allocation;
		}
		
		@Override
		public LoanAllocationNotificationChoice1 build() {
			return this;
		}
		
		@Override
		public LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder toBuilder() {
			LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder builder) {
			ofNullable(getAllocationId()).ifPresent(builder::setAllocationId);
			ofNullable(getAllocationSummary()).ifPresent(builder::setAllocationSummary);
			ofNullable(getAllocation()).ifPresent(builder::setAllocation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationNotificationChoice1 _that = getType().cast(o);
		
			if (!Objects.equals(allocationId, _that.getAllocationId())) return false;
			if (!Objects.equals(allocationSummary, _that.getAllocationSummary())) return false;
			if (!Objects.equals(allocation, _that.getAllocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationId != null ? allocationId.hashCode() : 0);
			_result = 31 * _result + (allocationSummary != null ? allocationSummary.hashCode() : 0);
			_result = 31 * _result + (allocation != null ? allocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationNotificationChoice1 {" +
				"allocationId=" + this.allocationId + ", " +
				"allocationSummary=" + this.allocationSummary + ", " +
				"allocation=" + this.allocation +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanAllocationNotificationChoice1  ***********************/
	class LoanAllocationNotificationChoice1BuilderImpl implements LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder {
	
		protected LoanAllocationIdentifier.LoanAllocationIdentifierBuilder allocationId;
		protected LoanAllocationSummary.LoanAllocationSummaryBuilder allocationSummary;
		protected LoanAllocationType.LoanAllocationTypeBuilder allocation;
		
		@Override
		@RosettaAttribute("allocationId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationId")
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getAllocationId() {
			return allocationId;
		}
		
		@Override
		public LoanAllocationIdentifier.LoanAllocationIdentifierBuilder getOrCreateAllocationId() {
			LoanAllocationIdentifier.LoanAllocationIdentifierBuilder result;
			if (allocationId!=null) {
				result = allocationId;
			}
			else {
				result = allocationId = LoanAllocationIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocationSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationSummary")
		public LoanAllocationSummary.LoanAllocationSummaryBuilder getAllocationSummary() {
			return allocationSummary;
		}
		
		@Override
		public LoanAllocationSummary.LoanAllocationSummaryBuilder getOrCreateAllocationSummary() {
			LoanAllocationSummary.LoanAllocationSummaryBuilder result;
			if (allocationSummary!=null) {
				result = allocationSummary;
			}
			else {
				result = allocationSummary = LoanAllocationSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocation")
		public LoanAllocationType.LoanAllocationTypeBuilder getAllocation() {
			return allocation;
		}
		
		@Override
		public LoanAllocationType.LoanAllocationTypeBuilder getOrCreateAllocation() {
			LoanAllocationType.LoanAllocationTypeBuilder result;
			if (allocation!=null) {
				result = allocation;
			}
			else {
				result = allocation = LoanAllocationType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("allocationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allocationId")
		@Override
		public LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder setAllocationId(LoanAllocationIdentifier _allocationId) {
			this.allocationId = _allocationId == null ? null : _allocationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("allocationSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allocationSummary")
		@Override
		public LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder setAllocationSummary(LoanAllocationSummary _allocationSummary) {
			this.allocationSummary = _allocationSummary == null ? null : _allocationSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("allocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allocation")
		@Override
		public LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder setAllocation(LoanAllocationType _allocation) {
			this.allocation = _allocation == null ? null : _allocation.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationNotificationChoice1 build() {
			return new LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Impl(this);
		}
		
		@Override
		public LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder prune() {
			if (allocationId!=null && !allocationId.prune().hasData()) allocationId = null;
			if (allocationSummary!=null && !allocationSummary.prune().hasData()) allocationSummary = null;
			if (allocation!=null && !allocation.prune().hasData()) allocation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAllocationId()!=null && getAllocationId().hasData()) return true;
			if (getAllocationSummary()!=null && getAllocationSummary().hasData()) return true;
			if (getAllocation()!=null && getAllocation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder o = (LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder) other;
			
			merger.mergeRosetta(getAllocationId(), o.getAllocationId(), this::setAllocationId);
			merger.mergeRosetta(getAllocationSummary(), o.getAllocationSummary(), this::setAllocationSummary);
			merger.mergeRosetta(getAllocation(), o.getAllocation(), this::setAllocation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationNotificationChoice1 _that = getType().cast(o);
		
			if (!Objects.equals(allocationId, _that.getAllocationId())) return false;
			if (!Objects.equals(allocationSummary, _that.getAllocationSummary())) return false;
			if (!Objects.equals(allocation, _that.getAllocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationId != null ? allocationId.hashCode() : 0);
			_result = 31 * _result + (allocationSummary != null ? allocationSummary.hashCode() : 0);
			_result = 31 * _result + (allocation != null ? allocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationNotificationChoice1Builder {" +
				"allocationId=" + this.allocationId + ", " +
				"allocationSummary=" + this.allocationSummary + ", " +
				"allocation=" + this.allocation +
			'}';
		}
	}
}
