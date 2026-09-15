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
import fpml.consolidated.fx.targets.meta.FxTargetSettlementPeriodPayoffMeta;
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
@RosettaDataType(value="FxTargetSettlementPeriodPayoff", builder=FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTargetSettlementPeriodPayoff", model="fpml", builder=FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilderImpl.class, version="2.1.1")
public interface FxTargetSettlementPeriodPayoff extends RosettaModelObject {

	FxTargetSettlementPeriodPayoffMeta metaData = new FxTargetSettlementPeriodPayoffMeta();

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
	FxTargetPayoffRegionReference getPayoffRegionReference();
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
	FxTargetSettlementPeriodPayoff build();
	
	FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder toBuilder();
	
	static FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder builder() {
		return new FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetSettlementPeriodPayoff> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTargetSettlementPeriodPayoff> getType() {
		return FxTargetSettlementPeriodPayoff.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payoffRegionReference"), processor, FxTargetPayoffRegionReference.class, getPayoffRegionReference());
		processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
		processor.processBasic(path.newSubPath("counterCurrencyAmount"), BigDecimal.class, getCounterCurrencyAmount(), this);
		processor.processBasic(path.newSubPath("lowerBound"), BigDecimal.class, getLowerBound(), this);
		processor.processBasic(path.newSubPath("upperBound"), BigDecimal.class, getUpperBound(), this);
		processRosetta(path.newSubPath("leverage"), processor, SettlementPeriodLeverage.class, getLeverage());
		processor.processBasic(path.newSubPath("payoffCap"), BigDecimal.class, getPayoffCap(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetSettlementPeriodPayoffBuilder extends FxTargetSettlementPeriodPayoff, RosettaModelObjectBuilder {
		FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder getOrCreatePayoffRegionReference();
		@Override
		FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder getPayoffRegionReference();
		SettlementPeriodLeverage.SettlementPeriodLeverageBuilder getOrCreateLeverage();
		@Override
		SettlementPeriodLeverage.SettlementPeriodLeverageBuilder getLeverage();
		FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder setPayoffRegionReference(FxTargetPayoffRegionReference payoffRegionReference);
		FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder setStrike(BigDecimal strike);
		FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder setCounterCurrencyAmount(BigDecimal counterCurrencyAmount);
		FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder setLowerBound(BigDecimal lowerBound);
		FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder setUpperBound(BigDecimal upperBound);
		FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder setLeverage(SettlementPeriodLeverage leverage);
		FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder setPayoffCap(BigDecimal payoffCap);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payoffRegionReference"), processor, FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder.class, getPayoffRegionReference());
			processor.processBasic(path.newSubPath("strike"), BigDecimal.class, getStrike(), this);
			processor.processBasic(path.newSubPath("counterCurrencyAmount"), BigDecimal.class, getCounterCurrencyAmount(), this);
			processor.processBasic(path.newSubPath("lowerBound"), BigDecimal.class, getLowerBound(), this);
			processor.processBasic(path.newSubPath("upperBound"), BigDecimal.class, getUpperBound(), this);
			processRosetta(path.newSubPath("leverage"), processor, SettlementPeriodLeverage.SettlementPeriodLeverageBuilder.class, getLeverage());
			processor.processBasic(path.newSubPath("payoffCap"), BigDecimal.class, getPayoffCap(), this);
		}
		

		FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetSettlementPeriodPayoff  ***********************/
	class FxTargetSettlementPeriodPayoffImpl implements FxTargetSettlementPeriodPayoff {
		private final FxTargetPayoffRegionReference payoffRegionReference;
		private final BigDecimal strike;
		private final BigDecimal counterCurrencyAmount;
		private final BigDecimal lowerBound;
		private final BigDecimal upperBound;
		private final SettlementPeriodLeverage leverage;
		private final BigDecimal payoffCap;
		
		protected FxTargetSettlementPeriodPayoffImpl(FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder builder) {
			this.payoffRegionReference = ofNullable(builder.getPayoffRegionReference()).map(f->f.build()).orElse(null);
			this.strike = builder.getStrike();
			this.counterCurrencyAmount = builder.getCounterCurrencyAmount();
			this.lowerBound = builder.getLowerBound();
			this.upperBound = builder.getUpperBound();
			this.leverage = ofNullable(builder.getLeverage()).map(f->f.build()).orElse(null);
			this.payoffCap = builder.getPayoffCap();
		}
		
		@Override
		@RosettaAttribute("payoffRegionReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payoffRegionReference")
		public FxTargetPayoffRegionReference getPayoffRegionReference() {
			return payoffRegionReference;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@Required
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
		public FxTargetSettlementPeriodPayoff build() {
			return this;
		}
		
		@Override
		public FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder toBuilder() {
			FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder builder) {
			ofNullable(getPayoffRegionReference()).ifPresent(builder::setPayoffRegionReference);
			ofNullable(getStrike()).ifPresent(builder::setStrike);
			ofNullable(getCounterCurrencyAmount()).ifPresent(builder::setCounterCurrencyAmount);
			ofNullable(getLowerBound()).ifPresent(builder::setLowerBound);
			ofNullable(getUpperBound()).ifPresent(builder::setUpperBound);
			ofNullable(getLeverage()).ifPresent(builder::setLeverage);
			ofNullable(getPayoffCap()).ifPresent(builder::setPayoffCap);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetSettlementPeriodPayoff _that = getType().cast(o);
		
			if (!Objects.equals(payoffRegionReference, _that.getPayoffRegionReference())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
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
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (leverage != null ? leverage.hashCode() : 0);
			_result = 31 * _result + (payoffCap != null ? payoffCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetSettlementPeriodPayoff {" +
				"payoffRegionReference=" + this.payoffRegionReference + ", " +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"upperBound=" + this.upperBound + ", " +
				"leverage=" + this.leverage + ", " +
				"payoffCap=" + this.payoffCap +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetSettlementPeriodPayoff  ***********************/
	class FxTargetSettlementPeriodPayoffBuilderImpl implements FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder {
	
		protected FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder payoffRegionReference;
		protected BigDecimal strike;
		protected BigDecimal counterCurrencyAmount;
		protected BigDecimal lowerBound;
		protected BigDecimal upperBound;
		protected SettlementPeriodLeverage.SettlementPeriodLeverageBuilder leverage;
		protected BigDecimal payoffCap;
		
		@Override
		@RosettaAttribute("payoffRegionReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("payoffRegionReference")
		public FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder getPayoffRegionReference() {
			return payoffRegionReference;
		}
		
		@Override
		public FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder getOrCreatePayoffRegionReference() {
			FxTargetPayoffRegionReference.FxTargetPayoffRegionReferenceBuilder result;
			if (payoffRegionReference!=null) {
				result = payoffRegionReference;
			}
			else {
				result = payoffRegionReference = FxTargetPayoffRegionReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strike")
		@Accessor(AccessorType.GETTER)
		@Required
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
		public FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder setPayoffRegionReference(FxTargetPayoffRegionReference _payoffRegionReference) {
			this.payoffRegionReference = _payoffRegionReference == null ? null : _payoffRegionReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strike")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("strike")
		@Override
		public FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder setStrike(BigDecimal _strike) {
			this.strike = _strike == null ? null : _strike;
			return this;
		}
		
		@RosettaAttribute("counterCurrencyAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterCurrencyAmount")
		@Override
		public FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder setCounterCurrencyAmount(BigDecimal _counterCurrencyAmount) {
			this.counterCurrencyAmount = _counterCurrencyAmount == null ? null : _counterCurrencyAmount;
			return this;
		}
		
		@RosettaAttribute("lowerBound")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lowerBound")
		@Override
		public FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder setLowerBound(BigDecimal _lowerBound) {
			this.lowerBound = _lowerBound == null ? null : _lowerBound;
			return this;
		}
		
		@RosettaAttribute("upperBound")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("upperBound")
		@Override
		public FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder setUpperBound(BigDecimal _upperBound) {
			this.upperBound = _upperBound == null ? null : _upperBound;
			return this;
		}
		
		@RosettaAttribute("leverage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leverage")
		@Override
		public FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder setLeverage(SettlementPeriodLeverage _leverage) {
			this.leverage = _leverage == null ? null : _leverage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payoffCap")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payoffCap")
		@Override
		public FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder setPayoffCap(BigDecimal _payoffCap) {
			this.payoffCap = _payoffCap == null ? null : _payoffCap;
			return this;
		}
		
		@Override
		public FxTargetSettlementPeriodPayoff build() {
			return new FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffImpl(this);
		}
		
		@Override
		public FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder prune() {
			if (payoffRegionReference!=null && !payoffRegionReference.prune().hasData()) payoffRegionReference = null;
			if (leverage!=null && !leverage.prune().hasData()) leverage = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayoffRegionReference()!=null && getPayoffRegionReference().hasData()) return true;
			if (getStrike()!=null) return true;
			if (getCounterCurrencyAmount()!=null) return true;
			if (getLowerBound()!=null) return true;
			if (getUpperBound()!=null) return true;
			if (getLeverage()!=null && getLeverage().hasData()) return true;
			if (getPayoffCap()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder o = (FxTargetSettlementPeriodPayoff.FxTargetSettlementPeriodPayoffBuilder) other;
			
			merger.mergeRosetta(getPayoffRegionReference(), o.getPayoffRegionReference(), this::setPayoffRegionReference);
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
		
			FxTargetSettlementPeriodPayoff _that = getType().cast(o);
		
			if (!Objects.equals(payoffRegionReference, _that.getPayoffRegionReference())) return false;
			if (!Objects.equals(strike, _that.getStrike())) return false;
			if (!Objects.equals(counterCurrencyAmount, _that.getCounterCurrencyAmount())) return false;
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
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (leverage != null ? leverage.hashCode() : 0);
			_result = 31 * _result + (payoffCap != null ? payoffCap.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetSettlementPeriodPayoffBuilder {" +
				"payoffRegionReference=" + this.payoffRegionReference + ", " +
				"strike=" + this.strike + ", " +
				"counterCurrencyAmount=" + this.counterCurrencyAmount + ", " +
				"lowerBound=" + this.lowerBound + ", " +
				"upperBound=" + this.upperBound + ", " +
				"leverage=" + this.leverage + ", " +
				"payoffCap=" + this.payoffCap +
			'}';
		}
	}
}
