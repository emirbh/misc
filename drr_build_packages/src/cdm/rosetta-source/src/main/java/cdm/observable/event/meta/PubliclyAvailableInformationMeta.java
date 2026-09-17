package cdm.observable.event.meta;

import cdm.observable.event.PubliclyAvailableInformation;
import cdm.observable.event.validation.PubliclyAvailableInformationTypeFormatValidator;
import cdm.observable.event.validation.PubliclyAvailableInformationValidator;
import cdm.observable.event.validation.datarule.PubliclyAvailableInformationPositiveSpecifiedNumber;
import cdm.observable.event.validation.datarule.PubliclyAvailableInformationSourceChoice;
import cdm.observable.event.validation.exists.PubliclyAvailableInformationOnlyExistsValidator;
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
@RosettaMeta(model=PubliclyAvailableInformation.class)
public class PubliclyAvailableInformationMeta implements RosettaMetaData<PubliclyAvailableInformation> {

	@Override
	public List<Validator<? super PubliclyAvailableInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PubliclyAvailableInformation>create(PubliclyAvailableInformationSourceChoice.class),
			factory.<PubliclyAvailableInformation>create(PubliclyAvailableInformationPositiveSpecifiedNumber.class)
		);
	}
	
	@Override
	public List<Function<? super PubliclyAvailableInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PubliclyAvailableInformation> validator(ValidatorFactory factory) {
		return factory.<PubliclyAvailableInformation>create(PubliclyAvailableInformationValidator.class);
	}

	@Override
	public Validator<? super PubliclyAvailableInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PubliclyAvailableInformation>create(PubliclyAvailableInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PubliclyAvailableInformation> validator() {
		return new PubliclyAvailableInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PubliclyAvailableInformation> typeFormatValidator() {
		return new PubliclyAvailableInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PubliclyAvailableInformation, Set<String>> onlyExistsValidator() {
		return new PubliclyAvailableInformationOnlyExistsValidator();
	}
}
