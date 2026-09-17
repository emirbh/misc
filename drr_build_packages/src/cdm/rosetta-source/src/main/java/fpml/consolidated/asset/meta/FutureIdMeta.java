package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.FutureId;
import fpml.consolidated.asset.validation.FutureIdTypeFormatValidator;
import fpml.consolidated.asset.validation.FutureIdValidator;
import fpml.consolidated.asset.validation.exists.FutureIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FutureId.class)
public class FutureIdMeta implements RosettaMetaData<FutureId> {

	@Override
	public List<Validator<? super FutureId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FutureId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FutureId> validator(ValidatorFactory factory) {
		return factory.<FutureId>create(FutureIdValidator.class);
	}

	@Override
	public Validator<? super FutureId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FutureId>create(FutureIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FutureId> validator() {
		return new FutureIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FutureId> typeFormatValidator() {
		return new FutureIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FutureId, Set<String>> onlyExistsValidator() {
		return new FutureIdOnlyExistsValidator();
	}
}
