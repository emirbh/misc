package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.PostTradeRiskReductionIdentifier1__2;
import iso20022.auth030.esma.validation.PostTradeRiskReductionIdentifier1__2TypeFormatValidator;
import iso20022.auth030.esma.validation.PostTradeRiskReductionIdentifier1__2Validator;
import iso20022.auth030.esma.validation.exists.PostTradeRiskReductionIdentifier1__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PostTradeRiskReductionIdentifier1__2.class)
public class PostTradeRiskReductionIdentifier1__2Meta implements RosettaMetaData<PostTradeRiskReductionIdentifier1__2> {

	@Override
	public List<Validator<? super PostTradeRiskReductionIdentifier1__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PostTradeRiskReductionIdentifier1__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PostTradeRiskReductionIdentifier1__2> validator(ValidatorFactory factory) {
		return factory.<PostTradeRiskReductionIdentifier1__2>create(PostTradeRiskReductionIdentifier1__2Validator.class);
	}

	@Override
	public Validator<? super PostTradeRiskReductionIdentifier1__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PostTradeRiskReductionIdentifier1__2>create(PostTradeRiskReductionIdentifier1__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PostTradeRiskReductionIdentifier1__2> validator() {
		return new PostTradeRiskReductionIdentifier1__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PostTradeRiskReductionIdentifier1__2> typeFormatValidator() {
		return new PostTradeRiskReductionIdentifier1__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PostTradeRiskReductionIdentifier1__2, Set<String>> onlyExistsValidator() {
		return new PostTradeRiskReductionIdentifier1__2OnlyExistsValidator();
	}
}
