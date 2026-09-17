package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.VolatilityRepresentation;
import fpml.consolidated.mktenv.validation.VolatilityRepresentationTypeFormatValidator;
import fpml.consolidated.mktenv.validation.VolatilityRepresentationValidator;
import fpml.consolidated.mktenv.validation.datarule.VolatilityRepresentationChoice;
import fpml.consolidated.mktenv.validation.exists.VolatilityRepresentationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VolatilityRepresentation.class)
public class VolatilityRepresentationMeta implements RosettaMetaData<VolatilityRepresentation> {

	@Override
	public List<Validator<? super VolatilityRepresentation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<VolatilityRepresentation>create(VolatilityRepresentationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super VolatilityRepresentation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VolatilityRepresentation> validator(ValidatorFactory factory) {
		return factory.<VolatilityRepresentation>create(VolatilityRepresentationValidator.class);
	}

	@Override
	public Validator<? super VolatilityRepresentation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VolatilityRepresentation>create(VolatilityRepresentationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VolatilityRepresentation> validator() {
		return new VolatilityRepresentationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VolatilityRepresentation> typeFormatValidator() {
		return new VolatilityRepresentationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilityRepresentation, Set<String>> onlyExistsValidator() {
		return new VolatilityRepresentationOnlyExistsValidator();
	}
}
