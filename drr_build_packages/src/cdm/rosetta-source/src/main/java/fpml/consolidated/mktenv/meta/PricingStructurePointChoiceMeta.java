package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.PricingStructurePointChoice;
import fpml.consolidated.mktenv.validation.PricingStructurePointChoiceTypeFormatValidator;
import fpml.consolidated.mktenv.validation.PricingStructurePointChoiceValidator;
import fpml.consolidated.mktenv.validation.datarule.PricingStructurePointChoiceChoice;
import fpml.consolidated.mktenv.validation.exists.PricingStructurePointChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PricingStructurePointChoice.class)
public class PricingStructurePointChoiceMeta implements RosettaMetaData<PricingStructurePointChoice> {

	@Override
	public List<Validator<? super PricingStructurePointChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PricingStructurePointChoice>create(PricingStructurePointChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PricingStructurePointChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricingStructurePointChoice> validator(ValidatorFactory factory) {
		return factory.<PricingStructurePointChoice>create(PricingStructurePointChoiceValidator.class);
	}

	@Override
	public Validator<? super PricingStructurePointChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricingStructurePointChoice>create(PricingStructurePointChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricingStructurePointChoice> validator() {
		return new PricingStructurePointChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricingStructurePointChoice> typeFormatValidator() {
		return new PricingStructurePointChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingStructurePointChoice, Set<String>> onlyExistsValidator() {
		return new PricingStructurePointChoiceOnlyExistsValidator();
	}
}
