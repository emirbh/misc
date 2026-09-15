package drr.enrichment.upi;

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
import drr.enrichment.upi.meta.UpiDataMeta;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="UpiData", builder=UpiData.UpiDataBuilderImpl.class, version="7.7.0")
@RuneDataType(value="UpiData", model="drr", builder=UpiData.UpiDataBuilderImpl.class, version="7.7.0")
public interface UpiData extends RosettaModelObject {

	UpiDataMeta metaData = new UpiDataMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbUpiRecord getUpiRecord();
	Boolean getUpiOfUnderlying();
	/**
	 * Specifies whether the UPI enrichment data should be used (True) or not (False).
	 */
	Boolean getUpiValidation();

	/*********************** Build Methods  ***********************/
	UpiData build();
	
	UpiData.UpiDataBuilder toBuilder();
	
	static UpiData.UpiDataBuilder builder() {
		return new UpiData.UpiDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UpiData> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UpiData> getType() {
		return UpiData.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("upiRecord"), processor, AnnaDsbUpiRecord.class, getUpiRecord());
		processor.processBasic(path.newSubPath("upiOfUnderlying"), Boolean.class, getUpiOfUnderlying(), this);
		processor.processBasic(path.newSubPath("upiValidation"), Boolean.class, getUpiValidation(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface UpiDataBuilder extends UpiData, RosettaModelObjectBuilder {
		AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder getOrCreateUpiRecord();
		@Override
		AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder getUpiRecord();
		UpiData.UpiDataBuilder setUpiRecord(AnnaDsbUpiRecord upiRecord);
		UpiData.UpiDataBuilder setUpiOfUnderlying(Boolean upiOfUnderlying);
		UpiData.UpiDataBuilder setUpiValidation(Boolean upiValidation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("upiRecord"), processor, AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder.class, getUpiRecord());
			processor.processBasic(path.newSubPath("upiOfUnderlying"), Boolean.class, getUpiOfUnderlying(), this);
			processor.processBasic(path.newSubPath("upiValidation"), Boolean.class, getUpiValidation(), this);
		}
		

		UpiData.UpiDataBuilder prune();
	}

	/*********************** Immutable Implementation of UpiData  ***********************/
	class UpiDataImpl implements UpiData {
		private final AnnaDsbUpiRecord upiRecord;
		private final Boolean upiOfUnderlying;
		private final Boolean upiValidation;
		
		protected UpiDataImpl(UpiData.UpiDataBuilder builder) {
			this.upiRecord = ofNullable(builder.getUpiRecord()).map(f->f.build()).orElse(null);
			this.upiOfUnderlying = builder.getUpiOfUnderlying();
			this.upiValidation = builder.getUpiValidation();
		}
		
		@Override
		@RosettaAttribute("upiRecord")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upiRecord")
		public AnnaDsbUpiRecord getUpiRecord() {
			return upiRecord;
		}
		
		@Override
		@RosettaAttribute("upiOfUnderlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upiOfUnderlying")
		public Boolean getUpiOfUnderlying() {
			return upiOfUnderlying;
		}
		
		@Override
		@RosettaAttribute("upiValidation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upiValidation")
		public Boolean getUpiValidation() {
			return upiValidation;
		}
		
		@Override
		public UpiData build() {
			return this;
		}
		
		@Override
		public UpiData.UpiDataBuilder toBuilder() {
			UpiData.UpiDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UpiData.UpiDataBuilder builder) {
			ofNullable(getUpiRecord()).ifPresent(builder::setUpiRecord);
			ofNullable(getUpiOfUnderlying()).ifPresent(builder::setUpiOfUnderlying);
			ofNullable(getUpiValidation()).ifPresent(builder::setUpiValidation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UpiData _that = getType().cast(o);
		
			if (!Objects.equals(upiRecord, _that.getUpiRecord())) return false;
			if (!Objects.equals(upiOfUnderlying, _that.getUpiOfUnderlying())) return false;
			if (!Objects.equals(upiValidation, _that.getUpiValidation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (upiRecord != null ? upiRecord.hashCode() : 0);
			_result = 31 * _result + (upiOfUnderlying != null ? upiOfUnderlying.hashCode() : 0);
			_result = 31 * _result + (upiValidation != null ? upiValidation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UpiData {" +
				"upiRecord=" + this.upiRecord + ", " +
				"upiOfUnderlying=" + this.upiOfUnderlying + ", " +
				"upiValidation=" + this.upiValidation +
			'}';
		}
	}

	/*********************** Builder Implementation of UpiData  ***********************/
	class UpiDataBuilderImpl implements UpiData.UpiDataBuilder {
	
		protected AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder upiRecord;
		protected Boolean upiOfUnderlying;
		protected Boolean upiValidation;
		
		@Override
		@RosettaAttribute("upiRecord")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upiRecord")
		public AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder getUpiRecord() {
			return upiRecord;
		}
		
		@Override
		public AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder getOrCreateUpiRecord() {
			AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder result;
			if (upiRecord!=null) {
				result = upiRecord;
			}
			else {
				result = upiRecord = AnnaDsbUpiRecord.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("upiOfUnderlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upiOfUnderlying")
		public Boolean getUpiOfUnderlying() {
			return upiOfUnderlying;
		}
		
		@Override
		@RosettaAttribute("upiValidation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upiValidation")
		public Boolean getUpiValidation() {
			return upiValidation;
		}
		
		@RosettaAttribute("upiRecord")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("upiRecord")
		@Override
		public UpiData.UpiDataBuilder setUpiRecord(AnnaDsbUpiRecord _upiRecord) {
			this.upiRecord = _upiRecord == null ? null : _upiRecord.toBuilder();
			return this;
		}
		
		@RosettaAttribute("upiOfUnderlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("upiOfUnderlying")
		@Override
		public UpiData.UpiDataBuilder setUpiOfUnderlying(Boolean _upiOfUnderlying) {
			this.upiOfUnderlying = _upiOfUnderlying == null ? null : _upiOfUnderlying;
			return this;
		}
		
		@RosettaAttribute("upiValidation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("upiValidation")
		@Override
		public UpiData.UpiDataBuilder setUpiValidation(Boolean _upiValidation) {
			this.upiValidation = _upiValidation == null ? null : _upiValidation;
			return this;
		}
		
		@Override
		public UpiData build() {
			return new UpiData.UpiDataImpl(this);
		}
		
		@Override
		public UpiData.UpiDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UpiData.UpiDataBuilder prune() {
			if (upiRecord!=null && !upiRecord.prune().hasData()) upiRecord = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUpiRecord()!=null && getUpiRecord().hasData()) return true;
			if (getUpiOfUnderlying()!=null) return true;
			if (getUpiValidation()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UpiData.UpiDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UpiData.UpiDataBuilder o = (UpiData.UpiDataBuilder) other;
			
			merger.mergeRosetta(getUpiRecord(), o.getUpiRecord(), this::setUpiRecord);
			
			merger.mergeBasic(getUpiOfUnderlying(), o.getUpiOfUnderlying(), this::setUpiOfUnderlying);
			merger.mergeBasic(getUpiValidation(), o.getUpiValidation(), this::setUpiValidation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UpiData _that = getType().cast(o);
		
			if (!Objects.equals(upiRecord, _that.getUpiRecord())) return false;
			if (!Objects.equals(upiOfUnderlying, _that.getUpiOfUnderlying())) return false;
			if (!Objects.equals(upiValidation, _that.getUpiValidation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (upiRecord != null ? upiRecord.hashCode() : 0);
			_result = 31 * _result + (upiOfUnderlying != null ? upiOfUnderlying.hashCode() : 0);
			_result = 31 * _result + (upiValidation != null ? upiValidation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UpiDataBuilder {" +
				"upiRecord=" + this.upiRecord + ", " +
				"upiOfUnderlying=" + this.upiOfUnderlying + ", " +
				"upiValidation=" + this.upiValidation +
			'}';
		}
	}
}
