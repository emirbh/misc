package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.NonDeliverableSettlement;
import fpml.consolidated.ird.validation.NonDeliverableSettlementTypeFormatValidator;
import fpml.consolidated.ird.validation.NonDeliverableSettlementValidator;
import fpml.consolidated.ird.validation.datarule.NonDeliverableSettlementChoice;
import fpml.consolidated.ird.validation.exists.NonDeliverableSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NonDeliverableSettlement.class)
public class NonDeliverableSettlementMeta implements RosettaMetaData<NonDeliverableSettlement> {

	@Override
	public List<Validator<? super NonDeliverableSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<NonDeliverableSettlement>create(NonDeliverableSettlementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NonDeliverableSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonDeliverableSettlement> validator(ValidatorFactory factory) {
		return factory.<NonDeliverableSettlement>create(NonDeliverableSettlementValidator.class);
	}

	@Override
	public Validator<? super NonDeliverableSettlement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonDeliverableSettlement>create(NonDeliverableSettlementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonDeliverableSettlement> validator() {
		return new NonDeliverableSettlementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonDeliverableSettlement> typeFormatValidator() {
		return new NonDeliverableSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonDeliverableSettlement, Set<String>> onlyExistsValidator() {
		return new NonDeliverableSettlementOnlyExistsValidator();
	}
}
