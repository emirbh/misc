package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.SensitivityMethodologies;
import cdm.legaldocumentation.csa.validation.SensitivityMethodologiesTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.SensitivityMethodologiesValidator;
import cdm.legaldocumentation.csa.validation.exists.SensitivityMethodologiesOnlyExistsValidator;
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
@RosettaMeta(model=SensitivityMethodologies.class)
public class SensitivityMethodologiesMeta implements RosettaMetaData<SensitivityMethodologies> {

	@Override
	public List<Validator<? super SensitivityMethodologies>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SensitivityMethodologies, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SensitivityMethodologies> validator(ValidatorFactory factory) {
		return factory.<SensitivityMethodologies>create(SensitivityMethodologiesValidator.class);
	}

	@Override
	public Validator<? super SensitivityMethodologies> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SensitivityMethodologies>create(SensitivityMethodologiesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SensitivityMethodologies> validator() {
		return new SensitivityMethodologiesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SensitivityMethodologies> typeFormatValidator() {
		return new SensitivityMethodologiesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SensitivityMethodologies, Set<String>> onlyExistsValidator() {
		return new SensitivityMethodologiesOnlyExistsValidator();
	}
}
