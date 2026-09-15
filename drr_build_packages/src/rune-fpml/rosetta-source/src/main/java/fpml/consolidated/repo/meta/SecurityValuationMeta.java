package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.SecurityValuation;
import fpml.consolidated.repo.validation.SecurityValuationTypeFormatValidator;
import fpml.consolidated.repo.validation.SecurityValuationValidator;
import fpml.consolidated.repo.validation.datarule.SecurityValuationChoice0;
import fpml.consolidated.repo.validation.datarule.SecurityValuationChoice1;
import fpml.consolidated.repo.validation.exists.SecurityValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SecurityValuation.class)
public class SecurityValuationMeta implements RosettaMetaData<SecurityValuation> {

	@Override
	public List<Validator<? super SecurityValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SecurityValuation>create(SecurityValuationChoice0.class),
			factory.<SecurityValuation>create(SecurityValuationChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super SecurityValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecurityValuation> validator(ValidatorFactory factory) {
		return factory.<SecurityValuation>create(SecurityValuationValidator.class);
	}

	@Override
	public Validator<? super SecurityValuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecurityValuation>create(SecurityValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecurityValuation> validator() {
		return new SecurityValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SecurityValuation> typeFormatValidator() {
		return new SecurityValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecurityValuation, Set<String>> onlyExistsValidator() {
		return new SecurityValuationOnlyExistsValidator();
	}
}
