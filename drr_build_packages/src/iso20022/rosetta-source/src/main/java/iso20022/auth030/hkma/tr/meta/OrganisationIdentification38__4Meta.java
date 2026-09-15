package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.OrganisationIdentification38__4;
import iso20022.auth030.hkma.tr.validation.OrganisationIdentification38__4TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.OrganisationIdentification38__4Validator;
import iso20022.auth030.hkma.tr.validation.exists.OrganisationIdentification38__4OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OrganisationIdentification38__4.class)
public class OrganisationIdentification38__4Meta implements RosettaMetaData<OrganisationIdentification38__4> {

	@Override
	public List<Validator<? super OrganisationIdentification38__4>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OrganisationIdentification38__4, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OrganisationIdentification38__4> validator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification38__4>create(OrganisationIdentification38__4Validator.class);
	}

	@Override
	public Validator<? super OrganisationIdentification38__4> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification38__4>create(OrganisationIdentification38__4TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification38__4> validator() {
		return new OrganisationIdentification38__4Validator();
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification38__4> typeFormatValidator() {
		return new OrganisationIdentification38__4TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrganisationIdentification38__4, Set<String>> onlyExistsValidator() {
		return new OrganisationIdentification38__4OnlyExistsValidator();
	}
}
