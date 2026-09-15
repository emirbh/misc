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
import fpml.consolidated.fx.meta.FxAmericanExerciseMeta;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.BusinessCenterTime;
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
 * Provision Describes the characteristics for american exercise of FX products.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Describes the characteristics for american exercise of FX products.
 *
 */
@RosettaDataType(value="FxAmericanExercise", builder=FxAmericanExercise.FxAmericanExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAmericanExercise", model="fpml", builder=FxAmericanExercise.FxAmericanExerciseBuilderImpl.class, version="2.1.1")
public interface FxAmericanExercise extends FxDigitalAmericanExercise {

	FxAmericanExerciseMeta metaData = new FxAmericanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Characteristics for multiple exercise.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Characteristics for multiple exercise.
	 *
	 */
	FxMultipleExercise getMultipleExercise();

	/*********************** Build Methods  ***********************/
	FxAmericanExercise build();
	
	FxAmericanExercise.FxAmericanExerciseBuilder toBuilder();
	
	static FxAmericanExercise.FxAmericanExerciseBuilder builder() {
		return new FxAmericanExercise.FxAmericanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAmericanExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAmericanExercise> getType() {
		return FxAmericanExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.class, getCommencementDate());
		processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
		processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.class, getExpiryTime());
		processRosetta(path.newSubPath("cutName"), processor, CutName.class, getCutName());
		processor.processBasic(path.newSubPath("latestValueDate"), ZonedDateTime.class, getLatestValueDate(), this);
		processRosetta(path.newSubPath("multipleExercise"), processor, FxMultipleExercise.class, getMultipleExercise());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAmericanExerciseBuilder extends FxAmericanExercise, FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder {
		FxMultipleExercise.FxMultipleExerciseBuilder getOrCreateMultipleExercise();
		@Override
		FxMultipleExercise.FxMultipleExerciseBuilder getMultipleExercise();
		@Override
		FxAmericanExercise.FxAmericanExerciseBuilder setId(String id);
		@Override
		FxAmericanExercise.FxAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate);
		@Override
		FxAmericanExercise.FxAmericanExerciseBuilder setExpiryDate(ZonedDateTime expiryDate);
		@Override
		FxAmericanExercise.FxAmericanExerciseBuilder setExpiryTime(BusinessCenterTime expiryTime);
		@Override
		FxAmericanExercise.FxAmericanExerciseBuilder setCutName(CutName cutName);
		@Override
		FxAmericanExercise.FxAmericanExerciseBuilder setLatestValueDate(ZonedDateTime latestValueDate);
		FxAmericanExercise.FxAmericanExerciseBuilder setMultipleExercise(FxMultipleExercise multipleExercise);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCommencementDate());
			processor.processBasic(path.newSubPath("expiryDate"), ZonedDateTime.class, getExpiryDate(), this);
			processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpiryTime());
			processRosetta(path.newSubPath("cutName"), processor, CutName.CutNameBuilder.class, getCutName());
			processor.processBasic(path.newSubPath("latestValueDate"), ZonedDateTime.class, getLatestValueDate(), this);
			processRosetta(path.newSubPath("multipleExercise"), processor, FxMultipleExercise.FxMultipleExerciseBuilder.class, getMultipleExercise());
		}
		

		FxAmericanExercise.FxAmericanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of FxAmericanExercise  ***********************/
	class FxAmericanExerciseImpl extends FxDigitalAmericanExercise.FxDigitalAmericanExerciseImpl implements FxAmericanExercise {
		private final FxMultipleExercise multipleExercise;
		
		protected FxAmericanExerciseImpl(FxAmericanExercise.FxAmericanExerciseBuilder builder) {
			super(builder);
			this.multipleExercise = ofNullable(builder.getMultipleExercise()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("multipleExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multipleExercise")
		public FxMultipleExercise getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		public FxAmericanExercise build() {
			return this;
		}
		
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder toBuilder() {
			FxAmericanExercise.FxAmericanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAmericanExercise.FxAmericanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMultipleExercise()).ifPresent(builder::setMultipleExercise);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAmericanExercise {" +
				"multipleExercise=" + this.multipleExercise +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAmericanExercise  ***********************/
	class FxAmericanExerciseBuilderImpl extends FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilderImpl implements FxAmericanExercise.FxAmericanExerciseBuilder {
	
		protected FxMultipleExercise.FxMultipleExerciseBuilder multipleExercise;
		
		@Override
		@RosettaAttribute("multipleExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multipleExercise")
		public FxMultipleExercise.FxMultipleExerciseBuilder getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		public FxMultipleExercise.FxMultipleExerciseBuilder getOrCreateMultipleExercise() {
			FxMultipleExercise.FxMultipleExerciseBuilder result;
			if (multipleExercise!=null) {
				result = multipleExercise;
			}
			else {
				result = multipleExercise = FxMultipleExercise.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("commencementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("commencementDate")
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate _commencementDate) {
			this.commencementDate = _commencementDate == null ? null : _commencementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("expiryDate")
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder setExpiryDate(ZonedDateTime _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate;
			return this;
		}
		
		@RosettaAttribute("expiryTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryTime")
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder setExpiryTime(BusinessCenterTime _expiryTime) {
			this.expiryTime = _expiryTime == null ? null : _expiryTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cutName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cutName")
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder setCutName(CutName _cutName) {
			this.cutName = _cutName == null ? null : _cutName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("latestValueDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("latestValueDate")
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder setLatestValueDate(ZonedDateTime _latestValueDate) {
			this.latestValueDate = _latestValueDate == null ? null : _latestValueDate;
			return this;
		}
		
		@RosettaAttribute("multipleExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multipleExercise")
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder setMultipleExercise(FxMultipleExercise _multipleExercise) {
			this.multipleExercise = _multipleExercise == null ? null : _multipleExercise.toBuilder();
			return this;
		}
		
		@Override
		public FxAmericanExercise build() {
			return new FxAmericanExercise.FxAmericanExerciseImpl(this);
		}
		
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder prune() {
			super.prune();
			if (multipleExercise!=null && !multipleExercise.prune().hasData()) multipleExercise = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMultipleExercise()!=null && getMultipleExercise().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxAmericanExercise.FxAmericanExerciseBuilder o = (FxAmericanExercise.FxAmericanExerciseBuilder) other;
			
			merger.mergeRosetta(getMultipleExercise(), o.getMultipleExercise(), this::setMultipleExercise);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAmericanExerciseBuilder {" +
				"multipleExercise=" + this.multipleExercise +
			'}' + " " + super.toString();
		}
	}
}
