package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LegacyInterestCapitalization;
import fpml.consolidated.loan.validation.LegacyInterestCapitalizationTypeFormatValidator;
import fpml.consolidated.loan.validation.LegacyInterestCapitalizationValidator;
import fpml.consolidated.loan.validation.exists.LegacyInterestCapitalizationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LegacyInterestCapitalization.class)
public class LegacyInterestCapitalizationMeta implements RosettaMetaData<LegacyInterestCapitalization> {

	@Override
	public List<Validator<? super LegacyInterestCapitalization>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegacyInterestCapitalization, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyInterestCapitalization> validator(ValidatorFactory factory) {
		return factory.<LegacyInterestCapitalization>create(LegacyInterestCapitalizationValidator.class);
	}

	@Override
	public Validator<? super LegacyInterestCapitalization> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyInterestCapitalization>create(LegacyInterestCapitalizationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyInterestCapitalization> validator() {
		return new LegacyInterestCapitalizationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyInterestCapitalization> typeFormatValidator() {
		return new LegacyInterestCapitalizationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyInterestCapitalization, Set<String>> onlyExistsValidator() {
		return new LegacyInterestCapitalizationOnlyExistsValidator();
	}
}
