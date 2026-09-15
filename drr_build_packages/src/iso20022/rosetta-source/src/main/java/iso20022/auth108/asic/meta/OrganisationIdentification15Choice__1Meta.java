package iso20022.auth108.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.asic.OrganisationIdentification15Choice__1;
import iso20022.auth108.asic.validation.OrganisationIdentification15Choice__1TypeFormatValidator;
import iso20022.auth108.asic.validation.OrganisationIdentification15Choice__1Validator;
import iso20022.auth108.asic.validation.exists.OrganisationIdentification15Choice__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OrganisationIdentification15Choice__1.class)
public class OrganisationIdentification15Choice__1Meta implements RosettaMetaData<OrganisationIdentification15Choice__1> {

	@Override
	public List<Validator<? super OrganisationIdentification15Choice__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OrganisationIdentification15Choice__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OrganisationIdentification15Choice__1> validator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification15Choice__1>create(OrganisationIdentification15Choice__1Validator.class);
	}

	@Override
	public Validator<? super OrganisationIdentification15Choice__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification15Choice__1>create(OrganisationIdentification15Choice__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification15Choice__1> validator() {
		return new OrganisationIdentification15Choice__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification15Choice__1> typeFormatValidator() {
		return new OrganisationIdentification15Choice__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrganisationIdentification15Choice__1, Set<String>> onlyExistsValidator() {
		return new OrganisationIdentification15Choice__1OnlyExistsValidator();
	}
}
