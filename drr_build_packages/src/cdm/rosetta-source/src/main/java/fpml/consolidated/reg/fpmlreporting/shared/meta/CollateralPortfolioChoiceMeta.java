package fpml.consolidated.reg.fpmlreporting.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPortfolioChoice;
import fpml.consolidated.reg.fpmlreporting.shared.validation.CollateralPortfolioChoiceTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.CollateralPortfolioChoiceValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.datarule.CollateralPortfolioChoiceChoice;
import fpml.consolidated.reg.fpmlreporting.shared.validation.exists.CollateralPortfolioChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CollateralPortfolioChoice.class)
public class CollateralPortfolioChoiceMeta implements RosettaMetaData<CollateralPortfolioChoice> {

	@Override
	public List<Validator<? super CollateralPortfolioChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CollateralPortfolioChoice>create(CollateralPortfolioChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CollateralPortfolioChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralPortfolioChoice> validator(ValidatorFactory factory) {
		return factory.<CollateralPortfolioChoice>create(CollateralPortfolioChoiceValidator.class);
	}

	@Override
	public Validator<? super CollateralPortfolioChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralPortfolioChoice>create(CollateralPortfolioChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralPortfolioChoice> validator() {
		return new CollateralPortfolioChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralPortfolioChoice> typeFormatValidator() {
		return new CollateralPortfolioChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralPortfolioChoice, Set<String>> onlyExistsValidator() {
		return new CollateralPortfolioChoiceOnlyExistsValidator();
	}
}
