package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityPhysicalAmericanExerciseMeta;
import fpml.consolidated.shared.AdjustableOrRelativeDates;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.PrevailingTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The parameters for defining the expiration date(s) and time(s) for an American style option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The parameters for defining the expiration date(s) and time(s) for an American style option.
 *
 */
@RosettaDataType(value="CommodityPhysicalAmericanExercise", builder=CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityPhysicalAmericanExercise", model="fpml", builder=CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilderImpl.class, version="2.1.1")
public interface CommodityPhysicalAmericanExercise extends Exercise {

	CommodityPhysicalAmericanExerciseMeta metaData = new CommodityPhysicalAmericanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The first day(s) of the exercise period(s) for an American-style option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The first day(s) of the exercise period(s) for an American-style option.
	 *
	 */
	AdjustableOrRelativeDates getCommencementDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Expiration Date(s) of an American-style option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Expiration Date(s) of an American-style option.
	 *
	 */
	AdjustableOrRelativeDates getExpirationDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The first day(s) of the exercise period(s) for an American-style option where it is relative to the occurrence of an external event.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The first day(s) of the exercise period(s) for an American-style option where it is relative to the occurrence of an external event.
	 *
	 */
	CommodityRelativeExpirationDates getRelativeCommencementDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Expiration Date(s) of an American-style option where it is relative to the occurrence of an external event.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Expiration Date(s) of an American-style option where it is relative to the occurrence of an external event.
	 *
	 */
	CommodityRelativeExpirationDates getRelativeExpirationDates();
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
	PrevailingTime getLatestExerciseTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specific time of day at which the option expires.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specific time of day at which the option expires.
	 *
	 */
	PrevailingTime getExpirationTime();

	/*********************** Build Methods  ***********************/
	CommodityPhysicalAmericanExercise build();
	
	CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder toBuilder();
	
	static CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder builder() {
		return new CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPhysicalAmericanExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityPhysicalAmericanExercise> getType() {
		return CommodityPhysicalAmericanExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commencementDates"), processor, AdjustableOrRelativeDates.class, getCommencementDates());
		processRosetta(path.newSubPath("expirationDates"), processor, AdjustableOrRelativeDates.class, getExpirationDates());
		processRosetta(path.newSubPath("relativeCommencementDates"), processor, CommodityRelativeExpirationDates.class, getRelativeCommencementDates());
		processRosetta(path.newSubPath("relativeExpirationDates"), processor, CommodityRelativeExpirationDates.class, getRelativeExpirationDates());
		processRosetta(path.newSubPath("latestExerciseTime"), processor, PrevailingTime.class, getLatestExerciseTime());
		processRosetta(path.newSubPath("expirationTime"), processor, PrevailingTime.class, getExpirationTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPhysicalAmericanExerciseBuilder extends CommodityPhysicalAmericanExercise, Exercise.ExerciseBuilder {
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateCommencementDates();
		@Override
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getCommencementDates();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateExpirationDates();
		@Override
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getExpirationDates();
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getOrCreateRelativeCommencementDates();
		@Override
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getRelativeCommencementDates();
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getOrCreateRelativeExpirationDates();
		@Override
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getRelativeExpirationDates();
		PrevailingTime.PrevailingTimeBuilder getOrCreateLatestExerciseTime();
		@Override
		PrevailingTime.PrevailingTimeBuilder getLatestExerciseTime();
		PrevailingTime.PrevailingTimeBuilder getOrCreateExpirationTime();
		@Override
		PrevailingTime.PrevailingTimeBuilder getExpirationTime();
		@Override
		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setId(String id);
		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setCommencementDates(AdjustableOrRelativeDates commencementDates);
		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setExpirationDates(AdjustableOrRelativeDates expirationDates);
		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setRelativeCommencementDates(CommodityRelativeExpirationDates relativeCommencementDates);
		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setRelativeExpirationDates(CommodityRelativeExpirationDates relativeExpirationDates);
		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setLatestExerciseTime(PrevailingTime latestExerciseTime);
		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setExpirationTime(PrevailingTime expirationTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commencementDates"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getCommencementDates());
			processRosetta(path.newSubPath("expirationDates"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getExpirationDates());
			processRosetta(path.newSubPath("relativeCommencementDates"), processor, CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder.class, getRelativeCommencementDates());
			processRosetta(path.newSubPath("relativeExpirationDates"), processor, CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder.class, getRelativeExpirationDates());
			processRosetta(path.newSubPath("latestExerciseTime"), processor, PrevailingTime.PrevailingTimeBuilder.class, getLatestExerciseTime());
			processRosetta(path.newSubPath("expirationTime"), processor, PrevailingTime.PrevailingTimeBuilder.class, getExpirationTime());
		}
		

		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPhysicalAmericanExercise  ***********************/
	class CommodityPhysicalAmericanExerciseImpl extends Exercise.ExerciseImpl implements CommodityPhysicalAmericanExercise {
		private final AdjustableOrRelativeDates commencementDates;
		private final AdjustableOrRelativeDates expirationDates;
		private final CommodityRelativeExpirationDates relativeCommencementDates;
		private final CommodityRelativeExpirationDates relativeExpirationDates;
		private final PrevailingTime latestExerciseTime;
		private final PrevailingTime expirationTime;
		
		protected CommodityPhysicalAmericanExerciseImpl(CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder builder) {
			super(builder);
			this.commencementDates = ofNullable(builder.getCommencementDates()).map(f->f.build()).orElse(null);
			this.expirationDates = ofNullable(builder.getExpirationDates()).map(f->f.build()).orElse(null);
			this.relativeCommencementDates = ofNullable(builder.getRelativeCommencementDates()).map(f->f.build()).orElse(null);
			this.relativeExpirationDates = ofNullable(builder.getRelativeExpirationDates()).map(f->f.build()).orElse(null);
			this.latestExerciseTime = ofNullable(builder.getLatestExerciseTime()).map(f->f.build()).orElse(null);
			this.expirationTime = ofNullable(builder.getExpirationTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commencementDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commencementDates")
		public AdjustableOrRelativeDates getCommencementDates() {
			return commencementDates;
		}
		
		@Override
		@RosettaAttribute("expirationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationDates")
		public AdjustableOrRelativeDates getExpirationDates() {
			return expirationDates;
		}
		
		@Override
		@RosettaAttribute("relativeCommencementDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeCommencementDates")
		public CommodityRelativeExpirationDates getRelativeCommencementDates() {
			return relativeCommencementDates;
		}
		
		@Override
		@RosettaAttribute("relativeExpirationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeExpirationDates")
		public CommodityRelativeExpirationDates getRelativeExpirationDates() {
			return relativeExpirationDates;
		}
		
		@Override
		@RosettaAttribute("latestExerciseTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("latestExerciseTime")
		public PrevailingTime getLatestExerciseTime() {
			return latestExerciseTime;
		}
		
		@Override
		@RosettaAttribute("expirationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationTime")
		public PrevailingTime getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		public CommodityPhysicalAmericanExercise build() {
			return this;
		}
		
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder toBuilder() {
			CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommencementDates()).ifPresent(builder::setCommencementDates);
			ofNullable(getExpirationDates()).ifPresent(builder::setExpirationDates);
			ofNullable(getRelativeCommencementDates()).ifPresent(builder::setRelativeCommencementDates);
			ofNullable(getRelativeExpirationDates()).ifPresent(builder::setRelativeExpirationDates);
			ofNullable(getLatestExerciseTime()).ifPresent(builder::setLatestExerciseTime);
			ofNullable(getExpirationTime()).ifPresent(builder::setExpirationTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPhysicalAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(commencementDates, _that.getCommencementDates())) return false;
			if (!Objects.equals(expirationDates, _that.getExpirationDates())) return false;
			if (!Objects.equals(relativeCommencementDates, _that.getRelativeCommencementDates())) return false;
			if (!Objects.equals(relativeExpirationDates, _that.getRelativeExpirationDates())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commencementDates != null ? commencementDates.hashCode() : 0);
			_result = 31 * _result + (expirationDates != null ? expirationDates.hashCode() : 0);
			_result = 31 * _result + (relativeCommencementDates != null ? relativeCommencementDates.hashCode() : 0);
			_result = 31 * _result + (relativeExpirationDates != null ? relativeExpirationDates.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalAmericanExercise {" +
				"commencementDates=" + this.commencementDates + ", " +
				"expirationDates=" + this.expirationDates + ", " +
				"relativeCommencementDates=" + this.relativeCommencementDates + ", " +
				"relativeExpirationDates=" + this.relativeExpirationDates + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"expirationTime=" + this.expirationTime +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityPhysicalAmericanExercise  ***********************/
	class CommodityPhysicalAmericanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl implements CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder {
	
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder commencementDates;
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder expirationDates;
		protected CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder relativeCommencementDates;
		protected CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder relativeExpirationDates;
		protected PrevailingTime.PrevailingTimeBuilder latestExerciseTime;
		protected PrevailingTime.PrevailingTimeBuilder expirationTime;
		
		@Override
		@RosettaAttribute("commencementDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commencementDates")
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getCommencementDates() {
			return commencementDates;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateCommencementDates() {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder result;
			if (commencementDates!=null) {
				result = commencementDates;
			}
			else {
				result = commencementDates = AdjustableOrRelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationDates")
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getExpirationDates() {
			return expirationDates;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateExpirationDates() {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder result;
			if (expirationDates!=null) {
				result = expirationDates;
			}
			else {
				result = expirationDates = AdjustableOrRelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeCommencementDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeCommencementDates")
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getRelativeCommencementDates() {
			return relativeCommencementDates;
		}
		
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getOrCreateRelativeCommencementDates() {
			CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder result;
			if (relativeCommencementDates!=null) {
				result = relativeCommencementDates;
			}
			else {
				result = relativeCommencementDates = CommodityRelativeExpirationDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeExpirationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativeExpirationDates")
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getRelativeExpirationDates() {
			return relativeExpirationDates;
		}
		
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getOrCreateRelativeExpirationDates() {
			CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder result;
			if (relativeExpirationDates!=null) {
				result = relativeExpirationDates;
			}
			else {
				result = relativeExpirationDates = CommodityRelativeExpirationDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("latestExerciseTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("latestExerciseTime")
		public PrevailingTime.PrevailingTimeBuilder getLatestExerciseTime() {
			return latestExerciseTime;
		}
		
		@Override
		public PrevailingTime.PrevailingTimeBuilder getOrCreateLatestExerciseTime() {
			PrevailingTime.PrevailingTimeBuilder result;
			if (latestExerciseTime!=null) {
				result = latestExerciseTime;
			}
			else {
				result = latestExerciseTime = PrevailingTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationTime")
		public PrevailingTime.PrevailingTimeBuilder getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		public PrevailingTime.PrevailingTimeBuilder getOrCreateExpirationTime() {
			PrevailingTime.PrevailingTimeBuilder result;
			if (expirationTime!=null) {
				result = expirationTime;
			}
			else {
				result = expirationTime = PrevailingTime.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("commencementDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commencementDates")
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setCommencementDates(AdjustableOrRelativeDates _commencementDates) {
			this.commencementDates = _commencementDates == null ? null : _commencementDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDates")
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setExpirationDates(AdjustableOrRelativeDates _expirationDates) {
			this.expirationDates = _expirationDates == null ? null : _expirationDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativeCommencementDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativeCommencementDates")
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setRelativeCommencementDates(CommodityRelativeExpirationDates _relativeCommencementDates) {
			this.relativeCommencementDates = _relativeCommencementDates == null ? null : _relativeCommencementDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativeExpirationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativeExpirationDates")
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setRelativeExpirationDates(CommodityRelativeExpirationDates _relativeExpirationDates) {
			this.relativeExpirationDates = _relativeExpirationDates == null ? null : _relativeExpirationDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("latestExerciseTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("latestExerciseTime")
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setLatestExerciseTime(PrevailingTime _latestExerciseTime) {
			this.latestExerciseTime = _latestExerciseTime == null ? null : _latestExerciseTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationTime")
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setExpirationTime(PrevailingTime _expirationTime) {
			this.expirationTime = _expirationTime == null ? null : _expirationTime.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPhysicalAmericanExercise build() {
			return new CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseImpl(this);
		}
		
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder prune() {
			super.prune();
			if (commencementDates!=null && !commencementDates.prune().hasData()) commencementDates = null;
			if (expirationDates!=null && !expirationDates.prune().hasData()) expirationDates = null;
			if (relativeCommencementDates!=null && !relativeCommencementDates.prune().hasData()) relativeCommencementDates = null;
			if (relativeExpirationDates!=null && !relativeExpirationDates.prune().hasData()) relativeExpirationDates = null;
			if (latestExerciseTime!=null && !latestExerciseTime.prune().hasData()) latestExerciseTime = null;
			if (expirationTime!=null && !expirationTime.prune().hasData()) expirationTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommencementDates()!=null && getCommencementDates().hasData()) return true;
			if (getExpirationDates()!=null && getExpirationDates().hasData()) return true;
			if (getRelativeCommencementDates()!=null && getRelativeCommencementDates().hasData()) return true;
			if (getRelativeExpirationDates()!=null && getRelativeExpirationDates().hasData()) return true;
			if (getLatestExerciseTime()!=null && getLatestExerciseTime().hasData()) return true;
			if (getExpirationTime()!=null && getExpirationTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder o = (CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder) other;
			
			merger.mergeRosetta(getCommencementDates(), o.getCommencementDates(), this::setCommencementDates);
			merger.mergeRosetta(getExpirationDates(), o.getExpirationDates(), this::setExpirationDates);
			merger.mergeRosetta(getRelativeCommencementDates(), o.getRelativeCommencementDates(), this::setRelativeCommencementDates);
			merger.mergeRosetta(getRelativeExpirationDates(), o.getRelativeExpirationDates(), this::setRelativeExpirationDates);
			merger.mergeRosetta(getLatestExerciseTime(), o.getLatestExerciseTime(), this::setLatestExerciseTime);
			merger.mergeRosetta(getExpirationTime(), o.getExpirationTime(), this::setExpirationTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPhysicalAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(commencementDates, _that.getCommencementDates())) return false;
			if (!Objects.equals(expirationDates, _that.getExpirationDates())) return false;
			if (!Objects.equals(relativeCommencementDates, _that.getRelativeCommencementDates())) return false;
			if (!Objects.equals(relativeExpirationDates, _that.getRelativeExpirationDates())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commencementDates != null ? commencementDates.hashCode() : 0);
			_result = 31 * _result + (expirationDates != null ? expirationDates.hashCode() : 0);
			_result = 31 * _result + (relativeCommencementDates != null ? relativeCommencementDates.hashCode() : 0);
			_result = 31 * _result + (relativeExpirationDates != null ? relativeExpirationDates.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalAmericanExerciseBuilder {" +
				"commencementDates=" + this.commencementDates + ", " +
				"expirationDates=" + this.expirationDates + ", " +
				"relativeCommencementDates=" + this.relativeCommencementDates + ", " +
				"relativeExpirationDates=" + this.relativeExpirationDates + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"expirationTime=" + this.expirationTime +
			'}' + " " + super.toString();
		}
	}
}
