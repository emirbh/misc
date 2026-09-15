package iso20022.auth108.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.hkma.dtcc.OrganisationIdentification15Choice__3;
import iso20022.auth108.hkma.dtcc.validation.OrganisationIdentification15Choice__3TypeFormatValidator;
import iso20022.auth108.hkma.dtcc.validation.OrganisationIdentification15Choice__3Validator;
import iso20022.auth108.hkma.dtcc.validation.datarule.OrganisationIdentification15Choice__3Choice;
import iso20022.auth108.hkma.dtcc.validation.exists.OrganisationIdentification15Choice__3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OrganisationIdentification15Choice__3.class)
public class OrganisationIdentification15Choice__3Meta implements RosettaMetaData<OrganisationIdentification15Choice__3> {

	@Override
	public List<Validator<? super OrganisationIdentification15Choice__3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OrganisationIdentification15Choice__3>create(OrganisationIdentification15Choice__3Choice.class)
		);
	}
	
	@Override
	public List<Function<? super OrganisationIdentification15Choice__3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OrganisationIdentification15Choice__3> validator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification15Choice__3>create(OrganisationIdentification15Choice__3Validator.class);
	}

	@Override
	public Validator<? super OrganisationIdentification15Choice__3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification15Choice__3>create(OrganisationIdentification15Choice__3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification15Choice__3> validator() {
		return new OrganisationIdentification15Choice__3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification15Choice__3> typeFormatValidator() {
		return new OrganisationIdentification15Choice__3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrganisationIdentification15Choice__3, Set<String>> onlyExistsValidator() {
		return new OrganisationIdentification15Choice__3OnlyExistsValidator();
	}
}
