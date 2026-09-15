package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.InterestComputationMethodFormat7__1;
import iso20022.auth030.hkma.dtcc.validation.InterestComputationMethodFormat7__1TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.InterestComputationMethodFormat7__1Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.InterestComputationMethodFormat7__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InterestComputationMethodFormat7__1.class)
public class InterestComputationMethodFormat7__1Meta implements RosettaMetaData<InterestComputationMethodFormat7__1> {

	@Override
	public List<Validator<? super InterestComputationMethodFormat7__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestComputationMethodFormat7__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestComputationMethodFormat7__1> validator(ValidatorFactory factory) {
		return factory.<InterestComputationMethodFormat7__1>create(InterestComputationMethodFormat7__1Validator.class);
	}

	@Override
	public Validator<? super InterestComputationMethodFormat7__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestComputationMethodFormat7__1>create(InterestComputationMethodFormat7__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestComputationMethodFormat7__1> validator() {
		return new InterestComputationMethodFormat7__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestComputationMethodFormat7__1> typeFormatValidator() {
		return new InterestComputationMethodFormat7__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestComputationMethodFormat7__1, Set<String>> onlyExistsValidator() {
		return new InterestComputationMethodFormat7__1OnlyExistsValidator();
	}
}
