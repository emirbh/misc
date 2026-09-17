package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.BespokeCalculationTime;
import cdm.legaldocumentation.csa.validation.BespokeCalculationTimeTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.BespokeCalculationTimeValidator;
import cdm.legaldocumentation.csa.validation.datarule.BespokeCalculationTimeAsCalculationAgentIm;
import cdm.legaldocumentation.csa.validation.datarule.BespokeCalculationTimeBespokeCalculationTimeTerms;
import cdm.legaldocumentation.csa.validation.exists.BespokeCalculationTimeOnlyExistsValidator;
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
@RosettaMeta(model=BespokeCalculationTime.class)
public class BespokeCalculationTimeMeta implements RosettaMetaData<BespokeCalculationTime> {

	@Override
	public List<Validator<? super BespokeCalculationTime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<BespokeCalculationTime>create(BespokeCalculationTimeAsCalculationAgentIm.class),
			factory.<BespokeCalculationTime>create(BespokeCalculationTimeBespokeCalculationTimeTerms.class)
		);
	}
	
	@Override
	public List<Function<? super BespokeCalculationTime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BespokeCalculationTime> validator(ValidatorFactory factory) {
		return factory.<BespokeCalculationTime>create(BespokeCalculationTimeValidator.class);
	}

	@Override
	public Validator<? super BespokeCalculationTime> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BespokeCalculationTime>create(BespokeCalculationTimeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BespokeCalculationTime> validator() {
		return new BespokeCalculationTimeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BespokeCalculationTime> typeFormatValidator() {
		return new BespokeCalculationTimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BespokeCalculationTime, Set<String>> onlyExistsValidator() {
		return new BespokeCalculationTimeOnlyExistsValidator();
	}
}
