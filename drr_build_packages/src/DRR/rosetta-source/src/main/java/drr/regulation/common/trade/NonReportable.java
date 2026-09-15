package drr.regulation.common.trade;

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
import drr.regulation.common.trade.meta.NonReportableMeta;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbNotionalScheduleEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="NonReportable", builder=NonReportable.NonReportableBuilderImpl.class, version="7.7.0")
@RuneDataType(value="NonReportable", model="drr", builder=NonReportable.NonReportableBuilderImpl.class, version="7.7.0")
public interface NonReportable extends RosettaModelObject {

	NonReportableMeta metaData = new NonReportableMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Populated by pre-enrichment process
	 */
	EnrichmentData getEnrichment();
	AnnaDsbUpiRequestAndType getPreUpiData();
	AnnaDsbUpiRecord getPostUpiData();
	AnnaDsbNotionalScheduleEnum getNotionalSchedule();
	String getUnderlyingAssetType();
	AnnaDsbInstrumentTypeEnum getInstrumentType();
	AnnaDsbDeliveryTypeEnum getDeliveryType();

	/*********************** Build Methods  ***********************/
	NonReportable build();
	
	NonReportable.NonReportableBuilder toBuilder();
	
	static NonReportable.NonReportableBuilder builder() {
		return new NonReportable.NonReportableBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonReportable> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonReportable> getType() {
		return NonReportable.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonReportableBuilder extends NonReportable, RosettaModelObjectBuilder {
		EnrichmentData.EnrichmentDataBuilder getOrCreateEnrichment();
		@Override
		EnrichmentData.EnrichmentDataBuilder getEnrichment();
		AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder getOrCreatePreUpiData();
		@Override
		AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder getPreUpiData();
		AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder getOrCreatePostUpiData();
		@Override
		AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder getPostUpiData();
		NonReportable.NonReportableBuilder setEnrichment(EnrichmentData enrichment);
		NonReportable.NonReportableBuilder setPreUpiData(AnnaDsbUpiRequestAndType preUpiData);
		NonReportable.NonReportableBuilder setPostUpiData(AnnaDsbUpiRecord postUpiData);
		NonReportable.NonReportableBuilder setNotionalSchedule(AnnaDsbNotionalScheduleEnum notionalSchedule);
		NonReportable.NonReportableBuilder setUnderlyingAssetType(String underlyingAssetType);
		NonReportable.NonReportableBuilder setInstrumentType(AnnaDsbInstrumentTypeEnum instrumentType);
		NonReportable.NonReportableBuilder setDeliveryType(AnnaDsbDeliveryTypeEnum deliveryType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("enrichment"), processor, EnrichmentData.EnrichmentDataBuilder.class, getEnrichment());
			processRosetta(path.newSubPath("preUpiData"), processor, AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder.class, getPreUpiData());
			processRosetta(path.newSubPath("postUpiData"), processor, AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder.class, getPostUpiData());
			processor.processBasic(path.newSubPath("notionalSchedule"), AnnaDsbNotionalScheduleEnum.class, getNotionalSchedule(), this);
			processor.processBasic(path.newSubPath("underlyingAssetType"), String.class, getUnderlyingAssetType(), this);
			processor.processBasic(path.newSubPath("instrumentType"), AnnaDsbInstrumentTypeEnum.class, getInstrumentType(), this);
			processor.processBasic(path.newSubPath("deliveryType"), AnnaDsbDeliveryTypeEnum.class, getDeliveryType(), this);
		}
		

		NonReportable.NonReportableBuilder prune();
	}

	/*********************** Immutable Implementation of NonReportable  ***********************/
	class NonReportableImpl implements NonReportable {
		private final EnrichmentData enrichment;
		private final AnnaDsbUpiRequestAndType preUpiData;
		private final AnnaDsbUpiRecord postUpiData;
		private final AnnaDsbNotionalScheduleEnum notionalSchedule;
		private final String underlyingAssetType;
		private final AnnaDsbInstrumentTypeEnum instrumentType;
		private final AnnaDsbDeliveryTypeEnum deliveryType;
		
		protected NonReportableImpl(NonReportable.NonReportableBuilder builder) {
			this.enrichment = ofNullable(builder.getEnrichment()).map(f->f.build()).orElse(null);
			this.preUpiData = ofNullable(builder.getPreUpiData()).map(f->f.build()).orElse(null);
			this.postUpiData = ofNullable(builder.getPostUpiData()).map(f->f.build()).orElse(null);
			this.notionalSchedule = builder.getNotionalSchedule();
			this.underlyingAssetType = builder.getUnderlyingAssetType();
			this.instrumentType = builder.getInstrumentType();
			this.deliveryType = builder.getDeliveryType();
		}
		
		@Override
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("enrichment")
		public EnrichmentData getEnrichment() {
			return enrichment;
		}
		
		@Override
		@RosettaAttribute("preUpiData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("preUpiData")
		public AnnaDsbUpiRequestAndType getPreUpiData() {
			return preUpiData;
		}
		
		@Override
		@RosettaAttribute("postUpiData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("postUpiData")
		public AnnaDsbUpiRecord getPostUpiData() {
			return postUpiData;
		}
		
		@Override
		@RosettaAttribute("notionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalSchedule")
		public AnnaDsbNotionalScheduleEnum getNotionalSchedule() {
			return notionalSchedule;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetType")
		public String getUnderlyingAssetType() {
			return underlyingAssetType;
		}
		
		@Override
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("instrumentType")
		public AnnaDsbInstrumentTypeEnum getInstrumentType() {
			return instrumentType;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryType")
		public AnnaDsbDeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		public NonReportable build() {
			return this;
		}
		
		@Override
		public NonReportable.NonReportableBuilder toBuilder() {
			NonReportable.NonReportableBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonReportable.NonReportableBuilder builder) {
			ofNullable(getEnrichment()).ifPresent(builder::setEnrichment);
			ofNullable(getPreUpiData()).ifPresent(builder::setPreUpiData);
			ofNullable(getPostUpiData()).ifPresent(builder::setPostUpiData);
			ofNullable(getNotionalSchedule()).ifPresent(builder::setNotionalSchedule);
			ofNullable(getUnderlyingAssetType()).ifPresent(builder::setUnderlyingAssetType);
			ofNullable(getInstrumentType()).ifPresent(builder::setInstrumentType);
			ofNullable(getDeliveryType()).ifPresent(builder::setDeliveryType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonReportable _that = getType().cast(o);
		
			if (!Objects.equals(enrichment, _that.getEnrichment())) return false;
			if (!Objects.equals(preUpiData, _that.getPreUpiData())) return false;
			if (!Objects.equals(postUpiData, _that.getPostUpiData())) return false;
			if (!Objects.equals(notionalSchedule, _that.getNotionalSchedule())) return false;
			if (!Objects.equals(underlyingAssetType, _that.getUnderlyingAssetType())) return false;
			if (!Objects.equals(instrumentType, _that.getInstrumentType())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (enrichment != null ? enrichment.hashCode() : 0);
			_result = 31 * _result + (preUpiData != null ? preUpiData.hashCode() : 0);
			_result = 31 * _result + (postUpiData != null ? postUpiData.hashCode() : 0);
			_result = 31 * _result + (notionalSchedule != null ? notionalSchedule.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingAssetType != null ? underlyingAssetType.hashCode() : 0);
			_result = 31 * _result + (instrumentType != null ? instrumentType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonReportable {" +
				"enrichment=" + this.enrichment + ", " +
				"preUpiData=" + this.preUpiData + ", " +
				"postUpiData=" + this.postUpiData + ", " +
				"notionalSchedule=" + this.notionalSchedule + ", " +
				"underlyingAssetType=" + this.underlyingAssetType + ", " +
				"instrumentType=" + this.instrumentType + ", " +
				"deliveryType=" + this.deliveryType +
			'}';
		}
	}

	/*********************** Builder Implementation of NonReportable  ***********************/
	class NonReportableBuilderImpl implements NonReportable.NonReportableBuilder {
	
		protected EnrichmentData.EnrichmentDataBuilder enrichment;
		protected AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder preUpiData;
		protected AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder postUpiData;
		protected AnnaDsbNotionalScheduleEnum notionalSchedule;
		protected String underlyingAssetType;
		protected AnnaDsbInstrumentTypeEnum instrumentType;
		protected AnnaDsbDeliveryTypeEnum deliveryType;
		
		@Override
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("enrichment")
		public EnrichmentData.EnrichmentDataBuilder getEnrichment() {
			return enrichment;
		}
		
		@Override
		public EnrichmentData.EnrichmentDataBuilder getOrCreateEnrichment() {
			EnrichmentData.EnrichmentDataBuilder result;
			if (enrichment!=null) {
				result = enrichment;
			}
			else {
				result = enrichment = EnrichmentData.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("preUpiData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("preUpiData")
		public AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder getPreUpiData() {
			return preUpiData;
		}
		
		@Override
		public AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder getOrCreatePreUpiData() {
			AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder result;
			if (preUpiData!=null) {
				result = preUpiData;
			}
			else {
				result = preUpiData = AnnaDsbUpiRequestAndType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("postUpiData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("postUpiData")
		public AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder getPostUpiData() {
			return postUpiData;
		}
		
		@Override
		public AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder getOrCreatePostUpiData() {
			AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder result;
			if (postUpiData!=null) {
				result = postUpiData;
			}
			else {
				result = postUpiData = AnnaDsbUpiRecord.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalSchedule")
		public AnnaDsbNotionalScheduleEnum getNotionalSchedule() {
			return notionalSchedule;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetType")
		public String getUnderlyingAssetType() {
			return underlyingAssetType;
		}
		
		@Override
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("instrumentType")
		public AnnaDsbInstrumentTypeEnum getInstrumentType() {
			return instrumentType;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryType")
		public AnnaDsbDeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@RosettaAttribute("enrichment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("enrichment")
		@Override
		public NonReportable.NonReportableBuilder setEnrichment(EnrichmentData _enrichment) {
			this.enrichment = _enrichment == null ? null : _enrichment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("preUpiData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("preUpiData")
		@Override
		public NonReportable.NonReportableBuilder setPreUpiData(AnnaDsbUpiRequestAndType _preUpiData) {
			this.preUpiData = _preUpiData == null ? null : _preUpiData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("postUpiData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("postUpiData")
		@Override
		public NonReportable.NonReportableBuilder setPostUpiData(AnnaDsbUpiRecord _postUpiData) {
			this.postUpiData = _postUpiData == null ? null : _postUpiData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalSchedule")
		@Override
		public NonReportable.NonReportableBuilder setNotionalSchedule(AnnaDsbNotionalScheduleEnum _notionalSchedule) {
			this.notionalSchedule = _notionalSchedule == null ? null : _notionalSchedule;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetType")
		@Override
		public NonReportable.NonReportableBuilder setUnderlyingAssetType(String _underlyingAssetType) {
			this.underlyingAssetType = _underlyingAssetType == null ? null : _underlyingAssetType;
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("instrumentType")
		@Override
		public NonReportable.NonReportableBuilder setInstrumentType(AnnaDsbInstrumentTypeEnum _instrumentType) {
			this.instrumentType = _instrumentType == null ? null : _instrumentType;
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryType")
		@Override
		public NonReportable.NonReportableBuilder setDeliveryType(AnnaDsbDeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@Override
		public NonReportable build() {
			return new NonReportable.NonReportableImpl(this);
		}
		
		@Override
		public NonReportable.NonReportableBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonReportable.NonReportableBuilder prune() {
			if (enrichment!=null && !enrichment.prune().hasData()) enrichment = null;
			if (preUpiData!=null && !preUpiData.prune().hasData()) preUpiData = null;
			if (postUpiData!=null && !postUpiData.prune().hasData()) postUpiData = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEnrichment()!=null && getEnrichment().hasData()) return true;
			if (getPreUpiData()!=null && getPreUpiData().hasData()) return true;
			if (getPostUpiData()!=null && getPostUpiData().hasData()) return true;
			if (getNotionalSchedule()!=null) return true;
			if (getUnderlyingAssetType()!=null) return true;
			if (getInstrumentType()!=null) return true;
			if (getDeliveryType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonReportable.NonReportableBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonReportable.NonReportableBuilder o = (NonReportable.NonReportableBuilder) other;
			
			merger.mergeRosetta(getEnrichment(), o.getEnrichment(), this::setEnrichment);
			merger.mergeRosetta(getPreUpiData(), o.getPreUpiData(), this::setPreUpiData);
			merger.mergeRosetta(getPostUpiData(), o.getPostUpiData(), this::setPostUpiData);
			
			merger.mergeBasic(getNotionalSchedule(), o.getNotionalSchedule(), this::setNotionalSchedule);
			merger.mergeBasic(getUnderlyingAssetType(), o.getUnderlyingAssetType(), this::setUnderlyingAssetType);
			merger.mergeBasic(getInstrumentType(), o.getInstrumentType(), this::setInstrumentType);
			merger.mergeBasic(getDeliveryType(), o.getDeliveryType(), this::setDeliveryType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonReportable _that = getType().cast(o);
		
			if (!Objects.equals(enrichment, _that.getEnrichment())) return false;
			if (!Objects.equals(preUpiData, _that.getPreUpiData())) return false;
			if (!Objects.equals(postUpiData, _that.getPostUpiData())) return false;
			if (!Objects.equals(notionalSchedule, _that.getNotionalSchedule())) return false;
			if (!Objects.equals(underlyingAssetType, _that.getUnderlyingAssetType())) return false;
			if (!Objects.equals(instrumentType, _that.getInstrumentType())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (enrichment != null ? enrichment.hashCode() : 0);
			_result = 31 * _result + (preUpiData != null ? preUpiData.hashCode() : 0);
			_result = 31 * _result + (postUpiData != null ? postUpiData.hashCode() : 0);
			_result = 31 * _result + (notionalSchedule != null ? notionalSchedule.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingAssetType != null ? underlyingAssetType.hashCode() : 0);
			_result = 31 * _result + (instrumentType != null ? instrumentType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonReportableBuilder {" +
				"enrichment=" + this.enrichment + ", " +
				"preUpiData=" + this.preUpiData + ", " +
				"postUpiData=" + this.postUpiData + ", " +
				"notionalSchedule=" + this.notionalSchedule + ", " +
				"underlyingAssetType=" + this.underlyingAssetType + ", " +
				"instrumentType=" + this.instrumentType + ", " +
				"deliveryType=" + this.deliveryType +
			'}';
		}
	}
}
