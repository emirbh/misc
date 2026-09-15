package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fx.accruals.meta.FxExpiryDateMeta;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.BusinessDayAdjustments;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Defines the expiry date of the accrual. The date is adjusted, date adjustments may be provided, and also the expiry time.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines the expiry date of the accrual. The date is adjusted, date adjustments may be provided, and also the expiry time.
 *
 */
@RosettaDataType(value="FxExpiryDate", builder=FxExpiryDate.FxExpiryDateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxExpiryDate", model="fpml", builder=FxExpiryDate.FxExpiryDateBuilderImpl.class, version="2.1.1")
public interface FxExpiryDate extends FxAdjustedDateAndDateAdjustments {

	FxExpiryDateMeta metaData = new FxExpiryDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Time of expiration of each expiry date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Time of expiration of each expiry date.
	 *
	 */
	BusinessCenterTime getExpiryTime();

	/*********************** Build Methods  ***********************/
	FxExpiryDate build();
	
	FxExpiryDate.FxExpiryDateBuilder toBuilder();
	
	static FxExpiryDate.FxExpiryDateBuilder builder() {
		return new FxExpiryDate.FxExpiryDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxExpiryDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxExpiryDate> getType() {
		return FxExpiryDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processor.processBasic(path.newSubPath("adjustedDate"), ZonedDateTime.class, getAdjustedDate(), this);
		processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.class, getExpiryTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxExpiryDateBuilder extends FxExpiryDate, FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpiryTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getExpiryTime();
		@Override
		FxExpiryDate.FxExpiryDateBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		@Override
		FxExpiryDate.FxExpiryDateBuilder setAdjustedDate(ZonedDateTime adjustedDate);
		FxExpiryDate.FxExpiryDateBuilder setExpiryTime(BusinessCenterTime expiryTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processor.processBasic(path.newSubPath("adjustedDate"), ZonedDateTime.class, getAdjustedDate(), this);
			processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpiryTime());
		}
		

		FxExpiryDate.FxExpiryDateBuilder prune();
	}

	/*********************** Immutable Implementation of FxExpiryDate  ***********************/
	class FxExpiryDateImpl extends FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsImpl implements FxExpiryDate {
		private final BusinessCenterTime expiryTime;
		
		protected FxExpiryDateImpl(FxExpiryDate.FxExpiryDateBuilder builder) {
			super(builder);
			this.expiryTime = ofNullable(builder.getExpiryTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("expiryTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryTime")
		public BusinessCenterTime getExpiryTime() {
			return expiryTime;
		}
		
		@Override
		public FxExpiryDate build() {
			return this;
		}
		
		@Override
		public FxExpiryDate.FxExpiryDateBuilder toBuilder() {
			FxExpiryDate.FxExpiryDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxExpiryDate.FxExpiryDateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpiryTime()).ifPresent(builder::setExpiryTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxExpiryDate _that = getType().cast(o);
		
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxExpiryDate {" +
				"expiryTime=" + this.expiryTime +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxExpiryDate  ***********************/
	class FxExpiryDateBuilderImpl extends FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilderImpl implements FxExpiryDate.FxExpiryDateBuilder {
	
		protected BusinessCenterTime.BusinessCenterTimeBuilder expiryTime;
		
		@Override
		@RosettaAttribute("expiryTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getExpiryTime() {
			return expiryTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpiryTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (expiryTime!=null) {
				result = expiryTime;
			}
			else {
				result = expiryTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateAdjustments")
		@Override
		public FxExpiryDate.FxExpiryDateBuilder setDateAdjustments(BusinessDayAdjustments _dateAdjustments) {
			this.dateAdjustments = _dateAdjustments == null ? null : _dateAdjustments.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("adjustedDate")
		@Override
		public FxExpiryDate.FxExpiryDateBuilder setAdjustedDate(ZonedDateTime _adjustedDate) {
			this.adjustedDate = _adjustedDate == null ? null : _adjustedDate;
			return this;
		}
		
		@RosettaAttribute("expiryTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryTime")
		@Override
		public FxExpiryDate.FxExpiryDateBuilder setExpiryTime(BusinessCenterTime _expiryTime) {
			this.expiryTime = _expiryTime == null ? null : _expiryTime.toBuilder();
			return this;
		}
		
		@Override
		public FxExpiryDate build() {
			return new FxExpiryDate.FxExpiryDateImpl(this);
		}
		
		@Override
		public FxExpiryDate.FxExpiryDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxExpiryDate.FxExpiryDateBuilder prune() {
			super.prune();
			if (expiryTime!=null && !expiryTime.prune().hasData()) expiryTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpiryTime()!=null && getExpiryTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxExpiryDate.FxExpiryDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxExpiryDate.FxExpiryDateBuilder o = (FxExpiryDate.FxExpiryDateBuilder) other;
			
			merger.mergeRosetta(getExpiryTime(), o.getExpiryTime(), this::setExpiryTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxExpiryDate _that = getType().cast(o);
		
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxExpiryDateBuilder {" +
				"expiryTime=" + this.expiryTime +
			'}' + " " + super.toString();
		}
	}
}
