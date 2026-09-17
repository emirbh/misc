package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.SwaptionAdjustedDatesMeta;
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
 * Provision A type describing the adjusted dates associated with swaption exercise and settlement.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the adjusted dates associated with swaption exercise and settlement.
 *
 */
@RosettaDataType(value="SwaptionAdjustedDates", builder=SwaptionAdjustedDates.SwaptionAdjustedDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SwaptionAdjustedDates", model="fpml", builder=SwaptionAdjustedDates.SwaptionAdjustedDatesBuilderImpl.class, version="2.1.1")
public interface SwaptionAdjustedDates extends RosettaModelObject {

	SwaptionAdjustedDatesMeta metaData = new SwaptionAdjustedDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The adjusted dates associated with an individual swaption exercise date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The adjusted dates associated with an individual swaption exercise date.
	 *
	 */
	List<? extends ExerciseEvent> getExerciseEvent();

	/*********************** Build Methods  ***********************/
	SwaptionAdjustedDates build();
	
	SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder toBuilder();
	
	static SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder builder() {
		return new SwaptionAdjustedDates.SwaptionAdjustedDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SwaptionAdjustedDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SwaptionAdjustedDates> getType() {
		return SwaptionAdjustedDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("exerciseEvent"), processor, ExerciseEvent.class, getExerciseEvent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SwaptionAdjustedDatesBuilder extends SwaptionAdjustedDates, RosettaModelObjectBuilder {
		ExerciseEvent.ExerciseEventBuilder getOrCreateExerciseEvent(int index);
		@Override
		List<? extends ExerciseEvent.ExerciseEventBuilder> getExerciseEvent();
		SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder addExerciseEvent(ExerciseEvent exerciseEvent);
		SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder addExerciseEvent(ExerciseEvent exerciseEvent, int idx);
		SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder addExerciseEvent(List<? extends ExerciseEvent> exerciseEvent);
		SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder setExerciseEvent(List<? extends ExerciseEvent> exerciseEvent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("exerciseEvent"), processor, ExerciseEvent.ExerciseEventBuilder.class, getExerciseEvent());
		}
		

		SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder prune();
	}

	/*********************** Immutable Implementation of SwaptionAdjustedDates  ***********************/
	class SwaptionAdjustedDatesImpl implements SwaptionAdjustedDates {
		private final List<? extends ExerciseEvent> exerciseEvent;
		
		protected SwaptionAdjustedDatesImpl(SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder builder) {
			this.exerciseEvent = ofNullable(builder.getExerciseEvent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exerciseEvent")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("exerciseEvent")
		public List<? extends ExerciseEvent> getExerciseEvent() {
			return exerciseEvent;
		}
		
		@Override
		public SwaptionAdjustedDates build() {
			return this;
		}
		
		@Override
		public SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder toBuilder() {
			SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder builder) {
			ofNullable(getExerciseEvent()).ifPresent(builder::setExerciseEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SwaptionAdjustedDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(exerciseEvent, _that.getExerciseEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseEvent != null ? exerciseEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwaptionAdjustedDates {" +
				"exerciseEvent=" + this.exerciseEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of SwaptionAdjustedDates  ***********************/
	class SwaptionAdjustedDatesBuilderImpl implements SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder {
	
		protected List<ExerciseEvent.ExerciseEventBuilder> exerciseEvent = new ArrayList<>();
		
		@Override
		@RosettaAttribute("exerciseEvent")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("exerciseEvent")
		public List<? extends ExerciseEvent.ExerciseEventBuilder> getExerciseEvent() {
			return exerciseEvent;
		}
		
		@Override
		public ExerciseEvent.ExerciseEventBuilder getOrCreateExerciseEvent(int index) {
			if (exerciseEvent==null) {
				this.exerciseEvent = new ArrayList<>();
			}
			return getIndex(exerciseEvent, index, () -> {
						ExerciseEvent.ExerciseEventBuilder newExerciseEvent = ExerciseEvent.builder();
						return newExerciseEvent;
					});
		}
		
		@RosettaAttribute("exerciseEvent")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("exerciseEvent")
		@Override
		public SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder addExerciseEvent(ExerciseEvent _exerciseEvent) {
			if (_exerciseEvent != null) {
				this.exerciseEvent.add(_exerciseEvent.toBuilder());
			}
			return this;
		}
		
		@Override
		public SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder addExerciseEvent(ExerciseEvent _exerciseEvent, int idx) {
			getIndex(this.exerciseEvent, idx, () -> _exerciseEvent.toBuilder());
			return this;
		}
		
		@Override
		public SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder addExerciseEvent(List<? extends ExerciseEvent> exerciseEvents) {
			if (exerciseEvents != null) {
				for (final ExerciseEvent toAdd : exerciseEvents) {
					this.exerciseEvent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("exerciseEvent")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("exerciseEvent")
		@Override
		public SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder setExerciseEvent(List<? extends ExerciseEvent> exerciseEvents) {
			if (exerciseEvents == null) {
				this.exerciseEvent = new ArrayList<>();
			} else {
				this.exerciseEvent = exerciseEvents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SwaptionAdjustedDates build() {
			return new SwaptionAdjustedDates.SwaptionAdjustedDatesImpl(this);
		}
		
		@Override
		public SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder prune() {
			exerciseEvent = exerciseEvent.stream().filter(b->b!=null).<ExerciseEvent.ExerciseEventBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExerciseEvent()!=null && getExerciseEvent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder o = (SwaptionAdjustedDates.SwaptionAdjustedDatesBuilder) other;
			
			merger.mergeRosetta(getExerciseEvent(), o.getExerciseEvent(), this::getOrCreateExerciseEvent);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SwaptionAdjustedDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(exerciseEvent, _that.getExerciseEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseEvent != null ? exerciseEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwaptionAdjustedDatesBuilder {" +
				"exerciseEvent=" + this.exerciseEvent +
			'}';
		}
	}
}
