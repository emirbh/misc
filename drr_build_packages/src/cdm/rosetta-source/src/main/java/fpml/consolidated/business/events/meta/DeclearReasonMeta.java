package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.DeclearReason;
import fpml.consolidated.business.events.validation.DeclearReasonTypeFormatValidator;
import fpml.consolidated.business.events.validation.DeclearReasonValidator;
import fpml.consolidated.business.events.validation.exists.DeclearReasonOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DeclearReason.class)
public class DeclearReasonMeta implements RosettaMetaData<DeclearReason> {

	@Override
	public List<Validator<? super DeclearReason>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DeclearReason, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DeclearReason> validator(ValidatorFactory factory) {
		return factory.<DeclearReason>create(DeclearReasonValidator.class);
	}

	@Override
	public Validator<? super DeclearReason> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DeclearReason>create(DeclearReasonTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DeclearReason> validator() {
		return new DeclearReasonValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DeclearReason> typeFormatValidator() {
		return new DeclearReasonTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeclearReason, Set<String>> onlyExistsValidator() {
		return new DeclearReasonOnlyExistsValidator();
	}
}
