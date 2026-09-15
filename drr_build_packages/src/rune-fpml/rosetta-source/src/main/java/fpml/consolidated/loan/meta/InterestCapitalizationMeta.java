package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.InterestCapitalization;
import fpml.consolidated.loan.validation.InterestCapitalizationTypeFormatValidator;
import fpml.consolidated.loan.validation.InterestCapitalizationValidator;
import fpml.consolidated.loan.validation.exists.InterestCapitalizationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InterestCapitalization.class)
public class InterestCapitalizationMeta implements RosettaMetaData<InterestCapitalization> {

	@Override
	public List<Validator<? super InterestCapitalization>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestCapitalization, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestCapitalization> validator(ValidatorFactory factory) {
		return factory.<InterestCapitalization>create(InterestCapitalizationValidator.class);
	}

	@Override
	public Validator<? super InterestCapitalization> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestCapitalization>create(InterestCapitalizationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestCapitalization> validator() {
		return new InterestCapitalizationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestCapitalization> typeFormatValidator() {
		return new InterestCapitalizationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestCapitalization, Set<String>> onlyExistsValidator() {
		return new InterestCapitalizationOnlyExistsValidator();
	}
}
