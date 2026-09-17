package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.fx.validation.FxOptionTypeFormatValidator;
import fpml.consolidated.fx.validation.FxOptionValidator;
import fpml.consolidated.fx.validation.datarule.FxOptionChoice;
import fpml.consolidated.fx.validation.exists.FxOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxOption.class)
public class FxOptionMeta implements RosettaMetaData<FxOption> {

	@Override
	public List<Validator<? super FxOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxOption>create(FxOptionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxOption> validator(ValidatorFactory factory) {
		return factory.<FxOption>create(FxOptionValidator.class);
	}

	@Override
	public Validator<? super FxOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxOption>create(FxOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxOption> validator() {
		return new FxOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxOption> typeFormatValidator() {
		return new FxOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxOption, Set<String>> onlyExistsValidator() {
		return new FxOptionOnlyExistsValidator();
	}
}
