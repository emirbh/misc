package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.validation.OnBehalfOfTypeFormatValidator;
import fpml.consolidated.shared.validation.OnBehalfOfValidator;
import fpml.consolidated.shared.validation.exists.OnBehalfOfOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OnBehalfOf.class)
public class OnBehalfOfMeta implements RosettaMetaData<OnBehalfOf> {

	@Override
	public List<Validator<? super OnBehalfOf>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OnBehalfOf, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OnBehalfOf> validator(ValidatorFactory factory) {
		return factory.<OnBehalfOf>create(OnBehalfOfValidator.class);
	}

	@Override
	public Validator<? super OnBehalfOf> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OnBehalfOf>create(OnBehalfOfTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OnBehalfOf> validator() {
		return new OnBehalfOfValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OnBehalfOf> typeFormatValidator() {
		return new OnBehalfOfTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OnBehalfOf, Set<String>> onlyExistsValidator() {
		return new OnBehalfOfOnlyExistsValidator();
	}
}
