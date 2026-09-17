package fpml.consolidated.fx.accruals;

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
import fpml.consolidated.fx.accruals.meta.FxAccrualLinearPayoffRegionMeta;
import fpml.consolidated.fx.targets.FxExchangedCurrency;
import fpml.consolidated.fx.targets.FxPayoffCap;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
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
 * Provision A fixing region in which the payoff varies linearly with the fixing value.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A fixing region in which the payoff varies linearly with the fixing value.
 *
 */
@RosettaDataType(value="FxAccrualLinearPayoffRegion", builder=FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrualLinearPayoffRegion", model="fpml", builder=FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilderImpl.class, version="2.1.1")
public interface FxAccrualLinearPayoffRegion extends FxAccrualPayoffRegion {

	FxAccrualLinearPayoffRegionMeta metaData = new FxAccrualLinearPayoffRegionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the first direction of who pays and receives a specific currency without specifying the amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the first direction of who pays and receives a specific currency without specifying the amount.
	 *
	 */
	FxExchangedCurrency getExchangedCurrency1();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the second direction of who pays and receives a specific currency without specifying the amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the second direction of who pays and receives a specific currency without specifying the amount.
	 *
	 */
	FxExchangedCurrency getExchangedCurrency2();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The rate of exchange between the two currencies.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The rate of exchange between the two currencies.
	 *
	 */
	FxForwardStrikePrice getStrike();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The opposite currency amount. The counterCurrencyAmount element is only optional if averageStrike component is present or if the accrualRegion specifies the amount of counterCurrencyAmount to accrue, in all other cases this element must be populated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The opposite currency amount. The counterCurrencyAmount element is only optional if averageStrike component is present or if the accrualRegion specifies the amount of counterCurrencyAmount to accrue, in all other cases this element must be populated.
	 *
	 */
	NonNegativeAmountSchedule getCounterCurrencyAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Average Strike Forward: means the average of the Reference Spot Rate on each Business Day from and including the Calculation Start Date up to and including the Calculation End Date rounded to the precision decimal places.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Average Strike Forward: means the average of the Reference Spot Rate on each Business Day from and including the Calculation Start Date up to and including the Calculation End Date rounded to the precision decimal places.
	 *
	 */
	FxAverageStrike getAverageStrike();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the upper bound of a payoff region.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the upper bound of a payoff region.
	 *
	 */
	FxAccrualRegionUpperBound getUpperBound();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the lower bound of a payoff region.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the lower bound of a payoff region.
	 *
	 */
	FxAccrualRegionLowerBound getLowerBound();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision These structures define a leverage multiplier to the payoff amounts at settlement points.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision These structures define a leverage multiplier to the payoff amounts at settlement points.
	 *
	 */
	FxAccrualLeverage getLeverage();
	/**
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
	List<? extends FxPayoffCap> getPayoffCap();

	/*********************** Build Methods  ***********************/
	FxAccrualLinearPayoffRegion build();
	
	FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder toBuilder();
	
	static FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder builder() {
		return new FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualLinearPayoffRegion> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrualLinearPayoffRegion> getType() {
		return FxAccrualLinearPayoffRegion.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("exchangedCurrency1"), processor, FxExchangedCurrency.class, getExchangedCurrency1());
		processRosetta(path.newSubPath("exchangedCurrency2"), processor, FxExchangedCurrency.class, getExchangedCurrency2());
		processRosetta(path.newSubPath("strike"), processor, FxForwardStrikePrice.class, getStrike());
		processRosetta(path.newSubPath("counterCurrencyAmount"), processor, NonNegativeAmountSchedule.class, getCounterCurrencyAmount());
		processRosetta(path.newSubPath("averageStrike"), processor, FxAverageStrike.class, getAverageStrike());
		processRosetta(path.newSubPath("upperBound"), processor, FxAccrualRegionUpperBound.class, getUpperBound());
		processRosetta(path.newSubPath("lowerBound"), processor, FxAccrualRegionLowerBound.class, getLowerBound());
		processRosetta(path.newSubPath("leverage"), processor, FxAccrualLeverage.class, getLeverage());
		processRosetta(path.newSubPath("payoffCap"), processor, FxPayoffCap.class, getPayoffCap());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualLinearPayoffRegionBuilder extends FxAccrualLinearPayoffRegion, FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilder {
		FxExchangedCurrency.FxExchangedCurrencyBuilder getOrCreateExchangedCurrency1();
		@Override
		FxExchangedCurrency.FxExchangedCurrencyBuilder getExchangedCurrency1();
		FxExchangedCurrency.FxExchangedCurrencyBuilder getOrCreateExchangedCurrency2();
		@Override
		FxExchangedCurrency.FxExchangedCurrencyBuilder getExchangedCurrency2();
		FxForwardStrikePrice.FxForwardStrikePriceBuilder getOrCreateStrike();
		@Override
		FxForwardStrikePrice.FxForwardStrikePriceBuilder getStrike();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateCounterCurrencyAmount();
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getCounterCurrencyAmount();
		FxAverageStrike.FxAverageStrikeBuilder getOrCreateAverageStrike();
		@Override
		FxAverageStrike.FxAverageStrikeBuilder getAverageStrike();
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getOrCreateUpperBound();
		@Override
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getUpperBound();
		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder getOrCreateLowerBound();
		@Override
		FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder getLowerBound();
		FxAccrualLeverage.FxAccrualLeverageBuilder getOrCreateLeverage();
		@Override
		FxAccrualLeverage.FxAccrualLeverageBuilder getLeverage();
		FxPayoffCap.FxPayoffCapBuilder getOrCreatePayoffCap(int index);
		@Override
		List<? extends FxPayoffCap.FxPayoffCapBuilder> getPayoffCap();
		@Override
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setId(String id);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setExchangedCurrency1(FxExchangedCurrency exchangedCurrency1);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setExchangedCurrency2(FxExchangedCurrency exchangedCurrency2);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setStrike(FxForwardStrikePrice strike);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setCounterCurrencyAmount(NonNegativeAmountSchedule counterCurrencyAmount);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setAverageStrike(FxAverageStrike averageStrike);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setUpperBound(FxAccrualRegionUpperBound upperBound);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setLowerBound(FxAccrualRegionLowerBound lowerBound);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setLeverage(FxAccrualLeverage leverage);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder addPayoffCap(FxPayoffCap payoffCap);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder addPayoffCap(FxPayoffCap payoffCap, int idx);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder addPayoffCap(List<? extends FxPayoffCap> payoffCap);
		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setPayoffCap(List<? extends FxPayoffCap> payoffCap);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("exchangedCurrency1"), processor, FxExchangedCurrency.FxExchangedCurrencyBuilder.class, getExchangedCurrency1());
			processRosetta(path.newSubPath("exchangedCurrency2"), processor, FxExchangedCurrency.FxExchangedCurrencyBuilder.class, getExchangedCurrency2());
			processRosetta(path.newSubPath("strike"), processor, FxForwardStrikePrice.FxForwardStrikePriceBuilder.class, getStrike());
			processRosetta(path.newSubPath("counterCurrencyAmount"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getCounterCurrencyAmount());
			processRosetta(path.newSubPath("averageStrike"), processor, FxAverageStrike.FxAverageStrikeBuilder.class, getAverageStrike());
			processRosetta(path.newSubPath("upperBound"), processor, FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder.class, getUpperBound());
			processRosetta(path.newSubPath("lowerBound"), processor, FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder.class, getLowerBound());
			processRosetta(path.newSubPath("leverage"), processor, FxAccrualLeverage.FxAccrualLeverageBuilder.class, getLeverage());
			processRosetta(path.newSubPath("payoffCap"), processor, FxPayoffCap.FxPayoffCapBuilder.class, getPayoffCap());
		}
		

		FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualLinearPayoffRegion  ***********************/
	class FxAccrualLinearPayoffRegionImpl extends FxAccrualPayoffRegion.FxAccrualPayoffRegionImpl implements FxAccrualLinearPayoffRegion {
		private final FxExchangedCurrency exchangedCurrency1;
		private final FxExchangedCurrency exchangedCurrency2;
		private final FxForwardStrikePrice strike;
		private final NonNegativeAmountSchedule counterCurrencyAmount;
		private final FxAverageStrike averageStrike;
		private final FxAccrualRegionUpperBound upperBound;
		private final FxAccrualRegionLowerBound lowerBound;
		private final FxAccrualLeverage leverage;
		private final List<? extends FxPayoffCap> payoffCap;
		
		protected FxAccrualLinearPayoffRegionImpl(FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder builder) {
			super(builder);
			this.exchangedCurrency1 = ofNullable(builder.getExchangedCurrency1()).map(f->f.build()).orElse(null);
			this.exchangedCurrency2 = ofNullable(builder.getExchangedCurrency2()).map(f->f.build()).orElse(null);
			this.strike = ofNullable(builder.getStrike()).map(f->f.build()).orElse(null);
			this.counterCurrencyAmount = ofNullable(builder.getCounterCurrencyAmount()).map(f->f.build()).orElse(null);
			this.averageStrike = ofNullable(builder.getAverageStrike()).map(f->f.build()).orElse(null);
			this.upperBound = ofNullable(builder.getUpperBound()).map(f->f.build()).orElse(null);
			this.lowerBound = ofNullable(builder.getLowerBound()).map(f->f.build()).orElse(null);
			this.leverage = ofNullable(builder.getLeverage()).map(f->f.build()).orElse(null);
			this.payoffCap = ofNullable(builder.getPayoffCap()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exchangedCurrency1")
		public FxExchangedCurrency getExchangedCurrency1() {
			return exchangedCurrency1;
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exchangedCurrency2")
		public FxExchangedCurrency getExchangedCurrency2() {
			return exchangedCurrency2;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public FxForwardStrikePrice getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterCurrencyAmount")
		public NonNegativeAmountSchedule getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		@RosettaAttribute("averageStrike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageStrike")
		public FxAverageStrike getAverageStrike() {
			return averageStrike;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upperBound")
		public FxAccrualRegionUpperBound getUpperBound() {
			return upperBound;
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lowerBound")
		public FxAccrualRegionLowerBound getLowerBound() {
			return lowerBound;
		}
		
		@Override
		@RosettaAttribute("leverage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leverage")
		public FxAccrualLeverage getLeverage() {
			return leverage;
		}
		
		@Override
		@RosettaAttribute("payoffCap")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("payoffCap")
		public List<? extends FxPayoffCap> getPayoffCap() {
			return payoffCap;
		}
		
		@Override
		public FxAccrualLinearPayoffRegion build() {
			return this;
		}
		
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder toBuilder() {
			FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExchangedCurrency1()).ifPresent(builder::setExchangedCurrency1);
			ofNullable(getExchangedCurrency2()).ifPresent(builder::setExchangedCurrency2);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
			ofNullable(getAverageStrike()).ifPresent(builder::setAverageStrike);
			ofNullable(getUpperBound()).ifPresent(builder::setUpperBound);
			ofNullable(getLowerBound()).ifPresent(builder::setLowerBound);
			ofNullable(getLeverage()).ifPresent(builder::setLeverage);
			ofNullable(getPayoffCap()).ifPresent(builder::setPayoffCap);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualLinearPayoffRegion _that = getType().cast(o);
		
			if (!Objects.equals(exchangedCurrency1, _that.getExchangedCurrency1())) return false;
			if (!Objects.equals(exchangedCurrency2, _that.getExchangedCurrency2())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			if (!Objects.equals(averageStrike, _that.getAverageStrike())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(leverage, _that.getLeverage())) return false;
			if (!ListEquals.listEquals(payoffCap, _that.getPayoffCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exchangedCurrency1 != null ? exchangedCurrency1.hashCode() : 0);
			_result = 31 * _result + (exchangedCurrency2 != null ? exchangedCurrency2.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (averageStrike != null ? averageStrike.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (leverage != null ? leverage.hashCode() : 0);
			_result = 31 * _result + (payoffCap != null ? payoffCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualLinearPayoffRegion {" +
				"exchangedCurrency1=" + this.exchangedCurrency1 + ", " +
				"exchangedCurrency2=" + this.exchangedCurrency2 + ", " +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount + ", " +
				"averageStrike=" + this.averageStrike + ", " +
				"upperBound=" + this.upperBound + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"leverage=" + this.leverage + ", " +
				"payoffCap=" + this.payoffCap +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAccrualLinearPayoffRegion  ***********************/
	class FxAccrualLinearPayoffRegionBuilderImpl extends FxAccrualPayoffRegion.FxAccrualPayoffRegionBuilderImpl implements FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder {
	
		protected FxExchangedCurrency.FxExchangedCurrencyBuilder exchangedCurrency1;
		protected FxExchangedCurrency.FxExchangedCurrencyBuilder exchangedCurrency2;
		protected FxForwardStrikePrice.FxForwardStrikePriceBuilder strike;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder counterCurrencyAmount;
		protected FxAverageStrike.FxAverageStrikeBuilder averageStrike;
		protected FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder upperBound;
		protected FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder lowerBound;
		protected FxAccrualLeverage.FxAccrualLeverageBuilder leverage;
		protected List<FxPayoffCap.FxPayoffCapBuilder> payoffCap = new ArrayList<>();
		
		@Override
		@RosettaAttribute("exchangedCurrency1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exchangedCurrency1")
		public FxExchangedCurrency.FxExchangedCurrencyBuilder getExchangedCurrency1() {
			return exchangedCurrency1;
		}
		
		@Override
		public FxExchangedCurrency.FxExchangedCurrencyBuilder getOrCreateExchangedCurrency1() {
			FxExchangedCurrency.FxExchangedCurrencyBuilder result;
			if (exchangedCurrency1!=null) {
				result = exchangedCurrency1;
			}
			else {
				result = exchangedCurrency1 = FxExchangedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exchangedCurrency2")
		public FxExchangedCurrency.FxExchangedCurrencyBuilder getExchangedCurrency2() {
			return exchangedCurrency2;
		}
		
		@Override
		public FxExchangedCurrency.FxExchangedCurrencyBuilder getOrCreateExchangedCurrency2() {
			FxExchangedCurrency.FxExchangedCurrencyBuilder result;
			if (exchangedCurrency2!=null) {
				result = exchangedCurrency2;
			}
			else {
				result = exchangedCurrency2 = FxExchangedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder getStrike() {
			return strike;
		}
		
		@Override
		public FxForwardStrikePrice.FxForwardStrikePriceBuilder getOrCreateStrike() {
			FxForwardStrikePrice.FxForwardStrikePriceBuilder result;
			if (strike!=null) {
				result = strike;
			}
			else {
				result = strike = FxForwardStrikePrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterCurrencyAmount")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateCounterCurrencyAmount() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (counterCurrencyAmount!=null) {
				result = counterCurrencyAmount;
			}
			else {
				result = counterCurrencyAmount = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averageStrike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageStrike")
		public FxAverageStrike.FxAverageStrikeBuilder getAverageStrike() {
			return averageStrike;
		}
		
		@Override
		public FxAverageStrike.FxAverageStrikeBuilder getOrCreateAverageStrike() {
			FxAverageStrike.FxAverageStrikeBuilder result;
			if (averageStrike!=null) {
				result = averageStrike;
			}
			else {
				result = averageStrike = FxAverageStrike.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upperBound")
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getUpperBound() {
			return upperBound;
		}
		
		@Override
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getOrCreateUpperBound() {
			FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder result;
			if (upperBound!=null) {
				result = upperBound;
			}
			else {
				result = upperBound = FxAccrualRegionUpperBound.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lowerBound")
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder getLowerBound() {
			return lowerBound;
		}
		
		@Override
		public FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder getOrCreateLowerBound() {
			FxAccrualRegionLowerBound.FxAccrualRegionLowerBoundBuilder result;
			if (lowerBound!=null) {
				result = lowerBound;
			}
			else {
				result = lowerBound = FxAccrualRegionLowerBound.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("leverage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leverage")
		public FxAccrualLeverage.FxAccrualLeverageBuilder getLeverage() {
			return leverage;
		}
		
		@Override
		public FxAccrualLeverage.FxAccrualLeverageBuilder getOrCreateLeverage() {
			FxAccrualLeverage.FxAccrualLeverageBuilder result;
			if (leverage!=null) {
				result = leverage;
			}
			else {
				result = leverage = FxAccrualLeverage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payoffCap")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("payoffCap")
		public List<? extends FxPayoffCap.FxPayoffCapBuilder> getPayoffCap() {
			return payoffCap;
		}
		
		@Override
		public FxPayoffCap.FxPayoffCapBuilder getOrCreatePayoffCap(int index) {
			if (payoffCap==null) {
				this.payoffCap = new ArrayList<>();
			}
			return getIndex(payoffCap, index, () -> {
						FxPayoffCap.FxPayoffCapBuilder newPayoffCap = FxPayoffCap.builder();
						return newPayoffCap;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("exchangedCurrency1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exchangedCurrency1")
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setExchangedCurrency1(FxExchangedCurrency _exchangedCurrency1) {
			this.exchangedCurrency1 = _exchangedCurrency1 == null ? null : _exchangedCurrency1.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangedCurrency2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exchangedCurrency2")
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setExchangedCurrency2(FxExchangedCurrency _exchangedCurrency2) {
			this.exchangedCurrency2 = _exchangedCurrency2 == null ? null : _exchangedCurrency2.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strike")
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setStrike(FxForwardStrikePrice _strike) {
			this.strike = _strike == null ? null : _strike.toBuilder();
			return this;
		}
		
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterCurrencyAmount")
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setCounterCurrencyAmount(NonNegativeAmountSchedule _counterCurrencyAmount) {
			this.counterCurrencyAmount = _counterCurrencyAmount == null ? null : _counterCurrencyAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averageStrike")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averageStrike")
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setAverageStrike(FxAverageStrike _averageStrike) {
			this.averageStrike = _averageStrike == null ? null : _averageStrike.toBuilder();
			return this;
		}
		
		@RosettaAttribute("upperBound")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("upperBound")
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setUpperBound(FxAccrualRegionUpperBound _upperBound) {
			this.upperBound = _upperBound == null ? null : _upperBound.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lowerBound")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lowerBound")
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setLowerBound(FxAccrualRegionLowerBound _lowerBound) {
			this.lowerBound = _lowerBound == null ? null : _lowerBound.toBuilder();
			return this;
		}
		
		@RosettaAttribute("leverage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leverage")
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setLeverage(FxAccrualLeverage _leverage) {
			this.leverage = _leverage == null ? null : _leverage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payoffCap")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("payoffCap")
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder addPayoffCap(FxPayoffCap _payoffCap) {
			if (_payoffCap != null) {
				this.payoffCap.add(_payoffCap.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder addPayoffCap(FxPayoffCap _payoffCap, int idx) {
			getIndex(this.payoffCap, idx, () -> _payoffCap.toBuilder());
			return this;
		}
		
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder addPayoffCap(List<? extends FxPayoffCap> payoffCaps) {
			if (payoffCaps != null) {
				for (final FxPayoffCap toAdd : payoffCaps) {
					this.payoffCap.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("payoffCap")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("payoffCap")
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder setPayoffCap(List<? extends FxPayoffCap> payoffCaps) {
			if (payoffCaps == null) {
				this.payoffCap = new ArrayList<>();
			} else {
				this.payoffCap = payoffCaps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxAccrualLinearPayoffRegion build() {
			return new FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionImpl(this);
		}
		
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder prune() {
			super.prune();
			if (exchangedCurrency1!=null && !exchangedCurrency1.prune().hasData()) exchangedCurrency1 = null;
			if (exchangedCurrency2!=null && !exchangedCurrency2.prune().hasData()) exchangedCurrency2 = null;
			if (strike!=null && !strike.prune().hasData()) strike = null;
			if (counterCurrencyAmount!=null && !counterCurrencyAmount.prune().hasData()) counterCurrencyAmount = null;
			if (averageStrike!=null && !averageStrike.prune().hasData()) averageStrike = null;
			if (upperBound!=null && !upperBound.prune().hasData()) upperBound = null;
			if (lowerBound!=null && !lowerBound.prune().hasData()) lowerBound = null;
			if (leverage!=null && !leverage.prune().hasData()) leverage = null;
			payoffCap = payoffCap.stream().filter(b->b!=null).<FxPayoffCap.FxPayoffCapBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExchangedCurrency1()!=null && getExchangedCurrency1().hasData()) return true;
			if (getExchangedCurrency2()!=null && getExchangedCurrency2().hasData()) return true;
			if (getStrike()!=null && getStrike().hasData()) return true;
			if (getCounterCurrencyAmount()!=null && getCounterCurrencyAmount().hasData()) return true;
			if (getAverageStrike()!=null && getAverageStrike().hasData()) return true;
			if (getUpperBound()!=null && getUpperBound().hasData()) return true;
			if (getLowerBound()!=null && getLowerBound().hasData()) return true;
			if (getLeverage()!=null && getLeverage().hasData()) return true;
			if (getPayoffCap()!=null && getPayoffCap().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder o = (FxAccrualLinearPayoffRegion.FxAccrualLinearPayoffRegionBuilder) other;
			
			merger.mergeRosetta(getExchangedCurrency1(), o.getExchangedCurrency1(), this::setExchangedCurrency1);
			merger.mergeRosetta(getExchangedCurrency2(), o.getExchangedCurrency2(), this::setExchangedCurrency2);
			merger.mergeRosetta(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeRosetta(getCounterCurrencyAmount(), o.getCounterCurrencyAmount(), this::setCounterCurrencyAmount);
			merger.mergeRosetta(getAverageStrike(), o.getAverageStrike(), this::setAverageStrike);
			merger.mergeRosetta(getUpperBound(), o.getUpperBound(), this::setUpperBound);
			merger.mergeRosetta(getLowerBound(), o.getLowerBound(), this::setLowerBound);
			merger.mergeRosetta(getLeverage(), o.getLeverage(), this::setLeverage);
			merger.mergeRosetta(getPayoffCap(), o.getPayoffCap(), this::getOrCreatePayoffCap);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAccrualLinearPayoffRegion _that = getType().cast(o);
		
			if (!Objects.equals(exchangedCurrency1, _that.getExchangedCurrency1())) return false;
			if (!Objects.equals(exchangedCurrency2, _that.getExchangedCurrency2())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			if (!Objects.equals(averageStrike, _that.getAverageStrike())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(leverage, _that.getLeverage())) return false;
			if (!ListEquals.listEquals(payoffCap, _that.getPayoffCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exchangedCurrency1 != null ? exchangedCurrency1.hashCode() : 0);
			_result = 31 * _result + (exchangedCurrency2 != null ? exchangedCurrency2.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (averageStrike != null ? averageStrike.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (leverage != null ? leverage.hashCode() : 0);
			_result = 31 * _result + (payoffCap != null ? payoffCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualLinearPayoffRegionBuilder {" +
				"exchangedCurrency1=" + this.exchangedCurrency1 + ", " +
				"exchangedCurrency2=" + this.exchangedCurrency2 + ", " +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount + ", " +
				"averageStrike=" + this.averageStrike + ", " +
				"upperBound=" + this.upperBound + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"leverage=" + this.leverage + ", " +
				"payoffCap=" + this.payoffCap +
			'}' + " " + super.toString();
		}
	}
}
