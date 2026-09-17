package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CollateralValueMethod;
import cdm.legaldocumentation.csa.validation.CollateralValueMethodTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CollateralValueMethodValidator;
import cdm.legaldocumentation.csa.validation.datarule.CollateralValueMethodOtherValues;
import cdm.legaldocumentation.csa.validation.exists.CollateralValueMethodOnlyExistsValidator;
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
@RosettaMeta(model=CollateralValueMethod.class)
public class CollateralValueMethodMeta implements RosettaMetaData<CollateralValueMethod> {

	@Override
	public List<Validator<? super CollateralValueMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CollateralValueMethod>create(CollateralValueMethodOtherValues.class)
		);
	}
	
	@Override
	public List<Function<? super CollateralValueMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralValueMethod> validator(ValidatorFactory factory) {
		return factory.<CollateralValueMethod>create(CollateralValueMethodValidator.class);
	}

	@Override
	public Validator<? super CollateralValueMethod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralValueMethod>create(CollateralValueMethodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralValueMethod> validator() {
		return new CollateralValueMethodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralValueMethod> typeFormatValidator() {
		return new CollateralValueMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralValueMethod, Set<String>> onlyExistsValidator() {
		return new CollateralValueMethodOnlyExistsValidator();
	}
}
