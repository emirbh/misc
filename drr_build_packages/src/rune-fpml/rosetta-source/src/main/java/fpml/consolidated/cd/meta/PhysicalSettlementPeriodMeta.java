package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.PhysicalSettlementPeriod;
import fpml.consolidated.cd.validation.PhysicalSettlementPeriodTypeFormatValidator;
import fpml.consolidated.cd.validation.PhysicalSettlementPeriodValidator;
import fpml.consolidated.cd.validation.datarule.PhysicalSettlementPeriodChoice;
import fpml.consolidated.cd.validation.exists.PhysicalSettlementPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PhysicalSettlementPeriod.class)
public class PhysicalSettlementPeriodMeta implements RosettaMetaData<PhysicalSettlementPeriod> {

	@Override
	public List<Validator<? super PhysicalSettlementPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PhysicalSettlementPeriod>create(PhysicalSettlementPeriodChoice.class)
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
