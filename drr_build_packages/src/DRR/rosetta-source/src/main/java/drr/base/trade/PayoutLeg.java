package drr.base.trade;

import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.Cashflow;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
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
import drr.base.trade.meta.PayoutLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="PayoutLeg", builder=PayoutLeg.PayoutLegBuilderImpl.class, version="7.7.0")
@RuneDataType(value="PayoutLeg", model="drr", builder=PayoutLeg.PayoutLegBuilderImpl.class, version="7.7.0")
public interface PayoutLeg extends RosettaModelObject {

	PayoutLegMeta metaData = new PayoutLegMeta();

	/*********************** Getter Methods  ***********************/
	CreditDefaultPayout getCreditDefaultPayout();
	OptionPayout getOptionPayout();
	SettlementPayout getSettlementPayout();
	PerformancePayout getPerformancePayout();
	InterestRatePayout getInterestRatePayout();
	Cashflow getCashflow();
	FixedPricePayout getFixedPricePayout();
	CommodityPayout getCommodityPayout();

	/*********************** Build Methods  ***********************/
	PayoutLeg build();
	
	PayoutLeg.PayoutLegBuilder toBuilder();
	
	static PayoutLeg.PayoutLegBuilder builder() {
		return new PayoutLeg.PayoutLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PayoutLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PayoutLeg> getType() {
		return PayoutLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("creditDefaultPayout"), processor, CreditDefaultPayout.class, getCreditDefaultPayout());
		processRosetta(path.newSubPath("optionPayout"), processor, OptionPayout.class, getOptionPayout());
		processRosetta(path.newSubPath("settlementPayout"), processor, SettlementPayout.class, getSettlementPayout());
		processRosetta(path.newSubPath("performancePayout"), processor, PerformancePayout.class, getPerformancePayout());
		processRosetta(path.newSubPath("interestRatePayout"), processor, InterestRatePayout.class, getInterestRatePayout());
		processRosetta(path.newSubPath("cashflow"), processor, Cashflow.class, getCashflow());
		processRosetta(path.newSubPath("fixedPricePayout"), processor, FixedPricePayout.class, getFixedPricePayout());
		processRosetta(path.newSubPath("commodityPayout"), processor, CommodityPayout.class, getCommodityPayout());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PayoutLegBuilder extends PayoutLeg, RosettaModelObjectBuilder {
		CreditDefaultPayout.CreditDefaultPayoutBuilder getOrCreateCreditDefaultPayout();
		@Override
		CreditDefaultPayout.CreditDefaultPayoutBuilder getCreditDefaultPayout();
		OptionPayout.OptionPayoutBuilder getOrCreateOptionPayout();
		@Override
		OptionPayout.OptionPayoutBuilder getOptionPayout();
		SettlementPayout.SettlementPayoutBuilder getOrCreateSettlementPayout();
		@Override
		SettlementPayout.SettlementPayoutBuilder getSettlementPayout();
		PerformancePayout.PerformancePayoutBuilder getOrCreatePerformancePayout();
		@Override
		PerformancePayout.PerformancePayoutBuilder getPerformancePayout();
		InterestRatePayout.InterestRatePayoutBuilder getOrCreateInterestRatePayout();
		@Override
		InterestRatePayout.InterestRatePayoutBuilder getInterestRatePayout();
		Cashflow.CashflowBuilder getOrCreateCashflow();
		@Override
		Cashflow.CashflowBuilder getCashflow();
		FixedPricePayout.FixedPricePayoutBuilder getOrCreateFixedPricePayout();
		@Override
		FixedPricePayout.FixedPricePayoutBuilder getFixedPricePayout();
		CommodityPayout.CommodityPayoutBuilder getOrCreateCommodityPayout();
		@Override
		CommodityPayout.CommodityPayoutBuilder getCommodityPayout();
		PayoutLeg.PayoutLegBuilder setCreditDefaultPayout(CreditDefaultPayout creditDefaultPayout);
		PayoutLeg.PayoutLegBuilder setOptionPayout(OptionPayout optionPayout);
		PayoutLeg.PayoutLegBuilder setSettlementPayout(SettlementPayout settlementPayout);
		PayoutLeg.PayoutLegBuilder setPerformancePayout(PerformancePayout performancePayout);
		PayoutLeg.PayoutLegBuilder setInterestRatePayout(InterestRatePayout interestRatePayout);
		PayoutLeg.PayoutLegBuilder setCashflow(Cashflow cashflow);
		PayoutLeg.PayoutLegBuilder setFixedPricePayout(FixedPricePayout fixedPricePayout);
		PayoutLeg.PayoutLegBuilder setCommodityPayout(CommodityPayout commodityPayout);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("creditDefaultPayout"), processor, CreditDefaultPayout.CreditDefaultPayoutBuilder.class, getCreditDefaultPayout());
			processRosetta(path.newSubPath("optionPayout"), processor, OptionPayout.OptionPayoutBuilder.class, getOptionPayout());
			processRosetta(path.newSubPath("settlementPayout"), processor, SettlementPayout.SettlementPayoutBuilder.class, getSettlementPayout());
			processRosetta(path.newSubPath("performancePayout"), processor, PerformancePayout.PerformancePayoutBuilder.class, getPerformancePayout());
			processRosetta(path.newSubPath("interestRatePayout"), processor, InterestRatePayout.InterestRatePayoutBuilder.class, getInterestRatePayout());
			processRosetta(path.newSubPath("cashflow"), processor, Cashflow.CashflowBuilder.class, getCashflow());
			processRosetta(path.newSubPath("fixedPricePayout"), processor, FixedPricePayout.FixedPricePayoutBuilder.class, getFixedPricePayout());
			processRosetta(path.newSubPath("commodityPayout"), processor, CommodityPayout.CommodityPayoutBuilder.class, getCommodityPayout());
		}
		

		PayoutLeg.PayoutLegBuilder prune();
	}

	/*********************** Immutable Implementation of PayoutLeg  ***********************/
	class PayoutLegImpl implements PayoutLeg {
		private final CreditDefaultPayout creditDefaultPayout;
		private final OptionPayout optionPayout;
		private final SettlementPayout settlementPayout;
		private final PerformancePayout performancePayout;
		private final InterestRatePayout interestRatePayout;
		private final Cashflow cashflow;
		private final FixedPricePayout fixedPricePayout;
		private final CommodityPayout commodityPayout;
		
		protected PayoutLegImpl(PayoutLeg.PayoutLegBuilder builder) {
			this.creditDefaultPayout = ofNullable(builder.getCreditDefaultPayout()).map(f->f.build()).orElse(null);
			this.optionPayout = ofNullable(builder.getOptionPayout()).map(f->f.build()).orElse(null);
			this.settlementPayout = ofNullable(builder.getSettlementPayout()).map(f->f.build()).orElse(null);
			this.performancePayout = ofNullable(builder.getPerformancePayout()).map(f->f.build()).orElse(null);
			this.interestRatePayout = ofNullable(builder.getInterestRatePayout()).map(f->f.build()).orElse(null);
			this.cashflow = ofNullable(builder.getCashflow()).map(f->f.build()).orElse(null);
			this.fixedPricePayout = ofNullable(builder.getFixedPricePayout()).map(f->f.build()).orElse(null);
			this.commodityPayout = ofNullable(builder.getCommodityPayout()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("creditDefaultPayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditDefaultPayout")
		public CreditDefaultPayout getCreditDefaultPayout() {
			return creditDefaultPayout;
		}
		
		@Override
		@RosettaAttribute("optionPayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionPayout")
		public OptionPayout getOptionPayout() {
			return optionPayout;
		}
		
		@Override
		@RosettaAttribute("settlementPayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPayout")
		public SettlementPayout getSettlementPayout() {
			return settlementPayout;
		}
		
		@Override
		@RosettaAttribute("performancePayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("performancePayout")
		public PerformancePayout getPerformancePayout() {
			return performancePayout;
		}
		
		@Override
		@RosettaAttribute("interestRatePayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestRatePayout")
		public InterestRatePayout getInterestRatePayout() {
			return interestRatePayout;
		}
		
		@Override
		@RosettaAttribute("cashflow")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflow")
		public Cashflow getCashflow() {
			return cashflow;
		}
		
		@Override
		@RosettaAttribute("fixedPricePayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedPricePayout")
		public FixedPricePayout getFixedPricePayout() {
			return fixedPricePayout;
		}
		
		@Override
		@RosettaAttribute("commodityPayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityPayout")
		public CommodityPayout getCommodityPayout() {
			return commodityPayout;
		}
		
		@Override
		public PayoutLeg build() {
			return this;
		}
		
		@Override
		public PayoutLeg.PayoutLegBuilder toBuilder() {
			PayoutLeg.PayoutLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PayoutLeg.PayoutLegBuilder builder) {
			ofNullable(getCreditDefaultPayout()).ifPresent(builder::setCreditDefaultPayout);
			ofNullable(getOptionPayout()).ifPresent(builder::setOptionPayout);
			ofNullable(getSettlementPayout()).ifPresent(builder::setSettlementPayout);
			ofNullable(getPerformancePayout()).ifPresent(builder::setPerformancePayout);
			ofNullable(getInterestRatePayout()).ifPresent(builder::setInterestRatePayout);
			ofNullable(getCashflow()).ifPresent(builder::setCashflow);
			ofNullable(getFixedPricePayout()).ifPresent(builder::setFixedPricePayout);
			ofNullable(getCommodityPayout()).ifPresent(builder::setCommodityPayout);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PayoutLeg _that = getType().cast(o);
		
			if (!Objects.equals(creditDefaultPayout, _that.getCreditDefaultPayout())) return false;
			if (!Objects.equals(optionPayout, _that.getOptionPayout())) return false;
			if (!Objects.equals(settlementPayout, _that.getSettlementPayout())) return false;
			if (!Objects.equals(performancePayout, _that.getPerformancePayout())) return false;
			if (!Objects.equals(interestRatePayout, _that.getInterestRatePayout())) return false;
			if (!Objects.equals(cashflow, _that.getCashflow())) return false;
			if (!Objects.equals(fixedPricePayout, _that.getFixedPricePayout())) return false;
			if (!Objects.equals(commodityPayout, _that.getCommodityPayout())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditDefaultPayout != null ? creditDefaultPayout.hashCode() : 0);
			_result = 31 * _result + (optionPayout != null ? optionPayout.hashCode() : 0);
			_result = 31 * _result + (settlementPayout != null ? settlementPayout.hashCode() : 0);
			_result = 31 * _result + (performancePayout != null ? performancePayout.hashCode() : 0);
			_result = 31 * _result + (interestRatePayout != null ? interestRatePayout.hashCode() : 0);
			_result = 31 * _result + (cashflow != null ? cashflow.hashCode() : 0);
			_result = 31 * _result + (fixedPricePayout != null ? fixedPricePayout.hashCode() : 0);
			_result = 31 * _result + (commodityPayout != null ? commodityPayout.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PayoutLeg {" +
				"creditDefaultPayout=" + this.creditDefaultPayout + ", " +
				"optionPayout=" + this.optionPayout + ", " +
				"settlementPayout=" + this.settlementPayout + ", " +
				"performancePayout=" + this.performancePayout + ", " +
				"interestRatePayout=" + this.interestRatePayout + ", " +
				"cashflow=" + this.cashflow + ", " +
				"fixedPricePayout=" + this.fixedPricePayout + ", " +
				"commodityPayout=" + this.commodityPayout +
			'}';
		}
	}

	/*********************** Builder Implementation of PayoutLeg  ***********************/
	class PayoutLegBuilderImpl implements PayoutLeg.PayoutLegBuilder {
	
		protected CreditDefaultPayout.CreditDefaultPayoutBuilder creditDefaultPayout;
		protected OptionPayout.OptionPayoutBuilder optionPayout;
		protected SettlementPayout.SettlementPayoutBuilder settlementPayout;
		protected PerformancePayout.PerformancePayoutBuilder performancePayout;
		protected InterestRatePayout.InterestRatePayoutBuilder interestRatePayout;
		protected Cashflow.CashflowBuilder cashflow;
		protected FixedPricePayout.FixedPricePayoutBuilder fixedPricePayout;
		protected CommodityPayout.CommodityPayoutBuilder commodityPayout;
		
		@Override
		@RosettaAttribute("creditDefaultPayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditDefaultPayout")
		public CreditDefaultPayout.CreditDefaultPayoutBuilder getCreditDefaultPayout() {
			return creditDefaultPayout;
		}
		
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder getOrCreateCreditDefaultPayout() {
			CreditDefaultPayout.CreditDefaultPayoutBuilder result;
			if (creditDefaultPayout!=null) {
				result = creditDefaultPayout;
			}
			else {
				result = creditDefaultPayout = CreditDefaultPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionPayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionPayout")
		public OptionPayout.OptionPayoutBuilder getOptionPayout() {
			return optionPayout;
		}
		
		@Override
		public OptionPayout.OptionPayoutBuilder getOrCreateOptionPayout() {
			OptionPayout.OptionPayoutBuilder result;
			if (optionPayout!=null) {
				result = optionPayout;
			}
			else {
				result = optionPayout = OptionPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPayout")
		public SettlementPayout.SettlementPayoutBuilder getSettlementPayout() {
			return settlementPayout;
		}
		
		@Override
		public SettlementPayout.SettlementPayoutBuilder getOrCreateSettlementPayout() {
			SettlementPayout.SettlementPayoutBuilder result;
			if (settlementPayout!=null) {
				result = settlementPayout;
			}
			else {
				result = settlementPayout = SettlementPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("performancePayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("performancePayout")
		public PerformancePayout.PerformancePayoutBuilder getPerformancePayout() {
			return performancePayout;
		}
		
		@Override
		public PerformancePayout.PerformancePayoutBuilder getOrCreatePerformancePayout() {
			PerformancePayout.PerformancePayoutBuilder result;
			if (performancePayout!=null) {
				result = performancePayout;
			}
			else {
				result = performancePayout = PerformancePayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestRatePayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interestRatePayout")
		public InterestRatePayout.InterestRatePayoutBuilder getInterestRatePayout() {
			return interestRatePayout;
		}
		
		@Override
		public InterestRatePayout.InterestRatePayoutBuilder getOrCreateInterestRatePayout() {
			InterestRatePayout.InterestRatePayoutBuilder result;
			if (interestRatePayout!=null) {
				result = interestRatePayout;
			}
			else {
				result = interestRatePayout = InterestRatePayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashflow")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflow")
		public Cashflow.CashflowBuilder getCashflow() {
			return cashflow;
		}
		
		@Override
		public Cashflow.CashflowBuilder getOrCreateCashflow() {
			Cashflow.CashflowBuilder result;
			if (cashflow!=null) {
				result = cashflow;
			}
			else {
				result = cashflow = Cashflow.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedPricePayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fixedPricePayout")
		public FixedPricePayout.FixedPricePayoutBuilder getFixedPricePayout() {
			return fixedPricePayout;
		}
		
		@Override
		public FixedPricePayout.FixedPricePayoutBuilder getOrCreateFixedPricePayout() {
			FixedPricePayout.FixedPricePayoutBuilder result;
			if (fixedPricePayout!=null) {
				result = fixedPricePayout;
			}
			else {
				result = fixedPricePayout = FixedPricePayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityPayout")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityPayout")
		public CommodityPayout.CommodityPayoutBuilder getCommodityPayout() {
			return commodityPayout;
		}
		
		@Override
		public CommodityPayout.CommodityPayoutBuilder getOrCreateCommodityPayout() {
			CommodityPayout.CommodityPayoutBuilder result;
			if (commodityPayout!=null) {
				result = commodityPayout;
			}
			else {
				result = commodityPayout = CommodityPayout.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("creditDefaultPayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditDefaultPayout")
		@Override
		public PayoutLeg.PayoutLegBuilder setCreditDefaultPayout(CreditDefaultPayout _creditDefaultPayout) {
			this.creditDefaultPayout = _creditDefaultPayout == null ? null : _creditDefaultPayout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionPayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPayout")
		@Override
		public PayoutLeg.PayoutLegBuilder setOptionPayout(OptionPayout _optionPayout) {
			this.optionPayout = _optionPayout == null ? null : _optionPayout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementPayout")
		@Override
		public PayoutLeg.PayoutLegBuilder setSettlementPayout(SettlementPayout _settlementPayout) {
			this.settlementPayout = _settlementPayout == null ? null : _settlementPayout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("performancePayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("performancePayout")
		@Override
		public PayoutLeg.PayoutLegBuilder setPerformancePayout(PerformancePayout _performancePayout) {
			this.performancePayout = _performancePayout == null ? null : _performancePayout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interestRatePayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interestRatePayout")
		@Override
		public PayoutLeg.PayoutLegBuilder setInterestRatePayout(InterestRatePayout _interestRatePayout) {
			this.interestRatePayout = _interestRatePayout == null ? null : _interestRatePayout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashflow")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashflow")
		@Override
		public PayoutLeg.PayoutLegBuilder setCashflow(Cashflow _cashflow) {
			this.cashflow = _cashflow == null ? null : _cashflow.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedPricePayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedPricePayout")
		@Override
		public PayoutLeg.PayoutLegBuilder setFixedPricePayout(FixedPricePayout _fixedPricePayout) {
			this.fixedPricePayout = _fixedPricePayout == null ? null : _fixedPricePayout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commodityPayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityPayout")
		@Override
		public PayoutLeg.PayoutLegBuilder setCommodityPayout(CommodityPayout _commodityPayout) {
			this.commodityPayout = _commodityPayout == null ? null : _commodityPayout.toBuilder();
			return this;
		}
		
		@Override
		public PayoutLeg build() {
			return new PayoutLeg.PayoutLegImpl(this);
		}
		
		@Override
		public PayoutLeg.PayoutLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PayoutLeg.PayoutLegBuilder prune() {
			if (creditDefaultPayout!=null && !creditDefaultPayout.prune().hasData()) creditDefaultPayout = null;
			if (optionPayout!=null && !optionPayout.prune().hasData()) optionPayout = null;
			if (settlementPayout!=null && !settlementPayout.prune().hasData()) settlementPayout = null;
			if (performancePayout!=null && !performancePayout.prune().hasData()) performancePayout = null;
			if (interestRatePayout!=null && !interestRatePayout.prune().hasData()) interestRatePayout = null;
			if (cashflow!=null && !cashflow.prune().hasData()) cashflow = null;
			if (fixedPricePayout!=null && !fixedPricePayout.prune().hasData()) fixedPricePayout = null;
			if (commodityPayout!=null && !commodityPayout.prune().hasData()) commodityPayout = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditDefaultPayout()!=null && getCreditDefaultPayout().hasData()) return true;
			if (getOptionPayout()!=null && getOptionPayout().hasData()) return true;
			if (getSettlementPayout()!=null && getSettlementPayout().hasData()) return true;
			if (getPerformancePayout()!=null && getPerformancePayout().hasData()) return true;
			if (getInterestRatePayout()!=null && getInterestRatePayout().hasData()) return true;
			if (getCashflow()!=null && getCashflow().hasData()) return true;
			if (getFixedPricePayout()!=null && getFixedPricePayout().hasData()) return true;
			if (getCommodityPayout()!=null && getCommodityPayout().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PayoutLeg.PayoutLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PayoutLeg.PayoutLegBuilder o = (PayoutLeg.PayoutLegBuilder) other;
			
			merger.mergeRosetta(getCreditDefaultPayout(), o.getCreditDefaultPayout(), this::setCreditDefaultPayout);
			merger.mergeRosetta(getOptionPayout(), o.getOptionPayout(), this::setOptionPayout);
			merger.mergeRosetta(getSettlementPayout(), o.getSettlementPayout(), this::setSettlementPayout);
			merger.mergeRosetta(getPerformancePayout(), o.getPerformancePayout(), this::setPerformancePayout);
			merger.mergeRosetta(getInterestRatePayout(), o.getInterestRatePayout(), this::setInterestRatePayout);
			merger.mergeRosetta(getCashflow(), o.getCashflow(), this::setCashflow);
			merger.mergeRosetta(getFixedPricePayout(), o.getFixedPricePayout(), this::setFixedPricePayout);
			merger.mergeRosetta(getCommodityPayout(), o.getCommodityPayout(), this::setCommodityPayout);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PayoutLeg _that = getType().cast(o);
		
			if (!Objects.equals(creditDefaultPayout, _that.getCreditDefaultPayout())) return false;
			if (!Objects.equals(optionPayout, _that.getOptionPayout())) return false;
			if (!Objects.equals(settlementPayout, _that.getSettlementPayout())) return false;
			if (!Objects.equals(performancePayout, _that.getPerformancePayout())) return false;
			if (!Objects.equals(interestRatePayout, _that.getInterestRatePayout())) return false;
			if (!Objects.equals(cashflow, _that.getCashflow())) return false;
			if (!Objects.equals(fixedPricePayout, _that.getFixedPricePayout())) return false;
			if (!Objects.equals(commodityPayout, _that.getCommodityPayout())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditDefaultPayout != null ? creditDefaultPayout.hashCode() : 0);
			_result = 31 * _result + (optionPayout != null ? optionPayout.hashCode() : 0);
			_result = 31 * _result + (settlementPayout != null ? settlementPayout.hashCode() : 0);
			_result = 31 * _result + (performancePayout != null ? performancePayout.hashCode() : 0);
			_result = 31 * _result + (interestRatePayout != null ? interestRatePayout.hashCode() : 0);
			_result = 31 * _result + (cashflow != null ? cashflow.hashCode() : 0);
			_result = 31 * _result + (fixedPricePayout != null ? fixedPricePayout.hashCode() : 0);
			_result = 31 * _result + (commodityPayout != null ? commodityPayout.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PayoutLegBuilder {" +
				"creditDefaultPayout=" + this.creditDefaultPayout + ", " +
				"optionPayout=" + this.optionPayout + ", " +
				"settlementPayout=" + this.settlementPayout + ", " +
				"performancePayout=" + this.performancePayout + ", " +
				"interestRatePayout=" + this.interestRatePayout + ", " +
				"cashflow=" + this.cashflow + ", " +
				"fixedPricePayout=" + this.fixedPricePayout + ", " +
				"commodityPayout=" + this.commodityPayout +
			'}';
		}
	}
}
