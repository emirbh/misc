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
import fpml.consolidated.eqd.meta.EquityAmericanExerciseMeta;
import fpml.consolidated.fpmlenum.TimeTypeEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.SharedAmericanExercise;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type for defining exercise procedures associated with an American style exercise of an equity option. This entity inherits from the type SharedAmericanExercise.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining exercise procedures associated with an American style exercise of an equity option. This entity inherits from the type SharedAmericanExercise.
 *
 */
@RosettaDataType(value="EquityAmericanExercise", builder=EquityAmericanExercise.EquityAmericanExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EquityAmericanExercise", model="fpml", builder=EquityAmericanExercise.EquityAmericanExerciseBuilderImpl.class, version="2.1.1")
public interface EquityAmericanExercise extends SharedAmericanExercise {

	EquityAmericanExerciseMeta metaData = new EquityAmericanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The latest time of day at which the equity option can be exercised, for example the official closing time of the exchange.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The latest time of day at which the equity option can be exercised, for example the official closing time of the exchange.
	 *
	 */
	TimeTypeEnum getLatestExerciseTimeType();
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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The presence of this element indicates that the option may be exercised on different days. It is not applicable to European options.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The presence of this element indicates that the option may be exercised on different days. It is not applicable to European options.
	 *
	 */
	EquityMultipleExercise getEquityMultipleExercise();

	/*********************** Build Methods  ***********************/
	EquityAmericanExercise build();
	
	EquityAmericanExercise.EquityAmericanExerciseBuilder toBuilder();
	
	static EquityAmericanExercise.EquityAmericanExerciseBuilder builder() {
		return new EquityAmericanExercise.EquityAmericanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityAmericanExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityAmericanExercise> getType() {
		return EquityAmericanExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.class, getCommencementDate());
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.class, getLatestExerciseTime());
		processRosetta(path.newSubPath("latestExerciseTimeDetermination"), processor, DeterminationMethod.class, getLatestExerciseTimeDetermination());
		processor.processBasic(path.newSubPath("latestExerciseTimeType"), TimeTypeEnum.class, getLatestExerciseTimeType(), this);
		processor.processBasic(path.newSubPath("equityExpirationTimeType"), TimeTypeEnum.class, getEquityExpirationTimeType(), this);
		processRosetta(path.newSubPath("equityExpirationTime"), processor, BusinessCenterTime.class, getEquityExpirationTime());
		processRosetta(path.newSubPath("expirationTimeDetermination"), processor, DeterminationMethod.class, getExpirationTimeDetermination());
		processRosetta(path.newSubPath("equityMultipleExercise"), processor, EquityMultipleExercise.class, getEquityMultipleExercise());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityAmericanExerciseBuilder extends EquityAmericanExercise, SharedAmericanExercise.SharedAmericanExerciseBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateEquityExpirationTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getEquityExpirationTime();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateExpirationTimeDetermination();
		@Override
		DeterminationMethod.DeterminationMethodBuilder getExpirationTimeDetermination();
		EquityMultipleExercise.EquityMultipleExerciseBuilder getOrCreateEquityMultipleExercise();
		@Override
		EquityMultipleExercise.EquityMultipleExerciseBuilder getEquityMultipleExercise();
		@Override
		EquityAmericanExercise.EquityAmericanExerciseBuilder setId(String id);
		@Override
		EquityAmericanExercise.EquityAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate);
		@Override
		EquityAmericanExercise.EquityAmericanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);
		@Override
		EquityAmericanExercise.EquityAmericanExerciseBuilder setLatestExerciseTime(BusinessCenterTime latestExerciseTime);
		@Override
		EquityAmericanExercise.EquityAmericanExerciseBuilder setLatestExerciseTimeDetermination(DeterminationMethod latestExerciseTimeDetermination);
		EquityAmericanExercise.EquityAmericanExerciseBuilder setLatestExerciseTimeType(TimeTypeEnum latestExerciseTimeType);
		EquityAmericanExercise.EquityAmericanExerciseBuilder setEquityExpirationTimeType(TimeTypeEnum equityExpirationTimeType);
		EquityAmericanExercise.EquityAmericanExerciseBuilder setEquityExpirationTime(BusinessCenterTime equityExpirationTime);
		EquityAmericanExercise.EquityAmericanExerciseBuilder setExpirationTimeDetermination(DeterminationMethod expirationTimeDetermination);
		EquityAmericanExercise.EquityAmericanExerciseBuilder setEquityMultipleExercise(EquityMultipleExercise equityMultipleExercise);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCommencementDate());
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("latestExerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getLatestExerciseTime());
			processRosetta(path.newSubPath("latestExerciseTimeDetermination"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getLatestExerciseTimeDetermination());
			processor.processBasic(path.newSubPath("latestExerciseTimeType"), TimeTypeEnum.class, getLatestExerciseTimeType(), this);
			processor.processBasic(path.newSubPath("equityExpirationTimeType"), TimeTypeEnum.class, getEquityExpirationTimeType(), this);
			processRosetta(path.newSubPath("equityExpirationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getEquityExpirationTime());
			processRosetta(path.newSubPath("expirationTimeDetermination"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getExpirationTimeDetermination());
			processRosetta(path.newSubPath("equityMultipleExercise"), processor, EquityMultipleExercise.EquityMultipleExerciseBuilder.class, getEquityMultipleExercise());
		}
		

		EquityAmericanExercise.EquityAmericanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of EquityAmericanExercise  ***********************/
	class EquityAmericanExerciseImpl extends SharedAmericanExercise.SharedAmericanExerciseImpl implements EquityAmericanExercise {
		private final TimeTypeEnum latestExerciseTimeType;
		private final TimeTypeEnum equityExpirationTimeType;
		private final BusinessCenterTime equityExpirationTime;
		private final DeterminationMethod expirationTimeDetermination;
		private final EquityMultipleExercise equityMultipleExercise;
		
		protected EquityAmericanExerciseImpl(EquityAmericanExercise.EquityAmericanExerciseBuilder builder) {
			super(builder);
			this.latestExerciseTimeType = builder.getLatestExerciseTimeType();
			this.equityExpirationTimeType = builder.getEquityExpirationTimeType();
			this.equityExpirationTime = ofNullable(builder.getEquityExpirationTime()).map(f->f.build()).orElse(null);
			this.expirationTimeDetermination = ofNullable(builder.getExpirationTimeDetermination()).map(f->f.build()).orElse(null);
			this.equityMultipleExercise = ofNullable(builder.getEquityMultipleExercise()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("latestExerciseTimeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("latestExerciseTimeType")
		public TimeTypeEnum getLatestExerciseTimeType() {
			return latestExerciseTimeType;
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
		@RosettaAttribute("equityMultipleExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityMultipleExercise")
		public EquityMultipleExercise getEquityMultipleExercise() {
			return equityMultipleExercise;
		}
		
		@Override
		public EquityAmericanExercise build() {
			return this;
		}
		
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder toBuilder() {
			EquityAmericanExercise.EquityAmericanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityAmericanExercise.EquityAmericanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLatestExerciseTimeType()).ifPresent(builder::setLatestExerciseTimeType);
			ofNullable(getEquityExpirationTimeType()).ifPresent(builder::setEquityExpirationTimeType);
			ofNullable(getEquityExpirationTime()).ifPresent(builder::setEquityExpirationTime);
			ofNullable(getExpirationTimeDetermination()).ifPresent(builder::setExpirationTimeDetermination);
			ofNullable(getEquityMultipleExercise()).ifPresent(builder::setEquityMultipleExercise);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(latestExerciseTimeType, _that.getLatestExerciseTimeType())) return false;
			if (!Objects.equals(equityExpirationTimeType, _that.getEquityExpirationTimeType())) return false;
			if (!Objects.equals(equityExpirationTime, _that.getEquityExpirationTime())) return false;
			if (!Objects.equals(expirationTimeDetermination, _that.getExpirationTimeDetermination())) return false;
			if (!Objects.equals(equityMultipleExercise, _that.getEquityMultipleExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (latestExerciseTimeType != null ? latestExerciseTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (equityExpirationTimeType != null ? equityExpirationTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (equityExpirationTime != null ? equityExpirationTime.hashCode() : 0);
			_result = 31 * _result + (expirationTimeDetermination != null ? expirationTimeDetermination.hashCode() : 0);
			_result = 31 * _result + (equityMultipleExercise != null ? equityMultipleExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityAmericanExercise {" +
				"latestExerciseTimeType=" + this.latestExerciseTimeType + ", " +
				"equityExpirationTimeType=" + this.equityExpirationTimeType + ", " +
				"equityExpirationTime=" + this.equityExpirationTime + ", " +
				"expirationTimeDetermination=" + this.expirationTimeDetermination + ", " +
				"equityMultipleExercise=" + this.equityMultipleExercise +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquityAmericanExercise  ***********************/
	class EquityAmericanExerciseBuilderImpl extends SharedAmericanExercise.SharedAmericanExerciseBuilderImpl implements EquityAmericanExercise.EquityAmericanExerciseBuilder {
	
		protected TimeTypeEnum latestExerciseTimeType;
		protected TimeTypeEnum equityExpirationTimeType;
		protected BusinessCenterTime.BusinessCenterTimeBuilder equityExpirationTime;
		protected DeterminationMethod.DeterminationMethodBuilder expirationTimeDetermination;
		protected EquityMultipleExercise.EquityMultipleExerciseBuilder equityMultipleExercise;
		
		@Override
		@RosettaAttribute("latestExerciseTimeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("latestExerciseTimeType")
		public TimeTypeEnum getLatestExerciseTimeType() {
			return latestExerciseTimeType;
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
		
		@Override
		@RosettaAttribute("equityMultipleExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityMultipleExercise")
		public EquityMultipleExercise.EquityMultipleExerciseBuilder getEquityMultipleExercise() {
			return equityMultipleExercise;
		}
		
		@Override
		public EquityMultipleExercise.EquityMultipleExerciseBuilder getOrCreateEquityMultipleExercise() {
			EquityMultipleExercise.EquityMultipleExerciseBuilder result;
			if (equityMultipleExercise!=null) {
				result = equityMultipleExercise;
			}
			else {
				result = equityMultipleExercise = EquityMultipleExercise.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("commencementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commencementDate")
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate _commencementDate) {
			this.commencementDate = _commencementDate == null ? null : _commencementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("expirationDate")
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setExpirationDate(AdjustableOrRelativeDate _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("latestExerciseTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("latestExerciseTime")
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setLatestExerciseTime(BusinessCenterTime _latestExerciseTime) {
			this.latestExerciseTime = _latestExerciseTime == null ? null : _latestExerciseTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("latestExerciseTimeDetermination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("latestExerciseTimeDetermination")
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setLatestExerciseTimeDetermination(DeterminationMethod _latestExerciseTimeDetermination) {
			this.latestExerciseTimeDetermination = _latestExerciseTimeDetermination == null ? null : _latestExerciseTimeDetermination.toBuilder();
			return this;
		}
		
		@RosettaAttribute("latestExerciseTimeType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("latestExerciseTimeType")
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setLatestExerciseTimeType(TimeTypeEnum _latestExerciseTimeType) {
			this.latestExerciseTimeType = _latestExerciseTimeType == null ? null : _latestExerciseTimeType;
			return this;
		}
		
		@RosettaAttribute("equityExpirationTimeType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityExpirationTimeType")
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setEquityExpirationTimeType(TimeTypeEnum _equityExpirationTimeType) {
			this.equityExpirationTimeType = _equityExpirationTimeType == null ? null : _equityExpirationTimeType;
			return this;
		}
		
		@RosettaAttribute("equityExpirationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityExpirationTime")
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setEquityExpirationTime(BusinessCenterTime _equityExpirationTime) {
			this.equityExpirationTime = _equityExpirationTime == null ? null : _equityExpirationTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expirationTimeDetermination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationTimeDetermination")
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setExpirationTimeDetermination(DeterminationMethod _expirationTimeDetermination) {
			this.expirationTimeDetermination = _expirationTimeDetermination == null ? null : _expirationTimeDetermination.toBuilder();
			return this;
		}
		
		@RosettaAttribute("equityMultipleExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityMultipleExercise")
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder setEquityMultipleExercise(EquityMultipleExercise _equityMultipleExercise) {
			this.equityMultipleExercise = _equityMultipleExercise == null ? null : _equityMultipleExercise.toBuilder();
			return this;
		}
		
		@Override
		public EquityAmericanExercise build() {
			return new EquityAmericanExercise.EquityAmericanExerciseImpl(this);
		}
		
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder prune() {
			super.prune();
			if (equityExpirationTime!=null && !equityExpirationTime.prune().hasData()) equityExpirationTime = null;
			if (expirationTimeDetermination!=null && !expirationTimeDetermination.prune().hasData()) expirationTimeDetermination = null;
			if (equityMultipleExercise!=null && !equityMultipleExercise.prune().hasData()) equityMultipleExercise = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLatestExerciseTimeType()!=null) return true;
			if (getEquityExpirationTimeType()!=null) return true;
			if (getEquityExpirationTime()!=null && getEquityExpirationTime().hasData()) return true;
			if (getExpirationTimeDetermination()!=null && getExpirationTimeDetermination().hasData()) return true;
			if (getEquityMultipleExercise()!=null && getEquityMultipleExercise().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EquityAmericanExercise.EquityAmericanExerciseBuilder o = (EquityAmericanExercise.EquityAmericanExerciseBuilder) other;
			
			merger.mergeRosetta(getEquityExpirationTime(), o.getEquityExpirationTime(), this::setEquityExpirationTime);
			merger.mergeRosetta(getExpirationTimeDetermination(), o.getExpirationTimeDetermination(), this::setExpirationTimeDetermination);
			merger.mergeRosetta(getEquityMultipleExercise(), o.getEquityMultipleExercise(), this::setEquityMultipleExercise);
			
			merger.mergeBasic(getLatestExerciseTimeType(), o.getLatestExerciseTimeType(), this::setLatestExerciseTimeType);
			merger.mergeBasic(getEquityExpirationTimeType(), o.getEquityExpirationTimeType(), this::setEquityExpirationTimeType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquityAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(latestExerciseTimeType, _that.getLatestExerciseTimeType())) return false;
			if (!Objects.equals(equityExpirationTimeType, _that.getEquityExpirationTimeType())) return false;
			if (!Objects.equals(equityExpirationTime, _that.getEquityExpirationTime())) return false;
			if (!Objects.equals(expirationTimeDetermination, _that.getExpirationTimeDetermination())) return false;
			if (!Objects.equals(equityMultipleExercise, _that.getEquityMultipleExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (latestExerciseTimeType != null ? latestExerciseTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (equityExpirationTimeType != null ? equityExpirationTimeType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (equityExpirationTime != null ? equityExpirationTime.hashCode() : 0);
			_result = 31 * _result + (expirationTimeDetermination != null ? expirationTimeDetermination.hashCode() : 0);
			_result = 31 * _result + (equityMultipleExercise != null ? equityMultipleExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityAmericanExerciseBuilder {" +
				"latestExerciseTimeType=" + this.latestExerciseTimeType + ", " +
				"equityExpirationTimeType=" + this.equityExpirationTimeType + ", " +
				"equityExpirationTime=" + this.equityExpirationTime + ", " +
				"expirationTimeDetermination=" + this.expirationTimeDetermination + ", " +
				"equityMultipleExercise=" + this.equityMultipleExercise +
			'}' + " " + super.toString();
		}
	}
}
