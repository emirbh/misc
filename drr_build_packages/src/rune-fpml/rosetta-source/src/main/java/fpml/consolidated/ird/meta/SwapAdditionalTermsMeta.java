package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.SwapAdditionalTerms;
import fpml.consolidated.ird.validation.SwapAdditionalTermsTypeFormatValidator;
import fpml.consolidated.ird.validation.SwapAdditionalTermsValidator;
import fpml.consolidated.ird.validation.exists.SwapAdditionalTermsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SwapAdditionalTerms.class)
public class SwapAdditionalTermsMeta implements RosettaMetaData<SwapAdditionalTerms> {

	@Override
	public List<Validator<? super SwapAdditionalTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SwapAdditionalTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SwapAdditionalTerms> validator(ValidatorFactory factory) {
		return factory.<SwapAdditionalTerms>create(SwapAdditionalTermsValidator.class);
	}

	@Override
	public Validator<? super SwapAdditionalTerms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SwapAdditionalTerms>create(SwapAdditionalTermsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SwapAdditionalTerms> validator() {
		return new SwapAdditionalTermsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SwapAdditionalTerms> typeFormatValidator() {
		return new SwapAdditionalTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SwapAdditionalTerms, Set<String>> onlyExistsValidator() {
		return new SwapAdditionalTermsOnlyExistsValidator();
	}
}
