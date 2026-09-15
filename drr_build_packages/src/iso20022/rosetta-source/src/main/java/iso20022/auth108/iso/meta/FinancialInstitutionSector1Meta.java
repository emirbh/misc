package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.FinancialInstitutionSector1;
import iso20022.auth108.iso.validation.FinancialInstitutionSector1TypeFormatValidator;
import iso20022.auth108.iso.validation.FinancialInstitutionSector1Validator;
import iso20022.auth108.iso.validation.exists.FinancialInstitutionSector1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FinancialInstitutionSector1.class)
public class FinancialInstitutionSector1Meta implements RosettaMetaData<FinancialInstitutionSector1> {

	@Override
	public List<Validator<? super FinancialInstitutionSector1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FinancialInstitutionSector1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FinancialInstitutionSector1> validator(ValidatorFactory factory) {
		return factory.<FinancialInstitutionSector1>create(FinancialInstitutionSector1Validator.class);
	}

	@Override
	public Validator<? super FinancialInstitutionSector1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FinancialInstitutionSector1>create(FinancialInstitutionSector1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FinancialInstitutionSector1> validator() {
		return new FinancialInstitutionSector1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FinancialInstitutionSector1> typeFormatValidator() {
		return new FinancialInstitutionSector1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FinancialInstitutionSector1, Set<String>> onlyExistsValidator() {
		return new FinancialInstitutionSector1OnlyExistsValidator();
	}
}
