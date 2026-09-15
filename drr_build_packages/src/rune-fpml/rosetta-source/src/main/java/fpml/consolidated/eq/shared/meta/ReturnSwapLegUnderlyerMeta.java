package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.ReturnSwapLegUnderlyer;
import fpml.consolidated.eq.shared.validation.ReturnSwapLegUnderlyerTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.ReturnSwapLegUnderlyerValidator;
import fpml.consolidated.eq.shared.validation.datarule.ReturnSwapLegUnderlyerChoice;
import fpml.consolidated.eq.shared.validation.exists.ReturnSwapLegUnderlyerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReturnSwapLegUnderlyer.class)
public class ReturnSwapLegUnderlyerMeta implements RosettaMetaData<ReturnSwapLegUnderlyer> {

	@Override
	public List<Validator<? super ReturnSwapLegUnderlyer>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReturnSwapLegUnderlyer>create(ReturnSwapLegUnderlyerChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapLegUnderlyer, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnSwapLegUnderlyer> validator(ValidatorFactory factory) {
		return factory.<ReturnSwapLegUnderlyer>create(ReturnSwapLegUnderlyerValidator.class);
	}

	@Override
	public Validator<? super ReturnSwapLegUnderlyer> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReturnSwapLegUnderlyer>create(ReturnSwapLegUnderlyerTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapLegUnderlyer> validator() {
		return new ReturnSwapLegUnderlyerValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapLegUnderlyer> typeFormatValidator() {
		return new ReturnSwapLegUnderlyerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapLegUnderlyer, Set<String>> onlyExistsValidator() {
		return new ReturnSwapLegUnderlyerOnlyExistsValidator();
	}
}
