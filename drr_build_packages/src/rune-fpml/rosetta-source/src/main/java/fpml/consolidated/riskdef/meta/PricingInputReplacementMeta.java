package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.PricingInputReplacement;
import fpml.consolidated.riskdef.validation.PricingInputReplacementTypeFormatValidator;
import fpml.consolidated.riskdef.validation.PricingInputReplacementValidator;
import fpml.consolidated.riskdef.validation.exists.PricingInputReplacementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PricingInputReplacement.class)
public class PricingInputReplacementMeta implements RosettaMetaData<PricingInputReplacement> {

	@Override
	public List<Validator<? super PricingInputReplacement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingInputReplacement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricingInputReplacement> validator(ValidatorFactory factory) {
		return factory.<PricingInputReplacement>create(PricingInputReplacementValidator.class);
	}

	@Override
	public Validator<? super PricingInputReplacement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricingInputReplacement>create(PricingInputReplacementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricingInputReplacement> validator() {
		return new PricingInputReplacementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricingInputReplacement> typeFormatValidator() {
		return new PricingInputReplacementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingInputReplacement, Set<String>> onlyExistsValidator() {
		return new PricingInputReplacementOnlyExistsValidator();
	}
}
