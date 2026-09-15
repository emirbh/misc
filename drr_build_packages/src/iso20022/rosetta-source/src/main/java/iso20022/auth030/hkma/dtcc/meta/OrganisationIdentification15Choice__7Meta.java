package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.OrganisationIdentification15Choice__7;
import iso20022.auth030.hkma.dtcc.validation.OrganisationIdentification15Choice__7TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.OrganisationIdentification15Choice__7Validator;
import iso20022.auth030.hkma.dtcc.validation.datarule.OrganisationIdentification15Choice__7Choice;
import iso20022.auth030.hkma.dtcc.validation.exists.OrganisationIdentification15Choice__7OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OrganisationIdentification15Choice__7.class)
public class OrganisationIdentification15Choice__7Meta implements RosettaMetaData<OrganisationIdentification15Choice__7> {

	@Override
	public List<Validator<? super OrganisationIdentification15Choice__7>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OrganisationIdentification15Choice__7>create(OrganisationIdentification15Choice__7Choice.class)
		);
	}
	
	@Override
	public List<Function<? super OrganisationIdentification15Choice__7, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OrganisationIdentification15Choice__7> validator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification15Choice__7>create(OrganisationIdentification15Choice__7Validator.class);
	}

	@Override
	public Validator<? super OrganisationIdentification15Choice__7> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification15Choice__7>create(OrganisationIdentification15Choice__7TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification15Choice__7> validator() {
		return new OrganisationIdentification15Choice__7Validator();
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification15Choice__7> typeFormatValidator() {
		return new OrganisationIdentification15Choice__7TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrganisationIdentification15Choice__7, Set<String>> onlyExistsValidator() {
		return new OrganisationIdentification15Choice__7OnlyExistsValidator();
	}
}
