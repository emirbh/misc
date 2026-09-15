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
import fpml.consolidated.shared.meta.SharedAmericanExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision TBA
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision TBA
 *
 */
@RosettaDataType(value="SharedAmericanExercise", builder=SharedAmericanExercise.SharedAmericanExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SharedAmericanExercise", model="fpml", builder=SharedAmericanExercise.SharedAmericanExerciseBuilderImpl.class, version="2.1.1")
public interface SharedAmericanExercise extends Exercise {

	SharedAmericanExerciseMeta metaData = new SharedAmericanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The first day of the exercise period for an American style option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The first day of the exercise period for an American style option.
	 *
	 */
	AdjustableOrRelativeDate getCommencementDate();
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
	 * Provision Latest exercise time determination method.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Latest exercise time determination method.
	 *
	 */
	DeterminationMethod getLatestExerciseTimeDetermination();

	/*********************** Build Methods  ***********************/
	SharedAmericanExercise build();
	
	SharedAmericanExercise.SharedAmericanExerciseBuilder toBuilder();
	
	static SharedAmericanExercise.SharedAmericanExerciseBuilder builder() {
		return new SharedAmericanExercise.SharedAmericanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SharedAmericanExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SharedAmericanExercise> getType() {
		return SharedAmericanExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.class, getCommencementDate());
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.class, getLatestExerciseTime());
		processRosetta(path.newSubPath("latestExerciseTimeDetermination"), processor, DeterminationMethod.class, getLatestExerciseTimeDetermination());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SharedAmericanExerciseBuilder extends SharedAmericanExercise, Exercise.ExerciseBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCommencementDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCommencementDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExerciseTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getLatestExerciseTime();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateLatestExerciseTimeDetermination();
		@Override
		DeterminationMethod.DeterminationMethodBuilder getLatestExerciseTimeDetermination();
		@Override
		SharedAmericanExercise.SharedAmericanExerciseBuilder setId(String id);
		SharedAmericanExercise.SharedAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate);
		SharedAmericanExercise.SharedAmericanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		SharedAmericanExercise.SharedAmericanExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime);
		SharedAmericanExercise.SharedAmericanExerciseBuilder setLatestExerciseTimeDetermination(DeterminationMethod latestExerciseTimeDetermination);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCommencementDate());
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getLatestExerciseTime());
			processRosetta(path.newSubPath("latestExerciseTimeDetermination"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getLatestExerciseTimeDetermination());
		}
		

		SharedAmericanExercise.SharedAmericanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of SharedAmericanExercise  ***********************/
	class SharedAmericanExerciseImpl extends Exercise.ExerciseImpl implements SharedAmericanExercise {
		private final AdjustableOrRelativeDate commencementDate;
		private final AdjustableOrRelativeDate expirationDate;
		private final BusinessCenterTime latestExerciseTime;
		private final DeterminationMethod latestExerciseTimeDetermination;
		
		protected SharedAmericanExerciseImpl(SharedAmericanExercise.SharedAmericanExerciseBuilder builder) {
			super(builder);
			this.commencementDate = ofNullable(builder.getCommencementDate()).map(f->f.build()).orElse(null);
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
			this.latestExerciseTime = ofNullable(builder.getLatestExerciseTime()).map(f->f.build()).orElse(null);
			this.latestExerciseTimeDetermination = ofNullable(builder.getLatestExerciseTimeDetermination()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commencementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commencementDate")
		public AdjustableOrRelativeDate getCommencementDate() {
			return commencementDate;
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
		@RosettaAttribute("latestExerciseTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("latestExerciseTime")
		public BusinessCenterTime getLatestExerciseTime() {
			return latestExerciseTime;
		}
		
		@Override
		@RosettaAttribute("latestExerciseTimeDetermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("latestExerciseTimeDetermination")
		public DeterminationMethod getLatestExerciseTimeDetermination() {
			return latestExerciseTimeDetermination;
		}
		
		@Override
		public SharedAmericanExercise build() {
			return this;
		}
		
		@Override
		public SharedAmericanExercise.SharedAmericanExerciseBuilder toBuilder() {
			SharedAmericanExercise.SharedAmericanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SharedAmericanExercise.SharedAmericanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommencementDate()).ifPresent(builder::setCommencementDate);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getLatestExerciseTime()).ifPresent(builder::setLatestExerciseTime);
			ofNullable(getLatestExerciseTimeDetermination()).ifPresent(builder::setLatestExerciseTimeDetermination);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SharedAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(latestExerciseTimeDetermination, _that.getLatestExerciseTimeDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTimeDetermination != null ? latestExerciseTimeDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SharedAmericanExercise {" +
				"commencementDate=" + this.commencementDate + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"latestExerciseTimeDetermination=" + this.latestExerciseTimeDetermination +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SharedAmericanExercise  ***********************/
	class SharedAmericanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl implements SharedAmericanExercise.SharedAmericanExerciseBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder commencementDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder expirationDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder latestExerciseTime;
		protected DeterminationMethod.DeterminationMethodBuilder latestExerciseTimeDetermination;
		
		@Override
		@RosettaAttribute("commencementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commencementDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCommencementDate() {
			return commencementDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCommencementDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (commencementDate!=null) {
				result = commencementDate;
			}
			else {
				result = commencementDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
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
		@RosettaAttribute("latestExerciseTimeDetermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("latestExerciseTimeDetermination")
		public DeterminationMethod.DeterminationMethodBuilder getLatestExerciseTimeDetermination() {
			return latestExerciseTimeDetermination;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder getOrCreateLatestExerciseTimeDetermination() {
			DeterminationMethod.DeterminationMethodBuilder result;
			if (latestExerciseTimeDetermination!=null) {
				result = latestExerciseTimeDetermination;
			}
			else {
				result = latestExerciseTimeDetermination = DeterminationMethod.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SharedAmericanExercise.SharedAmericanExerciseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("commencementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commencementDate")
		@Override
		public SharedAmericanExercise.SharedAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate _commencementDate) {
			this.commencementDate = _commencementDate == null ? null : _commencementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("expirationDate")
		@Override
		public SharedAmericanExercise.SharedAmericanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("latestExerciseTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("latestExerciseTime")
		@Override
		public SharedAmericanExercise.SharedAmericanExerciseBuilder setLatestExerciseTime(BusinessCenterTime _latestExerciseTime) {
			this.latestExerciseTime = _latestExerciseTime == null ? null : _latestExerciseTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("latestExerciseTimeDetermination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("latestExerciseTimeDetermination")
		@Override
		public SharedAmericanExercise.SharedAmericanExerciseBuilder setLatestExerciseTimeDetermination(DeterminationMethod _latestExerciseTimeDetermination) {
			this.latestExerciseTimeDetermination = _latestExerciseTimeDetermination == null ? null : _latestExerciseTimeDetermination.toBuilder();
			return this;
		}
		
		@Override
		public SharedAmericanExercise build() {
			return new SharedAmericanExercise.SharedAmericanExerciseImpl(this);
		}
		
		@Override
		public SharedAmericanExercise.SharedAmericanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SharedAmericanExercise.SharedAmericanExerciseBuilder prune() {
			super.prune();
			if (commencementDate!=null && !commencementDate.prune().hasData()) commencementDate = null;
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			if (latestExerciseTime!=null && !latestExerciseTime.prune().hasData()) latestExerciseTime = null;
			if (latestExerciseTimeDetermination!=null && !latestExerciseTimeDetermination.prune().hasData()) latestExerciseTimeDetermination = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommencementDate()!=null && getCommencementDate().hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			if (getLatestExerciseTime()!=null && getLatestExerciseTime().hasData()) return true;
			if (getLatestExerciseTimeDetermination()!=null && getLatestExerciseTimeDetermination().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SharedAmericanExercise.SharedAmericanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SharedAmericanExercise.SharedAmericanExerciseBuilder o = (SharedAmericanExercise.SharedAmericanExerciseBuilder) other;
			
			merger.mergeRosetta(getCommencementDate(), o.getCommencementDate(), this::setCommencementDate);
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeRosetta(getLatestExerciseTime(), o.getLatestExerciseTime(), this::setLatestExerciseTime);
			merger.mergeRosetta(getLatestExerciseTimeDetermination(), o.getLatestExerciseTimeDetermination(), this::setLatestExerciseTimeDetermination);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SharedAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(latestExerciseTimeDetermination, _that.getLatestExerciseTimeDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTimeDetermination != null ? latestExerciseTimeDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SharedAmericanExerciseBuilder {" +
				"commencementDate=" + this.commencementDate + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"latestExerciseTimeDetermination=" + this.latestExerciseTimeDetermination +
			'}' + " " + super.toString();
		}
	}
}
