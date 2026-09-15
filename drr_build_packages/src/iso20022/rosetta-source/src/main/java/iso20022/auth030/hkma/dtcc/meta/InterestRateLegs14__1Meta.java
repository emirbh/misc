package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.InterestRateLegs14__1;
import iso20022.auth030.hkma.dtcc.validation.InterestRateLegs14__1TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.InterestRateLegs14__1Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.InterestRateLegs14__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InterestRateLegs14__1.class)
public class InterestRateLegs14__1Meta implements RosettaMetaData<InterestRateLegs14__1> {

	@Override
	public List<Validator<? super InterestRateLegs14__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestRateLegs14__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestRateLegs14__1> validator(ValidatorFactory factory) {
		return factory.<InterestRateLegs14__1>create(InterestRateLegs14__1Validator.class);
	}

	@Override
	public Validator<? super InterestRateLegs14__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestRateLegs14__1>create(InterestRateLegs14__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestRateLegs14__1> validator() {
		return new InterestRateLegs14__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestRateLegs14__1> typeFormatValidator() {
		return new InterestRateLegs14__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestRateLegs14__1, Set<String>> onlyExistsValidator() {
		return new InterestRateLegs14__1OnlyExistsValidator();
	}
}
