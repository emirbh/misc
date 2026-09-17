package fpml.consolidated.reg.fpmlreporting.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPortfolio;
import fpml.consolidated.reg.fpmlreporting.shared.validation.CollateralPortfolioTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.CollateralPortfolioValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.exists.CollateralPortfolioOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CollateralPortfolio.class)
public class CollateralPortfolioMeta implements RosettaMetaData<CollateralPortfolio> {

	@Override
	public List<Validator<? super CollateralPortfolio>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralPortfolio, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralPortfolio> validator(ValidatorFactory factory) {
		return factory.<CollateralPortfolio>create(CollateralPortfolioValidator.class);
	}

	@Override
	public Validator<? super CollateralPortfolio> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralPortfolio>create(CollateralPortfolioTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralPortfolio> validator() {
		return new CollateralPortfolioValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralPortfolio> typeFormatValidator() {
		return new CollateralPortfolioTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralPortfolio, Set<String>> onlyExistsValidator() {
		return new CollateralPortfolioOnlyExistsValidator();
	}
}
