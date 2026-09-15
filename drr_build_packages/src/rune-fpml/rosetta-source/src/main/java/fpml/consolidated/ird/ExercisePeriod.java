package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.ExercisePeriodMeta;
import fpml.consolidated.shared.Period;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision This defines the time interval to the start of the exercise period, i.e. the earliest exercise date, and the frequency of subsequent exercise dates (if any).
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision This defines the time interval to the start of the exercise period, i.e. the earliest exercise date, and the frequency of subsequent exercise dates (if any).
 *
 */
@RosettaDataType(value="ExercisePeriod", builder=ExercisePeriod.ExercisePeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExercisePeriod", model="fpml", builder=ExercisePeriod.ExercisePeriodBuilderImpl.class, version="2.1.1")
public interface ExercisePeriod extends RosettaModelObject {

	ExercisePeriodMeta metaData = new ExercisePeriodMeta();

	/*********************** Getter Methods  ***********************/
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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time interval to the first (and possibly only) exercise date in the exercise period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time interval to the first (and possibly only) exercise date in the exercise period.
	 *
	 */
	Period getEarliestExerciseDateTenor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The frequency of subsequent exercise dates in the exercise period following the earliest exercise date. An interval of 1 day should be used to indicate an American style exercise period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The frequency of subsequent exercise dates in the exercise period following the earliest exercise date. An interval of 1 day should be used to indicate an American style exercise period.
	 *
	 */
	Period getExerciseFrequency();

	/*********************** Build Methods  ***********************/
	ExercisePeriod build();
	
	ExercisePeriod.ExercisePeriodBuilder toBuilder();
	
	static ExercisePeriod.ExercisePeriodBuilder builder() {
		return new ExercisePeriod.ExercisePeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExercisePeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExercisePeriod> getType() {
		return ExercisePeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("earliestExerciseDateTenor"), processor, Period.class, getEarliestExerciseDateTenor());
		processRosetta(path.newSubPath("exerciseFrequency"), processor, Period.class, getExerciseFrequency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExercisePeriodBuilder extends ExercisePeriod, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreateEarliestExerciseDateTenor();
		@Override
		Period.PeriodBuilder getEarliestExerciseDateTenor();
		Period.PeriodBuilder getOrCreateExerciseFrequency();
		@Override
		Period.PeriodBuilder getExerciseFrequency();
		ExercisePeriod.ExercisePeriodBuilder setId(String id);
		ExercisePeriod.ExercisePeriodBuilder setEarliestExerciseDateTenor(Period earliestExerciseDateTenor);
		ExercisePeriod.ExercisePeriodBuilder setExerciseFrequency(Period exerciseFrequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("earliestExerciseDateTenor"), processor, Period.PeriodBuilder.class, getEarliestExerciseDateTenor());
			processRosetta(path.newSubPath("exerciseFrequency"), processor, Period.PeriodBuilder.class, getExerciseFrequency());
		}
		

		ExercisePeriod.ExercisePeriodBuilder prune();
	}

	/*********************** Immutable Implementation of ExercisePeriod  ***********************/
	class ExercisePeriodImpl implements ExercisePeriod {
		private final String id;
		private final Period earliestExerciseDateTenor;
		private final Period exerciseFrequency;
		
		protected ExercisePeriodImpl(ExercisePeriod.ExercisePeriodBuilder builder) {
			this.id = builder.getId();
			this.earliestExerciseDateTenor = ofNullable(builder.getEarliestExerciseDateTenor()).map(f->f.build()).orElse(null);
			this.exerciseFrequency = ofNullable(builder.getExerciseFrequency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("earliestExerciseDateTenor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earliestExerciseDateTenor")
		public Period getEarliestExerciseDateTenor() {
			return earliestExerciseDateTenor;
		}
		
		@Override
		@RosettaAttribute("exerciseFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseFrequency")
		public Period getExerciseFrequency() {
			return exerciseFrequency;
		}
		
		@Override
		public ExercisePeriod build() {
			return this;
		}
		
		@Override
		public ExercisePeriod.ExercisePeriodBuilder toBuilder() {
			ExercisePeriod.ExercisePeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExercisePeriod.ExercisePeriodBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getEarliestExerciseDateTenor()).ifPresent(builder::setEarliestExerciseDateTenor);
			ofNullable(getExerciseFrequency()).ifPresent(builder::setExerciseFrequency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExercisePeriod _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(earliestExerciseDateTenor, _that.getEarliestExerciseDateTenor())) return false;
			if (!Objects.equals(exerciseFrequency, _that.getExerciseFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (earliestExerciseDateTenor != null ? earliestExerciseDateTenor.hashCode() : 0);
			_result = 31 * _result + (exerciseFrequency != null ? exerciseFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExercisePeriod {" +
				"id=" + this.id + ", " +
				"earliestExerciseDateTenor=" + this.earliestExerciseDateTenor + ", " +
				"exerciseFrequency=" + this.exerciseFrequency +
			'}';
		}
	}

	/*********************** Builder Implementation of ExercisePeriod  ***********************/
	class ExercisePeriodBuilderImpl implements ExercisePeriod.ExercisePeriodBuilder {
	
		protected String id;
		protected Period.PeriodBuilder earliestExerciseDateTenor;
		protected Period.PeriodBuilder exerciseFrequency;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("earliestExerciseDateTenor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earliestExerciseDateTenor")
		public Period.PeriodBuilder getEarliestExerciseDateTenor() {
			return earliestExerciseDateTenor;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateEarliestExerciseDateTenor() {
			Period.PeriodBuilder result;
			if (earliestExerciseDateTenor!=null) {
				result = earliestExerciseDateTenor;
			}
			else {
				result = earliestExerciseDateTenor = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseFrequency")
		public Period.PeriodBuilder getExerciseFrequency() {
			return exerciseFrequency;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateExerciseFrequency() {
			Period.PeriodBuilder result;
			if (exerciseFrequency!=null) {
				result = exerciseFrequency;
			}
			else {
				result = exerciseFrequency = Period.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ExercisePeriod.ExercisePeriodBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("earliestExerciseDateTenor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earliestExerciseDateTenor")
		@Override
		public ExercisePeriod.ExercisePeriodBuilder setEarliestExerciseDateTenor(Period _earliestExerciseDateTenor) {
			this.earliestExerciseDateTenor = _earliestExerciseDateTenor == null ? null : _earliestExerciseDateTenor.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseFrequency")
		@Override
		public ExercisePeriod.ExercisePeriodBuilder setExerciseFrequency(Period _exerciseFrequency) {
			this.exerciseFrequency = _exerciseFrequency == null ? null : _exerciseFrequency.toBuilder();
			return this;
		}
		
		@Override
		public ExercisePeriod build() {
			return new ExercisePeriod.ExercisePeriodImpl(this);
		}
		
		@Override
		public ExercisePeriod.ExercisePeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExercisePeriod.ExercisePeriodBuilder prune() {
			if (earliestExerciseDateTenor!=null && !earliestExerciseDateTenor.prune().hasData()) earliestExerciseDateTenor = null;
			if (exerciseFrequency!=null && !exerciseFrequency.prune().hasData()) exerciseFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getEarliestExerciseDateTenor()!=null && getEarliestExerciseDateTenor().hasData()) return true;
			if (getExerciseFrequency()!=null && getExerciseFrequency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExercisePeriod.ExercisePeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExercisePeriod.ExercisePeriodBuilder o = (ExercisePeriod.ExercisePeriodBuilder) other;
			
			merger.mergeRosetta(getEarliestExerciseDateTenor(), o.getEarliestExerciseDateTenor(), this::setEarliestExerciseDateTenor);
			merger.mergeRosetta(getExerciseFrequency(), o.getExerciseFrequency(), this::setExerciseFrequency);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExercisePeriod _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(earliestExerciseDateTenor, _that.getEarliestExerciseDateTenor())) return false;
			if (!Objects.equals(exerciseFrequency, _that.getExerciseFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (earliestExerciseDateTenor != null ? earliestExerciseDateTenor.hashCode() : 0);
			_result = 31 * _result + (exerciseFrequency != null ? exerciseFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExercisePeriodBuilder {" +
				"id=" + this.id + ", " +
				"earliestExerciseDateTenor=" + this.earliestExerciseDateTenor + ", " +
				"exerciseFrequency=" + this.exerciseFrequency +
			'}';
		}
	}
}
