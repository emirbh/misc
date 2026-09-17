package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.AdditionalRepresentation;
import cdm.legaldocumentation.csa.validation.AdditionalRepresentationTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.AdditionalRepresentationValidator;
import cdm.legaldocumentation.csa.validation.exists.AdditionalRepresentationOnlyExistsValidator;
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
@RosettaMeta(model=AdditionalRepresentation.class)
public class AdditionalRepresentationMeta implements RosettaMetaData<AdditionalRepresentation> {

	@Override
	public List<Validator<? super AdditionalRepresentation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdditionalRepresentation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalRepresentation> validator(ValidatorFactory factory) {
		return factory.<AdditionalRepresentation>create(AdditionalRepresentationValidator.class);
	}

	@Override
	public Validator<? super AdditionalRepresentation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdditionalRepresentation>create(AdditionalRepresentationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalRepresentation> validator() {
		return new AdditionalRepresentationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalRepresentation> typeFormatValidator() {
		return new AdditionalRepresentationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalRepresentation, Set<String>> onlyExistsValidator() {
		return new AdditionalRepresentationOnlyExistsValidator();
	}
}
