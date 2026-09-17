package fpml.consolidated.eq.shared;

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
import fpml.consolidated.asset.ExchangeTradedContract;
import fpml.consolidated.eq.shared.meta.ReturnLegValuationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing the initial and final valuation of the underlyer.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the initial and final valuation of the underlyer.
 *
 */
@RosettaDataType(value="ReturnLegValuation", builder=ReturnLegValuation.ReturnLegValuationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReturnLegValuation", model="fpml", builder=ReturnLegValuation.ReturnLegValuationBuilderImpl.class, version="2.1.1")
public interface ReturnLegValuation extends RosettaModelObject {

	ReturnLegValuationMeta metaData = new ReturnLegValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the initial reference price of the underlyer. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the initial reference price of the underlyer. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 *
	 */
	ReturnLegValuationPrice getInitialPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For return swaps, this element is equivalent to the term "Equity Notional Reset" as defined in the ISDA 2002 Equity Derivatives Definitions. The reference to the ISDA definition is either "Applicable" or 'Inapplicable".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For return swaps, this element is equivalent to the term "Equity Notional Reset" as defined in the ISDA 2002 Equity Derivatives Definitions. The reference to the ISDA definition is either "Applicable" or 'Inapplicable".
	 *
	 */
	Boolean getNotionalReset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the final valuation price of the underlyer. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the final valuation price of the underlyer. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 *
	 */
	ReturnLegValuationPrice getValuationPriceInterim();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the final valuation price of the underlyer. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the final valuation price of the underlyer. This price can be expressed either as an actual amount/currency, as a determination method, or by reference to another value specified in the swap document.
	 *
	 */
	ReturnLegValuationPrice getValuationPriceFinal();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the payment dates of the swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the payment dates of the swap.
	 *
	 */
	ReturnSwapPaymentDates getPaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision References a Contract on the Exchange.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision References a Contract on the Exchange.
	 *
	 */
	ExchangeTradedContract getExchangeTradedContractNearest();

	/*********************** Build Methods  ***********************/
	ReturnLegValuation build();
	
	ReturnLegValuation.ReturnLegValuationBuilder toBuilder();
	
	static ReturnLegValuation.ReturnLegValuationBuilder builder() {
		return new ReturnLegValuation.ReturnLegValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnLegValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReturnLegValuation> getType() {
		return ReturnLegValuation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initialPrice"), processor, ReturnLegValuationPrice.class, getInitialPrice());
		processor.processBasic(path.newSubPath("notionalReset"), Boolean.class, getNotionalReset(), this);
		processRosetta(path.newSubPath("valuationPriceInterim"), processor, ReturnLegValuationPrice.class, getValuationPriceInterim());
		processRosetta(path.newSubPath("valuationPriceFinal"), processor, ReturnLegValuationPrice.class, getValuationPriceFinal());
		processRosetta(path.newSubPath("paymentDates"), processor, ReturnSwapPaymentDates.class, getPaymentDates());
		processRosetta(path.newSubPath("exchangeTradedContractNearest"), processor, ExchangeTradedContract.class, getExchangeTradedContractNearest());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnLegValuationBuilder extends ReturnLegValuation, RosettaModelObjectBuilder {
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getOrCreateInitialPrice();
		@Override
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getInitialPrice();
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getOrCreateValuationPriceInterim();
		@Override
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getValuationPriceInterim();
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getOrCreateValuationPriceFinal();
		@Override
		ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getValuationPriceFinal();
		ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder getOrCreatePaymentDates();
		@Override
		ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder getPaymentDates();
		ExchangeTradedContract.ExchangeTradedContractBuilder getOrCreateExchangeTradedContractNearest();
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder getExchangeTradedContractNearest();
		ReturnLegValuation.ReturnLegValuationBuilder setInitialPrice(ReturnLegValuationPrice initialPrice);
		ReturnLegValuation.ReturnLegValuationBuilder setNotionalReset(Boolean notionalReset);
		ReturnLegValuation.ReturnLegValuationBuilder setValuationPriceInterim(ReturnLegValuationPrice valuationPriceInterim);
		ReturnLegValuation.ReturnLegValuationBuilder setValuationPriceFinal(ReturnLegValuationPrice valuationPriceFinal);
		ReturnLegValuation.ReturnLegValuationBuilder setPaymentDates(ReturnSwapPaymentDates paymentDates);
		ReturnLegValuation.ReturnLegValuationBuilder setExchangeTradedContractNearest(ExchangeTradedContract exchangeTradedContractNearest);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initialPrice"), processor, ReturnLegValuationPrice.ReturnLegValuationPriceBuilder.class, getInitialPrice());
			processor.processBasic(path.newSubPath("notionalReset"), Boolean.class, getNotionalReset(), this);
			processRosetta(path.newSubPath("valuationPriceInterim"), processor, ReturnLegValuationPrice.ReturnLegValuationPriceBuilder.class, getValuationPriceInterim());
			processRosetta(path.newSubPath("valuationPriceFinal"), processor, ReturnLegValuationPrice.ReturnLegValuationPriceBuilder.class, getValuationPriceFinal());
			processRosetta(path.newSubPath("paymentDates"), processor, ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder.class, getPaymentDates());
			processRosetta(path.newSubPath("exchangeTradedContractNearest"), processor, ExchangeTradedContract.ExchangeTradedContractBuilder.class, getExchangeTradedContractNearest());
		}
		

		ReturnLegValuation.ReturnLegValuationBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnLegValuation  ***********************/
	class ReturnLegValuationImpl implements ReturnLegValuation {
		private final ReturnLegValuationPrice initialPrice;
		private final Boolean notionalReset;
		private final ReturnLegValuationPrice valuationPriceInterim;
		private final ReturnLegValuationPrice valuationPriceFinal;
		private final ReturnSwapPaymentDates paymentDates;
		private final ExchangeTradedContract exchangeTradedContractNearest;
		
		protected ReturnLegValuationImpl(ReturnLegValuation.ReturnLegValuationBuilder builder) {
			this.initialPrice = ofNullable(builder.getInitialPrice()).map(f->f.build()).orElse(null);
			this.notionalReset = builder.getNotionalReset();
			this.valuationPriceInterim = ofNullable(builder.getValuationPriceInterim()).map(f->f.build()).orElse(null);
			this.valuationPriceFinal = ofNullable(builder.getValuationPriceFinal()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.exchangeTradedContractNearest = ofNullable(builder.getExchangeTradedContractNearest()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initialPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialPrice")
		public ReturnLegValuationPrice getInitialPrice() {
			return initialPrice;
		}
		
		@Override
		@RosettaAttribute("notionalReset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalReset")
		public Boolean getNotionalReset() {
			return notionalReset;
		}
		
		@Override
		@RosettaAttribute("valuationPriceInterim")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationPriceInterim")
		public ReturnLegValuationPrice getValuationPriceInterim() {
			return valuationPriceInterim;
		}
		
		@Override
		@RosettaAttribute("valuationPriceFinal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationPriceFinal")
		public ReturnLegValuationPrice getValuationPriceFinal() {
			return valuationPriceFinal;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDates")
		public ReturnSwapPaymentDates getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		@RosettaAttribute("exchangeTradedContractNearest")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeTradedContractNearest")
		public ExchangeTradedContract getExchangeTradedContractNearest() {
			return exchangeTradedContractNearest;
		}
		
		@Override
		public ReturnLegValuation build() {
			return this;
		}
		
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder toBuilder() {
			ReturnLegValuation.ReturnLegValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnLegValuation.ReturnLegValuationBuilder builder) {
			ofNullable(getInitialPrice()).ifPresent(builder::setInitialPrice);
			ofNullable(getNotionalReset()).ifPresent(builder::setNotionalReset);
			ofNullable(getValuationPriceInterim()).ifPresent(builder::setValuationPriceInterim);
			ofNullable(getValuationPriceFinal()).ifPresent(builder::setValuationPriceFinal);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getExchangeTradedContractNearest()).ifPresent(builder::setExchangeTradedContractNearest);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnLegValuation _that = getType().cast(o);
		
			if (!Objects.equals(initialPrice, _that.getInitialPrice())) return false;
			if (!Objects.equals(notionalReset, _that.getNotionalReset())) return false;
			if (!Objects.equals(valuationPriceInterim, _that.getValuationPriceInterim())) return false;
			if (!Objects.equals(valuationPriceFinal, _that.getValuationPriceFinal())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(exchangeTradedContractNearest, _that.getExchangeTradedContractNearest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialPrice != null ? initialPrice.hashCode() : 0);
			_result = 31 * _result + (notionalReset != null ? notionalReset.hashCode() : 0);
			_result = 31 * _result + (valuationPriceInterim != null ? valuationPriceInterim.hashCode() : 0);
			_result = 31 * _result + (valuationPriceFinal != null ? valuationPriceFinal.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (exchangeTradedContractNearest != null ? exchangeTradedContractNearest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnLegValuation {" +
				"initialPrice=" + this.initialPrice + ", " +
				"notionalReset=" + this.notionalReset + ", " +
				"valuationPriceInterim=" + this.valuationPriceInterim + ", " +
				"valuationPriceFinal=" + this.valuationPriceFinal + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"exchangeTradedContractNearest=" + this.exchangeTradedContractNearest +
			'}';
		}
	}

	/*********************** Builder Implementation of ReturnLegValuation  ***********************/
	class ReturnLegValuationBuilderImpl implements ReturnLegValuation.ReturnLegValuationBuilder {
	
		protected ReturnLegValuationPrice.ReturnLegValuationPriceBuilder initialPrice;
		protected Boolean notionalReset;
		protected ReturnLegValuationPrice.ReturnLegValuationPriceBuilder valuationPriceInterim;
		protected ReturnLegValuationPrice.ReturnLegValuationPriceBuilder valuationPriceFinal;
		protected ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder paymentDates;
		protected ExchangeTradedContract.ExchangeTradedContractBuilder exchangeTradedContractNearest;
		
		@Override
		@RosettaAttribute("initialPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialPrice")
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getInitialPrice() {
			return initialPrice;
		}
		
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getOrCreateInitialPrice() {
			ReturnLegValuationPrice.ReturnLegValuationPriceBuilder result;
			if (initialPrice!=null) {
				result = initialPrice;
			}
			else {
				result = initialPrice = ReturnLegValuationPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalReset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalReset")
		public Boolean getNotionalReset() {
			return notionalReset;
		}
		
		@Override
		@RosettaAttribute("valuationPriceInterim")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationPriceInterim")
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getValuationPriceInterim() {
			return valuationPriceInterim;
		}
		
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getOrCreateValuationPriceInterim() {
			ReturnLegValuationPrice.ReturnLegValuationPriceBuilder result;
			if (valuationPriceInterim!=null) {
				result = valuationPriceInterim;
			}
			else {
				result = valuationPriceInterim = ReturnLegValuationPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationPriceFinal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationPriceFinal")
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getValuationPriceFinal() {
			return valuationPriceFinal;
		}
		
		@Override
		public ReturnLegValuationPrice.ReturnLegValuationPriceBuilder getOrCreateValuationPriceFinal() {
			ReturnLegValuationPrice.ReturnLegValuationPriceBuilder result;
			if (valuationPriceFinal!=null) {
				result = valuationPriceFinal;
			}
			else {
				result = valuationPriceFinal = ReturnLegValuationPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDates")
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder getOrCreatePaymentDates() {
			ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder result;
			if (paymentDates!=null) {
				result = paymentDates;
			}
			else {
				result = paymentDates = ReturnSwapPaymentDates.builder();
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
		
		@RosettaAttribute("initialPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialPrice")
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder setInitialPrice(ReturnLegValuationPrice _initialPrice) {
			this.initialPrice = _initialPrice == null ? null : _initialPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalReset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalReset")
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder setNotionalReset(Boolean _notionalReset) {
			this.notionalReset = _notionalReset == null ? null : _notionalReset;
			return this;
		}
		
		@RosettaAttribute("valuationPriceInterim")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationPriceInterim")
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder setValuationPriceInterim(ReturnLegValuationPrice _valuationPriceInterim) {
			this.valuationPriceInterim = _valuationPriceInterim == null ? null : _valuationPriceInterim.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationPriceFinal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationPriceFinal")
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder setValuationPriceFinal(ReturnLegValuationPrice _valuationPriceFinal) {
			this.valuationPriceFinal = _valuationPriceFinal == null ? null : _valuationPriceFinal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDates")
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder setPaymentDates(ReturnSwapPaymentDates _paymentDates) {
			this.paymentDates = _paymentDates == null ? null : _paymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeTradedContractNearest")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeTradedContractNearest")
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder setExchangeTradedContractNearest(ExchangeTradedContract _exchangeTradedContractNearest) {
			this.exchangeTradedContractNearest = _exchangeTradedContractNearest == null ? null : _exchangeTradedContractNearest.toBuilder();
			return this;
		}
		
		@Override
		public ReturnLegValuation build() {
			return new ReturnLegValuation.ReturnLegValuationImpl(this);
		}
		
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder prune() {
			if (initialPrice!=null && !initialPrice.prune().hasData()) initialPrice = null;
			if (valuationPriceInterim!=null && !valuationPriceInterim.prune().hasData()) valuationPriceInterim = null;
			if (valuationPriceFinal!=null && !valuationPriceFinal.prune().hasData()) valuationPriceFinal = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			if (exchangeTradedContractNearest!=null && !exchangeTradedContractNearest.prune().hasData()) exchangeTradedContractNearest = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialPrice()!=null && getInitialPrice().hasData()) return true;
			if (getNotionalReset()!=null) return true;
			if (getValuationPriceInterim()!=null && getValuationPriceInterim().hasData()) return true;
			if (getValuationPriceFinal()!=null && getValuationPriceFinal().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getExchangeTradedContractNearest()!=null && getExchangeTradedContractNearest().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnLegValuation.ReturnLegValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReturnLegValuation.ReturnLegValuationBuilder o = (ReturnLegValuation.ReturnLegValuationBuilder) other;
			
			merger.mergeRosetta(getInitialPrice(), o.getInitialPrice(), this::setInitialPrice);
			merger.mergeRosetta(getValuationPriceInterim(), o.getValuationPriceInterim(), this::setValuationPriceInterim);
			merger.mergeRosetta(getValuationPriceFinal(), o.getValuationPriceFinal(), this::setValuationPriceFinal);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			merger.mergeRosetta(getExchangeTradedContractNearest(), o.getExchangeTradedContractNearest(), this::setExchangeTradedContractNearest);
			
			merger.mergeBasic(getNotionalReset(), o.getNotionalReset(), this::setNotionalReset);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnLegValuation _that = getType().cast(o);
		
			if (!Objects.equals(initialPrice, _that.getInitialPrice())) return false;
			if (!Objects.equals(notionalReset, _that.getNotionalReset())) return false;
			if (!Objects.equals(valuationPriceInterim, _that.getValuationPriceInterim())) return false;
			if (!Objects.equals(valuationPriceFinal, _that.getValuationPriceFinal())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(exchangeTradedContractNearest, _that.getExchangeTradedContractNearest())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialPrice != null ? initialPrice.hashCode() : 0);
			_result = 31 * _result + (notionalReset != null ? notionalReset.hashCode() : 0);
			_result = 31 * _result + (valuationPriceInterim != null ? valuationPriceInterim.hashCode() : 0);
			_result = 31 * _result + (valuationPriceFinal != null ? valuationPriceFinal.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (exchangeTradedContractNearest != null ? exchangeTradedContractNearest.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnLegValuationBuilder {" +
				"initialPrice=" + this.initialPrice + ", " +
				"notionalReset=" + this.notionalReset + ", " +
				"valuationPriceInterim=" + this.valuationPriceInterim + ", " +
				"valuationPriceFinal=" + this.valuationPriceFinal + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"exchangeTradedContractNearest=" + this.exchangeTradedContractNearest +
			'}';
		}
	}
}
