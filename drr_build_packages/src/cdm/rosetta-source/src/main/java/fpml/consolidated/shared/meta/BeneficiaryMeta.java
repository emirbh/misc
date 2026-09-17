package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Beneficiary;
import fpml.consolidated.shared.validation.BeneficiaryTypeFormatValidator;
import fpml.consolidated.shared.validation.BeneficiaryValidator;
import fpml.consolidated.shared.validation.datarule.BeneficiaryChoice;
import fpml.consolidated.shared.validation.exists.BeneficiaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Beneficiary.class)
public class BeneficiaryMeta implements RosettaMetaData<Beneficiary> {

	@Override
	public List<Validator<? super Beneficiary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Beneficiary>create(BeneficiaryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Beneficiary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Beneficiary> validator(ValidatorFactory factory) {
		return factory.<Beneficiary>create(BeneficiaryValidator.class);
	}

	@Override
	public Validator<? super Beneficiary> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Beneficiary>create(BeneficiaryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Beneficiary> validator() {
		return new BeneficiaryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Beneficiary> typeFormatValidator() {
		return new BeneficiaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Beneficiary, Set<String>> onlyExistsValidator() {
		return new BeneficiaryOnlyExistsValidator();
	}
}
