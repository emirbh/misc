package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.QuotationCharacteristics;
import fpml.consolidated.asset.validation.QuotationCharacteristicsTypeFormatValidator;
import fpml.consolidated.asset.validation.QuotationCharacteristicsValidator;
import fpml.consolidated.asset.validation.datarule.QuotationCharacteristicsChoice;
import fpml.consolidated.asset.validation.exists.QuotationCharacteristicsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=QuotationCharacteristics.class)
public class QuotationCharacteristicsMeta implements RosettaMetaData<QuotationCharacteristics> {

	@Override
	public List<Validator<? super QuotationCharacteristics>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<QuotationCharacteristics>create(QuotationCharacteristicsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super QuotationCharacteristics, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super QuotationCharacteristics> validator(ValidatorFactory factory) {
		return factory.<QuotationCharacteristics>create(QuotationCharacteristicsValidator.class);
	}

	@Override
	public Validator<? super QuotationCharacteristics> typeFormatValidator(ValidatorFactory factory) {
		return factory.<QuotationCharacteristics>create(QuotationCharacteristicsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super QuotationCharacteristics> validator() {
		return new QuotationCharacteristicsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super QuotationCharacteristics> typeFormatValidator() {
		return new QuotationCharacteristicsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QuotationCharacteristics, Set<String>> onlyExistsValidator() {
		return new QuotationCharacteristicsOnlyExistsValidator();
	}
}
