package fpml.consolidated.eqd;

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
import fpml.consolidated.eqd.meta.EquityEuropeanExerciseMeta;
import fpml.consolidated.fpmlenum.TimeTypeEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.Exercise;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type for defining exercise procedures associated with a European style exercise of an equity option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining exercise procedures associated with a European style exercise of an equity option.
 *
 */
@RosettaDataType(value="EquityEuropeanExercise", builder=EquityEuropeanExercise.EquityEuropeanExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EquityEuropeanExercise", model="fpml", builder=EquityEuropeanExercise.EquityEuropeanExerciseBuilderImpl.class, version="2.1.1")
public interface EquityEuropeanExercise extends Exercise {

	EquityEuropeanExerciseMeta metaData = new EquityEuropeanExerciseMeta();

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
	 * Provision The time of day at which the equity option expires, for example the official closing time of the exchange.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The time of day at which the equity option expires, for example the official closing time of the exchange.
	 *
	 */
	TimeTypeEnum getEquityExpirationTimeType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specific time of day at which the equity option expires.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specific time of day at which the equity option expires.
	 *
	 */
	BusinessCenterTime getEquityExpirationTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Expiration time determination method.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Expiration time determination method.
	 *
	 */
	DeterminationMethod getExpirationTimeDetermination();

	/*********************** Build Methods  ***********************/
	EquityEuropeanExercise build();
	
	EquityEuropeanExercise.EquityEuropeanExerciseBuilder toBuilder();
	
	static EquityEuropeanExercise.EquityEuropeanExerciseBuilder builder() {
		return new EquityEuropeanExercise.EquityEuropeanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityEuropeanExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityEuropeanExercise> getType() {
		return EquityEuropeanExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processor.processBasic(path.newSubPath("equityExpirationTimeType"), TimeTypeEnum.class, getEquityExpirationTimeType(), this);
		processRosetta(path.newSubPath("equityExpirationTime"), processor, BusinessCenterTime.class, getEquityExpirationTime());
		processRosetta(path.newSubPath("expirationTimeDetermination"), processor, DeterminationMethod.class, getExpirationTimeDetermination());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityEuropeanExerciseBuilder extends EquityEuropeanExercise, Exercise.ExerciseBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEquityExpirationTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getEquityExpirationTime();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateExpirationTimeDetermination();
		@Override
		DeterminationMethod.DeterminationMethodBuilder getExpirationTimeDetermination();
		@Override
		EquityEuropeanExercise.EquityEuropeanExerciseBuilder setId(String id);
		EquityEuropeanExercise.EquityEuropeanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		EquityEuropeanExercise.EquityEuropeanExerciseBuilder setEquityExpirationTimeType(TimeTypeEnum equityExpirationTimeType);
		EquityEuropeanExercise.EquityEuropeanExerciseBuilder setEquityExpirationTime(BusinessCenterTime equityExpirationTime);
		EquityEuropeanExercise.EquityEuropeanExerciseBuilder setExpirationTimeDetermination(DeterminationMethod expirationTimeDetermination);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processor.processBasic(path.newSubPath("equityExpirationTimeType"), TimeTypeEnum.class, getEquityExpirationTimeType(), this);
			processRosetta(path.newSubPath("equityExpirationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getEquityExpirationTime());
			processRosetta(path.newSubPath("expirationTimeDetermination"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getExpirationTimeDetermination());
		}
		

		EquityEuropeanExercise.EquityEuropeanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of EquityEuropeanExercise  ***********************/
	class EquityEuropeanExerciseImpl extends Exercise.ExerciseImpl implements EquityEuropeanExercise {
		private final AdjustableOrRelativeDate expirationDate;
		private final TimeTypeEnum equityExpirationTimeType;
		private final BusinessCenterTime equityExpirationTime;
		private final DeterminationMethod expirationTimeDetermination;
		
		protected EquityEuropeanExerciseImpl(EquityEuropeanExercise.EquityEuropeanExerciseBuilder builder) {
			super(builder);
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
			this.equityExpirationTimeType = builder.getEquityExpirationTimeType();
			this.equityExpirationTime = ofNullable(builder.getEquityExpirationTime()).map(f->f.build()).orElse(null);
			this.expirationTimeDetermination = ofNullable(builder.getExpirationTimeDetermination()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("equityExpirationTimeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityExpirationTimeType")
		public TimeTypeEnum getEquityExpirationTimeType() {
			return equityExpirationTimeType;
		}
		
		@Override
		@RosettaAttribute("equityExpirationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityExpirationTime")
		public BusinessCenterTime getEquityExpirationTime() {
			return equityExpirationTime;
		}
		
		@Override
		@RosettaAttribute("expirationTimeDetermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationTimeDetermination")
		public DeterminationMethod getExpirationTimeDetermination() {
			return expirationTimeDetermination;
		}
		
		@Override
		public EquityEuropeanExercise build() {
			return this;
		}
		
		@Override
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder toBuilder() {
			EquityEuropeanExercise.EquityEuropeanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityEuropeanExercise.EquityEuropeanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getEquityExpirationTimeType()).ifPresent(builder::setEquityExpirationTimeType);
			ofNullable(getEquityExpirationTime()).ifPresent(builder::setEquityExpirationTime);
			ofNullable(getExpirationTimeDetermination()).ifPresent(builder::setExpirationTimeDetermination);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityEuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(equityExpirationTimeType, _that.getEquityExpirationTimeType())) return false;
			if (!Objects.equals(equityExpirationTime, _that.getEquityExpirationTime())) return false;
			if (!Objects.equals(expirationTimeDetermination, _that.getExpirationTimeDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (equityExpirationTimeType != null ? equityExpirationTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (equityExpirationTime != null ? equityExpirationTime.hashCode() : 0);
			_result = 31 * _result + (expirationTimeDetermination != null ? expirationTimeDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityEuropeanExercise {" +
				"expirationDate=" + this.expirationDate + ", " +
				"equityExpirationTimeType=" + this.equityExpirationTimeType + ", " +
				"equityExpirationTime=" + this.equityExpirationTime + ", " +
				"expirationTimeDetermination=" + this.expirationTimeDetermination +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityEuropeanExercise  ***********************/
	class EquityEuropeanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl implements EquityEuropeanExercise.EquityEuropeanExerciseBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder expirationDate;
		protected TimeTypeEnum equityExpirationTimeType;
		protected BusinessCenterTime.BusinessCenterTimeBuilder equityExpirationTime;
		protected DeterminationMethod.DeterminationMethodBuilder expirationTimeDetermination;
		
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
		@RosettaAttribute("equityExpirationTimeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityExpirationTimeType")
		public TimeTypeEnum getEquityExpirationTimeType() {
			return equityExpirationTimeType;
		}
		
		@Override
		@RosettaAttribute("equityExpirationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityExpirationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getEquityExpirationTime() {
			return equityExpirationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEquityExpirationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (equityExpirationTime!=null) {
				result = equityExpirationTime;
			}
			else {
				result = equityExpirationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationTimeDetermination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationTimeDetermination")
		public DeterminationMethod.DeterminationMethodBuilder getExpirationTimeDetermination() {
			return expirationTimeDetermination;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder getOrCreateExpirationTimeDetermination() {
			DeterminationMethod.DeterminationMethodBuilder result;
			if (expirationTimeDetermination!=null) {
				result = expirationTimeDetermination;
			}
			else {
				result = expirationTimeDetermination = DeterminationMethod.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("expirationDate")
		@Override
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("equityExpirationTimeType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityExpirationTimeType")
		@Override
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder setEquityExpirationTimeType(TimeTypeEnum _equityExpirationTimeType) {
			this.equityExpirationTimeType = _equityExpirationTimeType == null ? null : _equityExpirationTimeType;
			return this;
		}
		
		@RosettaAttribute("equityExpirationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityExpirationTime")
		@Override
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder setEquityExpirationTime(BusinessCenterTime _equityExpirationTime) {
			this.equityExpirationTime = _equityExpirationTime == null ? null : _equityExpirationTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirationTimeDetermination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationTimeDetermination")
		@Override
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder setExpirationTimeDetermination(DeterminationMethod _expirationTimeDetermination) {
			this.expirationTimeDetermination = _expirationTimeDetermination == null ? null : _expirationTimeDetermination.toBuilder();
			return this;
		}
		
		@Override
		public EquityEuropeanExercise build() {
			return new EquityEuropeanExercise.EquityEuropeanExerciseImpl(this);
		}
		
		@Override
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder prune() {
			super.prune();
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			if (equityExpirationTime!=null && !equityExpirationTime.prune().hasData()) equityExpirationTime = null;
			if (expirationTimeDetermination!=null && !expirationTimeDetermination.prune().hasData()) expirationTimeDetermination = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			if (getEquityExpirationTimeType()!=null) return true;
			if (getEquityExpirationTime()!=null && getEquityExpirationTime().hasData()) return true;
			if (getExpirationTimeDetermination()!=null && getExpirationTimeDetermination().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EquityEuropeanExercise.EquityEuropeanExerciseBuilder o = (EquityEuropeanExercise.EquityEuropeanExerciseBuilder) other;
			
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeRosetta(getEquityExpirationTime(), o.getEquityExpirationTime(), this::setEquityExpirationTime);
			merger.mergeRosetta(getExpirationTimeDetermination(), o.getExpirationTimeDetermination(), this::setExpirationTimeDetermination);
			
			merger.mergeBasic(getEquityExpirationTimeType(), o.getEquityExpirationTimeType(), this::setEquityExpirationTimeType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityEuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(equityExpirationTimeType, _that.getEquityExpirationTimeType())) return false;
			if (!Objects.equals(equityExpirationTime, _that.getEquityExpirationTime())) return false;
			if (!Objects.equals(expirationTimeDetermination, _that.getExpirationTimeDetermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (equityExpirationTimeType != null ? equityExpirationTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (equityExpirationTime != null ? equityExpirationTime.hashCode() : 0);
			_result = 31 * _result + (expirationTimeDetermination != null ? expirationTimeDetermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityEuropeanExerciseBuilder {" +
				"expirationDate=" + this.expirationDate + ", " +
				"equityExpirationTimeType=" + this.equityExpirationTimeType + ", " +
				"equityExpirationTime=" + this.equityExpirationTime + ", " +
				"expirationTimeDetermination=" + this.expirationTimeDetermination +
			'}' + " " + super.toString();
		}
	}
}
