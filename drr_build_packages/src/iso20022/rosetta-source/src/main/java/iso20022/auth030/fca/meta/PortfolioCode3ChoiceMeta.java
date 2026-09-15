package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.PortfolioCode3Choice;
import iso20022.auth030.fca.validation.PortfolioCode3ChoiceTypeFormatValidator;
import iso20022.auth030.fca.validation.PortfolioCode3ChoiceValidator;
import iso20022.auth030.fca.validation.datarule.PortfolioCode3ChoiceChoice;
import iso20022.auth030.fca.validation.exists.PortfolioCode3ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PortfolioCode3Choice.class)
public class PortfolioCode3ChoiceMeta implements RosettaMetaData<PortfolioCode3Choice> {

	@Override
	public List<Validator<? super PortfolioCode3Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PortfolioCode3Choice>create(PortfolioCode3ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PortfolioCode3Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PortfolioCode3Choice> validator(ValidatorFactory factory) {
		return factory.<PortfolioCode3Choice>create(PortfolioCode3ChoiceValidator.class);
	}

	@Override
	public Validator<? super PortfolioCode3Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PortfolioCode3Choice>create(PortfolioCode3ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PortfolioCode3Choice> validator() {
		return new PortfolioCode3ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PortfolioCode3Choice> typeFormatValidator() {
		return new PortfolioCode3ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PortfolioCode3Choice, Set<String>> onlyExistsValidator() {
		return new PortfolioCode3ChoiceOnlyExistsValidator();
	}
}
