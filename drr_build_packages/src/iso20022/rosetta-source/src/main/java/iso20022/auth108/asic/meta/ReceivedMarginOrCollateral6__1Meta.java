package iso20022.auth108.asic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.asic.ReceivedMarginOrCollateral6__1;
import iso20022.auth108.asic.validation.ReceivedMarginOrCollateral6__1TypeFormatValidator;
import iso20022.auth108.asic.validation.ReceivedMarginOrCollateral6__1Validator;
import iso20022.auth108.asic.validation.exists.ReceivedMarginOrCollateral6__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReceivedMarginOrCollateral6__1.class)
public class ReceivedMarginOrCollateral6__1Meta implements RosettaMetaData<ReceivedMarginOrCollateral6__1> {

	@Override
	public List<Validator<? super ReceivedMarginOrCollateral6__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReceivedMarginOrCollateral6__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReceivedMarginOrCollateral6__1> validator(ValidatorFactory factory) {
		return factory.<ReceivedMarginOrCollateral6__1>create(ReceivedMarginOrCollateral6__1Validator.class);
	}

	@Override
	public Validator<? super ReceivedMarginOrCollateral6__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReceivedMarginOrCollateral6__1>create(ReceivedMarginOrCollateral6__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReceivedMarginOrCollateral6__1> validator() {
		return new ReceivedMarginOrCollateral6__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super ReceivedMarginOrCollateral6__1> typeFormatValidator() {
		return new ReceivedMarginOrCollateral6__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReceivedMarginOrCollateral6__1, Set<String>> onlyExistsValidator() {
		return new ReceivedMarginOrCollateral6__1OnlyExistsValidator();
	}
}
