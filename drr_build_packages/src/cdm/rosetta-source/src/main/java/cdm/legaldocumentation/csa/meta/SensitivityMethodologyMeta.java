package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.SensitivityMethodology;
import cdm.legaldocumentation.csa.validation.SensitivityMethodologyTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.SensitivityMethodologyValidator;
import cdm.legaldocumentation.csa.validation.datarule.SensitivityMethodologyOneOf0;
import cdm.legaldocumentation.csa.validation.exists.SensitivityMethodologyOnlyExistsValidator;
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
@RosettaMeta(model=SensitivityMethodology.class)
public class SensitivityMethodologyMeta implements RosettaMetaData<SensitivityMethodology> {

	@Override
	public List<Validator<? super SensitivityMethodology>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SensitivityMethodology>create(SensitivityMethodologyOneOf0.class)
		);
	}
	
	@Override
	public List<Function<? super SensitivityMethodology, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SensitivityMethodology> validator(ValidatorFactory factory) {
		return factory.<SensitivityMethodology>create(SensitivityMethodologyValidator.class);
	}

	@Override
	public Validator<? super SensitivityMethodology> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SensitivityMethodology>create(SensitivityMethodologyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SensitivityMethodology> validator() {
		return new SensitivityMethodologyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SensitivityMethodology> typeFormatValidator() {
		return new SensitivityMethodologyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SensitivityMethodology, Set<String>> onlyExistsValidator() {
		return new SensitivityMethodologyOnlyExistsValidator();
	}
}
