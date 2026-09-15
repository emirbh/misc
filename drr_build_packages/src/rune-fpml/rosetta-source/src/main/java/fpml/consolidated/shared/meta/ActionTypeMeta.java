package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ActionType;
import fpml.consolidated.shared.validation.ActionTypeTypeFormatValidator;
import fpml.consolidated.shared.validation.ActionTypeValidator;
import fpml.consolidated.shared.validation.exists.ActionTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ActionType.class)
public class ActionTypeMeta implements RosettaMetaData<ActionType> {

	@Override
	public List<Validator<? super ActionType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ActionType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ActionType> validator(ValidatorFactory factory) {
		return factory.<ActionType>create(ActionTypeValidator.class);
	}

	@Override
	public Validator<? super ActionType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ActionType>create(ActionTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ActionType> validator() {
		return new ActionTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ActionType> typeFormatValidator() {
		return new ActionTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ActionType, Set<String>> onlyExistsValidator() {
		return new ActionTypeOnlyExistsValidator();
	}
}
