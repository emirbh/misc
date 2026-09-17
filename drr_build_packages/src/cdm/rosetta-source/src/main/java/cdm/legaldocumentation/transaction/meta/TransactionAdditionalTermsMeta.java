package cdm.legaldocumentation.transaction.meta;

import cdm.legaldocumentation.transaction.TransactionAdditionalTerms;
import cdm.legaldocumentation.transaction.validation.TransactionAdditionalTermsTypeFormatValidator;
import cdm.legaldocumentation.transaction.validation.TransactionAdditionalTermsValidator;
import cdm.legaldocumentation.transaction.validation.exists.TransactionAdditionalTermsOnlyExistsValidator;
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
@RosettaMeta(model=TransactionAdditionalTerms.class)
public class TransactionAdditionalTermsMeta implements RosettaMetaData<TransactionAdditionalTerms> {

	@Override
	public List<Validator<? super TransactionAdditionalTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TransactionAdditionalTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TransactionAdditionalTerms> validator(ValidatorFactory factory) {
		return factory.<TransactionAdditionalTerms>create(TransactionAdditionalTermsValidator.class);
	}

	@Override
	public Validator<? super TransactionAdditionalTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TransactionAdditionalTerms>create(TransactionAdditionalTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TransactionAdditionalTerms> validator() {
		return new TransactionAdditionalTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TransactionAdditionalTerms> typeFormatValidator() {
		return new TransactionAdditionalTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransactionAdditionalTerms, Set<String>> onlyExistsValidator() {
		return new TransactionAdditionalTermsOnlyExistsValidator();
	}
}
