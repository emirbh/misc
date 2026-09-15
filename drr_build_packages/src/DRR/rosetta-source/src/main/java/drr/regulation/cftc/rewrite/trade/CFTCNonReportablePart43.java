package drr.regulation.cftc.rewrite.trade;

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
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.upi.AnnaDsbUpiRequestAndType;
import drr.regulation.cftc.rewrite.trade.meta.CFTCNonReportablePart43Meta;
import drr.regulation.common.trade.NonReportable;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbNotionalScheduleEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="CFTCNonReportablePart43", builder=CFTCNonReportablePart43.CFTCNonReportablePart43BuilderImpl.class, version="7.7.0")
@RuneDataType(value="CFTCNonReportablePart43", model="drr", builder=CFTCNonReportablePart43.CFTCNonReportablePart43BuilderImpl.class, version="7.7.0")
public interface CFTCNonReportablePart43 extends NonReportable {

	CFTCNonReportablePart43Meta metaData = new CFTCNonReportablePart43Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Counterparty1 Format - LEI, or LEI and Person.
	 */
	PartyIdentifierFormatEnum getCounterparty1Format();
	/**
	 * Counterparty2 Format - LEI, or LEI and Person.
	 */
	PartyIdentifierFormatEnum getCounterparty2Format();
	/**
	 * Execution Venue Type
	 */
	ExecutionVenueTypeEnum getExecutionVenueType();

	/*********************** Build Methods  ***********************/
	CFTCNonReportablePart43 build();
	
	CFTCNonReportablePart43.CFTCNonReportablePart43Builder toBuilder();
	
	static CFTCNonReportablePart43.CFTCNonReportablePart43Builder builder() {
		return new CFTCNonReportablePart43.CFTCNonReportablePart43BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CFTCNonReportablePart43> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CFTCNonReportablePart43> getType() {
		return CFTCNonReportablePart43.class;
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
		processor.processBasic(path.newSubPath("counterparty1Format"), PartyIdentifierFormatEnum.class, getCounterparty1Format(), this);
		processor.processBasic(path.newSubPath("counterparty2Format"), PartyIdentifierFormatEnum.class, getCounterparty2Format(), this);
		processor.processBasic(path.newSubPath("executionVenueType"), ExecutionVenueTypeEnum.class, getExecutionVenueType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CFTCNonReportablePart43Builder extends CFTCNonReportablePart43, NonReportable.NonReportableBuilder {
		@Override
		CFTCNonReportablePart43.CFTCNonReportablePart43Builder setEnrichment(EnrichmentData enrichment);
		@Override
		CFTCNonReportablePart43.CFTCNonReportablePart43Builder setPreUpiData(AnnaDsbUpiRequestAndType preUpiData);
		@Override
		CFTCNonReportablePart43.CFTCNonReportablePart43Builder setPostUpiData(AnnaDsbUpiRecord postUpiData);
		@Override
		CFTCNonReportablePart43.CFTCNonReportablePart43Builder setNotionalSchedule(AnnaDsbNotionalScheduleEnum notionalSchedule);
		@Override
		CFTCNonReportablePart43.CFTCNonReportablePart43Builder setUnderlyingAssetType(String underlyingAssetType);
		@Override
		CFTCNonReportablePart43.CFTCNonReportablePart43Builder setInstrumentType(AnnaDsbInstrumentTypeEnum instrumentType);
		@Override
		CFTCNonReportablePart43.CFTCNonReportablePart43Builder setDeliveryType(AnnaDsbDeliveryTypeEnum deliveryType);
		CFTCNonReportablePart43.CFTCNonReportablePart43Builder setCounterparty1Format(PartyIdentifierFormatEnum counterparty1Format);
		CFTCNonReportablePart43.CFTCNonReportablePart43Builder setCounterparty2Format(PartyIdentifierFormatEnum counterparty2Format);
		CFTCNonReportablePart43.CFTCNonReportablePart43Builder setExecutionVenueType(ExecutionVenueTypeEnum executionVenueType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("enrichment"), processor, EnrichmentData.EnrichmentDataBuilder.class, getEnrichment());
			processRosetta(path.newSubPath("preUpiData"), processor, AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder.class, getPreUpiData());
			processRosetta(path.newSubPath("postUpiData"), processor, AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder.class, getPostUpiData());
			processor.processBasic(path.newSubPath("notionalSchedule"), AnnaDsbNotionalScheduleEnum.class, getNotionalSchedule(), this);
			processor.processBasic(path.newSubPath("underlyingAssetType"), String.class, getUnderlyingAssetType(), this);
			processor.processBasic(path.newSubPath("instrumentType"), AnnaDsbInstrumentTypeEnum.class, getInstrumentType(), this);
			processor.processBasic(path.newSubPath("deliveryType"), AnnaDsbDeliveryTypeEnum.class, getDeliveryType(), this);
			processor.processBasic(path.newSubPath("counterparty1Format"), PartyIdentifierFormatEnum.class, getCounterparty1Format(), this);
			processor.processBasic(path.newSubPath("counterparty2Format"), PartyIdentifierFormatEnum.class, getCounterparty2Format(), this);
			processor.processBasic(path.newSubPath("executionVenueType"), ExecutionVenueTypeEnum.class, getExecutionVenueType(), this);
		}
		

		CFTCNonReportablePart43.CFTCNonReportablePart43Builder prune();
	}

	/*********************** Immutable Implementation of CFTCNonReportablePart43  ***********************/
	class CFTCNonReportablePart43Impl extends NonReportable.NonReportableImpl implements CFTCNonReportablePart43 {
		private final PartyIdentifierFormatEnum counterparty1Format;
		private final PartyIdentifierFormatEnum counterparty2Format;
		private final ExecutionVenueTypeEnum executionVenueType;
		
		protected CFTCNonReportablePart43Impl(CFTCNonReportablePart43.CFTCNonReportablePart43Builder builder) {
			super(builder);
			this.counterparty1Format = builder.getCounterparty1Format();
			this.counterparty2Format = builder.getCounterparty2Format();
			this.executionVenueType = builder.getExecutionVenueType();
		}
		
		@Override
		@RosettaAttribute("counterparty1Format")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty1Format")
		public PartyIdentifierFormatEnum getCounterparty1Format() {
			return counterparty1Format;
		}
		
		@Override
		@RosettaAttribute("counterparty2Format")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2Format")
		public PartyIdentifierFormatEnum getCounterparty2Format() {
			return counterparty2Format;
		}
		
		@Override
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueType")
		public ExecutionVenueTypeEnum getExecutionVenueType() {
			return executionVenueType;
		}
		
		@Override
		public CFTCNonReportablePart43 build() {
			return this;
		}
		
		@Override
		public CFTCNonReportablePart43.CFTCNonReportablePart43Builder toBuilder() {
			CFTCNonReportablePart43.CFTCNonReportablePart43Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CFTCNonReportablePart43.CFTCNonReportablePart43Builder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCounterparty1Format()).ifPresent(builder::setCounterparty1Format);
			ofNullable(getCounterparty2Format()).ifPresent(builder::setCounterparty2Format);
			ofNullable(getExecutionVenueType()).ifPresent(builder::setExecutionVenueType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CFTCNonReportablePart43 _that = getType().cast(o);
		
			if (!Objects.equals(counterparty1Format, _that.getCounterparty1Format())) return false;
			if (!Objects.equals(counterparty2Format, _that.getCounterparty2Format())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty1Format != null ? counterparty1Format.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (counterparty2Format != null ? counterparty2Format.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CFTCNonReportablePart43 {" +
				"counterparty1Format=" + this.counterparty1Format + ", " +
				"counterparty2Format=" + this.counterparty2Format + ", " +
				"executionVenueType=" + this.executionVenueType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CFTCNonReportablePart43  ***********************/
	class CFTCNonReportablePart43BuilderImpl extends NonReportable.NonReportableBuilderImpl implements CFTCNonReportablePart43.CFTCNonReportablePart43Builder {
	
		protected PartyIdentifierFormatEnum counterparty1Format;
		protected PartyIdentifierFormatEnum counterparty2Format;
		protected ExecutionVenueTypeEnum executionVenueType;
		
		@Override
		@RosettaAttribute("counterparty1Format")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty1Format")
		public PartyIdentifierFormatEnum getCounterparty1Format() {
			return counterparty1Format;
		}
		
		@Override
		@RosettaAttribute("counterparty2Format")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2Format")
		public PartyIdentifierFormatEnum getCounterparty2Format() {
			return counterparty2Format;
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
		public CFTCNonReportablePart43.CFTCNonReportablePart43Builder setEnrichment(EnrichmentData _enrichment) {
			this.enrichment = _enrichment == null ? null : _enrichment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("preUpiData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("preUpiData")
		@Override
		public CFTCNonReportablePart43.CFTCNonReportablePart43Builder setPreUpiData(AnnaDsbUpiRequestAndType _preUpiData) {
			this.preUpiData = _preUpiData == null ? null : _preUpiData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("postUpiData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("postUpiData")
		@Override
		public CFTCNonReportablePart43.CFTCNonReportablePart43Builder setPostUpiData(AnnaDsbUpiRecord _postUpiData) {
			this.postUpiData = _postUpiData == null ? null : _postUpiData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalSchedule")
		@Override
		public CFTCNonReportablePart43.CFTCNonReportablePart43Builder setNotionalSchedule(AnnaDsbNotionalScheduleEnum _notionalSchedule) {
			this.notionalSchedule = _notionalSchedule == null ? null : _notionalSchedule;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetType")
		@Override
		public CFTCNonReportablePart43.CFTCNonReportablePart43Builder setUnderlyingAssetType(String _underlyingAssetType) {
			this.underlyingAssetType = _underlyingAssetType == null ? null : _underlyingAssetType;
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("instrumentType")
		@Override
		public CFTCNonReportablePart43.CFTCNonReportablePart43Builder setInstrumentType(AnnaDsbInstrumentTypeEnum _instrumentType) {
			this.instrumentType = _instrumentType == null ? null : _instrumentType;
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryType")
		@Override
		public CFTCNonReportablePart43.CFTCNonReportablePart43Builder setDeliveryType(AnnaDsbDeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaAttribute("counterparty1Format")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty1Format")
		@Override
		public CFTCNonReportablePart43.CFTCNonReportablePart43Builder setCounterparty1Format(PartyIdentifierFormatEnum _counterparty1Format) {
			this.counterparty1Format = _counterparty1Format == null ? null : _counterparty1Format;
			return this;
		}
		
		@RosettaAttribute("counterparty2Format")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2Format")
		@Override
		public CFTCNonReportablePart43.CFTCNonReportablePart43Builder setCounterparty2Format(PartyIdentifierFormatEnum _counterparty2Format) {
			this.counterparty2Format = _counterparty2Format == null ? null : _counterparty2Format;
			return this;
		}
		
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionVenueType")
		@Override
		public CFTCNonReportablePart43.CFTCNonReportablePart43Builder setExecutionVenueType(ExecutionVenueTypeEnum _executionVenueType) {
			this.executionVenueType = _executionVenueType == null ? null : _executionVenueType;
			return this;
		}
		
		@Override
		public CFTCNonReportablePart43 build() {
			return new CFTCNonReportablePart43.CFTCNonReportablePart43Impl(this);
		}
		
		@Override
		public CFTCNonReportablePart43.CFTCNonReportablePart43Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CFTCNonReportablePart43.CFTCNonReportablePart43Builder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCounterparty1Format()!=null) return true;
			if (getCounterparty2Format()!=null) return true;
			if (getExecutionVenueType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CFTCNonReportablePart43.CFTCNonReportablePart43Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CFTCNonReportablePart43.CFTCNonReportablePart43Builder o = (CFTCNonReportablePart43.CFTCNonReportablePart43Builder) other;
			
			
			merger.mergeBasic(getCounterparty1Format(), o.getCounterparty1Format(), this::setCounterparty1Format);
			merger.mergeBasic(getCounterparty2Format(), o.getCounterparty2Format(), this::setCounterparty2Format);
			merger.mergeBasic(getExecutionVenueType(), o.getExecutionVenueType(), this::setExecutionVenueType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CFTCNonReportablePart43 _that = getType().cast(o);
		
			if (!Objects.equals(counterparty1Format, _that.getCounterparty1Format())) return false;
			if (!Objects.equals(counterparty2Format, _that.getCounterparty2Format())) return false;
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (counterparty1Format != null ? counterparty1Format.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (counterparty2Format != null ? counterparty2Format.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CFTCNonReportablePart43Builder {" +
				"counterparty1Format=" + this.counterparty1Format + ", " +
				"counterparty2Format=" + this.counterparty2Format + ", " +
				"executionVenueType=" + this.executionVenueType +
			'}' + " " + super.toString();
		}
	}
}
