package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.ValuationScenarioReference;
import fpml.consolidated.riskdef.validation.ValuationScenarioReferenceTypeFormatValidator;
import fpml.consolidated.riskdef.validation.ValuationScenarioReferenceValidator;
import fpml.consolidated.riskdef.validation.exists.ValuationScenarioReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ValuationScenarioReference.class)
public class ValuationScenarioReferenceMeta implements RosettaMetaData<ValuationScenarioReference> {

	@Override
	public List<Validator<? super ValuationScenarioReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationScenarioReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationScenarioReference> validator(ValidatorFactory factory) {
		return factory.<ValuationScenarioReference>create(ValuationScenarioReferenceValidator.class);
	}

	@Override
	public Validator<? super ValuationScenarioReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuationScenarioReference>create(ValuationScenarioReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuationScenarioReference> validator() {
		return new ValuationScenarioReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuationScenarioReference> typeFormatValidator() {
		return new ValuationScenarioReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationScenarioReference, Set<String>> onlyExistsValidator() {
		return new ValuationScenarioReferenceOnlyExistsValidator();
	}
}
