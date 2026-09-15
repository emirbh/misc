package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.PostTradeRiskReductionIdentifier1;
import iso20022.auth030.fca.validation.PostTradeRiskReductionIdentifier1TypeFormatValidator;
import iso20022.auth030.fca.validation.PostTradeRiskReductionIdentifier1Validator;
import iso20022.auth030.fca.validation.exists.PostTradeRiskReductionIdentifier1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PostTradeRiskReductionIdentifier1.class)
public class PostTradeRiskReductionIdentifier1Meta implements RosettaMetaData<PostTradeRiskReductionIdentifier1> {

	@Override
	public List<Validator<? super PostTradeRiskReductionIdentifier1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PostTradeRiskReductionIdentifier1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PostTradeRiskReductionIdentifier1> validator(ValidatorFactory factory) {
		return factory.<PostTradeRiskReductionIdentifier1>create(PostTradeRiskReductionIdentifier1Validator.class);
	}

	@Override
	public Validator<? super PostTradeRiskReductionIdentifier1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PostTradeRiskReductionIdentifier1>create(PostTradeRiskReductionIdentifier1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PostTradeRiskReductionIdentifier1> validator() {
		return new PostTradeRiskReductionIdentifier1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PostTradeRiskReductionIdentifier1> typeFormatValidator() {
		return new PostTradeRiskReductionIdentifier1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PostTradeRiskReductionIdentifier1, Set<String>> onlyExistsValidator() {
		return new PostTradeRiskReductionIdentifier1OnlyExistsValidator();
	}
}
