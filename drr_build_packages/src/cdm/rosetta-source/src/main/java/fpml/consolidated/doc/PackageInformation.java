package fpml.consolidated.doc;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.doc.meta.PackageInformationMeta;
import fpml.consolidated.shared.RelatedParty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining additional information that may be recorded against a package of trades.
 *
 */
@RosettaDataType(value="PackageInformation", builder=PackageInformation.PackageInformationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PackageInformation", model="fpml", builder=PackageInformation.PackageInformationBuilderImpl.class, version="2.1.1")
public interface PackageInformation extends RosettaModelObject {

	PackageInformationMeta metaData = new PackageInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to identify one or more parties that perform a role within the transaction. If this is within a partyTradeInformation block, the related party performs the role with respect to the party identifie by the "partyReference" in the partyTradeInformation block.
	 *
	 */
	List<? extends RelatedParty> getRelatedParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used to categorize trades into user-defined categories, such as house trades vs. customer trades.
	 *
	 */
	List<? extends TradeCategory> getCategory();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Trade execution date time, for example as provided by a central execution facility. Normally this refers to the original execution time of the trade, not the execution time of any post-trade events that may have affected it. However, in the case of a post trade event that reports the new version of the trade (for example, the novation trade in an novation event, or the amended trade in an amendment event), the execution date time may contain the time that the newly created or modified trade was created or modified.
	 *
	 */
	ExecutionDateTime getExecutionDateTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Allows timing information about a trade to be recorded.
	 *
	 */
	TradeProcessingTimestamps getTimestamps();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the trade is anticipated to be allocated.
	 *
	 */
	Boolean getIntentToAllocate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the trade is anticipated to be allocated, has been allocated, or will not be allocated.
	 *
	 */
	AllocationReportingStatus getAllocationStatus();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the trade is anticipated to be cleared via a derivative clearing organization
	 *
	 */
	Boolean getIntentToClear();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the status with respect to clearing (e.g. AwaitingAcceptance, Pending, Accepted, Rejected, etc.)
	 *
	 */
	ClearingStatusValue getClearingStatus();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used to describe the type of venue where trade was executed, e.g via an execution facility or privately.
	 *
	 */
	ExecutionVenueType getExecutionVenueType();

	/*********************** Build Methods  ***********************/
	PackageInformation build();
	
	PackageInformation.PackageInformationBuilder toBuilder();
	
	static PackageInformation.PackageInformationBuilder builder() {
		return new PackageInformation.PackageInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PackageInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PackageInformation> getType() {
		return PackageInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("category"), processor, TradeCategory.class, getCategory());
		processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.class, getExecutionDateTime());
		processRosetta(path.newSubPath("timestamps"), processor, TradeProcessingTimestamps.class, getTimestamps());
		processor.processBasic(path.newSubPath("intentToAllocate"), Boolean.class, getIntentToAllocate(), this);
		processRosetta(path.newSubPath("allocationStatus"), processor, AllocationReportingStatus.class, getAllocationStatus());
		processor.processBasic(path.newSubPath("intentToClear"), Boolean.class, getIntentToClear(), this);
		processRosetta(path.newSubPath("clearingStatus"), processor, ClearingStatusValue.class, getClearingStatus());
		processRosetta(path.newSubPath("executionVenueType"), processor, ExecutionVenueType.class, getExecutionVenueType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PackageInformationBuilder extends PackageInformation, RosettaModelObjectBuilder {
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index);
		@Override
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		TradeCategory.TradeCategoryBuilder getOrCreateCategory(int index);
		@Override
		List<? extends TradeCategory.TradeCategoryBuilder> getCategory();
		ExecutionDateTime.ExecutionDateTimeBuilder getOrCreateExecutionDateTime();
		@Override
		ExecutionDateTime.ExecutionDateTimeBuilder getExecutionDateTime();
		TradeProcessingTimestamps.TradeProcessingTimestampsBuilder getOrCreateTimestamps();
		@Override
		TradeProcessingTimestamps.TradeProcessingTimestampsBuilder getTimestamps();
		AllocationReportingStatus.AllocationReportingStatusBuilder getOrCreateAllocationStatus();
		@Override
		AllocationReportingStatus.AllocationReportingStatusBuilder getAllocationStatus();
		ClearingStatusValue.ClearingStatusValueBuilder getOrCreateClearingStatus();
		@Override
		ClearingStatusValue.ClearingStatusValueBuilder getClearingStatus();
		ExecutionVenueType.ExecutionVenueTypeBuilder getOrCreateExecutionVenueType();
		@Override
		ExecutionVenueType.ExecutionVenueTypeBuilder getExecutionVenueType();
		PackageInformation.PackageInformationBuilder addRelatedParty(RelatedParty relatedParty);
		PackageInformation.PackageInformationBuilder addRelatedParty(RelatedParty relatedParty, int idx);
		PackageInformation.PackageInformationBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		PackageInformation.PackageInformationBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);
		PackageInformation.PackageInformationBuilder addCategory(TradeCategory category);
		PackageInformation.PackageInformationBuilder addCategory(TradeCategory category, int idx);
		PackageInformation.PackageInformationBuilder addCategory(List<? extends TradeCategory> category);
		PackageInformation.PackageInformationBuilder setCategory(List<? extends TradeCategory> category);
		PackageInformation.PackageInformationBuilder setExecutionDateTime(ExecutionDateTime executionDateTime);
		PackageInformation.PackageInformationBuilder setTimestamps(TradeProcessingTimestamps timestamps);
		PackageInformation.PackageInformationBuilder setIntentToAllocate(Boolean intentToAllocate);
		PackageInformation.PackageInformationBuilder setAllocationStatus(AllocationReportingStatus allocationStatus);
		PackageInformation.PackageInformationBuilder setIntentToClear(Boolean intentToClear);
		PackageInformation.PackageInformationBuilder setClearingStatus(ClearingStatusValue clearingStatus);
		PackageInformation.PackageInformationBuilder setExecutionVenueType(ExecutionVenueType executionVenueType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("category"), processor, TradeCategory.TradeCategoryBuilder.class, getCategory());
			processRosetta(path.newSubPath("executionDateTime"), processor, ExecutionDateTime.ExecutionDateTimeBuilder.class, getExecutionDateTime());
			processRosetta(path.newSubPath("timestamps"), processor, TradeProcessingTimestamps.TradeProcessingTimestampsBuilder.class, getTimestamps());
			processor.processBasic(path.newSubPath("intentToAllocate"), Boolean.class, getIntentToAllocate(), this);
			processRosetta(path.newSubPath("allocationStatus"), processor, AllocationReportingStatus.AllocationReportingStatusBuilder.class, getAllocationStatus());
			processor.processBasic(path.newSubPath("intentToClear"), Boolean.class, getIntentToClear(), this);
			processRosetta(path.newSubPath("clearingStatus"), processor, ClearingStatusValue.ClearingStatusValueBuilder.class, getClearingStatus());
			processRosetta(path.newSubPath("executionVenueType"), processor, ExecutionVenueType.ExecutionVenueTypeBuilder.class, getExecutionVenueType());
		}
		

		PackageInformation.PackageInformationBuilder prune();
	}

	/*********************** Immutable Implementation of PackageInformation  ***********************/
	class PackageInformationImpl implements PackageInformation {
		private final List<? extends RelatedParty> relatedParty;
		private final List<? extends TradeCategory> category;
		private final ExecutionDateTime executionDateTime;
		private final TradeProcessingTimestamps timestamps;
		private final Boolean intentToAllocate;
		private final AllocationReportingStatus allocationStatus;
		private final Boolean intentToClear;
		private final ClearingStatusValue clearingStatus;
		private final ExecutionVenueType executionVenueType;
		
		protected PackageInformationImpl(PackageInformation.PackageInformationBuilder builder) {
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.category = ofNullable(builder.getCategory()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.executionDateTime = ofNullable(builder.getExecutionDateTime()).map(f->f.build()).orElse(null);
			this.timestamps = ofNullable(builder.getTimestamps()).map(f->f.build()).orElse(null);
			this.intentToAllocate = builder.getIntentToAllocate();
			this.allocationStatus = ofNullable(builder.getAllocationStatus()).map(f->f.build()).orElse(null);
			this.intentToClear = builder.getIntentToClear();
			this.clearingStatus = ofNullable(builder.getClearingStatus()).map(f->f.build()).orElse(null);
			this.executionVenueType = ofNullable(builder.getExecutionVenueType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		@RosettaAttribute("category")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("category")
		public List<? extends TradeCategory> getCategory() {
			return category;
		}
		
		@Override
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionDateTime")
		public ExecutionDateTime getExecutionDateTime() {
			return executionDateTime;
		}
		
		@Override
		@RosettaAttribute("timestamps")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("timestamps")
		public TradeProcessingTimestamps getTimestamps() {
			return timestamps;
		}
		
		@Override
		@RosettaAttribute("intentToAllocate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intentToAllocate")
		public Boolean getIntentToAllocate() {
			return intentToAllocate;
		}
		
		@Override
		@RosettaAttribute("allocationStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationStatus")
		public AllocationReportingStatus getAllocationStatus() {
			return allocationStatus;
		}
		
		@Override
		@RosettaAttribute("intentToClear")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intentToClear")
		public Boolean getIntentToClear() {
			return intentToClear;
		}
		
		@Override
		@RosettaAttribute("clearingStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingStatus")
		public ClearingStatusValue getClearingStatus() {
			return clearingStatus;
		}
		
		@Override
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueType")
		public ExecutionVenueType getExecutionVenueType() {
			return executionVenueType;
		}
		
		@Override
		public PackageInformation build() {
			return this;
		}
		
		@Override
		public PackageInformation.PackageInformationBuilder toBuilder() {
			PackageInformation.PackageInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PackageInformation.PackageInformationBuilder builder) {
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getCategory()).ifPresent(builder::setCategory);
			ofNullable(getExecutionDateTime()).ifPresent(builder::setExecutionDateTime);
			ofNullable(getTimestamps()).ifPresent(builder::setTimestamps);
			ofNullable(getIntentToAllocate()).ifPresent(builder::setIntentToAllocate);
			ofNullable(getAllocationStatus()).ifPresent(builder::setAllocationStatus);
			ofNullable(getIntentToClear()).ifPresent(builder::setIntentToClear);
			ofNullable(getClearingStatus()).ifPresent(builder::setClearingStatus);
			ofNullable(getExecutionVenueType()).ifPresent(builder::setExecutionVenueType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PackageInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(category, _that.getCategory())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(timestamps, _that.getTimestamps())) return false;
			if (!Objects.equals(intentToAllocate, _that.getIntentToAllocate())) return false;
			if (!Objects.equals(allocationStatus, _that.getAllocationStatus())) return false;
			if (!Objects.equals(intentToClear, _that.getIntentToClear())) return false;
			if (!Objects.equals(clearingStatus, _that.getClearingStatus())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (timestamps != null ? timestamps.hashCode() : 0);
			_result = 31 * _result + (intentToAllocate != null ? intentToAllocate.hashCode() : 0);
			_result = 31 * _result + (allocationStatus != null ? allocationStatus.hashCode() : 0);
			_result = 31 * _result + (intentToClear != null ? intentToClear.hashCode() : 0);
			_result = 31 * _result + (clearingStatus != null ? clearingStatus.hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PackageInformation {" +
				"relatedParty=" + this.relatedParty + ", " +
				"category=" + this.category + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"timestamps=" + this.timestamps + ", " +
				"intentToAllocate=" + this.intentToAllocate + ", " +
				"allocationStatus=" + this.allocationStatus + ", " +
				"intentToClear=" + this.intentToClear + ", " +
				"clearingStatus=" + this.clearingStatus + ", " +
				"executionVenueType=" + this.executionVenueType +
			'}';
		}
	}

	/*********************** Builder Implementation of PackageInformation  ***********************/
	class PackageInformationBuilderImpl implements PackageInformation.PackageInformationBuilder {
	
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected List<TradeCategory.TradeCategoryBuilder> category = new ArrayList<>();
		protected ExecutionDateTime.ExecutionDateTimeBuilder executionDateTime;
		protected TradeProcessingTimestamps.TradeProcessingTimestampsBuilder timestamps;
		protected Boolean intentToAllocate;
		protected AllocationReportingStatus.AllocationReportingStatusBuilder allocationStatus;
		protected Boolean intentToClear;
		protected ClearingStatusValue.ClearingStatusValueBuilder clearingStatus;
		protected ExecutionVenueType.ExecutionVenueTypeBuilder executionVenueType;
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index) {
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			return getIndex(relatedParty, index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@Override
		@RosettaAttribute("category")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("category")
		public List<? extends TradeCategory.TradeCategoryBuilder> getCategory() {
			return category;
		}
		
		@Override
		public TradeCategory.TradeCategoryBuilder getOrCreateCategory(int index) {
			if (category==null) {
				this.category = new ArrayList<>();
			}
			return getIndex(category, index, () -> {
						TradeCategory.TradeCategoryBuilder newCategory = TradeCategory.builder();
						return newCategory;
					});
		}
		
		@Override
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionDateTime")
		public ExecutionDateTime.ExecutionDateTimeBuilder getExecutionDateTime() {
			return executionDateTime;
		}
		
		@Override
		public ExecutionDateTime.ExecutionDateTimeBuilder getOrCreateExecutionDateTime() {
			ExecutionDateTime.ExecutionDateTimeBuilder result;
			if (executionDateTime!=null) {
				result = executionDateTime;
			}
			else {
				result = executionDateTime = ExecutionDateTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("timestamps")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("timestamps")
		public TradeProcessingTimestamps.TradeProcessingTimestampsBuilder getTimestamps() {
			return timestamps;
		}
		
		@Override
		public TradeProcessingTimestamps.TradeProcessingTimestampsBuilder getOrCreateTimestamps() {
			TradeProcessingTimestamps.TradeProcessingTimestampsBuilder result;
			if (timestamps!=null) {
				result = timestamps;
			}
			else {
				result = timestamps = TradeProcessingTimestamps.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("intentToAllocate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intentToAllocate")
		public Boolean getIntentToAllocate() {
			return intentToAllocate;
		}
		
		@Override
		@RosettaAttribute("allocationStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allocationStatus")
		public AllocationReportingStatus.AllocationReportingStatusBuilder getAllocationStatus() {
			return allocationStatus;
		}
		
		@Override
		public AllocationReportingStatus.AllocationReportingStatusBuilder getOrCreateAllocationStatus() {
			AllocationReportingStatus.AllocationReportingStatusBuilder result;
			if (allocationStatus!=null) {
				result = allocationStatus;
			}
			else {
				result = allocationStatus = AllocationReportingStatus.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("intentToClear")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intentToClear")
		public Boolean getIntentToClear() {
			return intentToClear;
		}
		
		@Override
		@RosettaAttribute("clearingStatus")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingStatus")
		public ClearingStatusValue.ClearingStatusValueBuilder getClearingStatus() {
			return clearingStatus;
		}
		
		@Override
		public ClearingStatusValue.ClearingStatusValueBuilder getOrCreateClearingStatus() {
			ClearingStatusValue.ClearingStatusValueBuilder result;
			if (clearingStatus!=null) {
				result = clearingStatus;
			}
			else {
				result = clearingStatus = ClearingStatusValue.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueType")
		public ExecutionVenueType.ExecutionVenueTypeBuilder getExecutionVenueType() {
			return executionVenueType;
		}
		
		@Override
		public ExecutionVenueType.ExecutionVenueTypeBuilder getOrCreateExecutionVenueType() {
			ExecutionVenueType.ExecutionVenueTypeBuilder result;
			if (executionVenueType!=null) {
				result = executionVenueType;
			}
			else {
				result = executionVenueType = ExecutionVenueType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public PackageInformation.PackageInformationBuilder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public PackageInformation.PackageInformationBuilder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public PackageInformation.PackageInformationBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (final RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public PackageInformation.PackageInformationBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null) {
				this.relatedParty = new ArrayList<>();
			} else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("category")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("category")
		@Override
		public PackageInformation.PackageInformationBuilder addCategory(TradeCategory _category) {
			if (_category != null) {
				this.category.add(_category.toBuilder());
			}
			return this;
		}
		
		@Override
		public PackageInformation.PackageInformationBuilder addCategory(TradeCategory _category, int idx) {
			getIndex(this.category, idx, () -> _category.toBuilder());
			return this;
		}
		
		@Override
		public PackageInformation.PackageInformationBuilder addCategory(List<? extends TradeCategory> categorys) {
			if (categorys != null) {
				for (final TradeCategory toAdd : categorys) {
					this.category.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("category")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("category")
		@Override
		public PackageInformation.PackageInformationBuilder setCategory(List<? extends TradeCategory> categorys) {
			if (categorys == null) {
				this.category = new ArrayList<>();
			} else {
				this.category = categorys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("executionDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionDateTime")
		@Override
		public PackageInformation.PackageInformationBuilder setExecutionDateTime(ExecutionDateTime _executionDateTime) {
			this.executionDateTime = _executionDateTime == null ? null : _executionDateTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("timestamps")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("timestamps")
		@Override
		public PackageInformation.PackageInformationBuilder setTimestamps(TradeProcessingTimestamps _timestamps) {
			this.timestamps = _timestamps == null ? null : _timestamps.toBuilder();
			return this;
		}
		
		@RosettaAttribute("intentToAllocate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intentToAllocate")
		@Override
		public PackageInformation.PackageInformationBuilder setIntentToAllocate(Boolean _intentToAllocate) {
			this.intentToAllocate = _intentToAllocate == null ? null : _intentToAllocate;
			return this;
		}
		
		@RosettaAttribute("allocationStatus")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allocationStatus")
		@Override
		public PackageInformation.PackageInformationBuilder setAllocationStatus(AllocationReportingStatus _allocationStatus) {
			this.allocationStatus = _allocationStatus == null ? null : _allocationStatus.toBuilder();
			return this;
		}
		
		@RosettaAttribute("intentToClear")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intentToClear")
		@Override
		public PackageInformation.PackageInformationBuilder setIntentToClear(Boolean _intentToClear) {
			this.intentToClear = _intentToClear == null ? null : _intentToClear;
			return this;
		}
		
		@RosettaAttribute("clearingStatus")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingStatus")
		@Override
		public PackageInformation.PackageInformationBuilder setClearingStatus(ClearingStatusValue _clearingStatus) {
			this.clearingStatus = _clearingStatus == null ? null : _clearingStatus.toBuilder();
			return this;
		}
		
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionVenueType")
		@Override
		public PackageInformation.PackageInformationBuilder setExecutionVenueType(ExecutionVenueType _executionVenueType) {
			this.executionVenueType = _executionVenueType == null ? null : _executionVenueType.toBuilder();
			return this;
		}
		
		@Override
		public PackageInformation build() {
			return new PackageInformation.PackageInformationImpl(this);
		}
		
		@Override
		public PackageInformation.PackageInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PackageInformation.PackageInformationBuilder prune() {
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			category = category.stream().filter(b->b!=null).<TradeCategory.TradeCategoryBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (executionDateTime!=null && !executionDateTime.prune().hasData()) executionDateTime = null;
			if (timestamps!=null && !timestamps.prune().hasData()) timestamps = null;
			if (allocationStatus!=null && !allocationStatus.prune().hasData()) allocationStatus = null;
			if (clearingStatus!=null && !clearingStatus.prune().hasData()) clearingStatus = null;
			if (executionVenueType!=null && !executionVenueType.prune().hasData()) executionVenueType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCategory()!=null && getCategory().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExecutionDateTime()!=null && getExecutionDateTime().hasData()) return true;
			if (getTimestamps()!=null && getTimestamps().hasData()) return true;
			if (getIntentToAllocate()!=null) return true;
			if (getAllocationStatus()!=null && getAllocationStatus().hasData()) return true;
			if (getIntentToClear()!=null) return true;
			if (getClearingStatus()!=null && getClearingStatus().hasData()) return true;
			if (getExecutionVenueType()!=null && getExecutionVenueType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PackageInformation.PackageInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PackageInformation.PackageInformationBuilder o = (PackageInformation.PackageInformationBuilder) other;
			
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getCategory(), o.getCategory(), this::getOrCreateCategory);
			merger.mergeRosetta(getExecutionDateTime(), o.getExecutionDateTime(), this::setExecutionDateTime);
			merger.mergeRosetta(getTimestamps(), o.getTimestamps(), this::setTimestamps);
			merger.mergeRosetta(getAllocationStatus(), o.getAllocationStatus(), this::setAllocationStatus);
			merger.mergeRosetta(getClearingStatus(), o.getClearingStatus(), this::setClearingStatus);
			merger.mergeRosetta(getExecutionVenueType(), o.getExecutionVenueType(), this::setExecutionVenueType);
			
			merger.mergeBasic(getIntentToAllocate(), o.getIntentToAllocate(), this::setIntentToAllocate);
			merger.mergeBasic(getIntentToClear(), o.getIntentToClear(), this::setIntentToClear);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PackageInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(category, _that.getCategory())) return false;
			if (!Objects.equals(executionDateTime, _that.getExecutionDateTime())) return false;
			if (!Objects.equals(timestamps, _that.getTimestamps())) return false;
			if (!Objects.equals(intentToAllocate, _that.getIntentToAllocate())) return false;
			if (!Objects.equals(allocationStatus, _that.getAllocationStatus())) return false;
			if (!Objects.equals(intentToClear, _that.getIntentToClear())) return false;
			if (!Objects.equals(clearingStatus, _that.getClearingStatus())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			_result = 31 * _result + (executionDateTime != null ? executionDateTime.hashCode() : 0);
			_result = 31 * _result + (timestamps != null ? timestamps.hashCode() : 0);
			_result = 31 * _result + (intentToAllocate != null ? intentToAllocate.hashCode() : 0);
			_result = 31 * _result + (allocationStatus != null ? allocationStatus.hashCode() : 0);
			_result = 31 * _result + (intentToClear != null ? intentToClear.hashCode() : 0);
			_result = 31 * _result + (clearingStatus != null ? clearingStatus.hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PackageInformationBuilder {" +
				"relatedParty=" + this.relatedParty + ", " +
				"category=" + this.category + ", " +
				"executionDateTime=" + this.executionDateTime + ", " +
				"timestamps=" + this.timestamps + ", " +
				"intentToAllocate=" + this.intentToAllocate + ", " +
				"allocationStatus=" + this.allocationStatus + ", " +
				"intentToClear=" + this.intentToClear + ", " +
				"clearingStatus=" + this.clearingStatus + ", " +
				"executionVenueType=" + this.executionVenueType +
			'}';
		}
	}
}
