package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.PostedMarginOrCollateral6;
import iso20022.auth108.iso.validation.PostedMarginOrCollateral6TypeFormatValidator;
import iso20022.auth108.iso.validation.PostedMarginOrCollateral6Validator;
import iso20022.auth108.iso.validation.exists.PostedMarginOrCollateral6OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PostedMarginOrCollateral6.class)
public class PostedMarginOrCollateral6Meta implements RosettaMetaData<PostedMarginOrCollateral6> {

	@Override
	public List<Validator<? super PostedMarginOrCollateral6>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PostedMarginOrCollateral6, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PostedMarginOrCollateral6> validator(ValidatorFactory factory) {
		return factory.<PostedMarginOrCollateral6>create(PostedMarginOrCollateral6Validator.class);
	}

	@Override
	public Validator<? super PostedMarginOrCollateral6> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PostedMarginOrCollateral6>create(PostedMarginOrCollateral6TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PostedMarginOrCollateral6> validator() {
		return new PostedMarginOrCollateral6Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PostedMarginOrCollateral6> typeFormatValidator() {
		return new PostedMarginOrCollateral6TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PostedMarginOrCollateral6, Set<String>> onlyExistsValidator() {
		return new PostedMarginOrCollateral6OnlyExistsValidator();
	}
}
