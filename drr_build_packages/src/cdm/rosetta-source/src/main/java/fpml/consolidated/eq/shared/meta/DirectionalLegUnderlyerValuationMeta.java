package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.DirectionalLegUnderlyer;
import fpml.consolidated.eq.shared.DirectionalLegUnderlyerValuation;
import fpml.consolidated.eq.shared.validation.DirectionalLegUnderlyerValuationTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.DirectionalLegUnderlyerValuationValidator;
import fpml.consolidated.eq.shared.validation.datarule.DirectionalLegUnderlyerChoice;
import fpml.consolidated.eq.shared.validation.exists.DirectionalLegUnderlyerValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DirectionalLegUnderlyerValuation.class)
public class DirectionalLegUnderlyerValuationMeta implements RosettaMetaData<DirectionalLegUnderlyerValuation> {

	@Override
	public List<Validator<? super DirectionalLegUnderlyerValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DirectionalLegUnderlyer>create(DirectionalLegUnderlyerChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DirectionalLegUnderlyerValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DirectionalLegUnderlyerValuation> validator(ValidatorFactory factory) {
		return factory.<DirectionalLegUnderlyerValuation>create(DirectionalLegUnderlyerValuationValidator.class);
	}

	@Override
	public Validator<? super DirectionalLegUnderlyerValuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DirectionalLegUnderlyerValuation>create(DirectionalLegUnderlyerValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DirectionalLegUnderlyerValuation> validator() {
		return new DirectionalLegUnderlyerValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DirectionalLegUnderlyerValuation> typeFormatValidator() {
		return new DirectionalLegUnderlyerValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DirectionalLegUnderlyerValuation, Set<String>> onlyExistsValidator() {
		return new DirectionalLegUnderlyerValuationOnlyExistsValidator();
	}
}
