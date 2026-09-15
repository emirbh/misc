package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.CashSettlementTerms;
import fpml.consolidated.cd.validation.CashSettlementTermsTypeFormatValidator;
import fpml.consolidated.cd.validation.CashSettlementTermsValidator;
import fpml.consolidated.cd.validation.datarule.CashSettlementTermsChoice;
import fpml.consolidated.cd.validation.exists.CashSettlementTermsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CashSettlementTerms.class)
public class CashSettlementTermsMeta implements RosettaMetaData<CashSettlementTerms> {

	@Override
	public List<Validator<? super CashSettlementTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CashSettlementTerms>create(CashSettlementTermsChoice.class)
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
