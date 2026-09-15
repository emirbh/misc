package fpml.consolidated.eqd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eqd.EquityExerciseValuationSettlement;
import fpml.consolidated.eqd.validation.EquityExerciseValuationSettlementTypeFormatValidator;
import fpml.consolidated.eqd.validation.EquityExerciseValuationSettlementValidator;
import fpml.consolidated.eqd.validation.datarule.EquityExerciseValuationSettlementChoice0;
import fpml.consolidated.eqd.validation.datarule.EquityExerciseValuationSettlementChoice1;
import fpml.consolidated.eqd.validation.exists.EquityExerciseValuationSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EquityExerciseValuationSettlement.class)
public class EquityExerciseValuationSettlementMeta implements RosettaMetaData<EquityExerciseValuationSettlement> {

	@Override
	public List<Validator<? super EquityExerciseValuationSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EquityExerciseValuationSettlement>create(EquityExerciseValuationSettlementChoice0.class),
			factory.<EquityExerciseValuationSettlement>create(EquityExerciseValuationSettlementChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super EquityExerciseValuationSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityExerciseValuationSettlement> validator(ValidatorFactory factory) {
		return factory.<EquityExerciseValuationSettlement>create(EquityExerciseValuationSettlementValidator.class);
	}

	@Override
	public Validator<? super EquityExerciseValuationSettlement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityExerciseValuationSettlement>create(EquityExerciseValuationSettlementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityExerciseValuationSettlement> validator() {
		return new EquityExerciseValuationSettlementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityExerciseValuationSettlement> typeFormatValidator() {
		return new EquityExerciseValuationSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityExerciseValuationSettlement, Set<String>> onlyExistsValidator() {
		return new EquityExerciseValuationSettlementOnlyExistsValidator();
	}
}
