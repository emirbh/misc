package fpml.consolidated.fx.accruals;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.fx.accruals.meta.FxAccrualSettlementPeriodPayoffMeta;
import fpml.consolidated.fx.targets.SettlementPeriodFixingDates;
import fpml.consolidated.fx.targets.SettlementPeriodLeverage;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Payoff region
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Payoff region
 *
 */
@RosettaDataType(value="FxAccrualSettlementPeriodPayoff", builder=FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxAccrualSettlementPeriodPayoff", model="fpml", builder=FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilderImpl.class, version="2.1.1")
public interface FxAccrualSettlementPeriodPayoff extends RosettaModelObject {

	FxAccrualSettlementPeriodPayoffMeta metaData = new FxAccrualSettlementPeriodPayoffMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Optional reference to the Payoff Region in the parametric representation of the product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Optional reference to the Payoff Region in the parametric representation of the product.
	 *
	 */
	FxAccrualPayoffRegionReference getPayoffRegionReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Strike for the settlement period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Strike for the settlement period.
	 *
	 */
	BigDecimal getStrike();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Counter Currency Amount for the settlement period. Multiple Counter Currency Amount elements may appear if there are more than one strike in the settlement period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Counter Currency Amount for the settlement period. Multiple Counter Currency Amount elements may appear if there are more than one strike in the settlement period.
	 *
	 */
	BigDecimal getCounterCurrencyAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Average Strike Fixing Dates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Average Strike Fixing Dates.
	 *
	 */
	SettlementPeriodFixingDates getAverageStrikeFixingDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Average Rate Fixing Dates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Average Rate Fixing Dates.
	 *
	 */
	SettlementPeriodFixingDates getAverageRateFixingDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Lower bound to the region.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Lower bound to the region.
	 *
	 */
	BigDecimal getLowerBound();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Upper bound to the region.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Upper bound to the region.
	 *
	 */
	BigDecimal getUpperBound();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Leverage within the period expressed as either an amount or ratio.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Leverage within the period expressed as either an amount or ratio.
	 *
	 */
	SettlementPeriodLeverage getLeverage();
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
	BigDecimal getPayoffCap();

	/*********************** Build Methods  ***********************/
	FxAccrualSettlementPeriodPayoff build();
	
	FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder toBuilder();
	
	static FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder builder() {
		return new FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualSettlementPeriodPayoff> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxAccrualSettlementPeriodPayoff> getType() {
		return FxAccrualSettlementPeriodPayoff.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payoffRegionReference"), processor, FxAccrualPayoffRegionReference.class, getPayoffRegionReference());
		processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
		processor.processBasic(path.newSubPath("counterCurrencyAmount"), BigDecimal.class, getCounterCurrencyAmount(), this);
		processRosetta(path.newSubPath("averageStrikeFixingDates"), processor, SettlementPeriodFixingDates.class, getAverageStrikeFixingDates());
		processRosetta(path.newSubPath("averageRateFixingDates"), processor, SettlementPeriodFixingDates.class, getAverageRateFixingDates());
		processor.processBasic(path.newSubPath("lowerBound"), BigDecimal.class, getLowerBound(), this);
		processor.processBasic(path.newSubPath("upperBound"), BigDecimal.class, getUpperBound(), this);
		processRosetta(path.newSubPath("leverage"), processor, SettlementPeriodLeverage.class, getLeverage());
		processor.processBasic(path.newSubPath("payoffCap"), BigDecimal.class, getPayoffCap(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualSettlementPeriodPayoffBuilder extends FxAccrualSettlementPeriodPayoff, RosettaModelObjectBuilder {
		FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder getOrCreatePayoffRegionReference();
		@Override
		FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder getPayoffRegionReference();
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getOrCreateAverageStrikeFixingDates();
		@Override
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getAverageStrikeFixingDates();
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getOrCreateAverageRateFixingDates();
		@Override
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getAverageRateFixingDates();
		SettlementPeriodLeverage.SettlementPeriodLeverageBuilder getOrCreateLeverage();
		@Override
		SettlementPeriodLeverage.SettlementPeriodLeverageBuilder getLeverage();
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setPayoffRegionReference(FxAccrualPayoffRegionReference payoffRegionReference);
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setStrike(BigDecimal strike);
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setCounterCurrencyAmount(BigDecimal counterCurrencyAmount);
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setAverageStrikeFixingDates(SettlementPeriodFixingDates averageStrikeFixingDates);
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setAverageRateFixingDates(SettlementPeriodFixingDates averageRateFixingDates);
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setLowerBound(BigDecimal lowerBound);
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setUpperBound(BigDecimal upperBound);
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setLeverage(SettlementPeriodLeverage leverage);
		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setPayoffCap(BigDecimal payoffCap);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payoffRegionReference"), processor, FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder.class, getPayoffRegionReference());
			processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
			processor.processBasic(path.newSubPath("counterCurrencyAmount"), BigDecimal.class, getCounterCurrencyAmount(), this);
			processRosetta(path.newSubPath("averageStrikeFixingDates"), processor, SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder.class, getAverageStrikeFixingDates());
			processRosetta(path.newSubPath("averageRateFixingDates"), processor, SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder.class, getAverageRateFixingDates());
			processor.processBasic(path.newSubPath("lowerBound"), BigDecimal.class, getLowerBound(), this);
			processor.processBasic(path.newSubPath("upperBound"), BigDecimal.class, getUpperBound(), this);
			processRosetta(path.newSubPath("leverage"), processor, SettlementPeriodLeverage.SettlementPeriodLeverageBuilder.class, getLeverage());
			processor.processBasic(path.newSubPath("payoffCap"), BigDecimal.class, getPayoffCap(), this);
		}
		

		FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualSettlementPeriodPayoff  ***********************/
	class FxAccrualSettlementPeriodPayoffImpl implements FxAccrualSettlementPeriodPayoff {
		private final FxAccrualPayoffRegionReference payoffRegionReference;
		private final BigDecimal strike;
		private final BigDecimal counterCurrencyAmount;
		private final SettlementPeriodFixingDates averageStrikeFixingDates;
		private final SettlementPeriodFixingDates averageRateFixingDates;
		private final BigDecimal lowerBound;
		private final BigDecimal upperBound;
		private final SettlementPeriodLeverage leverage;
		private final BigDecimal payoffCap;
		
		protected FxAccrualSettlementPeriodPayoffImpl(FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder builder) {
			this.payoffRegionReference = ofNullable(builder.getPayoffRegionReference()).map(f->f.build()).orElse(null);
			this.strike = builder.getStrike();
			this.counterCurrencyAmount = builder.getCounterCurrencyAmount();
			this.averageStrikeFixingDates = ofNullable(builder.getAverageStrikeFixingDates()).map(f->f.build()).orElse(null);
			this.averageRateFixingDates = ofNullable(builder.getAverageRateFixingDates()).map(f->f.build()).orElse(null);
			this.lowerBound = builder.getLowerBound();
			this.upperBound = builder.getUpperBound();
			this.leverage = ofNullable(builder.getLeverage()).map(f->f.build()).orElse(null);
			this.payoffCap = builder.getPayoffCap();
		}
		
		@Override
		@RosettaAttribute("payoffRegionReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payoffRegionReference")
		public FxAccrualPayoffRegionReference getPayoffRegionReference() {
			return payoffRegionReference;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterCurrencyAmount")
		public BigDecimal getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		@RosettaAttribute("averageStrikeFixingDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageStrikeFixingDates")
		public SettlementPeriodFixingDates getAverageStrikeFixingDates() {
			return averageStrikeFixingDates;
		}
		
		@Override
		@RosettaAttribute("averageRateFixingDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageRateFixingDates")
		public SettlementPeriodFixingDates getAverageRateFixingDates() {
			return averageRateFixingDates;
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lowerBound")
		public BigDecimal getLowerBound() {
			return lowerBound;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upperBound")
		public BigDecimal getUpperBound() {
			return upperBound;
		}
		
		@Override
		@RosettaAttribute("leverage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leverage")
		public SettlementPeriodLeverage getLeverage() {
			return leverage;
		}
		
		@Override
		@RosettaAttribute("payoffCap")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payoffCap")
		public BigDecimal getPayoffCap() {
			return payoffCap;
		}
		
		@Override
		public FxAccrualSettlementPeriodPayoff build() {
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder toBuilder() {
			FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder builder) {
			ofNullable(getPayoffRegionReference()).ifPresent(builder::setPayoffRegionReference);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
			ofNullable(getAverageStrikeFixingDates()).ifPresent(builder::setAverageStrikeFixingDates);
			ofNullable(getAverageRateFixingDates()).ifPresent(builder::setAverageRateFixingDates);
			ofNullable(getLowerBound()).ifPresent(builder::setLowerBound);
			ofNullable(getUpperBound()).ifPresent(builder::setUpperBound);
			ofNullable(getLeverage()).ifPresent(builder::setLeverage);
			ofNullable(getPayoffCap()).ifPresent(builder::setPayoffCap);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualSettlementPeriodPayoff _that = getType().cast(o);
		
			if (!Objects.equals(payoffRegionReference, _that.getPayoffRegionReference())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			if (!Objects.equals(averageStrikeFixingDates, _that.getAverageStrikeFixingDates())) return false;
			if (!Objects.equals(averageRateFixingDates, _that.getAverageRateFixingDates())) return false;
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(leverage, _that.getLeverage())) return false;
			if (!Objects.equals(payoffCap, _that.getPayoffCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payoffRegionReference != null ? payoffRegionReference.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (averageStrikeFixingDates != null ? averageStrikeFixingDates.hashCode() : 0);
			_result = 31 * _result + (averageRateFixingDates != null ? averageRateFixingDates.hashCode() : 0);
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (leverage != null ? leverage.hashCode() : 0);
			_result = 31 * _result + (payoffCap != null ? payoffCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualSettlementPeriodPayoff {" +
				"payoffRegionReference=" + this.payoffRegionReference + ", " +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount + ", " +
				"averageStrikeFixingDates=" + this.averageStrikeFixingDates + ", " +
				"averageRateFixingDates=" + this.averageRateFixingDates + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"upperBound=" + this.upperBound + ", " +
				"leverage=" + this.leverage + ", " +
				"payoffCap=" + this.payoffCap +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualSettlementPeriodPayoff  ***********************/
	class FxAccrualSettlementPeriodPayoffBuilderImpl implements FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder {
	
		protected FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder payoffRegionReference;
		protected BigDecimal strike;
		protected BigDecimal counterCurrencyAmount;
		protected SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder averageStrikeFixingDates;
		protected SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder averageRateFixingDates;
		protected BigDecimal lowerBound;
		protected BigDecimal upperBound;
		protected SettlementPeriodLeverage.SettlementPeriodLeverageBuilder leverage;
		protected BigDecimal payoffCap;
		
		@Override
		@RosettaAttribute("payoffRegionReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payoffRegionReference")
		public FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder getPayoffRegionReference() {
			return payoffRegionReference;
		}
		
		@Override
		public FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder getOrCreatePayoffRegionReference() {
			FxAccrualPayoffRegionReference.FxAccrualPayoffRegionReferenceBuilder result;
			if (payoffRegionReference!=null) {
				result = payoffRegionReference;
			}
			else {
				result = payoffRegionReference = FxAccrualPayoffRegionReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strike")
		public BigDecimal getStrike() {
			return strike;
		}
		
		@Override
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterCurrencyAmount")
		public BigDecimal getCounterCurrencyAmount() {
			return counterCurrencyAmount;
		}
		
		@Override
		@RosettaAttribute("averageStrikeFixingDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageStrikeFixingDates")
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getAverageStrikeFixingDates() {
			return averageStrikeFixingDates;
		}
		
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getOrCreateAverageStrikeFixingDates() {
			SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder result;
			if (averageStrikeFixingDates!=null) {
				result = averageStrikeFixingDates;
			}
			else {
				result = averageStrikeFixingDates = SettlementPeriodFixingDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averageRateFixingDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageRateFixingDates")
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getAverageRateFixingDates() {
			return averageRateFixingDates;
		}
		
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder getOrCreateAverageRateFixingDates() {
			SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder result;
			if (averageRateFixingDates!=null) {
				result = averageRateFixingDates;
			}
			else {
				result = averageRateFixingDates = SettlementPeriodFixingDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lowerBound")
		public BigDecimal getLowerBound() {
			return lowerBound;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upperBound")
		public BigDecimal getUpperBound() {
			return upperBound;
		}
		
		@Override
		@RosettaAttribute("leverage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leverage")
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder getLeverage() {
			return leverage;
		}
		
		@Override
		public SettlementPeriodLeverage.SettlementPeriodLeverageBuilder getOrCreateLeverage() {
			SettlementPeriodLeverage.SettlementPeriodLeverageBuilder result;
			if (leverage!=null) {
				result = leverage;
			}
			else {
				result = leverage = SettlementPeriodLeverage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payoffCap")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payoffCap")
		public BigDecimal getPayoffCap() {
			return payoffCap;
		}
		
		@RosettaAttribute("payoffRegionReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payoffRegionReference")
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setPayoffRegionReference(FxAccrualPayoffRegionReference _payoffRegionReference) {
			this.payoffRegionReference = _payoffRegionReference == null ? null : _payoffRegionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strike")
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setStrike(BigDecimal _strike) {
			this.strike = _strike == null ? null : _strike;
			return this;
		}
		
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterCurrencyAmount")
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setCounterCurrencyAmount(BigDecimal _counterCurrencyAmount) {
			this.counterCurrencyAmount = _counterCurrencyAmount == null ? null : _counterCurrencyAmount;
			return this;
		}
		
		@RosettaAttribute("averageStrikeFixingDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averageStrikeFixingDates")
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setAverageStrikeFixingDates(SettlementPeriodFixingDates _averageStrikeFixingDates) {
			this.averageStrikeFixingDates = _averageStrikeFixingDates == null ? null : _averageStrikeFixingDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averageRateFixingDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averageRateFixingDates")
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setAverageRateFixingDates(SettlementPeriodFixingDates _averageRateFixingDates) {
			this.averageRateFixingDates = _averageRateFixingDates == null ? null : _averageRateFixingDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lowerBound")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lowerBound")
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setLowerBound(BigDecimal _lowerBound) {
			this.lowerBound = _lowerBound == null ? null : _lowerBound;
			return this;
		}
		
		@RosettaAttribute("upperBound")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("upperBound")
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setUpperBound(BigDecimal _upperBound) {
			this.upperBound = _upperBound == null ? null : _upperBound;
			return this;
		}
		
		@RosettaAttribute("leverage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leverage")
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setLeverage(SettlementPeriodLeverage _leverage) {
			this.leverage = _leverage == null ? null : _leverage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payoffCap")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payoffCap")
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder setPayoffCap(BigDecimal _payoffCap) {
			this.payoffCap = _payoffCap == null ? null : _payoffCap;
			return this;
		}
		
		@Override
		public FxAccrualSettlementPeriodPayoff build() {
			return new FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffImpl(this);
		}
		
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder prune() {
			if (payoffRegionReference!=null && !payoffRegionReference.prune().hasData()) payoffRegionReference = null;
			if (averageStrikeFixingDates!=null && !averageStrikeFixingDates.prune().hasData()) averageStrikeFixingDates = null;
			if (averageRateFixingDates!=null && !averageRateFixingDates.prune().hasData()) averageRateFixingDates = null;
			if (leverage!=null && !leverage.prune().hasData()) leverage = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayoffRegionReference()!=null && getPayoffRegionReference().hasData()) return true;
			if (getStrike()!=null) return true;
			if (getCounterCurrencyAmount()!=null) return true;
			if (getAverageStrikeFixingDates()!=null && getAverageStrikeFixingDates().hasData()) return true;
			if (getAverageRateFixingDates()!=null && getAverageRateFixingDates().hasData()) return true;
			if (getLowerBound()!=null) return true;
			if (getUpperBound()!=null) return true;
			if (getLeverage()!=null && getLeverage().hasData()) return true;
			if (getPayoffCap()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder o = (FxAccrualSettlementPeriodPayoff.FxAccrualSettlementPeriodPayoffBuilder) other;
			
			merger.mergeRosetta(getPayoffRegionReference(), o.getPayoffRegionReference(), this::setPayoffRegionReference);
			merger.mergeRosetta(getAverageStrikeFixingDates(), o.getAverageStrikeFixingDates(), this::setAverageStrikeFixingDates);
			merger.mergeRosetta(getAverageRateFixingDates(), o.getAverageRateFixingDates(), this::setAverageRateFixingDates);
			merger.mergeRosetta(getLeverage(), o.getLeverage(), this::setLeverage);
			
			merger.mergeBasic(getStrike(), o.getStrike(), this::setStrike);
			merger.mergeBasic(getCounterCurrencyAmount(), o.getCounterCurrencyAmount(), this::setCounterCurrencyAmount);
			merger.mergeBasic(getLowerBound(), o.getLowerBound(), this::setLowerBound);
			merger.mergeBasic(getUpperBound(), o.getUpperBound(), this::setUpperBound);
			merger.mergeBasic(getPayoffCap(), o.getPayoffCap(), this::setPayoffCap);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualSettlementPeriodPayoff _that = getType().cast(o);
		
			if (!Objects.equals(payoffRegionReference, _that.getPayoffRegionReference())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
			if (!Objects.equals(averageStrikeFixingDates, _that.getAverageStrikeFixingDates())) return false;
			if (!Objects.equals(averageRateFixingDates, _that.getAverageRateFixingDates())) return false;
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(leverage, _that.getLeverage())) return false;
			if (!Objects.equals(payoffCap, _that.getPayoffCap())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payoffRegionReference != null ? payoffRegionReference.hashCode() : 0);
			_result = 31 * _result + (strike != null ? strike.hashCode() : 0);
			_result = 31 * _result + (counterCurrencyAmount != null ? counterCurrencyAmount.hashCode() : 0);
			_result = 31 * _result + (averageStrikeFixingDates != null ? averageStrikeFixingDates.hashCode() : 0);
			_result = 31 * _result + (averageRateFixingDates != null ? averageRateFixingDates.hashCode() : 0);
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (leverage != null ? leverage.hashCode() : 0);
			_result = 31 * _result + (payoffCap != null ? payoffCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualSettlementPeriodPayoffBuilder {" +
				"payoffRegionReference=" + this.payoffRegionReference + ", " +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount + ", " +
				"averageStrikeFixingDates=" + this.averageStrikeFixingDates + ", " +
				"averageRateFixingDates=" + this.averageRateFixingDates + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"upperBound=" + this.upperBound + ", " +
				"leverage=" + this.leverage + ", " +
				"payoffCap=" + this.payoffCap +
			'}';
		}
	}
}
