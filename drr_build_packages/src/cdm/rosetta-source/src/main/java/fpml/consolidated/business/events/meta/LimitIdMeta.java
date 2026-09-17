package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.LimitId;
import fpml.consolidated.business.events.validation.LimitIdTypeFormatValidator;
import fpml.consolidated.business.events.validation.LimitIdValidator;
import fpml.consolidated.business.events.validation.exists.LimitIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LimitId.class)
public class LimitIdMeta implements RosettaMetaData<LimitId> {

	@Override
	public List<Validator<? super LimitId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LimitId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LimitId> validator(ValidatorFactory factory) {
		return factory.<LimitId>create(LimitIdValidator.class);
	}

	@Override
	public Validator<? super LimitId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LimitId>create(LimitIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LimitId> validator() {
		return new LimitIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LimitId> typeFormatValidator() {
		return new LimitIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LimitId, Set<String>> onlyExistsValidator() {
		return new LimitIdOnlyExistsValidator();
	}
}
