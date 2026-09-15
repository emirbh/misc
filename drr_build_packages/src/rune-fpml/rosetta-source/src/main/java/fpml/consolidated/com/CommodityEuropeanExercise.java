package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityEuropeanExerciseMeta;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.Frequency;
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
 * Provision A type for defining exercise procedures associated with a European style exercise of a commodity option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining exercise procedures associated with a European style exercise of a commodity option.
 *
 */
@RosettaDataType(value="CommodityEuropeanExercise", builder=CommodityEuropeanExercise.CommodityEuropeanExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityEuropeanExercise", model="fpml", builder=CommodityEuropeanExercise.CommodityEuropeanExerciseBuilderImpl.class, version="2.1.1")
public interface CommodityEuropeanExercise extends Exercise {

	CommodityEuropeanExerciseMeta metaData = new CommodityEuropeanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The last day within an exercise period for an American style option. For a European style option it is the only day within the exercise period. For an averaging option this is equivalent to the Termination Date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The last day within an exercise period for an American style option. For a European style option it is the only day within the exercise period. For an averaging option this is equivalent to the Termination Date.
	 *
	 */
	List<? extends AdjustableOrRelativeDate> getExpirationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The exercise frequency for the strip.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The exercise frequency for the strip.
	 *
	 */
	Frequency getExerciseFrequency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specific time of day on which the option expires.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specific time of day on which the option expires.
	 *
	 */
	BusinessCenterTime getExpirationTime();

	/*********************** Build Methods  ***********************/
	CommodityEuropeanExercise build();
	
	CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder toBuilder();
	
	static CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder builder() {
		return new CommodityEuropeanExercise.CommodityEuropeanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityEuropeanExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityEuropeanExercise> getType() {
		return CommodityEuropeanExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("exerciseFrequency"), processor, Frequency.class, getExerciseFrequency());
		processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.class, getExpirationTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityEuropeanExerciseBuilder extends CommodityEuropeanExercise, Exercise.ExerciseBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate(int index);
		@Override
		List<? extends AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder> getExpirationDate();
		Frequency.FrequencyBuilder getOrCreateExerciseFrequency();
		@Override
		Frequency.FrequencyBuilder getExerciseFrequency();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpirationTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getExpirationTime();
		@Override
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setId(String id);
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder addExpirationDate(AdjustableOrRelativeDate expirationDate);
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder addExpirationDate(AdjustableOrRelativeDate expirationDate, int idx);
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder addExpirationDate(List<? extends AdjustableOrRelativeDate> expirationDate);
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setExpirationDate(List<? extends AdjustableOrRelativeDate> expirationDate);
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setExerciseFrequency(Frequency exerciseFrequency);
		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("exerciseFrequency"), processor, Frequency.FrequencyBuilder.class, getExerciseFrequency());
			processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpirationTime());
		}
		

		CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityEuropeanExercise  ***********************/
	class CommodityEuropeanExerciseImpl extends Exercise.ExerciseImpl implements CommodityEuropeanExercise {
		private final List<? extends AdjustableOrRelativeDate> expirationDate;
		private final Frequency exerciseFrequency;
		private final BusinessCenterTime expirationTime;
		
		protected CommodityEuropeanExerciseImpl(CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder builder) {
			super(builder);
			this.expirationDate = ofNullable(builder.getExpirationDate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.exerciseFrequency = ofNullable(builder.getExerciseFrequency()).map(f->f.build()).orElse(null);
			this.expirationTime = ofNullable(builder.getExpirationTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("expirationDate")
		public List<? extends AdjustableOrRelativeDate> getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		@RosettaAttribute("exerciseFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseFrequency")
		public Frequency getExerciseFrequency() {
			return exerciseFrequency;
		}
		
		@Override
		@RosettaAttribute("expirationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationTime")
		public BusinessCenterTime getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		public CommodityEuropeanExercise build() {
			return this;
		}
		
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder toBuilder() {
			CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getExerciseFrequency()).ifPresent(builder::setExerciseFrequency);
			ofNullable(getExpirationTime()).ifPresent(builder::setExpirationTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityEuropeanExercise _that = getType().cast(o);
		
			if (!ListEquals.listEquals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(exerciseFrequency, _that.getExerciseFrequency())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (exerciseFrequency != null ? exerciseFrequency.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityEuropeanExercise {" +
				"expirationDate=" + this.expirationDate + ", " +
				"exerciseFrequency=" + this.exerciseFrequency + ", " +
				"expirationTime=" + this.expirationTime +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityEuropeanExercise  ***********************/
	class CommodityEuropeanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl implements CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder {
	
		protected List<AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder> expirationDate = new ArrayList<>();
		protected Frequency.FrequencyBuilder exerciseFrequency;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expirationTime;
		
		@Override
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("expirationDate")
		public List<? extends AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder> getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate(int index) {
			if (expirationDate==null) {
				this.expirationDate = new ArrayList<>();
			}
			return getIndex(expirationDate, index, () -> {
						AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder newExpirationDate = AdjustableOrRelativeDate.builder();
						return newExpirationDate;
					});
		}
		
		@Override
		@RosettaAttribute("exerciseFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseFrequency")
		public Frequency.FrequencyBuilder getExerciseFrequency() {
			return exerciseFrequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreateExerciseFrequency() {
			Frequency.FrequencyBuilder result;
			if (exerciseFrequency!=null) {
				result = exerciseFrequency;
			}
			else {
				result = exerciseFrequency = Frequency.builder();
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("expirationDate")
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder addExpirationDate(AdjustableOrRelativeDate _expirationDate) {
			if (_expirationDate != null) {
				this.expirationDate.add(_expirationDate.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder addExpirationDate(AdjustableOrRelativeDate _expirationDate, int idx) {
			getIndex(this.expirationDate, idx, () -> _expirationDate.toBuilder());
			return this;
		}
		
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder addExpirationDate(List<? extends AdjustableOrRelativeDate> expirationDates) {
			if (expirationDates != null) {
				for (final AdjustableOrRelativeDate toAdd : expirationDates) {
					this.expirationDate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("expirationDate")
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setExpirationDate(List<? extends AdjustableOrRelativeDate> expirationDates) {
			if (expirationDates == null) {
				this.expirationDate = new ArrayList<>();
			} else {
				this.expirationDate = expirationDates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("exerciseFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseFrequency")
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setExerciseFrequency(Frequency _exerciseFrequency) {
			this.exerciseFrequency = _exerciseFrequency == null ? null : _exerciseFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationTime")
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder setExpirationTime(BusinessCenterTime _expirationTime) {
			this.expirationTime = _expirationTime == null ? null : _expirationTime.toBuilder();
			return this;
		}
		
		@Override
		public CommodityEuropeanExercise build() {
			return new CommodityEuropeanExercise.CommodityEuropeanExerciseImpl(this);
		}
		
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder prune() {
			super.prune();
			expirationDate = expirationDate.stream().filter(b->b!=null).<AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (exerciseFrequency!=null && !exerciseFrequency.prune().hasData()) exerciseFrequency = null;
			if (expirationTime!=null && !expirationTime.prune().hasData()) expirationTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExerciseFrequency()!=null && getExerciseFrequency().hasData()) return true;
			if (getExpirationTime()!=null && getExpirationTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder o = (CommodityEuropeanExercise.CommodityEuropeanExerciseBuilder) other;
			
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::getOrCreateExpirationDate);
			merger.mergeRosetta(getExerciseFrequency(), o.getExerciseFrequency(), this::setExerciseFrequency);
			merger.mergeRosetta(getExpirationTime(), o.getExpirationTime(), this::setExpirationTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityEuropeanExercise _that = getType().cast(o);
		
			if (!ListEquals.listEquals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(exerciseFrequency, _that.getExerciseFrequency())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (exerciseFrequency != null ? exerciseFrequency.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityEuropeanExerciseBuilder {" +
				"expirationDate=" + this.expirationDate + ", " +
				"exerciseFrequency=" + this.exerciseFrequency + ", " +
				"expirationTime=" + this.expirationTime +
			'}' + " " + super.toString();
		}
	}
}
