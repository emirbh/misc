package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.EligibilityToHoldCollateral;
import cdm.legaldocumentation.csa.validation.EligibilityToHoldCollateralTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.EligibilityToHoldCollateralValidator;
import cdm.legaldocumentation.csa.validation.exists.EligibilityToHoldCollateralOnlyExistsValidator;
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
@RosettaMeta(model=EligibilityToHoldCollateral.class)
public class EligibilityToHoldCollateralMeta implements RosettaMetaData<EligibilityToHoldCollateral> {

	@Override
	public List<Validator<? super EligibilityToHoldCollateral>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EligibilityToHoldCollateral, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EligibilityToHoldCollateral> validator(ValidatorFactory factory) {
		return factory.<EligibilityToHoldCollateral>create(EligibilityToHoldCollateralValidator.class);
	}

	@Override
	public Validator<? super EligibilityToHoldCollateral> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EligibilityToHoldCollateral>create(EligibilityToHoldCollateralTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EligibilityToHoldCollateral> validator() {
		return new EligibilityToHoldCollateralValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EligibilityToHoldCollateral> typeFormatValidator() {
		return new EligibilityToHoldCollateralTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EligibilityToHoldCollateral, Set<String>> onlyExistsValidator() {
		return new EligibilityToHoldCollateralOnlyExistsValidator();
	}
}
