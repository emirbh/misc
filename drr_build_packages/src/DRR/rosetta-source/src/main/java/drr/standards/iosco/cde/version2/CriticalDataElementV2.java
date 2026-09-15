package drr.standards.iosco.cde.version2;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RosettaIgnore;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneIgnore;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import drr.base.trade.basket.BasketConstituentsReport;
import drr.base.trade.payment.OtherPayment;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.PricePeriod;
import drr.standards.iosco.cde.version1.CriticalDataElementV1;
import drr.standards.iosco.cde.version1.LegV1;
import drr.standards.iosco.cde.version2.meta.CriticalDataElementV2Meta;
import drr.standards.iso.ClearedEnum;
import drr.standards.iso.ConfirmationEnum;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="CriticalDataElementV2", builder=CriticalDataElementV2.CriticalDataElementV2BuilderImpl.class, version="7.7.0")
@RuneDataType(value="CriticalDataElementV2", model="drr", builder=CriticalDataElementV2.CriticalDataElementV2BuilderImpl.class, version="7.7.0")
public interface CriticalDataElementV2 extends CriticalDataElementV1 {

	CriticalDataElementV2Meta metaData = new CriticalDataElementV2Meta();

	/*********************** Getter Methods  ***********************/
	@Override
	LegV2 getLeg1();
	@Override
	LegV2 getLeg2();

	/*********************** Build Methods  ***********************/
	CriticalDataElementV2 build();
	
	CriticalDataElementV2.CriticalDataElementV2Builder toBuilder();
	
	static CriticalDataElementV2.CriticalDataElementV2Builder builder() {
		return new CriticalDataElementV2.CriticalDataElementV2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CriticalDataElementV2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CriticalDataElementV2> getType() {
		return CriticalDataElementV2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processor.processBasic(path.newSubPath("earlyTerminationDate"), Date.class, getEarlyTerminationDate(), this);
		processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
		processor.processBasic(path.newSubPath("executionTimestamp"), ZonedDateTime.class, getExecutionTimestamp(), this);
		processor.processBasic(path.newSubPath("expirationDate"), Date.class, getExpirationDate(), this);
		processor.processBasic(path.newSubPath("counterparty1"), String.class, getCounterparty1(), this);
		processor.processBasic(path.newSubPath("counterparty2"), String.class, getCounterparty2(), this);
		processor.processBasic(path.newSubPath("counterparty2IdentifierType"), Boolean.class, getCounterparty2IdentifierType(), this);
		processor.processBasic(path.newSubPath("beneficiary1"), String.class, getBeneficiary1(), this);
		processor.processBasic(path.newSubPath("beneficiary1IdentifierTypeIndicator"), Boolean.class, getBeneficiary1IdentifierTypeIndicator(), this);
		processor.processBasic(path.newSubPath("buyerIdentifier"), String.class, getBuyerIdentifier(), this);
		processor.processBasic(path.newSubPath("sellerIdentifier"), String.class, getSellerIdentifier(), this);
		processor.processBasic(path.newSubPath("cleared"), ClearedEnum.class, getCleared(), this);
		processor.processBasic(path.newSubPath("centralCounterparty"), String.class, getCentralCounterparty(), this);
		processor.processBasic(path.newSubPath("clearingMember"), String.class, getClearingMember(), this);
		processor.processBasic(path.newSubPath("confirmed"), ConfirmationEnum.class, getConfirmed(), this);
		processor.processBasic(path.newSubPath("callAmount"), BigDecimal.class, getCallAmount(), this);
		processor.processBasic(path.newSubPath("putAmount"), BigDecimal.class, getPutAmount(), this);
		processor.processBasic(path.newSubPath("callCurrency"), ISOCurrencyCodeEnum.class, getCallCurrency(), this);
		processor.processBasic(path.newSubPath("putCurrency"), ISOCurrencyCodeEnum.class, getPutCurrency(), this);
		processor.processBasic(path.newSubPath("delta"), BigDecimal.class, getDelta(), this);
		processRosetta(path.newSubPath("priceSchedule"), processor, PricePeriod.class, getPriceSchedule());
		processRosetta(path.newSubPath("strikePriceSchedule"), processor, PricePeriod.class, getStrikePriceSchedule());
		processRosetta(path.newSubPath("price"), processor, PriceFormat.class, getPrice());
		processor.processBasic(path.newSubPath("priceNotation"), PriceNotationEnum.class, getPriceNotation(), this);
		processor.processBasic(path.newSubPath("priceCurrency"), ISOCurrencyCodeEnum.class, getPriceCurrency(), this);
		processRosetta(path.newSubPath("packageTransactionPrice"), processor, PriceFormat.class, getPackageTransactionPrice());
		processor.processBasic(path.newSubPath("packageTransactionPriceNotation"), PriceNotationEnum.class, getPackageTransactionPriceNotation(), this);
		processor.processBasic(path.newSubPath("packageTransactionPriceCurrency"), ISOCurrencyCodeEnum.class, getPackageTransactionPriceCurrency(), this);
		processRosetta(path.newSubPath("packageTransactionSpread"), processor, PriceFormat.class, getPackageTransactionSpread());
		processor.processBasic(path.newSubPath("packageTransactionSpreadNotation"), PriceNotationEnum.class, getPackageTransactionSpreadNotation(), this);
		processor.processBasic(path.newSubPath("packageTransactionSpreadCurrency"), ISOCurrencyCodeEnum.class, getPackageTransactionSpreadCurrency(), this);
		processor.processBasic(path.newSubPath("packageIdentifier"), String.class, getPackageIdentifier(), this);
		processRosetta(path.newSubPath("strikePrice"), processor, PriceFormat.class, getStrikePrice());
		processor.processBasic(path.newSubPath("strikePriceNotation"), PriceNotationEnum.class, getStrikePriceNotation(), this);
		processor.processBasic(path.newSubPath("strikePriceCurrency"), String.class, getStrikePriceCurrency(), this);
		processor.processBasic(path.newSubPath("priceUnitOfMeasure"), String.class, getPriceUnitOfMeasure(), this);
		processor.processBasic(path.newSubPath("optionPremiumAmount"), BigDecimal.class, getOptionPremiumAmount(), this);
		processor.processBasic(path.newSubPath("optionPremiumCurrency"), ISOCurrencyCodeEnum.class, getOptionPremiumCurrency(), this);
		processor.processBasic(path.newSubPath("optionPremiumPaymentDate"), Date.class, getOptionPremiumPaymentDate(), this);
		processor.processBasic(path.newSubPath("exchangeRate"), BigDecimal.class, getExchangeRate(), this);
		processor.processBasic(path.newSubPath("exchangeRateBasis"), String.class, getExchangeRateBasis(), this);
		processor.processBasic(path.newSubPath("cdSIndexAttachmentPoint"), BigDecimal.class, getCdSIndexAttachmentPoint(), this);
		processor.processBasic(path.newSubPath("cdSIndexDetachmentPoint"), BigDecimal.class, getCdSIndexDetachmentPoint(), this);
		processor.processBasic(path.newSubPath("collateralPortfolioIndicator"), Boolean.class, getCollateralPortfolioIndicator(), this);
		processor.processBasic(path.newSubPath("firstExerciseDate"), Date.class, getFirstExerciseDate(), this);
		processor.processBasic(path.newSubPath("finalContractualSettlementDate"), Date.class, getFinalContractualSettlementDate(), this);
		processor.processBasic(path.newSubPath("settlementLocation"), ISOCountryCodeEnum.class, getSettlementLocation(), this);
		processor.processBasic(path.newSubPath("priorUTI"), String.class, getPriorUTI(), this);
		processor.processBasic(path.newSubPath("direction1"), Direction1Enum.class, getDirection1(), this);
		processor.processBasic(path.newSubPath("valuationAmount"), BigDecimal.class, getValuationAmount(), this);
		processor.processBasic(path.newSubPath("valuationCurrency"), ISOCurrencyCodeEnum.class, getValuationCurrency(), this);
		processor.processBasic(path.newSubPath("valuationMethod"), ValuationType1Code.class, getValuationMethod(), this);
		processor.processBasic(path.newSubPath("valuationTimestamp"), ZonedDateTime.class, getValuationTimestamp(), this);
		processor.processBasic(path.newSubPath("customBasketCode"), String.class, getCustomBasketCode(), this);
		processRosetta(path.newSubPath("basketConstituents"), processor, BasketConstituentsReport.class, getBasketConstituents());
		processRosetta(path.newSubPath("otherPayment"), processor, OtherPayment.class, getOtherPayment());
		processRosetta(path.newSubPath("leg1"), processor, LegV2.class, getLeg1());
		processRosetta(path.newSubPath("leg2"), processor, LegV2.class, getLeg2());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CriticalDataElementV2Builder extends CriticalDataElementV2, CriticalDataElementV1.CriticalDataElementV1Builder {
		LegV2.LegV2Builder getOrCreateLeg1();
		@Override
		LegV2.LegV2Builder getLeg1();
		LegV2.LegV2Builder getOrCreateLeg2();
		@Override
		LegV2.LegV2Builder getLeg2();
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setEffectiveDate(Date effectiveDate);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setEarlyTerminationDate(Date earlyTerminationDate);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setReportingTimestamp(ZonedDateTime reportingTimestamp);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setExecutionTimestamp(ZonedDateTime executionTimestamp);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setExpirationDate(Date expirationDate);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setCounterparty1(String counterparty1);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setCounterparty2(String counterparty2);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setCounterparty2IdentifierType(Boolean counterparty2IdentifierType);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setBeneficiary1(String beneficiary1);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setBeneficiary1IdentifierTypeIndicator(Boolean beneficiary1IdentifierTypeIndicator);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setBuyerIdentifier(String buyerIdentifier);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setSellerIdentifier(String sellerIdentifier);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setCleared(ClearedEnum cleared);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setCentralCounterparty(String centralCounterparty);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setClearingMember(String clearingMember);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setConfirmed(ConfirmationEnum confirmed);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setCallAmount(BigDecimal callAmount);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setPutAmount(BigDecimal putAmount);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setCallCurrency(ISOCurrencyCodeEnum callCurrency);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setPutCurrency(ISOCurrencyCodeEnum putCurrency);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setDelta(BigDecimal delta);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder addPriceSchedule(PricePeriod priceSchedule);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder addPriceSchedule(PricePeriod priceSchedule, int idx);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder addPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setPriceSchedule(List<? extends PricePeriod> priceSchedule);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder addStrikePriceSchedule(PricePeriod strikePriceSchedule);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder addStrikePriceSchedule(PricePeriod strikePriceSchedule, int idx);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedule);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setPrice(PriceFormat price);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setPriceNotation(PriceNotationEnum priceNotation);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setPriceCurrency(ISOCurrencyCodeEnum priceCurrency);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setPackageTransactionPrice(PriceFormat packageTransactionPrice);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setPackageTransactionPriceNotation(PriceNotationEnum packageTransactionPriceNotation);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum packageTransactionPriceCurrency);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setPackageTransactionSpread(PriceFormat packageTransactionSpread);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setPackageTransactionSpreadNotation(PriceNotationEnum packageTransactionSpreadNotation);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum packageTransactionSpreadCurrency);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setPackageIdentifier(String packageIdentifier);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setStrikePrice(PriceFormat strikePrice);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setStrikePriceNotation(PriceNotationEnum strikePriceNotation);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setStrikePriceCurrency(String strikePriceCurrency);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setPriceUnitOfMeasure(String priceUnitOfMeasure);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setOptionPremiumAmount(BigDecimal optionPremiumAmount);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setOptionPremiumCurrency(ISOCurrencyCodeEnum optionPremiumCurrency);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setOptionPremiumPaymentDate(Date optionPremiumPaymentDate);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setExchangeRate(BigDecimal exchangeRate);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setExchangeRateBasis(String exchangeRateBasis);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setCdSIndexAttachmentPoint(BigDecimal cdSIndexAttachmentPoint);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setCdSIndexDetachmentPoint(BigDecimal cdSIndexDetachmentPoint);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setCollateralPortfolioIndicator(Boolean collateralPortfolioIndicator);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setFirstExerciseDate(Date firstExerciseDate);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setFinalContractualSettlementDate(Date finalContractualSettlementDate);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setSettlementLocation(ISOCountryCodeEnum settlementLocation);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setPriorUTI(String priorUTI);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setDirection1(Direction1Enum direction1);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setValuationAmount(BigDecimal valuationAmount);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setValuationCurrency(ISOCurrencyCodeEnum valuationCurrency);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setValuationMethod(ValuationType1Code valuationMethod);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setValuationTimestamp(ZonedDateTime valuationTimestamp);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setCustomBasketCode(String customBasketCode);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder addBasketConstituents(BasketConstituentsReport basketConstituents);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder addBasketConstituents(BasketConstituentsReport basketConstituents, int idx);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituents);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder addOtherPayment(OtherPayment otherPayment);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder addOtherPayment(OtherPayment otherPayment, int idx);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder addOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setOtherPayment(List<? extends OtherPayment> otherPayment);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setLeg1(LegV1 leg1);
		@Override
		CriticalDataElementV2.CriticalDataElementV2Builder setLeg2(LegV1 leg2);
		CriticalDataElementV2.CriticalDataElementV2Builder setLeg1(LegV2 leg1);
		CriticalDataElementV2.CriticalDataElementV2Builder setLeg2(LegV2 leg2);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processor.processBasic(path.newSubPath("earlyTerminationDate"), Date.class, getEarlyTerminationDate(), this);
			processor.processBasic(path.newSubPath("reportingTimestamp"), ZonedDateTime.class, getReportingTimestamp(), this);
			processor.processBasic(path.newSubPath("executionTimestamp"), ZonedDateTime.class, getExecutionTimestamp(), this);
			processor.processBasic(path.newSubPath("expirationDate"), Date.class, getExpirationDate(), this);
			processor.processBasic(path.newSubPath("counterparty1"), String.class, getCounterparty1(), this);
			processor.processBasic(path.newSubPath("counterparty2"), String.class, getCounterparty2(), this);
			processor.processBasic(path.newSubPath("counterparty2IdentifierType"), Boolean.class, getCounterparty2IdentifierType(), this);
			processor.processBasic(path.newSubPath("beneficiary1"), String.class, getBeneficiary1(), this);
			processor.processBasic(path.newSubPath("beneficiary1IdentifierTypeIndicator"), Boolean.class, getBeneficiary1IdentifierTypeIndicator(), this);
			processor.processBasic(path.newSubPath("buyerIdentifier"), String.class, getBuyerIdentifier(), this);
			processor.processBasic(path.newSubPath("sellerIdentifier"), String.class, getSellerIdentifier(), this);
			processor.processBasic(path.newSubPath("cleared"), ClearedEnum.class, getCleared(), this);
			processor.processBasic(path.newSubPath("centralCounterparty"), String.class, getCentralCounterparty(), this);
			processor.processBasic(path.newSubPath("clearingMember"), String.class, getClearingMember(), this);
			processor.processBasic(path.newSubPath("confirmed"), ConfirmationEnum.class, getConfirmed(), this);
			processor.processBasic(path.newSubPath("callAmount"), BigDecimal.class, getCallAmount(), this);
			processor.processBasic(path.newSubPath("putAmount"), BigDecimal.class, getPutAmount(), this);
			processor.processBasic(path.newSubPath("callCurrency"), ISOCurrencyCodeEnum.class, getCallCurrency(), this);
			processor.processBasic(path.newSubPath("putCurrency"), ISOCurrencyCodeEnum.class, getPutCurrency(), this);
			processor.processBasic(path.newSubPath("delta"), BigDecimal.class, getDelta(), this);
			processRosetta(path.newSubPath("priceSchedule"), processor, PricePeriod.PricePeriodBuilder.class, getPriceSchedule());
			processRosetta(path.newSubPath("strikePriceSchedule"), processor, PricePeriod.PricePeriodBuilder.class, getStrikePriceSchedule());
			processRosetta(path.newSubPath("price"), processor, PriceFormat.PriceFormatBuilder.class, getPrice());
			processor.processBasic(path.newSubPath("priceNotation"), PriceNotationEnum.class, getPriceNotation(), this);
			processor.processBasic(path.newSubPath("priceCurrency"), ISOCurrencyCodeEnum.class, getPriceCurrency(), this);
			processRosetta(path.newSubPath("packageTransactionPrice"), processor, PriceFormat.PriceFormatBuilder.class, getPackageTransactionPrice());
			processor.processBasic(path.newSubPath("packageTransactionPriceNotation"), PriceNotationEnum.class, getPackageTransactionPriceNotation(), this);
			processor.processBasic(path.newSubPath("packageTransactionPriceCurrency"), ISOCurrencyCodeEnum.class, getPackageTransactionPriceCurrency(), this);
			processRosetta(path.newSubPath("packageTransactionSpread"), processor, PriceFormat.PriceFormatBuilder.class, getPackageTransactionSpread());
			processor.processBasic(path.newSubPath("packageTransactionSpreadNotation"), PriceNotationEnum.class, getPackageTransactionSpreadNotation(), this);
			processor.processBasic(path.newSubPath("packageTransactionSpreadCurrency"), ISOCurrencyCodeEnum.class, getPackageTransactionSpreadCurrency(), this);
			processor.processBasic(path.newSubPath("packageIdentifier"), String.class, getPackageIdentifier(), this);
			processRosetta(path.newSubPath("strikePrice"), processor, PriceFormat.PriceFormatBuilder.class, getStrikePrice());
			processor.processBasic(path.newSubPath("strikePriceNotation"), PriceNotationEnum.class, getStrikePriceNotation(), this);
			processor.processBasic(path.newSubPath("strikePriceCurrency"), String.class, getStrikePriceCurrency(), this);
			processor.processBasic(path.newSubPath("priceUnitOfMeasure"), String.class, getPriceUnitOfMeasure(), this);
			processor.processBasic(path.newSubPath("optionPremiumAmount"), BigDecimal.class, getOptionPremiumAmount(), this);
			processor.processBasic(path.newSubPath("optionPremiumCurrency"), ISOCurrencyCodeEnum.class, getOptionPremiumCurrency(), this);
			processor.processBasic(path.newSubPath("optionPremiumPaymentDate"), Date.class, getOptionPremiumPaymentDate(), this);
			processor.processBasic(path.newSubPath("exchangeRate"), BigDecimal.class, getExchangeRate(), this);
			processor.processBasic(path.newSubPath("exchangeRateBasis"), String.class, getExchangeRateBasis(), this);
			processor.processBasic(path.newSubPath("cdSIndexAttachmentPoint"), BigDecimal.class, getCdSIndexAttachmentPoint(), this);
			processor.processBasic(path.newSubPath("cdSIndexDetachmentPoint"), BigDecimal.class, getCdSIndexDetachmentPoint(), this);
			processor.processBasic(path.newSubPath("collateralPortfolioIndicator"), Boolean.class, getCollateralPortfolioIndicator(), this);
			processor.processBasic(path.newSubPath("firstExerciseDate"), Date.class, getFirstExerciseDate(), this);
			processor.processBasic(path.newSubPath("finalContractualSettlementDate"), Date.class, getFinalContractualSettlementDate(), this);
			processor.processBasic(path.newSubPath("settlementLocation"), ISOCountryCodeEnum.class, getSettlementLocation(), this);
			processor.processBasic(path.newSubPath("priorUTI"), String.class, getPriorUTI(), this);
			processor.processBasic(path.newSubPath("direction1"), Direction1Enum.class, getDirection1(), this);
			processor.processBasic(path.newSubPath("valuationAmount"), BigDecimal.class, getValuationAmount(), this);
			processor.processBasic(path.newSubPath("valuationCurrency"), ISOCurrencyCodeEnum.class, getValuationCurrency(), this);
			processor.processBasic(path.newSubPath("valuationMethod"), ValuationType1Code.class, getValuationMethod(), this);
			processor.processBasic(path.newSubPath("valuationTimestamp"), ZonedDateTime.class, getValuationTimestamp(), this);
			processor.processBasic(path.newSubPath("customBasketCode"), String.class, getCustomBasketCode(), this);
			processRosetta(path.newSubPath("basketConstituents"), processor, BasketConstituentsReport.BasketConstituentsReportBuilder.class, getBasketConstituents());
			processRosetta(path.newSubPath("otherPayment"), processor, OtherPayment.OtherPaymentBuilder.class, getOtherPayment());
			processRosetta(path.newSubPath("leg1"), processor, LegV2.LegV2Builder.class, getLeg1());
			processRosetta(path.newSubPath("leg2"), processor, LegV2.LegV2Builder.class, getLeg2());
		}
		

		CriticalDataElementV2.CriticalDataElementV2Builder prune();
	}

	/*********************** Immutable Implementation of CriticalDataElementV2  ***********************/
	class CriticalDataElementV2Impl extends CriticalDataElementV1.CriticalDataElementV1Impl implements CriticalDataElementV2 {
		private final LegV2 leg1;
		private final LegV2 leg2;
		
		protected CriticalDataElementV2Impl(CriticalDataElementV2.CriticalDataElementV2Builder builder) {
			super(builder);
			this.leg1 = ofNullable(builder.getLeg1()).map(f->f.build()).orElse(null);
			this.leg2 = ofNullable(builder.getLeg2()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("leg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg1")
		public LegV2 getLeg1() {
			return leg1;
		}
		
		@Override
		@RosettaAttribute("leg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg2")
		public LegV2 getLeg2() {
			return leg2;
		}
		
		@Override
		public CriticalDataElementV2 build() {
			return this;
		}
		
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder toBuilder() {
			CriticalDataElementV2.CriticalDataElementV2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CriticalDataElementV2.CriticalDataElementV2Builder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLeg1()).ifPresent(builder::setLeg1);
			ofNullable(getLeg2()).ifPresent(builder::setLeg2);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CriticalDataElementV2 _that = getType().cast(o);
		
			if (!Objects.equals(leg1, _that.getLeg1())) return false;
			if (!Objects.equals(leg2, _that.getLeg2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (leg1 != null ? leg1.hashCode() : 0);
			_result = 31 * _result + (leg2 != null ? leg2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CriticalDataElementV2 {" +
				"leg1=" + this.leg1 + ", " +
				"leg2=" + this.leg2 +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CriticalDataElementV2  ***********************/
	class CriticalDataElementV2BuilderImpl implements CriticalDataElementV2.CriticalDataElementV2Builder {
	
		protected Date effectiveDate;
		protected Date earlyTerminationDate;
		protected ZonedDateTime reportingTimestamp;
		protected ZonedDateTime executionTimestamp;
		protected Date expirationDate;
		protected String counterparty1;
		protected String counterparty2;
		protected Boolean counterparty2IdentifierType;
		protected String beneficiary1;
		protected Boolean beneficiary1IdentifierTypeIndicator;
		protected String buyerIdentifier;
		protected String sellerIdentifier;
		protected ClearedEnum cleared;
		protected String centralCounterparty;
		protected String clearingMember;
		protected ConfirmationEnum confirmed;
		protected BigDecimal callAmount;
		protected BigDecimal putAmount;
		protected ISOCurrencyCodeEnum callCurrency;
		protected ISOCurrencyCodeEnum putCurrency;
		protected BigDecimal delta;
		protected List<PricePeriod.PricePeriodBuilder> priceSchedule = new ArrayList<>();
		protected List<PricePeriod.PricePeriodBuilder> strikePriceSchedule = new ArrayList<>();
		protected PriceFormat.PriceFormatBuilder price;
		protected PriceNotationEnum priceNotation;
		protected ISOCurrencyCodeEnum priceCurrency;
		protected PriceFormat.PriceFormatBuilder packageTransactionPrice;
		protected PriceNotationEnum packageTransactionPriceNotation;
		protected ISOCurrencyCodeEnum packageTransactionPriceCurrency;
		protected PriceFormat.PriceFormatBuilder packageTransactionSpread;
		protected PriceNotationEnum packageTransactionSpreadNotation;
		protected ISOCurrencyCodeEnum packageTransactionSpreadCurrency;
		protected String packageIdentifier;
		protected PriceFormat.PriceFormatBuilder strikePrice;
		protected PriceNotationEnum strikePriceNotation;
		protected String strikePriceCurrency;
		protected String priceUnitOfMeasure;
		protected BigDecimal optionPremiumAmount;
		protected ISOCurrencyCodeEnum optionPremiumCurrency;
		protected Date optionPremiumPaymentDate;
		protected BigDecimal exchangeRate;
		protected String exchangeRateBasis;
		protected BigDecimal cdSIndexAttachmentPoint;
		protected BigDecimal cdSIndexDetachmentPoint;
		protected Boolean collateralPortfolioIndicator;
		protected Date firstExerciseDate;
		protected Date finalContractualSettlementDate;
		protected ISOCountryCodeEnum settlementLocation;
		protected String priorUTI;
		protected Direction1Enum direction1;
		protected BigDecimal valuationAmount;
		protected ISOCurrencyCodeEnum valuationCurrency;
		protected ValuationType1Code valuationMethod;
		protected ZonedDateTime valuationTimestamp;
		protected String customBasketCode;
		protected List<BasketConstituentsReport.BasketConstituentsReportBuilder> basketConstituents = new ArrayList<>();
		protected List<OtherPayment.OtherPaymentBuilder> otherPayment = new ArrayList<>();
		protected LegV2.LegV2Builder leg1;
		protected LegV2.LegV2Builder leg2;
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earlyTerminationDate")
		public Date getEarlyTerminationDate() {
			return earlyTerminationDate;
		}
		
		@Override
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		public ZonedDateTime getReportingTimestamp() {
			return reportingTimestamp;
		}
		
		@Override
		@RosettaAttribute("executionTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionTimestamp")
		public ZonedDateTime getExecutionTimestamp() {
			return executionTimestamp;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationDate")
		public Date getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("counterparty1")
		public String getCounterparty1() {
			return counterparty1;
		}
		
		@Override
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2")
		public String getCounterparty2() {
			return counterparty2;
		}
		
		@Override
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterparty2IdentifierType")
		public Boolean getCounterparty2IdentifierType() {
			return counterparty2IdentifierType;
		}
		
		@Override
		@RosettaAttribute("beneficiary1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("beneficiary1")
		public String getBeneficiary1() {
			return beneficiary1;
		}
		
		@Override
		@RosettaAttribute("beneficiary1IdentifierTypeIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("beneficiary1IdentifierTypeIndicator")
		public Boolean getBeneficiary1IdentifierTypeIndicator() {
			return beneficiary1IdentifierTypeIndicator;
		}
		
		@Override
		@RosettaAttribute("buyerIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerIdentifier")
		public String getBuyerIdentifier() {
			return buyerIdentifier;
		}
		
		@Override
		@RosettaAttribute("sellerIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerIdentifier")
		public String getSellerIdentifier() {
			return sellerIdentifier;
		}
		
		@Override
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cleared")
		public ClearedEnum getCleared() {
			return cleared;
		}
		
		@Override
		@RosettaAttribute("centralCounterparty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("centralCounterparty")
		public String getCentralCounterparty() {
			return centralCounterparty;
		}
		
		@Override
		@RosettaAttribute("clearingMember")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingMember")
		public String getClearingMember() {
			return clearingMember;
		}
		
		@Override
		@RosettaAttribute("confirmed")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("confirmed")
		public ConfirmationEnum getConfirmed() {
			return confirmed;
		}
		
		@Override
		@RosettaAttribute("callAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("callAmount")
		public BigDecimal getCallAmount() {
			return callAmount;
		}
		
		@Override
		@RosettaAttribute("putAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("putAmount")
		public BigDecimal getPutAmount() {
			return putAmount;
		}
		
		@Override
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("callCurrency")
		public ISOCurrencyCodeEnum getCallCurrency() {
			return callCurrency;
		}
		
		@Override
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("putCurrency")
		public ISOCurrencyCodeEnum getPutCurrency() {
			return putCurrency;
		}
		
		@Override
		@RosettaAttribute("delta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("delta")
		public BigDecimal getDelta() {
			return delta;
		}
		
		@Override
		@RosettaAttribute("priceSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("priceSchedule")
		public List<? extends PricePeriod.PricePeriodBuilder> getPriceSchedule() {
			return priceSchedule;
		}
		
		@Override
		public PricePeriod.PricePeriodBuilder getOrCreatePriceSchedule(int index) {
			if (priceSchedule==null) {
				this.priceSchedule = new ArrayList<>();
			}
			return getIndex(priceSchedule, index, () -> {
						PricePeriod.PricePeriodBuilder newPriceSchedule = PricePeriod.builder();
						return newPriceSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("strikePriceSchedule")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strikePriceSchedule")
		public List<? extends PricePeriod.PricePeriodBuilder> getStrikePriceSchedule() {
			return strikePriceSchedule;
		}
		
		@Override
		public PricePeriod.PricePeriodBuilder getOrCreateStrikePriceSchedule(int index) {
			if (strikePriceSchedule==null) {
				this.strikePriceSchedule = new ArrayList<>();
			}
			return getIndex(strikePriceSchedule, index, () -> {
						PricePeriod.PricePeriodBuilder newStrikePriceSchedule = PricePeriod.builder();
						return newStrikePriceSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public PriceFormat.PriceFormatBuilder getPrice() {
			return price;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder getOrCreatePrice() {
			PriceFormat.PriceFormatBuilder result;
			if (price!=null) {
				result = price;
			}
			else {
				result = price = PriceFormat.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceNotation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceNotation")
		public PriceNotationEnum getPriceNotation() {
			return priceNotation;
		}
		
		@Override
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceCurrency")
		public ISOCurrencyCodeEnum getPriceCurrency() {
			return priceCurrency;
		}
		
		@Override
		@RosettaAttribute("packageTransactionPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionPrice")
		public PriceFormat.PriceFormatBuilder getPackageTransactionPrice() {
			return packageTransactionPrice;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder getOrCreatePackageTransactionPrice() {
			PriceFormat.PriceFormatBuilder result;
			if (packageTransactionPrice!=null) {
				result = packageTransactionPrice;
			}
			else {
				result = packageTransactionPrice = PriceFormat.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("packageTransactionPriceNotation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionPriceNotation")
		public PriceNotationEnum getPackageTransactionPriceNotation() {
			return packageTransactionPriceNotation;
		}
		
		@Override
		@RosettaAttribute("packageTransactionPriceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionPriceCurrency")
		public ISOCurrencyCodeEnum getPackageTransactionPriceCurrency() {
			return packageTransactionPriceCurrency;
		}
		
		@Override
		@RosettaAttribute("packageTransactionSpread")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionSpread")
		public PriceFormat.PriceFormatBuilder getPackageTransactionSpread() {
			return packageTransactionSpread;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder getOrCreatePackageTransactionSpread() {
			PriceFormat.PriceFormatBuilder result;
			if (packageTransactionSpread!=null) {
				result = packageTransactionSpread;
			}
			else {
				result = packageTransactionSpread = PriceFormat.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("packageTransactionSpreadNotation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionSpreadNotation")
		public PriceNotationEnum getPackageTransactionSpreadNotation() {
			return packageTransactionSpreadNotation;
		}
		
		@Override
		@RosettaAttribute("packageTransactionSpreadCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTransactionSpreadCurrency")
		public ISOCurrencyCodeEnum getPackageTransactionSpreadCurrency() {
			return packageTransactionSpreadCurrency;
		}
		
		@Override
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageIdentifier")
		public String getPackageIdentifier() {
			return packageIdentifier;
		}
		
		@Override
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePrice")
		public PriceFormat.PriceFormatBuilder getStrikePrice() {
			return strikePrice;
		}
		
		@Override
		public PriceFormat.PriceFormatBuilder getOrCreateStrikePrice() {
			PriceFormat.PriceFormatBuilder result;
			if (strikePrice!=null) {
				result = strikePrice;
			}
			else {
				result = strikePrice = PriceFormat.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePriceNotation")
		public PriceNotationEnum getStrikePriceNotation() {
			return strikePriceNotation;
		}
		
		@Override
		@RosettaAttribute("strikePriceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePriceCurrency")
		public String getStrikePriceCurrency() {
			return strikePriceCurrency;
		}
		
		@Override
		@RosettaAttribute("priceUnitOfMeasure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceUnitOfMeasure")
		public String getPriceUnitOfMeasure() {
			return priceUnitOfMeasure;
		}
		
		@Override
		@RosettaAttribute("optionPremiumAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionPremiumAmount")
		public BigDecimal getOptionPremiumAmount() {
			return optionPremiumAmount;
		}
		
		@Override
		@RosettaAttribute("optionPremiumCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionPremiumCurrency")
		public ISOCurrencyCodeEnum getOptionPremiumCurrency() {
			return optionPremiumCurrency;
		}
		
		@Override
		@RosettaAttribute("optionPremiumPaymentDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionPremiumPaymentDate")
		public Date getOptionPremiumPaymentDate() {
			return optionPremiumPaymentDate;
		}
		
		@Override
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeRate")
		public BigDecimal getExchangeRate() {
			return exchangeRate;
		}
		
		@Override
		@RosettaAttribute("exchangeRateBasis")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exchangeRateBasis")
		public String getExchangeRateBasis() {
			return exchangeRateBasis;
		}
		
		@Override
		@RosettaAttribute("cdSIndexAttachmentPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdSIndexAttachmentPoint")
		public BigDecimal getCdSIndexAttachmentPoint() {
			return cdSIndexAttachmentPoint;
		}
		
		@Override
		@RosettaAttribute("cdSIndexDetachmentPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cdSIndexDetachmentPoint")
		public BigDecimal getCdSIndexDetachmentPoint() {
			return cdSIndexDetachmentPoint;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		public Boolean getCollateralPortfolioIndicator() {
			return collateralPortfolioIndicator;
		}
		
		@Override
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firstExerciseDate")
		public Date getFirstExerciseDate() {
			return firstExerciseDate;
		}
		
		@Override
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalContractualSettlementDate")
		public Date getFinalContractualSettlementDate() {
			return finalContractualSettlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementLocation")
		public ISOCountryCodeEnum getSettlementLocation() {
			return settlementLocation;
		}
		
		@Override
		@RosettaAttribute("priorUTI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priorUTI")
		public String getPriorUTI() {
			return priorUTI;
		}
		
		@Override
		@RosettaAttribute("direction1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("direction1")
		public Direction1Enum getDirection1() {
			return direction1;
		}
		
		@Override
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationAmount")
		public BigDecimal getValuationAmount() {
			return valuationAmount;
		}
		
		@Override
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationCurrency")
		public ISOCurrencyCodeEnum getValuationCurrency() {
			return valuationCurrency;
		}
		
		@Override
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationMethod")
		public ValuationType1Code getValuationMethod() {
			return valuationMethod;
		}
		
		@Override
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationTimestamp")
		public ZonedDateTime getValuationTimestamp() {
			return valuationTimestamp;
		}
		
		@Override
		@RosettaAttribute("customBasketCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("customBasketCode")
		public String getCustomBasketCode() {
			return customBasketCode;
		}
		
		@Override
		@RosettaAttribute("basketConstituents")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("basketConstituents")
		public List<? extends BasketConstituentsReport.BasketConstituentsReportBuilder> getBasketConstituents() {
			return basketConstituents;
		}
		
		@Override
		public BasketConstituentsReport.BasketConstituentsReportBuilder getOrCreateBasketConstituents(int index) {
			if (basketConstituents==null) {
				this.basketConstituents = new ArrayList<>();
			}
			return getIndex(basketConstituents, index, () -> {
						BasketConstituentsReport.BasketConstituentsReportBuilder newBasketConstituents = BasketConstituentsReport.builder();
						return newBasketConstituents;
					});
		}
		
		@Override
		@RosettaAttribute("otherPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPayment")
		public List<? extends OtherPayment.OtherPaymentBuilder> getOtherPayment() {
			return otherPayment;
		}
		
		@Override
		public OtherPayment.OtherPaymentBuilder getOrCreateOtherPayment(int index) {
			if (otherPayment==null) {
				this.otherPayment = new ArrayList<>();
			}
			return getIndex(otherPayment, index, () -> {
						OtherPayment.OtherPaymentBuilder newOtherPayment = OtherPayment.builder();
						return newOtherPayment;
					});
		}
		
		@Override
		@RosettaAttribute("leg1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg1")
		public LegV2.LegV2Builder getLeg1() {
			return leg1;
		}
		
		@Override
		public LegV2.LegV2Builder getOrCreateLeg1() {
			LegV2.LegV2Builder result;
			if (leg1!=null) {
				result = leg1;
			}
			else {
				result = leg1 = LegV2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("leg2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg2")
		public LegV2.LegV2Builder getLeg2() {
			return leg2;
		}
		
		@Override
		public LegV2.LegV2Builder getOrCreateLeg2() {
			LegV2.LegV2Builder result;
			if (leg2!=null) {
				result = leg2;
			}
			else {
				result = leg2 = LegV2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setEffectiveDate(Date _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate;
			return this;
		}
		
		@RosettaAttribute("earlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earlyTerminationDate")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setEarlyTerminationDate(Date _earlyTerminationDate) {
			this.earlyTerminationDate = _earlyTerminationDate == null ? null : _earlyTerminationDate;
			return this;
		}
		
		@RosettaAttribute("reportingTimestamp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingTimestamp")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setReportingTimestamp(ZonedDateTime _reportingTimestamp) {
			this.reportingTimestamp = _reportingTimestamp == null ? null : _reportingTimestamp;
			return this;
		}
		
		@RosettaAttribute("executionTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionTimestamp")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setExecutionTimestamp(ZonedDateTime _executionTimestamp) {
			this.executionTimestamp = _executionTimestamp == null ? null : _executionTimestamp;
			return this;
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDate")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setExpirationDate(Date _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate;
			return this;
		}
		
		@RosettaAttribute("counterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("counterparty1")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setCounterparty1(String _counterparty1) {
			this.counterparty1 = _counterparty1 == null ? null : _counterparty1;
			return this;
		}
		
		@RosettaAttribute("counterparty2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setCounterparty2(String _counterparty2) {
			this.counterparty2 = _counterparty2 == null ? null : _counterparty2;
			return this;
		}
		
		@RosettaAttribute("counterparty2IdentifierType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterparty2IdentifierType")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setCounterparty2IdentifierType(Boolean _counterparty2IdentifierType) {
			this.counterparty2IdentifierType = _counterparty2IdentifierType == null ? null : _counterparty2IdentifierType;
			return this;
		}
		
		@RosettaAttribute("beneficiary1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setBeneficiary1(String _beneficiary1) {
			this.beneficiary1 = _beneficiary1 == null ? null : _beneficiary1;
			return this;
		}
		
		@RosettaAttribute("beneficiary1IdentifierTypeIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("beneficiary1IdentifierTypeIndicator")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setBeneficiary1IdentifierTypeIndicator(Boolean _beneficiary1IdentifierTypeIndicator) {
			this.beneficiary1IdentifierTypeIndicator = _beneficiary1IdentifierTypeIndicator == null ? null : _beneficiary1IdentifierTypeIndicator;
			return this;
		}
		
		@RosettaAttribute("buyerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerIdentifier")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setBuyerIdentifier(String _buyerIdentifier) {
			this.buyerIdentifier = _buyerIdentifier == null ? null : _buyerIdentifier;
			return this;
		}
		
		@RosettaAttribute("sellerIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerIdentifier")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setSellerIdentifier(String _sellerIdentifier) {
			this.sellerIdentifier = _sellerIdentifier == null ? null : _sellerIdentifier;
			return this;
		}
		
		@RosettaAttribute("cleared")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cleared")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setCleared(ClearedEnum _cleared) {
			this.cleared = _cleared == null ? null : _cleared;
			return this;
		}
		
		@RosettaAttribute("centralCounterparty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("centralCounterparty")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setCentralCounterparty(String _centralCounterparty) {
			this.centralCounterparty = _centralCounterparty == null ? null : _centralCounterparty;
			return this;
		}
		
		@RosettaAttribute("clearingMember")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingMember")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setClearingMember(String _clearingMember) {
			this.clearingMember = _clearingMember == null ? null : _clearingMember;
			return this;
		}
		
		@RosettaAttribute("confirmed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("confirmed")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setConfirmed(ConfirmationEnum _confirmed) {
			this.confirmed = _confirmed == null ? null : _confirmed;
			return this;
		}
		
		@RosettaAttribute("callAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callAmount")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setCallAmount(BigDecimal _callAmount) {
			this.callAmount = _callAmount == null ? null : _callAmount;
			return this;
		}
		
		@RosettaAttribute("putAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putAmount")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setPutAmount(BigDecimal _putAmount) {
			this.putAmount = _putAmount == null ? null : _putAmount;
			return this;
		}
		
		@RosettaAttribute("callCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callCurrency")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setCallCurrency(ISOCurrencyCodeEnum _callCurrency) {
			this.callCurrency = _callCurrency == null ? null : _callCurrency;
			return this;
		}
		
		@RosettaAttribute("putCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putCurrency")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setPutCurrency(ISOCurrencyCodeEnum _putCurrency) {
			this.putCurrency = _putCurrency == null ? null : _putCurrency;
			return this;
		}
		
		@RosettaAttribute("delta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("delta")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setDelta(BigDecimal _delta) {
			this.delta = _delta == null ? null : _delta;
			return this;
		}
		
		@RosettaAttribute("priceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("priceSchedule")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder addPriceSchedule(PricePeriod _priceSchedule) {
			if (_priceSchedule != null) {
				this.priceSchedule.add(_priceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder addPriceSchedule(PricePeriod _priceSchedule, int idx) {
			getIndex(this.priceSchedule, idx, () -> _priceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder addPriceSchedule(List<? extends PricePeriod> priceSchedules) {
			if (priceSchedules != null) {
				for (final PricePeriod toAdd : priceSchedules) {
					this.priceSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("priceSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("priceSchedule")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setPriceSchedule(List<? extends PricePeriod> priceSchedules) {
			if (priceSchedules == null) {
				this.priceSchedule = new ArrayList<>();
			} else {
				this.priceSchedule = priceSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("strikePriceSchedule")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("strikePriceSchedule")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder addStrikePriceSchedule(PricePeriod _strikePriceSchedule) {
			if (_strikePriceSchedule != null) {
				this.strikePriceSchedule.add(_strikePriceSchedule.toBuilder());
			}
			return this;
		}
		
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder addStrikePriceSchedule(PricePeriod _strikePriceSchedule, int idx) {
			getIndex(this.strikePriceSchedule, idx, () -> _strikePriceSchedule.toBuilder());
			return this;
		}
		
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder addStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
			if (strikePriceSchedules != null) {
				for (final PricePeriod toAdd : strikePriceSchedules) {
					this.strikePriceSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("strikePriceSchedule")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("strikePriceSchedule")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setStrikePriceSchedule(List<? extends PricePeriod> strikePriceSchedules) {
			if (strikePriceSchedules == null) {
				this.strikePriceSchedule = new ArrayList<>();
			} else {
				this.strikePriceSchedule = strikePriceSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("price")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("price")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setPrice(PriceFormat _price) {
			this.price = _price == null ? null : _price.toBuilder();
			return this;
		}
		
		@RosettaAttribute("priceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceNotation")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setPriceNotation(PriceNotationEnum _priceNotation) {
			this.priceNotation = _priceNotation == null ? null : _priceNotation;
			return this;
		}
		
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceCurrency")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setPriceCurrency(ISOCurrencyCodeEnum _priceCurrency) {
			this.priceCurrency = _priceCurrency == null ? null : _priceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPrice")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setPackageTransactionPrice(PriceFormat _packageTransactionPrice) {
			this.packageTransactionPrice = _packageTransactionPrice == null ? null : _packageTransactionPrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceNotation")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setPackageTransactionPriceNotation(PriceNotationEnum _packageTransactionPriceNotation) {
			this.packageTransactionPriceNotation = _packageTransactionPriceNotation == null ? null : _packageTransactionPriceNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionPriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionPriceCurrency")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setPackageTransactionPriceCurrency(ISOCurrencyCodeEnum _packageTransactionPriceCurrency) {
			this.packageTransactionPriceCurrency = _packageTransactionPriceCurrency == null ? null : _packageTransactionPriceCurrency;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpread")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpread")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setPackageTransactionSpread(PriceFormat _packageTransactionSpread) {
			this.packageTransactionSpread = _packageTransactionSpread == null ? null : _packageTransactionSpread.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadNotation")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setPackageTransactionSpreadNotation(PriceNotationEnum _packageTransactionSpreadNotation) {
			this.packageTransactionSpreadNotation = _packageTransactionSpreadNotation == null ? null : _packageTransactionSpreadNotation;
			return this;
		}
		
		@RosettaAttribute("packageTransactionSpreadCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTransactionSpreadCurrency")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setPackageTransactionSpreadCurrency(ISOCurrencyCodeEnum _packageTransactionSpreadCurrency) {
			this.packageTransactionSpreadCurrency = _packageTransactionSpreadCurrency == null ? null : _packageTransactionSpreadCurrency;
			return this;
		}
		
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIdentifier")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setPackageIdentifier(String _packageIdentifier) {
			this.packageIdentifier = _packageIdentifier == null ? null : _packageIdentifier;
			return this;
		}
		
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePrice")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setStrikePrice(PriceFormat _strikePrice) {
			this.strikePrice = _strikePrice == null ? null : _strikePrice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikePriceNotation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceNotation")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setStrikePriceNotation(PriceNotationEnum _strikePriceNotation) {
			this.strikePriceNotation = _strikePriceNotation == null ? null : _strikePriceNotation;
			return this;
		}
		
		@RosettaAttribute("strikePriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceCurrency")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setStrikePriceCurrency(String _strikePriceCurrency) {
			this.strikePriceCurrency = _strikePriceCurrency == null ? null : _strikePriceCurrency;
			return this;
		}
		
		@RosettaAttribute("priceUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceUnitOfMeasure")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setPriceUnitOfMeasure(String _priceUnitOfMeasure) {
			this.priceUnitOfMeasure = _priceUnitOfMeasure == null ? null : _priceUnitOfMeasure;
			return this;
		}
		
		@RosettaAttribute("optionPremiumAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumAmount")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setOptionPremiumAmount(BigDecimal _optionPremiumAmount) {
			this.optionPremiumAmount = _optionPremiumAmount == null ? null : _optionPremiumAmount;
			return this;
		}
		
		@RosettaAttribute("optionPremiumCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumCurrency")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setOptionPremiumCurrency(ISOCurrencyCodeEnum _optionPremiumCurrency) {
			this.optionPremiumCurrency = _optionPremiumCurrency == null ? null : _optionPremiumCurrency;
			return this;
		}
		
		@RosettaAttribute("optionPremiumPaymentDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionPremiumPaymentDate")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setOptionPremiumPaymentDate(Date _optionPremiumPaymentDate) {
			this.optionPremiumPaymentDate = _optionPremiumPaymentDate == null ? null : _optionPremiumPaymentDate;
			return this;
		}
		
		@RosettaAttribute("exchangeRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRate")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setExchangeRate(BigDecimal _exchangeRate) {
			this.exchangeRate = _exchangeRate == null ? null : _exchangeRate;
			return this;
		}
		
		@RosettaAttribute("exchangeRateBasis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeRateBasis")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setExchangeRateBasis(String _exchangeRateBasis) {
			this.exchangeRateBasis = _exchangeRateBasis == null ? null : _exchangeRateBasis;
			return this;
		}
		
		@RosettaAttribute("cdSIndexAttachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexAttachmentPoint")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setCdSIndexAttachmentPoint(BigDecimal _cdSIndexAttachmentPoint) {
			this.cdSIndexAttachmentPoint = _cdSIndexAttachmentPoint == null ? null : _cdSIndexAttachmentPoint;
			return this;
		}
		
		@RosettaAttribute("cdSIndexDetachmentPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cdSIndexDetachmentPoint")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setCdSIndexDetachmentPoint(BigDecimal _cdSIndexDetachmentPoint) {
			this.cdSIndexDetachmentPoint = _cdSIndexDetachmentPoint == null ? null : _cdSIndexDetachmentPoint;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralPortfolioIndicator")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setCollateralPortfolioIndicator(Boolean _collateralPortfolioIndicator) {
			this.collateralPortfolioIndicator = _collateralPortfolioIndicator == null ? null : _collateralPortfolioIndicator;
			return this;
		}
		
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firstExerciseDate")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setFirstExerciseDate(Date _firstExerciseDate) {
			this.firstExerciseDate = _firstExerciseDate == null ? null : _firstExerciseDate;
			return this;
		}
		
		@RosettaAttribute("finalContractualSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalContractualSettlementDate")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setFinalContractualSettlementDate(Date _finalContractualSettlementDate) {
			this.finalContractualSettlementDate = _finalContractualSettlementDate == null ? null : _finalContractualSettlementDate;
			return this;
		}
		
		@RosettaAttribute("settlementLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementLocation")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setSettlementLocation(ISOCountryCodeEnum _settlementLocation) {
			this.settlementLocation = _settlementLocation == null ? null : _settlementLocation;
			return this;
		}
		
		@RosettaAttribute("priorUTI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priorUTI")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setPriorUTI(String _priorUTI) {
			this.priorUTI = _priorUTI == null ? null : _priorUTI;
			return this;
		}
		
		@RosettaAttribute("direction1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("direction1")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setDirection1(Direction1Enum _direction1) {
			this.direction1 = _direction1 == null ? null : _direction1;
			return this;
		}
		
		@RosettaAttribute("valuationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationAmount")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setValuationAmount(BigDecimal _valuationAmount) {
			this.valuationAmount = _valuationAmount == null ? null : _valuationAmount;
			return this;
		}
		
		@RosettaAttribute("valuationCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationCurrency")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setValuationCurrency(ISOCurrencyCodeEnum _valuationCurrency) {
			this.valuationCurrency = _valuationCurrency == null ? null : _valuationCurrency;
			return this;
		}
		
		@RosettaAttribute("valuationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationMethod")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setValuationMethod(ValuationType1Code _valuationMethod) {
			this.valuationMethod = _valuationMethod == null ? null : _valuationMethod;
			return this;
		}
		
		@RosettaAttribute("valuationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationTimestamp")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setValuationTimestamp(ZonedDateTime _valuationTimestamp) {
			this.valuationTimestamp = _valuationTimestamp == null ? null : _valuationTimestamp;
			return this;
		}
		
		@RosettaAttribute("customBasketCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("customBasketCode")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setCustomBasketCode(String _customBasketCode) {
			this.customBasketCode = _customBasketCode == null ? null : _customBasketCode;
			return this;
		}
		
		@RosettaAttribute("basketConstituents")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("basketConstituents")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder addBasketConstituents(BasketConstituentsReport _basketConstituents) {
			if (_basketConstituents != null) {
				this.basketConstituents.add(_basketConstituents.toBuilder());
			}
			return this;
		}
		
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder addBasketConstituents(BasketConstituentsReport _basketConstituents, int idx) {
			getIndex(this.basketConstituents, idx, () -> _basketConstituents.toBuilder());
			return this;
		}
		
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder addBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
			if (basketConstituentss != null) {
				for (final BasketConstituentsReport toAdd : basketConstituentss) {
					this.basketConstituents.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("basketConstituents")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("basketConstituents")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setBasketConstituents(List<? extends BasketConstituentsReport> basketConstituentss) {
			if (basketConstituentss == null) {
				this.basketConstituents = new ArrayList<>();
			} else {
				this.basketConstituents = basketConstituentss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("otherPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("otherPayment")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder addOtherPayment(OtherPayment _otherPayment) {
			if (_otherPayment != null) {
				this.otherPayment.add(_otherPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder addOtherPayment(OtherPayment _otherPayment, int idx) {
			getIndex(this.otherPayment, idx, () -> _otherPayment.toBuilder());
			return this;
		}
		
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder addOtherPayment(List<? extends OtherPayment> otherPayments) {
			if (otherPayments != null) {
				for (final OtherPayment toAdd : otherPayments) {
					this.otherPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("otherPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("otherPayment")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setOtherPayment(List<? extends OtherPayment> otherPayments) {
			if (otherPayments == null) {
				this.otherPayment = new ArrayList<>();
			} else {
				this.otherPayment = otherPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg1")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setLeg1(LegV2 _leg1) {
			this.leg1 = _leg1 == null ? null : _leg1.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setLeg1(LegV1 _leg1) {
			final LegV2 ifThenElseResult;
			if (_leg1 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg1 instanceof LegV2 ? LegV2.class.cast(_leg1) : null;
			}
			return setLeg1(ifThenElseResult);
		}
		
		@RosettaAttribute("leg2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg2")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setLeg2(LegV2 _leg2) {
			this.leg2 = _leg2 == null ? null : _leg2.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder setLeg2(LegV1 _leg2) {
			final LegV2 ifThenElseResult;
			if (_leg2 == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _leg2 instanceof LegV2 ? LegV2.class.cast(_leg2) : null;
			}
			return setLeg2(ifThenElseResult);
		}
		
		@Override
		public CriticalDataElementV2 build() {
			return new CriticalDataElementV2.CriticalDataElementV2Impl(this);
		}
		
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder prune() {
			priceSchedule = priceSchedule.stream().filter(b->b!=null).<PricePeriod.PricePeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			strikePriceSchedule = strikePriceSchedule.stream().filter(b->b!=null).<PricePeriod.PricePeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (price!=null && !price.prune().hasData()) price = null;
			if (packageTransactionPrice!=null && !packageTransactionPrice.prune().hasData()) packageTransactionPrice = null;
			if (packageTransactionSpread!=null && !packageTransactionSpread.prune().hasData()) packageTransactionSpread = null;
			if (strikePrice!=null && !strikePrice.prune().hasData()) strikePrice = null;
			basketConstituents = basketConstituents.stream().filter(b->b!=null).<BasketConstituentsReport.BasketConstituentsReportBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			otherPayment = otherPayment.stream().filter(b->b!=null).<OtherPayment.OtherPaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (leg1!=null && !leg1.prune().hasData()) leg1 = null;
			if (leg2!=null && !leg2.prune().hasData()) leg2 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null) return true;
			if (getEarlyTerminationDate()!=null) return true;
			if (getReportingTimestamp()!=null) return true;
			if (getExecutionTimestamp()!=null) return true;
			if (getExpirationDate()!=null) return true;
			if (getCounterparty1()!=null) return true;
			if (getCounterparty2()!=null) return true;
			if (getCounterparty2IdentifierType()!=null) return true;
			if (getBeneficiary1()!=null) return true;
			if (getBeneficiary1IdentifierTypeIndicator()!=null) return true;
			if (getBuyerIdentifier()!=null) return true;
			if (getSellerIdentifier()!=null) return true;
			if (getCleared()!=null) return true;
			if (getCentralCounterparty()!=null) return true;
			if (getClearingMember()!=null) return true;
			if (getConfirmed()!=null) return true;
			if (getCallAmount()!=null) return true;
			if (getPutAmount()!=null) return true;
			if (getCallCurrency()!=null) return true;
			if (getPutCurrency()!=null) return true;
			if (getDelta()!=null) return true;
			if (getPriceSchedule()!=null && getPriceSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getStrikePriceSchedule()!=null && getStrikePriceSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPrice()!=null && getPrice().hasData()) return true;
			if (getPriceNotation()!=null) return true;
			if (getPriceCurrency()!=null) return true;
			if (getPackageTransactionPrice()!=null && getPackageTransactionPrice().hasData()) return true;
			if (getPackageTransactionPriceNotation()!=null) return true;
			if (getPackageTransactionPriceCurrency()!=null) return true;
			if (getPackageTransactionSpread()!=null && getPackageTransactionSpread().hasData()) return true;
			if (getPackageTransactionSpreadNotation()!=null) return true;
			if (getPackageTransactionSpreadCurrency()!=null) return true;
			if (getPackageIdentifier()!=null) return true;
			if (getStrikePrice()!=null && getStrikePrice().hasData()) return true;
			if (getStrikePriceNotation()!=null) return true;
			if (getStrikePriceCurrency()!=null) return true;
			if (getPriceUnitOfMeasure()!=null) return true;
			if (getOptionPremiumAmount()!=null) return true;
			if (getOptionPremiumCurrency()!=null) return true;
			if (getOptionPremiumPaymentDate()!=null) return true;
			if (getExchangeRate()!=null) return true;
			if (getExchangeRateBasis()!=null) return true;
			if (getCdSIndexAttachmentPoint()!=null) return true;
			if (getCdSIndexDetachmentPoint()!=null) return true;
			if (getCollateralPortfolioIndicator()!=null) return true;
			if (getFirstExerciseDate()!=null) return true;
			if (getFinalContractualSettlementDate()!=null) return true;
			if (getSettlementLocation()!=null) return true;
			if (getPriorUTI()!=null) return true;
			if (getDirection1()!=null) return true;
			if (getValuationAmount()!=null) return true;
			if (getValuationCurrency()!=null) return true;
			if (getValuationMethod()!=null) return true;
			if (getValuationTimestamp()!=null) return true;
			if (getCustomBasketCode()!=null) return true;
			if (getBasketConstituents()!=null && getBasketConstituents().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOtherPayment()!=null && getOtherPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLeg1()!=null && getLeg1().hasData()) return true;
			if (getLeg2()!=null && getLeg2().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CriticalDataElementV2.CriticalDataElementV2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CriticalDataElementV2.CriticalDataElementV2Builder o = (CriticalDataElementV2.CriticalDataElementV2Builder) other;
			
			merger.mergeRosetta(getPriceSchedule(), o.getPriceSchedule(), this::getOrCreatePriceSchedule);
			merger.mergeRosetta(getStrikePriceSchedule(), o.getStrikePriceSchedule(), this::getOrCreateStrikePriceSchedule);
			merger.mergeRosetta(getPrice(), o.getPrice(), this::setPrice);
			merger.mergeRosetta(getPackageTransactionPrice(), o.getPackageTransactionPrice(), this::setPackageTransactionPrice);
			merger.mergeRosetta(getPackageTransactionSpread(), o.getPackageTransactionSpread(), this::setPackageTransactionSpread);
			merger.mergeRosetta(getStrikePrice(), o.getStrikePrice(), this::setStrikePrice);
			merger.mergeRosetta(getBasketConstituents(), o.getBasketConstituents(), this::getOrCreateBasketConstituents);
			merger.mergeRosetta(getOtherPayment(), o.getOtherPayment(), this::getOrCreateOtherPayment);
			merger.mergeRosetta(getLeg1(), o.getLeg1(), this::setLeg1);
			merger.mergeRosetta(getLeg2(), o.getLeg2(), this::setLeg2);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeBasic(getEarlyTerminationDate(), o.getEarlyTerminationDate(), this::setEarlyTerminationDate);
			merger.mergeBasic(getReportingTimestamp(), o.getReportingTimestamp(), this::setReportingTimestamp);
			merger.mergeBasic(getExecutionTimestamp(), o.getExecutionTimestamp(), this::setExecutionTimestamp);
			merger.mergeBasic(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			merger.mergeBasic(getCounterparty1(), o.getCounterparty1(), this::setCounterparty1);
			merger.mergeBasic(getCounterparty2(), o.getCounterparty2(), this::setCounterparty2);
			merger.mergeBasic(getCounterparty2IdentifierType(), o.getCounterparty2IdentifierType(), this::setCounterparty2IdentifierType);
			merger.mergeBasic(getBeneficiary1(), o.getBeneficiary1(), this::setBeneficiary1);
			merger.mergeBasic(getBeneficiary1IdentifierTypeIndicator(), o.getBeneficiary1IdentifierTypeIndicator(), this::setBeneficiary1IdentifierTypeIndicator);
			merger.mergeBasic(getBuyerIdentifier(), o.getBuyerIdentifier(), this::setBuyerIdentifier);
			merger.mergeBasic(getSellerIdentifier(), o.getSellerIdentifier(), this::setSellerIdentifier);
			merger.mergeBasic(getCleared(), o.getCleared(), this::setCleared);
			merger.mergeBasic(getCentralCounterparty(), o.getCentralCounterparty(), this::setCentralCounterparty);
			merger.mergeBasic(getClearingMember(), o.getClearingMember(), this::setClearingMember);
			merger.mergeBasic(getConfirmed(), o.getConfirmed(), this::setConfirmed);
			merger.mergeBasic(getCallAmount(), o.getCallAmount(), this::setCallAmount);
			merger.mergeBasic(getPutAmount(), o.getPutAmount(), this::setPutAmount);
			merger.mergeBasic(getCallCurrency(), o.getCallCurrency(), this::setCallCurrency);
			merger.mergeBasic(getPutCurrency(), o.getPutCurrency(), this::setPutCurrency);
			merger.mergeBasic(getDelta(), o.getDelta(), this::setDelta);
			merger.mergeBasic(getPriceNotation(), o.getPriceNotation(), this::setPriceNotation);
			merger.mergeBasic(getPriceCurrency(), o.getPriceCurrency(), this::setPriceCurrency);
			merger.mergeBasic(getPackageTransactionPriceNotation(), o.getPackageTransactionPriceNotation(), this::setPackageTransactionPriceNotation);
			merger.mergeBasic(getPackageTransactionPriceCurrency(), o.getPackageTransactionPriceCurrency(), this::setPackageTransactionPriceCurrency);
			merger.mergeBasic(getPackageTransactionSpreadNotation(), o.getPackageTransactionSpreadNotation(), this::setPackageTransactionSpreadNotation);
			merger.mergeBasic(getPackageTransactionSpreadCurrency(), o.getPackageTransactionSpreadCurrency(), this::setPackageTransactionSpreadCurrency);
			merger.mergeBasic(getPackageIdentifier(), o.getPackageIdentifier(), this::setPackageIdentifier);
			merger.mergeBasic(getStrikePriceNotation(), o.getStrikePriceNotation(), this::setStrikePriceNotation);
			merger.mergeBasic(getStrikePriceCurrency(), o.getStrikePriceCurrency(), this::setStrikePriceCurrency);
			merger.mergeBasic(getPriceUnitOfMeasure(), o.getPriceUnitOfMeasure(), this::setPriceUnitOfMeasure);
			merger.mergeBasic(getOptionPremiumAmount(), o.getOptionPremiumAmount(), this::setOptionPremiumAmount);
			merger.mergeBasic(getOptionPremiumCurrency(), o.getOptionPremiumCurrency(), this::setOptionPremiumCurrency);
			merger.mergeBasic(getOptionPremiumPaymentDate(), o.getOptionPremiumPaymentDate(), this::setOptionPremiumPaymentDate);
			merger.mergeBasic(getExchangeRate(), o.getExchangeRate(), this::setExchangeRate);
			merger.mergeBasic(getExchangeRateBasis(), o.getExchangeRateBasis(), this::setExchangeRateBasis);
			merger.mergeBasic(getCdSIndexAttachmentPoint(), o.getCdSIndexAttachmentPoint(), this::setCdSIndexAttachmentPoint);
			merger.mergeBasic(getCdSIndexDetachmentPoint(), o.getCdSIndexDetachmentPoint(), this::setCdSIndexDetachmentPoint);
			merger.mergeBasic(getCollateralPortfolioIndicator(), o.getCollateralPortfolioIndicator(), this::setCollateralPortfolioIndicator);
			merger.mergeBasic(getFirstExerciseDate(), o.getFirstExerciseDate(), this::setFirstExerciseDate);
			merger.mergeBasic(getFinalContractualSettlementDate(), o.getFinalContractualSettlementDate(), this::setFinalContractualSettlementDate);
			merger.mergeBasic(getSettlementLocation(), o.getSettlementLocation(), this::setSettlementLocation);
			merger.mergeBasic(getPriorUTI(), o.getPriorUTI(), this::setPriorUTI);
			merger.mergeBasic(getDirection1(), o.getDirection1(), this::setDirection1);
			merger.mergeBasic(getValuationAmount(), o.getValuationAmount(), this::setValuationAmount);
			merger.mergeBasic(getValuationCurrency(), o.getValuationCurrency(), this::setValuationCurrency);
			merger.mergeBasic(getValuationMethod(), o.getValuationMethod(), this::setValuationMethod);
			merger.mergeBasic(getValuationTimestamp(), o.getValuationTimestamp(), this::setValuationTimestamp);
			merger.mergeBasic(getCustomBasketCode(), o.getCustomBasketCode(), this::setCustomBasketCode);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CriticalDataElementV2 _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(earlyTerminationDate, _that.getEarlyTerminationDate())) return false;
			if (!Objects.equals(reportingTimestamp, _that.getReportingTimestamp())) return false;
			if (!Objects.equals(executionTimestamp, _that.getExecutionTimestamp())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(counterparty1, _that.getCounterparty1())) return false;
			if (!Objects.equals(counterparty2, _that.getCounterparty2())) return false;
			if (!Objects.equals(counterparty2IdentifierType, _that.getCounterparty2IdentifierType())) return false;
			if (!Objects.equals(beneficiary1, _that.getBeneficiary1())) return false;
			if (!Objects.equals(beneficiary1IdentifierTypeIndicator, _that.getBeneficiary1IdentifierTypeIndicator())) return false;
			if (!Objects.equals(buyerIdentifier, _that.getBuyerIdentifier())) return false;
			if (!Objects.equals(sellerIdentifier, _that.getSellerIdentifier())) return false;
			if (!Objects.equals(cleared, _that.getCleared())) return false;
			if (!Objects.equals(centralCounterparty, _that.getCentralCounterparty())) return false;
			if (!Objects.equals(clearingMember, _that.getClearingMember())) return false;
			if (!Objects.equals(confirmed, _that.getConfirmed())) return false;
			if (!Objects.equals(callAmount, _that.getCallAmount())) return false;
			if (!Objects.equals(putAmount, _that.getPutAmount())) return false;
			if (!Objects.equals(callCurrency, _that.getCallCurrency())) return false;
			if (!Objects.equals(putCurrency, _that.getPutCurrency())) return false;
			if (!Objects.equals(delta, _that.getDelta())) return false;
			if (!ListEquals.listEquals(priceSchedule, _that.getPriceSchedule())) return false;
			if (!ListEquals.listEquals(strikePriceSchedule, _that.getStrikePriceSchedule())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(priceNotation, _that.getPriceNotation())) return false;
			if (!Objects.equals(priceCurrency, _that.getPriceCurrency())) return false;
			if (!Objects.equals(packageTransactionPrice, _that.getPackageTransactionPrice())) return false;
			if (!Objects.equals(packageTransactionPriceNotation, _that.getPackageTransactionPriceNotation())) return false;
			if (!Objects.equals(packageTransactionPriceCurrency, _that.getPackageTransactionPriceCurrency())) return false;
			if (!Objects.equals(packageTransactionSpread, _that.getPackageTransactionSpread())) return false;
			if (!Objects.equals(packageTransactionSpreadNotation, _that.getPackageTransactionSpreadNotation())) return false;
			if (!Objects.equals(packageTransactionSpreadCurrency, _that.getPackageTransactionSpreadCurrency())) return false;
			if (!Objects.equals(packageIdentifier, _that.getPackageIdentifier())) return false;
			if (!Objects.equals(strikePrice, _that.getStrikePrice())) return false;
			if (!Objects.equals(strikePriceNotation, _that.getStrikePriceNotation())) return false;
			if (!Objects.equals(strikePriceCurrency, _that.getStrikePriceCurrency())) return false;
			if (!Objects.equals(priceUnitOfMeasure, _that.getPriceUnitOfMeasure())) return false;
			if (!Objects.equals(optionPremiumAmount, _that.getOptionPremiumAmount())) return false;
			if (!Objects.equals(optionPremiumCurrency, _that.getOptionPremiumCurrency())) return false;
			if (!Objects.equals(optionPremiumPaymentDate, _that.getOptionPremiumPaymentDate())) return false;
			if (!Objects.equals(exchangeRate, _that.getExchangeRate())) return false;
			if (!Objects.equals(exchangeRateBasis, _that.getExchangeRateBasis())) return false;
			if (!Objects.equals(cdSIndexAttachmentPoint, _that.getCdSIndexAttachmentPoint())) return false;
			if (!Objects.equals(cdSIndexDetachmentPoint, _that.getCdSIndexDetachmentPoint())) return false;
			if (!Objects.equals(collateralPortfolioIndicator, _that.getCollateralPortfolioIndicator())) return false;
			if (!Objects.equals(firstExerciseDate, _that.getFirstExerciseDate())) return false;
			if (!Objects.equals(finalContractualSettlementDate, _that.getFinalContractualSettlementDate())) return false;
			if (!Objects.equals(settlementLocation, _that.getSettlementLocation())) return false;
			if (!Objects.equals(priorUTI, _that.getPriorUTI())) return false;
			if (!Objects.equals(direction1, _that.getDirection1())) return false;
			if (!Objects.equals(valuationAmount, _that.getValuationAmount())) return false;
			if (!Objects.equals(valuationCurrency, _that.getValuationCurrency())) return false;
			if (!Objects.equals(valuationMethod, _that.getValuationMethod())) return false;
			if (!Objects.equals(valuationTimestamp, _that.getValuationTimestamp())) return false;
			if (!Objects.equals(customBasketCode, _that.getCustomBasketCode())) return false;
			if (!ListEquals.listEquals(basketConstituents, _that.getBasketConstituents())) return false;
			if (!ListEquals.listEquals(otherPayment, _that.getOtherPayment())) return false;
			if (!Objects.equals(leg1, _that.getLeg1())) return false;
			if (!Objects.equals(leg2, _that.getLeg2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationDate != null ? earlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (reportingTimestamp != null ? reportingTimestamp.hashCode() : 0);
			_result = 31 * _result + (executionTimestamp != null ? executionTimestamp.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (counterparty1 != null ? counterparty1.hashCode() : 0);
			_result = 31 * _result + (counterparty2 != null ? counterparty2.hashCode() : 0);
			_result = 31 * _result + (counterparty2IdentifierType != null ? counterparty2IdentifierType.hashCode() : 0);
			_result = 31 * _result + (beneficiary1 != null ? beneficiary1.hashCode() : 0);
			_result = 31 * _result + (beneficiary1IdentifierTypeIndicator != null ? beneficiary1IdentifierTypeIndicator.hashCode() : 0);
			_result = 31 * _result + (buyerIdentifier != null ? buyerIdentifier.hashCode() : 0);
			_result = 31 * _result + (sellerIdentifier != null ? sellerIdentifier.hashCode() : 0);
			_result = 31 * _result + (cleared != null ? cleared.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (centralCounterparty != null ? centralCounterparty.hashCode() : 0);
			_result = 31 * _result + (clearingMember != null ? clearingMember.hashCode() : 0);
			_result = 31 * _result + (confirmed != null ? confirmed.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (callAmount != null ? callAmount.hashCode() : 0);
			_result = 31 * _result + (putAmount != null ? putAmount.hashCode() : 0);
			_result = 31 * _result + (callCurrency != null ? callCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (putCurrency != null ? putCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (delta != null ? delta.hashCode() : 0);
			_result = 31 * _result + (priceSchedule != null ? priceSchedule.hashCode() : 0);
			_result = 31 * _result + (strikePriceSchedule != null ? strikePriceSchedule.hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (priceNotation != null ? priceNotation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (priceCurrency != null ? priceCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (packageTransactionPrice != null ? packageTransactionPrice.hashCode() : 0);
			_result = 31 * _result + (packageTransactionPriceNotation != null ? packageTransactionPriceNotation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (packageTransactionPriceCurrency != null ? packageTransactionPriceCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (packageTransactionSpread != null ? packageTransactionSpread.hashCode() : 0);
			_result = 31 * _result + (packageTransactionSpreadNotation != null ? packageTransactionSpreadNotation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (packageTransactionSpreadCurrency != null ? packageTransactionSpreadCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (packageIdentifier != null ? packageIdentifier.hashCode() : 0);
			_result = 31 * _result + (strikePrice != null ? strikePrice.hashCode() : 0);
			_result = 31 * _result + (strikePriceNotation != null ? strikePriceNotation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strikePriceCurrency != null ? strikePriceCurrency.hashCode() : 0);
			_result = 31 * _result + (priceUnitOfMeasure != null ? priceUnitOfMeasure.hashCode() : 0);
			_result = 31 * _result + (optionPremiumAmount != null ? optionPremiumAmount.hashCode() : 0);
			_result = 31 * _result + (optionPremiumCurrency != null ? optionPremiumCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionPremiumPaymentDate != null ? optionPremiumPaymentDate.hashCode() : 0);
			_result = 31 * _result + (exchangeRate != null ? exchangeRate.hashCode() : 0);
			_result = 31 * _result + (exchangeRateBasis != null ? exchangeRateBasis.hashCode() : 0);
			_result = 31 * _result + (cdSIndexAttachmentPoint != null ? cdSIndexAttachmentPoint.hashCode() : 0);
			_result = 31 * _result + (cdSIndexDetachmentPoint != null ? cdSIndexDetachmentPoint.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioIndicator != null ? collateralPortfolioIndicator.hashCode() : 0);
			_result = 31 * _result + (firstExerciseDate != null ? firstExerciseDate.hashCode() : 0);
			_result = 31 * _result + (finalContractualSettlementDate != null ? finalContractualSettlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementLocation != null ? settlementLocation.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (priorUTI != null ? priorUTI.hashCode() : 0);
			_result = 31 * _result + (direction1 != null ? direction1.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationAmount != null ? valuationAmount.hashCode() : 0);
			_result = 31 * _result + (valuationCurrency != null ? valuationCurrency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationMethod != null ? valuationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (valuationTimestamp != null ? valuationTimestamp.hashCode() : 0);
			_result = 31 * _result + (customBasketCode != null ? customBasketCode.hashCode() : 0);
			_result = 31 * _result + (basketConstituents != null ? basketConstituents.hashCode() : 0);
			_result = 31 * _result + (otherPayment != null ? otherPayment.hashCode() : 0);
			_result = 31 * _result + (leg1 != null ? leg1.hashCode() : 0);
			_result = 31 * _result + (leg2 != null ? leg2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CriticalDataElementV2Builder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"earlyTerminationDate=" + this.earlyTerminationDate + ", " +
				"reportingTimestamp=" + this.reportingTimestamp + ", " +
				"executionTimestamp=" + this.executionTimestamp + ", " +
				"expirationDate=" + this.expirationDate + ", " +
				"counterparty1=" + this.counterparty1 + ", " +
				"counterparty2=" + this.counterparty2 + ", " +
				"counterparty2IdentifierType=" + this.counterparty2IdentifierType + ", " +
				"beneficiary1=" + this.beneficiary1 + ", " +
				"beneficiary1IdentifierTypeIndicator=" + this.beneficiary1IdentifierTypeIndicator + ", " +
				"buyerIdentifier=" + this.buyerIdentifier + ", " +
				"sellerIdentifier=" + this.sellerIdentifier + ", " +
				"cleared=" + this.cleared + ", " +
				"centralCounterparty=" + this.centralCounterparty + ", " +
				"clearingMember=" + this.clearingMember + ", " +
				"confirmed=" + this.confirmed + ", " +
				"callAmount=" + this.callAmount + ", " +
				"putAmount=" + this.putAmount + ", " +
				"callCurrency=" + this.callCurrency + ", " +
				"putCurrency=" + this.putCurrency + ", " +
				"delta=" + this.delta + ", " +
				"priceSchedule=" + this.priceSchedule + ", " +
				"strikePriceSchedule=" + this.strikePriceSchedule + ", " +
				"price=" + this.price + ", " +
				"priceNotation=" + this.priceNotation + ", " +
				"priceCurrency=" + this.priceCurrency + ", " +
				"packageTransactionPrice=" + this.packageTransactionPrice + ", " +
				"packageTransactionPriceNotation=" + this.packageTransactionPriceNotation + ", " +
				"packageTransactionPriceCurrency=" + this.packageTransactionPriceCurrency + ", " +
				"packageTransactionSpread=" + this.packageTransactionSpread + ", " +
				"packageTransactionSpreadNotation=" + this.packageTransactionSpreadNotation + ", " +
				"packageTransactionSpreadCurrency=" + this.packageTransactionSpreadCurrency + ", " +
				"packageIdentifier=" + this.packageIdentifier + ", " +
				"strikePrice=" + this.strikePrice + ", " +
				"strikePriceNotation=" + this.strikePriceNotation + ", " +
				"strikePriceCurrency=" + this.strikePriceCurrency + ", " +
				"priceUnitOfMeasure=" + this.priceUnitOfMeasure + ", " +
				"optionPremiumAmount=" + this.optionPremiumAmount + ", " +
				"optionPremiumCurrency=" + this.optionPremiumCurrency + ", " +
				"optionPremiumPaymentDate=" + this.optionPremiumPaymentDate + ", " +
				"exchangeRate=" + this.exchangeRate + ", " +
				"exchangeRateBasis=" + this.exchangeRateBasis + ", " +
				"cdSIndexAttachmentPoint=" + this.cdSIndexAttachmentPoint + ", " +
				"cdSIndexDetachmentPoint=" + this.cdSIndexDetachmentPoint + ", " +
				"collateralPortfolioIndicator=" + this.collateralPortfolioIndicator + ", " +
				"firstExerciseDate=" + this.firstExerciseDate + ", " +
				"finalContractualSettlementDate=" + this.finalContractualSettlementDate + ", " +
				"settlementLocation=" + this.settlementLocation + ", " +
				"priorUTI=" + this.priorUTI + ", " +
				"direction1=" + this.direction1 + ", " +
				"valuationAmount=" + this.valuationAmount + ", " +
				"valuationCurrency=" + this.valuationCurrency + ", " +
				"valuationMethod=" + this.valuationMethod + ", " +
				"valuationTimestamp=" + this.valuationTimestamp + ", " +
				"customBasketCode=" + this.customBasketCode + ", " +
				"basketConstituents=" + this.basketConstituents + ", " +
				"otherPayment=" + this.otherPayment + ", " +
				"leg1=" + this.leg1 + ", " +
				"leg2=" + this.leg2 +
			'}';
		}
	}
}
