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
import fpml.consolidated.fpmlenum.ConditionEnum;
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.fx.accruals.meta.FxAccrualLeverageMeta;
import fpml.consolidated.fx.targets.FxCounterCurrencyAmount;
import fpml.consolidated.fx.targets.FxLevel;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.Schedule;
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
@RosettaDataType(value="FxAccrualLeverage", builder=FxAccrualLeverage.FxAccrualLeverageBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrualLeverage", model="fpml", builder=FxAccrualLeverage.FxAccrualLeverageBuilderImpl.class, version="2.1.1")
public interface FxAccrualLeverage extends RosettaModelObject {

	FxAccrualLeverageMeta metaData = new FxAccrualLeverageMeta();

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
	 * Provision Notional amount Schedule. The notional value of the product per settlement period. This number divided by the total number of fixings in the fixing schedule is the amount that is accrued at each fixing if the accrual factor is one.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Notional amount Schedule. The notional value of the product per settlement period. This number divided by the total number of fixings in the fixing schedule is the amount that is accrued at each fixing if the accrual factor is one.
	 *
	 */
	NonNegativeAmountSchedule getNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The opposite currency amount. The counterCurrencyAmount element is only optional if averageStrike component is present, in all other cases this element must be populated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The opposite currency amount. The counterCurrencyAmount element is only optional if averageStrike component is present, in all other cases this element must be populated.
	 *
	 */
	FxCounterCurrencyAmount getCounterCurrencyAmount();

	/*********************** Build Methods  ***********************/
	FxAccrualLeverage build();
	
	FxAccrualLeverage.FxAccrualLeverageBuilder toBuilder();
	
	static FxAccrualLeverage.FxAccrualLeverageBuilder builder() {
		return new FxAccrualLeverage.FxAccrualLeverageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualLeverage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrualLeverage> getType() {
		return FxAccrualLeverage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("level"), processor, FxLevel.class, getLevel());
		processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
		processRosetta(path.newSubPath("strikeReference"), processor, FxAccrualStrikeReference.class, getStrikeReference());
		processRosetta(path.newSubPath("averageStrikeReference"), processor, FxAccrualAverageStrikeReference.class, getAverageStrikeReference());
		processRosetta(path.newSubPath("triggerReference"), processor, FxAccrualTriggerReference.class, getTriggerReference());
		processRosetta(path.newSubPath("ratio"), processor, Schedule.class, getRatio());
		processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.class, getNotionalAmount());
		processRosetta(path.newSubPath("counterCurrencyAmount"), processor, FxCounterCurrencyAmount.class, getCounterCurrencyAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualLeverageBuilder extends FxAccrualLeverage, RosettaModelObjectBuilder {
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
		Schedule.ScheduleBuilder getOrCreateRatio();
		@Override
		Schedule.ScheduleBuilder getRatio();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalAmount();
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalAmount();
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getOrCreateCounterCurrencyAmount();
		@Override
		FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getCounterCurrencyAmount();
		FxAccrualLeverage.FxAccrualLeverageBuilder setId(String id);
		FxAccrualLeverage.FxAccrualLeverageBuilder setCondition(ConditionEnum condition);
		FxAccrualLeverage.FxAccrualLeverageBuilder setLevel(FxLevel level);
		FxAccrualLeverage.FxAccrualLeverageBuilder setQuoteBasis(QuoteBasisEnum quoteBasis);
		FxAccrualLeverage.FxAccrualLeverageBuilder setStrikeReference(FxAccrualStrikeReference strikeReference);
		FxAccrualLeverage.FxAccrualLeverageBuilder setAverageStrikeReference(FxAccrualAverageStrikeReference averageStrikeReference);
		FxAccrualLeverage.FxAccrualLeverageBuilder setTriggerReference(FxAccrualTriggerReference triggerReference);
		FxAccrualLeverage.FxAccrualLeverageBuilder setRatio(Schedule ratio);
		FxAccrualLeverage.FxAccrualLeverageBuilder setNotionalAmount(NonNegativeAmountSchedule notionalAmount);
		FxAccrualLeverage.FxAccrualLeverageBuilder setCounterCurrencyAmount(FxCounterCurrencyAmount counterCurrencyAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("level"), processor, FxLevel.FxLevelBuilder.class, getLevel());
			processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
			processRosetta(path.newSubPath("strikeReference"), processor, FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder.class, getStrikeReference());
			processRosetta(path.newSubPath("averageStrikeReference"), processor, FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder.class, getAverageStrikeReference());
			processRosetta(path.newSubPath("triggerReference"), processor, FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder.class, getTriggerReference());
			processRosetta(path.newSubPath("ratio"), processor, Schedule.ScheduleBuilder.class, getRatio());
			processRosetta(path.newSubPath("notionalAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("counterCurrencyAmount"), processor, FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder.class, getCounterCurrencyAmount());
		}
		

		FxAccrualLeverage.FxAccrualLeverageBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualLeverage  ***********************/
	class FxAccrualLeverageImpl implements FxAccrualLeverage {
		private final String id;
		private final ConditionEnum condition;
		private final FxLevel level;
		private final QuoteBasisEnum quoteBasis;
		private final FxAccrualStrikeReference strikeReference;
		private final FxAccrualAverageStrikeReference averageStrikeReference;
		private final FxAccrualTriggerReference triggerReference;
		private final Schedule ratio;
		private final NonNegativeAmountSchedule notionalAmount;
		private final FxCounterCurrencyAmount counterCurrencyAmount;
		
		protected FxAccrualLeverageImpl(FxAccrualLeverage.FxAccrualLeverageBuilder builder) {
			this.id = builder.getId();
			this.condition = builder.getCondition();
			this.level = ofNullable(builder.getLevel()).map(f->f.build()).orElse(null);
			this.quoteBasis = builder.getQuoteBasis();
			this.strikeReference = ofNullable(builder.getStrikeReference()).map(f->f.build()).orElse(null);
			this.averageStrikeReference = ofNullable(builder.getAverageStrikeReference()).map(f->f.build()).orElse(null);
			this.triggerReference = ofNullable(builder.getTriggerReference()).map(f->f.build()).orElse(null);
			this.ratio = ofNullable(builder.getRatio()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.counterCurrencyAmount = ofNullable(builder.getCounterCurrencyAmount()).map(f->f.build()).orElse(null);
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
		@RuneAttribute("counterCurrencyAmount")
		public FxCounterCurrencyAmount getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public FxAccrualLeverage build() {
			return this;
		}
		
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder toBuilder() {
			FxAccrualLeverage.FxAccrualLeverageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualLeverage.FxAccrualLeverageBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getCondition()).ifPresent(builder::setCondition);
			ofNullable(getLevel()).ifPresent(builder::setLevel);
			ofNullable(getQuoteBasis()).ifPresent(builder::setQuoteBasis);
			ofNullable(getStrikeReference()).ifPresent(builder::setStrikeReference);
			ofNullable(getAverageStrikeReference()).ifPresent(builder::setAverageStrikeReference);
			ofNullable(getTriggerReference()).ifPresent(builder::setTriggerReference);
			ofNullable(getRatio()).ifPresent(builder::setRatio);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualLeverage _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			if (!Objects.equals(averageStrikeReference, _that.getAverageStrikeReference())) return false;
			if (!Objects.equals(triggerReference, _that.getTriggerReference())) return false;
			if (!Objects.equals(ratio, _that.getRatio())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			_result = 31 * _result + (averageStrikeReference != null ? averageStrikeReference.hashCode() : 0);
			_result = 31 * _result + (triggerReference != null ? triggerReference.hashCode() : 0);
			_result = 31 * _result + (ratio != null ? ratio.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualLeverage {" +
				"id=" + this.id + ", " +
				"condition=" + this.condition + ", " +
				"level=" + this.level + ", " +
				"quoteBasis=" + this.quoteBasis + ", " +
				"strikeReference=" + this.strikeReference + ", " +
				"averageStrikeReference=" + this.averageStrikeReference + ", " +
				"triggerReference=" + this.triggerReference + ", " +
				"ratio=" + this.ratio + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualLeverage  ***********************/
	class FxAccrualLeverageBuilderImpl implements FxAccrualLeverage.FxAccrualLeverageBuilder {
	
		protected String id;
		protected ConditionEnum condition;
		protected FxLevel.FxLevelBuilder level;
		protected QuoteBasisEnum quoteBasis;
		protected FxAccrualStrikeReference.FxAccrualStrikeReferenceBuilder strikeReference;
		protected FxAccrualAverageStrikeReference.FxAccrualAverageStrikeReferenceBuilder averageStrikeReference;
		protected FxAccrualTriggerReference.FxAccrualTriggerReferenceBuilder triggerReference;
		protected Schedule.ScheduleBuilder ratio;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalAmount;
		protected FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder counterCurrencyAmount;
		
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
		@RuneAttribute("counterCurrencyAmount")
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder getOrCreateCounterCurrencyAmount() {
			FxCounterCurrencyAmount.FxCounterCurrencyAmountBuilder result;
			if (counterCurrencyAmount!=null) {
				result = counterCurrencyAmount;
			}
			else {
				result = counterCurrencyAmount = FxCounterCurrencyAmount.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("condition")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("condition")
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder setCondition(ConditionEnum _condition) {
			this.condition = _condition == null ? null : _condition;
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder setLevel(FxLevel _level) {
			this.level = _level == null ? null : _level.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quoteBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quoteBasis")
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder setQuoteBasis(QuoteBasisEnum _quoteBasis) {
			this.quoteBasis = _quoteBasis == null ? null : _quoteBasis;
			return this;
		}
		
		@RosettaAttribute("strikeReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikeReference")
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder setStrikeReference(FxAccrualStrikeReference _strikeReference) {
			this.strikeReference = _strikeReference == null ? null : _strikeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averageStrikeReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averageStrikeReference")
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder setAverageStrikeReference(FxAccrualAverageStrikeReference _averageStrikeReference) {
			this.averageStrikeReference = _averageStrikeReference == null ? null : _averageStrikeReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("triggerReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triggerReference")
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder setTriggerReference(FxAccrualTriggerReference _triggerReference) {
			this.triggerReference = _triggerReference == null ? null : _triggerReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ratio")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ratio")
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder setRatio(Schedule _ratio) {
			this.ratio = _ratio == null ? null : _ratio.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmount")
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder setNotionalAmount(NonNegativeAmountSchedule _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterCurrencyAmount")
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder setCounterCurrencyAmount(FxCounterCurrencyAmount _counterCurrencyAmount) {
			this.counterCurrencyAmount = _counterCurrencyAmount == null ? null : _counterCurrencyAmount.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualLeverage build() {
			return new FxAccrualLeverage.FxAccrualLeverageImpl(this);
		}
		
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder prune() {
			if (level!=null && !level.prune().hasData()) level = null;
			if (strikeReference!=null && !strikeReference.prune().hasData()) strikeReference = null;
			if (averageStrikeReference!=null && !averageStrikeReference.prune().hasData()) averageStrikeReference = null;
			if (triggerReference!=null && !triggerReference.prune().hasData()) triggerReference = null;
			if (ratio!=null && !ratio.prune().hasData()) ratio = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (counterCurrencyAmount!=null && !counterCurrencyAmount.prune().hasData()) counterCurrencyAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getCondition()!=null) return true;
			if (getLevel()!=null && getLevel().hasData()) return true;
			if (getQuoteBasis()!=null) return true;
			if (getStrikeReference()!=null && getStrikeReference().hasData()) return true;
			if (getAverageStrikeReference()!=null && getAverageStrikeReference().hasData()) return true;
			if (getTriggerReference()!=null && getTriggerReference().hasData()) return true;
			if (getRatio()!=null && getRatio().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getCounterCurrencyAmount()!=null && getCounterCurrencyAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualLeverage.FxAccrualLeverageBuilder o = (FxAccrualLeverage.FxAccrualLeverageBuilder) other;
			
			merger.mergeRosetta(getLevel(), o.getLevel(), this::setLevel);
			merger.mergeRosetta(getStrikeReference(), o.getStrikeReference(), this::setStrikeReference);
			merger.mergeRosetta(getAverageStrikeReference(), o.getAverageStrikeReference(), this::setAverageStrikeReference);
			merger.mergeRosetta(getTriggerReference(), o.getTriggerReference(), this::setTriggerReference);
			merger.mergeRosetta(getRatio(), o.getRatio(), this::setRatio);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getCounterCurrencyAmount(), o.getCounterCurrencyAmount(), this::setCounterCurrencyAmount);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getCondition(), o.getCondition(), this::setCondition);
			merger.mergeBasic(getQuoteBasis(), o.getQuoteBasis(), this::setQuoteBasis);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualLeverage _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			if (!Objects.equals(strikeReference, _that.getStrikeReference())) return false;
			if (!Objects.equals(averageStrikeReference, _that.getAverageStrikeReference())) return false;
			if (!Objects.equals(triggerReference, _that.getTriggerReference())) return false;
			if (!Objects.equals(ratio, _that.getRatio())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strikeReference != null ? strikeReference.hashCode() : 0);
			_result = 31 * _result + (averageStrikeReference != null ? averageStrikeReference.hashCode() : 0);
			_result = 31 * _result + (triggerReference != null ? triggerReference.hashCode() : 0);
			_result = 31 * _result + (ratio != null ? ratio.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualLeverageBuilder {" +
				"id=" + this.id + ", " +
				"condition=" + this.condition + ", " +
				"level=" + this.level + ", " +
				"quoteBasis=" + this.quoteBasis + ", " +
				"strikeReference=" + this.strikeReference + ", " +
				"averageStrikeReference=" + this.averageStrikeReference + ", " +
				"triggerReference=" + this.triggerReference + ", " +
				"ratio=" + this.ratio + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount +
			'}';
		}
	}
}
