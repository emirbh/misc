package fpml.consolidated.fx.targets;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.fpmlenum.ConditionEnum;
import fpml.consolidated.fx.targets.meta.FxTargetLeverageMeta;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.Schedule;
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
@RosettaDataType(value="FxTargetLeverage", builder=FxTargetLeverage.FxTargetLeverageBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTargetLeverage", model="fpml", builder=FxTargetLeverage.FxTargetLeverageBuilderImpl.class, version="2.1.1")
public interface FxTargetLeverage extends RosettaModelObject {

	FxTargetLeverageMeta metaData = new FxTargetLeverageMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Condition in which leverage applies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Condition in which leverage applies.
	 *
	 */
	ConditionEnum getCondition();
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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Leverage rate with optional steps. Format is 2 for 200%.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Leverage rate with optional steps. Format is 2 for 200%.
	 *
	 */
	Schedule getRatio();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Leveraged notional expressed as amount with optional steps.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Leveraged notional expressed as amount with optional steps.
	 *
	 */
	NonNegativeAmountSchedule getNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The opposite currency amount of the Target.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The opposite currency amount of the Target.
	 *
	 */
	List<? extends FxCounterCurrencyAmount> getCounterCurrencyAmount();

	/*********************** Build Methods  ***********************/
	FxTargetLeverage build();
	
	FxTargetLeverage.FxTargetLeverageBuilder toBuilder();
	
	static FxTargetLeverage.FxTargetLeverageBuilder builder() {
		return new FxTargetLeverage.FxTargetLeverageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetLeverage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTargetLeverage> getType() {
		return FxTargetLeverage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("level"), processor, FxLevel.class, getLevel());
		processRosetta(path.newSubPath("strikeReference"), processor, FxStrikeReference.class, getStrikeReference());
		processRosetta(path.newSubPath("pivotReference"), processor, FxPivotReference.class, getPivotReference());
		processRosetta(path.newSubPath("barrierReference"), processor, FxComplexBarrierBaseReference.class, getBarrierReference());
		processRosetta(path.newSubPath("levelReference"), processor, FxLevelReference.class, getLevelReference());
		processRosetta(path.newSubPath("ratio"), processor, Schedule.class, getRatio());
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("counterCurrencyAmount"), processor, FxCounterCurrencyAmount.class, getCounterCurrencyAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetLeverageBuilder extends FxTargetLeverage, RosettaModelObjectBuilder {
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
		Schedule.ScheduleBuilder getOrCreateRatio();
		@Override
		Schedule.ScheduleBuilder getRatio();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount();
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount();
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getOrCreateCounterCurrencyAmount(int index);
		@Override
		List<? extends FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder> getCounterCurrencyAmount();
		FxTargetLeverage.FxTargetLeverageBuilder setId(String id);
		FxTargetLeverage.FxTargetLeverageBuilder setCondition(ConditionEnum condition);
		FxTargetLeverage.FxTargetLeverageBuilder setLevel(FxLevel level);
		FxTargetLeverage.FxTargetLeverageBuilder setStrikeReference(FxStrikeReference strikeReference);
		FxTargetLeverage.FxTargetLeverageBuilder setPivotReference(FxPivotReference pivotReference);
		FxTargetLeverage.FxTargetLeverageBuilder setBarrierReference(FxComplexBarrierBaseReference barrierReference);
		FxTargetLeverage.FxTargetLeverageBuilder setLevelReference(FxLevelReference levelReference);
		FxTargetLeverage.FxTargetLeverageBuilder setRatio(Schedule ratio);
		FxTargetLeverage.FxTargetLeverageBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxTargetLeverage.FxTargetLeverageBuilder addCounterCurrencyAmount(FxCounterCurrencyAmount counterCurrencyAmount);
		FxTargetLeverage.FxTargetLeverageBuilder addCounterCurrencyAmount(FxCounterCurrencyAmount counterCurrencyAmount, int idx);
		FxTargetLeverage.FxTargetLeverageBuilder addCounterCurrencyAmount(List<? extends FxCounterCurrencyAmount> counterCurrencyAmount);
		FxTargetLeverage.FxTargetLeverageBuilder setCounterCurrencyAmount(List<? extends FxCounterCurrencyAmount> counterCurrencyAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("level"), processor, FxLevel.FxLevelBuilder.class, getLevel());
			processRosetta(path.newSubPath("strikeReference"), processor, FxStrikeReference.FxStrikeReferenceBuilder.class, getStrikeReference());
			processRosetta(path.newSubPath("pivotReference"), processor, FxPivotReference.FxPivotReferenceBuilder.class, getPivotReference());
			processRosetta(path.newSubPath("barrierReference"), processor, FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder.class, getBarrierReference());
			processRosetta(path.newSubPath("levelReference"), processor, FxLevelReference.FxLevelReferenceBuilder.class, getLevelReference());
			processRosetta(path.newSubPath("ratio"), processor, Schedule.ScheduleBuilder.class, getRatio());
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("counterCurrencyAmount"), processor, FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder.class, getCounterCurrencyAmount());
		}
		

		FxTargetLeverage.FxTargetLeverageBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetLeverage  ***********************/
	class FxTargetLeverageImpl implements FxTargetLeverage {
		private final String id;
		private final ConditionEnum condition;
		private final FxLevel level;
		private final FxStrikeReference strikeReference;
		private final FxPivotReference pivotReference;
		private final FxComplexBarrierBaseReference barrierReference;
		private final FxLevelReference levelReference;
		private final Schedule ratio;
		private final NonNegativeAmountSchedule notionalAmount;
		private final List<? extends FxCounterCurrencyAmount> counterCurrencyAmount;
		
		protected FxTargetLeverageImpl(FxTargetLeverage.FxTargetLeverageBuilder builder) {
			this.id = builder.getId();
			this.condition = builder.getCondition();
			this.level = ofNullable(builder.getLevel()).map(f->f.build()).orElse(null);
			this.strikeReference = ofNullable(builder.getStrikeReference()).map(f->f.build()).orElse(null);
			this.pivotReference = ofNullable(builder.getPivotReference()).map(f->f.build()).orElse(null);
			this.barrierReference = ofNullable(builder.getBarrierReference()).map(f->f.build()).orElse(null);
			this.levelReference = ofNullable(builder.getLevelReference()).map(f->f.build()).orElse(null);
			this.ratio = ofNullable(builder.getRatio()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.counterCurrencyAmount = ofNullable(builder.getCounterCurrencyAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("condition")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("condition")
		public ConditionEnum getCondition() {
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
		@RosettaAttribute("ratio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ratio")
		public Schedule getRatio() {
			return ratio;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public NonNegativeAmountSchedule getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("counterCurrencyAmount")
		public List<? extends FxCounterCurrencyAmount> getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public FxTargetLeverage build() {
			return this;
		}
		
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder toBuilder() {
			FxTargetLeverage.FxTargetLeverageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetLeverage.FxTargetLeverageBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getCondition()).ifPresent(builder::setCondition);
			ofNullable(getLevel()).ifPresent(builder::setLevel);
			ofNullable(getStrikeReference()).ifPresent(builder::setStrikeReference);
			ofNullable(getPivotReference()).ifPresent(builder::setPivotReference);
			ofNullable(getBarrierReference()).ifPresent(builder::setBarrierReference);
			ofNullable(getLevelReference()).ifPresent(builder::setLevelReference);
			ofNullable(getRatio()).ifPresent(builder::setRatio);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetLeverage _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			if (!Objects.equals(pivotReference, _that.getPivotReference())) return false;
			if (!Objects.equals(barrierReference, _that.getBarrierReference())) return false;
			if (!Objects.equals(levelReference, _that.getLevelReference())) return false;
			if (!Objects.equals(ratio, _that.getRatio())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!ListEquals.listEquals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			_result = 31 * _result + (pivotReference != null ? pivotReference.hashCode() : 0);
			_result = 31 * _result + (barrierReference != null ? barrierReference.hashCode() : 0);
			_result = 31 * _result + (levelReference != null ? levelReference.hashCode() : 0);
			_result = 31 * _result + (ratio != null ? ratio.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetLeverage {" +
				"id=" + this.id + ", " +
				"condition=" + this.condition + ", " +
				"level=" + this.level + ", " +
				"strikeReference=" + this.strikeReference + ", " +
				"pivotReference=" + this.pivotReference + ", " +
				"barrierReference=" + this.barrierReference + ", " +
				"levelReference=" + this.levelReference + ", " +
				"ratio=" + this.ratio + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetLeverage  ***********************/
	class FxTargetLeverageBuilderImpl implements FxTargetLeverage.FxTargetLeverageBuilder {
	
		protected String id;
		protected ConditionEnum condition;
		protected FxLevel.FxLevelBuilder level;
		protected FxStrikeReference.FxStrikeReferenceBuilder strikeReference;
		protected FxPivotReference.FxPivotReferenceBuilder pivotReference;
		protected FxComplexBarrierBaseReference.FxComplexBarrierBaseReferenceBuilder barrierReference;
		protected FxLevelReference.FxLevelReferenceBuilder levelReference;
		protected Schedule.ScheduleBuilder ratio;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected List<FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder> counterCurrencyAmount = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("condition")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("condition")
		public ConditionEnum getCondition() {
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
		
		@Override
		@RosettaAttribute("ratio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ratio")
		public Schedule.ScheduleBuilder getRatio() {
			return ratio;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateRatio() {
			Schedule.ScheduleBuilder result;
			if (ratio!=null) {
				result = ratio;
			}
			else {
				result = ratio = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("counterCurrencyAmount")
		public List<? extends FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder> getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getOrCreateCounterCurrencyAmount(int index) {
			if (counterCurrencyAmount==null) {
				this.counterCurrencyAmount = new ArrayList<>();
			}
			return getIndex(counterCurrencyAmount, index, () -> {
						FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder newCounterCurrencyAmount = FxCounterCurrencyAmount.builder();
						return newCounterCurrencyAmount;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("condition")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("condition")
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder setCondition(ConditionEnum _condition) {
			this.condition = _condition == null ? null : _condition;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder setLevel(FxLevel _level) {
			this.level = _level == null ? null : _level.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeReference")
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder setStrikeReference(FxStrikeReference _strikeReference) {
			this.strikeReference = _strikeReference == null ? null : _strikeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pivotReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pivotReference")
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder setPivotReference(FxPivotReference _pivotReference) {
			this.pivotReference = _pivotReference == null ? null : _pivotReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("barrierReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrierReference")
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder setBarrierReference(FxComplexBarrierBaseReference _barrierReference) {
			this.barrierReference = _barrierReference == null ? null : _barrierReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("levelReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("levelReference")
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder setLevelReference(FxLevelReference _levelReference) {
			this.levelReference = _levelReference == null ? null : _levelReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ratio")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ratio")
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder setRatio(Schedule _ratio) {
			this.ratio = _ratio == null ? null : _ratio.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmount")
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder setNotionalAmount(NonNegativeAmountSchedule _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("counterCurrencyAmount")
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder addCounterCurrencyAmount(FxCounterCurrencyAmount _counterCurrencyAmount) {
			if (_counterCurrencyAmount != null) {
				this.counterCurrencyAmount.add(_counterCurrencyAmount.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder addCounterCurrencyAmount(FxCounterCurrencyAmount _counterCurrencyAmount, int idx) {
			getIndex(this.counterCurrencyAmount, idx, () -> _counterCurrencyAmount.toBuilder());
			return this;
		}
		
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder addCounterCurrencyAmount(List<? extends FxCounterCurrencyAmount> counterCurrencyAmounts) {
			if (counterCurrencyAmounts != null) {
				for (final FxCounterCurrencyAmount toAdd : counterCurrencyAmounts) {
					this.counterCurrencyAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("counterCurrencyAmount")
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder setCounterCurrencyAmount(List<? extends FxCounterCurrencyAmount> counterCurrencyAmounts) {
			if (counterCurrencyAmounts == null) {
				this.counterCurrencyAmount = new ArrayList<>();
			} else {
				this.counterCurrencyAmount = counterCurrencyAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxTargetLeverage build() {
			return new FxTargetLeverage.FxTargetLeverageImpl(this);
		}
		
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder prune() {
			if (level!=null && !level.prune().hasData()) level = null;
			if (strikeReference!=null && !strikeReference.prune().hasData()) strikeReference = null;
			if (pivotReference!=null && !pivotReference.prune().hasData()) pivotReference = null;
			if (barrierReference!=null && !barrierReference.prune().hasData()) barrierReference = null;
			if (levelReference!=null && !levelReference.prune().hasData()) levelReference = null;
			if (ratio!=null && !ratio.prune().hasData()) ratio = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			counterCurrencyAmount = counterCurrencyAmount.stream().filter(b->b!=null).<FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getCondition()!=null) return true;
			if (getLevel()!=null && getLevel().hasData()) return true;
			if (getStrikeReference()!=null && getStrikeReference().hasData()) return true;
			if (getPivotReference()!=null && getPivotReference().hasData()) return true;
			if (getBarrierReference()!=null && getBarrierReference().hasData()) return true;
			if (getLevelReference()!=null && getLevelReference().hasData()) return true;
			if (getRatio()!=null && getRatio().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getCounterCurrencyAmount()!=null && getCounterCurrencyAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetLeverage.FxTargetLeverageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetLeverage.FxTargetLeverageBuilder o = (FxTargetLeverage.FxTargetLeverageBuilder) other;
			
			merger.mergeRosetta(getLevel(), o.getLevel(), this::setLevel);
			merger.mergeRosetta(getStrikeReference(), o.getStrikeReference(), this::setStrikeReference);
			merger.mergeRosetta(getPivotReference(), o.getPivotReference(), this::setPivotReference);
			merger.mergeRosetta(getBarrierReference(), o.getBarrierReference(), this::setBarrierReference);
			merger.mergeRosetta(getLevelReference(), o.getLevelReference(), this::setLevelReference);
			merger.mergeRosetta(getRatio(), o.getRatio(), this::setRatio);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getCounterCurrencyAmount(), o.getCounterCurrencyAmount(), this::getOrCreateCounterCurrencyAmount);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getCondition(), o.getCondition(), this::setCondition);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetLeverage _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			if (!Objects.equals(pivotReference, _that.getPivotReference())) return false;
			if (!Objects.equals(barrierReference, _that.getBarrierReference())) return false;
			if (!Objects.equals(levelReference, _that.getLevelReference())) return false;
			if (!Objects.equals(ratio, _that.getRatio())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!ListEquals.listEquals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			_result = 31 * _result + (pivotReference != null ? pivotReference.hashCode() : 0);
			_result = 31 * _result + (barrierReference != null ? barrierReference.hashCode() : 0);
			_result = 31 * _result + (levelReference != null ? levelReference.hashCode() : 0);
			_result = 31 * _result + (ratio != null ? ratio.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetLeverageBuilder {" +
				"id=" + this.id + ", " +
				"condition=" + this.condition + ", " +
				"level=" + this.level + ", " +
				"strikeReference=" + this.strikeReference + ", " +
				"pivotReference=" + this.pivotReference + ", " +
				"barrierReference=" + this.barrierReference + ", " +
				"levelReference=" + this.levelReference + ", " +
				"ratio=" + this.ratio + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}
}
