package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxTrigger;
import fpml.consolidated.fx.validation.FxTriggerTypeFormatValidator;
import fpml.consolidated.fx.validation.FxTriggerValidator;
import fpml.consolidated.fx.validation.exists.FxTriggerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTrigger.class)
public class FxTriggerMeta implements RosettaMetaData<FxTrigger> {

	@Override
	public List<Validator<? super FxTrigger>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTrigger, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTrigger> validator(ValidatorFactory factory) {
		return factory.<FxTrigger>create(FxTriggerValidator.class);
	}

	@Override
	public Validator<? super FxTrigger> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTrigger>create(FxTriggerTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTrigger> validator() {
		return new FxTriggerValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTrigger> typeFormatValidator() {
		return new FxTriggerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTrigger, Set<String>> onlyExistsValidator() {
		return new FxTriggerOnlyExistsValidator();
	}
}
