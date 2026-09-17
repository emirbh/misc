package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.AppropriatedCollateralValuation;
import cdm.legaldocumentation.csa.validation.AppropriatedCollateralValuationTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.AppropriatedCollateralValuationValidator;
import cdm.legaldocumentation.csa.validation.datarule.AppropriatedCollateralValuationNotSpecified;
import cdm.legaldocumentation.csa.validation.datarule.AppropriatedCollateralValuationSpecified;
import cdm.legaldocumentation.csa.validation.exists.AppropriatedCollateralValuationOnlyExistsValidator;
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
@RosettaMeta(model=AppropriatedCollateralValuation.class)
public class AppropriatedCollateralValuationMeta implements RosettaMetaData<AppropriatedCollateralValuation> {

	@Override
	public List<Validator<? super AppropriatedCollateralValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AppropriatedCollateralValuation>create(AppropriatedCollateralValuationSpecified.class),
			factory.<AppropriatedCollateralValuation>create(AppropriatedCollateralValuationNotSpecified.class)
		);
	}
	
	@Override
	public List<Function<? super AppropriatedCollateralValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AppropriatedCollateralValuation> validator(ValidatorFactory factory) {
		return factory.<AppropriatedCollateralValuation>create(AppropriatedCollateralValuationValidator.class);
	}

	@Override
	public Validator<? super AppropriatedCollateralValuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AppropriatedCollateralValuation>create(AppropriatedCollateralValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AppropriatedCollateralValuation> validator() {
		return new AppropriatedCollateralValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AppropriatedCollateralValuation> typeFormatValidator() {
		return new AppropriatedCollateralValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AppropriatedCollateralValuation, Set<String>> onlyExistsValidator() {
		return new AppropriatedCollateralValuationOnlyExistsValidator();
	}
}
