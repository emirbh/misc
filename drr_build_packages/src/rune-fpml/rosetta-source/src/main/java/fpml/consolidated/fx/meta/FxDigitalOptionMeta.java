package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxDigitalOption;
import fpml.consolidated.fx.validation.FxDigitalOptionTypeFormatValidator;
import fpml.consolidated.fx.validation.FxDigitalOptionValidator;
import fpml.consolidated.fx.validation.datarule.FxDigitalOptionChoice;
import fpml.consolidated.fx.validation.exists.FxDigitalOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxDigitalOption.class)
public class FxDigitalOptionMeta implements RosettaMetaData<FxDigitalOption> {

	@Override
	public List<Validator<? super FxDigitalOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxDigitalOption>create(FxDigitalOptionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxDigitalOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxDigitalOption> validator(ValidatorFactory factory) {
		return factory.<FxDigitalOption>create(FxDigitalOptionValidator.class);
	}

	@Override
	public Validator<? super FxDigitalOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxDigitalOption>create(FxDigitalOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxDigitalOption> validator() {
		return new FxDigitalOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxDigitalOption> typeFormatValidator() {
		return new FxDigitalOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDigitalOption, Set<String>> onlyExistsValidator() {
		return new FxDigitalOptionOnlyExistsValidator();
	}
}
