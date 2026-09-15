package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.InterestRateLegs14__3;
import iso20022.auth030.jfsa.validation.InterestRateLegs14__3TypeFormatValidator;
import iso20022.auth030.jfsa.validation.InterestRateLegs14__3Validator;
import iso20022.auth030.jfsa.validation.exists.InterestRateLegs14__3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InterestRateLegs14__3.class)
public class InterestRateLegs14__3Meta implements RosettaMetaData<InterestRateLegs14__3> {

	@Override
	public List<Validator<? super InterestRateLegs14__3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestRateLegs14__3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestRateLegs14__3> validator(ValidatorFactory factory) {
		return factory.<InterestRateLegs14__3>create(InterestRateLegs14__3Validator.class);
	}

	@Override
	public Validator<? super InterestRateLegs14__3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestRateLegs14__3>create(InterestRateLegs14__3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestRateLegs14__3> validator() {
		return new InterestRateLegs14__3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestRateLegs14__3> typeFormatValidator() {
		return new InterestRateLegs14__3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestRateLegs14__3, Set<String>> onlyExistsValidator() {
		return new InterestRateLegs14__3OnlyExistsValidator();
	}
}
