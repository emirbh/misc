package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.NotionalAmountLegs5__1;
import iso20022.auth030.hkma.dtcc.validation.NotionalAmountLegs5__1TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.NotionalAmountLegs5__1Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.NotionalAmountLegs5__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NotionalAmountLegs5__1.class)
public class NotionalAmountLegs5__1Meta implements RosettaMetaData<NotionalAmountLegs5__1> {

	@Override
	public List<Validator<? super NotionalAmountLegs5__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalAmountLegs5__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotionalAmountLegs5__1> validator(ValidatorFactory factory) {
		return factory.<NotionalAmountLegs5__1>create(NotionalAmountLegs5__1Validator.class);
	}

	@Override
	public Validator<? super NotionalAmountLegs5__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotionalAmountLegs5__1>create(NotionalAmountLegs5__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotionalAmountLegs5__1> validator() {
		return new NotionalAmountLegs5__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super NotionalAmountLegs5__1> typeFormatValidator() {
		return new NotionalAmountLegs5__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalAmountLegs5__1, Set<String>> onlyExistsValidator() {
		return new NotionalAmountLegs5__1OnlyExistsValidator();
	}
}
