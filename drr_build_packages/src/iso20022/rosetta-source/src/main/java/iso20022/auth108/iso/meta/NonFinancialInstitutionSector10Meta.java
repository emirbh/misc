package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.NonFinancialInstitutionSector10;
import iso20022.auth108.iso.validation.NonFinancialInstitutionSector10TypeFormatValidator;
import iso20022.auth108.iso.validation.NonFinancialInstitutionSector10Validator;
import iso20022.auth108.iso.validation.exists.NonFinancialInstitutionSector10OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NonFinancialInstitutionSector10.class)
public class NonFinancialInstitutionSector10Meta implements RosettaMetaData<NonFinancialInstitutionSector10> {

	@Override
	public List<Validator<? super NonFinancialInstitutionSector10>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonFinancialInstitutionSector10, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonFinancialInstitutionSector10> validator(ValidatorFactory factory) {
		return factory.<NonFinancialInstitutionSector10>create(NonFinancialInstitutionSector10Validator.class);
	}

	@Override
	public Validator<? super NonFinancialInstitutionSector10> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonFinancialInstitutionSector10>create(NonFinancialInstitutionSector10TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonFinancialInstitutionSector10> validator() {
		return new NonFinancialInstitutionSector10Validator();
	}

	@Deprecated
	@Override
	public Validator<? super NonFinancialInstitutionSector10> typeFormatValidator() {
		return new NonFinancialInstitutionSector10TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonFinancialInstitutionSector10, Set<String>> onlyExistsValidator() {
		return new NonFinancialInstitutionSector10OnlyExistsValidator();
	}
}
