package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.ReceivedMarginOrCollateral6;
import iso20022.auth108.iso.validation.ReceivedMarginOrCollateral6TypeFormatValidator;
import iso20022.auth108.iso.validation.ReceivedMarginOrCollateral6Validator;
import iso20022.auth108.iso.validation.exists.ReceivedMarginOrCollateral6OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReceivedMarginOrCollateral6.class)
public class ReceivedMarginOrCollateral6Meta implements RosettaMetaData<ReceivedMarginOrCollateral6> {

	@Override
	public List<Validator<? super ReceivedMarginOrCollateral6>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReceivedMarginOrCollateral6, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReceivedMarginOrCollateral6> validator(ValidatorFactory factory) {
		return factory.<ReceivedMarginOrCollateral6>create(ReceivedMarginOrCollateral6Validator.class);
	}

	@Override
	public Validator<? super ReceivedMarginOrCollateral6> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReceivedMarginOrCollateral6>create(ReceivedMarginOrCollateral6TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReceivedMarginOrCollateral6> validator() {
		return new ReceivedMarginOrCollateral6Validator();
	}

	@Deprecated
	@Override
	public Validator<? super ReceivedMarginOrCollateral6> typeFormatValidator() {
		return new ReceivedMarginOrCollateral6TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReceivedMarginOrCollateral6, Set<String>> onlyExistsValidator() {
		return new ReceivedMarginOrCollateral6OnlyExistsValidator();
	}
}
