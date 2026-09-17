package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.validation.CashSettlementTermsTypeFormatValidator;
import cdm.product.common.settlement.validation.CashSettlementTermsValidator;
import cdm.product.common.settlement.validation.datarule.CashSettlementTermsCashCollateralMethod;
import cdm.product.common.settlement.validation.datarule.CashSettlementTermsCashSettlementTermsChoice;
import cdm.product.common.settlement.validation.datarule.CashSettlementTermsFirmQuotationMethod;
import cdm.product.common.settlement.validation.datarule.CashSettlementTermsMidMarketValuationMethod;
import cdm.product.common.settlement.validation.datarule.CashSettlementTermsRecoveryFactor;
import cdm.product.common.settlement.validation.datarule.CashSettlementTermsReplacementValueMethod;
import cdm.product.common.settlement.validation.exists.CashSettlementTermsOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=CashSettlementTerms.class)
public class CashSettlementTermsMeta implements RosettaMetaData<CashSettlementTerms> {

	@Override
	public List<Validator<? super CashSettlementTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CashSettlementTerms>create(CashSettlementTermsCashSettlementTermsChoice.class),
			factory.<CashSettlementTerms>create(CashSettlementTermsRecoveryFactor.class),
			factory.<CashSettlementTerms>create(CashSettlementTermsCashCollateralMethod.class),
			factory.<CashSettlementTerms>create(CashSettlementTermsMidMarketValuationMethod.class),
			factory.<CashSettlementTerms>create(CashSettlementTermsReplacementValueMethod.class),
			factory.<CashSettlementTerms>create(CashSettlementTermsFirmQuotationMethod.class)
		);
	}
	
	@Override
	public List<Function<? super CashSettlementTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CashSettlementTerms> validator(ValidatorFactory factory) {
		return factory.<CashSettlementTerms>create(CashSettlementTermsValidator.class);
	}

	@Override
	public Validator<? super CashSettlementTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CashSettlementTerms>create(CashSettlementTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CashSettlementTerms> validator() {
		return new CashSettlementTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CashSettlementTerms> typeFormatValidator() {
		return new CashSettlementTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashSettlementTerms, Set<String>> onlyExistsValidator() {
		return new CashSettlementTermsOnlyExistsValidator();
	}
}
