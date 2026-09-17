package cdm.product.collateral.meta;

import cdm.product.collateral.ConcentrationLimit;
import cdm.product.collateral.validation.ConcentrationLimitTypeFormatValidator;
import cdm.product.collateral.validation.ConcentrationLimitValidator;
import cdm.product.collateral.validation.datarule.ConcentrationLimitConcentrationLimitValueChoice;
import cdm.product.collateral.validation.datarule.ConcentrationLimitPercentageConcentrationLimit;
import cdm.product.collateral.validation.exists.ConcentrationLimitOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=ConcentrationLimit.class)
public class ConcentrationLimitMeta implements RosettaMetaData<ConcentrationLimit> {

	@Override
	public List<Validator<? super ConcentrationLimit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ConcentrationLimit>create(ConcentrationLimitConcentrationLimitValueChoice.class),
			factory.<ConcentrationLimit>create(ConcentrationLimitPercentageConcentrationLimit.class)
		);
	}
	
	@Override
	public List<Function<? super ConcentrationLimit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConcentrationLimit> validator(ValidatorFactory factory) {
		return factory.<ConcentrationLimit>create(ConcentrationLimitValidator.class);
	}

	@Override
	public Validator<? super ConcentrationLimit> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ConcentrationLimit>create(ConcentrationLimitTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ConcentrationLimit> validator() {
		return new ConcentrationLimitValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ConcentrationLimit> typeFormatValidator() {
		return new ConcentrationLimitTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConcentrationLimit, Set<String>> onlyExistsValidator() {
		return new ConcentrationLimitOnlyExistsValidator();
	}
}
