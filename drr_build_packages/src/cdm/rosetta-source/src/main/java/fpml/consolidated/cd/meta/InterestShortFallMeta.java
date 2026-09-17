package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.InterestShortFall;
import fpml.consolidated.cd.validation.InterestShortFallTypeFormatValidator;
import fpml.consolidated.cd.validation.InterestShortFallValidator;
import fpml.consolidated.cd.validation.exists.InterestShortFallOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InterestShortFall.class)
public class InterestShortFallMeta implements RosettaMetaData<InterestShortFall> {

	@Override
	public List<Validator<? super InterestShortFall>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestShortFall, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestShortFall> validator(ValidatorFactory factory) {
		return factory.<InterestShortFall>create(InterestShortFallValidator.class);
	}

	@Override
	public Validator<? super InterestShortFall> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestShortFall>create(InterestShortFallTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestShortFall> validator() {
		return new InterestShortFallValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestShortFall> typeFormatValidator() {
		return new InterestShortFallTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestShortFall, Set<String>> onlyExistsValidator() {
		return new InterestShortFallOnlyExistsValidator();
	}
}
