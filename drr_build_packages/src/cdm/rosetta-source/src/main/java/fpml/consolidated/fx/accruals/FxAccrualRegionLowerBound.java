package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fpmlenum.FxRegionLowerBoundDirectionEnum;
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.fx.accruals.meta.FxAccrualRegionLowerBoundMeta;
import fpml.consolidated.fx.targets.FxLevel;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="FxAccrualRegionLowerBound", builder=FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrualRegionLowerBound", model="fpml", builder=FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilderImpl.class, version="2.1.1")
public interface FxAccrualRegionLowerBound extends RosettaModelObject {

	FxAccrualRegionLowerBoundMeta metaData = new FxAccrualRegionLowerBoundMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Lower Bound Direction. It only contains the AtOrAbove and Above values.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Lower Bound Direction. It only contains the AtOrAbove and Above values.
	 *
	 */
	FxRegionLowerBoundDirectionEnum getCondition();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Level expressed as a level.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Level expressed as a level.
	 *
	 */
	FxLevel getLevel();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Quoted Currency Pair that is used accross the product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Quoted Currency Pair that is used accross the product.
	 *
	 */
	QuoteBasisEnum getQuoteBasis();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a strike defined within the FxAccrualForward and FxAccrualOption products.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a strike defined within the FxAccrualForward and FxAccrualOption products.
	 *
	 */
	FxAccrualStrikeReference getStrikeReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to an average rate defined within the FxAccrualForward and FxAccrualOption products.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to an average rate defined within the FxAccrualForward and FxAccrualOption products.
	 *
	 */
	FxAccrualAverageStrikeReference getAverageStrikeReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a trigger defined within the FxAccrualDigitalOption product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a trigger defined within the FxAccrualDigitalOption product.
	 *
	 */
	FxAccrualTriggerReference getTriggerReference();

	/*********************** Build Methods  ***********************/
	FxAccrualRegionLowerBound build();
	
	FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder toBuilder();
	
	static FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder builder() {
		return new FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualRegionLowerBound> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrualRegionLowerBound> getType() {
		return FxAccrualRegionLowerBound.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("condition"), FxRegionLowerBoundDirectionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("level"), processor, FxLevel.class, getLevel());
		processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
		processRosetta(path.newSubPath("strikeReference"), processor, FxAccrualStrikeReference.class, getStrikeReference());
		processRosetta(path.newSubPath("averageStrikeReference"), processor, FxAccrualAverageStrikeReference.class, getAverageStrikeReference());
		processRosetta(path.newSubPath("triggerReference"), processor, FxAccrualTriggerReference.class, getTriggerReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualRegionLowerBoundBuilder extends FxAccrualRegionLowerBound, RosettaModelObjectBuilder {
		FxLevel.FxLevelBuilder getOrCreateLevel();
		@Override
		FxLevel.FxLevelBuilder getLevel();
		FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder getOrCreateStrikeReference();
		@Override
		FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder getStrikeReference();
		FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder getOrCreateAverageStrikeReference();
		@Override
		FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder getAverageStrikeReference();
		FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder getOrCreateTriggerReference();
		@Override
		FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder getTriggerReference();
		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setCondition(FxRegionLowerBoundDirectionEnum condition);
		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setLevel(FxLevel level);
		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setQuoteBasis(QuoteBasisEnum quoteBasis);
		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setStrikeReference(FxAccrualStrikeReference strikeReference);
		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setAverageStrikeReference(FxAccrualAverageStrikeReference averageStrikeReference);
		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setTriggerReference(FxAccrualTriggerReference triggerReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("condition"), FxRegionLowerBoundDirectionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("level"), processor, FxLevel.FxLevelBuilder.class, getLevel());
			processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
			processRosetta(path.newSubPath("strikeReference"), processor, FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder.class, getStrikeReference());
			processRosetta(path.newSubPath("averageStrikeReference"), processor, FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder.class, getAverageStrikeReference());
			processRosetta(path.newSubPath("triggerReference"), processor, FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder.class, getTriggerReference());
		}
		

		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualRegionLowerBound  ***********************/
	class FxAccrualRegionLowerBoundImpl implements FxAccrualRegionLowerBound {
		private final FxRegionLowerBoundDirectionEnum condition;
		private final FxLevel level;
		private final QuoteBasisEnum quoteBasis;
		private final FxAccrualStrikeReference strikeReference;
		private final FxAccrualAverageStrikeReference averageStrikeReference;
		private final FxAccrualTriggerReference triggerReference;
		
		protected FxAccrualRegionLowerBoundImpl(FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder builder) {
			this.condition = builder.getCondition();
			this.level = ofNullable(builder.getLevel()).map(f->f.build()).orElse(null);
			this.quoteBasis = builder.getQuoteBasis();
			this.strikeReference = ofNullable(builder.getStrikeReference()).map(f->f.build()).orElse(null);
			this.averageStrikeReference = ofNullable(builder.getAverageStrikeReference()).map(f->f.build()).orElse(null);
			this.triggerReference = ofNullable(builder.getTriggerReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("condition")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("condition")
		public FxRegionLowerBoundDirectionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("level")
		public FxLevel getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("quoteBasis")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quoteBasis")
		public QuoteBasisEnum getQuoteBasis() {
			return quoteBasis;
		}
		
		@Override
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeReference")
		public FxAccrualStrikeReference getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		@RosettaAttribute("averageStrikeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageStrikeReference")
		public FxAccrualAverageStrikeReference getAverageStrikeReference() {
			return averageStrikeReference;
		}
		
		@Override
		@RosettaAttribute("triggerReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerReference")
		public FxAccrualTriggerReference getTriggerReference() {
			return triggerReference;
		}
		
		@Override
		public FxAccrualRegionLowerBound build() {
			return this;
		}
		
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder toBuilder() {
			FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder builder) {
			ofNullable(getCondition()).ifPresent(builder::setCondition);
			ofNullable(getLevel()).ifPresent(builder::setLevel);
			ofNullable(getQuoteBasis()).ifPresent(builder::setQuoteBasis);
			ofNullable(getStrikeReference()).ifPresent(builder::setStrikeReference);
			ofNullable(getAverageStrikeReference()).ifPresent(builder::setAverageStrikeReference);
			ofNullable(getTriggerReference()).ifPresent(builder::setTriggerReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegionLowerBound _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			if (!Objects.equals(averageStrikeReference, _that.getAverageStrikeReference())) return false;
			if (!Objects.equals(triggerReference, _that.getTriggerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			_result = 31 * _result + (averageStrikeReference != null ? averageStrikeReference.hashCode() : 0);
			_result = 31 * _result + (triggerReference != null ? triggerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualRegionLowerBound {" +
				"condition=" + this.condition + ", " +
				"level=" + this.level + ", " +
				"quoteBasis=" + this.quoteBasis + ", " +
				"strikeReference=" + this.strikeReference + ", " +
				"averageStrikeReference=" + this.averageStrikeReference + ", " +
				"triggerReference=" + this.triggerReference +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualRegionLowerBound  ***********************/
	class FxAccrualRegionLowerBoundBuilderImpl implements FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder {
	
		protected FxRegionLowerBoundDirectionEnum condition;
		protected FxLevel.FxLevelBuilder level;
		protected QuoteBasisEnum quoteBasis;
		protected FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder strikeReference;
		protected FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder averageStrikeReference;
		protected FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder triggerReference;
		
		@Override
		@RosettaAttribute("condition")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("condition")
		public FxRegionLowerBoundDirectionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("level")
		public FxLevel.FxLevelBuilder getLevel() {
			return level;
		}
		
		@Override
		public FxLevel.FxLevelBuilder getOrCreateLevel() {
			FxLevel.FxLevelBuilder result;
			if (level!=null) {
				result = level;
			}
			else {
				result = level = FxLevel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quoteBasis")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quoteBasis")
		public QuoteBasisEnum getQuoteBasis() {
			return quoteBasis;
		}
		
		@Override
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeReference")
		public FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder getOrCreateStrikeReference() {
			FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder result;
			if (strikeReference!=null) {
				result = strikeReference;
			}
			else {
				result = strikeReference = FxAccrualStrikeReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averageStrikeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageStrikeReference")
		public FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder getAverageStrikeReference() {
			return averageStrikeReference;
		}
		
		@Override
		public FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder getOrCreateAverageStrikeReference() {
			FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder result;
			if (averageStrikeReference!=null) {
				result = averageStrikeReference;
			}
			else {
				result = averageStrikeReference = FxAccrualAverageStrikeReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triggerReference")
		public FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder getTriggerReference() {
			return triggerReference;
		}
		
		@Override
		public FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder getOrCreateTriggerReference() {
			FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder result;
			if (triggerReference!=null) {
				result = triggerReference;
			}
			else {
				result = triggerReference = FxAccrualTriggerReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("condition")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("condition")
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setCondition(FxRegionLowerBoundDirectionEnum _condition) {
			this.condition = _condition == null ? null : _condition;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setLevel(FxLevel _level) {
			this.level = _level == null ? null : _level.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quoteBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quoteBasis")
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setQuoteBasis(QuoteBasisEnum _quoteBasis) {
			this.quoteBasis = _quoteBasis == null ? null : _quoteBasis;
			return this;
		}
		
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeReference")
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setStrikeReference(FxAccrualStrikeReference _strikeReference) {
			this.strikeReference = _strikeReference == null ? null : _strikeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averageStrikeReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averageStrikeReference")
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setAverageStrikeReference(FxAccrualAverageStrikeReference _averageStrikeReference) {
			this.averageStrikeReference = _averageStrikeReference == null ? null : _averageStrikeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerReference")
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder setTriggerReference(FxAccrualTriggerReference _triggerReference) {
			this.triggerReference = _triggerReference == null ? null : _triggerReference.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualRegionLowerBound build() {
			return new FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundImpl(this);
		}
		
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder prune() {
			if (level!=null && !level.prune().hasData()) level = null;
			if (strikeReference!=null && !strikeReference.prune().hasData()) strikeReference = null;
			if (averageStrikeReference!=null && !averageStrikeReference.prune().hasData()) averageStrikeReference = null;
			if (triggerReference!=null && !triggerReference.prune().hasData()) triggerReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCondition()!=null) return true;
			if (getLevel()!=null && getLevel().hasData()) return true;
			if (getQuoteBasis()!=null) return true;
			if (getStrikeReference()!=null && getStrikeReference().hasData()) return true;
			if (getAverageStrikeReference()!=null && getAverageStrikeReference().hasData()) return true;
			if (getTriggerReference()!=null && getTriggerReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder o = (FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder) other;
			
			merger.mergeRosetta(getLevel(), o.getLevel(), this::setLevel);
			merger.mergeRosetta(getStrikeReference(), o.getStrikeReference(), this::setStrikeReference);
			merger.mergeRosetta(getAverageStrikeReference(), o.getAverageStrikeReference(), this::setAverageStrikeReference);
			merger.mergeRosetta(getTriggerReference(), o.getTriggerReference(), this::setTriggerReference);
			
			merger.mergeBasic(getCondition(), o.getCondition(), this::setCondition);
			merger.mergeBasic(getQuoteBasis(), o.getQuoteBasis(), this::setQuoteBasis);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegionLowerBound _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			if (!Objects.equals(averageStrikeReference, _that.getAverageStrikeReference())) return false;
			if (!Objects.equals(triggerReference, _that.getTriggerReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			_result = 31 * _result + (averageStrikeReference != null ? averageStrikeReference.hashCode() : 0);
			_result = 31 * _result + (triggerReference != null ? triggerReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualRegionLowerBoundBuilder {" +
				"condition=" + this.condition + ", " +
				"level=" + this.level + ", " +
				"quoteBasis=" + this.quoteBasis + ", " +
				"strikeReference=" + this.strikeReference + ", " +
				"averageStrikeReference=" + this.averageStrikeReference + ", " +
				"triggerReference=" + this.triggerReference +
			'}';
		}
	}
}
