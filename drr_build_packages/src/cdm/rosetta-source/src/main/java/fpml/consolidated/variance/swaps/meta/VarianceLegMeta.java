package fpml.consolidated.variance.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.DirectionalLegUnderlyer;
import fpml.consolidated.eq.shared.validation.datarule.DirectionalLegUnderlyerChoice;
import fpml.consolidated.variance.swaps.VarianceLeg;
import fpml.consolidated.variance.swaps.validation.VarianceLegTypeFormatValidator;
import fpml.consolidated.variance.swaps.validation.VarianceLegValidator;
import fpml.consolidated.variance.swaps.validation.exists.VarianceLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VarianceLeg.class)
public class VarianceLegMeta implements RosettaMetaData<VarianceLeg> {

	@Override
	public List<Validator<? super VarianceLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DirectionalLegUnderlyer>create(DirectionalLegUnderlyerChoice.class)
		);
	}
	
	@Override
	public List<Function<? super VarianceLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VarianceLeg> validator(ValidatorFactory factory) {
		return factory.<VarianceLeg>create(VarianceLegValidator.class);
	}

	@Override
	public Validator<? super VarianceLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VarianceLeg>create(VarianceLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VarianceLeg> validator() {
		return new VarianceLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VarianceLeg> typeFormatValidator() {
		return new VarianceLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VarianceLeg, Set<String>> onlyExistsValidator() {
		return new VarianceLegOnlyExistsValidator();
	}
}
