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
import drr.regulation.cftc.rewrite.trade.meta.CFTCNonReportablePart45Meta;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbNotionalScheduleEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="CFTCNonReportablePart45", builder=CFTCNonReportablePart45.CFTCNonReportablePart45BuilderImpl.class, version="7.7.0")
@RuneDataType(value="CFTCNonReportablePart45", model="drr", builder=CFTCNonReportablePart45.CFTCNonReportablePart45BuilderImpl.class, version="7.7.0")
public interface CFTCNonReportablePart45 extends CFTCNonReportablePart43 {

	CFTCNonReportablePart45Meta metaData = new CFTCNonReportablePart45Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * BuyerIdentifier Format - LEI, or LEI and Person.
	 */
	PartyIdentifierFormatEnum getBuyerIdentifierFormat();
	/**
	 * SellerIdentifier Format - LEI, or LEI and Person.
	 */
	PartyIdentifierFormatEnum getSellerIdentifierFormat();

	/*********************** Build Methods  ***********************/
	CFTCNonReportablePart45 build();
	
	CFTCNonReportablePart45.CFTCNonReportablePart45Builder toBuilder();
	
	static CFTCNonReportablePart45.CFTCNonReportablePart45Builder builder() {
		return new CFTCNonReportablePart45.CFTCNonReportablePart45BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CFTCNonReportablePart45> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CFTCNonReportablePart45> getType() {
		return CFTCNonReportablePart45.class;
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
		processor.processBasic(path.newSubPath("buyerIdentifierFormat"), PartyIdentifierFormatEnum.class, getBuyerIdentifierFormat(), this);
		processor.processBasic(path.newSubPath("sellerIdentifierFormat"), PartyIdentifierFormatEnum.class, getSellerIdentifierFormat(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CFTCNonReportablePart45Builder extends CFTCNonReportablePart45, CFTCNonReportablePart43.CFTCNonReportablePart43Builder {
		@Override
		CFTCNonReportablePart45.CFTCNonReportablePart45Builder setEnrichment(EnrichmentData enrichment);
		@Override
		CFTCNonReportablePart45.CFTCNonReportablePart45Builder setPreUpiData(AnnaDsbUpiRequestAndType preUpiData);
		@Override
		CFTCNonReportablePart45.CFTCNonReportablePart45Builder setPostUpiData(AnnaDsbUpiRecord postUpiData);
		@Override
		CFTCNonReportablePart45.CFTCNonReportablePart45Builder setNotionalSchedule(AnnaDsbNotionalScheduleEnum notionalSchedule);
		@Override
		CFTCNonReportablePart45.CFTCNonReportablePart45Builder setUnderlyingAssetType(String underlyingAssetType);
		@Override
		CFTCNonReportablePart45.CFTCNonReportablePart45Builder setInstrumentType(AnnaDsbInstrumentTypeEnum instrumentType);
		@Override
		CFTCNonReportablePart45.CFTCNonReportablePart45Builder setDeliveryType(AnnaDsbDeliveryTypeEnum deliveryType);
		@Override
		CFTCNonReportablePart45.CFTCNonReportablePart45Builder setCounterparty1Format(PartyIdentifierFormatEnum counterparty1Format);
		@Override
		CFTCNonReportablePart45.CFTCNonReportablePart45Builder setCounterparty2Format(PartyIdentifierFormatEnum counterparty2Format);
		@Override
		CFTCNonReportablePart45.CFTCNonReportablePart45Builder setExecutionVenueType(ExecutionVenueTypeEnum executionVenueType);
		CFTCNonReportablePart45.CFTCNonReportablePart45Builder setBuyerIdentifierFormat(PartyIdentifierFormatEnum buyerIdentifierFormat);
		CFTCNonReportablePart45.CFTCNonReportablePart45Builder setSellerIdentifierFormat(PartyIdentifierFormatEnum sellerIdentifierFormat);

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
			processor.processBasic(path.newSubPath("buyerIdentifierFormat"), PartyIdentifierFormatEnum.class, getBuyerIdentifierFormat(), this);
			processor.processBasic(path.newSubPath("sellerIdentifierFormat"), PartyIdentifierFormatEnum.class, getSellerIdentifierFormat(), this);
		}
		

		CFTCNonReportablePart45.CFTCNonReportablePart45Builder prune();
	}

	/*********************** Immutable Implementation of CFTCNonReportablePart45  ***********************/
	class CFTCNonReportablePart45Impl extends CFTCNonReportablePart43.CFTCNonReportablePart43Impl implements CFTCNonReportablePart45 {
		private final PartyIdentifierFormatEnum buyerIdentifierFormat;
		private final PartyIdentifierFormatEnum sellerIdentifierFormat;
		
		protected CFTCNonReportablePart45Impl(CFTCNonReportablePart45.CFTCNonReportablePart45Builder builder) {
			super(builder);
			this.buyerIdentifierFormat = builder.getBuyerIdentifierFormat();
			this.sellerIdentifierFormat = builder.getSellerIdentifierFormat();
		}
		
		@Override
		@RosettaAttribute("buyerIdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerIdentifierFormat")
		public PartyIdentifierFormatEnum getBuyerIdentifierFormat() {
			return buyerIdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("sellerIdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerIdentifierFormat")
		public PartyIdentifierFormatEnum getSellerIdentifierFormat() {
			return sellerIdentifierFormat;
		}
		
		@Override
		public CFTCNonReportablePart45 build() {
			return this;
		}
		
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder toBuilder() {
			CFTCNonReportablePart45.CFTCNonReportablePart45Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CFTCNonReportablePart45.CFTCNonReportablePart45Builder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerIdentifierFormat()).ifPresent(builder::setBuyerIdentifierFormat);
			ofNullable(getSellerIdentifierFormat()).ifPresent(builder::setSellerIdentifierFormat);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CFTCNonReportablePart45 _that = getType().cast(o);
		
			if (!Objects.equals(buyerIdentifierFormat, _that.getBuyerIdentifierFormat())) return false;
			if (!Objects.equals(sellerIdentifierFormat, _that.getSellerIdentifierFormat())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerIdentifierFormat != null ? buyerIdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (sellerIdentifierFormat != null ? sellerIdentifierFormat.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CFTCNonReportablePart45 {" +
				"buyerIdentifierFormat=" + this.buyerIdentifierFormat + ", " +
				"sellerIdentifierFormat=" + this.sellerIdentifierFormat +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CFTCNonReportablePart45  ***********************/
	class CFTCNonReportablePart45BuilderImpl extends CFTCNonReportablePart43.CFTCNonReportablePart43BuilderImpl implements CFTCNonReportablePart45.CFTCNonReportablePart45Builder {
	
		protected PartyIdentifierFormatEnum buyerIdentifierFormat;
		protected PartyIdentifierFormatEnum sellerIdentifierFormat;
		
		@Override
		@RosettaAttribute("buyerIdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerIdentifierFormat")
		public PartyIdentifierFormatEnum getBuyerIdentifierFormat() {
			return buyerIdentifierFormat;
		}
		
		@Override
		@RosettaAttribute("sellerIdentifierFormat")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerIdentifierFormat")
		public PartyIdentifierFormatEnum getSellerIdentifierFormat() {
			return sellerIdentifierFormat;
		}
		
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("enrichment")
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder setEnrichment(EnrichmentData _enrichment) {
			this.enrichment = _enrichment == null ? null : _enrichment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("preUpiData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("preUpiData")
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder setPreUpiData(AnnaDsbUpiRequestAndType _preUpiData) {
			this.preUpiData = _preUpiData == null ? null : _preUpiData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("postUpiData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("postUpiData")
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder setPostUpiData(AnnaDsbUpiRecord _postUpiData) {
			this.postUpiData = _postUpiData == null ? null : _postUpiData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalSchedule")
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder setNotionalSchedule(AnnaDsbNotionalScheduleEnum _notionalSchedule) {
			this.notionalSchedule = _notionalSchedule == null ? null : _notionalSchedule;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetType")
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder setUnderlyingAssetType(String _underlyingAssetType) {
			this.underlyingAssetType = _underlyingAssetType == null ? null : _underlyingAssetType;
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("instrumentType")
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder setInstrumentType(AnnaDsbInstrumentTypeEnum _instrumentType) {
			this.instrumentType = _instrumentType == null ? null : _instrumentType;
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryType")
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder setDeliveryType(AnnaDsbDeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaAttribute("counterparty1Format")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty1Format")
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder setCounterparty1Format(PartyIdentifierFormatEnum _counterparty1Format) {
			this.counterparty1Format = _counterparty1Format == null ? null : _counterparty1Format;
			return this;
		}
		
		@RosettaAttribute("counterparty2Format")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2Format")
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder setCounterparty2Format(PartyIdentifierFormatEnum _counterparty2Format) {
			this.counterparty2Format = _counterparty2Format == null ? null : _counterparty2Format;
			return this;
		}
		
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionVenueType")
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder setExecutionVenueType(ExecutionVenueTypeEnum _executionVenueType) {
			this.executionVenueType = _executionVenueType == null ? null : _executionVenueType;
			return this;
		}
		
		@RosettaAttribute("buyerIdentifierFormat")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerIdentifierFormat")
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder setBuyerIdentifierFormat(PartyIdentifierFormatEnum _buyerIdentifierFormat) {
			this.buyerIdentifierFormat = _buyerIdentifierFormat == null ? null : _buyerIdentifierFormat;
			return this;
		}
		
		@RosettaAttribute("sellerIdentifierFormat")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerIdentifierFormat")
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder setSellerIdentifierFormat(PartyIdentifierFormatEnum _sellerIdentifierFormat) {
			this.sellerIdentifierFormat = _sellerIdentifierFormat == null ? null : _sellerIdentifierFormat;
			return this;
		}
		
		@Override
		public CFTCNonReportablePart45 build() {
			return new CFTCNonReportablePart45.CFTCNonReportablePart45Impl(this);
		}
		
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerIdentifierFormat()!=null) return true;
			if (getSellerIdentifierFormat()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CFTCNonReportablePart45.CFTCNonReportablePart45Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CFTCNonReportablePart45.CFTCNonReportablePart45Builder o = (CFTCNonReportablePart45.CFTCNonReportablePart45Builder) other;
			
			
			merger.mergeBasic(getBuyerIdentifierFormat(), o.getBuyerIdentifierFormat(), this::setBuyerIdentifierFormat);
			merger.mergeBasic(getSellerIdentifierFormat(), o.getSellerIdentifierFormat(), this::setSellerIdentifierFormat);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CFTCNonReportablePart45 _that = getType().cast(o);
		
			if (!Objects.equals(buyerIdentifierFormat, _that.getBuyerIdentifierFormat())) return false;
			if (!Objects.equals(sellerIdentifierFormat, _that.getSellerIdentifierFormat())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (buyerIdentifierFormat != null ? buyerIdentifierFormat.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (sellerIdentifierFormat != null ? sellerIdentifierFormat.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CFTCNonReportablePart45Builder {" +
				"buyerIdentifierFormat=" + this.buyerIdentifierFormat + ", " +
				"sellerIdentifierFormat=" + this.sellerIdentifierFormat +
			'}' + " " + super.toString();
		}
	}
}
