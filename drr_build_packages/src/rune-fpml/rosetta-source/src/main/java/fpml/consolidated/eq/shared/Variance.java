package fpml.consolidated.eq.shared;

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
import fpml.consolidated.asset.ExchangeTradedContract;
import fpml.consolidated.eq.shared.meta.VarianceMeta;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.NonNegativeMoney;
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
 * Provision A type describing the variance amount of a variance swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the variance amount of a variance swap.
 *
 */
@RosettaDataType(value="Variance", builder=Variance.VarianceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Variance", model="fpml", builder=Variance.VarianceBuilderImpl.class, version="2.1.1")
public interface Variance extends CalculationFromObservation {

	VarianceMeta metaData = new VarianceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Variance amount, which is a cash multiplier.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Variance amount, which is a cash multiplier.
	 *
	 */
	NonNegativeMoney getVarianceAmount();
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
	BigDecimal getVolatilityStrikePrice();
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
	BigDecimal getVarianceStrikePrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If present and true, then variance cap is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If present and true, then variance cap is applicable.
	 *
	 */
	Boolean getVarianceCap();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For use when varianceCap is applicable. Contains the scaling factor of the Variance Cap that can differ on a trade-by-trade basis in the European market. For example, a Variance Cap of 2.5^2 x Variance Strike Price has an unadjustedVarianceCap of 2.5.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For use when varianceCap is applicable. Contains the scaling factor of the Variance Cap that can differ on a trade-by-trade basis in the European market. For example, a Variance Cap of 2.5^2 x Variance Strike Price has an unadjustedVarianceCap of 2.5.
	 *
	 */
	BigDecimal getUnadjustedVarianceCap();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Conditions which bound variance. The contract specifies one or more boundary levels. These levels are expressed as prices for confirmation purposes Underlyer price must be equal to or higher than Lower Barrier is known as Up Conditional Swap Underlyer price must be equal to or lower than Upper Barrier is known as Down Conditional Swap Underlyer price must be equal to or higher than Lower Barrier and must be equal to or lower than Upper Barrier is known as Barrier Conditional Swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Conditions which bound variance. The contract specifies one or more boundary levels. These levels are expressed as prices for confirmation purposes Underlyer price must be equal to or higher than Lower Barrier is known as Up Conditional Swap Underlyer price must be equal to or lower than Upper Barrier is known as Down Conditional Swap Underlyer price must be equal to or higher than Lower Barrier and must be equal to or lower than Upper Barrier is known as Barrier Conditional Swap.
	 *
	 */
	BoundedVariance getBoundedVariance();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specification of the exchange traded contract nearest.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specification of the exchange traded contract nearest.
	 *
	 */
	ExchangeTradedContract getExchangeTradedContractNearest();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Vega Notional represents the approximate gain/loss at maturity for a 1% difference between RVol (realised vol) and KVol (strike vol). It does not necessarily represent the Vega Risk of the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Vega Notional represents the approximate gain/loss at maturity for a 1% difference between RVol (realised vol) and KVol (strike vol). It does not necessarily represent the Vega Risk of the trade.
	 *
	 */
	BigDecimal getVegaNotionalAmount();

	/*********************** Build Methods  ***********************/
	Variance build();
	
	Variance.VarianceBuilder toBuilder();
	
	static Variance.VarianceBuilder builder() {
		return new Variance.VarianceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Variance> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Variance> getType() {
		return Variance.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialLevel"), BigDecimal.class, getInitialLevel(), this);
		processRosetta(path.newSubPath("initialLevelSource"), processor, DeterminationMethod.class, getInitialLevelSource());
		processor.processBasic(path.newSubPath("closingLevel"), Boolean.class, getClosingLevel(), this);
		processor.processBasic(path.newSubPath("expiringLevel"), Boolean.class, getExpiringLevel(), this);
		processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
		processRosetta(path.newSubPath("varianceAmount"), processor, NonNegativeMoney.class, getVarianceAmount());
		processor.processBasic(path.newSubPath("volatilityStrikePrice"), BigDecimal.class, getVolatilityStrikePrice(), this);
		processor.processBasic(path.newSubPath("varianceStrikePrice"), BigDecimal.class, getVarianceStrikePrice(), this);
		processor.processBasic(path.newSubPath("varianceCap"), Boolean.class, getVarianceCap(), this);
		processor.processBasic(path.newSubPath("unadjustedVarianceCap"), BigDecimal.class, getUnadjustedVarianceCap(), this);
		processRosetta(path.newSubPath("boundedVariance"), processor, BoundedVariance.class, getBoundedVariance());
		processRosetta(path.newSubPath("exchangeTradedContractNearest"), processor, ExchangeTradedContract.class, getExchangeTradedContractNearest());
		processor.processBasic(path.newSubPath("vegaNotionalAmount"), BigDecimal.class, getVegaNotionalAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface VarianceBuilder extends Variance, CalculationFromObservation.CalculationFromObservationBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateVarianceAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getVarianceAmount();
		BoundedVariance.BoundedVarianceBuilder getOrCreateBoundedVariance();
		@Override
		BoundedVariance.BoundedVarianceBuilder getBoundedVariance();
		ExchangeTradedContract.ExchangeTradedContractBuilder getOrCreateExchangeTradedContractNearest();
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder getExchangeTradedContractNearest();
		@Override
		Variance.VarianceBuilder setInitialLevel(BigDecimal initialLevel);
		@Override
		Variance.VarianceBuilder setInitialLevelSource(DeterminationMethod initialLevelSource);
		@Override
		Variance.VarianceBuilder setClosingLevel(Boolean closingLevel);
		@Override
		Variance.VarianceBuilder setExpiringLevel(Boolean expiringLevel);
		@Override
		Variance.VarianceBuilder setExpectedN(Integer expectedN);
		Variance.VarianceBuilder setVarianceAmount(NonNegativeMoney varianceAmount);
		Variance.VarianceBuilder setVolatilityStrikePrice(BigDecimal volatilityStrikePrice);
		Variance.VarianceBuilder setVarianceStrikePrice(BigDecimal varianceStrikePrice);
		Variance.VarianceBuilder setVarianceCap(Boolean varianceCap);
		Variance.VarianceBuilder setUnadjustedVarianceCap(BigDecimal unadjustedVarianceCap);
		Variance.VarianceBuilder setBoundedVariance(BoundedVariance boundedVariance);
		Variance.VarianceBuilder setExchangeTradedContractNearest(ExchangeTradedContract exchangeTradedContractNearest);
		Variance.VarianceBuilder setVegaNotionalAmount(BigDecimal vegaNotionalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialLevel"), BigDecimal.class, getInitialLevel(), this);
			processRosetta(path.newSubPath("initialLevelSource"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getInitialLevelSource());
			processor.processBasic(path.newSubPath("closingLevel"), Boolean.class, getClosingLevel(), this);
			processor.processBasic(path.newSubPath("expiringLevel"), Boolean.class, getExpiringLevel(), this);
			processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
			processRosetta(path.newSubPath("varianceAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getVarianceAmount());
			processor.processBasic(path.newSubPath("volatilityStrikePrice"), BigDecimal.class, getVolatilityStrikePrice(), this);
			processor.processBasic(path.newSubPath("varianceStrikePrice"), BigDecimal.class, getVarianceStrikePrice(), this);
			processor.processBasic(path.newSubPath("varianceCap"), Boolean.class, getVarianceCap(), this);
			processor.processBasic(path.newSubPath("unadjustedVarianceCap"), BigDecimal.class, getUnadjustedVarianceCap(), this);
			processRosetta(path.newSubPath("boundedVariance"), processor, BoundedVariance.BoundedVarianceBuilder.class, getBoundedVariance());
			processRosetta(path.newSubPath("exchangeTradedContractNearest"), processor, ExchangeTradedContract.ExchangeTradedContractBuilder.class, getExchangeTradedContractNearest());
			processor.processBasic(path.newSubPath("vegaNotionalAmount"), BigDecimal.class, getVegaNotionalAmount(), this);
		}
		

		Variance.VarianceBuilder prune();
	}

	/*********************** Immutable Implementation of Variance  ***********************/
	class VarianceImpl extends CalculationFromObservation.CalculationFromObservationImpl implements Variance {
		private final NonNegativeMoney varianceAmount;
		private final BigDecimal volatilityStrikePrice;
		private final BigDecimal varianceStrikePrice;
		private final Boolean varianceCap;
		private final BigDecimal unadjustedVarianceCap;
		private final BoundedVariance boundedVariance;
		private final ExchangeTradedContract exchangeTradedContractNearest;
		private final BigDecimal vegaNotionalAmount;
		
		protected VarianceImpl(Variance.VarianceBuilder builder) {
			super(builder);
			this.varianceAmount = ofNullable(builder.getVarianceAmount()).map(f->f.build()).orElse(null);
			this.volatilityStrikePrice = builder.getVolatilityStrikePrice();
			this.varianceStrikePrice = builder.getVarianceStrikePrice();
			this.varianceCap = builder.getVarianceCap();
			this.unadjustedVarianceCap = builder.getUnadjustedVarianceCap();
			this.boundedVariance = ofNullable(builder.getBoundedVariance()).map(f->f.build()).orElse(null);
			this.exchangeTradedContractNearest = ofNullable(builder.getExchangeTradedContractNearest()).map(f->f.build()).orElse(null);
			this.vegaNotionalAmount = builder.getVegaNotionalAmount();
		}
		
		@Override
		@RosettaAttribute("varianceAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("varianceAmount")
		public NonNegativeMoney getVarianceAmount() {
			return varianceAmount;
		}
		
		@Override
		@RosettaAttribute("volatilityStrikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("volatilityStrikePrice")
		public BigDecimal getVolatilityStrikePrice() {
			return volatilityStrikePrice;
		}
		
		@Override
		@RosettaAttribute("varianceStrikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("varianceStrikePrice")
		public BigDecimal getVarianceStrikePrice() {
			return varianceStrikePrice;
		}
		
		@Override
		@RosettaAttribute("varianceCap")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("varianceCap")
		public Boolean getVarianceCap() {
			return varianceCap;
		}
		
		@Override
		@RosettaAttribute("unadjustedVarianceCap")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedVarianceCap")
		public BigDecimal getUnadjustedVarianceCap() {
			return unadjustedVarianceCap;
		}
		
		@Override
		@RosettaAttribute("boundedVariance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("boundedVariance")
		public BoundedVariance getBoundedVariance() {
			return boundedVariance;
		}
		
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeTradedContractNearest")
		public ExchangeTradedContract getExchangeTradedContractNearest() {
			return exchangeTradedContractNearest;
		}
		
		@Override
		@RosettaAttribute("vegaNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vegaNotionalAmount")
		public BigDecimal getVegaNotionalAmount() {
			return vegaNotionalAmount;
		}
		
		@Override
		public Variance build() {
			return this;
		}
		
		@Override
		public Variance.VarianceBuilder toBuilder() {
			Variance.VarianceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Variance.VarianceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getVarianceAmount()).ifPresent(builder::setVarianceAmount);
			ofNullable(getVolatilityStrikePrice()).ifPresent(builder::setVolatilityStrikePrice);
			ofNullable(getVarianceStrikePrice()).ifPresent(builder::setVarianceStrikePrice);
			ofNullable(getVarianceCap()).ifPresent(builder::setVarianceCap);
			ofNullable(getUnadjustedVarianceCap()).ifPresent(builder::setUnadjustedVarianceCap);
			ofNullable(getBoundedVariance()).ifPresent(builder::setBoundedVariance);
			ofNullable(getExchangeTradedContractNearest()).ifPresent(builder::setExchangeTradedContractNearest);
			ofNullable(getVegaNotionalAmount()).ifPresent(builder::setVegaNotionalAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Variance _that = getType().cast(o);
		
			if (!Objects.equals(varianceAmount, _that.getVarianceAmount())) return false;
			if (!Objects.equals(volatilityStrikePrice, _that.getVolatilityStrikePrice())) return false;
			if (!Objects.equals(varianceStrikePrice, _that.getVarianceStrikePrice())) return false;
			if (!Objects.equals(varianceCap, _that.getVarianceCap())) return false;
			if (!Objects.equals(unadjustedVarianceCap, _that.getUnadjustedVarianceCap())) return false;
			if (!Objects.equals(boundedVariance, _that.getBoundedVariance())) return false;
			if (!Objects.equals(exchangeTradedContractNearest, _that.getExchangeTradedContractNearest())) return false;
			if (!Objects.equals(vegaNotionalAmount, _that.getVegaNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (varianceAmount != null ? varianceAmount.hashCode() : 0);
			_result = 31 * _result + (volatilityStrikePrice != null ? volatilityStrikePrice.hashCode() : 0);
			_result = 31 * _result + (varianceStrikePrice != null ? varianceStrikePrice.hashCode() : 0);
			_result = 31 * _result + (varianceCap != null ? varianceCap.hashCode() : 0);
			_result = 31 * _result + (unadjustedVarianceCap != null ? unadjustedVarianceCap.hashCode() : 0);
			_result = 31 * _result + (boundedVariance != null ? boundedVariance.hashCode() : 0);
			_result = 31 * _result + (exchangeTradedContractNearest != null ? exchangeTradedContractNearest.hashCode() : 0);
			_result = 31 * _result + (vegaNotionalAmount != null ? vegaNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Variance {" +
				"varianceAmount=" + this.varianceAmount + ", " +
				"volatilityStrikePrice=" + this.volatilityStrikePrice + ", " +
				"varianceStrikePrice=" + this.varianceStrikePrice + ", " +
				"varianceCap=" + this.varianceCap + ", " +
				"unadjustedVarianceCap=" + this.unadjustedVarianceCap + ", " +
				"boundedVariance=" + this.boundedVariance + ", " +
				"exchangeTradedContractNearest=" + this.exchangeTradedContractNearest + ", " +
				"vegaNotionalAmount=" + this.vegaNotionalAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Variance  ***********************/
	class VarianceBuilderImpl extends CalculationFromObservation.CalculationFromObservationBuilderImpl implements Variance.VarianceBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder varianceAmount;
		protected BigDecimal volatilityStrikePrice;
		protected BigDecimal varianceStrikePrice;
		protected Boolean varianceCap;
		protected BigDecimal unadjustedVarianceCap;
		protected BoundedVariance.BoundedVarianceBuilder boundedVariance;
		protected ExchangeTradedContract.ExchangeTradedContractBuilder exchangeTradedContractNearest;
		protected BigDecimal vegaNotionalAmount;
		
		@Override
		@RosettaAttribute("varianceAmount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("varianceAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getVarianceAmount() {
			return varianceAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateVarianceAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (varianceAmount!=null) {
				result = varianceAmount;
			}
			else {
				result = varianceAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("volatilityStrikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("volatilityStrikePrice")
		public BigDecimal getVolatilityStrikePrice() {
			return volatilityStrikePrice;
		}
		
		@Override
		@RosettaAttribute("varianceStrikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("varianceStrikePrice")
		public BigDecimal getVarianceStrikePrice() {
			return varianceStrikePrice;
		}
		
		@Override
		@RosettaAttribute("varianceCap")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("varianceCap")
		public Boolean getVarianceCap() {
			return varianceCap;
		}
		
		@Override
		@RosettaAttribute("unadjustedVarianceCap")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedVarianceCap")
		public BigDecimal getUnadjustedVarianceCap() {
			return unadjustedVarianceCap;
		}
		
		@Override
		@RosettaAttribute("boundedVariance")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("boundedVariance")
		public BoundedVariance.BoundedVarianceBuilder getBoundedVariance() {
			return boundedVariance;
		}
		
		@Override
		public BoundedVariance.BoundedVarianceBuilder getOrCreateBoundedVariance() {
			BoundedVariance.BoundedVarianceBuilder result;
			if (boundedVariance!=null) {
				result = boundedVariance;
			}
			else {
				result = boundedVariance = BoundedVariance.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeTradedContractNearest")
		public ExchangeTradedContract.ExchangeTradedContractBuilder getExchangeTradedContractNearest() {
			return exchangeTradedContractNearest;
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder getOrCreateExchangeTradedContractNearest() {
			ExchangeTradedContract.ExchangeTradedContractBuilder result;
			if (exchangeTradedContractNearest!=null) {
				result = exchangeTradedContractNearest;
			}
			else {
				result = exchangeTradedContractNearest = ExchangeTradedContract.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vegaNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("vegaNotionalAmount")
		public BigDecimal getVegaNotionalAmount() {
			return vegaNotionalAmount;
		}
		
		@RosettaAttribute("initialLevel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialLevel")
		@Override
		public Variance.VarianceBuilder setInitialLevel(BigDecimal _initialLevel) {
			this.initialLevel = _initialLevel == null ? null : _initialLevel;
			return this;
		}
		
		@RosettaAttribute("initialLevelSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialLevelSource")
		@Override
		public Variance.VarianceBuilder setInitialLevelSource(DeterminationMethod _initialLevelSource) {
			this.initialLevelSource = _initialLevelSource == null ? null : _initialLevelSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("closingLevel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("closingLevel")
		@Override
		public Variance.VarianceBuilder setClosingLevel(Boolean _closingLevel) {
			this.closingLevel = _closingLevel == null ? null : _closingLevel;
			return this;
		}
		
		@RosettaAttribute("expiringLevel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiringLevel")
		@Override
		public Variance.VarianceBuilder setExpiringLevel(Boolean _expiringLevel) {
			this.expiringLevel = _expiringLevel == null ? null : _expiringLevel;
			return this;
		}
		
		@RosettaAttribute("expectedN")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedN")
		@Override
		public Variance.VarianceBuilder setExpectedN(Integer _expectedN) {
			this.expectedN = _expectedN == null ? null : _expectedN;
			return this;
		}
		
		@RosettaAttribute("varianceAmount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("varianceAmount")
		@Override
		public Variance.VarianceBuilder setVarianceAmount(NonNegativeMoney _varianceAmount) {
			this.varianceAmount = _varianceAmount == null ? null : _varianceAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("volatilityStrikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("volatilityStrikePrice")
		@Override
		public Variance.VarianceBuilder setVolatilityStrikePrice(BigDecimal _volatilityStrikePrice) {
			this.volatilityStrikePrice = _volatilityStrikePrice == null ? null : _volatilityStrikePrice;
			return this;
		}
		
		@RosettaAttribute("varianceStrikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("varianceStrikePrice")
		@Override
		public Variance.VarianceBuilder setVarianceStrikePrice(BigDecimal _varianceStrikePrice) {
			this.varianceStrikePrice = _varianceStrikePrice == null ? null : _varianceStrikePrice;
			return this;
		}
		
		@RosettaAttribute("varianceCap")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("varianceCap")
		@Override
		public Variance.VarianceBuilder setVarianceCap(Boolean _varianceCap) {
			this.varianceCap = _varianceCap == null ? null : _varianceCap;
			return this;
		}
		
		@RosettaAttribute("unadjustedVarianceCap")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedVarianceCap")
		@Override
		public Variance.VarianceBuilder setUnadjustedVarianceCap(BigDecimal _unadjustedVarianceCap) {
			this.unadjustedVarianceCap = _unadjustedVarianceCap == null ? null : _unadjustedVarianceCap;
			return this;
		}
		
		@RosettaAttribute("boundedVariance")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("boundedVariance")
		@Override
		public Variance.VarianceBuilder setBoundedVariance(BoundedVariance _boundedVariance) {
			this.boundedVariance = _boundedVariance == null ? null : _boundedVariance.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeTradedContractNearest")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeTradedContractNearest")
		@Override
		public Variance.VarianceBuilder setExchangeTradedContractNearest(ExchangeTradedContract _exchangeTradedContractNearest) {
			this.exchangeTradedContractNearest = _exchangeTradedContractNearest == null ? null : _exchangeTradedContractNearest.toBuilder();
			return this;
		}
		
		@RosettaAttribute("vegaNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("vegaNotionalAmount")
		@Override
		public Variance.VarianceBuilder setVegaNotionalAmount(BigDecimal _vegaNotionalAmount) {
			this.vegaNotionalAmount = _vegaNotionalAmount == null ? null : _vegaNotionalAmount;
			return this;
		}
		
		@Override
		public Variance build() {
			return new Variance.VarianceImpl(this);
		}
		
		@Override
		public Variance.VarianceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Variance.VarianceBuilder prune() {
			super.prune();
			if (varianceAmount!=null && !varianceAmount.prune().hasData()) varianceAmount = null;
			if (boundedVariance!=null && !boundedVariance.prune().hasData()) boundedVariance = null;
			if (exchangeTradedContractNearest!=null && !exchangeTradedContractNearest.prune().hasData()) exchangeTradedContractNearest = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getVarianceAmount()!=null && getVarianceAmount().hasData()) return true;
			if (getVolatilityStrikePrice()!=null) return true;
			if (getVarianceStrikePrice()!=null) return true;
			if (getVarianceCap()!=null) return true;
			if (getUnadjustedVarianceCap()!=null) return true;
			if (getBoundedVariance()!=null && getBoundedVariance().hasData()) return true;
			if (getExchangeTradedContractNearest()!=null && getExchangeTradedContractNearest().hasData()) return true;
			if (getVegaNotionalAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Variance.VarianceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Variance.VarianceBuilder o = (Variance.VarianceBuilder) other;
			
			merger.mergeRosetta(getVarianceAmount(), o.getVarianceAmount(), this::setVarianceAmount);
			merger.mergeRosetta(getBoundedVariance(), o.getBoundedVariance(), this::setBoundedVariance);
			merger.mergeRosetta(getExchangeTradedContractNearest(), o.getExchangeTradedContractNearest(), this::setExchangeTradedContractNearest);
			
			merger.mergeBasic(getVolatilityStrikePrice(), o.getVolatilityStrikePrice(), this::setVolatilityStrikePrice);
			merger.mergeBasic(getVarianceStrikePrice(), o.getVarianceStrikePrice(), this::setVarianceStrikePrice);
			merger.mergeBasic(getVarianceCap(), o.getVarianceCap(), this::setVarianceCap);
			merger.mergeBasic(getUnadjustedVarianceCap(), o.getUnadjustedVarianceCap(), this::setUnadjustedVarianceCap);
			merger.mergeBasic(getVegaNotionalAmount(), o.getVegaNotionalAmount(), this::setVegaNotionalAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Variance _that = getType().cast(o);
		
			if (!Objects.equals(varianceAmount, _that.getVarianceAmount())) return false;
			if (!Objects.equals(volatilityStrikePrice, _that.getVolatilityStrikePrice())) return false;
			if (!Objects.equals(varianceStrikePrice, _that.getVarianceStrikePrice())) return false;
			if (!Objects.equals(varianceCap, _that.getVarianceCap())) return false;
			if (!Objects.equals(unadjustedVarianceCap, _that.getUnadjustedVarianceCap())) return false;
			if (!Objects.equals(boundedVariance, _that.getBoundedVariance())) return false;
			if (!Objects.equals(exchangeTradedContractNearest, _that.getExchangeTradedContractNearest())) return false;
			if (!Objects.equals(vegaNotionalAmount, _that.getVegaNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (varianceAmount != null ? varianceAmount.hashCode() : 0);
			_result = 31 * _result + (volatilityStrikePrice != null ? volatilityStrikePrice.hashCode() : 0);
			_result = 31 * _result + (varianceStrikePrice != null ? varianceStrikePrice.hashCode() : 0);
			_result = 31 * _result + (varianceCap != null ? varianceCap.hashCode() : 0);
			_result = 31 * _result + (unadjustedVarianceCap != null ? unadjustedVarianceCap.hashCode() : 0);
			_result = 31 * _result + (boundedVariance != null ? boundedVariance.hashCode() : 0);
			_result = 31 * _result + (exchangeTradedContractNearest != null ? exchangeTradedContractNearest.hashCode() : 0);
			_result = 31 * _result + (vegaNotionalAmount != null ? vegaNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceBuilder {" +
				"varianceAmount=" + this.varianceAmount + ", " +
				"volatilityStrikePrice=" + this.volatilityStrikePrice + ", " +
				"varianceStrikePrice=" + this.varianceStrikePrice + ", " +
				"varianceCap=" + this.varianceCap + ", " +
				"unadjustedVarianceCap=" + this.unadjustedVarianceCap + ", " +
				"boundedVariance=" + this.boundedVariance + ", " +
				"exchangeTradedContractNearest=" + this.exchangeTradedContractNearest + ", " +
				"vegaNotionalAmount=" + this.vegaNotionalAmount +
			'}' + " " + super.toString();
		}
	}
}
