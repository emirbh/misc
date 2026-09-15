package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Future;
import fpml.consolidated.asset.validation.FutureTypeFormatValidator;
import fpml.consolidated.asset.validation.FutureValidator;
import fpml.consolidated.asset.validation.datarule.FutureChoice;
import fpml.consolidated.asset.validation.exists.FutureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Future.class)
public class FutureMeta implements RosettaMetaData<Future> {

	@Override
	public List<Validator<? super Future>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Future>create(FutureChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Future, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Future> validator(ValidatorFactory factory) {
		return factory.<Future>create(FutureValidator.class);
	}

	@Override
	public Validator<? super Future> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Future>create(FutureTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Future> validator() {
		return new FutureValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Future> typeFormatValidator() {
		return new FutureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Future, Set<String>> onlyExistsValidator() {
		return new FutureOnlyExistsValidator();
	}
}
