package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.OrganisationIdentification38__3;
import iso20022.auth030.hkma.dtcc.validation.OrganisationIdentification38__3TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.OrganisationIdentification38__3Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.OrganisationIdentification38__3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OrganisationIdentification38__3.class)
public class OrganisationIdentification38__3Meta implements RosettaMetaData<OrganisationIdentification38__3> {

	@Override
	public List<Validator<? super OrganisationIdentification38__3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OrganisationIdentification38__3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OrganisationIdentification38__3> validator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification38__3>create(OrganisationIdentification38__3Validator.class);
	}

	@Override
	public Validator<? super OrganisationIdentification38__3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification38__3>create(OrganisationIdentification38__3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification38__3> validator() {
		return new OrganisationIdentification38__3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification38__3> typeFormatValidator() {
		return new OrganisationIdentification38__3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrganisationIdentification38__3, Set<String>> onlyExistsValidator() {
		return new OrganisationIdentification38__3OnlyExistsValidator();
	}
}
