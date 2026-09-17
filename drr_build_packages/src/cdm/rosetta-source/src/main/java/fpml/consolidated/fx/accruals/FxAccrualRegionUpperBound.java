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
import fpml.consolidated.fpmlenum.FxRegionUpperBoundDirectionEnum;
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.fx.accruals.meta.FxAccrualRegionUpperBoundMeta;
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
@RosettaDataType(value="FxAccrualRegionUpperBound", builder=FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrualRegionUpperBound", model="fpml", builder=FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilderImpl.class, version="2.1.1")
public interface FxAccrualRegionUpperBound extends RosettaModelObject {

	FxAccrualRegionUpperBoundMeta metaData = new FxAccrualRegionUpperBoundMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Upper Bound Direction. It only contains the AtOrBelow and Below values.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Upper Bound Direction. It only contains the AtOrBelow and Below values.
	 *
	 */
	FxRegionUpperBoundDirectionEnum getCondition();
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
	FxAccrualRegionUpperBound build();
	
	FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder toBuilder();
	
	static FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder builder() {
		return new FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualRegionUpperBound> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrualRegionUpperBound> getType() {
		return FxAccrualRegionUpperBound.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("condition"), FxRegionUpperBoundDirectionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("level"), processor, FxLevel.class, getLevel());
		processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
		processRosetta(path.newSubPath("strikeReference"), processor, FxAccrualStrikeReference.class, getStrikeReference());
		processRosetta(path.newSubPath("averageStrikeReference"), processor, FxAccrualAverageStrikeReference.class, getAverageStrikeReference());
		processRosetta(path.newSubPath("triggerReference"), processor, FxAccrualTriggerReference.class, getTriggerReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualRegionUpperBoundBuilder extends FxAccrualRegionUpperBound, RosettaModelObjectBuilder {
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
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setCondition(FxRegionUpperBoundDirectionEnum condition);
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setLevel(FxLevel level);
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setQuoteBasis(QuoteBasisEnum quoteBasis);
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setStrikeReference(FxAccrualStrikeReference strikeReference);
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setAverageStrikeReference(FxAccrualAverageStrikeReference averageStrikeReference);
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setTriggerReference(FxAccrualTriggerReference triggerReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("condition"), FxRegionUpperBoundDirectionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("level"), processor, FxLevel.FxLevelBuilder.class, getLevel());
			processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
			processRosetta(path.newSubPath("strikeReference"), processor, FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder.class, getStrikeReference());
			processRosetta(path.newSubPath("averageStrikeReference"), processor, FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder.class, getAverageStrikeReference());
			processRosetta(path.newSubPath("triggerReference"), processor, FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder.class, getTriggerReference());
		}
		

		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualRegionUpperBound  ***********************/
	class FxAccrualRegionUpperBoundImpl implements FxAccrualRegionUpperBound {
		private final FxRegionUpperBoundDirectionEnum condition;
		private final FxLevel level;
		private final QuoteBasisEnum quoteBasis;
		private final FxAccrualStrikeReference strikeReference;
		private final FxAccrualAverageStrikeReference averageStrikeReference;
		private final FxAccrualTriggerReference triggerReference;
		
		protected FxAccrualRegionUpperBoundImpl(FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder builder) {
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
		public FxRegionUpperBoundDirectionEnum getCondition() {
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
		public FxAccrualRegionUpperBound build() {
			return this;
		}
		
		@Override
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder toBuilder() {
			FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder builder) {
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
		
			FxAccrualRegionUpperBound _that = getType().cast(o);
		
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
			return "FxAccrualRegionUpperBound {" +
				"condition=" + this.condition + ", " +
				"level=" + this.level + ", " +
				"quoteBasis=" + this.quoteBasis + ", " +
				"strikeReference=" + this.strikeReference + ", " +
				"averageStrikeReference=" + this.averageStrikeReference + ", " +
				"triggerReference=" + this.triggerReference +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualRegionUpperBound  ***********************/
	class FxAccrualRegionUpperBoundBuilderImpl implements FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder {
	
		protected FxRegionUpperBoundDirectionEnum condition;
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
		public FxRegionUpperBoundDirectionEnum getCondition() {
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
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setCondition(FxRegionUpperBoundDirectionEnum _condition) {
			this.condition = _condition == null ? null : _condition;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setLevel(FxLevel _level) {
			this.level = _level == null ? null : _level.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quoteBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quoteBasis")
		@Override
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setQuoteBasis(QuoteBasisEnum _quoteBasis) {
			this.quoteBasis = _quoteBasis == null ? null : _quoteBasis;
			return this;
		}
		
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeReference")
		@Override
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setStrikeReference(FxAccrualStrikeReference _strikeReference) {
			this.strikeReference = _strikeReference == null ? null : _strikeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averageStrikeReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averageStrikeReference")
		@Override
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setAverageStrikeReference(FxAccrualAverageStrikeReference _averageStrikeReference) {
			this.averageStrikeReference = _averageStrikeReference == null ? null : _averageStrikeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerReference")
		@Override
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder setTriggerReference(FxAccrualTriggerReference _triggerReference) {
			this.triggerReference = _triggerReference == null ? null : _triggerReference.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualRegionUpperBound build() {
			return new FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundImpl(this);
		}
		
		@Override
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder prune() {
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
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder o = (FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder) other;
			
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
		
			FxAccrualRegionUpperBound _that = getType().cast(o);
		
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
			return "FxAccrualRegionUpperBoundBuilder {" +
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
