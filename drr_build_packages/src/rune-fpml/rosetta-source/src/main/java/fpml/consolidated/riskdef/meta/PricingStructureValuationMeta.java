package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.PricingStructureValuation;
import fpml.consolidated.riskdef.validation.PricingStructureValuationTypeFormatValidator;
import fpml.consolidated.riskdef.validation.PricingStructureValuationValidator;
import fpml.consolidated.riskdef.validation.exists.PricingStructureValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PricingStructureValuation.class)
public class PricingStructureValuationMeta implements RosettaMetaData<PricingStructureValuation> {

	@Override
	public List<Validator<? super PricingStructureValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingStructureValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricingStructureValuation> validator(ValidatorFactory factory) {
		return factory.<PricingStructureValuation>create(PricingStructureValuationValidator.class);
	}

	@Override
	public Validator<? super PricingStructureValuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricingStructureValuation>create(PricingStructureValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricingStructureValuation> validator() {
		return new PricingStructureValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricingStructureValuation> typeFormatValidator() {
		return new PricingStructureValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingStructureValuation, Set<String>> onlyExistsValidator() {
		return new PricingStructureValuationOnlyExistsValidator();
	}
}
