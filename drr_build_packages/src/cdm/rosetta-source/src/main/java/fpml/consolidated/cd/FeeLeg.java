package fpml.consolidated.cd;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.cd.meta.FeeLegMeta;
import fpml.consolidated.fpmlenum.QuotationStyleEnum;
import fpml.consolidated.shared.Leg;
import java.math.BigDecimal;
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
@RosettaDataType(value="FeeLeg", builder=FeeLeg.FeeLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FeeLeg", model="fpml", builder=FeeLeg.FeeLegBuilderImpl.class, version="2.1.1")
public interface FeeLeg extends Leg {

	FeeLegMeta metaData = new FeeLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies a single fixed payment that is payable by the payer to the receiver on the initial payment date. The fixed payment to be paid is specified in terms of a known currency amount. This element should be used for CDS Index trades, Standard CDS trades, and can be used for CDS trades where it is necessary to represent a payment from Seller to Buyer. For CDS trades where a payment is to be made from Buyer to Seller the feeLeg/singlePayment structure must be used.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies a single fixed payment that is payable by the payer to the receiver on the initial payment date. The fixed payment to be paid is specified in terms of a known currency amount. This element should be used for CDS Index trades, Standard CDS trades, and can be used for CDS trades where it is necessary to represent a payment from Seller to Buyer. For CDS trades where a payment is to be made from Buyer to Seller the feeLeg/singlePayment structure must be used.
	 *
	 */
	InitialPayment getInitialPayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies a single fixed amount that is payable by the buyer to the seller on the fixed rate payer payment date. The fixed amount to be paid is specified in terms of a known currency amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies a single fixed amount that is payable by the buyer to the seller on the fixed rate payer payment date. The fixed amount to be paid is specified in terms of a known currency amount.
	 *
	 */
	List<? extends SinglePayment> getSinglePayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies a periodic schedule of fixed amounts that are payable by the buyer to the seller on the fixed rate payer payment dates. The fixed amount to be paid on each payment date can be specified in terms of a known currency amount or as an amount calculated on a formula basis by reference to a per annum fixed rate. The applicable business day convention and business day for adjusting any fixed rate payer payment date if it would otherwise fall on a day that is not a business day are those specified in the dateAdjustments element within the generalTerms component. ISDA 2003 Term:
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies a periodic schedule of fixed amounts that are payable by the buyer to the seller on the fixed rate payer payment dates. The fixed amount to be paid on each payment date can be specified in terms of a known currency amount or as an amount calculated on a formula basis by reference to a per annum fixed rate. The applicable business day convention and business day for adjusting any fixed rate payer payment date if it would otherwise fall on a day that is not a business day are those specified in the dateAdjustments element within the generalTerms component. ISDA 2003 Term:
	 *
	 */
	PeriodicPayment getPeriodicPayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional element that only has meaning in a credit index trade. This element contains the credit spread ("fair value") at which the trade was executed. Unlike the fixedRate of an index, the marketFixedRate varies over the life of the index depending on market conditions. The marketFixedRate is the price of the index as quoted by trading desks.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional element that only has meaning in a credit index trade. This element contains the credit spread ("fair value") at which the trade was executed. Unlike the fixedRate of an index, the marketFixedRate varies over the life of the index depending on market conditions. The marketFixedRate is the price of the index as quoted by trading desks.
	 *
	 */
	BigDecimal getMarketFixedRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Applicable to CDS on MBS to specify whether payment delays are applicable to the fixed Amount. RMBS typically have a payment delay of 5 days between the coupon date of the reference obligation and the payment date of the synthetic swap. CMBS do not, on the other hand, with both payment dates being on the 25th of each month.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Applicable to CDS on MBS to specify whether payment delays are applicable to the fixed Amount. RMBS typically have a payment delay of 5 days between the coupon date of the reference obligation and the payment date of the synthetic swap. CMBS do not, on the other hand, with both payment dates being on the 25th of each month.
	 *
	 */
	Boolean getPaymentDelay();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional element that contains the up-front points expressed as a percentage of the notional. An initialPoints value of 5% would be represented as 0.05. The initialPoints element is an alternative to marketFixedRate in quoting the traded level of a trade. When initialPoints is used, the traded level is the sum of fixedRate and initialPoints. The initialPoints is one of the items that are factored into the initialPayment calculation and is payable by the Buyer to the Seller. Note that initialPoints and marketFixedRate may both be present in the same document when both implied values are desired.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional element that contains the up-front points expressed as a percentage of the notional. An initialPoints value of 5% would be represented as 0.05. The initialPoints element is an alternative to marketFixedRate in quoting the traded level of a trade. When initialPoints is used, the traded level is the sum of fixedRate and initialPoints. The initialPoints is one of the items that are factored into the initialPayment calculation and is payable by the Buyer to the Seller. Note that initialPoints and marketFixedRate may both be present in the same document when both implied values are desired.
	 *
	 */
	BigDecimal getInitialPoints();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An optional element that only has meaning in a credit index trade. This element contains the price at which the trade was executed and is used instead of marketFixedRate on credit trades on certain indicies which are quoted using a price rather than a spread.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional element that only has meaning in a credit index trade. This element contains the price at which the trade was executed and is used instead of marketFixedRate on credit trades on certain indicies which are quoted using a price rather than a spread.
	 *
	 */
	BigDecimal getMarketPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of quotation that was used between the trading desks. The purpose of this element is to indicate the actual quotation style that was used to quote this trade which may not be apparent when both marketFixedRate and initialPoints are included in the document. When quotationStyle is ‘PointsUpFront’, the initialPoints element should be populated. When quotationStyle is ‘TradedSpread’, the marketFixedRate element should be populated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of quotation that was used between the trading desks. The purpose of this element is to indicate the actual quotation style that was used to quote this trade which may not be apparent when both marketFixedRate and initialPoints are included in the document. When quotationStyle is ‘PointsUpFront’, the initialPoints element should be populated. When quotationStyle is ‘TradedSpread’, the marketFixedRate element should be populated.
	 *
	 */
	QuotationStyleEnum getQuotationStyle();

	/*********************** Build Methods  ***********************/
	FeeLeg build();
	
	FeeLeg.FeeLegBuilder toBuilder();
	
	static FeeLeg.FeeLegBuilder builder() {
		return new FeeLeg.FeeLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FeeLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FeeLeg> getType() {
		return FeeLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("initialPayment"), processor, InitialPayment.class, getInitialPayment());
		processRosetta(path.newSubPath("singlePayment"), processor, SinglePayment.class, getSinglePayment());
		processRosetta(path.newSubPath("periodicPayment"), processor, PeriodicPayment.class, getPeriodicPayment());
		processor.processBasic(path.newSubPath("marketFixedRate"), BigDecimal.class, getMarketFixedRate(), this);
		processor.processBasic(path.newSubPath("paymentDelay"), Boolean.class, getPaymentDelay(), this);
		processor.processBasic(path.newSubPath("initialPoints"), BigDecimal.class, getInitialPoints(), this);
		processor.processBasic(path.newSubPath("marketPrice"), BigDecimal.class, getMarketPrice(), this);
		processor.processBasic(path.newSubPath("quotationStyle"), QuotationStyleEnum.class, getQuotationStyle(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FeeLegBuilder extends FeeLeg, Leg.LegBuilder {
		InitialPayment.InitialPaymentBuilder getOrCreateInitialPayment();
		@Override
		InitialPayment.InitialPaymentBuilder getInitialPayment();
		SinglePayment.SinglePaymentBuilder getOrCreateSinglePayment(int index);
		@Override
		List<? extends SinglePayment.SinglePaymentBuilder> getSinglePayment();
		PeriodicPayment.PeriodicPaymentBuilder getOrCreatePeriodicPayment();
		@Override
		PeriodicPayment.PeriodicPaymentBuilder getPeriodicPayment();
		@Override
		FeeLeg.FeeLegBuilder setId(String id);
		FeeLeg.FeeLegBuilder setInitialPayment(InitialPayment initialPayment);
		FeeLeg.FeeLegBuilder addSinglePayment(SinglePayment singlePayment);
		FeeLeg.FeeLegBuilder addSinglePayment(SinglePayment singlePayment, int idx);
		FeeLeg.FeeLegBuilder addSinglePayment(List<? extends SinglePayment> singlePayment);
		FeeLeg.FeeLegBuilder setSinglePayment(List<? extends SinglePayment> singlePayment);
		FeeLeg.FeeLegBuilder setPeriodicPayment(PeriodicPayment periodicPayment);
		FeeLeg.FeeLegBuilder setMarketFixedRate(BigDecimal marketFixedRate);
		FeeLeg.FeeLegBuilder setPaymentDelay(Boolean paymentDelay);
		FeeLeg.FeeLegBuilder setInitialPoints(BigDecimal initialPoints);
		FeeLeg.FeeLegBuilder setMarketPrice(BigDecimal marketPrice);
		FeeLeg.FeeLegBuilder setQuotationStyle(QuotationStyleEnum quotationStyle);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("initialPayment"), processor, InitialPayment.InitialPaymentBuilder.class, getInitialPayment());
			processRosetta(path.newSubPath("singlePayment"), processor, SinglePayment.SinglePaymentBuilder.class, getSinglePayment());
			processRosetta(path.newSubPath("periodicPayment"), processor, PeriodicPayment.PeriodicPaymentBuilder.class, getPeriodicPayment());
			processor.processBasic(path.newSubPath("marketFixedRate"), BigDecimal.class, getMarketFixedRate(), this);
			processor.processBasic(path.newSubPath("paymentDelay"), Boolean.class, getPaymentDelay(), this);
			processor.processBasic(path.newSubPath("initialPoints"), BigDecimal.class, getInitialPoints(), this);
			processor.processBasic(path.newSubPath("marketPrice"), BigDecimal.class, getMarketPrice(), this);
			processor.processBasic(path.newSubPath("quotationStyle"), QuotationStyleEnum.class, getQuotationStyle(), this);
		}
		

		FeeLeg.FeeLegBuilder prune();
	}

	/*********************** Immutable Implementation of FeeLeg  ***********************/
	class FeeLegImpl extends Leg.LegImpl implements FeeLeg {
		private final InitialPayment initialPayment;
		private final List<? extends SinglePayment> singlePayment;
		private final PeriodicPayment periodicPayment;
		private final BigDecimal marketFixedRate;
		private final Boolean paymentDelay;
		private final BigDecimal initialPoints;
		private final BigDecimal marketPrice;
		private final QuotationStyleEnum quotationStyle;
		
		protected FeeLegImpl(FeeLeg.FeeLegBuilder builder) {
			super(builder);
			this.initialPayment = ofNullable(builder.getInitialPayment()).map(f->f.build()).orElse(null);
			this.singlePayment = ofNullable(builder.getSinglePayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.periodicPayment = ofNullable(builder.getPeriodicPayment()).map(f->f.build()).orElse(null);
			this.marketFixedRate = builder.getMarketFixedRate();
			this.paymentDelay = builder.getPaymentDelay();
			this.initialPoints = builder.getInitialPoints();
			this.marketPrice = builder.getMarketPrice();
			this.quotationStyle = builder.getQuotationStyle();
		}
		
		@Override
		@RosettaAttribute("initialPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialPayment")
		public InitialPayment getInitialPayment() {
			return initialPayment;
		}
		
		@Override
		@RosettaAttribute("singlePayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("singlePayment")
		public List<? extends SinglePayment> getSinglePayment() {
			return singlePayment;
		}
		
		@Override
		@RosettaAttribute("periodicPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("periodicPayment")
		public PeriodicPayment getPeriodicPayment() {
			return periodicPayment;
		}
		
		@Override
		@RosettaAttribute("marketFixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketFixedRate")
		public BigDecimal getMarketFixedRate() {
			return marketFixedRate;
		}
		
		@Override
		@RosettaAttribute("paymentDelay")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDelay")
		public Boolean getPaymentDelay() {
			return paymentDelay;
		}
		
		@Override
		@RosettaAttribute("initialPoints")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialPoints")
		public BigDecimal getInitialPoints() {
			return initialPoints;
		}
		
		@Override
		@RosettaAttribute("marketPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketPrice")
		public BigDecimal getMarketPrice() {
			return marketPrice;
		}
		
		@Override
		@RosettaAttribute("quotationStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotationStyle")
		public QuotationStyleEnum getQuotationStyle() {
			return quotationStyle;
		}
		
		@Override
		public FeeLeg build() {
			return this;
		}
		
		@Override
		public FeeLeg.FeeLegBuilder toBuilder() {
			FeeLeg.FeeLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FeeLeg.FeeLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInitialPayment()).ifPresent(builder::setInitialPayment);
			ofNullable(getSinglePayment()).ifPresent(builder::setSinglePayment);
			ofNullable(getPeriodicPayment()).ifPresent(builder::setPeriodicPayment);
			ofNullable(getMarketFixedRate()).ifPresent(builder::setMarketFixedRate);
			ofNullable(getPaymentDelay()).ifPresent(builder::setPaymentDelay);
			ofNullable(getInitialPoints()).ifPresent(builder::setInitialPoints);
			ofNullable(getMarketPrice()).ifPresent(builder::setMarketPrice);
			ofNullable(getQuotationStyle()).ifPresent(builder::setQuotationStyle);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FeeLeg _that = getType().cast(o);
		
			if (!Objects.equals(initialPayment, _that.getInitialPayment())) return false;
			if (!ListEquals.listEquals(singlePayment, _that.getSinglePayment())) return false;
			if (!Objects.equals(periodicPayment, _that.getPeriodicPayment())) return false;
			if (!Objects.equals(marketFixedRate, _that.getMarketFixedRate())) return false;
			if (!Objects.equals(paymentDelay, _that.getPaymentDelay())) return false;
			if (!Objects.equals(initialPoints, _that.getInitialPoints())) return false;
			if (!Objects.equals(marketPrice, _that.getMarketPrice())) return false;
			if (!Objects.equals(quotationStyle, _that.getQuotationStyle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (initialPayment != null ? initialPayment.hashCode() : 0);
			_result = 31 * _result + (singlePayment != null ? singlePayment.hashCode() : 0);
			_result = 31 * _result + (periodicPayment != null ? periodicPayment.hashCode() : 0);
			_result = 31 * _result + (marketFixedRate != null ? marketFixedRate.hashCode() : 0);
			_result = 31 * _result + (paymentDelay != null ? paymentDelay.hashCode() : 0);
			_result = 31 * _result + (initialPoints != null ? initialPoints.hashCode() : 0);
			_result = 31 * _result + (marketPrice != null ? marketPrice.hashCode() : 0);
			_result = 31 * _result + (quotationStyle != null ? quotationStyle.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeLeg {" +
				"initialPayment=" + this.initialPayment + ", " +
				"singlePayment=" + this.singlePayment + ", " +
				"periodicPayment=" + this.periodicPayment + ", " +
				"marketFixedRate=" + this.marketFixedRate + ", " +
				"paymentDelay=" + this.paymentDelay + ", " +
				"initialPoints=" + this.initialPoints + ", " +
				"marketPrice=" + this.marketPrice + ", " +
				"quotationStyle=" + this.quotationStyle +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FeeLeg  ***********************/
	class FeeLegBuilderImpl extends Leg.LegBuilderImpl implements FeeLeg.FeeLegBuilder {
	
		protected InitialPayment.InitialPaymentBuilder initialPayment;
		protected List<SinglePayment.SinglePaymentBuilder> singlePayment = new ArrayList<>();
		protected PeriodicPayment.PeriodicPaymentBuilder periodicPayment;
		protected BigDecimal marketFixedRate;
		protected Boolean paymentDelay;
		protected BigDecimal initialPoints;
		protected BigDecimal marketPrice;
		protected QuotationStyleEnum quotationStyle;
		
		@Override
		@RosettaAttribute("initialPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialPayment")
		public InitialPayment.InitialPaymentBuilder getInitialPayment() {
			return initialPayment;
		}
		
		@Override
		public InitialPayment.InitialPaymentBuilder getOrCreateInitialPayment() {
			InitialPayment.InitialPaymentBuilder result;
			if (initialPayment!=null) {
				result = initialPayment;
			}
			else {
				result = initialPayment = InitialPayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("singlePayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("singlePayment")
		public List<? extends SinglePayment.SinglePaymentBuilder> getSinglePayment() {
			return singlePayment;
		}
		
		@Override
		public SinglePayment.SinglePaymentBuilder getOrCreateSinglePayment(int index) {
			if (singlePayment==null) {
				this.singlePayment = new ArrayList<>();
			}
			return getIndex(singlePayment, index, () -> {
						SinglePayment.SinglePaymentBuilder newSinglePayment = SinglePayment.builder();
						return newSinglePayment;
					});
		}
		
		@Override
		@RosettaAttribute("periodicPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("periodicPayment")
		public PeriodicPayment.PeriodicPaymentBuilder getPeriodicPayment() {
			return periodicPayment;
		}
		
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder getOrCreatePeriodicPayment() {
			PeriodicPayment.PeriodicPaymentBuilder result;
			if (periodicPayment!=null) {
				result = periodicPayment;
			}
			else {
				result = periodicPayment = PeriodicPayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("marketFixedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketFixedRate")
		public BigDecimal getMarketFixedRate() {
			return marketFixedRate;
		}
		
		@Override
		@RosettaAttribute("paymentDelay")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDelay")
		public Boolean getPaymentDelay() {
			return paymentDelay;
		}
		
		@Override
		@RosettaAttribute("initialPoints")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialPoints")
		public BigDecimal getInitialPoints() {
			return initialPoints;
		}
		
		@Override
		@RosettaAttribute("marketPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketPrice")
		public BigDecimal getMarketPrice() {
			return marketPrice;
		}
		
		@Override
		@RosettaAttribute("quotationStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quotationStyle")
		public QuotationStyleEnum getQuotationStyle() {
			return quotationStyle;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FeeLeg.FeeLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("initialPayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialPayment")
		@Override
		public FeeLeg.FeeLegBuilder setInitialPayment(InitialPayment _initialPayment) {
			this.initialPayment = _initialPayment == null ? null : _initialPayment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("singlePayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("singlePayment")
		@Override
		public FeeLeg.FeeLegBuilder addSinglePayment(SinglePayment _singlePayment) {
			if (_singlePayment != null) {
				this.singlePayment.add(_singlePayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public FeeLeg.FeeLegBuilder addSinglePayment(SinglePayment _singlePayment, int idx) {
			getIndex(this.singlePayment, idx, () -> _singlePayment.toBuilder());
			return this;
		}
		
		@Override
		public FeeLeg.FeeLegBuilder addSinglePayment(List<? extends SinglePayment> singlePayments) {
			if (singlePayments != null) {
				for (final SinglePayment toAdd : singlePayments) {
					this.singlePayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("singlePayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("singlePayment")
		@Override
		public FeeLeg.FeeLegBuilder setSinglePayment(List<? extends SinglePayment> singlePayments) {
			if (singlePayments == null) {
				this.singlePayment = new ArrayList<>();
			} else {
				this.singlePayment = singlePayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("periodicPayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periodicPayment")
		@Override
		public FeeLeg.FeeLegBuilder setPeriodicPayment(PeriodicPayment _periodicPayment) {
			this.periodicPayment = _periodicPayment == null ? null : _periodicPayment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("marketFixedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketFixedRate")
		@Override
		public FeeLeg.FeeLegBuilder setMarketFixedRate(BigDecimal _marketFixedRate) {
			this.marketFixedRate = _marketFixedRate == null ? null : _marketFixedRate;
			return this;
		}
		
		@RosettaAttribute("paymentDelay")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDelay")
		@Override
		public FeeLeg.FeeLegBuilder setPaymentDelay(Boolean _paymentDelay) {
			this.paymentDelay = _paymentDelay == null ? null : _paymentDelay;
			return this;
		}
		
		@RosettaAttribute("initialPoints")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialPoints")
		@Override
		public FeeLeg.FeeLegBuilder setInitialPoints(BigDecimal _initialPoints) {
			this.initialPoints = _initialPoints == null ? null : _initialPoints;
			return this;
		}
		
		@RosettaAttribute("marketPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketPrice")
		@Override
		public FeeLeg.FeeLegBuilder setMarketPrice(BigDecimal _marketPrice) {
			this.marketPrice = _marketPrice == null ? null : _marketPrice;
			return this;
		}
		
		@RosettaAttribute("quotationStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quotationStyle")
		@Override
		public FeeLeg.FeeLegBuilder setQuotationStyle(QuotationStyleEnum _quotationStyle) {
			this.quotationStyle = _quotationStyle == null ? null : _quotationStyle;
			return this;
		}
		
		@Override
		public FeeLeg build() {
			return new FeeLeg.FeeLegImpl(this);
		}
		
		@Override
		public FeeLeg.FeeLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeLeg.FeeLegBuilder prune() {
			super.prune();
			if (initialPayment!=null && !initialPayment.prune().hasData()) initialPayment = null;
			singlePayment = singlePayment.stream().filter(b->b!=null).<SinglePayment.SinglePaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (periodicPayment!=null && !periodicPayment.prune().hasData()) periodicPayment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInitialPayment()!=null && getInitialPayment().hasData()) return true;
			if (getSinglePayment()!=null && getSinglePayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPeriodicPayment()!=null && getPeriodicPayment().hasData()) return true;
			if (getMarketFixedRate()!=null) return true;
			if (getPaymentDelay()!=null) return true;
			if (getInitialPoints()!=null) return true;
			if (getMarketPrice()!=null) return true;
			if (getQuotationStyle()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeLeg.FeeLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FeeLeg.FeeLegBuilder o = (FeeLeg.FeeLegBuilder) other;
			
			merger.mergeRosetta(getInitialPayment(), o.getInitialPayment(), this::setInitialPayment);
			merger.mergeRosetta(getSinglePayment(), o.getSinglePayment(), this::getOrCreateSinglePayment);
			merger.mergeRosetta(getPeriodicPayment(), o.getPeriodicPayment(), this::setPeriodicPayment);
			
			merger.mergeBasic(getMarketFixedRate(), o.getMarketFixedRate(), this::setMarketFixedRate);
			merger.mergeBasic(getPaymentDelay(), o.getPaymentDelay(), this::setPaymentDelay);
			merger.mergeBasic(getInitialPoints(), o.getInitialPoints(), this::setInitialPoints);
			merger.mergeBasic(getMarketPrice(), o.getMarketPrice(), this::setMarketPrice);
			merger.mergeBasic(getQuotationStyle(), o.getQuotationStyle(), this::setQuotationStyle);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FeeLeg _that = getType().cast(o);
		
			if (!Objects.equals(initialPayment, _that.getInitialPayment())) return false;
			if (!ListEquals.listEquals(singlePayment, _that.getSinglePayment())) return false;
			if (!Objects.equals(periodicPayment, _that.getPeriodicPayment())) return false;
			if (!Objects.equals(marketFixedRate, _that.getMarketFixedRate())) return false;
			if (!Objects.equals(paymentDelay, _that.getPaymentDelay())) return false;
			if (!Objects.equals(initialPoints, _that.getInitialPoints())) return false;
			if (!Objects.equals(marketPrice, _that.getMarketPrice())) return false;
			if (!Objects.equals(quotationStyle, _that.getQuotationStyle())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (initialPayment != null ? initialPayment.hashCode() : 0);
			_result = 31 * _result + (singlePayment != null ? singlePayment.hashCode() : 0);
			_result = 31 * _result + (periodicPayment != null ? periodicPayment.hashCode() : 0);
			_result = 31 * _result + (marketFixedRate != null ? marketFixedRate.hashCode() : 0);
			_result = 31 * _result + (paymentDelay != null ? paymentDelay.hashCode() : 0);
			_result = 31 * _result + (initialPoints != null ? initialPoints.hashCode() : 0);
			_result = 31 * _result + (marketPrice != null ? marketPrice.hashCode() : 0);
			_result = 31 * _result + (quotationStyle != null ? quotationStyle.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeLegBuilder {" +
				"initialPayment=" + this.initialPayment + ", " +
				"singlePayment=" + this.singlePayment + ", " +
				"periodicPayment=" + this.periodicPayment + ", " +
				"marketFixedRate=" + this.marketFixedRate + ", " +
				"paymentDelay=" + this.paymentDelay + ", " +
				"initialPoints=" + this.initialPoints + ", " +
				"marketPrice=" + this.marketPrice + ", " +
				"quotationStyle=" + this.quotationStyle +
			'}' + " " + super.toString();
		}
	}
}
