package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.DirectionalLegUnderlyer;
import fpml.consolidated.eq.shared.validation.DirectionalLegUnderlyerTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.DirectionalLegUnderlyerValidator;
import fpml.consolidated.eq.shared.validation.datarule.DirectionalLegUnderlyerChoice;
import fpml.consolidated.eq.shared.validation.exists.DirectionalLegUnderlyerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DirectionalLegUnderlyer.class)
public class DirectionalLegUnderlyerMeta implements RosettaMetaData<DirectionalLegUnderlyer> {

	@Override
	public List<Validator<? super DirectionalLegUnderlyer>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DirectionalLegUnderlyer>create(DirectionalLegUnderlyerChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DirectionalLegUnderlyer, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DirectionalLegUnderlyer> validator(ValidatorFactory factory) {
		return factory.<DirectionalLegUnderlyer>create(DirectionalLegUnderlyerValidator.class);
	}

	@Override
	public Validator<? super DirectionalLegUnderlyer> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DirectionalLegUnderlyer>create(DirectionalLegUnderlyerTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DirectionalLegUnderlyer> validator() {
		return new DirectionalLegUnderlyerValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DirectionalLegUnderlyer> typeFormatValidator() {
		return new DirectionalLegUnderlyerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DirectionalLegUnderlyer, Set<String>> onlyExistsValidator() {
		return new DirectionalLegUnderlyerOnlyExistsValidator();
	}
}
