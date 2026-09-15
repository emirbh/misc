package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradingEconomicBenefit;
import fpml.consolidated.loan.validation.LoanTradingEconomicBenefitTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradingEconomicBenefitValidator;
import fpml.consolidated.loan.validation.datarule.LoanTradingEconomicBenefitChoice;
import fpml.consolidated.loan.validation.exists.LoanTradingEconomicBenefitOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradingEconomicBenefit.class)
public class LoanTradingEconomicBenefitMeta implements RosettaMetaData<LoanTradingEconomicBenefit> {

	@Override
	public List<Validator<? super LoanTradingEconomicBenefit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanTradingEconomicBenefit>create(LoanTradingEconomicBenefitChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanTradingEconomicBenefit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradingEconomicBenefit> validator(ValidatorFactory factory) {
		return factory.<LoanTradingEconomicBenefit>create(LoanTradingEconomicBenefitValidator.class);
	}

	@Override
	public Validator<? super LoanTradingEconomicBenefit> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradingEconomicBenefit>create(LoanTradingEconomicBenefitTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradingEconomicBenefit> validator() {
		return new LoanTradingEconomicBenefitValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradingEconomicBenefit> typeFormatValidator() {
		return new LoanTradingEconomicBenefitTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingEconomicBenefit, Set<String>> onlyExistsValidator() {
		return new LoanTradingEconomicBenefitOnlyExistsValidator();
	}
}
