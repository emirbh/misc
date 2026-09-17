package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.AccessConditions;
import cdm.legaldocumentation.csa.validation.AccessConditionsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.AccessConditionsValidator;
import cdm.legaldocumentation.csa.validation.exists.AccessConditionsOnlyExistsValidator;
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
@RosettaMeta(model=AccessConditions.class)
public class AccessConditionsMeta implements RosettaMetaData<AccessConditions> {

	@Override
	public List<Validator<? super AccessConditions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccessConditions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AccessConditions> validator(ValidatorFactory factory) {
		return factory.<AccessConditions>create(AccessConditionsValidator.class);
	}

	@Override
	public Validator<? super AccessConditions> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AccessConditions>create(AccessConditionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AccessConditions> validator() {
		return new AccessConditionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AccessConditions> typeFormatValidator() {
		return new AccessConditionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccessConditions, Set<String>> onlyExistsValidator() {
		return new AccessConditionsOnlyExistsValidator();
	}
}
