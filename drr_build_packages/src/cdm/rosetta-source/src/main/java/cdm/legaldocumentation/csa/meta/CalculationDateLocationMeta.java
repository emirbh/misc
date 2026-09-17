package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CalculationDateLocation;
import cdm.legaldocumentation.csa.validation.CalculationDateLocationTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CalculationDateLocationValidator;
import cdm.legaldocumentation.csa.validation.exists.CalculationDateLocationOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=CalculationDateLocation.class)
public class CalculationDateLocationMeta implements RosettaMetaData<CalculationDateLocation> {

	@Override
	public List<Validator<? super CalculationDateLocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationDateLocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationDateLocation> validator(ValidatorFactory factory) {
		return factory.<CalculationDateLocation>create(CalculationDateLocationValidator.class);
	}

	@Override
	public Validator<? super CalculationDateLocation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationDateLocation>create(CalculationDateLocationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationDateLocation> validator() {
		return new CalculationDateLocationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationDateLocation> typeFormatValidator() {
		return new CalculationDateLocationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationDateLocation, Set<String>> onlyExistsValidator() {
		return new CalculationDateLocationOnlyExistsValidator();
	}
}
