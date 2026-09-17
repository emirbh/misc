package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.SubstitutedRegime;
import cdm.legaldocumentation.csa.validation.SubstitutedRegimeTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.SubstitutedRegimeValidator;
import cdm.legaldocumentation.csa.validation.datarule.SubstitutedRegimeSubstitutedRegimeChoice;
import cdm.legaldocumentation.csa.validation.exists.SubstitutedRegimeOnlyExistsValidator;
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
@RosettaMeta(model=SubstitutedRegime.class)
public class SubstitutedRegimeMeta implements RosettaMetaData<SubstitutedRegime> {

	@Override
	public List<Validator<? super SubstitutedRegime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SubstitutedRegime>create(SubstitutedRegimeSubstitutedRegimeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SubstitutedRegime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SubstitutedRegime> validator(ValidatorFactory factory) {
		return factory.<SubstitutedRegime>create(SubstitutedRegimeValidator.class);
	}

	@Override
	public Validator<? super SubstitutedRegime> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SubstitutedRegime>create(SubstitutedRegimeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SubstitutedRegime> validator() {
		return new SubstitutedRegimeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SubstitutedRegime> typeFormatValidator() {
		return new SubstitutedRegimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SubstitutedRegime, Set<String>> onlyExistsValidator() {
		return new SubstitutedRegimeOnlyExistsValidator();
	}
}
