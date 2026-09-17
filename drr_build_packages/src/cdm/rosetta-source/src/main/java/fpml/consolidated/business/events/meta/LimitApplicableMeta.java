package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.LimitApplicable;
import fpml.consolidated.business.events.validation.LimitApplicableTypeFormatValidator;
import fpml.consolidated.business.events.validation.LimitApplicableValidator;
import fpml.consolidated.business.events.validation.datarule.LimitApplicableChoice;
import fpml.consolidated.business.events.validation.exists.LimitApplicableOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LimitApplicable.class)
public class LimitApplicableMeta implements RosettaMetaData<LimitApplicable> {

	@Override
	public List<Validator<? super LimitApplicable>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LimitApplicable>create(LimitApplicableChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LimitApplicable, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LimitApplicable> validator(ValidatorFactory factory) {
		return factory.<LimitApplicable>create(LimitApplicableValidator.class);
	}

	@Override
	public Validator<? super LimitApplicable> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LimitApplicable>create(LimitApplicableTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LimitApplicable> validator() {
		return new LimitApplicableValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LimitApplicable> typeFormatValidator() {
		return new LimitApplicableTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LimitApplicable, Set<String>> onlyExistsValidator() {
		return new LimitApplicableOnlyExistsValidator();
	}
}
