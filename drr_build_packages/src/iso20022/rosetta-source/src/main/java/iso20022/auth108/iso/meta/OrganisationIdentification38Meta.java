package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.OrganisationIdentification38;
import iso20022.auth108.iso.validation.OrganisationIdentification38TypeFormatValidator;
import iso20022.auth108.iso.validation.OrganisationIdentification38Validator;
import iso20022.auth108.iso.validation.exists.OrganisationIdentification38OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OrganisationIdentification38.class)
public class OrganisationIdentification38Meta implements RosettaMetaData<OrganisationIdentification38> {

	@Override
	public List<Validator<? super OrganisationIdentification38>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OrganisationIdentification38, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OrganisationIdentification38> validator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification38>create(OrganisationIdentification38Validator.class);
	}

	@Override
	public Validator<? super OrganisationIdentification38> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OrganisationIdentification38>create(OrganisationIdentification38TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification38> validator() {
		return new OrganisationIdentification38Validator();
	}

	@Deprecated
	@Override
	public Validator<? super OrganisationIdentification38> typeFormatValidator() {
		return new OrganisationIdentification38TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrganisationIdentification38, Set<String>> onlyExistsValidator() {
		return new OrganisationIdentification38OnlyExistsValidator();
	}
}
