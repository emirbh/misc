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
import fpml.consolidated.shared.meta.EuropeanExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the exercise period for a European style option together with any rules governing the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fees.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the exercise period for a European style option together with any rules governing the notional amount of the underlying which can be exercised on any given exercise date and any associated exercise fees.
 *
 */
@RosettaDataType(value="EuropeanExercise", builder=EuropeanExercise.EuropeanExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EuropeanExercise", model="fpml", builder=EuropeanExercise.EuropeanExerciseBuilderImpl.class, version="2.1.1")
public interface EuropeanExercise extends Exercise {

	EuropeanExerciseMeta metaData = new EuropeanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The last day within an exercise period for an American style option. For a European style option it is the only day within the exercise period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The last day within an exercise period for an American style option. For a European style option it is the only day within the exercise period.
	 *
	 */
	AdjustableOrRelativeDate getExpirationDate();
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
	 * Provision As defined in the 2000 ISDA Definitions, Section 12.3. Partial Exercise, the buyer of the option has the right to exercise all or less than all the notional amount of the underlying swap on the expiration date, but may not exercise less than the minimum notional amount, and if an integral multiple amount is specified, the notional amount exercised must be equal to, or be an integral multiple of, the integral multiple amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision As defined in the 2000 ISDA Definitions, Section 12.3. Partial Exercise, the buyer of the option has the right to exercise all or less than all the notional amount of the underlying swap on the expiration date, but may not exercise less than the minimum notional amount, and if an integral multiple amount is specified, the notional amount exercised must be equal to, or be an integral multiple of, the integral multiple amount.
	 *
	 */
	PartialExercise getPartialExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A fee to be paid on exercise. This could be represented as an amount or a rate and notional reference on which to apply the rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A fee to be paid on exercise. This could be represented as an amount or a rate and notional reference on which to apply the rate.
	 *
	 */
	ExerciseFee getExerciseFee();

	/*********************** Build Methods  ***********************/
	EuropeanExercise build();
	
	EuropeanExercise.EuropeanExerciseBuilder toBuilder();
	
	static EuropeanExercise.EuropeanExerciseBuilder builder() {
		return new EuropeanExercise.EuropeanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EuropeanExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EuropeanExercise> getType() {
		return EuropeanExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("relevantUnderlyingDate"), processor, AdjustableOrRelativeDates.class, getRelevantUnderlyingDate());
		processRosetta(path.newSubPath("earliestExerciseTime"), processor, BusinessCenterTime.class, getEarliestExerciseTime());
		processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.class, getExpirationTime());
		processRosetta(path.newSubPath("partialExercise"), processor, PartialExercise.class, getPartialExercise());
		processRosetta(path.newSubPath("exerciseFee"), processor, ExerciseFee.class, getExerciseFee());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EuropeanExerciseBuilder extends EuropeanExercise, Exercise.ExerciseBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateRelevantUnderlyingDate();
		@Override
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getRelevantUnderlyingDate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEarliestExerciseTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getEarliestExerciseTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpirationTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getExpirationTime();
		PartialExercise.PartialExerciseBuilder getOrCreatePartialExercise();
		@Override
		PartialExercise.PartialExerciseBuilder getPartialExercise();
		ExerciseFee.ExerciseFeeBuilder getOrCreateExerciseFee();
		@Override
		ExerciseFee.ExerciseFeeBuilder getExerciseFee();
		@Override
		EuropeanExercise.EuropeanExerciseBuilder setId(String id);
		EuropeanExercise.EuropeanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		EuropeanExercise.EuropeanExerciseBuilder setRelevantUnderlyingDate(AdjustableOrRelativeDates relevantUnderlyingDate);
		EuropeanExercise.EuropeanExerciseBuilder setEarliestExerciseTime(BusinessCenterTime earliestExerciseTime);
		EuropeanExercise.EuropeanExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime);
		EuropeanExercise.EuropeanExerciseBuilder setPartialExercise(PartialExercise partialExercise);
		EuropeanExercise.EuropeanExerciseBuilder setExerciseFee(ExerciseFee exerciseFee);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("relevantUnderlyingDate"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getRelevantUnderlyingDate());
			processRosetta(path.newSubPath("earliestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getEarliestExerciseTime());
			processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpirationTime());
			processRosetta(path.newSubPath("partialExercise"), processor, PartialExercise.PartialExerciseBuilder.class, getPartialExercise());
			processRosetta(path.newSubPath("exerciseFee"), processor, ExerciseFee.ExerciseFeeBuilder.class, getExerciseFee());
		}
		

		EuropeanExercise.EuropeanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of EuropeanExercise  ***********************/
	class EuropeanExerciseImpl extends Exercise.ExerciseImpl implements EuropeanExercise {
		private final AdjustableOrRelativeDate expirationDate;
		private final AdjustableOrRelativeDates relevantUnderlyingDate;
		private final BusinessCenterTime earliestExerciseTime;
		private final BusinessCenterTime expirationTime;
		private final PartialExercise partialExercise;
		private final ExerciseFee exerciseFee;
		
		protected EuropeanExerciseImpl(EuropeanExercise.EuropeanExerciseBuilder builder) {
			super(builder);
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
			this.relevantUnderlyingDate = ofNullable(builder.getRelevantUnderlyingDate()).map(f->f.build()).orElse(null);
			this.earliestExerciseTime = ofNullable(builder.getEarliestExerciseTime()).map(f->f.build()).orElse(null);
			this.expirationTime = ofNullable(builder.getExpirationTime()).map(f->f.build()).orElse(null);
			this.partialExercise = ofNullable(builder.getPartialExercise()).map(f->f.build()).orElse(null);
			this.exerciseFee = ofNullable(builder.getExerciseFee()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("expirationDate")
		public AdjustableOrRelativeDate getExpirationDate() {
			return expirationDate;
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
		@RosettaAttribute("expirationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationTime")
		public BusinessCenterTime getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		@RosettaAttribute("partialExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partialExercise")
		public PartialExercise getPartialExercise() {
			return partialExercise;
		}
		
		@Override
		@RosettaAttribute("exerciseFee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseFee")
		public ExerciseFee getExerciseFee() {
			return exerciseFee;
		}
		
		@Override
		public EuropeanExercise build() {
			return this;
		}
		
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder toBuilder() {
			EuropeanExercise.EuropeanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EuropeanExercise.EuropeanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getRelevantUnderlyingDate()).ifPresent(builder::setRelevantUnderlyingDate);
			ofNullable(getEarliestExerciseTime()).ifPresent(builder::setEarliestExerciseTime);
			ofNullable(getExpirationTime()).ifPresent(builder::setExpirationTime);
			ofNullable(getPartialExercise()).ifPresent(builder::setPartialExercise);
			ofNullable(getExerciseFee()).ifPresent(builder::setExerciseFee);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(relevantUnderlyingDate, _that.getRelevantUnderlyingDate())) return false;
			if (!Objects.equals(earliestExerciseTime, _that.getEarliestExerciseTime())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(partialExercise, _that.getPartialExercise())) return false;
			if (!Objects.equals(exerciseFee, _that.getExerciseFee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDate != null ? relevantUnderlyingDate.hashCode() : 0);
			_result = 31 * _result + (earliestExerciseTime != null ? earliestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (partialExercise != null ? partialExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseFee != null ? exerciseFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EuropeanExercise {" +
				"expirationDate=" + this.expirationDate + ", " +
				"relevantUnderlyingDate=" + this.relevantUnderlyingDate + ", " +
				"earliestExerciseTime=" + this.earliestExerciseTime + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"partialExercise=" + this.partialExercise + ", " +
				"exerciseFee=" + this.exerciseFee +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EuropeanExercise  ***********************/
	class EuropeanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl implements EuropeanExercise.EuropeanExerciseBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder expirationDate;
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder relevantUnderlyingDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder earliestExerciseTime;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expirationTime;
		protected PartialExercise.PartialExerciseBuilder partialExercise;
		protected ExerciseFee.ExerciseFeeBuilder exerciseFee;
		
		@Override
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("expirationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (expirationDate!=null) {
				result = expirationDate;
			}
			else {
				result = expirationDate = AdjustableOrRelativeDate.builder();
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
		@RosettaAttribute("partialExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partialExercise")
		public PartialExercise.PartialExerciseBuilder getPartialExercise() {
			return partialExercise;
		}
		
		@Override
		public PartialExercise.PartialExerciseBuilder getOrCreatePartialExercise() {
			PartialExercise.PartialExerciseBuilder result;
			if (partialExercise!=null) {
				result = partialExercise;
			}
			else {
				result = partialExercise = PartialExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseFee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseFee")
		public ExerciseFee.ExerciseFeeBuilder getExerciseFee() {
			return exerciseFee;
		}
		
		@Override
		public ExerciseFee.ExerciseFeeBuilder getOrCreateExerciseFee() {
			ExerciseFee.ExerciseFeeBuilder result;
			if (exerciseFee!=null) {
				result = exerciseFee;
			}
			else {
				result = exerciseFee = ExerciseFee.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("expirationDate")
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relevantUnderlyingDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relevantUnderlyingDate")
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder setRelevantUnderlyingDate(AdjustableOrRelativeDates _relevantUnderlyingDate) {
			this.relevantUnderlyingDate = _relevantUnderlyingDate == null ? null : _relevantUnderlyingDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("earliestExerciseTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earliestExerciseTime")
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder setEarliestExerciseTime(BusinessCenterTime _earliestExerciseTime) {
			this.earliestExerciseTime = _earliestExerciseTime == null ? null : _earliestExerciseTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationTime")
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder setExpirationTime(BusinessCenterTime _expirationTime) {
			this.expirationTime = _expirationTime == null ? null : _expirationTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partialExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partialExercise")
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder setPartialExercise(PartialExercise _partialExercise) {
			this.partialExercise = _partialExercise == null ? null : _partialExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseFee")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseFee")
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder setExerciseFee(ExerciseFee _exerciseFee) {
			this.exerciseFee = _exerciseFee == null ? null : _exerciseFee.toBuilder();
			return this;
		}
		
		@Override
		public EuropeanExercise build() {
			return new EuropeanExercise.EuropeanExerciseImpl(this);
		}
		
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder prune() {
			super.prune();
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			if (relevantUnderlyingDate!=null && !relevantUnderlyingDate.prune().hasData()) relevantUnderlyingDate = null;
			if (earliestExerciseTime!=null && !earliestExerciseTime.prune().hasData()) earliestExerciseTime = null;
			if (expirationTime!=null && !expirationTime.prune().hasData()) expirationTime = null;
			if (partialExercise!=null && !partialExercise.prune().hasData()) partialExercise = null;
			if (exerciseFee!=null && !exerciseFee.prune().hasData()) exerciseFee = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			if (getRelevantUnderlyingDate()!=null && getRelevantUnderlyingDate().hasData()) return true;
			if (getEarliestExerciseTime()!=null && getEarliestExerciseTime().hasData()) return true;
			if (getExpirationTime()!=null && getExpirationTime().hasData()) return true;
			if (getPartialExercise()!=null && getPartialExercise().hasData()) return true;
			if (getExerciseFee()!=null && getExerciseFee().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EuropeanExercise.EuropeanExerciseBuilder o = (EuropeanExercise.EuropeanExerciseBuilder) other;
			
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeRosetta(getRelevantUnderlyingDate(), o.getRelevantUnderlyingDate(), this::setRelevantUnderlyingDate);
			merger.mergeRosetta(getEarliestExerciseTime(), o.getEarliestExerciseTime(), this::setEarliestExerciseTime);
			merger.mergeRosetta(getExpirationTime(), o.getExpirationTime(), this::setExpirationTime);
			merger.mergeRosetta(getPartialExercise(), o.getPartialExercise(), this::setPartialExercise);
			merger.mergeRosetta(getExerciseFee(), o.getExerciseFee(), this::setExerciseFee);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(relevantUnderlyingDate, _that.getRelevantUnderlyingDate())) return false;
			if (!Objects.equals(earliestExerciseTime, _that.getEarliestExerciseTime())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(partialExercise, _that.getPartialExercise())) return false;
			if (!Objects.equals(exerciseFee, _that.getExerciseFee())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDate != null ? relevantUnderlyingDate.hashCode() : 0);
			_result = 31 * _result + (earliestExerciseTime != null ? earliestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (partialExercise != null ? partialExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseFee != null ? exerciseFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EuropeanExerciseBuilder {" +
				"expirationDate=" + this.expirationDate + ", " +
				"relevantUnderlyingDate=" + this.relevantUnderlyingDate + ", " +
				"earliestExerciseTime=" + this.earliestExerciseTime + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"partialExercise=" + this.partialExercise + ", " +
				"exerciseFee=" + this.exerciseFee +
			'}' + " " + super.toString();
		}
	}
}
