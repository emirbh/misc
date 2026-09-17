package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.SingleUnderlyer;
import fpml.consolidated.asset.validation.SingleUnderlyerTypeFormatValidator;
import fpml.consolidated.asset.validation.SingleUnderlyerValidator;
import fpml.consolidated.asset.validation.exists.SingleUnderlyerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SingleUnderlyer.class)
public class SingleUnderlyerMeta implements RosettaMetaData<SingleUnderlyer> {

	@Override
	public List<Validator<? super SingleUnderlyer>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SingleUnderlyer, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SingleUnderlyer> validator(ValidatorFactory factory) {
		return factory.<SingleUnderlyer>create(SingleUnderlyerValidator.class);
	}

	@Override
	public Validator<? super SingleUnderlyer> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SingleUnderlyer>create(SingleUnderlyerTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SingleUnderlyer> validator() {
		return new SingleUnderlyerValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SingleUnderlyer> typeFormatValidator() {
		return new SingleUnderlyerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SingleUnderlyer, Set<String>> onlyExistsValidator() {
		return new SingleUnderlyerOnlyExistsValidator();
	}
}
