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
import fpml.consolidated.fx.targets.meta.FxSettlementScheduleMeta;
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
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="FxSettlementSchedule", builder=FxSettlementSchedule.FxSettlementScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxSettlementSchedule", model="fpml", builder=FxSettlementSchedule.FxSettlementScheduleBuilderImpl.class, version="2.1.1")
public interface FxSettlementSchedule extends FxSchedule {

	FxSettlementScheduleMeta metaData = new FxSettlementScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The final settlement date facilitates informing the final date without having to process all settlement dates in the schedule.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The final settlement date facilitates informing the final date without having to process all settlement dates in the schedule.
	 *
	 */
	ZonedDateTime getFinalSettlementDate();

	/*********************** Build Methods  ***********************/
	FxSettlementSchedule build();
	
	FxSettlementSchedule.FxSettlementScheduleBuilder toBuilder();
	
	static FxSettlementSchedule.FxSettlementScheduleBuilder builder() {
		return new FxSettlementSchedule.FxSettlementScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxSettlementSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxSettlementSchedule> getType() {
		return FxSettlementSchedule.class;
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
		processor.processBasic(path.newSubPath("finalSettlementDate"), ZonedDateTime.class, getFinalSettlementDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxSettlementScheduleBuilder extends FxSettlementSchedule, FxSchedule.FxScheduleBuilder {
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder setId(String id);
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder addAdjustedDate(ZonedDateTime adjustedDate);
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder addAdjustedDate(ZonedDateTime adjustedDate, int idx);
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder addAdjustedDate(List<ZonedDateTime> adjustedDate);
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder setAdjustedDate(List<ZonedDateTime> adjustedDate);
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder setStartDate(ZonedDateTime startDate);
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder setEndDate(ZonedDateTime endDate);
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder setObservationFrequency(ObservationFrequency observationFrequency);
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder setDayType(DayTypeEnum dayType);
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder setBusinessCentersReference(BusinessCentersReference businessCentersReference);
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder setBusinessCenters(BusinessCenters businessCenters);
		@Override
		FxSettlementSchedule.FxSettlementScheduleBuilder setDateOffset(FxDateOffset dateOffset);
		FxSettlementSchedule.FxSettlementScheduleBuilder setFinalSettlementDate(ZonedDateTime finalSettlementDate);

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
			processor.processBasic(path.newSubPath("finalSettlementDate"), ZonedDateTime.class, getFinalSettlementDate(), this);
		}
		

		FxSettlementSchedule.FxSettlementScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of FxSettlementSchedule  ***********************/
	class FxSettlementScheduleImpl extends FxSchedule.FxScheduleImpl implements FxSettlementSchedule {
		private final ZonedDateTime finalSettlementDate;
		
		protected FxSettlementScheduleImpl(FxSettlementSchedule.FxSettlementScheduleBuilder builder) {
			super(builder);
			this.finalSettlementDate = builder.getFinalSettlementDate();
		}
		
		@Override
		@RosettaAttribute("finalSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalSettlementDate")
		public ZonedDateTime getFinalSettlementDate() {
			return finalSettlementDate;
		}
		
		@Override
		public FxSettlementSchedule build() {
			return this;
		}
		
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder toBuilder() {
			FxSettlementSchedule.FxSettlementScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSettlementSchedule.FxSettlementScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFinalSettlementDate()).ifPresent(builder::setFinalSettlementDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxSettlementSchedule _that = getType().cast(o);
		
			if (!Objects.equals(finalSettlementDate, _that.getFinalSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (finalSettlementDate != null ? finalSettlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSettlementSchedule {" +
				"finalSettlementDate=" + this.finalSettlementDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxSettlementSchedule  ***********************/
	class FxSettlementScheduleBuilderImpl extends FxSchedule.FxScheduleBuilderImpl implements FxSettlementSchedule.FxSettlementScheduleBuilder {
	
		protected ZonedDateTime finalSettlementDate;
		
		@Override
		@RosettaAttribute("finalSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalSettlementDate")
		public ZonedDateTime getFinalSettlementDate() {
			return finalSettlementDate;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateAdjustments")
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder setDateAdjustments(BusinessDayAdjustments _dateAdjustments) {
			this.dateAdjustments = _dateAdjustments == null ? null : _dateAdjustments.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("adjustedDate")
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder addAdjustedDate(ZonedDateTime _adjustedDate) {
			if (_adjustedDate != null) {
				this.adjustedDate.add(_adjustedDate);
			}
			return this;
		}
		
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder addAdjustedDate(ZonedDateTime _adjustedDate, int idx) {
			getIndex(this.adjustedDate, idx, () -> _adjustedDate);
			return this;
		}
		
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder addAdjustedDate(List<ZonedDateTime> adjustedDates) {
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
		public FxSettlementSchedule.FxSettlementScheduleBuilder setAdjustedDate(List<ZonedDateTime> adjustedDates) {
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
		public FxSettlementSchedule.FxSettlementScheduleBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("observationFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationFrequency")
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder setObservationFrequency(ObservationFrequency _observationFrequency) {
			this.observationFrequency = _observationFrequency == null ? null : _observationFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayType")
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder setDayType(DayTypeEnum _dayType) {
			this.dayType = _dayType == null ? null : _dayType;
			return this;
		}
		
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCentersReference")
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder setBusinessCentersReference(BusinessCentersReference _businessCentersReference) {
			this.businessCentersReference = _businessCentersReference == null ? null : _businessCentersReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenters")
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dateOffset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateOffset")
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder setDateOffset(FxDateOffset _dateOffset) {
			this.dateOffset = _dateOffset == null ? null : _dateOffset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("finalSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalSettlementDate")
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder setFinalSettlementDate(ZonedDateTime _finalSettlementDate) {
			this.finalSettlementDate = _finalSettlementDate == null ? null : _finalSettlementDate;
			return this;
		}
		
		@Override
		public FxSettlementSchedule build() {
			return new FxSettlementSchedule.FxSettlementScheduleImpl(this);
		}
		
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFinalSettlementDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxSettlementSchedule.FxSettlementScheduleBuilder o = (FxSettlementSchedule.FxSettlementScheduleBuilder) other;
			
			
			merger.mergeBasic(getFinalSettlementDate(), o.getFinalSettlementDate(), this::setFinalSettlementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxSettlementSchedule _that = getType().cast(o);
		
			if (!Objects.equals(finalSettlementDate, _that.getFinalSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (finalSettlementDate != null ? finalSettlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSettlementScheduleBuilder {" +
				"finalSettlementDate=" + this.finalSettlementDate +
			'}' + " " + super.toString();
		}
	}
}
