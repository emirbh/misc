package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ExposureScope;
import cdm.legaldocumentation.csa.validation.ExposureScopeTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ExposureScopeValidator;
import cdm.legaldocumentation.csa.validation.exists.ExposureScopeOnlyExistsValidator;
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
@RosettaMeta(model=ExposureScope.class)
public class ExposureScopeMeta implements RosettaMetaData<ExposureScope> {

	@Override
	public List<Validator<? super ExposureScope>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExposureScope, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExposureScope> validator(ValidatorFactory factory) {
		return factory.<ExposureScope>create(ExposureScopeValidator.class);
	}

	@Override
	public Validator<? super ExposureScope> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExposureScope>create(ExposureScopeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExposureScope> validator() {
		return new ExposureScopeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExposureScope> typeFormatValidator() {
		return new ExposureScopeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExposureScope, Set<String>> onlyExistsValidator() {
		return new ExposureScopeOnlyExistsValidator();
	}
}
