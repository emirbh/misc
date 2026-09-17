package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.AdditionalRepresentations;
import cdm.legaldocumentation.csa.validation.AdditionalRepresentationsTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.AdditionalRepresentationsValidator;
import cdm.legaldocumentation.csa.validation.datarule.AdditionalRepresentationsOneOf0;
import cdm.legaldocumentation.csa.validation.exists.AdditionalRepresentationsOnlyExistsValidator;
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
@RosettaMeta(model=AdditionalRepresentations.class)
public class AdditionalRepresentationsMeta implements RosettaMetaData<AdditionalRepresentations> {

	@Override
	public List<Validator<? super AdditionalRepresentations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AdditionalRepresentations>create(AdditionalRepresentationsOneOf0.class)
		);
	}
	
	@Override
	public List<Function<? super AdditionalRepresentations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalRepresentations> validator(ValidatorFactory factory) {
		return factory.<AdditionalRepresentations>create(AdditionalRepresentationsValidator.class);
	}

	@Override
	public Validator<? super AdditionalRepresentations> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdditionalRepresentations>create(AdditionalRepresentationsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalRepresentations> validator() {
		return new AdditionalRepresentationsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalRepresentations> typeFormatValidator() {
		return new AdditionalRepresentationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalRepresentations, Set<String>> onlyExistsValidator() {
		return new AdditionalRepresentationsOnlyExistsValidator();
	}
}
