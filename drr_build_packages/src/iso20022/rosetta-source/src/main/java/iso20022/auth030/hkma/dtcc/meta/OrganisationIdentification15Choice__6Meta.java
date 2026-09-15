package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.OrganisationIdentification15Choice__6;
import iso20022.auth030.hkma.dtcc.validation.OrganisationIdentification15Choice__6TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.OrganisationIdentification15Choice__6Validator;
import iso20022.auth030.hkma.dtcc.validation.datarule.OrganisationIdentification15Choice__6Choice;
import iso20022.auth030.hkma.dtcc.validation.exists.OrganisationIdentification15Choice__6OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OrganisationIdentification15Choice__6.class)
public class OrganisationIdentification15Choice__6Meta implements RosettaMetaData<OrganisationIdentification15Choice__6> {

	@Override
	public List<Validator<? super OrganisationIdentification15Choice__6>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OrganisationIdentification15Choice__6>create(OrganisationIdentification15Choice__6Choice.class)
		);
	}
	
	@Override
	public List<Function<? super OrganisationIdentification15Choice__6, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OrganisationIdentification15Choice__6> validator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification15Choice__6>create(OrganisationIdentification15Choice__6Validator.class);
	}

	@Override
	public Validator<? super OrganisationIdentification15Choice__6> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification15Choice__6>create(OrganisationIdentification15Choice__6TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification15Choice__6> validator() {
		return new OrganisationIdentification15Choice__6Validator();
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification15Choice__6> typeFormatValidator() {
		return new OrganisationIdentification15Choice__6TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrganisationIdentification15Choice__6, Set<String>> onlyExistsValidator() {
		return new OrganisationIdentification15Choice__6OnlyExistsValidator();
	}
}
