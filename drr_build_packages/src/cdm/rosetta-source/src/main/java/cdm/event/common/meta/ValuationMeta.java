package cdm.event.common.meta;

import cdm.event.common.Valuation;
import cdm.event.common.validation.ValuationTypeFormatValidator;
import cdm.event.common.validation.ValuationValidator;
import cdm.event.common.validation.datarule.ValuationValuationType;
import cdm.event.common.validation.exists.ValuationOnlyExistsValidator;
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
@RosettaMeta(model=Valuation.class)
public class ValuationMeta implements RosettaMetaData<Valuation> {

	@Override
	public List<Validator<? super Valuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Valuation>create(ValuationValuationType.class)
		);
	}
	
	@Override
	public List<Function<? super Valuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Valuation> validator(ValidatorFactory factory) {
		return factory.<Valuation>create(ValuationValidator.class);
	}

	@Override
	public Validator<? super Valuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Valuation>create(ValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Valuation> validator() {
		return new ValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Valuation> typeFormatValidator() {
		return new ValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Valuation, Set<String>> onlyExistsValidator() {
		return new ValuationOnlyExistsValidator();
	}
}
