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
import fpml.consolidated.fpmlenum.ConditionEnum;
import fpml.consolidated.fpmlenum.FxSettlementAdjustmentMethodEnum;
import fpml.consolidated.fx.targets.meta.FxPayoffCapMeta;
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
 * Provision The amount of gain on the client upside or firm upside is limited. If spot settles above the cap, or below the floor, the payout is adjusted to limit the gain. The adjustment may be made by varying the strike, or by maintaining the strike, but varying the payout notionals.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The amount of gain on the client upside or firm upside is limited. If spot settles above the cap, or below the floor, the payout is adjusted to limit the gain. The adjustment may be made by varying the strike, or by maintaining the strike, but varying the payout notionals.
 *
 */
@RosettaDataType(value="FxPayoffCap", builder=FxPayoffCap.FxPayoffCapBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxPayoffCap", model="fpml", builder=FxPayoffCap.FxPayoffCapBuilderImpl.class, version="2.1.1")
public interface FxPayoffCap extends RosettaModelObject {

	FxPayoffCapMeta metaData = new FxPayoffCapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Condition in which Cap or Floor applies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Condition in which Cap or Floor applies.
	 *
	 */
	ConditionEnum getCondition();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Cap/Floor rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Cap/Floor rate.
	 *
	 */
	Schedule getRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Settlement Adjustment Style can be VariedStrike or VariedNotional.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Settlement Adjustment Style can be VariedStrike or VariedNotional.
	 *
	 */
	FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle();

	/*********************** Build Methods  ***********************/
	FxPayoffCap build();
	
	FxPayoffCap.FxPayoffCapBuilder toBuilder();
	
	static FxPayoffCap.FxPayoffCapBuilder builder() {
		return new FxPayoffCap.FxPayoffCapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxPayoffCap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxPayoffCap> getType() {
		return FxPayoffCap.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
		processRosetta(path.newSubPath("rate"), processor, Schedule.class, getRate());
		processor.processBasic(path.newSubPath("settlementAdjustmentStyle"), FxSettlementAdjustmentMethodEnum.class, getSettlementAdjustmentStyle(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxPayoffCapBuilder extends FxPayoffCap, RosettaModelObjectBuilder {
		Schedule.ScheduleBuilder getOrCreateRate();
		@Override
		Schedule.ScheduleBuilder getRate();
		FxPayoffCap.FxPayoffCapBuilder setCondition(ConditionEnum condition);
		FxPayoffCap.FxPayoffCapBuilder setRate(Schedule rate);
		FxPayoffCap.FxPayoffCapBuilder setSettlementAdjustmentStyle(FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("condition"), ConditionEnum.class, getCondition(), this);
			processRosetta(path.newSubPath("rate"), processor, Schedule.ScheduleBuilder.class, getRate());
			processor.processBasic(path.newSubPath("settlementAdjustmentStyle"), FxSettlementAdjustmentMethodEnum.class, getSettlementAdjustmentStyle(), this);
		}
		

		FxPayoffCap.FxPayoffCapBuilder prune();
	}

	/*********************** Immutable Implementation of FxPayoffCap  ***********************/
	class FxPayoffCapImpl implements FxPayoffCap {
		private final ConditionEnum condition;
		private final Schedule rate;
		private final FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle;
		
		protected FxPayoffCapImpl(FxPayoffCap.FxPayoffCapBuilder builder) {
			this.condition = builder.getCondition();
			this.rate = ofNullable(builder.getRate()).map(f->f.build()).orElse(null);
			this.settlementAdjustmentStyle = builder.getSettlementAdjustmentStyle();
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
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public Schedule getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("settlementAdjustmentStyle")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementAdjustmentStyle")
		public FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle() {
			return settlementAdjustmentStyle;
		}
		
		@Override
		public FxPayoffCap build() {
			return this;
		}
		
		@Override
		public FxPayoffCap.FxPayoffCapBuilder toBuilder() {
			FxPayoffCap.FxPayoffCapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxPayoffCap.FxPayoffCapBuilder builder) {
			ofNullable(getCondition()).ifPresent(builder::setCondition);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getSettlementAdjustmentStyle()).ifPresent(builder::setSettlementAdjustmentStyle);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxPayoffCap _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(settlementAdjustmentStyle, _that.getSettlementAdjustmentStyle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (settlementAdjustmentStyle != null ? settlementAdjustmentStyle.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPayoffCap {" +
				"condition=" + this.condition + ", " +
				"rate=" + this.rate + ", " +
				"settlementAdjustmentStyle=" + this.settlementAdjustmentStyle +
			'}';
		}
	}

	/*********************** Builder Implementation of FxPayoffCap  ***********************/
	class FxPayoffCapBuilderImpl implements FxPayoffCap.FxPayoffCapBuilder {
	
		protected ConditionEnum condition;
		protected Schedule.ScheduleBuilder rate;
		protected FxSettlementAdjustmentMethodEnum settlementAdjustmentStyle;
		
		@Override
		@RosettaAttribute("condition")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("condition")
		public ConditionEnum getCondition() {
			return condition;
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rate")
		public Schedule.ScheduleBuilder getRate() {
			return rate;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateRate() {
			Schedule.ScheduleBuilder result;
			if (rate!=null) {
				result = rate;
			}
			else {
				result = rate = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementAdjustmentStyle")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("settlementAdjustmentStyle")
		public FxSettlementAdjustmentMethodEnum getSettlementAdjustmentStyle() {
			return settlementAdjustmentStyle;
		}
		
		@RosettaAttribute("condition")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("condition")
		@Override
		public FxPayoffCap.FxPayoffCapBuilder setCondition(ConditionEnum _condition) {
			this.condition = _condition == null ? null : _condition;
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rate")
		@Override
		public FxPayoffCap.FxPayoffCapBuilder setRate(Schedule _rate) {
			this.rate = _rate == null ? null : _rate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementAdjustmentStyle")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("settlementAdjustmentStyle")
		@Override
		public FxPayoffCap.FxPayoffCapBuilder setSettlementAdjustmentStyle(FxSettlementAdjustmentMethodEnum _settlementAdjustmentStyle) {
			this.settlementAdjustmentStyle = _settlementAdjustmentStyle == null ? null : _settlementAdjustmentStyle;
			return this;
		}
		
		@Override
		public FxPayoffCap build() {
			return new FxPayoffCap.FxPayoffCapImpl(this);
		}
		
		@Override
		public FxPayoffCap.FxPayoffCapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPayoffCap.FxPayoffCapBuilder prune() {
			if (rate!=null && !rate.prune().hasData()) rate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCondition()!=null) return true;
			if (getRate()!=null && getRate().hasData()) return true;
			if (getSettlementAdjustmentStyle()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxPayoffCap.FxPayoffCapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxPayoffCap.FxPayoffCapBuilder o = (FxPayoffCap.FxPayoffCapBuilder) other;
			
			merger.mergeRosetta(getRate(), o.getRate(), this::setRate);
			
			merger.mergeBasic(getCondition(), o.getCondition(), this::setCondition);
			merger.mergeBasic(getSettlementAdjustmentStyle(), o.getSettlementAdjustmentStyle(), this::setSettlementAdjustmentStyle);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxPayoffCap _that = getType().cast(o);
		
			if (!Objects.equals(condition, _that.getCondition())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(settlementAdjustmentStyle, _that.getSettlementAdjustmentStyle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (condition != null ? condition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (settlementAdjustmentStyle != null ? settlementAdjustmentStyle.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxPayoffCapBuilder {" +
				"condition=" + this.condition + ", " +
				"rate=" + this.rate + ", " +
				"settlementAdjustmentStyle=" + this.settlementAdjustmentStyle +
			'}';
		}
	}
}
