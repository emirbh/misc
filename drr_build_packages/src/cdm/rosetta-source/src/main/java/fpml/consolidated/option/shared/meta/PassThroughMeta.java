package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.PassThrough;
import fpml.consolidated.option.shared.validation.PassThroughTypeFormatValidator;
import fpml.consolidated.option.shared.validation.PassThroughValidator;
import fpml.consolidated.option.shared.validation.exists.PassThroughOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PassThrough.class)
public class PassThroughMeta implements RosettaMetaData<PassThrough> {

	@Override
	public List<Validator<? super PassThrough>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PassThrough, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PassThrough> validator(ValidatorFactory factory) {
		return factory.<PassThrough>create(PassThroughValidator.class);
	}

	@Override
	public Validator<? super PassThrough> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PassThrough>create(PassThroughTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PassThrough> validator() {
		return new PassThroughValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PassThrough> typeFormatValidator() {
		return new PassThroughTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PassThrough, Set<String>> onlyExistsValidator() {
		return new PassThroughOnlyExistsValidator();
	}
}
