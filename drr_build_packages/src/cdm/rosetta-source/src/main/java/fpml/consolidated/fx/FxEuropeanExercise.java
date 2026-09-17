package fpml.consolidated.fx;

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
import fpml.consolidated.fx.meta.FxEuropeanExerciseMeta;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.Exercise;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Describes the characteristics for European exercise of FX products.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes the characteristics for European exercise of FX products.
 *
 */
@RosettaDataType(value="FxEuropeanExercise", builder=FxEuropeanExercise.FxEuropeanExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxEuropeanExercise", model="fpml", builder=FxEuropeanExercise.FxEuropeanExerciseBuilderImpl.class, version="2.1.1")
public interface FxEuropeanExercise extends Exercise {

	FxEuropeanExerciseMeta metaData = new FxEuropeanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Represents a standard expiry date as defined for an FX OTC option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Represents a standard expiry date as defined for an FX OTC option.
	 *
	 */
	ZonedDateTime getExpiryDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Time at which the option expires on the expiry date, at the specified business center. This component represents the formal definition of option expiry time.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Time at which the option expires on the expiry date, at the specified business center. This component represents the formal definition of option expiry time.
	 *
	 */
	BusinessCenterTime getExpiryTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A code by which the expiry time is known in the market. This element is available to supplement the formal definition of expiry time, and must not be used in absence of the expiryTime element.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A code by which the expiry time is known in the market. This element is available to supplement the formal definition of expiry time, and must not be used in absence of the expiryTime element.
	 *
	 */
	CutName getCutName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which both currencies traded will settle.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which both currencies traded will settle.
	 *
	 */
	ZonedDateTime getValueDate();

	/*********************** Build Methods  ***********************/
	FxEuropeanExercise build();
	
	FxEuropeanExercise.FxEuropeanExerciseBuilder toBuilder();
	
	static FxEuropeanExercise.FxEuropeanExerciseBuilder builder() {
		return new FxEuropeanExercise.FxEuropeanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxEuropeanExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxEuropeanExercise> getType() {
		return FxEuropeanExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
		processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.class, getExpiryTime());
		processRosetta(path.newSubPath("cutName"), processor, CutName.class, getCutName());
		processor.processBasic(path.newSubPath("valueDate"), ZonedDateTime.class, getValueDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxEuropeanExerciseBuilder extends FxEuropeanExercise, Exercise.ExerciseBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpiryTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getExpiryTime();
		CutName.CutNameBuilder getOrCreateCutName();
		@Override
		CutName.CutNameBuilder getCutName();
		@Override
		FxEuropeanExercise.FxEuropeanExerciseBuilder setId(String id);
		FxEuropeanExercise.FxEuropeanExerciseBuilder setExpiryDate(ZonedDateTime expiryDate);
		FxEuropeanExercise.FxEuropeanExerciseBuilder setExpiryTime(BusinessCenterTime expiryTime);
		FxEuropeanExercise.FxEuropeanExerciseBuilder setCutName(CutName cutName);
		FxEuropeanExercise.FxEuropeanExerciseBuilder setValueDate(ZonedDateTime valueDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
			processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpiryTime());
			processRosetta(path.newSubPath("cutName"), processor, CutName.CutNameBuilder.class, getCutName());
			processor.processBasic(path.newSubPath("valueDate"), ZonedDateTime.class, getValueDate(), this);
		}
		

		FxEuropeanExercise.FxEuropeanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of FxEuropeanExercise  ***********************/
	class FxEuropeanExerciseImpl extends Exercise.ExerciseImpl implements FxEuropeanExercise {
		private final ZonedDateTime expiryDate;
		private final BusinessCenterTime expiryTime;
		private final CutName cutName;
		private final ZonedDateTime valueDate;
		
		protected FxEuropeanExerciseImpl(FxEuropeanExercise.FxEuropeanExerciseBuilder builder) {
			super(builder);
			this.expiryDate = builder.getExpiryDate();
			this.expiryTime = ofNullable(builder.getExpiryTime()).map(f->f.build()).orElse(null);
			this.cutName = ofNullable(builder.getCutName()).map(f->f.build()).orElse(null);
			this.valueDate = builder.getValueDate();
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("expiryDate")
		public ZonedDateTime getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("expiryTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryTime")
		public BusinessCenterTime getExpiryTime() {
			return expiryTime;
		}
		
		@Override
		@RosettaAttribute("cutName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cutName")
		public CutName getCutName() {
			return cutName;
		}
		
		@Override
		@RosettaAttribute("valueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valueDate")
		public ZonedDateTime getValueDate() {
			return valueDate;
		}
		
		@Override
		public FxEuropeanExercise build() {
			return this;
		}
		
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder toBuilder() {
			FxEuropeanExercise.FxEuropeanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxEuropeanExercise.FxEuropeanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getExpiryTime()).ifPresent(builder::setExpiryTime);
			ofNullable(getCutName()).ifPresent(builder::setCutName);
			ofNullable(getValueDate()).ifPresent(builder::setValueDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxEuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			if (!Objects.equals(cutName, _that.getCutName())) return false;
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			_result = 31 * _result + (cutName != null ? cutName.hashCode() : 0);
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxEuropeanExercise {" +
				"expiryDate=" + this.expiryDate + ", " +
				"expiryTime=" + this.expiryTime + ", " +
				"cutName=" + this.cutName + ", " +
				"valueDate=" + this.valueDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxEuropeanExercise  ***********************/
	class FxEuropeanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl implements FxEuropeanExercise.FxEuropeanExerciseBuilder {
	
		protected ZonedDateTime expiryDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expiryTime;
		protected CutName.CutNameBuilder cutName;
		protected ZonedDateTime valueDate;
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("expiryDate")
		public ZonedDateTime getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("expiryTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getExpiryTime() {
			return expiryTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpiryTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (expiryTime!=null) {
				result = expiryTime;
			}
			else {
				result = expiryTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cutName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cutName")
		public CutName.CutNameBuilder getCutName() {
			return cutName;
		}
		
		@Override
		public CutName.CutNameBuilder getOrCreateCutName() {
			CutName.CutNameBuilder result;
			if (cutName!=null) {
				result = cutName;
			}
			else {
				result = cutName = CutName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valueDate")
		public ZonedDateTime getValueDate() {
			return valueDate;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("expiryDate")
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder setExpiryDate(ZonedDateTime _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate;
			return this;
		}
		
		@RosettaAttribute("expiryTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryTime")
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder setExpiryTime(BusinessCenterTime _expiryTime) {
			this.expiryTime = _expiryTime == null ? null : _expiryTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cutName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cutName")
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder setCutName(CutName _cutName) {
			this.cutName = _cutName == null ? null : _cutName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valueDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valueDate")
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder setValueDate(ZonedDateTime _valueDate) {
			this.valueDate = _valueDate == null ? null : _valueDate;
			return this;
		}
		
		@Override
		public FxEuropeanExercise build() {
			return new FxEuropeanExercise.FxEuropeanExerciseImpl(this);
		}
		
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder prune() {
			super.prune();
			if (expiryTime!=null && !expiryTime.prune().hasData()) expiryTime = null;
			if (cutName!=null && !cutName.prune().hasData()) cutName = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpiryDate()!=null) return true;
			if (getExpiryTime()!=null && getExpiryTime().hasData()) return true;
			if (getCutName()!=null && getCutName().hasData()) return true;
			if (getValueDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxEuropeanExercise.FxEuropeanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxEuropeanExercise.FxEuropeanExerciseBuilder o = (FxEuropeanExercise.FxEuropeanExerciseBuilder) other;
			
			merger.mergeRosetta(getExpiryTime(), o.getExpiryTime(), this::setExpiryTime);
			merger.mergeRosetta(getCutName(), o.getCutName(), this::setCutName);
			
			merger.mergeBasic(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeBasic(getValueDate(), o.getValueDate(), this::setValueDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxEuropeanExercise _that = getType().cast(o);
		
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			if (!Objects.equals(cutName, _that.getCutName())) return false;
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			_result = 31 * _result + (cutName != null ? cutName.hashCode() : 0);
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxEuropeanExerciseBuilder {" +
				"expiryDate=" + this.expiryDate + ", " +
				"expiryTime=" + this.expiryTime + ", " +
				"cutName=" + this.cutName + ", " +
				"valueDate=" + this.valueDate +
			'}' + " " + super.toString();
		}
	}
}
