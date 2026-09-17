package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.PhysicalSettlementPeriod;
import cdm.product.common.settlement.validation.PhysicalSettlementPeriodTypeFormatValidator;
import cdm.product.common.settlement.validation.PhysicalSettlementPeriodValidator;
import cdm.product.common.settlement.validation.datarule.PhysicalSettlementPeriodBusinessDays;
import cdm.product.common.settlement.validation.datarule.PhysicalSettlementPeriodMaximumBusinessDays;
import cdm.product.common.settlement.validation.datarule.PhysicalSettlementPeriodOneOf2;
import cdm.product.common.settlement.validation.exists.PhysicalSettlementPeriodOnlyExistsValidator;
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
@RosettaMeta(model=PhysicalSettlementPeriod.class)
public class PhysicalSettlementPeriodMeta implements RosettaMetaData<PhysicalSettlementPeriod> {

	@Override
	public List<Validator<? super PhysicalSettlementPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PhysicalSettlementPeriod>create(PhysicalSettlementPeriodOneOf2.class),
			factory.<PhysicalSettlementPeriod>create(PhysicalSettlementPeriodBusinessDays.class),
			factory.<PhysicalSettlementPeriod>create(PhysicalSettlementPeriodMaximumBusinessDays.class)
		);
	}
	
	@Override
	public List<Function<? super PhysicalSettlementPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PhysicalSettlementPeriod> validator(ValidatorFactory factory) {
		return factory.<PhysicalSettlementPeriod>create(PhysicalSettlementPeriodValidator.class);
	}

	@Override
	public Validator<? super PhysicalSettlementPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PhysicalSettlementPeriod>create(PhysicalSettlementPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PhysicalSettlementPeriod> validator() {
		return new PhysicalSettlementPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PhysicalSettlementPeriod> typeFormatValidator() {
		return new PhysicalSettlementPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PhysicalSettlementPeriod, Set<String>> onlyExistsValidator() {
		return new PhysicalSettlementPeriodOnlyExistsValidator();
	}
}
