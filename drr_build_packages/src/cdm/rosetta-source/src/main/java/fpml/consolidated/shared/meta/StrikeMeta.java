package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Strike;
import fpml.consolidated.shared.validation.StrikeTypeFormatValidator;
import fpml.consolidated.shared.validation.StrikeValidator;
import fpml.consolidated.shared.validation.exists.StrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Strike.class)
public class StrikeMeta implements RosettaMetaData<Strike> {

	@Override
	public List<Validator<? super Strike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Strike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Strike> validator(ValidatorFactory factory) {
		return factory.<Strike>create(StrikeValidator.class);
	}

	@Override
	public Validator<? super Strike> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Strike>create(StrikeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Strike> validator() {
		return new StrikeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Strike> typeFormatValidator() {
		return new StrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Strike, Set<String>> onlyExistsValidator() {
		return new StrikeOnlyExistsValidator();
	}
}
