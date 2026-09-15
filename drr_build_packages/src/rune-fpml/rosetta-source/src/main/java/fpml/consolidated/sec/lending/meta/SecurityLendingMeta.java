package fpml.consolidated.sec.lending.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.sec.lending.SecurityLending;
import fpml.consolidated.sec.lending.validation.SecurityLendingTypeFormatValidator;
import fpml.consolidated.sec.lending.validation.SecurityLendingValidator;
import fpml.consolidated.sec.lending.validation.datarule.SecurityLendingChoice0;
import fpml.consolidated.sec.lending.validation.datarule.SecurityLendingChoice1;
import fpml.consolidated.sec.lending.validation.exists.SecurityLendingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SecurityLending.class)
public class SecurityLendingMeta implements RosettaMetaData<SecurityLending> {

	@Override
	public List<Validator<? super SecurityLending>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SecurityLending>create(SecurityLendingChoice0.class),
			factory.<SecurityLending>create(SecurityLendingChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super SecurityLending, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecurityLending> validator(ValidatorFactory factory) {
		return factory.<SecurityLending>create(SecurityLendingValidator.class);
	}

	@Override
	public Validator<? super SecurityLending> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecurityLending>create(SecurityLendingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecurityLending> validator() {
		return new SecurityLendingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SecurityLending> typeFormatValidator() {
		return new SecurityLendingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecurityLending, Set<String>> onlyExistsValidator() {
		return new SecurityLendingOnlyExistsValidator();
	}
}
