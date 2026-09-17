package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fx.accruals.meta.FxFixingScheduleMeta;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.BusinessCentersReference;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.ObservationFrequency;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Describes a schedule of fixing dates as a parametric description, an explicit list of dates or both.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes a schedule of fixing dates as a parametric description, an explicit list of dates or both.
 *
 */
@RosettaDataType(value="FxFixingSchedule", builder=FxFixingSchedule.FxFixingScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxFixingSchedule", model="fpml", builder=FxFixingSchedule.FxFixingScheduleBuilderImpl.class, version="2.1.1")
public interface FxFixingSchedule extends RosettaModelObject {

	FxFixingScheduleMeta metaData = new FxFixingScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Date adjustments applied to the adjusted dates including the business day convention and the business centers.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date adjustments applied to the adjusted dates including the business day convention and the business centers.
	 *
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision List of schedule dates. These dates have been subject to adjustments based on the dateAdjustments structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision List of schedule dates. These dates have been subject to adjustments based on the dateAdjustments structure.
	 *
	 */
	List<ZonedDateTime> getFixingDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Start of the schedule.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Start of the schedule.
	 *
	 */
	ZonedDateTime getStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision End of the schedule.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision End of the schedule.
	 *
	 */
	ZonedDateTime getEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the frequency at which calculation period end dates occur within the period schedule and their roll date convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the frequency at which calculation period end dates occur within the period schedule and their roll date convention.
	 *
	 */
	ObservationFrequency getObservationFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A day type classification, e.g. Business, Calendar, etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A day type classification, e.g. Business, Calendar, etc.
	 *
	 */
	DayTypeEnum getDayType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
	 *
	 */
	BusinessCentersReference getBusinessCentersReference();
	/**
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
	BusinessCenters getBusinessCenters();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The number of fixing points in the fixing schedule.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The number of fixing points in the fixing schedule.
	 *
	 */
	Integer getNumberOfFixings();

	/*********************** Build Methods  ***********************/
	FxFixingSchedule build();
	
	FxFixingSchedule.FxFixingScheduleBuilder toBuilder();
	
	static FxFixingSchedule.FxFixingScheduleBuilder builder() {
		return new FxFixingSchedule.FxFixingScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFixingSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxFixingSchedule> getType() {
		return FxFixingSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processRosetta(path.newSubPath("observationFrequency"), processor, ObservationFrequency.class, getObservationFrequency());
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.class, getBusinessCentersReference());
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
		processor.processBasic(path.newSubPath("numberOfFixings"), Integer.class, getNumberOfFixings(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFixingScheduleBuilder extends FxFixingSchedule, RosettaModelObjectBuilder {
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		@Override
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		ObservationFrequency.ObservationFrequencyBuilder getOrCreateObservationFrequency();
		@Override
		ObservationFrequency.ObservationFrequencyBuilder getObservationFrequency();
		BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference();
		@Override
		BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference();
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		@Override
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		FxFixingSchedule.FxFixingScheduleBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		FxFixingSchedule.FxFixingScheduleBuilder addFixingDate(ZonedDateTime fixingDate);
		FxFixingSchedule.FxFixingScheduleBuilder addFixingDate(ZonedDateTime fixingDate, int idx);
		FxFixingSchedule.FxFixingScheduleBuilder addFixingDate(List<ZonedDateTime> fixingDate);
		FxFixingSchedule.FxFixingScheduleBuilder setFixingDate(List<ZonedDateTime> fixingDate);
		FxFixingSchedule.FxFixingScheduleBuilder setStartDate(ZonedDateTime startDate);
		FxFixingSchedule.FxFixingScheduleBuilder setEndDate(ZonedDateTime endDate);
		FxFixingSchedule.FxFixingScheduleBuilder setObservationFrequency(ObservationFrequency observationFrequency);
		FxFixingSchedule.FxFixingScheduleBuilder setDayType(DayTypeEnum dayType);
		FxFixingSchedule.FxFixingScheduleBuilder setBusinessCentersReference(BusinessCentersReference businessCentersReference);
		FxFixingSchedule.FxFixingScheduleBuilder setBusinessCenters(BusinessCenters businessCenters);
		FxFixingSchedule.FxFixingScheduleBuilder setNumberOfFixings(Integer numberOfFixings);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processRosetta(path.newSubPath("observationFrequency"), processor, ObservationFrequency.ObservationFrequencyBuilder.class, getObservationFrequency());
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.BusinessCentersReferenceBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
			processor.processBasic(path.newSubPath("numberOfFixings"), Integer.class, getNumberOfFixings(), this);
		}
		

		FxFixingSchedule.FxFixingScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of FxFixingSchedule  ***********************/
	class FxFixingScheduleImpl implements FxFixingSchedule {
		private final BusinessDayAdjustments dateAdjustments;
		private final List<ZonedDateTime> fixingDate;
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final ObservationFrequency observationFrequency;
		private final DayTypeEnum dayType;
		private final BusinessCentersReference businessCentersReference;
		private final BusinessCenters businessCenters;
		private final Integer numberOfFixings;
		
		protected FxFixingScheduleImpl(FxFixingSchedule.FxFixingScheduleBuilder builder) {
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.fixingDate = ofNullable(builder.getFixingDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.observationFrequency = ofNullable(builder.getObservationFrequency()).map(f->f.build()).orElse(null);
			this.dayType = builder.getDayType();
			this.businessCentersReference = ofNullable(builder.getBusinessCentersReference()).map(f->f.build()).orElse(null);
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
			this.numberOfFixings = builder.getNumberOfFixings();
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixingDate")
		public List<ZonedDateTime> getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("observationFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationFrequency")
		public ObservationFrequency getObservationFrequency() {
			return observationFrequency;
		}
		
		@Override
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayType")
		public DayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCentersReference")
		public BusinessCentersReference getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenters")
		public BusinessCenters getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		@RosettaAttribute("numberOfFixings")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfFixings")
		public Integer getNumberOfFixings() {
			return numberOfFixings;
		}
		
		@Override
		public FxFixingSchedule build() {
			return this;
		}
		
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder toBuilder() {
			FxFixingSchedule.FxFixingScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFixingSchedule.FxFixingScheduleBuilder builder) {
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getObservationFrequency()).ifPresent(builder::setObservationFrequency);
			ofNullable(getDayType()).ifPresent(builder::setDayType);
			ofNullable(getBusinessCentersReference()).ifPresent(builder::setBusinessCentersReference);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
			ofNullable(getNumberOfFixings()).ifPresent(builder::setNumberOfFixings);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingSchedule _that = getType().cast(o);
		
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!ListEquals.listEquals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(observationFrequency, _that.getObservationFrequency())) return false;
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(numberOfFixings, _that.getNumberOfFixings())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (observationFrequency != null ? observationFrequency.hashCode() : 0);
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (numberOfFixings != null ? numberOfFixings.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingSchedule {" +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"observationFrequency=" + this.observationFrequency + ", " +
				"dayType=" + this.dayType + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"numberOfFixings=" + this.numberOfFixings +
			'}';
		}
	}

	/*********************** Builder Implementation of FxFixingSchedule  ***********************/
	class FxFixingScheduleBuilderImpl implements FxFixingSchedule.FxFixingScheduleBuilder {
	
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected List<ZonedDateTime> fixingDate = new ArrayList<>();
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected ObservationFrequency.ObservationFrequencyBuilder observationFrequency;
		protected DayTypeEnum dayType;
		protected BusinessCentersReference.BusinessCentersReferenceBuilder businessCentersReference;
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		protected Integer numberOfFixings;
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (dateAdjustments!=null) {
				result = dateAdjustments;
			}
			else {
				result = dateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixingDate")
		public List<ZonedDateTime> getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("observationFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationFrequency")
		public ObservationFrequency.ObservationFrequencyBuilder getObservationFrequency() {
			return observationFrequency;
		}
		
		@Override
		public ObservationFrequency.ObservationFrequencyBuilder getOrCreateObservationFrequency() {
			ObservationFrequency.ObservationFrequencyBuilder result;
			if (observationFrequency!=null) {
				result = observationFrequency;
			}
			else {
				result = observationFrequency = ObservationFrequency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayType")
		public DayTypeEnum getDayType() {
			return dayType;
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCentersReference")
		public BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		public BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference() {
			BusinessCentersReference.BusinessCentersReferenceBuilder result;
			if (businessCentersReference!=null) {
				result = businessCentersReference;
			}
			else {
				result = businessCentersReference = BusinessCentersReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenters")
		public BusinessCenters.BusinessCentersBuilder getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters() {
			BusinessCenters.BusinessCentersBuilder result;
			if (businessCenters!=null) {
				result = businessCenters;
			}
			else {
				result = businessCenters = BusinessCenters.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfFixings")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfFixings")
		public Integer getNumberOfFixings() {
			return numberOfFixings;
		}
		
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateAdjustments")
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder setDateAdjustments(BusinessDayAdjustments _dateAdjustments) {
			this.dateAdjustments = _dateAdjustments == null ? null : _dateAdjustments.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fixingDate")
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder addFixingDate(ZonedDateTime _fixingDate) {
			if (_fixingDate != null) {
				this.fixingDate.add(_fixingDate);
			}
			return this;
		}
		
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder addFixingDate(ZonedDateTime _fixingDate, int idx) {
			getIndex(this.fixingDate, idx, () -> _fixingDate);
			return this;
		}
		
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder addFixingDate(List<ZonedDateTime> fixingDates) {
			if (fixingDates != null) {
				for (final ZonedDateTime toAdd : fixingDates) {
					this.fixingDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fixingDate")
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder setFixingDate(List<ZonedDateTime> fixingDates) {
			if (fixingDates == null) {
				this.fixingDate = new ArrayList<>();
			} else {
				this.fixingDate = fixingDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("startDate")
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("observationFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationFrequency")
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder setObservationFrequency(ObservationFrequency _observationFrequency) {
			this.observationFrequency = _observationFrequency == null ? null : _observationFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayType")
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder setDayType(DayTypeEnum _dayType) {
			this.dayType = _dayType == null ? null : _dayType;
			return this;
		}
		
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCentersReference")
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder setBusinessCentersReference(BusinessCentersReference _businessCentersReference) {
			this.businessCentersReference = _businessCentersReference == null ? null : _businessCentersReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenters")
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@RosettaAttribute("numberOfFixings")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfFixings")
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder setNumberOfFixings(Integer _numberOfFixings) {
			this.numberOfFixings = _numberOfFixings == null ? null : _numberOfFixings;
			return this;
		}
		
		@Override
		public FxFixingSchedule build() {
			return new FxFixingSchedule.FxFixingScheduleImpl(this);
		}
		
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder prune() {
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			if (observationFrequency!=null && !observationFrequency.prune().hasData()) observationFrequency = null;
			if (businessCentersReference!=null && !businessCentersReference.prune().hasData()) businessCentersReference = null;
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getFixingDate()!=null && !getFixingDate().isEmpty()) return true;
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getObservationFrequency()!=null && getObservationFrequency().hasData()) return true;
			if (getDayType()!=null) return true;
			if (getBusinessCentersReference()!=null && getBusinessCentersReference().hasData()) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			if (getNumberOfFixings()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxFixingSchedule.FxFixingScheduleBuilder o = (FxFixingSchedule.FxFixingScheduleBuilder) other;
			
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getObservationFrequency(), o.getObservationFrequency(), this::setObservationFrequency);
			merger.mergeRosetta(getBusinessCentersReference(), o.getBusinessCentersReference(), this::setBusinessCentersReference);
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), (Consumer<ZonedDateTime>) this::addFixingDate);
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getDayType(), o.getDayType(), this::setDayType);
			merger.mergeBasic(getNumberOfFixings(), o.getNumberOfFixings(), this::setNumberOfFixings);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingSchedule _that = getType().cast(o);
		
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!ListEquals.listEquals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(observationFrequency, _that.getObservationFrequency())) return false;
			if (!Objects.equals(dayType, _that.getDayType())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			if (!Objects.equals(numberOfFixings, _that.getNumberOfFixings())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (observationFrequency != null ? observationFrequency.hashCode() : 0);
			_result = 31 * _result + (dayType != null ? dayType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			_result = 31 * _result + (numberOfFixings != null ? numberOfFixings.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingScheduleBuilder {" +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"fixingDate=" + this.fixingDate + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"observationFrequency=" + this.observationFrequency + ", " +
				"dayType=" + this.dayType + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters + ", " +
				"numberOfFixings=" + this.numberOfFixings +
			'}';
		}
	}
}
