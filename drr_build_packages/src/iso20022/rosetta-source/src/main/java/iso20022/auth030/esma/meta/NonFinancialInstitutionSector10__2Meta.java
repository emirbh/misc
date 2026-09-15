package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.NonFinancialInstitutionSector10__2;
import iso20022.auth030.esma.validation.NonFinancialInstitutionSector10__2TypeFormatValidator;
import iso20022.auth030.esma.validation.NonFinancialInstitutionSector10__2Validator;
import iso20022.auth030.esma.validation.exists.NonFinancialInstitutionSector10__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NonFinancialInstitutionSector10__2.class)
public class NonFinancialInstitutionSector10__2Meta implements RosettaMetaData<NonFinancialInstitutionSector10__2> {

	@Override
	public List<Validator<? super NonFinancialInstitutionSector10__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonFinancialInstitutionSector10__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonFinancialInstitutionSector10__2> validator(ValidatorFactory factory) {
		return factory.<NonFinancialInstitutionSector10__2>create(NonFinancialInstitutionSector10__2Validator.class);
	}

	@Override
	public Validator<? super NonFinancialInstitutionSector10__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonFinancialInstitutionSector10__2>create(NonFinancialInstitutionSector10__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonFinancialInstitutionSector10__2> validator() {
		return new NonFinancialInstitutionSector10__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super NonFinancialInstitutionSector10__2> typeFormatValidator() {
		return new NonFinancialInstitutionSector10__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonFinancialInstitutionSector10__2, Set<String>> onlyExistsValidator() {
		return new NonFinancialInstitutionSector10__2OnlyExistsValidator();
	}
}
