package fpml.consolidated.fx.targets;

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
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fx.targets.meta.FxExpiryScheduleMeta;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.ObservationFrequency;
import java.time.ZonedDateTime;
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
 * version "recordkeeping-5.13"
 *
 * Provision Defines the expiry/observation schedule of the target.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines the expiry/observation schedule of the target.
 *
 */
@RosettaDataType(value="FxExpirySchedule", builder=FxExpirySchedule.FxExpiryScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxExpirySchedule", model="fpml", builder=FxExpirySchedule.FxExpiryScheduleBuilderImpl.class, version="2.1.1")
public interface FxExpirySchedule extends FxSchedule {

	FxExpiryScheduleMeta metaData = new FxExpiryScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The final expiry date facilitates informing the final date without having to process all expiry dates in the schedule.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The final expiry date facilitates informing the final date without having to process all expiry dates in the schedule.
	 *
	 */
	ZonedDateTime getFinalExpiryDate();
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
	FxExpirySchedule build();
	
	FxExpirySchedule.FxExpiryScheduleBuilder toBuilder();
	
	static FxExpirySchedule.FxExpiryScheduleBuilder builder() {
		return new FxExpirySchedule.FxExpiryScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxExpirySchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxExpirySchedule> getType() {
		return FxExpirySchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processor.processBasic(path.newSubPath("adjustedDate"), ZonedDateTime.class, getAdjustedDate(), this);
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processRosetta(path.newSubPath("observationFrequency"), processor, ObservationFrequency.class, getObservationFrequency());
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.class, getBusinessCentersReference());
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
		processRosetta(path.newSubPath("dateOffset"), processor, FxDateOffset.class, getDateOffset());
		processor.processBasic(path.newSubPath("finalExpiryDate"), ZonedDateTime.class, getFinalExpiryDate(), this);
		processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.class, getExpiryTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxExpiryScheduleBuilder extends FxExpirySchedule, FxSchedule.FxScheduleBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpiryTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getExpiryTime();
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder setId(String id);
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder addAdjustedDate(ZonedDateTime adjustedDate);
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder addAdjustedDate(ZonedDateTime adjustedDate, int idx);
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder addAdjustedDate(List<ZonedDateTime> adjustedDate);
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder setAdjustedDate(List<ZonedDateTime> adjustedDate);
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder setStartDate(ZonedDateTime startDate);
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder setEndDate(ZonedDateTime endDate);
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder setObservationFrequency(ObservationFrequency observationFrequency);
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder setDayType(DayTypeEnum dayType);
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder setBusinessCentersReference(BusinessCentersReference businessCentersReference);
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder setBusinessCenters(BusinessCenters businessCenters);
		@Override
		FxExpirySchedule.FxExpiryScheduleBuilder setDateOffset(FxDateOffset dateOffset);
		FxExpirySchedule.FxExpiryScheduleBuilder setFinalExpiryDate(ZonedDateTime finalExpiryDate);
		FxExpirySchedule.FxExpiryScheduleBuilder setExpiryTime(BusinessCenterTime expiryTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processor.processBasic(path.newSubPath("adjustedDate"), ZonedDateTime.class, getAdjustedDate(), this);
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processRosetta(path.newSubPath("observationFrequency"), processor, ObservationFrequency.ObservationFrequencyBuilder.class, getObservationFrequency());
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.BusinessCentersReferenceBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
			processRosetta(path.newSubPath("dateOffset"), processor, FxDateOffset.FxDateOffsetBuilder.class, getDateOffset());
			processor.processBasic(path.newSubPath("finalExpiryDate"), ZonedDateTime.class, getFinalExpiryDate(), this);
			processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpiryTime());
		}
		

		FxExpirySchedule.FxExpiryScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of FxExpirySchedule  ***********************/
	class FxExpiryScheduleImpl extends FxSchedule.FxScheduleImpl implements FxExpirySchedule {
		private final ZonedDateTime finalExpiryDate;
		private final BusinessCenterTime expiryTime;
		
		protected FxExpiryScheduleImpl(FxExpirySchedule.FxExpiryScheduleBuilder builder) {
			super(builder);
			this.finalExpiryDate = builder.getFinalExpiryDate();
			this.expiryTime = ofNullable(builder.getExpiryTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("finalExpiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalExpiryDate")
		public ZonedDateTime getFinalExpiryDate() {
			return finalExpiryDate;
		}
		
		@Override
		@RosettaAttribute("expiryTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryTime")
		public BusinessCenterTime getExpiryTime() {
			return expiryTime;
		}
		
		@Override
		public FxExpirySchedule build() {
			return this;
		}
		
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder toBuilder() {
			FxExpirySchedule.FxExpiryScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxExpirySchedule.FxExpiryScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFinalExpiryDate()).ifPresent(builder::setFinalExpiryDate);
			ofNullable(getExpiryTime()).ifPresent(builder::setExpiryTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxExpirySchedule _that = getType().cast(o);
		
			if (!Objects.equals(finalExpiryDate, _that.getFinalExpiryDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (finalExpiryDate != null ? finalExpiryDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxExpirySchedule {" +
				"finalExpiryDate=" + this.finalExpiryDate + ", " +
				"expiryTime=" + this.expiryTime +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxExpirySchedule  ***********************/
	class FxExpiryScheduleBuilderImpl extends FxSchedule.FxScheduleBuilderImpl implements FxExpirySchedule.FxExpiryScheduleBuilder {
	
		protected ZonedDateTime finalExpiryDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expiryTime;
		
		@Override
		@RosettaAttribute("finalExpiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalExpiryDate")
		public ZonedDateTime getFinalExpiryDate() {
			return finalExpiryDate;
		}
		
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateAdjustments")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder setDateAdjustments(BusinessDayAdjustments _dateAdjustments) {
			this.dateAdjustments = _dateAdjustments == null ? null : _dateAdjustments.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("adjustedDate")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder addAdjustedDate(ZonedDateTime _adjustedDate) {
			if (_adjustedDate != null) {
				this.adjustedDate.add(_adjustedDate);
			}
			return this;
		}
		
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder addAdjustedDate(ZonedDateTime _adjustedDate, int idx) {
			getIndex(this.adjustedDate, idx, () -> _adjustedDate);
			return this;
		}
		
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder addAdjustedDate(List<ZonedDateTime> adjustedDates) {
			if (adjustedDates != null) {
				for (final ZonedDateTime toAdd : adjustedDates) {
					this.adjustedDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("adjustedDate")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder setAdjustedDate(List<ZonedDateTime> adjustedDates) {
			if (adjustedDates == null) {
				this.adjustedDate = new ArrayList<>();
			} else {
				this.adjustedDate = adjustedDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("startDate")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("observationFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationFrequency")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder setObservationFrequency(ObservationFrequency _observationFrequency) {
			this.observationFrequency = _observationFrequency == null ? null : _observationFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayType")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder setDayType(DayTypeEnum _dayType) {
			this.dayType = _dayType == null ? null : _dayType;
			return this;
		}
		
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCentersReference")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder setBusinessCentersReference(BusinessCentersReference _businessCentersReference) {
			this.businessCentersReference = _businessCentersReference == null ? null : _businessCentersReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenters")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dateOffset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateOffset")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder setDateOffset(FxDateOffset _dateOffset) {
			this.dateOffset = _dateOffset == null ? null : _dateOffset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("finalExpiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalExpiryDate")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder setFinalExpiryDate(ZonedDateTime _finalExpiryDate) {
			this.finalExpiryDate = _finalExpiryDate == null ? null : _finalExpiryDate;
			return this;
		}
		
		@RosettaAttribute("expiryTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryTime")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder setExpiryTime(BusinessCenterTime _expiryTime) {
			this.expiryTime = _expiryTime == null ? null : _expiryTime.toBuilder();
			return this;
		}
		
		@Override
		public FxExpirySchedule build() {
			return new FxExpirySchedule.FxExpiryScheduleImpl(this);
		}
		
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder prune() {
			super.prune();
			if (expiryTime!=null && !expiryTime.prune().hasData()) expiryTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFinalExpiryDate()!=null) return true;
			if (getExpiryTime()!=null && getExpiryTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxExpirySchedule.FxExpiryScheduleBuilder o = (FxExpirySchedule.FxExpiryScheduleBuilder) other;
			
			merger.mergeRosetta(getExpiryTime(), o.getExpiryTime(), this::setExpiryTime);
			
			merger.mergeBasic(getFinalExpiryDate(), o.getFinalExpiryDate(), this::setFinalExpiryDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxExpirySchedule _that = getType().cast(o);
		
			if (!Objects.equals(finalExpiryDate, _that.getFinalExpiryDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (finalExpiryDate != null ? finalExpiryDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxExpiryScheduleBuilder {" +
				"finalExpiryDate=" + this.finalExpiryDate + ", " +
				"expiryTime=" + this.expiryTime +
			'}' + " " + super.toString();
		}
	}
}
