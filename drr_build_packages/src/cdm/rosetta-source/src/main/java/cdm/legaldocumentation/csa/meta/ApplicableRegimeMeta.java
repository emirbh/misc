package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ApplicableRegime;
import cdm.legaldocumentation.csa.validation.ApplicableRegimeTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ApplicableRegimeValidator;
import cdm.legaldocumentation.csa.validation.datarule.ApplicableRegimeApplicableRegimeChoice;
import cdm.legaldocumentation.csa.validation.exists.ApplicableRegimeOnlyExistsValidator;
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
@RosettaMeta(model=ApplicableRegime.class)
public class ApplicableRegimeMeta implements RosettaMetaData<ApplicableRegime> {

	@Override
	public List<Validator<? super ApplicableRegime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ApplicableRegime>create(ApplicableRegimeApplicableRegimeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ApplicableRegime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ApplicableRegime> validator(ValidatorFactory factory) {
		return factory.<ApplicableRegime>create(ApplicableRegimeValidator.class);
	}

	@Override
	public Validator<? super ApplicableRegime> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ApplicableRegime>create(ApplicableRegimeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableRegime> validator() {
		return new ApplicableRegimeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableRegime> typeFormatValidator() {
		return new ApplicableRegimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApplicableRegime, Set<String>> onlyExistsValidator() {
		return new ApplicableRegimeOnlyExistsValidator();
	}
}
