package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.CollateralPortfolioCode5Choice;
import iso20022.auth108.iso.validation.CollateralPortfolioCode5ChoiceTypeFormatValidator;
import iso20022.auth108.iso.validation.CollateralPortfolioCode5ChoiceValidator;
import iso20022.auth108.iso.validation.datarule.CollateralPortfolioCode5ChoiceChoice;
import iso20022.auth108.iso.validation.exists.CollateralPortfolioCode5ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CollateralPortfolioCode5Choice.class)
public class CollateralPortfolioCode5ChoiceMeta implements RosettaMetaData<CollateralPortfolioCode5Choice> {

	@Override
	public List<Validator<? super CollateralPortfolioCode5Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CollateralPortfolioCode5Choice>create(CollateralPortfolioCode5ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CollateralPortfolioCode5Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralPortfolioCode5Choice> validator(ValidatorFactory factory) {
		return factory.<CollateralPortfolioCode5Choice>create(CollateralPortfolioCode5ChoiceValidator.class);
	}

	@Override
	public Validator<? super CollateralPortfolioCode5Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralPortfolioCode5Choice>create(CollateralPortfolioCode5ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralPortfolioCode5Choice> validator() {
		return new CollateralPortfolioCode5ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralPortfolioCode5Choice> typeFormatValidator() {
		return new CollateralPortfolioCode5ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralPortfolioCode5Choice, Set<String>> onlyExistsValidator() {
		return new CollateralPortfolioCode5ChoiceOnlyExistsValidator();
	}
}
