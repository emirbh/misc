package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.InterestRateContractTerm4__2;
import iso20022.auth030.fca.validation.InterestRateContractTerm4__2TypeFormatValidator;
import iso20022.auth030.fca.validation.InterestRateContractTerm4__2Validator;
import iso20022.auth030.fca.validation.exists.InterestRateContractTerm4__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InterestRateContractTerm4__2.class)
public class InterestRateContractTerm4__2Meta implements RosettaMetaData<InterestRateContractTerm4__2> {

	@Override
	public List<Validator<? super InterestRateContractTerm4__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestRateContractTerm4__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestRateContractTerm4__2> validator(ValidatorFactory factory) {
		return factory.<InterestRateContractTerm4__2>create(InterestRateContractTerm4__2Validator.class);
	}

	@Override
	public Validator<? super InterestRateContractTerm4__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestRateContractTerm4__2>create(InterestRateContractTerm4__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestRateContractTerm4__2> validator() {
		return new InterestRateContractTerm4__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestRateContractTerm4__2> typeFormatValidator() {
		return new InterestRateContractTerm4__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestRateContractTerm4__2, Set<String>> onlyExistsValidator() {
		return new InterestRateContractTerm4__2OnlyExistsValidator();
	}
}
