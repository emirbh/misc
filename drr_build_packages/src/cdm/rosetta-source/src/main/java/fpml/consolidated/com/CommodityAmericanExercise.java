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
import fpml.consolidated.com.meta.CommodityAmericanExerciseMeta;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.DeterminationMethod;
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
 * Provision A type for defining exercise procedures associated with an American style exercise of a commodity option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining exercise procedures associated with an American style exercise of a commodity option.
 *
 */
@RosettaDataType(value="CommodityAmericanExercise", builder=CommodityAmericanExercise.CommodityAmericanExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityAmericanExercise", model="fpml", builder=CommodityAmericanExercise.CommodityAmericanExerciseBuilderImpl.class, version="2.1.1")
public interface CommodityAmericanExercise extends Exercise {

	CommodityAmericanExerciseMeta metaData = new CommodityAmericanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes the American exercise periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes the American exercise periods.
	 *
	 */
	List<? extends CommodityExercisePeriods> getExercisePeriod();
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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The presence of this element indicates that the option may be partially exercised. It is not applicable to European or Asian options.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The presence of this element indicates that the option may be partially exercised. It is not applicable to European or Asian options.
	 *
	 */
	CommodityMultipleExercise getMultipleExercise();

	/*********************** Build Methods  ***********************/
	CommodityAmericanExercise build();
	
	CommodityAmericanExercise.CommodityAmericanExerciseBuilder toBuilder();
	
	static CommodityAmericanExercise.CommodityAmericanExerciseBuilder builder() {
		return new CommodityAmericanExercise.CommodityAmericanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityAmericanExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityAmericanExercise> getType() {
		return CommodityAmericanExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("exercisePeriod"), processor, CommodityExercisePeriods.class, getExercisePeriod());
		processRosetta(path.newSubPath("exerciseFrequency"), processor, Frequency.class, getExerciseFrequency());
		processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.class, getLatestExerciseTime());
		processRosetta(path.newSubPath("latestExerciseTimeDetermination"), processor, DeterminationMethod.class, getLatestExerciseTimeDetermination());
		processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.class, getExpirationTime());
		processRosetta(path.newSubPath("multipleExercise"), processor, CommodityMultipleExercise.class, getMultipleExercise());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityAmericanExerciseBuilder extends CommodityAmericanExercise, Exercise.ExerciseBuilder {
		CommodityExercisePeriods.CommodityExercisePeriodsBuilder getOrCreateExercisePeriod(int index);
		@Override
		List<? extends CommodityExercisePeriods.CommodityExercisePeriodsBuilder> getExercisePeriod();
		Frequency.FrequencyBuilder getOrCreateExerciseFrequency();
		@Override
		Frequency.FrequencyBuilder getExerciseFrequency();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateLatestExerciseTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getLatestExerciseTime();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateLatestExerciseTimeDetermination();
		@Override
		DeterminationMethod.DeterminationMethodBuilder getLatestExerciseTimeDetermination();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpirationTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getExpirationTime();
		CommodityMultipleExercise.CommodityMultipleExerciseBuilder getOrCreateMultipleExercise();
		@Override
		CommodityMultipleExercise.CommodityMultipleExerciseBuilder getMultipleExercise();
		@Override
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder setId(String id);
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder addExercisePeriod(CommodityExercisePeriods exercisePeriod);
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder addExercisePeriod(CommodityExercisePeriods exercisePeriod, int idx);
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder addExercisePeriod(List<? extends CommodityExercisePeriods> exercisePeriod);
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder setExercisePeriod(List<? extends CommodityExercisePeriods> exercisePeriod);
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder setExerciseFrequency(Frequency exerciseFrequency);
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime);
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder setLatestExerciseTimeDetermination(DeterminationMethod latestExerciseTimeDetermination);
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder setExpirationTime(BusinessCenterTime expirationTime);
		CommodityAmericanExercise.CommodityAmericanExerciseBuilder setMultipleExercise(CommodityMultipleExercise multipleExercise);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("exercisePeriod"), processor, CommodityExercisePeriods.CommodityExercisePeriodsBuilder.class, getExercisePeriod());
			processRosetta(path.newSubPath("exerciseFrequency"), processor, Frequency.FrequencyBuilder.class, getExerciseFrequency());
			processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getLatestExerciseTime());
			processRosetta(path.newSubPath("latestExerciseTimeDetermination"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getLatestExerciseTimeDetermination());
			processRosetta(path.newSubPath("expirationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpirationTime());
			processRosetta(path.newSubPath("multipleExercise"), processor, CommodityMultipleExercise.CommodityMultipleExerciseBuilder.class, getMultipleExercise());
		}
		

		CommodityAmericanExercise.CommodityAmericanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityAmericanExercise  ***********************/
	class CommodityAmericanExerciseImpl extends Exercise.ExerciseImpl implements CommodityAmericanExercise {
		private final List<? extends CommodityExercisePeriods> exercisePeriod;
		private final Frequency exerciseFrequency;
		private final BusinessCenterTime latestExerciseTime;
		private final DeterminationMethod latestExerciseTimeDetermination;
		private final BusinessCenterTime expirationTime;
		private final CommodityMultipleExercise multipleExercise;
		
		protected CommodityAmericanExerciseImpl(CommodityAmericanExercise.CommodityAmericanExerciseBuilder builder) {
			super(builder);
			this.exercisePeriod = ofNullable(builder.getExercisePeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.exerciseFrequency = ofNullable(builder.getExerciseFrequency()).map(f->f.build()).orElse(null);
			this.latestExerciseTime = ofNullable(builder.getLatestExerciseTime()).map(f->f.build()).orElse(null);
			this.latestExerciseTimeDetermination = ofNullable(builder.getLatestExerciseTimeDetermination()).map(f->f.build()).orElse(null);
			this.expirationTime = ofNullable(builder.getExpirationTime()).map(f->f.build()).orElse(null);
			this.multipleExercise = ofNullable(builder.getMultipleExercise()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exercisePeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("exercisePeriod")
		public List<? extends CommodityExercisePeriods> getExercisePeriod() {
			return exercisePeriod;
		}
		
		@Override
		@RosettaAttribute("exerciseFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseFrequency")
		public Frequency getExerciseFrequency() {
			return exerciseFrequency;
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
		public CommodityMultipleExercise getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		public CommodityAmericanExercise build() {
			return this;
		}
		
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder toBuilder() {
			CommodityAmericanExercise.CommodityAmericanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityAmericanExercise.CommodityAmericanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExercisePeriod()).ifPresent(builder::setExercisePeriod);
			ofNullable(getExerciseFrequency()).ifPresent(builder::setExerciseFrequency);
			ofNullable(getLatestExerciseTime()).ifPresent(builder::setLatestExerciseTime);
			ofNullable(getLatestExerciseTimeDetermination()).ifPresent(builder::setLatestExerciseTimeDetermination);
			ofNullable(getExpirationTime()).ifPresent(builder::setExpirationTime);
			ofNullable(getMultipleExercise()).ifPresent(builder::setMultipleExercise);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityAmericanExercise _that = getType().cast(o);
		
			if (!ListEquals.listEquals(exercisePeriod, _that.getExercisePeriod())) return false;
			if (!Objects.equals(exerciseFrequency, _that.getExerciseFrequency())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(latestExerciseTimeDetermination, _that.getLatestExerciseTimeDetermination())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exercisePeriod != null ? exercisePeriod.hashCode() : 0);
			_result = 31 * _result + (exerciseFrequency != null ? exerciseFrequency.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTimeDetermination != null ? latestExerciseTimeDetermination.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityAmericanExercise {" +
				"exercisePeriod=" + this.exercisePeriod + ", " +
				"exerciseFrequency=" + this.exerciseFrequency + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"latestExerciseTimeDetermination=" + this.latestExerciseTimeDetermination + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"multipleExercise=" + this.multipleExercise +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityAmericanExercise  ***********************/
	class CommodityAmericanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl implements CommodityAmericanExercise.CommodityAmericanExerciseBuilder {
	
		protected List<CommodityExercisePeriods.CommodityExercisePeriodsBuilder> exercisePeriod = new ArrayList<>();
		protected Frequency.FrequencyBuilder exerciseFrequency;
		protected BusinessCenterTime.BusinessCenterTimeBuilder latestExerciseTime;
		protected DeterminationMethod.DeterminationMethodBuilder latestExerciseTimeDetermination;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expirationTime;
		protected CommodityMultipleExercise.CommodityMultipleExerciseBuilder multipleExercise;
		
		@Override
		@RosettaAttribute("exercisePeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("exercisePeriod")
		public List<? extends CommodityExercisePeriods.CommodityExercisePeriodsBuilder> getExercisePeriod() {
			return exercisePeriod;
		}
		
		@Override
		public CommodityExercisePeriods.CommodityExercisePeriodsBuilder getOrCreateExercisePeriod(int index) {
			if (exercisePeriod==null) {
				this.exercisePeriod = new ArrayList<>();
			}
			return getIndex(exercisePeriod, index, () -> {
						CommodityExercisePeriods.CommodityExercisePeriodsBuilder newExercisePeriod = CommodityExercisePeriods.builder();
						return newExercisePeriod;
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
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		public CommodityMultipleExercise.CommodityMultipleExerciseBuilder getOrCreateMultipleExercise() {
			CommodityMultipleExercise.CommodityMultipleExerciseBuilder result;
			if (multipleExercise!=null) {
				result = multipleExercise;
			}
			else {
				result = multipleExercise = CommodityMultipleExercise.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("exercisePeriod")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("exercisePeriod")
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder addExercisePeriod(CommodityExercisePeriods _exercisePeriod) {
			if (_exercisePeriod != null) {
				this.exercisePeriod.add(_exercisePeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder addExercisePeriod(CommodityExercisePeriods _exercisePeriod, int idx) {
			getIndex(this.exercisePeriod, idx, () -> _exercisePeriod.toBuilder());
			return this;
		}
		
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder addExercisePeriod(List<? extends CommodityExercisePeriods> exercisePeriods) {
			if (exercisePeriods != null) {
				for (final CommodityExercisePeriods toAdd : exercisePeriods) {
					this.exercisePeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("exercisePeriod")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("exercisePeriod")
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder setExercisePeriod(List<? extends CommodityExercisePeriods> exercisePeriods) {
			if (exercisePeriods == null) {
				this.exercisePeriod = new ArrayList<>();
			} else {
				this.exercisePeriod = exercisePeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("exerciseFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseFrequency")
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder setExerciseFrequency(Frequency _exerciseFrequency) {
			this.exerciseFrequency = _exerciseFrequency == null ? null : _exerciseFrequency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("latestExerciseTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("latestExerciseTime")
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder setLatestExerciseTime(BusinessCenterTime _latestExerciseTime) {
			this.latestExerciseTime = _latestExerciseTime == null ? null : _latestExerciseTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("latestExerciseTimeDetermination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("latestExerciseTimeDetermination")
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder setLatestExerciseTimeDetermination(DeterminationMethod _latestExerciseTimeDetermination) {
			this.latestExerciseTimeDetermination = _latestExerciseTimeDetermination == null ? null : _latestExerciseTimeDetermination.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationTime")
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder setExpirationTime(BusinessCenterTime _expirationTime) {
			this.expirationTime = _expirationTime == null ? null : _expirationTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("multipleExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multipleExercise")
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder setMultipleExercise(CommodityMultipleExercise _multipleExercise) {
			this.multipleExercise = _multipleExercise == null ? null : _multipleExercise.toBuilder();
			return this;
		}
		
		@Override
		public CommodityAmericanExercise build() {
			return new CommodityAmericanExercise.CommodityAmericanExerciseImpl(this);
		}
		
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder prune() {
			super.prune();
			exercisePeriod = exercisePeriod.stream().filter(b->b!=null).<CommodityExercisePeriods.CommodityExercisePeriodsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (exerciseFrequency!=null && !exerciseFrequency.prune().hasData()) exerciseFrequency = null;
			if (latestExerciseTime!=null && !latestExerciseTime.prune().hasData()) latestExerciseTime = null;
			if (latestExerciseTimeDetermination!=null && !latestExerciseTimeDetermination.prune().hasData()) latestExerciseTimeDetermination = null;
			if (expirationTime!=null && !expirationTime.prune().hasData()) expirationTime = null;
			if (multipleExercise!=null && !multipleExercise.prune().hasData()) multipleExercise = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExercisePeriod()!=null && getExercisePeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExerciseFrequency()!=null && getExerciseFrequency().hasData()) return true;
			if (getLatestExerciseTime()!=null && getLatestExerciseTime().hasData()) return true;
			if (getLatestExerciseTimeDetermination()!=null && getLatestExerciseTimeDetermination().hasData()) return true;
			if (getExpirationTime()!=null && getExpirationTime().hasData()) return true;
			if (getMultipleExercise()!=null && getMultipleExercise().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityAmericanExercise.CommodityAmericanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityAmericanExercise.CommodityAmericanExerciseBuilder o = (CommodityAmericanExercise.CommodityAmericanExerciseBuilder) other;
			
			merger.mergeRosetta(getExercisePeriod(), o.getExercisePeriod(), this::getOrCreateExercisePeriod);
			merger.mergeRosetta(getExerciseFrequency(), o.getExerciseFrequency(), this::setExerciseFrequency);
			merger.mergeRosetta(getLatestExerciseTime(), o.getLatestExerciseTime(), this::setLatestExerciseTime);
			merger.mergeRosetta(getLatestExerciseTimeDetermination(), o.getLatestExerciseTimeDetermination(), this::setLatestExerciseTimeDetermination);
			merger.mergeRosetta(getExpirationTime(), o.getExpirationTime(), this::setExpirationTime);
			merger.mergeRosetta(getMultipleExercise(), o.getMultipleExercise(), this::setMultipleExercise);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityAmericanExercise _that = getType().cast(o);
		
			if (!ListEquals.listEquals(exercisePeriod, _that.getExercisePeriod())) return false;
			if (!Objects.equals(exerciseFrequency, _that.getExerciseFrequency())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(latestExerciseTimeDetermination, _that.getLatestExerciseTimeDetermination())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exercisePeriod != null ? exercisePeriod.hashCode() : 0);
			_result = 31 * _result + (exerciseFrequency != null ? exerciseFrequency.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTimeDetermination != null ? latestExerciseTimeDetermination.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityAmericanExerciseBuilder {" +
				"exercisePeriod=" + this.exercisePeriod + ", " +
				"exerciseFrequency=" + this.exerciseFrequency + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"latestExerciseTimeDetermination=" + this.latestExerciseTimeDetermination + ", " +
				"expirationTime=" + this.expirationTime + ", " +
				"multipleExercise=" + this.multipleExercise +
			'}' + " " + super.toString();
		}
	}
}
