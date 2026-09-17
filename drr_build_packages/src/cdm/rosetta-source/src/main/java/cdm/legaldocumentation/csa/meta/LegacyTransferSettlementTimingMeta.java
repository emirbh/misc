package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.LegacyTransferSettlementTiming;
import cdm.legaldocumentation.csa.validation.LegacyTransferSettlementTimingTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.LegacyTransferSettlementTimingValidator;
import cdm.legaldocumentation.csa.validation.datarule.LegacyTransferSettlementTimingOtherValues;
import cdm.legaldocumentation.csa.validation.exists.LegacyTransferSettlementTimingOnlyExistsValidator;
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
@RosettaMeta(model=LegacyTransferSettlementTiming.class)
public class LegacyTransferSettlementTimingMeta implements RosettaMetaData<LegacyTransferSettlementTiming> {

	@Override
	public List<Validator<? super LegacyTransferSettlementTiming>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LegacyTransferSettlementTiming>create(LegacyTransferSettlementTimingOtherValues.class)
		);
	}
	
	@Override
	public List<Function<? super LegacyTransferSettlementTiming, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyTransferSettlementTiming> validator(ValidatorFactory factory) {
		return factory.<LegacyTransferSettlementTiming>create(LegacyTransferSettlementTimingValidator.class);
	}

	@Override
	public Validator<? super LegacyTransferSettlementTiming> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyTransferSettlementTiming>create(LegacyTransferSettlementTimingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyTransferSettlementTiming> validator() {
		return new LegacyTransferSettlementTimingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyTransferSettlementTiming> typeFormatValidator() {
		return new LegacyTransferSettlementTimingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyTransferSettlementTiming, Set<String>> onlyExistsValidator() {
		return new LegacyTransferSettlementTimingOnlyExistsValidator();
	}
}
