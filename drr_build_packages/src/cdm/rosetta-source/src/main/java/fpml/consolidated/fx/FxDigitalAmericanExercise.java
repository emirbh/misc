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
import fpml.consolidated.fx.meta.FxDigitalAmericanExerciseMeta;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
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
 * Provision Descrines the characteristics for American exercise in FX digital options.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Descrines the characteristics for American exercise in FX digital options.
 *
 */
@RosettaDataType(value="FxDigitalAmericanExercise", builder=FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxDigitalAmericanExercise", model="fpml", builder=FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilderImpl.class, version="2.1.1")
public interface FxDigitalAmericanExercise extends Exercise {

	FxDigitalAmericanExerciseMeta metaData = new FxDigitalAmericanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The earliest date on which the option can be exercised.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The earliest date on which the option can be exercised.
	 *
	 */
	AdjustableOrRelativeDate getCommencementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The latest date on which the option can be exercised.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The latest date on which the option can be exercised.
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
	 * Provision The latest date on which both currencies traded will settle.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The latest date on which both currencies traded will settle.
	 *
	 */
	ZonedDateTime getLatestValueDate();

	/*********************** Build Methods  ***********************/
	FxDigitalAmericanExercise build();
	
	FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder toBuilder();
	
	static FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder builder() {
		return new FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDigitalAmericanExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxDigitalAmericanExercise> getType() {
		return FxDigitalAmericanExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.class, getCommencementDate());
		processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
		processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.class, getExpiryTime());
		processRosetta(path.newSubPath("cutName"), processor, CutName.class, getCutName());
		processor.processBasic(path.newSubPath("latestValueDate"), ZonedDateTime.class, getLatestValueDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDigitalAmericanExerciseBuilder extends FxDigitalAmericanExercise, Exercise.ExerciseBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCommencementDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCommencementDate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpiryTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getExpiryTime();
		CutName.CutNameBuilder getOrCreateCutName();
		@Override
		CutName.CutNameBuilder getCutName();
		@Override
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setId(String id);
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate);
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setExpiryDate(ZonedDateTime expiryDate);
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setExpiryTime(BusinessCenterTime expiryTime);
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setCutName(CutName cutName);
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setLatestValueDate(ZonedDateTime latestValueDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCommencementDate());
			processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
			processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpiryTime());
			processRosetta(path.newSubPath("cutName"), processor, CutName.CutNameBuilder.class, getCutName());
			processor.processBasic(path.newSubPath("latestValueDate"), ZonedDateTime.class, getLatestValueDate(), this);
		}
		

		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of FxDigitalAmericanExercise  ***********************/
	class FxDigitalAmericanExerciseImpl extends Exercise.ExerciseImpl implements FxDigitalAmericanExercise {
		private final AdjustableOrRelativeDate commencementDate;
		private final ZonedDateTime expiryDate;
		private final BusinessCenterTime expiryTime;
		private final CutName cutName;
		private final ZonedDateTime latestValueDate;
		
		protected FxDigitalAmericanExerciseImpl(FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder builder) {
			super(builder);
			this.commencementDate = ofNullable(builder.getCommencementDate()).map(f->f.build()).orElse(null);
			this.expiryDate = builder.getExpiryDate();
			this.expiryTime = ofNullable(builder.getExpiryTime()).map(f->f.build()).orElse(null);
			this.cutName = ofNullable(builder.getCutName()).map(f->f.build()).orElse(null);
			this.latestValueDate = builder.getLatestValueDate();
		}
		
		@Override
		@RosettaAttribute("commencementDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("commencementDate")
		public AdjustableOrRelativeDate getCommencementDate() {
			return commencementDate;
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
		@RosettaAttribute("latestValueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("latestValueDate")
		public ZonedDateTime getLatestValueDate() {
			return latestValueDate;
		}
		
		@Override
		public FxDigitalAmericanExercise build() {
			return this;
		}
		
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder toBuilder() {
			FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommencementDate()).ifPresent(builder::setCommencementDate);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getExpiryTime()).ifPresent(builder::setExpiryTime);
			ofNullable(getCutName()).ifPresent(builder::setCutName);
			ofNullable(getLatestValueDate()).ifPresent(builder::setLatestValueDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxDigitalAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			if (!Objects.equals(cutName, _that.getCutName())) return false;
			if (!Objects.equals(latestValueDate, _that.getLatestValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			_result = 31 * _result + (cutName != null ? cutName.hashCode() : 0);
			_result = 31 * _result + (latestValueDate != null ? latestValueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDigitalAmericanExercise {" +
				"commencementDate=" + this.commencementDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"expiryTime=" + this.expiryTime + ", " +
				"cutName=" + this.cutName + ", " +
				"latestValueDate=" + this.latestValueDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxDigitalAmericanExercise  ***********************/
	class FxDigitalAmericanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl implements FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder commencementDate;
		protected ZonedDateTime expiryDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder expiryTime;
		protected CutName.CutNameBuilder cutName;
		protected ZonedDateTime latestValueDate;
		
		@Override
		@RosettaAttribute("commencementDate")
		@Accessor(AccessorType.GETTER)
		@Required
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
		@RosettaAttribute("latestValueDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("latestValueDate")
		public ZonedDateTime getLatestValueDate() {
			return latestValueDate;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("commencementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("commencementDate")
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate _commencementDate) {
			this.commencementDate = _commencementDate == null ? null : _commencementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("expiryDate")
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setExpiryDate(ZonedDateTime _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate;
			return this;
		}
		
		@RosettaAttribute("expiryTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryTime")
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setExpiryTime(BusinessCenterTime _expiryTime) {
			this.expiryTime = _expiryTime == null ? null : _expiryTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cutName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cutName")
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setCutName(CutName _cutName) {
			this.cutName = _cutName == null ? null : _cutName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("latestValueDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("latestValueDate")
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder setLatestValueDate(ZonedDateTime _latestValueDate) {
			this.latestValueDate = _latestValueDate == null ? null : _latestValueDate;
			return this;
		}
		
		@Override
		public FxDigitalAmericanExercise build() {
			return new FxDigitalAmericanExercise.FxDigitalAmericanExerciseImpl(this);
		}
		
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder prune() {
			super.prune();
			if (commencementDate!=null && !commencementDate.prune().hasData()) commencementDate = null;
			if (expiryTime!=null && !expiryTime.prune().hasData()) expiryTime = null;
			if (cutName!=null && !cutName.prune().hasData()) cutName = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommencementDate()!=null && getCommencementDate().hasData()) return true;
			if (getExpiryDate()!=null) return true;
			if (getExpiryTime()!=null && getExpiryTime().hasData()) return true;
			if (getCutName()!=null && getCutName().hasData()) return true;
			if (getLatestValueDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder o = (FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder) other;
			
			merger.mergeRosetta(getCommencementDate(), o.getCommencementDate(), this::setCommencementDate);
			merger.mergeRosetta(getExpiryTime(), o.getExpiryTime(), this::setExpiryTime);
			merger.mergeRosetta(getCutName(), o.getCutName(), this::setCutName);
			
			merger.mergeBasic(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeBasic(getLatestValueDate(), o.getLatestValueDate(), this::setLatestValueDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxDigitalAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			if (!Objects.equals(cutName, _that.getCutName())) return false;
			if (!Objects.equals(latestValueDate, _that.getLatestValueDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			_result = 31 * _result + (cutName != null ? cutName.hashCode() : 0);
			_result = 31 * _result + (latestValueDate != null ? latestValueDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDigitalAmericanExerciseBuilder {" +
				"commencementDate=" + this.commencementDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"expiryTime=" + this.expiryTime + ", " +
				"cutName=" + this.cutName + ", " +
				"latestValueDate=" + this.latestValueDate +
			'}' + " " + super.toString();
		}
	}
}
