package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.BermudaExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the Bermuda option exercise dates and the expiration date together with any rules govenerning the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fee.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the Bermuda option exercise dates and the expiration date together with any rules govenerning the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fee.
 *
 */
@RosettaDataType(value="BermudaExercise", builder=BermudaExercise.BermudaExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BermudaExercise", model="fpml", builder=BermudaExercise.BermudaExerciseBuilderImpl.class, version="2.1.1")
public interface BermudaExercise extends Exercise {

	BermudaExerciseMeta metaData = new BermudaExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The dates the define the Bermuda option exercise dates and the expiration date. The last specified date is assumed to be the expiration date. The dates can either be specified as a series of explicit dates and associated adjustments or as a series of dates defined relative to another schedule of dates, for example, the calculation period start dates. Where a relative series of dates are defined the first and last possible exercise dates can be separately specified.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The dates the define the Bermuda option exercise dates and the expiration date. The last specified date is assumed to be the expiration date. The dates can either be specified as a series of explicit dates and associated adjustments or as a series of dates defined relative to another schedule of dates, for example, the calculation period start dates. Where a relative series of dates are defined the first and last possible exercise dates can be separately specified.
	 *
	 */
	AdjustableOrRelativeDates getBermudaExerciseDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on the underlying set by the exercise of an option. What this date is depends on the option (e.g. in a swaption it is the swap effective date, in an extendible/cancelable provision it is the swap termination date).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on the underlying set by the exercise of an option. What this date is depends on the option (e.g. in a swaption it is the swap effective date, in an extendible/cancelable provision it is the swap termination date).
	 *
	 */
	AdjustableOrRelativeDates getRelevantUnderlyingDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The earliest time at which notice of exercise can be given by the buyer to the seller (or seller's agent) i) on the expriation date, in the case of a European style option, (ii) on each bermuda option exercise date and the expiration date, in the case of a Bermuda style option the commencement date to, and including, the expiration date , in the case of an American option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The earliest time at which notice of exercise can be given by the buyer to the seller (or seller's agent) i) on the expriation date, in the case of a European style option, (ii) on each bermuda option exercise date and the expiration date, in the case of a Bermuda style option the commencement date to, and including, the expiration date , in the case of an American option.
	 *
	 */
	BusinessCenterTime getEarliestExerciseTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For a Bermuda or American style option, the latest time on an exercise business day (excluding the expiration date) within the exercise period that notice can be given by the buyer to the seller or seller's agent. Notice of exercise given after this time will be deemed to have been given on the next exercise business day.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For a Bermuda or American style option, the latest time on an exercise business day (excluding the expiration date) within the exercise period that notice can be given by the buyer to the seller or seller's agent. Notice of exercise given after this time will be deemed to have been given on the next exercise business day.
	 *
	 */
	BusinessCenterTime getLatestExerciseTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The latest time for exercise on expirationDate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The latest time for exercise on expirationDate.
	 *
	 */
	BusinessCenterTime getExpirationTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision As defined in the 2000 ISDA Definitions, Section 12.4. Multiple Exercise, the buyer of the option has the right to exercise all or less than all the unexercised notional amount of the underlying swap on one or more days in the exercise period, but on any such day may not exercise less than the minimum notional amount or more that the maximum notional amount, and if an integral multiple amount is specified, the notional amount exercised must be equal to, or be an intergral multiple of, the integral multiple amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision As defined in the 2000 ISDA Definitions, Section 12.4. Multiple Exercise, the buyer of the option has the right to exercise all or less than all the unexercised notional amount of the underlying swap on one or more days in the exercise period, but on any such day may not exercise less than the minimum notional amount or more that the maximum notional amount, and if an integral multiple amount is specified, the notional amount exercised must be equal to, or be an intergral multiple of, the integral multiple amount.
	 *
	 */
	MultipleExercise getMultipleExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The fees associated with an exercise date. The fees are conditional on the exercise occuring. The fees can be specified as actual currency amounts or as percentages of the notional amount being exercised.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The fees associated with an exercise date. The fees are conditional on the exercise occuring. The fees can be specified as actual currency amounts or as percentages of the notional amount being exercised.
	 *
	 */
	ExerciseFeeSchedule getExerciseFeeSchedule();

	/*********************** Build Methods  ***********************/
	BermudaExercise build();
	
	BermudaExercise.BermudaExerciseBuilder toBuilder();
	
	static BermudaExercise.BermudaExerciseBuilder builder() {
		return new BermudaExercise.BermudaExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BermudaExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BermudaExercise> getType() {
		return BermudaExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("bermudaExerciseDates"), processor, AdjustableOrRelativeDates.class, getBermudaExerciseDates());
		processRosetta(path.newSubPath("relevantUnderlyingDate"), processor, AdjustableOrRelativeDates.class, getRelevantUnderlyingDate());
		processRosetta(path.newSubPath("earliestExerciseTime"), processor, BusinessCenterTime.class, getEarliestExerciseTime());
		processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.class, getLatestExerciseTime());
		processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.class, getExpirationTime());
		processRosetta(path.newSubPath("multipleExercise"), processor, MultipleExercise.class, getMultipleExercise());
		processRosetta(path.newSubPath("exerciseFeeSchedule"), processor, ExerciseFeeSchedule.class, getExerciseFeeSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BermudaExerciseBuilder extends BermudaExercise, Exercise.ExerciseBuilder {
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateBermudaExerciseDates();
		@Override
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getBermudaExerciseDates();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateRelevantUnderlyingDate();
		@Override
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getRelevantUnderlyingDate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestExerciseTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getEarliestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExerciseTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getLatestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpirationTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getExpirationTime();
		MultipleExercise.MultipleExerciseBuilder getOrCreateMultipleExercise();
		@Override
		MultipleExercise.MultipleExerciseBuilder getMultipleExercise();
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getOrCreateExerciseFeeSchedule();
		@Override
		ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getExerciseFeeSchedule();
		@Override
		BermudaExercise.BermudaExerciseBuilder setId(String id);
		BermudaExercise.BermudaExerciseBuilder setBermudaExerciseDates(AdjustableOrRelativeDates bermudaExerciseDates);
		BermudaExercise.BermudaExerciseBuilder setRelevantUnderlyingDate(AdjustableOrRelativeDates relevantUnderlyingDate);
		BermudaExercise.BermudaExerciseBuilder setEarliestExerciseTime(BusinessCenterTime earliestExerciseTime);
		BermudaExercise.BermudaExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime);
		BermudaExercise.BermudaExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime);
		BermudaExercise.BermudaExerciseBuilder setMultipleExercise(MultipleExercise multipleExercise);
		BermudaExercise.BermudaExerciseBuilder setExerciseFeeSchedule(ExerciseFeeSchedule exerciseFeeSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("bermudaExerciseDates"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getBermudaExerciseDates());
			processRosetta(path.newSubPath("relevantUnderlyingDate"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getRelevantUnderlyingDate());
			processRosetta(path.newSubPath("earliestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getEarliestExerciseTime());
			processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getLatestExerciseTime());
			processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpirationTime());
			processRosetta(path.newSubPath("multipleExercise"), processor, MultipleExercise.MultipleExerciseBuilder.class, getMultipleExercise());
			processRosetta(path.newSubPath("exerciseFeeSchedule"), processor, ExerciseFeeSchedule.ExerciseFeeScheduleBuilder.class, getExerciseFeeSchedule());
		}
		

		BermudaExercise.BermudaExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of BermudaExercise  ***********************/
	class BermudaExerciseImpl extends Exercise.ExerciseImpl implements BermudaExercise {
		private final AdjustableOrRelativeDates bermudaExerciseDates;
		private final AdjustableOrRelativeDates relevantUnderlyingDate;
		private final BusinessCenterTime earliestExerciseTime;
		private final BusinessCenterTime latestExerciseTime;
		private final BusinessCenterTime expirationTime;
		private final MultipleExercise multipleExercise;
		private final ExerciseFeeSchedule exerciseFeeSchedule;
		
		protected BermudaExerciseImpl(BermudaExercise.BermudaExerciseBuilder builder) {
			super(builder);
			this.bermudaExerciseDates = ofNullable(builder.getBermudaExerciseDates()).map(f->f.build()).orElse(null);
			this.relevantUnderlyingDate = ofNullable(builder.getRelevantUnderlyingDate()).map(f->f.build()).orElse(null);
			this.earliestExerciseTime = ofNullable(builder.getEarliestExerciseTime()).map(f->f.build()).orElse(null);
			this.latestExerciseTime = ofNullable(builder.getLatestExerciseTime()).map(f->f.build()).orElse(null);
			this.expirationTime = ofNullable(builder.getExpirationTime()).map(f->f.build()).orElse(null);
			this.multipleExercise = ofNullable(builder.getMultipleExercise()).map(f->f.build()).orElse(null);
			this.exerciseFeeSchedule = ofNullable(builder.getExerciseFeeSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("bermudaExerciseDates")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("bermudaExerciseDates")
		public AdjustableOrRelativeDates getBermudaExerciseDates() {
			return bermudaExerciseDates;
		}
		
		@Override
		@RosettaAttribute("relevantUnderlyingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relevantUnderlyingDate")
		public AdjustableOrRelativeDates getRelevantUnderlyingDate() {
			return relevantUnderlyingDate;
		}
		
		@Override
		@RosettaAttribute("earliestExerciseTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earliestExerciseTime")
		public BusinessCenterTime getEarliestExerciseTime() {
			return earliestExerciseTime;
		}
		
		@Override
		@RosettaAttribute("latestExerciseTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("latestExerciseTime")
		public BusinessCenterTime getLatestExerciseTime() {
			return latestExerciseTime;
		}
		
		@Override
		@RosettaAttribute("expirationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationTime")
		public BusinessCenterTime getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		@RosettaAttribute("multipleExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multipleExercise")
		public MultipleExercise getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		@RosettaAttribute("exerciseFeeSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseFeeSchedule")
		public ExerciseFeeSchedule getExerciseFeeSchedule() {
			return exerciseFeeSchedule;
		}
		
		@Override
		public BermudaExercise build() {
			return this;
		}
		
		@Override
		public BermudaExercise.BermudaExerciseBuilder toBuilder() {
			BermudaExercise.BermudaExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BermudaExercise.BermudaExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBermudaExerciseDates()).ifPresent(builder::setBermudaExerciseDates);
			ofNullable(getRelevantUnderlyingDate()).ifPresent(builder::setRelevantUnderlyingDate);
			ofNullable(getEarliestExerciseTime()).ifPresent(builder::setEarliestExerciseTime);
			ofNullable(getLatestExerciseTime()).ifPresent(builder::setLatestExerciseTime);
			ofNullable(getExpirationTime()).ifPresent(builder::setExpirationTime);
			ofNullable(getMultipleExercise()).ifPresent(builder::setMultipleExercise);
			ofNullable(getExerciseFeeSchedule()).ifPresent(builder::setExerciseFeeSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BermudaExercise _that = getType().cast(o);
		
			if (!Objects.equals(bermudaExerciseDates, _that.getBermudaExerciseDates())) return false;
			if (!Objects.equals(relevantUnderlyingDate, _that.getRelevantUnderlyingDate())) return false;
			if (!Objects.equals(earliestExerciseTime, _that.getEarliestExerciseTime())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			if (!Objects.equals(exerciseFeeSchedule, _that.getExerciseFeeSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (bermudaExerciseDates != null ? bermudaExerciseDates.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDate != null ? relevantUnderlyingDate.hashCode() : 0);
			_result = 31 * _result + (earliestExerciseTime != null ? earliestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseFeeSchedule != null ? exerciseFeeSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BermudaExercise {" +
				"bermudaExerciseDates=" + this.bermudaExerciseDates + ", " +
				"relevantUnderlyingDate=" + this.relevantUnderlyingDate + ", " +
				"earliestExerciseTime=" + this.earliestExerciseTime + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"multipleExercise=" + this.multipleExercise + ", " +
				"exerciseFeeSchedule=" + this.exerciseFeeSchedule +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BermudaExercise  ***********************/
	class BermudaExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl implements BermudaExercise.BermudaExerciseBuilder {
	
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder bermudaExerciseDates;
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder relevantUnderlyingDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder earliestExerciseTime;
		protected BusinessCenterTime.BusinessCenterTimeBuilder latestExerciseTime;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expirationTime;
		protected MultipleExercise.MultipleExerciseBuilder multipleExercise;
		protected ExerciseFeeSchedule.ExerciseFeeScheduleBuilder exerciseFeeSchedule;
		
		@Override
		@RosettaAttribute("bermudaExerciseDates")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("bermudaExerciseDates")
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getBermudaExerciseDates() {
			return bermudaExerciseDates;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateBermudaExerciseDates() {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder result;
			if (bermudaExerciseDates!=null) {
				result = bermudaExerciseDates;
			}
			else {
				result = bermudaExerciseDates = AdjustableOrRelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relevantUnderlyingDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relevantUnderlyingDate")
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getRelevantUnderlyingDate() {
			return relevantUnderlyingDate;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateRelevantUnderlyingDate() {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder result;
			if (relevantUnderlyingDate!=null) {
				result = relevantUnderlyingDate;
			}
			else {
				result = relevantUnderlyingDate = AdjustableOrRelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("earliestExerciseTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earliestExerciseTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getEarliestExerciseTime() {
			return earliestExerciseTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestExerciseTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (earliestExerciseTime!=null) {
				result = earliestExerciseTime;
			}
			else {
				result = earliestExerciseTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("latestExerciseTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("latestExerciseTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getLatestExerciseTime() {
			return latestExerciseTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExerciseTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (latestExerciseTime!=null) {
				result = latestExerciseTime;
			}
			else {
				result = latestExerciseTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpirationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (expirationTime!=null) {
				result = expirationTime;
			}
			else {
				result = expirationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("multipleExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multipleExercise")
		public MultipleExercise.MultipleExerciseBuilder getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		public MultipleExercise.MultipleExerciseBuilder getOrCreateMultipleExercise() {
			MultipleExercise.MultipleExerciseBuilder result;
			if (multipleExercise!=null) {
				result = multipleExercise;
			}
			else {
				result = multipleExercise = MultipleExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseFeeSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseFeeSchedule")
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getExerciseFeeSchedule() {
			return exerciseFeeSchedule;
		}
		
		@Override
		public ExerciseFeeSchedule.ExerciseFeeScheduleBuilder getOrCreateExerciseFeeSchedule() {
			ExerciseFeeSchedule.ExerciseFeeScheduleBuilder result;
			if (exerciseFeeSchedule!=null) {
				result = exerciseFeeSchedule;
			}
			else {
				result = exerciseFeeSchedule = ExerciseFeeSchedule.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public BermudaExercise.BermudaExerciseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("bermudaExerciseDates")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("bermudaExerciseDates")
		@Override
		public BermudaExercise.BermudaExerciseBuilder setBermudaExerciseDates(AdjustableOrRelativeDates _bermudaExerciseDates) {
			this.bermudaExerciseDates = _bermudaExerciseDates == null ? null : _bermudaExerciseDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relevantUnderlyingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relevantUnderlyingDate")
		@Override
		public BermudaExercise.BermudaExerciseBuilder setRelevantUnderlyingDate(AdjustableOrRelativeDates _relevantUnderlyingDate) {
			this.relevantUnderlyingDate = _relevantUnderlyingDate == null ? null : _relevantUnderlyingDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("earliestExerciseTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earliestExerciseTime")
		@Override
		public BermudaExercise.BermudaExerciseBuilder setEarliestExerciseTime(BusinessCenterTime _earliestExerciseTime) {
			this.earliestExerciseTime = _earliestExerciseTime == null ? null : _earliestExerciseTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("latestExerciseTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("latestExerciseTime")
		@Override
		public BermudaExercise.BermudaExerciseBuilder setLatestExerciseTime(BusinessCenterTime _latestExerciseTime) {
			this.latestExerciseTime = _latestExerciseTime == null ? null : _latestExerciseTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationTime")
		@Override
		public BermudaExercise.BermudaExerciseBuilder setExpirationTime(BusinessCenterTime _expirationTime) {
			this.expirationTime = _expirationTime == null ? null : _expirationTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("multipleExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multipleExercise")
		@Override
		public BermudaExercise.BermudaExerciseBuilder setMultipleExercise(MultipleExercise _multipleExercise) {
			this.multipleExercise = _multipleExercise == null ? null : _multipleExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseFeeSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseFeeSchedule")
		@Override
		public BermudaExercise.BermudaExerciseBuilder setExerciseFeeSchedule(ExerciseFeeSchedule _exerciseFeeSchedule) {
			this.exerciseFeeSchedule = _exerciseFeeSchedule == null ? null : _exerciseFeeSchedule.toBuilder();
			return this;
		}
		
		@Override
		public BermudaExercise build() {
			return new BermudaExercise.BermudaExerciseImpl(this);
		}
		
		@Override
		public BermudaExercise.BermudaExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BermudaExercise.BermudaExerciseBuilder prune() {
			super.prune();
			if (bermudaExerciseDates!=null && !bermudaExerciseDates.prune().hasData()) bermudaExerciseDates = null;
			if (relevantUnderlyingDate!=null && !relevantUnderlyingDate.prune().hasData()) relevantUnderlyingDate = null;
			if (earliestExerciseTime!=null && !earliestExerciseTime.prune().hasData()) earliestExerciseTime = null;
			if (latestExerciseTime!=null && !latestExerciseTime.prune().hasData()) latestExerciseTime = null;
			if (expirationTime!=null && !expirationTime.prune().hasData()) expirationTime = null;
			if (multipleExercise!=null && !multipleExercise.prune().hasData()) multipleExercise = null;
			if (exerciseFeeSchedule!=null && !exerciseFeeSchedule.prune().hasData()) exerciseFeeSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBermudaExerciseDates()!=null && getBermudaExerciseDates().hasData()) return true;
			if (getRelevantUnderlyingDate()!=null && getRelevantUnderlyingDate().hasData()) return true;
			if (getEarliestExerciseTime()!=null && getEarliestExerciseTime().hasData()) return true;
			if (getLatestExerciseTime()!=null && getLatestExerciseTime().hasData()) return true;
			if (getExpirationTime()!=null && getExpirationTime().hasData()) return true;
			if (getMultipleExercise()!=null && getMultipleExercise().hasData()) return true;
			if (getExerciseFeeSchedule()!=null && getExerciseFeeSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BermudaExercise.BermudaExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			BermudaExercise.BermudaExerciseBuilder o = (BermudaExercise.BermudaExerciseBuilder) other;
			
			merger.mergeRosetta(getBermudaExerciseDates(), o.getBermudaExerciseDates(), this::setBermudaExerciseDates);
			merger.mergeRosetta(getRelevantUnderlyingDate(), o.getRelevantUnderlyingDate(), this::setRelevantUnderlyingDate);
			merger.mergeRosetta(getEarliestExerciseTime(), o.getEarliestExerciseTime(), this::setEarliestExerciseTime);
			merger.mergeRosetta(getLatestExerciseTime(), o.getLatestExerciseTime(), this::setLatestExerciseTime);
			merger.mergeRosetta(getExpirationTime(), o.getExpirationTime(), this::setExpirationTime);
			merger.mergeRosetta(getMultipleExercise(), o.getMultipleExercise(), this::setMultipleExercise);
			merger.mergeRosetta(getExerciseFeeSchedule(), o.getExerciseFeeSchedule(), this::setExerciseFeeSchedule);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BermudaExercise _that = getType().cast(o);
		
			if (!Objects.equals(bermudaExerciseDates, _that.getBermudaExerciseDates())) return false;
			if (!Objects.equals(relevantUnderlyingDate, _that.getRelevantUnderlyingDate())) return false;
			if (!Objects.equals(earliestExerciseTime, _that.getEarliestExerciseTime())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			if (!Objects.equals(exerciseFeeSchedule, _that.getExerciseFeeSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (bermudaExerciseDates != null ? bermudaExerciseDates.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDate != null ? relevantUnderlyingDate.hashCode() : 0);
			_result = 31 * _result + (earliestExerciseTime != null ? earliestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseFeeSchedule != null ? exerciseFeeSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BermudaExerciseBuilder {" +
				"bermudaExerciseDates=" + this.bermudaExerciseDates + ", " +
				"relevantUnderlyingDate=" + this.relevantUnderlyingDate + ", " +
				"earliestExerciseTime=" + this.earliestExerciseTime + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"multipleExercise=" + this.multipleExercise + ", " +
				"exerciseFeeSchedule=" + this.exerciseFeeSchedule +
			'}' + " " + super.toString();
		}
	}
}
