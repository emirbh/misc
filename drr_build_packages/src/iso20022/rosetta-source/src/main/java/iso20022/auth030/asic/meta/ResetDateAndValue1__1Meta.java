package iso20022.auth030.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.ResetDateAndValue1__1;
import iso20022.auth030.asic.validation.ResetDateAndValue1__1TypeFormatValidator;
import iso20022.auth030.asic.validation.ResetDateAndValue1__1Validator;
import iso20022.auth030.asic.validation.exists.ResetDateAndValue1__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ResetDateAndValue1__1.class)
public class ResetDateAndValue1__1Meta implements RosettaMetaData<ResetDateAndValue1__1> {

	@Override
	public List<Validator<? super ResetDateAndValue1__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResetDateAndValue1__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ResetDateAndValue1__1> validator(ValidatorFactory factory) {
		return factory.<ResetDateAndValue1__1>create(ResetDateAndValue1__1Validator.class);
	}

	@Override
	public Validator<? super ResetDateAndValue1__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ResetDateAndValue1__1>create(ResetDateAndValue1__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ResetDateAndValue1__1> validator() {
		return new ResetDateAndValue1__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super ResetDateAndValue1__1> typeFormatValidator() {
		return new ResetDateAndValue1__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResetDateAndValue1__1, Set<String>> onlyExistsValidator() {
		return new ResetDateAndValue1__1OnlyExistsValidator();
	}
}
