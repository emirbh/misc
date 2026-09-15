package drr.base.trade;

import cdm.observable.asset.PriceSchedule;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
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
import drr.base.trade.meta.PayoutLegWithAuxiliaryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="PayoutLegWithAuxiliary", builder=PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilderImpl.class, version="7.7.0")
@RuneDataType(value="PayoutLegWithAuxiliary", model="drr", builder=PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilderImpl.class, version="7.7.0")
public interface PayoutLegWithAuxiliary extends PayoutLeg {

	PayoutLegWithAuxiliaryMeta metaData = new PayoutLegWithAuxiliaryMeta();

	/*********************** Getter Methods  ***********************/
	PayoutLeg getAuxiliaryLeg();
	PriceSchedule getLastAvailableSpotPrice();
	TradeLot getTradeLot();
	Boolean getIsProductETD();
	Boolean getZeroNotionalAmountDefaulting();
	SettlementTerms getSettlementTerms();

	/*********************** Build Methods  ***********************/
	PayoutLegWithAuxiliary build();
	
	PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder toBuilder();
	
	static PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder builder() {
		return new PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PayoutLegWithAuxiliary> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PayoutLegWithAuxiliary> getType() {
		return PayoutLegWithAuxiliary.class;
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
		processRosetta(path.newSubPath("auxiliaryLeg"), processor, PayoutLeg.class, getAuxiliaryLeg());
		processRosetta(path.newSubPath("lastAvailableSpotPrice"), processor, PriceSchedule.class, getLastAvailableSpotPrice());
		processRosetta(path.newSubPath("tradeLot"), processor, TradeLot.class, getTradeLot());
		processor.processBasic(path.newSubPath("isProductETD"), Boolean.class, getIsProductETD(), this);
		processor.processBasic(path.newSubPath("zeroNotionalAmountDefaulting"), Boolean.class, getZeroNotionalAmountDefaulting(), this);
		processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.class, getSettlementTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PayoutLegWithAuxiliaryBuilder extends PayoutLegWithAuxiliary, PayoutLeg.PayoutLegBuilder {
		PayoutLeg.PayoutLegBuilder getOrCreateAuxiliaryLeg();
		@Override
		PayoutLeg.PayoutLegBuilder getAuxiliaryLeg();
		PriceSchedule.PriceScheduleBuilder getOrCreateLastAvailableSpotPrice();
		@Override
		PriceSchedule.PriceScheduleBuilder getLastAvailableSpotPrice();
		TradeLot.TradeLotBuilder getOrCreateTradeLot();
		@Override
		TradeLot.TradeLotBuilder getTradeLot();
		SettlementTerms.SettlementTermsBuilder getOrCreateSettlementTerms();
		@Override
		SettlementTerms.SettlementTermsBuilder getSettlementTerms();
		@Override
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setCreditDefaultPayout(CreditDefaultPayout creditDefaultPayout);
		@Override
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setOptionPayout(OptionPayout optionPayout);
		@Override
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setSettlementPayout(SettlementPayout settlementPayout);
		@Override
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setPerformancePayout(PerformancePayout performancePayout);
		@Override
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setInterestRatePayout(InterestRatePayout interestRatePayout);
		@Override
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setCashflow(Cashflow cashflow);
		@Override
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setFixedPricePayout(FixedPricePayout fixedPricePayout);
		@Override
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setCommodityPayout(CommodityPayout commodityPayout);
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setAuxiliaryLeg(PayoutLeg auxiliaryLeg);
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setLastAvailableSpotPrice(PriceSchedule lastAvailableSpotPrice);
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setTradeLot(TradeLot tradeLot);
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setIsProductETD(Boolean isProductETD);
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setZeroNotionalAmountDefaulting(Boolean zeroNotionalAmountDefaulting);
		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setSettlementTerms(SettlementTerms settlementTerms);

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
			processRosetta(path.newSubPath("auxiliaryLeg"), processor, PayoutLeg.PayoutLegBuilder.class, getAuxiliaryLeg());
			processRosetta(path.newSubPath("lastAvailableSpotPrice"), processor, PriceSchedule.PriceScheduleBuilder.class, getLastAvailableSpotPrice());
			processRosetta(path.newSubPath("tradeLot"), processor, TradeLot.TradeLotBuilder.class, getTradeLot());
			processor.processBasic(path.newSubPath("isProductETD"), Boolean.class, getIsProductETD(), this);
			processor.processBasic(path.newSubPath("zeroNotionalAmountDefaulting"), Boolean.class, getZeroNotionalAmountDefaulting(), this);
			processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.SettlementTermsBuilder.class, getSettlementTerms());
		}
		

		PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder prune();
	}

	/*********************** Immutable Implementation of PayoutLegWithAuxiliary  ***********************/
	class PayoutLegWithAuxiliaryImpl extends PayoutLeg.PayoutLegImpl implements PayoutLegWithAuxiliary {
		private final PayoutLeg auxiliaryLeg;
		private final PriceSchedule lastAvailableSpotPrice;
		private final TradeLot tradeLot;
		private final Boolean isProductETD;
		private final Boolean zeroNotionalAmountDefaulting;
		private final SettlementTerms settlementTerms;
		
		protected PayoutLegWithAuxiliaryImpl(PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder builder) {
			super(builder);
			this.auxiliaryLeg = ofNullable(builder.getAuxiliaryLeg()).map(f->f.build()).orElse(null);
			this.lastAvailableSpotPrice = ofNullable(builder.getLastAvailableSpotPrice()).map(f->f.build()).orElse(null);
			this.tradeLot = ofNullable(builder.getTradeLot()).map(f->f.build()).orElse(null);
			this.isProductETD = builder.getIsProductETD();
			this.zeroNotionalAmountDefaulting = builder.getZeroNotionalAmountDefaulting();
			this.settlementTerms = ofNullable(builder.getSettlementTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("auxiliaryLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("auxiliaryLeg")
		public PayoutLeg getAuxiliaryLeg() {
			return auxiliaryLeg;
		}
		
		@Override
		@RosettaAttribute("lastAvailableSpotPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastAvailableSpotPrice")
		public PriceSchedule getLastAvailableSpotPrice() {
			return lastAvailableSpotPrice;
		}
		
		@Override
		@RosettaAttribute("tradeLot")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeLot")
		public TradeLot getTradeLot() {
			return tradeLot;
		}
		
		@Override
		@RosettaAttribute("isProductETD")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isProductETD")
		public Boolean getIsProductETD() {
			return isProductETD;
		}
		
		@Override
		@RosettaAttribute("zeroNotionalAmountDefaulting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("zeroNotionalAmountDefaulting")
		public Boolean getZeroNotionalAmountDefaulting() {
			return zeroNotionalAmountDefaulting;
		}
		
		@Override
		@RosettaAttribute("settlementTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementTerms")
		public SettlementTerms getSettlementTerms() {
			return settlementTerms;
		}
		
		@Override
		public PayoutLegWithAuxiliary build() {
			return this;
		}
		
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder toBuilder() {
			PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAuxiliaryLeg()).ifPresent(builder::setAuxiliaryLeg);
			ofNullable(getLastAvailableSpotPrice()).ifPresent(builder::setLastAvailableSpotPrice);
			ofNullable(getTradeLot()).ifPresent(builder::setTradeLot);
			ofNullable(getIsProductETD()).ifPresent(builder::setIsProductETD);
			ofNullable(getZeroNotionalAmountDefaulting()).ifPresent(builder::setZeroNotionalAmountDefaulting);
			ofNullable(getSettlementTerms()).ifPresent(builder::setSettlementTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PayoutLegWithAuxiliary _that = getType().cast(o);
		
			if (!Objects.equals(auxiliaryLeg, _that.getAuxiliaryLeg())) return false;
			if (!Objects.equals(lastAvailableSpotPrice, _that.getLastAvailableSpotPrice())) return false;
			if (!Objects.equals(tradeLot, _that.getTradeLot())) return false;
			if (!Objects.equals(isProductETD, _that.getIsProductETD())) return false;
			if (!Objects.equals(zeroNotionalAmountDefaulting, _that.getZeroNotionalAmountDefaulting())) return false;
			if (!Objects.equals(settlementTerms, _that.getSettlementTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (auxiliaryLeg != null ? auxiliaryLeg.hashCode() : 0);
			_result = 31 * _result + (lastAvailableSpotPrice != null ? lastAvailableSpotPrice.hashCode() : 0);
			_result = 31 * _result + (tradeLot != null ? tradeLot.hashCode() : 0);
			_result = 31 * _result + (isProductETD != null ? isProductETD.hashCode() : 0);
			_result = 31 * _result + (zeroNotionalAmountDefaulting != null ? zeroNotionalAmountDefaulting.hashCode() : 0);
			_result = 31 * _result + (settlementTerms != null ? settlementTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PayoutLegWithAuxiliary {" +
				"auxiliaryLeg=" + this.auxiliaryLeg + ", " +
				"lastAvailableSpotPrice=" + this.lastAvailableSpotPrice + ", " +
				"tradeLot=" + this.tradeLot + ", " +
				"isProductETD=" + this.isProductETD + ", " +
				"zeroNotionalAmountDefaulting=" + this.zeroNotionalAmountDefaulting + ", " +
				"settlementTerms=" + this.settlementTerms +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PayoutLegWithAuxiliary  ***********************/
	class PayoutLegWithAuxiliaryBuilderImpl extends PayoutLeg.PayoutLegBuilderImpl implements PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder {
	
		protected PayoutLeg.PayoutLegBuilder auxiliaryLeg;
		protected PriceSchedule.PriceScheduleBuilder lastAvailableSpotPrice;
		protected TradeLot.TradeLotBuilder tradeLot;
		protected Boolean isProductETD;
		protected Boolean zeroNotionalAmountDefaulting;
		protected SettlementTerms.SettlementTermsBuilder settlementTerms;
		
		@Override
		@RosettaAttribute("auxiliaryLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("auxiliaryLeg")
		public PayoutLeg.PayoutLegBuilder getAuxiliaryLeg() {
			return auxiliaryLeg;
		}
		
		@Override
		public PayoutLeg.PayoutLegBuilder getOrCreateAuxiliaryLeg() {
			PayoutLeg.PayoutLegBuilder result;
			if (auxiliaryLeg!=null) {
				result = auxiliaryLeg;
			}
			else {
				result = auxiliaryLeg = PayoutLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lastAvailableSpotPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lastAvailableSpotPrice")
		public PriceSchedule.PriceScheduleBuilder getLastAvailableSpotPrice() {
			return lastAvailableSpotPrice;
		}
		
		@Override
		public PriceSchedule.PriceScheduleBuilder getOrCreateLastAvailableSpotPrice() {
			PriceSchedule.PriceScheduleBuilder result;
			if (lastAvailableSpotPrice!=null) {
				result = lastAvailableSpotPrice;
			}
			else {
				result = lastAvailableSpotPrice = PriceSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeLot")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeLot")
		public TradeLot.TradeLotBuilder getTradeLot() {
			return tradeLot;
		}
		
		@Override
		public TradeLot.TradeLotBuilder getOrCreateTradeLot() {
			TradeLot.TradeLotBuilder result;
			if (tradeLot!=null) {
				result = tradeLot;
			}
			else {
				result = tradeLot = TradeLot.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("isProductETD")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isProductETD")
		public Boolean getIsProductETD() {
			return isProductETD;
		}
		
		@Override
		@RosettaAttribute("zeroNotionalAmountDefaulting")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("zeroNotionalAmountDefaulting")
		public Boolean getZeroNotionalAmountDefaulting() {
			return zeroNotionalAmountDefaulting;
		}
		
		@Override
		@RosettaAttribute("settlementTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementTerms")
		public SettlementTerms.SettlementTermsBuilder getSettlementTerms() {
			return settlementTerms;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder getOrCreateSettlementTerms() {
			SettlementTerms.SettlementTermsBuilder result;
			if (settlementTerms!=null) {
				result = settlementTerms;
			}
			else {
				result = settlementTerms = SettlementTerms.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("creditDefaultPayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditDefaultPayout")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setCreditDefaultPayout(CreditDefaultPayout _creditDefaultPayout) {
			this.creditDefaultPayout = _creditDefaultPayout == null ? null : _creditDefaultPayout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionPayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPayout")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setOptionPayout(OptionPayout _optionPayout) {
			this.optionPayout = _optionPayout == null ? null : _optionPayout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementPayout")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setSettlementPayout(SettlementPayout _settlementPayout) {
			this.settlementPayout = _settlementPayout == null ? null : _settlementPayout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("performancePayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("performancePayout")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setPerformancePayout(PerformancePayout _performancePayout) {
			this.performancePayout = _performancePayout == null ? null : _performancePayout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("interestRatePayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interestRatePayout")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setInterestRatePayout(InterestRatePayout _interestRatePayout) {
			this.interestRatePayout = _interestRatePayout == null ? null : _interestRatePayout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashflow")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashflow")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setCashflow(Cashflow _cashflow) {
			this.cashflow = _cashflow == null ? null : _cashflow.toBuilder();
			return this;
		}
		
		@RosettaAttribute("fixedPricePayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fixedPricePayout")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setFixedPricePayout(FixedPricePayout _fixedPricePayout) {
			this.fixedPricePayout = _fixedPricePayout == null ? null : _fixedPricePayout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commodityPayout")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityPayout")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setCommodityPayout(CommodityPayout _commodityPayout) {
			this.commodityPayout = _commodityPayout == null ? null : _commodityPayout.toBuilder();
			return this;
		}
		
		@RosettaAttribute("auxiliaryLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("auxiliaryLeg")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setAuxiliaryLeg(PayoutLeg _auxiliaryLeg) {
			this.auxiliaryLeg = _auxiliaryLeg == null ? null : _auxiliaryLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lastAvailableSpotPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lastAvailableSpotPrice")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setLastAvailableSpotPrice(PriceSchedule _lastAvailableSpotPrice) {
			this.lastAvailableSpotPrice = _lastAvailableSpotPrice == null ? null : _lastAvailableSpotPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeLot")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeLot")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setTradeLot(TradeLot _tradeLot) {
			this.tradeLot = _tradeLot == null ? null : _tradeLot.toBuilder();
			return this;
		}
		
		@RosettaAttribute("isProductETD")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isProductETD")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setIsProductETD(Boolean _isProductETD) {
			this.isProductETD = _isProductETD == null ? null : _isProductETD;
			return this;
		}
		
		@RosettaAttribute("zeroNotionalAmountDefaulting")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("zeroNotionalAmountDefaulting")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setZeroNotionalAmountDefaulting(Boolean _zeroNotionalAmountDefaulting) {
			this.zeroNotionalAmountDefaulting = _zeroNotionalAmountDefaulting == null ? null : _zeroNotionalAmountDefaulting;
			return this;
		}
		
		@RosettaAttribute("settlementTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementTerms")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder setSettlementTerms(SettlementTerms _settlementTerms) {
			this.settlementTerms = _settlementTerms == null ? null : _settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public PayoutLegWithAuxiliary build() {
			return new PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryImpl(this);
		}
		
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder prune() {
			super.prune();
			if (auxiliaryLeg!=null && !auxiliaryLeg.prune().hasData()) auxiliaryLeg = null;
			if (lastAvailableSpotPrice!=null && !lastAvailableSpotPrice.prune().hasData()) lastAvailableSpotPrice = null;
			if (tradeLot!=null && !tradeLot.prune().hasData()) tradeLot = null;
			if (settlementTerms!=null && !settlementTerms.prune().hasData()) settlementTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAuxiliaryLeg()!=null && getAuxiliaryLeg().hasData()) return true;
			if (getLastAvailableSpotPrice()!=null && getLastAvailableSpotPrice().hasData()) return true;
			if (getTradeLot()!=null && getTradeLot().hasData()) return true;
			if (getIsProductETD()!=null) return true;
			if (getZeroNotionalAmountDefaulting()!=null) return true;
			if (getSettlementTerms()!=null && getSettlementTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder o = (PayoutLegWithAuxiliary.PayoutLegWithAuxiliaryBuilder) other;
			
			merger.mergeRosetta(getAuxiliaryLeg(), o.getAuxiliaryLeg(), this::setAuxiliaryLeg);
			merger.mergeRosetta(getLastAvailableSpotPrice(), o.getLastAvailableSpotPrice(), this::setLastAvailableSpotPrice);
			merger.mergeRosetta(getTradeLot(), o.getTradeLot(), this::setTradeLot);
			merger.mergeRosetta(getSettlementTerms(), o.getSettlementTerms(), this::setSettlementTerms);
			
			merger.mergeBasic(getIsProductETD(), o.getIsProductETD(), this::setIsProductETD);
			merger.mergeBasic(getZeroNotionalAmountDefaulting(), o.getZeroNotionalAmountDefaulting(), this::setZeroNotionalAmountDefaulting);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			PayoutLegWithAuxiliary _that = getType().cast(o);
		
			if (!Objects.equals(auxiliaryLeg, _that.getAuxiliaryLeg())) return false;
			if (!Objects.equals(lastAvailableSpotPrice, _that.getLastAvailableSpotPrice())) return false;
			if (!Objects.equals(tradeLot, _that.getTradeLot())) return false;
			if (!Objects.equals(isProductETD, _that.getIsProductETD())) return false;
			if (!Objects.equals(zeroNotionalAmountDefaulting, _that.getZeroNotionalAmountDefaulting())) return false;
			if (!Objects.equals(settlementTerms, _that.getSettlementTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (auxiliaryLeg != null ? auxiliaryLeg.hashCode() : 0);
			_result = 31 * _result + (lastAvailableSpotPrice != null ? lastAvailableSpotPrice.hashCode() : 0);
			_result = 31 * _result + (tradeLot != null ? tradeLot.hashCode() : 0);
			_result = 31 * _result + (isProductETD != null ? isProductETD.hashCode() : 0);
			_result = 31 * _result + (zeroNotionalAmountDefaulting != null ? zeroNotionalAmountDefaulting.hashCode() : 0);
			_result = 31 * _result + (settlementTerms != null ? settlementTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PayoutLegWithAuxiliaryBuilder {" +
				"auxiliaryLeg=" + this.auxiliaryLeg + ", " +
				"lastAvailableSpotPrice=" + this.lastAvailableSpotPrice + ", " +
				"tradeLot=" + this.tradeLot + ", " +
				"isProductETD=" + this.isProductETD + ", " +
				"zeroNotionalAmountDefaulting=" + this.zeroNotionalAmountDefaulting + ", " +
				"settlementTerms=" + this.settlementTerms +
			'}' + " " + super.toString();
		}
	}
}
