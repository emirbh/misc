package drr.regulation.csa.rewrite.trade;

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
import drr.base.trade.ExecutionVenueTypeEnum;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.upi.AnnaDsbUpiRequestAndType;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.csa.rewrite.trade.meta.CSANonReportableMeta;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbNotionalScheduleEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="CSANonReportable", builder=CSANonReportable.CSANonReportableBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CSANonReportable", model="drr", builder=CSANonReportable.CSANonReportableBuilderImpl.class, version="7.7.0")
public interface CSANonReportable extends NonReportable {

	CSANonReportableMeta metaData = new CSANonReportableMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus WorkingGroup EUUKNAPeerReviewGroup ISDA EU/UK/North America Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended EU/UK EMIR and North America transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20250416" * field "Return or Payout Trigger (non-reportable)"
	 *
	 * Provision The firms proposed extracting post-UPI information through an alternative method for entities not utilizing the UPI, with the objective of enabling the use of the Validation Rules. Consequently, this non-reportable field has been created, which in this instance extracts the Return or Payout Trigger .
	 *
	 */
	String getReturnorPayoutTrigger();
	/**
	 * Execution Venue Type
	 */
	ExecutionVenueTypeEnum getExecutionVenueType();

	/*********************** Build Methods  ***********************/
	CSANonReportable build();
	
	CSANonReportable.CSANonReportableBuilder toBuilder();
	
	static CSANonReportable.CSANonReportableBuilder builder() {
		return new CSANonReportable.CSANonReportableBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CSANonReportable> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CSANonReportable> getType() {
		return CSANonReportable.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("enrichment"), processor, EnrichmentData.class, getEnrichment());
		processRosetta(path.newSubPath("preUpiData"), processor, AnnaDsbUpiRequestAndType.class, getPreUpiData());
		processRosetta(path.newSubPath("postUpiData"), processor, AnnaDsbUpiRecord.class, getPostUpiData());
		processor.processBasic(path.newSubPath("notionalSchedule"), AnnaDsbNotionalScheduleEnum.class, getNotionalSchedule(), this);
		processor.processBasic(path.newSubPath("underlyingAssetType"), String.class, getUnderlyingAssetType(), this);
		processor.processBasic(path.newSubPath("instrumentType"), AnnaDsbInstrumentTypeEnum.class, getInstrumentType(), this);
		processor.processBasic(path.newSubPath("deliveryType"), AnnaDsbDeliveryTypeEnum.class, getDeliveryType(), this);
		processor.processBasic(path.newSubPath("returnorPayoutTrigger"), String.class, getReturnorPayoutTrigger(), this);
		processor.processBasic(path.newSubPath("executionVenueType"), ExecutionVenueTypeEnum.class, getExecutionVenueType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CSANonReportableBuilder extends CSANonReportable, NonReportable.NonReportableBuilder {
		@Override
		CSANonReportable.CSANonReportableBuilder setEnrichment(EnrichmentData enrichment);
		@Override
		CSANonReportable.CSANonReportableBuilder setPreUpiData(AnnaDsbUpiRequestAndType preUpiData);
		@Override
		CSANonReportable.CSANonReportableBuilder setPostUpiData(AnnaDsbUpiRecord postUpiData);
		@Override
		CSANonReportable.CSANonReportableBuilder setNotionalSchedule(AnnaDsbNotionalScheduleEnum notionalSchedule);
		@Override
		CSANonReportable.CSANonReportableBuilder setUnderlyingAssetType(String underlyingAssetType);
		@Override
		CSANonReportable.CSANonReportableBuilder setInstrumentType(AnnaDsbInstrumentTypeEnum instrumentType);
		@Override
		CSANonReportable.CSANonReportableBuilder setDeliveryType(AnnaDsbDeliveryTypeEnum deliveryType);
		CSANonReportable.CSANonReportableBuilder setReturnorPayoutTrigger(String returnorPayoutTrigger);
		CSANonReportable.CSANonReportableBuilder setExecutionVenueType(ExecutionVenueTypeEnum executionVenueType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("enrichment"), processor, EnrichmentData.EnrichmentDataBuilder.class, getEnrichment());
			processRosetta(path.newSubPath("preUpiData"), processor, AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder.class, getPreUpiData());
			processRosetta(path.newSubPath("postUpiData"), processor, AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder.class, getPostUpiData());
			processor.processBasic(path.newSubPath("notionalSchedule"), AnnaDsbNotionalScheduleEnum.class, getNotionalSchedule(), this);
			processor.processBasic(path.newSubPath("underlyingAssetType"), String.class, getUnderlyingAssetType(), this);
			processor.processBasic(path.newSubPath("instrumentType"), AnnaDsbInstrumentTypeEnum.class, getInstrumentType(), this);
			processor.processBasic(path.newSubPath("deliveryType"), AnnaDsbDeliveryTypeEnum.class, getDeliveryType(), this);
			processor.processBasic(path.newSubPath("returnorPayoutTrigger"), String.class, getReturnorPayoutTrigger(), this);
			processor.processBasic(path.newSubPath("executionVenueType"), ExecutionVenueTypeEnum.class, getExecutionVenueType(), this);
		}
		

		CSANonReportable.CSANonReportableBuilder prune();
	}

	/*********************** Immutable Implementation of CSANonReportable  ***********************/
	class CSANonReportableImpl extends NonReportable.NonReportableImpl implements CSANonReportable {
		private final String returnorPayoutTrigger;
		private final ExecutionVenueTypeEnum executionVenueType;
		
		protected CSANonReportableImpl(CSANonReportable.CSANonReportableBuilder builder) {
			super(builder);
			this.returnorPayoutTrigger = builder.getReturnorPayoutTrigger();
			this.executionVenueType = builder.getExecutionVenueType();
		}
		
		@Override
		@RosettaAttribute("returnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("returnorPayoutTrigger")
		public String getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueType")
		public ExecutionVenueTypeEnum getExecutionVenueType() {
			return executionVenueType;
		}
		
		@Override
		public CSANonReportable build() {
			return this;
		}
		
		@Override
		public CSANonReportable.CSANonReportableBuilder toBuilder() {
			CSANonReportable.CSANonReportableBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CSANonReportable.CSANonReportableBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReturnorPayoutTrigger()).ifPresent(builder::setReturnorPayoutTrigger);
			ofNullable(getExecutionVenueType()).ifPresent(builder::setExecutionVenueType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CSANonReportable _that = getType().cast(o);
		
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSANonReportable {" +
				"returnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"executionVenueType=" + this.executionVenueType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CSANonReportable  ***********************/
	class CSANonReportableBuilderImpl extends NonReportable.NonReportableBuilderImpl implements CSANonReportable.CSANonReportableBuilder {
	
		protected String returnorPayoutTrigger;
		protected ExecutionVenueTypeEnum executionVenueType;
		
		@Override
		@RosettaAttribute("returnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("returnorPayoutTrigger")
		public String getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueType")
		public ExecutionVenueTypeEnum getExecutionVenueType() {
			return executionVenueType;
		}
		
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("enrichment")
		@Override
		public CSANonReportable.CSANonReportableBuilder setEnrichment(EnrichmentData _enrichment) {
			this.enrichment = _enrichment == null ? null : _enrichment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("preUpiData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("preUpiData")
		@Override
		public CSANonReportable.CSANonReportableBuilder setPreUpiData(AnnaDsbUpiRequestAndType _preUpiData) {
			this.preUpiData = _preUpiData == null ? null : _preUpiData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("postUpiData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("postUpiData")
		@Override
		public CSANonReportable.CSANonReportableBuilder setPostUpiData(AnnaDsbUpiRecord _postUpiData) {
			this.postUpiData = _postUpiData == null ? null : _postUpiData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalSchedule")
		@Override
		public CSANonReportable.CSANonReportableBuilder setNotionalSchedule(AnnaDsbNotionalScheduleEnum _notionalSchedule) {
			this.notionalSchedule = _notionalSchedule == null ? null : _notionalSchedule;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetType")
		@Override
		public CSANonReportable.CSANonReportableBuilder setUnderlyingAssetType(String _underlyingAssetType) {
			this.underlyingAssetType = _underlyingAssetType == null ? null : _underlyingAssetType;
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("instrumentType")
		@Override
		public CSANonReportable.CSANonReportableBuilder setInstrumentType(AnnaDsbInstrumentTypeEnum _instrumentType) {
			this.instrumentType = _instrumentType == null ? null : _instrumentType;
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryType")
		@Override
		public CSANonReportable.CSANonReportableBuilder setDeliveryType(AnnaDsbDeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaAttribute("returnorPayoutTrigger")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("returnorPayoutTrigger")
		@Override
		public CSANonReportable.CSANonReportableBuilder setReturnorPayoutTrigger(String _returnorPayoutTrigger) {
			this.returnorPayoutTrigger = _returnorPayoutTrigger == null ? null : _returnorPayoutTrigger;
			return this;
		}
		
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionVenueType")
		@Override
		public CSANonReportable.CSANonReportableBuilder setExecutionVenueType(ExecutionVenueTypeEnum _executionVenueType) {
			this.executionVenueType = _executionVenueType == null ? null : _executionVenueType;
			return this;
		}
		
		@Override
		public CSANonReportable build() {
			return new CSANonReportable.CSANonReportableImpl(this);
		}
		
		@Override
		public CSANonReportable.CSANonReportableBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSANonReportable.CSANonReportableBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getReturnorPayoutTrigger()!=null) return true;
			if (getExecutionVenueType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSANonReportable.CSANonReportableBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CSANonReportable.CSANonReportableBuilder o = (CSANonReportable.CSANonReportableBuilder) other;
			
			
			merger.mergeBasic(getReturnorPayoutTrigger(), o.getReturnorPayoutTrigger(), this::setReturnorPayoutTrigger);
			merger.mergeBasic(getExecutionVenueType(), o.getExecutionVenueType(), this::setExecutionVenueType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CSANonReportable _that = getType().cast(o);
		
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSANonReportableBuilder {" +
				"returnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"executionVenueType=" + this.executionVenueType +
			'}' + " " + super.toString();
		}
	}
}
