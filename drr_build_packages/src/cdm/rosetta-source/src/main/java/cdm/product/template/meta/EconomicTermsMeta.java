package cdm.product.template.meta;

import cdm.product.qualification.functions.Qualify_BuySellBack;
import cdm.product.qualification.functions.Qualify_Commodity_Forward;
import cdm.product.qualification.functions.Qualify_Commodity_Option;
import cdm.product.qualification.functions.Qualify_Commodity_Option_NonStandard;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Basket;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Index;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_IndexTranche;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Loan;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_SingleName;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwaption;
import cdm.product.qualification.functions.Qualify_Credit_Option_NonStandard;
import cdm.product.qualification.functions.Qualify_EquityForward_PriceReturnBasicPerformance_Basket;
import cdm.product.qualification.functions.Qualify_EquityForward_PriceReturnBasicPerformance_SingleIndex;
import cdm.product.qualification.functions.Qualify_EquityForward_PriceReturnBasicPerformance_SingleName;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnCorrelation_Basket;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnDividend_Basket;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnDividend_Index;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnDividend_SingleName;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVariance_Basket;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVariance_Index;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVariance_SingleName;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVolatility_Basket;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVolatility_Index;
import cdm.product.qualification.functions.Qualify_EquityOption_ParameterReturnVolatility_SingleName;
import cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_Basket;
import cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_Index;
import cdm.product.qualification.functions.Qualify_EquityOption_PriceReturnBasicPerformance_SingleName;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnCorrelation_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDispersion;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnDividend_SingleName;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVariance_SingleName;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_ParameterReturnVolatility_SingleName;
import cdm.product.qualification.functions.Qualify_EquitySwap_PriceReturnBasicPerformance_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_PriceReturnBasicPerformance_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_PriceReturnBasicPerformance_SingleName;
import cdm.product.qualification.functions.Qualify_EquitySwap_TotalReturnBasicPerformance_Basket;
import cdm.product.qualification.functions.Qualify_EquitySwap_TotalReturnBasicPerformance_Index;
import cdm.product.qualification.functions.Qualify_EquitySwap_TotalReturnBasicPerformance_SingleName;
import cdm.product.qualification.functions.Qualify_Equity_OtherForward;
import cdm.product.qualification.functions.Qualify_Equity_OtherOption;
import cdm.product.qualification.functions.Qualify_Equity_Swap_NonStandard;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDF;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDS;
import cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnCorrelation;
import cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnVariance;
import cdm.product.qualification.functions.Qualify_ForeignExchange_ParameterReturnVolatility;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Spot_Forward;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Swap;
import cdm.product.qualification.functions.Qualify_ForeignExchange_VanillaOption;
import cdm.product.qualification.functions.Qualify_InterestRate_CapFloor;
import cdm.product.qualification.functions.Qualify_InterestRate_CrossCurrency_Basis;
import cdm.product.qualification.functions.Qualify_InterestRate_CrossCurrency_FixedFixed;
import cdm.product.qualification.functions.Qualify_InterestRate_CrossCurrency_FixedFloat;
import cdm.product.qualification.functions.Qualify_InterestRate_Forward_Debt;
import cdm.product.qualification.functions.Qualify_InterestRate_Fra;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_Basis;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_Basis_OIS;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_FixedFixed;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_FixedFloat;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_FixedFloat_OIS;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_Basis_YearOn_Year;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_Basis_ZeroCoupon;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon;
import cdm.product.qualification.functions.Qualify_InterestRate_Option_DebtOption;
import cdm.product.qualification.functions.Qualify_InterestRate_Option_Swaption;
import cdm.product.qualification.functions.Qualify_RepurchaseAgreement;
import cdm.product.qualification.functions.Qualify_SecurityLending;
import cdm.product.qualification.functions.Qualify_TotalReturnSwap_Index;
import cdm.product.template.EconomicTerms;
import cdm.product.template.validation.EconomicTermsTypeFormatValidator;
import cdm.product.template.validation.EconomicTermsValidator;
import cdm.product.template.validation.datarule.EconomicTermsAssetPayoutDividendTermsValidation;
import cdm.product.template.validation.datarule.EconomicTermsDayCountFraction;
import cdm.product.template.validation.datarule.EconomicTermsFpML_cd_26_28;
import cdm.product.template.validation.datarule.EconomicTermsFpML_cd_27;
import cdm.product.template.validation.datarule.EconomicTermsFpML_cd_30;
import cdm.product.template.validation.datarule.EconomicTermsIndependentCalculationAgent;
import cdm.product.template.validation.datarule.EconomicTermsLastRegularPaymentDate;
import cdm.product.template.validation.datarule.EconomicTermsMarketPrice;
import cdm.product.template.validation.datarule.EconomicTermsNotionalResetInterestRatePayoutExists;
import cdm.product.template.validation.datarule.EconomicTermsNotionalResetOnPerformancePayout;
import cdm.product.template.validation.datarule.EconomicTermsPayRelativeTo;
import cdm.product.template.validation.datarule.EconomicTermsPaymentDates;
import cdm.product.template.validation.datarule.EconomicTermsPaymentDatesAdjustments;
import cdm.product.template.validation.datarule.EconomicTermsPaymentFrequency;
import cdm.product.template.validation.datarule.EconomicTermsQuantity;
import cdm.product.template.validation.datarule.EconomicTermsReturnType_Total_Requires_Dividends;
import cdm.product.template.validation.exists.EconomicTermsOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=EconomicTerms.class)
public class EconomicTermsMeta implements RosettaMetaData<EconomicTerms> {

	@Override
	public List<Validator<? super EconomicTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EconomicTerms>create(EconomicTermsReturnType_Total_Requires_Dividends.class),
			factory.<EconomicTerms>create(EconomicTermsLastRegularPaymentDate.class),
			factory.<EconomicTerms>create(EconomicTermsPayRelativeTo.class),
			factory.<EconomicTerms>create(EconomicTermsPaymentDatesAdjustments.class),
			factory.<EconomicTerms>create(EconomicTermsPaymentFrequency.class),
			factory.<EconomicTerms>create(EconomicTermsQuantity.class),
			factory.<EconomicTerms>create(EconomicTermsDayCountFraction.class),
			factory.<EconomicTerms>create(EconomicTermsPaymentDates.class),
			factory.<EconomicTerms>create(EconomicTermsMarketPrice.class),
			factory.<EconomicTerms>create(EconomicTermsNotionalResetOnPerformancePayout.class),
			factory.<EconomicTerms>create(EconomicTermsNotionalResetInterestRatePayoutExists.class),
			factory.<EconomicTerms>create(EconomicTermsFpML_cd_26_28.class),
			factory.<EconomicTerms>create(EconomicTermsFpML_cd_27.class),
			factory.<EconomicTerms>create(EconomicTermsFpML_cd_30.class),
			factory.<EconomicTerms>create(EconomicTermsIndependentCalculationAgent.class),
			factory.<EconomicTerms>create(EconomicTermsAssetPayoutDividendTermsValidation.class)
		);
	}
	
	@Override
	public List<Function<? super EconomicTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Arrays.asList(
			factory.<EconomicTerms>create(Qualify_CreditDefaultSwap_SingleName.class),
			factory.<EconomicTerms>create(Qualify_CreditDefaultSwap_Index.class),
			factory.<EconomicTerms>create(Qualify_CreditDefaultSwap_IndexTranche.class),
			factory.<EconomicTerms>create(Qualify_CreditDefaultSwap_Loan.class),
			factory.<EconomicTerms>create(Qualify_CreditDefaultSwap_Basket.class),
			factory.<EconomicTerms>create(Qualify_CreditDefaultSwaption.class),
			factory.<EconomicTerms>create(Qualify_TotalReturnSwap_Index.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_PriceReturnBasicPerformance_SingleName.class),
			factory.<EconomicTerms>create(Qualify_EquityForward_PriceReturnBasicPerformance_SingleName.class),
			factory.<EconomicTerms>create(Qualify_EquityForward_PriceReturnBasicPerformance_SingleIndex.class),
			factory.<EconomicTerms>create(Qualify_EquityForward_PriceReturnBasicPerformance_Basket.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_TotalReturnBasicPerformance_SingleName.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_PriceReturnBasicPerformance_Index.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_TotalReturnBasicPerformance_Index.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_PriceReturnBasicPerformance_Basket.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_TotalReturnBasicPerformance_Basket.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_ParameterReturnVariance_SingleName.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_ParameterReturnVariance_Index.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_ParameterReturnVariance_Basket.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_ParameterReturnDispersion.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_ParameterReturnVolatility_SingleName.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_ParameterReturnVolatility_Index.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_ParameterReturnVolatility_Basket.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_ParameterReturnCorrelation_Basket.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_ParameterReturnDividend_SingleName.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_ParameterReturnDividend_Index.class),
			factory.<EconomicTerms>create(Qualify_EquitySwap_ParameterReturnDividend_Basket.class),
			factory.<EconomicTerms>create(Qualify_Equity_OtherForward.class),
			factory.<EconomicTerms>create(Qualify_EquityOption_PriceReturnBasicPerformance_SingleName.class),
			factory.<EconomicTerms>create(Qualify_EquityOption_PriceReturnBasicPerformance_Index.class),
			factory.<EconomicTerms>create(Qualify_EquityOption_PriceReturnBasicPerformance_Basket.class),
			factory.<EconomicTerms>create(Qualify_EquityOption_ParameterReturnVariance_SingleName.class),
			factory.<EconomicTerms>create(Qualify_EquityOption_ParameterReturnVariance_Index.class),
			factory.<EconomicTerms>create(Qualify_EquityOption_ParameterReturnVariance_Basket.class),
			factory.<EconomicTerms>create(Qualify_EquityOption_ParameterReturnVolatility_SingleName.class),
			factory.<EconomicTerms>create(Qualify_EquityOption_ParameterReturnVolatility_Index.class),
			factory.<EconomicTerms>create(Qualify_EquityOption_ParameterReturnVolatility_Basket.class),
			factory.<EconomicTerms>create(Qualify_EquityOption_ParameterReturnCorrelation_Basket.class),
			factory.<EconomicTerms>create(Qualify_EquityOption_ParameterReturnDividend_SingleName.class),
			factory.<EconomicTerms>create(Qualify_EquityOption_ParameterReturnDividend_Index.class),
			factory.<EconomicTerms>create(Qualify_EquityOption_ParameterReturnDividend_Basket.class),
			factory.<EconomicTerms>create(Qualify_Equity_OtherOption.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_IRSwap_FixedFloat.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_IRSwap_FixedFixed.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_IRSwap_Basis.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_IRSwap_FixedFloat_OIS.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_IRSwap_Basis_OIS.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_CrossCurrency_FixedFloat.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_CrossCurrency_Basis.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_CrossCurrency_FixedFixed.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_InflationSwap_Basis_YearOn_Year.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_InflationSwap_Basis_ZeroCoupon.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_Fra.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_CapFloor.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_Option_Swaption.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_Option_DebtOption.class),
			factory.<EconomicTerms>create(Qualify_InterestRate_Forward_Debt.class),
			factory.<EconomicTerms>create(Qualify_ForeignExchange_Spot_Forward.class),
			factory.<EconomicTerms>create(Qualify_ForeignExchange_Swap.class),
			factory.<EconomicTerms>create(Qualify_ForeignExchange_NDF.class),
			factory.<EconomicTerms>create(Qualify_ForeignExchange_NDS.class),
			factory.<EconomicTerms>create(Qualify_ForeignExchange_ParameterReturnVariance.class),
			factory.<EconomicTerms>create(Qualify_ForeignExchange_ParameterReturnVolatility.class),
			factory.<EconomicTerms>create(Qualify_ForeignExchange_ParameterReturnCorrelation.class),
			factory.<EconomicTerms>create(Qualify_ForeignExchange_VanillaOption.class),
			factory.<EconomicTerms>create(Qualify_RepurchaseAgreement.class),
			factory.<EconomicTerms>create(Qualify_BuySellBack.class),
			factory.<EconomicTerms>create(Qualify_SecurityLending.class),
			factory.<EconomicTerms>create(Qualify_Commodity_Swap_FixedFloat.class),
			factory.<EconomicTerms>create(Qualify_Commodity_Swap_Basis.class),
			factory.<EconomicTerms>create(Qualify_Commodity_Option.class),
			factory.<EconomicTerms>create(Qualify_Commodity_Swaption.class),
			factory.<EconomicTerms>create(Qualify_Commodity_Forward.class),
			factory.<EconomicTerms>create(Qualify_Equity_Swap_NonStandard.class),
			factory.<EconomicTerms>create(Qualify_Credit_Option_NonStandard.class),
			factory.<EconomicTerms>create(Qualify_Commodity_Option_NonStandard.class)
		);
	}
	
	@Override
	public Validator<? super EconomicTerms> validator(ValidatorFactory factory) {
		return factory.<EconomicTerms>create(EconomicTermsValidator.class);
	}

	@Override
	public Validator<? super EconomicTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EconomicTerms>create(EconomicTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EconomicTerms> validator() {
		return new EconomicTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EconomicTerms> typeFormatValidator() {
		return new EconomicTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EconomicTerms, Set<String>> onlyExistsValidator() {
		return new EconomicTermsOnlyExistsValidator();
	}
}
