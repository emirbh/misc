package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.OrganisationIdentification38__2;
import iso20022.auth030.hkma.tr.validation.OrganisationIdentification38__2TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.OrganisationIdentification38__2Validator;
import iso20022.auth030.hkma.tr.validation.exists.OrganisationIdentification38__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OrganisationIdentification38__2.class)
public class OrganisationIdentification38__2Meta implements RosettaMetaData<OrganisationIdentification38__2> {

	@Override
	public List<Validator<? super OrganisationIdentification38__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OrganisationIdentification38__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OrganisationIdentification38__2> validator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification38__2>create(OrganisationIdentification38__2Validator.class);
	}

	@Override
	public Validator<? super OrganisationIdentification38__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification38__2>create(OrganisationIdentification38__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification38__2> validator() {
		return new OrganisationIdentification38__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification38__2> typeFormatValidator() {
		return new OrganisationIdentification38__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrganisationIdentification38__2, Set<String>> onlyExistsValidator() {
		return new OrganisationIdentification38__2OnlyExistsValidator();
	}
}
