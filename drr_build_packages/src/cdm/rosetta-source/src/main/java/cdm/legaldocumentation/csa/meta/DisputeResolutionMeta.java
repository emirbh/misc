package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.DisputeResolution;
import cdm.legaldocumentation.csa.validation.DisputeResolutionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.DisputeResolutionValidator;
import cdm.legaldocumentation.csa.validation.exists.DisputeResolutionOnlyExistsValidator;
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
@RosettaMeta(model=DisputeResolution.class)
public class DisputeResolutionMeta implements RosettaMetaData<DisputeResolution> {

	@Override
	public List<Validator<? super DisputeResolution>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DisputeResolution, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DisputeResolution> validator(ValidatorFactory factory) {
		return factory.<DisputeResolution>create(DisputeResolutionValidator.class);
	}

	@Override
	public Validator<? super DisputeResolution> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DisputeResolution>create(DisputeResolutionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DisputeResolution> validator() {
		return new DisputeResolutionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DisputeResolution> typeFormatValidator() {
		return new DisputeResolutionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DisputeResolution, Set<String>> onlyExistsValidator() {
		return new DisputeResolutionOnlyExistsValidator();
	}
}
