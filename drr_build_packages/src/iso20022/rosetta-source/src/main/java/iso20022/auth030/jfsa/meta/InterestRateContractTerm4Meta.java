package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.InterestRateContractTerm4;
import iso20022.auth030.jfsa.validation.InterestRateContractTerm4TypeFormatValidator;
import iso20022.auth030.jfsa.validation.InterestRateContractTerm4Validator;
import iso20022.auth030.jfsa.validation.exists.InterestRateContractTerm4OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InterestRateContractTerm4.class)
public class InterestRateContractTerm4Meta implements RosettaMetaData<InterestRateContractTerm4> {

	@Override
	public List<Validator<? super InterestRateContractTerm4>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestRateContractTerm4, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestRateContractTerm4> validator(ValidatorFactory factory) {
		return factory.<InterestRateContractTerm4>create(InterestRateContractTerm4Validator.class);
	}

	@Override
	public Validator<? super InterestRateContractTerm4> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestRateContractTerm4>create(InterestRateContractTerm4TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestRateContractTerm4> validator() {
		return new InterestRateContractTerm4Validator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestRateContractTerm4> typeFormatValidator() {
		return new InterestRateContractTerm4TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestRateContractTerm4, Set<String>> onlyExistsValidator() {
		return new InterestRateContractTerm4OnlyExistsValidator();
	}
}
