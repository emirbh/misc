package fpml.consolidated.correlation.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.correlation.swaps.CorrelationLeg;
import fpml.consolidated.correlation.swaps.validation.CorrelationLegTypeFormatValidator;
import fpml.consolidated.correlation.swaps.validation.CorrelationLegValidator;
import fpml.consolidated.correlation.swaps.validation.exists.CorrelationLegOnlyExistsValidator;
import fpml.consolidated.eq.shared.DirectionalLegUnderlyer;
import fpml.consolidated.eq.shared.validation.datarule.DirectionalLegUnderlyerChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CorrelationLeg.class)
public class CorrelationLegMeta implements RosettaMetaData<CorrelationLeg> {

	@Override
	public List<Validator<? super CorrelationLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DirectionalLegUnderlyer>create(DirectionalLegUnderlyerChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CorrelationLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CorrelationLeg> validator(ValidatorFactory factory) {
		return factory.<CorrelationLeg>create(CorrelationLegValidator.class);
	}

	@Override
	public Validator<? super CorrelationLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CorrelationLeg>create(CorrelationLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CorrelationLeg> validator() {
		return new CorrelationLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CorrelationLeg> typeFormatValidator() {
		return new CorrelationLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorrelationLeg, Set<String>> onlyExistsValidator() {
		return new CorrelationLegOnlyExistsValidator();
	}
}
