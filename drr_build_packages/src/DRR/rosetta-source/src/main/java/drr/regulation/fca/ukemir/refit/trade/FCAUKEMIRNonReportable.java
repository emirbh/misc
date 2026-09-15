package drr.regulation.fca.ukemir.refit.trade;

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
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.upi.AnnaDsbUpiRequestAndType;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.fca.ukemir.refit.trade.meta.FCAUKEMIRNonReportableMeta;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbNotionalScheduleEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="FCAUKEMIRNonReportable", builder=FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilderImpl.class, version="7.7.0")
@RuneDataType(value="FCAUKEMIRNonReportable", model="drr", builder=FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilderImpl.class, version="7.7.0")
public interface FCAUKEMIRNonReportable extends NonReportable {

	FCAUKEMIRNonReportableMeta metaData = new FCAUKEMIRNonReportableMeta();

	/*********************** Getter Methods  ***********************/
	String getRelationshipRecord();

	/*********************** Build Methods  ***********************/
	FCAUKEMIRNonReportable build();
	
	FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder toBuilder();
	
	static FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder builder() {
		return new FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FCAUKEMIRNonReportable> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FCAUKEMIRNonReportable> getType() {
		return FCAUKEMIRNonReportable.class;
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
		processor.processBasic(path.newSubPath("relationshipRecord"), String.class, getRelationshipRecord(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FCAUKEMIRNonReportableBuilder extends FCAUKEMIRNonReportable, NonReportable.NonReportableBuilder {
		@Override
		FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setEnrichment(EnrichmentData enrichment);
		@Override
		FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setPreUpiData(AnnaDsbUpiRequestAndType preUpiData);
		@Override
		FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setPostUpiData(AnnaDsbUpiRecord postUpiData);
		@Override
		FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setNotionalSchedule(AnnaDsbNotionalScheduleEnum notionalSchedule);
		@Override
		FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setUnderlyingAssetType(String underlyingAssetType);
		@Override
		FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setInstrumentType(AnnaDsbInstrumentTypeEnum instrumentType);
		@Override
		FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setDeliveryType(AnnaDsbDeliveryTypeEnum deliveryType);
		FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setRelationshipRecord(String relationshipRecord);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("enrichment"), processor, EnrichmentData.EnrichmentDataBuilder.class, getEnrichment());
			processRosetta(path.newSubPath("preUpiData"), processor, AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder.class, getPreUpiData());
			processRosetta(path.newSubPath("postUpiData"), processor, AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder.class, getPostUpiData());
			processor.processBasic(path.newSubPath("notionalSchedule"), AnnaDsbNotionalScheduleEnum.class, getNotionalSchedule(), this);
			processor.processBasic(path.newSubPath("underlyingAssetType"), String.class, getUnderlyingAssetType(), this);
			processor.processBasic(path.newSubPath("instrumentType"), AnnaDsbInstrumentTypeEnum.class, getInstrumentType(), this);
			processor.processBasic(path.newSubPath("deliveryType"), AnnaDsbDeliveryTypeEnum.class, getDeliveryType(), this);
			processor.processBasic(path.newSubPath("relationshipRecord"), String.class, getRelationshipRecord(), this);
		}
		

		FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder prune();
	}

	/*********************** Immutable Implementation of FCAUKEMIRNonReportable  ***********************/
	class FCAUKEMIRNonReportableImpl extends NonReportable.NonReportableImpl implements FCAUKEMIRNonReportable {
		private final String relationshipRecord;
		
		protected FCAUKEMIRNonReportableImpl(FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder builder) {
			super(builder);
			this.relationshipRecord = builder.getRelationshipRecord();
		}
		
		@Override
		@RosettaAttribute("relationshipRecord")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relationshipRecord")
		public String getRelationshipRecord() {
			return relationshipRecord;
		}
		
		@Override
		public FCAUKEMIRNonReportable build() {
			return this;
		}
		
		@Override
		public FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder toBuilder() {
			FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRelationshipRecord()).ifPresent(builder::setRelationshipRecord);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FCAUKEMIRNonReportable _that = getType().cast(o);
		
			if (!Objects.equals(relationshipRecord, _that.getRelationshipRecord())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relationshipRecord != null ? relationshipRecord.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FCAUKEMIRNonReportable {" +
				"relationshipRecord=" + this.relationshipRecord +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FCAUKEMIRNonReportable  ***********************/
	class FCAUKEMIRNonReportableBuilderImpl extends NonReportable.NonReportableBuilderImpl implements FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder {
	
		protected String relationshipRecord;
		
		@Override
		@RosettaAttribute("relationshipRecord")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relationshipRecord")
		public String getRelationshipRecord() {
			return relationshipRecord;
		}
		
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("enrichment")
		@Override
		public FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setEnrichment(EnrichmentData _enrichment) {
			this.enrichment = _enrichment == null ? null : _enrichment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("preUpiData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("preUpiData")
		@Override
		public FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setPreUpiData(AnnaDsbUpiRequestAndType _preUpiData) {
			this.preUpiData = _preUpiData == null ? null : _preUpiData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("postUpiData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("postUpiData")
		@Override
		public FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setPostUpiData(AnnaDsbUpiRecord _postUpiData) {
			this.postUpiData = _postUpiData == null ? null : _postUpiData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalSchedule")
		@Override
		public FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setNotionalSchedule(AnnaDsbNotionalScheduleEnum _notionalSchedule) {
			this.notionalSchedule = _notionalSchedule == null ? null : _notionalSchedule;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetType")
		@Override
		public FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setUnderlyingAssetType(String _underlyingAssetType) {
			this.underlyingAssetType = _underlyingAssetType == null ? null : _underlyingAssetType;
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("instrumentType")
		@Override
		public FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setInstrumentType(AnnaDsbInstrumentTypeEnum _instrumentType) {
			this.instrumentType = _instrumentType == null ? null : _instrumentType;
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryType")
		@Override
		public FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setDeliveryType(AnnaDsbDeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaAttribute("relationshipRecord")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relationshipRecord")
		@Override
		public FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder setRelationshipRecord(String _relationshipRecord) {
			this.relationshipRecord = _relationshipRecord == null ? null : _relationshipRecord;
			return this;
		}
		
		@Override
		public FCAUKEMIRNonReportable build() {
			return new FCAUKEMIRNonReportable.FCAUKEMIRNonReportableImpl(this);
		}
		
		@Override
		public FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRelationshipRecord()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder o = (FCAUKEMIRNonReportable.FCAUKEMIRNonReportableBuilder) other;
			
			
			merger.mergeBasic(getRelationshipRecord(), o.getRelationshipRecord(), this::setRelationshipRecord);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FCAUKEMIRNonReportable _that = getType().cast(o);
		
			if (!Objects.equals(relationshipRecord, _that.getRelationshipRecord())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relationshipRecord != null ? relationshipRecord.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FCAUKEMIRNonReportableBuilder {" +
				"relationshipRecord=" + this.relationshipRecord +
			'}' + " " + super.toString();
		}
	}
}
