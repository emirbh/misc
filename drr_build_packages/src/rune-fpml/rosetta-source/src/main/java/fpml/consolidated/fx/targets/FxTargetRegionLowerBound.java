package fpml.consolidated.fx.targets;

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
import fpml.consolidated.fx.targets.meta.FxTargetRegionLowerBoundMeta;
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
@RosettaDataType(value="FxTargetRegionLowerBound", builder=FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTargetRegionLowerBound", model="fpml", builder=FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilderImpl.class, version="2.1.1")
public interface FxTargetRegionLowerBound extends RosettaModelObject {

	FxTargetRegionLowerBoundMeta metaData = new FxTargetRegionLowerBoundMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision AtOrAbove, Above.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision AtOrAbove, Above.
	 *
	 */
	FxRegionLowerBoundDirectionEnum getCondition();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Level expressed as a level with optional steps different from strike, pivot, or barrier.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Level expressed as a level with optional steps different from strike, pivot, or barrier.
	 *
	 */
	FxLevel getLevel();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a strike defined within the FX product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a strike defined within the FX product.
	 *
	 */
	FxStrikeReference getStrikeReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to the pivot defined within the FX product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the pivot defined within the FX product.
	 *
	 */
	FxPivotReference getPivotReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a perExpiryBarrier component to indicate theat the bound of the region is defined by the barrier component.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a perExpiryBarrier component to indicate theat the bound of the region is defined by the barrier component.
	 *
	 */
	FxComplexBarrierBaseReference getBarrierReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a level defined within the FX product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a level defined within the FX product.
	 *
	 */
	FxLevelReference getLevelReference();

	/*********************** Build Methods  ***********************/
	FxTargetRegionLowerBound build();
	
	FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder toBuilder();
	
	static FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder builder() {
		return new FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetRegionLowerBound> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTargetRegionLowerBound> getType() {
		return FxTargetRegionLowerBound.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("condition"), FxRegionLowerBoundDirectionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("level"), processor, FxLevel.class, getLevel());
		processRosetta(path.newSubPath("strikeReference"), processor, FxStrikeReference.class, getStrikeReference());
		processRosetta(path.newSubPath("pivotReference"), processor, FxPivotReference.class, getPivotReference());
		processRosetta(path.newSubPath("barrierReference"), processor, FxComplexBarrierBaseReference.class, getBarrierReference());
		processRosetta(path.newSubPath("levelReference"), processor, FxLevelReference.class, getLevelReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetRegionLowerBoundBuilder extends FxTargetRegionLowerBound, RosettaModelObjectBuilder {
		FxLevel.FxLevelBuilder getOrCreateLevel();
		@Override
		FxLevel.FxLevelBuilder getLevel();
		FxStrikeReference.FxStrikeReferenceBuilder getOrCreateStrikeReference();
		@Override
		FxStrikeReference.FxStrikeReferenceBuilder getStrikeReference();
		FxPivotReference.FxPivotReferenceBuilder getOrCreatePivotReference();
		@Override
		FxPivotReference.FxPivotReferenceBuilder getPivotReference();
		FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getOrCreateBarrierReference();
		@Override
		FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getBarrierReference();
		FxLevelReference.FxLevelReferenceBuilder getOrCreateLevelReference();
		@Override
		FxLevelReference.FxLevelReferenceBuilder getLevelReference();
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setCondition(FxRegionLowerBoundDirectionEnum condition);
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setLevel(FxLevel level);
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setStrikeReference(FxStrikeReference strikeReference);
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setPivotReference(FxPivotReference pivotReference);
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setBarrierReference(FxComplexBarrierBaseReference barrierReference);
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setLevelReference(FxLevelReference levelReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("condition"), FxRegionLowerBoundDirectionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("level"), processor, FxLevel.FxLevelBuilder.class, getLevel());
			processRosetta(path.newSubPath("strikeReference"), processor, FxStrikeReference.FxStrikeReferenceBuilder.class, getStrikeReference());
			processRosetta(path.newSubPath("pivotReference"), processor, FxPivotReference.FxPivotReferenceBuilder.class, getPivotReference());
			processRosetta(path.newSubPath("barrierReference"), processor, FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder.class, getBarrierReference());
			processRosetta(path.newSubPath("levelReference"), processor, FxLevelReference.FxLevelReferenceBuilder.class, getLevelReference());
		}
		

		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetRegionLowerBound  ***********************/
	class FxTargetRegionLowerBoundImpl implements FxTargetRegionLowerBound {
		private final FxRegionLowerBoundDirectionEnum condition;
		private final FxLevel level;
		private final FxStrikeReference strikeReference;
		private final FxPivotReference pivotReference;
		private final FxComplexBarrierBaseReference barrierReference;
		private final FxLevelReference levelReference;
		
		protected FxTargetRegionLowerBoundImpl(FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder builder) {
			this.condition = builder.getCondition();
			this.level = ofNullable(builder.getLevel()).map(f->f.build()).orElse(null);
			this.strikeReference = ofNullable(builder.getStrikeReference()).map(f->f.build()).orElse(null);
			this.pivotReference = ofNullable(builder.getPivotReference()).map(f->f.build()).orElse(null);
			this.barrierReference = ofNullable(builder.getBarrierReference()).map(f->f.build()).orElse(null);
			this.levelReference = ofNullable(builder.getLevelReference()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeReference")
		public FxStrikeReference getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		@RosettaAttribute("pivotReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pivotReference")
		public FxPivotReference getPivotReference() {
			return pivotReference;
		}
		
		@Override
		@RosettaAttribute("barrierReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrierReference")
		public FxComplexBarrierBaseReference getBarrierReference() {
			return barrierReference;
		}
		
		@Override
		@RosettaAttribute("levelReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("levelReference")
		public FxLevelReference getLevelReference() {
			return levelReference;
		}
		
		@Override
		public FxTargetRegionLowerBound build() {
			return this;
		}
		
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder toBuilder() {
			FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder builder) {
			ofNullable(getCondition()).ifPresent(builder::setCondition);
			ofNullable(getLevel()).ifPresent(builder::setLevel);
			ofNullable(getStrikeReference()).ifPresent(builder::setStrikeReference);
			ofNullable(getPivotReference()).ifPresent(builder::setPivotReference);
			ofNullable(getBarrierReference()).ifPresent(builder::setBarrierReference);
			ofNullable(getLevelReference()).ifPresent(builder::setLevelReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetRegionLowerBound _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			if (!Objects.equals(pivotReference, _that.getPivotReference())) return false;
			if (!Objects.equals(barrierReference, _that.getBarrierReference())) return false;
			if (!Objects.equals(levelReference, _that.getLevelReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			_result = 31 * _result + (pivotReference != null ? pivotReference.hashCode() : 0);
			_result = 31 * _result + (barrierReference != null ? barrierReference.hashCode() : 0);
			_result = 31 * _result + (levelReference != null ? levelReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetRegionLowerBound {" +
				"condition=" + this.condition + ", " +
				"level=" + this.level + ", " +
				"strikeReference=" + this.strikeReference + ", " +
				"pivotReference=" + this.pivotReference + ", " +
				"barrierReference=" + this.barrierReference + ", " +
				"levelReference=" + this.levelReference +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetRegionLowerBound  ***********************/
	class FxTargetRegionLowerBoundBuilderImpl implements FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder {
	
		protected FxRegionLowerBoundDirectionEnum condition;
		protected FxLevel.FxLevelBuilder level;
		protected FxStrikeReference.FxStrikeReferenceBuilder strikeReference;
		protected FxPivotReference.FxPivotReferenceBuilder pivotReference;
		protected FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder barrierReference;
		protected FxLevelReference.FxLevelReferenceBuilder levelReference;
		
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
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikeReference")
		public FxStrikeReference.FxStrikeReferenceBuilder getStrikeReference() {
			return strikeReference;
		}
		
		@Override
		public FxStrikeReference.FxStrikeReferenceBuilder getOrCreateStrikeReference() {
			FxStrikeReference.FxStrikeReferenceBuilder result;
			if (strikeReference!=null) {
				result = strikeReference;
			}
			else {
				result = strikeReference = FxStrikeReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pivotReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pivotReference")
		public FxPivotReference.FxPivotReferenceBuilder getPivotReference() {
			return pivotReference;
		}
		
		@Override
		public FxPivotReference.FxPivotReferenceBuilder getOrCreatePivotReference() {
			FxPivotReference.FxPivotReferenceBuilder result;
			if (pivotReference!=null) {
				result = pivotReference;
			}
			else {
				result = pivotReference = FxPivotReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrierReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrierReference")
		public FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getBarrierReference() {
			return barrierReference;
		}
		
		@Override
		public FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder getOrCreateBarrierReference() {
			FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder result;
			if (barrierReference!=null) {
				result = barrierReference;
			}
			else {
				result = barrierReference = FxComplexBarrierBaseReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("levelReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("levelReference")
		public FxLevelReference.FxLevelReferenceBuilder getLevelReference() {
			return levelReference;
		}
		
		@Override
		public FxLevelReference.FxLevelReferenceBuilder getOrCreateLevelReference() {
			FxLevelReference.FxLevelReferenceBuilder result;
			if (levelReference!=null) {
				result = levelReference;
			}
			else {
				result = levelReference = FxLevelReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("condition")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("condition")
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setCondition(FxRegionLowerBoundDirectionEnum _condition) {
			this.condition = _condition == null ? null : _condition;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setLevel(FxLevel _level) {
			this.level = _level == null ? null : _level.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeReference")
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setStrikeReference(FxStrikeReference _strikeReference) {
			this.strikeReference = _strikeReference == null ? null : _strikeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pivotReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pivotReference")
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setPivotReference(FxPivotReference _pivotReference) {
			this.pivotReference = _pivotReference == null ? null : _pivotReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("barrierReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrierReference")
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setBarrierReference(FxComplexBarrierBaseReference _barrierReference) {
			this.barrierReference = _barrierReference == null ? null : _barrierReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("levelReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("levelReference")
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder setLevelReference(FxLevelReference _levelReference) {
			this.levelReference = _levelReference == null ? null : _levelReference.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetRegionLowerBound build() {
			return new FxTargetRegionLowerBound.FxTargetRegionLowerBoundImpl(this);
		}
		
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder prune() {
			if (level!=null && !level.prune().hasData()) level = null;
			if (strikeReference!=null && !strikeReference.prune().hasData()) strikeReference = null;
			if (pivotReference!=null && !pivotReference.prune().hasData()) pivotReference = null;
			if (barrierReference!=null && !barrierReference.prune().hasData()) barrierReference = null;
			if (levelReference!=null && !levelReference.prune().hasData()) levelReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCondition()!=null) return true;
			if (getLevel()!=null && getLevel().hasData()) return true;
			if (getStrikeReference()!=null && getStrikeReference().hasData()) return true;
			if (getPivotReference()!=null && getPivotReference().hasData()) return true;
			if (getBarrierReference()!=null && getBarrierReference().hasData()) return true;
			if (getLevelReference()!=null && getLevelReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder o = (FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder) other;
			
			merger.mergeRosetta(getLevel(), o.getLevel(), this::setLevel);
			merger.mergeRosetta(getStrikeReference(), o.getStrikeReference(), this::setStrikeReference);
			merger.mergeRosetta(getPivotReference(), o.getPivotReference(), this::setPivotReference);
			merger.mergeRosetta(getBarrierReference(), o.getBarrierReference(), this::setBarrierReference);
			merger.mergeRosetta(getLevelReference(), o.getLevelReference(), this::setLevelReference);
			
			merger.mergeBasic(getCondition(), o.getCondition(), this::setCondition);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetRegionLowerBound _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			if (!Objects.equals(pivotReference, _that.getPivotReference())) return false;
			if (!Objects.equals(barrierReference, _that.getBarrierReference())) return false;
			if (!Objects.equals(levelReference, _that.getLevelReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			_result = 31 * _result + (pivotReference != null ? pivotReference.hashCode() : 0);
			_result = 31 * _result + (barrierReference != null ? barrierReference.hashCode() : 0);
			_result = 31 * _result + (levelReference != null ? levelReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetRegionLowerBoundBuilder {" +
				"condition=" + this.condition + ", " +
				"level=" + this.level + ", " +
				"strikeReference=" + this.strikeReference + ", " +
				"pivotReference=" + this.pivotReference + ", " +
				"barrierReference=" + this.barrierReference + ", " +
				"levelReference=" + this.levelReference +
			'}';
		}
	}
}
