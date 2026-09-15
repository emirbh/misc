package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxTriggerBase;
import fpml.consolidated.fx.validation.FxTriggerBaseTypeFormatValidator;
import fpml.consolidated.fx.validation.FxTriggerBaseValidator;
import fpml.consolidated.fx.validation.exists.FxTriggerBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTriggerBase.class)
public class FxTriggerBaseMeta implements RosettaMetaData<FxTriggerBase> {

	@Override
	public List<Validator<? super FxTriggerBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTriggerBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTriggerBase> validator(ValidatorFactory factory) {
		return factory.<FxTriggerBase>create(FxTriggerBaseValidator.class);
	}

	@Override
	public Validator<? super FxTriggerBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTriggerBase>create(FxTriggerBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTriggerBase> validator() {
		return new FxTriggerBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTriggerBase> typeFormatValidator() {
		return new FxTriggerBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTriggerBase, Set<String>> onlyExistsValidator() {
		return new FxTriggerBaseOnlyExistsValidator();
	}
}
