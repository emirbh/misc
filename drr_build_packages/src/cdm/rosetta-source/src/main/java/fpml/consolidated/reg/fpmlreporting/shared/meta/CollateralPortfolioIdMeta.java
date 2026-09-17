package fpml.consolidated.reg.fpmlreporting.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPortfolioId;
import fpml.consolidated.reg.fpmlreporting.shared.validation.CollateralPortfolioIdTypeFormatValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.CollateralPortfolioIdValidator;
import fpml.consolidated.reg.fpmlreporting.shared.validation.exists.CollateralPortfolioIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CollateralPortfolioId.class)
public class CollateralPortfolioIdMeta implements RosettaMetaData<CollateralPortfolioId> {

	@Override
	public List<Validator<? super CollateralPortfolioId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralPortfolioId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralPortfolioId> validator(ValidatorFactory factory) {
		return factory.<CollateralPortfolioId>create(CollateralPortfolioIdValidator.class);
	}

	@Override
	public Validator<? super CollateralPortfolioId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralPortfolioId>create(CollateralPortfolioIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralPortfolioId> validator() {
		return new CollateralPortfolioIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralPortfolioId> typeFormatValidator() {
		return new CollateralPortfolioIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralPortfolioId, Set<String>> onlyExistsValidator() {
		return new CollateralPortfolioIdOnlyExistsValidator();
	}
}
