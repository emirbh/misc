package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.OrganisationIdentification15Choice;
import iso20022.auth108.iso.validation.OrganisationIdentification15ChoiceTypeFormatValidator;
import iso20022.auth108.iso.validation.OrganisationIdentification15ChoiceValidator;
import iso20022.auth108.iso.validation.datarule.OrganisationIdentification15ChoiceChoice;
import iso20022.auth108.iso.validation.exists.OrganisationIdentification15ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OrganisationIdentification15Choice.class)
public class OrganisationIdentification15ChoiceMeta implements RosettaMetaData<OrganisationIdentification15Choice> {

	@Override
	public List<Validator<? super OrganisationIdentification15Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OrganisationIdentification15Choice>create(OrganisationIdentification15ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OrganisationIdentification15Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OrganisationIdentification15Choice> validator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification15Choice>create(OrganisationIdentification15ChoiceValidator.class);
	}

	@Override
	public Validator<? super OrganisationIdentification15Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification15Choice>create(OrganisationIdentification15ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification15Choice> validator() {
		return new OrganisationIdentification15ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification15Choice> typeFormatValidator() {
		return new OrganisationIdentification15ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrganisationIdentification15Choice, Set<String>> onlyExistsValidator() {
		return new OrganisationIdentification15ChoiceOnlyExistsValidator();
	}
}
