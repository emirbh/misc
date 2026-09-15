package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ValuationTradeInformation;
import drr.regulation.common.validation.ValuationTradeInformationTypeFormatValidator;
import drr.regulation.common.validation.ValuationTradeInformationValidator;
import drr.regulation.common.validation.exists.ValuationTradeInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ValuationTradeInformation.class)
public class ValuationTradeInformationMeta implements RosettaMetaData<ValuationTradeInformation> {

	@Override
	public List<Validator<? super ValuationTradeInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationTradeInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationTradeInformation> validator(ValidatorFactory factory) {
		return factory.<ValuationTradeInformation>create(ValuationTradeInformationValidator.class);
	}

	@Override
	public Validator<? super ValuationTradeInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuationTradeInformation>create(ValuationTradeInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuationTradeInformation> validator() {
		return new ValuationTradeInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuationTradeInformation> typeFormatValidator() {
		return new ValuationTradeInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationTradeInformation, Set<String>> onlyExistsValidator() {
		return new ValuationTradeInformationOnlyExistsValidator();
	}
}
